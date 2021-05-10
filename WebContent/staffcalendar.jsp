<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>calendar</title>

<style>
* {
	margin: 0px;
	padding: 0px;
}

p {
	margin: 10px;
}

input {
	width: 80px;
	height: 28px;
}

table {
	border: 1px solid #d7E1fb;
	border-collapse: collapse;
	text-align: left
}

th {
	width: 80px;
	padding: 10px;
	background-color: #d7E1fb;
	border: 1px solid #d7E1fb;
}

ul {
	width: 720px;
	margin: 10px;
}

li {
	list-style: none;
}

.date-title {
	float: left;
	width: 80px;
	padding: 10px;
	background-color: #d7E1fb;
	border: 1px solid #d7E1fb;
}

.date-item {
	float: left;
	width: 80px;
	padding: 10px;
	height: 20px;
	border-collapse: collapse;
	border: 1px solid #d7E1fb;
}
</style>
</head>
<body>
	<%-- <%
	String result = (String) request.getAttribute("result");
		if (null == result) {
			result = "";
		}
	%> --%>
	<%-- <input type="hidden" value='<%=result%>' id="dateStr"></input> --%>
	<p>
		<!-- <input id="curYear" type="number" onchange=getShowDayList()
			onblur=getShowDayList() value="2019"> 年 
		<input id="curMonth"type="number" onchange='getShowDayList()' value="3"
			onblur=getShowDayList()> 月 -->

		<input id="curYear" type="number" value="2021">year <input
			id="curMonth" type="number" value="4">month
		<button id="button" οnclick=getShowDayList()>submit</button>
	</p>
	<ul>
		<li class="date-title">Sunday</li>
		<li class="date-title">Monday</li>
		<li class="date-title">Tuesday</li>
		<li class="date-title">Wednesday</li>
		<li class="date-title">Thursday</li>
		<li class="date-title">Friday</li>
		<li class="date-title">Saturday</li>
	</ul>
	<ul id="dateListBox"></ul>
</body>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script>
	$('#button').click(function() {
		getShowDayList();
	});
	function getShowDayList() {

		var dateStr = "111";
		var curYear = parseInt($("#curYear").val());
		var curMonth = parseInt($("#curMonth").val());

		$.ajax({
			url : 'StaffCalendarServlet',
			data : {
				staffId : '222',
				year : curYear,
				month : curMonth
			},
			type : "get",
			success : function(data) {

				dateStr = String(data);
				var monthLength = getlengthOfMonth(curYear, curMonth);
				var startDay = getDaysOfMonth(curYear, curMonth, 1);
				var endDay = getDaysOfMonth(curYear, curMonth, monthLength);
				var showDayList = [];
				for (var i = 1; i < (monthLength + 1); i++) {

					if (dateStr.indexOf("," + String(i) + ",") >= 0) {
						showDayList.push(i + '(allocated)');
					} else {
						showDayList.push(i);
					}

					/*    if (i === 1) {
					   showDayList.push(curMonth + '月' + i + '号');
					   } else {
					  showDayList.push(i + '号');
					  
					 } */
				}
				var lastMonth = (curMonth - 1) > 0 ? curMonth - 1 : 12;
				var lastMonthLength = getlengthOfMonth(
						(curMonth - 1) > 0 ? curYear : curYear - 1, lastMonth);
				if (startDay > 1) {
					for (var i = startDay; i > 0; i--) {
						if (i === 1) {
							showDayList.unshift('');
						} else {
							showDayList.unshift('');
						}
						lastMonthLength--;
					}
				}
				if (endDay < 6) {
					for (var i = endDay + 1, j = 1; i < 7; i++, j++) {
						if (j === 1) {
							showDayList.push('');
						} else {
							showDayList.push('');
						}
					}
				}
				var htmllist = '';
				for (var i = 0; i < showDayList.length; i++) {
					htmllist += '<li class="date-item">' + showDayList[i]
							+ '</li>';
				}
				$("#dateListBox").empty();
				$("#dateListBox").append(htmllist);
			}
		});

	}
	function isLeapYear(year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

	function getlengthOfMonth(year, month) {
		const monthLengthList = [ 31, isLeapYear(year) ? 29 : 28, 31, 30, 31,
				30, 31, 31, 30, 31, 30, 31 ];
		return monthLengthList[month - 1];
	}

	function getDaysOfMonth(year, month, date) {
		const curDay = new Date(year, month - 1, date);
		return curDay.getDay()
	}

	getShowDayList();
</script>
</html>