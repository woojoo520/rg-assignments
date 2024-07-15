const express = require('express')
const morgan = require('morgan')
const bodyParser = require('body-parser')

const getTransactionRouter = require("./routes")

const app = express()
app.use(express.urlencoded({ extended: true }));

const transactionRouter = getTransactionRouter(app)
// app.use("/transactions", transactionRouter)
app.listen(3000)