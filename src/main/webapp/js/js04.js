/**
 * 
 */

function person(firstName, lastName, favorite, say){
	this.firstName = firstName;
	this.lastName = lastName;
	this.favorite = favorite;
	say(this.firstName, this.favorite);	
}

function say(name, favorite){
	console.log("my name: " + name);
	console.log("my favorite: " + favorite);
	
};

var father = new person("father first name","father last name", "lemon", say);
var father = new person("son first name","son last name", "fruit", say);

var x = "ddd\reeef";
var y = "dddeeef";
console.log(x);
console.log(y);
console.log(x == y);
console.log(y.substring(2,4));
console.log(y.substr(2,4));