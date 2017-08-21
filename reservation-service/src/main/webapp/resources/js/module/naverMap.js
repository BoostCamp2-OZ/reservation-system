$(function() {
    var myaddress = $('.store_addr_bold').text();

    naver.maps.Service.geocode({
        address: myaddress
    }, function (status, response) {

        if (status !== naver.maps.Service.Status.OK) {
            return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
        }

        var result = response.result;
        var myaddr = result.items[0].point.x + "," + result.items[0].point.y;
        var placeName = $('.store_addr.addr_detail').text();

        $('.store_map.img_thumb').attr('src', "https://openapi.naver.com/v1/map/staticmap.bin?clientId=cYcPk9usu3TaN83mu0va&url=http://127.0.0.1:8080/&crs=EPSG:4326&center=" + myaddr + "&level=10&w=340&h=150&baselayer=default&markers=" + myaddr);
        //네이버 지도로 이동설정...
        $('.store_location').attr('href', 'http://map.naver.com/?lng=' + result.items[0].point.x + '&pinTitle=' + placeName + '&level=2&pinType=SITE&lat=' + result.items[0].point.y + '&enc=utf8;');
    });
});