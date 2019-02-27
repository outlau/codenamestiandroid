const { wrap } = require("async-middleware");

const SoundsController = require("../controllers/sounds");

module.exports = router => {
  router.get("/sounds", wrap(SoundsController.getAllSounds));
  router.get("/sounds/:file", wrap(SoundsController.getSound));
  router.get("/sti", wrap(SoundsController.getSti));
};
