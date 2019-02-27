var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

const result = require('dotenv').config();
if (result.error) {
  console.log(result.error)
}
console.log(result.parsed);


var app = express();


const apiRouter = require('./routes/index');

app.use('/', express.static(path.join(__dirname, '../frontend/dist/frontend/')));

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '../frontend/dist/frontend/index.html'));
});
// app.use('/users', usersRouter);

app.use('/api', apiRouter);

// catch 404 and forward to error handler
app.use('/api',function(req, res, next) {
  next(createError(404));
});


module.exports = app;
