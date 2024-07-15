const txnService = require('../services');

async function getTransactions(req, res) {
    const { id } = req.query;
    const val = await txnService.getTransactions(id);
    return res.json(val);
}

async function getSingleTransaction(req, res) {
    const trans = await txnService.getSingleTransaction(req.params.id);
    return res.json(trans);
}

async function createTransaction(req, res) {
    const details = req.body;
    const newId = await txnService.createTransaction(details);
    return res.status(201).json(newId);
}

module.exports = { getTransactions, getSingleTransaction, createTransaction };