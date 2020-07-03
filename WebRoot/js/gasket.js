$(document).ready(function(){
	$("#Gasket_Search").click(function(){
		var gasketvalue = $("#gasket_value").val();
		if(gasketvalue==""){
			alert("请输入要查找的型号");
		}else{
			$.post("SearchServlet",{
				Action:"GasketSearch",
				Values:gasketvalue
			},function(data,status){
				if(data=="null"){
					alert("没有查到这个型号哦！");
				}else{
					var gasketbean = JSON.parse(data);
					$("#data_content").append("<div class='append_content' ><strong>公称规格(螺纹大径d):</strong>&nbsp;&nbsp;"+gasketbean.name+"<br>"+
							"<strong>d1(内径):</strong>&nbsp;&nbsp;"+gasketbean.d1_nominal_min+"(公称min)"+gasketbean.d1_max+"(max)<br>"+
							"<strong>d2(外径):</strong>&nbsp;&nbsp;"+gasketbean.d2_nominal_max+"(公称max)&nbsp;&nbsp;"+gasketbean.d2_min+"(min)<br>"+
							"<strong>h:</strong>&nbsp;&nbsp;"+gasketbean.h_nominal+"(公称)&nbsp;&nbsp;"+gasketbean.h_max+"(max)"+gasketbean.h_min+"(min)<br></div><br><br>");
				}
			})
		}
	});
});