<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Map<String, Double> weeklyWorkload = (HashMap<String, Double>) request.getAttribute("weeklyWorkload");
Map<String, Double> monthlyWorkload = (HashMap<String, Double>) request.getAttribute("monthlyWorkload");

Gson gson = new Gson();
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

for (Map.Entry<String, Double> entry : weeklyWorkload.entrySet()) {
	Map<Object,Object> map = new HashMap<Object,Object>();
	map.put("label", entry.getKey());
	map.put("y", entry.getValue());
	list.add(map);
}

String weeklyData = gson.toJson(list);

gson = new Gson();
list = new ArrayList<Map<Object,Object>>();

for (Map.Entry<String, Double> entry : monthlyWorkload.entrySet()) {
	Map<Object,Object> map = new HashMap<Object,Object>();
	map.put("label", entry.getKey());
	map.put("y", entry.getValue());
	list.add(map);
}
 
String monthlyData = gson.toJson(list);
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
	var weeklyChart = new CanvasJS.Chart("weeklyChart", {
		theme: "light2",
		title: {
			text: "Staff Workload"
		},
		subtitles: [{
			text: "Current Week"
		}],
		axisY: {
			title: "Working Hours"
		},
		data: [{
			type: "bar",
			indexLabel: "{y}",
			indexLabelFontColor: "#444",
			indexLabelPlacement: "inside",
			dataPoints: <%out.print(weeklyData);%>
		}]
	});
	weeklyChart.render();
	
	var monthlyChart = new CanvasJS.Chart("monthlyChart", {
		theme: "light2",
		title: {
			text: "Staff Workload"
		},
		subtitles: [{
			text: "Current Month"
		}],
		axisY: {
			title: "Working Hours"
		},
		data: [{
			type: "bar",
			indexLabel: "{y}",
			indexLabelFontColor: "#444",
			indexLabelPlacement: "inside",
			dataPoints: <%out.print(monthlyData);%>
		}]
	});
	monthlyChart.render();
}
</script>
</head>
<body>
<br>
<br>
<div id="weeklyChart" style="height: 370px; width: 100%;"></div>
<br>
<br>
<div id="monthlyChart" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>                              