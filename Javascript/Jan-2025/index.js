const http = require("http");


const server = http.createServer((req, res) => {
    console.log(req.url);

    if (req.url === "/about") {
        res.end("Welcome to the about page");
        return;
    } else if(req.url === "/contact") {
        res.end("Welcome to the contact page");
        return;
    }
    else{ res.end("Hello World! Welcome to Semicolon");}
    c
});


server.listen(3000, 'localhost', () => {
  console.log("Server is running on port 3000");
});