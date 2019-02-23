const { wrap } = require("async-middleware");

const BoyfriendController = require("../controllers/boyfriend");

module.exports = router => {
  router.get("/boyfriend", wrap(BoyfriendController.get));
};
