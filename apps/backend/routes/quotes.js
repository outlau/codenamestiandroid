const { wrap } = require("async-middleware");

const QuotesController = require("../controllers/quotes");

module.exports = router => {
  router.get("/quotes", wrap(QuotesController.get));
};
