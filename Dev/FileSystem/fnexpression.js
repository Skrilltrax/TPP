let { exec } = require("child_process");

let greeter = function sayHi() {
  console.log("Hi");
};

greeter();

let newName = greeter();

function lib(number) {
  for (let div = 2; div * div <= number; div++) {
    if (number % div == 0) {
      return false;
    }
  }
  return true;
}

let ans = lib(21);

if (ans) {
  console.log("isPrime");
} else {
  console.log("notPrime");
}

function framework(data, scb, fcb) {
  for (let div = 2; div * div <= data; div++) {
    if (data % div == 0) {
      fcb();
      return;
    }
  }
  scb();
}

function succ() {
  console.log("Number is prime");
  exec("calc");
}

function fail() {
  console.log("Number is not prime");
  exec("start chrome");
}

framework(3, succ, fail);
