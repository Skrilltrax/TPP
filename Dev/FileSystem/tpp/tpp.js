let cmd = process.argv[2];
let { view } = require("./commands/view");
let { treefy } = require("./commands/treefy");
let { untreefy } = require("./commands/untreefy");
let { help } = require("./commands/help");

switch (cmd) {
  case "view":
    view(process.argv[3], process.argv[4]);
    break;
  case "untreefy":
    untreefy(process.argv[3], process.argv[4]);
    break;
  case "treefy":
    treefy(process.argv[3], process.argv[4]);
    break;
    break;
  case "help":
    help();
    break;
  default:
    console.log("Wrong Command");
}
