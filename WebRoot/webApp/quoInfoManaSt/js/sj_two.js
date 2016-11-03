var this_year = 2015;
$(function() {
	var year = year();
	var month = month();
});
function year(){
	var year= "<div id='select_year'>";
	for(var i = 0; i < 50; i++){
		year = year + "<div class='year' year="+(2015+i)+"></div>";
	}
	year = year + "</div>";
	return year;
}
function month() {
	var month = "<div id='select_month'>";
	for(var i = 0; i < 12; i++){
		month = month + "<div class='month' month="+(i+1)+" >"+i+1+"</div>";
	}
	month = "</div>";
	return month;
}
function day(month,year) {
	var d = 31;
	if(month%2 == 0){
		if(month == 2){
			if(year%4 == 0){
				d = 29;
			}else{
				d = 28;
			}
		}else{
			d = 30;
		}
	}
	var day = "<div id='select_day'>";
	for(var i = 0; i < (d+1); i++){
		day = day + "<div class='day' day="+(i+1)+" >";
	}
	day = "</div>";
}
