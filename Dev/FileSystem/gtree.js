let root = {
  data: "d10",
  children: [
    {
      data: "d20",
      children: [
        {
          data: "d50",
          children: [],
        },
        {
          data: "d60",
          children: [],
        },
      ],
    },
    {
      data: "d30",
      children: [
        {
          data: "d70",
          children: [],
        },
      ],
    },
    {
      data: "d40",
      children: [
        { 
            data: "d80", 
            children: [] 
        },
        {
          data: "d90",
          children: [],
        },
      ],
    },
  ],
};


function viewGTree(node) {
  let str = "" + node.data + " => ";
  for (let i = 0; i < node.children.length; i++) {
    str += node.children[i].data + ", ";
  }

  console.log(str);

  for (let i = 0; i < node.children.length; i++) {
    viewGTree(node.children[i]);
  }
}

viewGTree(root);
