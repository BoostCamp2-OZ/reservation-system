<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="/resources/css/style.css" rel="stylesheet">
    <script src="//code.jquery.com/jquery.min.js"></script>
</head>

<body>
    <div id="container">
		<!-- [D] 예약하기로 들어오면 header에 fade 클래스 추가로 숨김 -->
		<jsp:include page="common/header.jsp"/>
        <div class="ct">
            <div class="wrap_review_list">
                <div class="review_header">
                    <div class="top_title gr">
                        <a href="#" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
                        <h2><a class="title" href="#">오디컴퍼니 주식회사</a></h2>
                    </div>
                </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area"> <span class="graph_mask"> <em class="graph_value" style="width: 88%;"></em> </span> <strong class="text_value"> <span>${avgScore}</span> <em class="total">5.0</em> </strong> <span class="join_count"><em class="green">${count}건</em> 등록</span>                                </div>
                            <ul class="list_short_review">
                            	<!-- handlebars -->
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                </div>
            </div>
        </div>
        <hr> </div>
		<footer>
	        <div class="gototop">
	            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
	        </div>
	        <div id="footer" class="footer">
	            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
	            <span class="copyright">© NAVER Corp.</span>
	        </div>
	    </footer>
	    
	    

      	
<!--  Handlebar -->
<script src="/resources/js/node_modules/handlebars/dist/handlebars.min.js"></script>

<!-- Jquery -->
<script src="/resources/js/node_modules/jquery/dist/jquery.min.js"></script>

<!-- moment -->
<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>



<script id="review-content" type="text/x-handlebars-template">

{{# items}}
	    <li class="list_item">
	        <div>
	            <div class="review_area">
					{{#if firstImageSaveFileName}}
					<div class="thumb_area">
                    	<a href="#" class="thumb" title="이미지 크게 보기"> 
							<img width="90" height="90" class="img_vertical_top" src="/img/{{firstImageSaveFileName}}" alt="리뷰이미지"> 
						</a> 
						<span class="img_count">{{imageCount}}</span>
                     </div>
					{{/if}}
	                <h4 class="resoc_name">${productName}</h4>
	                <p class="review">{{comment}}</p>
	            </div>
	            <div class="info_area">
	                <div class="review_info"> <span class="grade">{{score}}</span> <span class="name">{{nickname}}</span> <span class="date">{{timeStamp createDate}} 방문</span> </div>
	            </div>
	        </div>
      	</li>
{{/items}}
</script>	

<script>


Handlebars.registerHelper("timeStamp", function(timestamp) {
	  if (moment) {
	    // can use other formats like 'lll' too
	    return  moment(timestamp).format("YYYY.DD.MM");
	  }
	  else {
	    return datetime;
	  }
});


var amount = 10,
start = 0;

var templateSource = $("#review-content").html(),
Template = Handlebars.compile(templateSource);

$(".graph_value").css("width",('${avgScore}' * 20)+"%");

$.ajax({
	method : "get",
	url : "/api/comment/"+'${productId}'+"?start="+start+"&amount="+amount
}).done(function(data){
	if(data.length ===0){
		
	}else{
		var item = {
				items : []
		};
		console.log(data);
		for(var i =0, max = data.length; i<max; ++i){
			item.items.push(data[i]);
		}
		//expectationLength += max ;
		var html = Template(item);
		var $card = $(".list_short_review");
		$card.append(html);
		start +=10;
	}
});

$(document).scroll(function(){
	 if ($(window).scrollTop() >= $(document).height() - $(window).height()) {
		 $.ajax({
				method : "get",
				url : "/api/comment/"+'${productId}'+"?start="+start+"&amount="+amount
			}).done(function(data){
				if(data.length ===0){
					
				}else{
					var item = {
							items : []
					};
					console.log(data);
					for(var i =0, max = data.length; i<max; ++i){
						item.items.push(data[i]);
					}
					//expectationLength += max ;
					var html = Template(item);
					var $card = $(".list_short_review");
					$card.append(html);
					start +=10;
				}
				
			});
	 }
});

</script>
</body>

</html>
