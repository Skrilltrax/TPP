let request = require("request");
let fs = require("fs");
let cheerio = require("cheerio");

console.log("Before");

request('https://www.espncricinfo.com/series/19322/commentary/1187683', function (error, response, body) {
    if (error === null && response.statusCode == 200) {
        parseHTML(body);
    } else if (request.statusCode == 400) {
        console.log("Invalid Url")
    } else {
        console.log(err);
    }
});

function parseHTML(html) {
    let $ = cheerio.load(html);
    let itemWrapper = $('.item-wrapper .description');
    let commentary = $(itemWrapper[0]).text();

    console.log(commentary);
}
console.log("after");
