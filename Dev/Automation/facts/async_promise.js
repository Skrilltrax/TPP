let fs = require("fs");

console.log("Before");
console.log("Start");

let fileWillBeReadPromise = fs.promises.readFile("f1.html");

console.log("After");

fileWillBeReadPromise.then(function(content){
    console.log(content+" ");
    console.log("Finish");
})

fileWillBeReadPromise.catch(function(content){
    console.log(err);
})