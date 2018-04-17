/**
 * 
 */

/*products : [
	{"folder":"folder1", "images":[{"image":"image1"},{"image":"image2"}]},
	{"folder":"folder2", "images":[{"image":"image1"},{"image":"image2"}]}
]*/

var json = '[{"folder":"folder1","images":[{"image":"image1"},{"image":"image2"}]},{"folder":"folder2","images":[{"image":"image1"},{"image":"image2"}]}]';
//alert(json);

var jsonObj = JSON.parse(json);
//alert(jsonObj);
for (var i = 0; i < jsonObj.length; i++) {
	for (var j = 0; j < jsonObj[i].images.length; j++) {
		alert(jsonObj[i].images[j].image);
	}
}



var jsonString = JSON.stringify(jsonObj);
alert(jsonString);


