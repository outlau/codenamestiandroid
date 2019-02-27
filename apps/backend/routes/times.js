const { wrap } = require("async-middleware");

const TimerController = require("../controllers/timer");

module.exports = router => {
  router.get("/times", wrap(TimerController.get));
};
