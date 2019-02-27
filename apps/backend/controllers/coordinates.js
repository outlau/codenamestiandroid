// const APIError = require('../errors/api-error');
const dbInterface = require('../db/db-interface');

module.exports = {
  getAll: async (req, res) => {
    const coordinates = await dbInterface.getCoordinates();
    res.send(coordinates);
  },
};
