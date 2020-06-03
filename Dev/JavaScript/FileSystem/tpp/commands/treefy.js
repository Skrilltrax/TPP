const fs = require("fs");
const path = require("path");

module.exports.treefy = function (src, dest) {
  let rd = fs.readFileSync("structure.json");
  let tree = JSON.parse(rd);
  //console.log(tree);
  construct(tree, src, dest);
};

function construct(node, src, dest) {
  let isfile = node.isfile;
  if (isfile) {
    let filename = node.newname;
    fs.copyFileSync(path.join(src, filename), path.join(dest, node.name));
  } else {
    // let name = node.name;
    // fs.mkdirSync(dest , name);
    let ndest = path.join(dest, node.name);
    let children = node.children;
    for (let i = 0; i < children.length; i++) {
      let child = children[i];
      construct(child, src, ndest);
    }
  }
}
