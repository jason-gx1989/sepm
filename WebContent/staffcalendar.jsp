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
	<%
	String result = (String) request.getAttribute("result");
		if (null == result) {
			result = "";
		}
	%>
	<h1><%=result%></h1>
	<p>
		<input id="curYear" type="number" onchange=getShowDayList()
			onblur=getShowDayList() value="2019"> 年 <input id="curMonth"
			type="number" onchange='getShowDayList()' value="3"
			onblur=getShowDayList()> 月
	</p>
	<ul>
		<li class="date-title">星期天</li>
		<li class="date-title">星期一</li>
		<li class="date-title">星期二</li>
		<li class="date-title">星期三</li>
		<li class="date-title">星期四</li>
		<li class="date-title">星期五</li>
		<li class="date-title">星期六</li>
	</ul>
	<ul id="dateListBox"></ul>
</body>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script>
  function getShowDayList() {
    var curYear = parseInt($("#curYear").val());
    var curMonth = parseInt($("#curMonth").val());
    var monthLength = getlengthOfMonth(curYear, curMonth);
    var startDay = getDaysOfMonth(curYear, curMonth, 1); // 获取每月1号是星期几
    var endDay = getDaysOfMonth(curYear, curMonth, monthLength);  // 获取每月最后一天是星期几
    var showDayList = [];
    for (var i = 1; i < (monthLength + 1); i++) {
      if (i === 1) {
        showDayList.push(curMonth + '月' + i + '号（1）');
      } else {
        showDayList.push(i + '号（2）');
      }
    }
    var lastMonth = (curMonth - 1) > 0 ? curMonth - 1: 12;
    var lastMonthLength = getlengthOfMonth((curMonth - 1) > 0 ? curYear : curYear-1, lastMonth);
    if (startDay > 1) {
      for (var i = startDay; i > 0; i--) { 
        if (i === 1) {
          showDayList.unshift(lastMonth + '月' + lastMonthLength + '号（3）');
          // showDayList.unshift('');
        } else{
          showDayList.unshift( lastMonthLength + '号（4）');
          // showDayList.unshift('');s
        }
        lastMonthLength--;
      }
    }
    if (endDay < 6) {
        for (var i = endDay + 1, j = 1; i < 7; i++, j++) {
          if (j===1) {
            showDayList.push(curMonth + 1 +'月1号（5）');
            // showDayList.push('');
          } else {
            showDayList.push( j + '号（6）')
            // showDayList.push('');
          }
        }
      }
      var htmllist = '';
      for (var i = 0; i < showDayList.length; i++) {
        htmllist += '<li class="date-item">'+ showDayList[i] +'</li>';
      }
      $("#dateListBox").empty();
      $("#dateListBox").append(htmllist);
    } 
    function isLeapYear(year) { //判断是否为闰年
      //传入为时间格式需要处理
      if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) return true;
      else return false;
    }
   
    function getlengthOfMonth(year, month) { //获取每月天数
      const monthLengthList = [31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
      return monthLengthList[month - 1];
    }
   
    function getDaysOfMonth(year, month, date) {  // 判断当天是星期几
      const curDay = new Date(year, month - 1, date);
      return curDay.getDay()
    }
   
    getShowDayList();

</script>
</html>