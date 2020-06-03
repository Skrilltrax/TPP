let request = require("request");
let fs = require("fs");
let cheerio = require("cheerio");

request('https://www.espncricinfo.com/series/19322/scorecard/1187683', function (error, response, body) {
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
    let bowlers = $(".scorecard-section.bowling table tbody tr");

    let name = "";
    let wickets = 0;

    for (let i = 0; i < bowlers.length; i++) {
        let bRow =  $(bowlers[i]).find("td")
        let bName = $(bRow[0]).text();
        let bWick = $(bRow[5]).text();

        if (bWick > wickets) {
            wickets = bWick;
            name = bName;
        }

        console.log(bName + " " + bWick);
    }

    console.log();
    console.log(name + " " + wickets);
}
