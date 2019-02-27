const { wrap } = require("async-middleware");

const CoordinatesController = require("../controllers/coordinates");

module.exports = router => {
  router.get("/coordinates", wrap(CoordinatesController.getAll));
};
