var checkReservable = (function () {

    var $reservationBtn = $('.bk_btn_wrap');
    var $agree = $('.chk_agree');

    function checkAll() {

        if (_checkUserInfo() && _checkTicket() && _checkAgreement()) {
            $reservationBtn.removeClass('disable');
        } else {
            $reservationBtn.addClass('disable');
        }

    }

    function _checkAgreement() {

        if ($agree.is(':checked')) {
            return true;
        } else {
            return false;
        }

    }

    function _checkTicket() {

        if ($('.individual_price.on_color').length > 0) {
            return true;
        } else {
            //alert("티켓을 선택해 주세요.");
            return false;
        }

    }

    function _checkUserInfo() {

        if(_checkTel() && _checkUsername() && _checkEmail()) return true;
        return false;

    }

    function _checkTel(){

        var tel = $('input[name="tel"]').val();

        if (tel === "") return false;

        if (tel.length === 11 || tel.length === 10) {
            var re = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
            if (!re.test(tel)) return false;
        }
        else {
            return false;
        }
        return true;

    }

    function _checkUsername(){

        var username = $('input[name="name"]').val();

        if (username === "") {
            return false;
        }
        return true;

    }

    function _checkEmail(){

        var email = $('input[name="email"]').val();

        if (email !== "") {
            var reEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            if (!reEmail.test(email)) {
                //alert("이메일을 확인해 주세요.");
                return false;
            }
        }
        return true;

    }

    return {
        checkAll : checkAll
    }

})();

