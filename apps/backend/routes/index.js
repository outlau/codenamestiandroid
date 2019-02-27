const fs = require("fs");
const express = require("express");
const router = express.Router();

const routeGroups = fs.readdirSync(__dirname).filter(fn => fn !== "index.js");
routeGroups.forEach(routeFile => {
  const enableRoutes = require(`./${routeFile}`);
  enableRoutes(router);
});

module.exports = router;
