const { wrap } = require("async-middleware");

const PicturesController = require("../controllers/pictures");

module.exports = router => {
  router.get("/pictures", wrap(PicturesController.getAll));
  router.get("/pictures/:file", wrap(PicturesController.get));
};
