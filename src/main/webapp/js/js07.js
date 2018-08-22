/**
 * 
 */
//fun01();

$(function(){
	
	var date = new Date('2018-04-21');
	var dateNew = new Date();
	console.log(dateNew.setDate(date.getDate() + 1));
	console.log(dateNew);
	console.log(dateNew > date);
	console.log(new Date(date.getDate() - 1));
	console.log(new Date(''));
	
	console.log(date.getFullYear());
	console.log(date.getMonth());
	
	var month = 2;
	if(month in [0, 1, 2]){
		console.log('1');
	}
	
	var myDate = new Date();
	console.log(myDate.toLocaleDateString());
	
	console.log(getQuarter(4));
	
});


function getQuarter(month){
	if(month == 0 || month == 1 || month == 2){
		return 1;
	}
	if(month == 3 || month == 4 || month == 5){
		return 2;
	}
	if(month == 6 || month == 7 || month == 8){
		return 3;
	}
	if(month == 9 || month == 10 || month == 11){
		return 4;
	}
	return null;
}


function callback(parameter){
	
	console.log(parameter);
}