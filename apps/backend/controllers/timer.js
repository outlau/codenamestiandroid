// const APIError = require('../errors/api-error');
const dbInterface = require("../db/db-interface");

module.exports = {
  get: async (req, res) => {
    const times = await dbInterface.getTimes();
    res.send(times);
  }
};
