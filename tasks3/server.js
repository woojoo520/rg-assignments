const http = require('http');
const displayTransactions = require("./readFiles");

// TODO 1: In the below line, replace '' with code to import/require transactions data from './data/transactions.json'
(
  async () => {
    // since 'await' expressions are only allowed within async functions and at the top levels of modules, we just show how to call this function here.
    const transactions = await displayTransactions();
  }
)

const server = http.createServer(async (req, res) => {
  if (req.url === '/') {
    // TODO 2: Implement response for '/' endpoint with proper HTTP status and 'Content-Type' using res.writeHead()
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello PayPal');
  }
  else if (req.url === '/transactions') {
    // TODO 3: Implement response for '/transactions' endpoint with JSON data and proper headers
    try {
      const transaction = await displayTransactions();
      if (!transaction) throw new Error("Transaction data not available!");

      res.writeHead(200, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify(transaction));
    } catch (error) {
      console.error("Error fetching transactions: ", error)
      res.writeHead(500, { 'Content-Type': 'text/plain' });
      res.end("Internal Server Error");
    }

  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('404 Not Found');
  }
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
