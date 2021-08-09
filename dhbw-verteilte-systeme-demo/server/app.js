var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const swaggerUi = require('swagger-ui-express');
var swaggerDocument = require('./swagger.json');
const cors = require("cors")

var indexRouter = require('./routes/index');
var taskRouter = require('./routes/tasks');
var subjectRouter = require('./routes/subjects');

var app = express();

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use(cors())

app.use('/', indexRouter);
app.use('/api', taskRouter);
app.use('/api', subjectRouter);

module.exports = app;
