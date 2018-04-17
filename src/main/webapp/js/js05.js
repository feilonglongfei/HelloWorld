/**
 * 
 */
//fun01();

$(function(){
	
	for(var i=0; i<3; i++){
		$.ajax({url:"E:/workspace/HelloWorld/src/main/webapp/jsDemo.html",
			success:successCallback(i),
	        async:false
		});
	};
	
	
	function successCallback(parameter){
		return function(result){
			console.log("callback success:" + parameter);
		}
	}
	
	console.log("after ajax");
});