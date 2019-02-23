// const APIError = require('../errors/api-error');
const fs = require("fs");
const path = require("path");

module.exports = {
  get: async (req, res) => {
    const file = path.join(__dirname, `../assets/boyfriend.zip`);
    const stat = fs.statSync(file);
    res.writeHead(200, {
      "Content-Type": "application/zip",
      "Content-Length": stat.size
    });

    const readStream = fs.createReadStream(file);
    readStream.pipe(res);
  },
};
