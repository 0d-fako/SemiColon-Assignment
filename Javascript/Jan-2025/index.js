const http = require("http");


const server = http.createServer((req, res) => {
    res.end("Hello World! Welcome to WeJapa Internships");
});


server.listen(3000, 'localhost', () => {
  console.log("Server is running on port 3000");
});