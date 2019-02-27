const fs = require("fs");
const path = require("path");
const moment = require("moment");

const dbInterface = require("../db/db-interface");

const sendFile = (req, res, file) => {
  const stat = fs.statSync(file);
  res.writeHead(200, {
    "Content-Type": "audio/wav",
    "Content-Length": stat.size
  });

  const readStream = fs.createReadStream(file);
  readStream.pipe(res);
};

module.exports = {
  getAllSounds: async (req, res) => {
    const filePath = path.join(__dirname, "../assets/sounds/");

    fs.readdir(filePath, (err, items) => {
      res.send(items);
    });
  },

  getSound: async (req, res) => {
    const file = path.join(__dirname, `../assets/sounds/${req.params.file}`);
    sendFile(req, res, file);
  },

  getSti: async (req, res) => {
    const [sti] = await dbInterface.getSti();
    const dirPath = path.join(__dirname, "../assets/stis/");
    const now = new Date();
    const lastChecked = new Date(sti.datetime);

    if (moment(lastChecked).isBefore(now, "day")) {
      const obj = {
        id: sti.id,
        datetime: now
      };
      fs.readdir(dirPath, (err, items) => {
        const nameId = items.findIndex(i => i === sti.name);
        let name;
        if(nameId < 0){
          name = items[0];
        } else {
          name = items[(nameId + 1) % items.length];
        }
        obj.name = name;
        console.log(obj);
        dbInterface.updateSti(obj).then(() => {
          sendFile(req, res, dirPath+obj.name);
        });
      });
    } else {
      sendFile(req, res, dirPath+sti.name);
    }
  }
};
