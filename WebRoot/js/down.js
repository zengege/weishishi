function go(a){
			var x = document.querySelectorAll('.cang');
			x[a].style.display = "block";
				
			
		}
		function leave(a){
			var x = document.querySelectorAll('.cang');
			
					x[a].style.display="none";
		}
		function show(a){
			var x = document.querySelectorAll('.xixi');
			for (var i=0;i<3;i++) {
				x[i].style.display = "none";
			}
			x[a].style.display ="block";
		}