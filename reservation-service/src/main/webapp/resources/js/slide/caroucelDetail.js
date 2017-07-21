// slide 와 관련된 부분  [Caroucel]

// 클릭만 동작하는 부분 + touch 
	
function CaroucelTouch($ul,$point){
	this.$point = $point;
	this.$ul = $ul;
	this.current_length = 0;
	if($point){
		this.currentPoint = Number($point.text());
	}
	
	this.start_x = 0;
	this.save_a = 0;
	this.move_dx = 0;
	this.touchstartEvent = function(event){};
	this.touchendEvent = function(event){};
	this.touchmoveEvent = function(event){};
	
	this.caroucelLeftClick = function(){
		if(this.leftClick()){
			 this.save_a -= this.setting.imgLength;	
			this.$point.text(--this.currentPoint);
			return true;
		}
		return false;
	};
	
	this.caroucelRightClick = function(){
		if(this.rightClick()){
			 this.save_a += this.setting.imgLength;
			this.$point.text(++this.currentPoint);
			return true;
		}
		return false;
	};
	
	this.touchstartEvent = function(event){
		this.start_x =event.originalEvent.changedTouches[0].screenX;
	}
 	

	this.touchendEvent = function(){
	     if(this.move_dx >50 ){
			 this.caroucelLeftClick()
		 }else if(this.move_dx < -50 ){
			 this.caroucelRightClick()
		 }
	     // 움직인 만큼 반대로 돌림 
	     this.$ul.animate({"right": "+="+this.move_dx }, 0);	 
		// 다시 초기화 	     
	     this.move_x = 0,
	     this.move_dx = 0;
	};
	
	this.touchmoveEvent = function(event){
		this.move_dx = event.originalEvent.changedTouches[0].screenX-this.start_x;
		this.$ul.animate({"right": this.save_a-this.move_dx},0);
	};
	
}




function CaroucelPopup($ul,$point){
	this.$point = $point;
	this.$ul = $ul;
	this.currentPoint = Number($point.text());
	this.current_length = 0;
	templateSource = $("#layer-content").html(),
	leftTemplate = Handlebars.compile(templateSource);
	
	this.getLayerImg = function(data) {
		if (data.length === 0) {
			alert("없는 이미지 ");
		}else{
			main ='html',
			Items = {
				items : []
			}
			for (var i = 0, max = data.length; i < max; ++i) {
				Items.items.push(data[i]);
			}
			main = leftTemplate(Items);
			this.$ul.append(main);
		}
	};
};

CaroucelTouch.prototype = new Caroucel();
CaroucelTouch.prototype.constructor = CaroucelTouch;

CaroucelPopup.prototype = new CaroucelTouch();
CaroucelPopup.prototype.constructor = CaroucelPopup;



var CarocelDetail = (function(){
	var touch = {};
	var caroucel = new Caroucel();
	return{
		init : function(touch){
			var $ul = touch.$ul;
			var $pre =  $ul.parents(".group_visual").find(".prev_inn");
			var $nxt =  $ul.parents(".group_visual").find(".nxt_inn");
			
			touch.setInit(414);
			$ul.on("touchend",touch.touchendEvent.bind(touch)); 
			$ul.on("touchstart",touch.touchstartEvent.bind(touch)); 
			$ul.on("touchmove",touch.touchmoveEvent.bind(touch)); 
			
			$pre.on("click",touch.caroucelLeftClick.bind(touch));
			$nxt.on("click",touch.caroucelRightClick.bind(touch));
		},
		destroy : function($ul){
			var $pre =  $ul.parents(".group_visual").find(".prev_inn");
			var $nxt =  $ul.parents(".group_visual").find(".nxt_inn");
			
			$ul.off("touchstart");
			$ul.off("touchend");
			$ul.off("touchmove");
			$ul.animate({"right": 0}, 0);
			$pre.off("click");
			$nxt.off("click");
			
		}
	}
})();


/*
	var Carouceldetail = (function(){
		var $point = $(".num:first"),
		currentPoint = Number($point.text());
		var caroucel = new Caroucel(),
		touch_start_x = 0,
		save_x = 0,
		move_dx = 0,
		touchstartEvent = function(event){},
		touchendEvent = function(event){},
		touchmoveEvent = function(event){};
		
		
		touchstartEvent = function(event){
			touch_start_x =event.originalEvent.changedTouches[0].screenX;
		}
	 	
	
		touchendEvent = function(event){
			// 버블링 막기 
			
		     if(move_dx >50 ){
				 if(Carouceldetail.caroucelLeftClick()){
					 save_x -= caroucel.setting.imgLength;	 
				 }
			 }else if(move_dx < -50 ){
				 if(Carouceldetail.caroucelRightClick()){
					 save_x += caroucel.setting.imgLength;
				 }
			 }
		     // 움직인 만큼 반대로 돌림 
		     caroucel.$ul.animate({"right": "+="+move_dx }, "fast");	  
			// 다시 초기화 	     
			move_x = 0,
			move_dx = 0;
			event.preventDefault();
		};
		
	
		touchmoveEvent = function(event){
			event.preventDefault();
			move_dx = event.originalEvent.changedTouches[0].screenX-touch_start_x;
			caroucel.$ul.animate({"right": save_x-move_dx},0);
		};
		
		
		
		return {
				init : function($ul,size){
					caroucel.setUl($ul);
					caroucel.setWidth(size);
				},
				caroucelLeftClick : function leftClickEvent(){
					if(caroucel.leftClick()){
						$point.text(--currentPoint);
						return true;
					}
					return false;
				},
				
				caroucelRightClick : function rightClickEvent(){
					if(caroucel.rightClick()){
						$point.text(++currentPoint);
						return true;
					}
					return false;
				}
				,
				touchEvent : function(){
					caroucel.$ul.on("touchstart",touchstartEvent); 
					caroucel.$ul.on("touchend",touchendEvent); 
					caroucel.$ul.on("touchmove",touchmoveEvent);
				}
		}
		
	})();
*/