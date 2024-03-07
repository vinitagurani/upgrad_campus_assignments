//-----------------------1.concatenate different arrays-------------------------
function concat(...args) {
	let arr1=[...args]
	let arr=[]
	for (let i=0;i<arr1.length;i++){
		arr.push(...arr1[i])
	}
	return  arr;
}
//------------------------2.add a suffix to a word----------------------------
function add_suffix(suffix) {
	return (x) => {
		return x+suffix;
	}
}
//-------------------------3.Your task is to create a Circle constructor that creates a circle with a radius provided by an argument. The circles constructed must have two methods getArea() (PI*r^2) 
//and getPerimeter() (2*PI*r) which give both respective areas and perimeter (circumference)-----------------------------------
class Circle {
	constructor(radius) {
		this.radius = radius;
	}
	getArea() {return (PI*this.radius*this.radius);}
	getPerimeter() {return (2*PI*this.radius);}
}
//------------------------4. print the table------------------------------------------------
function arrayOfMultiples (num, length) {
	let arr = [];
	for (let i = 1;i<= length;i++) {
		arr.push(i*num);
	}
	return arr;
}
//----------------------5.sort the array-----------------------------------------------------
function sort () {
  const sortIt = a => a.sort((a,b)=> a - b);
}
