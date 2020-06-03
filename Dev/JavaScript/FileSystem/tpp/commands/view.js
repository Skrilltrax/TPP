let fs = require("fs");
var path = require("path");


module.exports.view = function () {

    let src = arguments[1];

    let mode = arguments[0];
    if (mode == "-t") {
        viewAsTree(src);
    } else if (mode == "-f") {
        viewAsFlatFiles(src);
    } else {
        viewAsTree(src, "")
    }
};

function viewAsTree() {
    console.log("Implemented");
}

function childReader(src) {
    let childrens = fs.readdirSync(src);
    return childrens;
}

function viewAsFlatFiles(src) {
    let isFile = !fs.lstatSync(src).isDirectory();
    
    if (isFile == true) {
      console.log(src + "*");
    } else {
      console.log(src);

      let childrens =childReader(src);

      for (let i = 0; i < childrens.length; i++) {
        let child = childrens[i];
        let childPath = path.join(src, child);
        viewAsFlatFiles(childPath);
      }
    }
}

function viewAsTree(src, indent){
    if(fs.readdirSync == 0){
        return 0;
    }

    let isFile = !fs.lstatSync(src).isDirectory();

    if(isFile){
        console.log(indent+path.basename(src)+"*")
    }else{
        console.log(indent+path.basename(src));
        let children = fs.readdirSync(src);

        for (let i =0; i<children.length; i++){
            let childPath = path.join(src, children[i]);
            viewAsTree(childPath, indent + "\t");
        }
    }
}
  