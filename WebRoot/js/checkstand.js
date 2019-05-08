window.onload = function() {

	
	var oder_detail_2 = document.getElementById("oder_detail_2");
	var detail_2 = document.getElementById("detail_2");

	oder_detail_2.onclick = function() {
		if(detail_2.style.display == "block") {
			detail_2.style.display = "none"
		} else {
			detail_2.style.display = "block";
		}

	}

    
	var payTab = document.getElementById("payTab");
	var paylis = payTab.getElementsByTagName("li");
	var pay_kind_div = document.getElementById("pay_kind_div");
	var div_kinds = pay_kind_div.getElementsByTagName("div");
	for(var i = 0; i < paylis.length; i++) {
		paylis[i].index = i;
		paylis[i].onclick = function() {
			for(var i = 0; i < paylis.length; i++) {
				paylis[i].className = "";
				div_kinds[i].style.display = "none";
			}
			this.className = "active";
			div_kinds[this.index].style.display = "block";
		}
	}

	var pay_kind_div = document.getElementById("pay_kind_div");
	
	var pay_a_lis = pay_kind_div.getElementsByTagName("li");

	var selected = document.getElementsByClassName("selected");

	for(var i = 0; i < pay_a_lis.length; i++) {

		pay_a_lis[i].index=i;
		pay_a_lis[i].onclick = function() {
			for(var i = 0; i < pay_a_lis.length; i++) {
				selected[i].style.display="none";
				pay_a_lis[i].className = "dengdai_li";
			}
			this.className = "active_li";
			selected[this.index].style.display="block";
			
		}

	}
////	var selected_1 = document.getElementsByClassName("selected_1");
//	
//	for(var i = 0; i < pay_b_lis.length; i++) {
//		pay_b_lis[i].index=i;
//		pay_b_lis[i].onclick = function() {
//			for(var i = 0; i < pay_b_lis.length; i++) {
////				selected_1[i].style.display="none";
//				pay_b_lis[i].className = "dengdai_li";
//			}
//			this.className = "active_li";
////			selected_1[this.index].style.display="block";
//		}
//
//	}
//	
////	var selected_2 = document.getElementsByClassName("selected_2");
//	
//	for(var i = 0; i < pay_c_lis.length; i++) {
//		pay_c_lis[i].index=i;
//		pay_c_lis[i].onclick = function() {
//			for(var i = 0; i < pay_c_lis.length; i++) {
////				selected_2[i].style.display="none";
//				pay_c_lis[i].className = "dengdai_li";
//			}
//			this.className = "active_li";
////			selected_2[this.index].style.display="block";
//		}
//
//	}
////	var selected_3 = document.getElementsByClassName("selected_3");
//	
//	for(var i = 0; i < pay_d_lis.length; i++) {
//		pay_d_lis[i].index=i;
//		pay_d_lis[i].onclick = function() {
//			for(var i = 0; i < pay_d_lis.length; i++) {
////				selected_3[i].style.display="none";
//				pay_d_lis[i].className = "dengdai_li";
//			}
//			this.className = "active_li";
////			selected_3[this.index].style.display="block";
//		}
//
//	}
//	

	
	
	
}
	var time_now_server, time_now_client, time_end, time_server_client, timerID;

		time_end = new Date("2010/10/5 10:10:1"); //结束的时间
		time_end = time_end.getTime();

		time_now_server = new Date("2010/10/04 10:10:1"); //开始的时间
		time_now_server = time_now_server.getTime();

		time_now_client = new Date();
		time_now_client = time_now_client.getTime();

		time_server_client = time_now_server - time_now_client;

		setTimeout("show_time()", 1000);

		function show_time() {
			var timer = document.getElementById("timer");
			if(!timer) {
				return;
			}
			timer.innerHTML = time_server_client;

			var time_now, time_distance, str_time;
			var int_day, int_hour, int_minute, int_second;
			var time_now = new Date();
			time_now = time_now.getTime() + time_server_client;
			time_distance = time_end - time_now;
			if(time_distance > 0) {
				int_day = Math.floor(time_distance / 86400000)
				time_distance -= int_day * 86400000;
				int_hour = Math.floor(time_distance / 3600000)
				time_distance -= int_hour * 3600000;
				int_minute = Math.floor(time_distance / 60000)
				time_distance -= int_minute * 60000;
				int_second = Math.floor(time_distance / 1000)

				if(int_hour < 10)
					int_hour = "0" + int_hour;
				if(int_minute < 10)
					int_minute = "0" + int_minute;
				if(int_second < 10)
					int_second = "0" + int_second;
				str_time = int_day + "天" + int_hour + "小时" + int_minute + "分钟" + int_second + "秒";
				timer.innerHTML = str_time;
				setTimeout("show_time()", 1000);
			} else {
				timer.innerHTML = timer.innerHTML;
				clearTimeout(timerID)
			}
		}
	