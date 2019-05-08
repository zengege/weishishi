window.onload=function(){

	var selcted_address1 = document.getElementById("selcted_address1");
	var option_select = selcted_address1.getElementsByTagName("option");
	var ensure_addresstip = document.getElementById("ensure_addresstip");
	selcted_address1.onblur = function(){
		for(var i = 0;i<option_select.length;i++){
			if(option_select[i].selected){
				ensure_addresstip.style.display="none";
			}else{
					ensure_addresstip.style.display="inline-block";
			}
			
			
		}
		
	}
//	
	var username = document.getElementById("username");
	var usernametip = document.getElementById("usernametip");
	username.onblur = function(){
		var value1 = username.value;
		
		if(value1==""){
			usernametip.style.display="inline-block";
			return false
		}else{
			usernametip.style.display="none";
			return true;
		}
	}
	
	
	
	var telephone = document.getElementById("telephone");
	var telephonetip = document.getElementById("telephonetip");
	var reg = /^0?1[3|4|5|7|8][0-9]\d{8}$/;
	telephone.onblur = function(){
		var value1 = telephone.value;
		
		if(!reg.test(value1)){
			telephonetip.style.display="inline-block";
			return false
		}else{
			telephonetip.style.display="none";
			return true;
		}
	}
	
	var detail_address = document.getElementById("detail_address");
	var detail_addresstip = document.getElementById("detail_addresstip");
	detail_address.onblur = function(){
		var value1 = detail_address.value;
		
		if(value1==""){
			detail_addresstip.style.display="inline-block";
			return false
		}else{
			detail_addresstip.style.display="none";
			return true;
		}
	}
	var add_new = document.getElementById("add_new");
	add_new.onclick=function checkall(){
	if(username.value!=""&&reg.test(telephone.value)&&detail_address.value!=""){
        	alert("信息填写成功");
        	document.getElementById("myform").submit();
        }else{

        	alert("信息填写失败或为空");
        }
	}
//	function checkall(form){
//		if(username.value!=""&&reg.test(telephone.value)&&detail_address.value!=""){
//			alert("登入成功");
//			retur true;
//		}else{
//			alert("填写失败");
//			retur false;
//		}
//	}
  

	
}
