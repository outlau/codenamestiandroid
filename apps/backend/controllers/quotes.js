// const APIError = require('../errors/api-error');
const dbInterface = require('../db/db-interface');

module.exports = {
  get: async (req, res) => {
    const [quote] = await dbInterface.getQuote();
    res.send(quote);
  },
};
