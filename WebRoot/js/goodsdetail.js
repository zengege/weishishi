window.onload = function(){
	
    var pic_left = document.getElementById("pre");
    var pic_list = document.getElementById("pro_gallerys");
    var pic_list_box = document.getElementById("pic_list");
    var pic_right = document.getElementById("next");
    var li_pic = pic_list.getElementsByTagName("li");
    
    
    
    pic_left.onclick=function(){
    	pic_list.style.marginLeft='-75px';
    }
    pic_right.onclick=function(){
    	pic_list.style.marginLeft='0px';
    }
    
    
    var pro_quantity = document.getElementById("pro_quantity");
    var pro_quantity_plus = document.getElementById("pro_quantity_plus");
    var pro_quantity_minus = document.getElementById("pro_quantity_minus");
     pro_quantity_plus.onclick = function(){
     	pro_quantity.value=parseInt(pro_quantity.value)+1;
     }
     pro_quantity_minus.onclick = function(){
     	if(parseInt(pro_quantity.value)==1){
     		pro_quantity.value=2;
     	}
     	pro_quantity.value=parseInt(pro_quantity.value)-1;
     	
     }
     
      var color_name = document.getElementsByClassName("color_name");
     
     var color_phone = document.getElementsByClassName("color_phone");
     
     
     
     var edition_phone = document.getElementsByClassName("edition_phone");
     var kind_phone    = document.getElementsByClassName("kind_phone");
    
     var color_ = document.getElementById("color_");
     var edition_ = document.getElementById("edition_");
     
     var taocan_ = document.getElementById("taocan_");
     var edition_name = document.getElementsByClassName("edition_name");
     var  pro_1 = document.getElementById("pro_1");
     var  pro_2 = document.getElementById("pro_2");
     var pro_edition = document.getElementById("pro_edition");
     var pro_color = document.getElementById("pro_color");
     
     for(var i = 0 ;i<color_phone.length;i++ ){
     	color_phone[i].onclick=function(){
     		
     		for(var i = 0;i<color_phone.length;i++){
     			color_phone[i].className="color_phone";
     			color_.innerHTML=$(this).children("span").eq(0).text();
     			pro_1.innerHTML=$(this).children("span").eq(0).text();
     			pro_color.innerHTML=$(this).children("span").eq(0).text();
     		}
     		
     		this.className="color_phone active_kind";

     	}
     	
     }
     
     for(var i = 0 ;i<edition_phone.length;i++ ){
     	edition_phone[i].onclick=function(){
     		
     		for(var i = 0;i<edition_phone.length;i++){
     			edition_phone[i].className="edition_phone";
     		
     			edition_.innerHTML=$(this).children("a").eq(0).text();
     			
     			pro_2.innerHTML=$(this).children("a").eq(0).text();
     			
     			pro_edition.innerHTML=$(this).children("a").eq(0).text();
     		}
     		
     		this.className="edition_phone active_kind";

     	}
     	
     }
     
      for(var i = 0 ;i<kind_phone.length;i++ ){
     	kind_phone[i].onclick=function(){
     		
     		for(var i = 0;i<kind_phone.length;i++){
     			kind_phone[i].className="kind_phone";
     			taocan_.innerHTML=$(this).children("a").eq(0).text();
     			
     			
     		}
     		
     		this.className="kind_phone active_kind";

     	}
     	
     }
     
     
     var cancel = document.getElementById("cancel");
     var hidden_gouwu = document.getElementById("hidden_gouwu");
     var product_button01 = document.getElementById("product_button01");
     var not_jiesuan = document.getElementById("not_jiesuan");
     not_jiesuan.onclick=function(){
     	hidden_gouwu.style.display="none";
     	
     }
     product_button01.onclick=function(){
     	hidden_gouwu.style.display="block";
     	
     }
     cancel.onclick=function(){
     	hidden_gouwu.style.display="none";
     	
     }
     
     
     
     var pro_gallerys = document.getElementById("pro_gallerys");
     var pro_gallerys_li = pro_gallerys.getElementsByTagName("li");
     for(var i = 0; i < pro_gallerys_li.length; i++) {
		pro_gallerys_li[i].index = i;
		pro_gallerys_li[i].onmousemove = function() {
			for(var i = 0; i < pro_gallerys_li.length; i++) {
				pro_gallerys_li[i].className = "";
				
			}
			this.className = "current";
			
		}
	}
     
     
     
}