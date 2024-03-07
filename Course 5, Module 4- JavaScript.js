//-----------------1. Print odd numbers till n-------------------------------
let print = (n) => {
  for (let i = 0; i <=n;i++) {
    if (i%2 == 0) {
      continue;
  }
  console.log (i);
}
}
//----------------2. return the first element of the array---------------------
function getFirstValue(arr) {
	return arr[0];
}
//--------------3. The function returns a function that returns a string------------------
function redundant(str) {
	let str1 = () => {
		return str.toString();
	}
	return str1;
}
//--------------4. return a function that takes an argument------------------------
function makePlusFunction(baseNum) {
	return (x) => {
		return x+baseNum;
	}
}
//----------------5. Create a function that takes a number as an argument, increments the number by +1 and returns the result.------------------------------
function addition(num) {
	return num+1;
}
//-----------------6.object to array--------------------------------------------------
function toArray(obj) {
	return Object.entries(obj);
}
