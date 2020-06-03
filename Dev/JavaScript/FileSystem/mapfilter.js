let arr = [4, 14, 17, 23, 48, 66]

function mapFun(num) {
    if (num % 2 == 0) return num + 1
    else return num - 1;
}

let mArr = arr.map(mapFun)
console.log(mArr);

function isPrime(number) {
    for (let div = 2; div * div <= number; div++) {
      if (number % div == 0) {
        return false;
      }
    }
    return true;
}

function filterFun(num) {
    return isPrime(num);
}

let fArr = arr.filter(filterFun);
console.log(fArr);

Array.prototype.mymap = function(callback) {
    let newArr = [];
    for (let i = 0; i < this.length; i++) {
        let tmp = callback(this[i]);
        newArr.push(tmp);
      }
    
      return newArr;
}

Array.prototype.myfilter = function(callback) {
    let newArr = [];
    for (let i = 0; i < this.length; i++) {
        if(callback(this[i])) newArr.push(this[i]);
      }
    
      return newArr;
}

function squarer(num) {
    return num * num;
}

let mmArr = arr.mymap(mapFun)
console.log(mArr);

let mfArr = arr.myfilter(filterFun);
console.log(fArr);