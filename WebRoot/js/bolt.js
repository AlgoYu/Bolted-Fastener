$(document).ready(function(){
	$("#bolt_search").click(function(){
		var boltvalue = $("#bolt_value").val();
		if(boltvalue==""){
			alert("请输入要查找的型号");
		}else{
			$.post("SearchServlet",{
				Action:"BoltSearch",
				Values:boltvalue
			},function(data,status){
				if(data=="null"){
					alert("没有查到这个型号哦！");
				}else{
					var boltbean = JSON.parse(data);
					$("#data_content").append("<div class='append_content' ><strong>螺纹规格d:</strong>&nbsp;&nbsp;"+boltbean.name+"<br>"+
							"<strong>pa:</strong>&nbsp;&nbsp;"+boltbean.p_a+"<br>"+
							"<strong>b(参考):</strong>&nbsp;&nbsp;"+boltbean.b_b+"(b)&nbsp;&nbsp;"+boltbean.b_c+"(c)&nbsp;&nbsp;"+boltbean.b_d+"(d)<br>"+
							"<strong>c(max):</strong>&nbsp;&nbsp;"+boltbean.c_max+"<br>"+
							"<strong>da(max):</strong>&nbsp;&nbsp;"+boltbean.d_a_max+"<br>"+
							"<strong>ds:</strong>&nbsp;&nbsp;"+boltbean.d_s_max+"(max)&nbsp;&nbsp;"+boltbean.d_s_min+"(min)<br>"+
							"<strong>dw(min):</strong>&nbsp;&nbsp;"+boltbean.d_w_min+"<br>"+
							"<strong>e(min):</strong>&nbsp;&nbsp;"+boltbean.e_min+"<br>"+
							"<strong>k:</strong>&nbsp;&nbsp;"+boltbean.k_nominal+"(公称)&nbsp;&nbsp;"+boltbean.k_max+"(max)&nbsp;&nbsp;"+boltbean.k_min+"(min)<br>"+
							"<strong>kwe(min):</strong>&nbsp;&nbsp;"+boltbean.k_w_e_min+"<br>"+
							"<strong>r(min):</strong>&nbsp;&nbsp;"+boltbean.r_min+"<br>"+
							"<strong>s:</strong>&nbsp;&nbsp;"+boltbean.s_nominal_max+"(公称=max)"+boltbean.s_min+"(min)<br>"+
							"<strong>l:</strong>&nbsp;&nbsp;"+boltbean.ls_lg+"</div><br><br>");
				}
			})
		}
	});
});