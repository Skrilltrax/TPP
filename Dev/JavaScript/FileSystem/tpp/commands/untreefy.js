let fs = require("fs");
let path = require("path");
let id = require("uniqid");

module.exports.untreefy = async function (src, dest) {
  let tree = await copy(src, dest);
  let jsoncontent = JSON.stringify(tree);
  fs.writeFile("structure.json", jsoncontent, "utf8", function (err) {
    if (err) {
      console.log("An error occured while writing JSON Object to File.");
      return console.log(err);
    }

    console.log("JSON file has been saved.");
  });
};
function copy(src, dest) {
  let isfile = fs.lstatSync(src).isFile();
  if (isfile) {
    let rname = id();

    dest = path.join(dest, rname);
    fs.copyFileSync(src, dest);
    let node = {
      isfile: true,
      name: path.basename(src),
      newname: rname,
    };
    return node;
  } else {
    let children = fs.readdirSync(src);
    let node = {
      isfile: false,
      name: path.basename(src),
      children: [],
    };
    for (let i = 0; i < children.length; i++) {
      let child = children[i];
      let childpath = path.join(src, child);
      let childd = copy(childpath, dest);
      node.children.push(childd);
    }

    return node;
  }
}
