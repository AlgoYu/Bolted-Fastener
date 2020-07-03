$(document).ready(function(){
	$("#Nut_Search").click(function(){
		var nutvalue = $("#nut_value").val();
		if(nutvalue==""){
			alert("请输入要查找的型号");
		}else{
			$.post("SearchServlet",{
				Action:"NutSearch",
				Values:nutvalue
			},function(data,status){
				if(data=="null"){
					alert("没有查到这个型号哦！");
				}else{
					var nutbean = JSON.parse(data);
					$("#data_content").append("<div class='append_content' ><strong>螺纹规格D:</strong>&nbsp;&nbsp;"+nutbean.name+"<br>"+
							"<strong>pa:</strong>&nbsp;&nbsp;"+nutbean.p_a+"<br>"+
							"<strong>c:</strong>&nbsp;&nbsp;"+nutbean.c_max+"(max)&nbsp;&nbsp;"+nutbean.c_min+"(min)<br>"+
							"<strong>da:</strong>&nbsp;&nbsp;"+nutbean.d_a_max+"(max)&nbsp;&nbsp;"+nutbean.d_a_min+"(min)<br>"+
							"<strong>dw(min):</strong>&nbsp;&nbsp;"+nutbean.d_w_min+"<br>"+
							"<strong>e(min):</strong>&nbsp;&nbsp;"+nutbean.e_min+"<br>"+
							"<strong>m:</strong>&nbsp;&nbsp;"+nutbean.m_max+"(max)&nbsp;&nbsp;"+nutbean.m_min+"(min)<br>"+
							"<strong>mw(min):</strong>&nbsp;&nbsp;"+nutbean.m_w_min+"<br>"+
							"<strong>s:</strong>&nbsp;&nbsp;"+nutbean.s_nominal_max+"(公称=max)&nbsp;&nbsp;"+nutbean.s_min+"(min)</div><br><br>");
				}
			})
		}
	});
});