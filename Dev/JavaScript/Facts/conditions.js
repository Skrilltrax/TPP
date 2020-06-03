const fs = require("fs")

fs.readFile("./files/file1.txt", function (err, data) {
    console.log("File 1 Size : " + data.byteLength);
    if (data.byteLength > 20) {
        fs.readFile("./files/file2.txt", function (err, data) {
            console.log("File 2 Size : " + data.byteLength);
            if (data.byteLength > 40) {
                fs.readFile("./files/file6.txt", function (err, data) {
                    console.log("File 6 Size : " + data.byteLength);
                })
            }
            else {
                fs.readFile("./files/file7.txt", function (err, data) {
                    console.log("File 7 Size : " + data.byteLength);
                })
            }
        })
    }
    else {
        fs.readFile("./files/file3.txt", function (err, data) {
            console.log("File 3 Size : " + data.byteLength);
            if (data.byteLength > 30) {
                fs.readFile("./files/file4.txt", function (err, data) {
                    console.log("File 4 Size : " + data.byteLength);
                })
            }
            else {
                fs.readFile("./files/file5.txt", function (err, data) {
                    console.log("File 5 Size : " + data.byteLength);
                })
            }
        })
    }
})