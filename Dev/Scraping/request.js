let request = require("request");
let fs = require("fs");

console.log("Before");

request('http://www.google.com', function (error, response, body) {
    if (error === null && response.statusCode == 200) {
        fs.writeFileSync("index.html", body);
    }
});

console.log("after");
