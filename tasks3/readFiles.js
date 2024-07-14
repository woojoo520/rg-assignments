const fs = require('fs').promises;
const path = require('path');

async function displayTransactions() {
  try {
    // TODO: Read 'transactions.json' file using fs.readFile or fs.readFile with async/await
    
    // resolve filepath
    const fp = path.resolve('./data/transactions.json');

    // read file content 
    const data = await fs.readFile(fp, 'utf8');

    // transform string to json format
    const transactions = JSON.parse(data);
  
    // console.log(transactions);
    return transactions;

  } catch (error) {
    // TODO: Handle errors that occur during file reading or JSON parsing
    console.error("Error while reading or parsing transaction.json", error);
    return null;
  }
}

displayTransactions();
module.exports = displayTransactions;