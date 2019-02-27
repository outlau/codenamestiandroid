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
  getAll: async (req, res) => {
    const filePath = path.join(__dirname, "../assets/pictures/");

    fs.readdir(filePath, (err, items) => {
      res.send(items);
    });
  },

  get: async (req, res) => {
    const file = path.join(__dirname, `../assets/pictures/${req.params.file}`);
    sendFile(req, res, file);
  }
};
