/**
 * 
 */

	function Ticket($qty,price){
		this.$qty = $qty;
		this.$text = $qty.find(".count_control_input[type = tel]");
		this.$total_price = $qty.find(".total_price");
		this.total_price =parseInt(this.$total_price.text());
		this.price = parseInt($qty.find(".price").text().replace(/[^\d]+/g,''));
		this.count = 0;
	}		
	
	//Ticket.prototype = new	eg.Component();		
	Ticket.prototype.constructor =	Ticket;	
	
	Ticket.prototype.totalCount = 0;

	Ticket.prototype.changeTotal = function(){
		$(".tickat_count").text(this.totalCount);
	}
	
	Ticket.prototype.minus = function(){
		--this.count;
		// 이렇게 안하고 this.~ 으로 하면 객체 내부에 totalCount를 선언해버림 
		--Ticket.prototype.totalCount
		this.$text.val(this.count);
		this.$total_price.text(this.total_price-=this.price);
		if(this.count ===0){
			this.$qty.find(".ico_minus3").addClass("disabled");
		}
		this.changeTotal();
	};	
	
	Ticket.prototype.plus = function(){	
		Ticket.prototype.totalCount++
		++this.count
		this.$text.val(this.count);
		this.$total_price.text(this.total_price+=this.price);
		if(this.count !==0){
			this.$qty.find(".ico_minus3").removeClass("disabled");
		}
		this.changeTotal();
	};	
	
	var TicketModule = (function(){
		return {
			init: function(){
				
			}
		}
	})();
