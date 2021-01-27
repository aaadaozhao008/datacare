$(function () {
	var lurl = location.href;
	var number = tmp = fNum = "";
	var ulTotalBuy = $('#ulTotalBuy').eq(0);
	if ($('#Head2_WithdrawCount').val()) {
		number = $('#Head2_WithdrawCount').val() + '';
		startrunnum();
	} else if(lurl.indexOf('.html')>=0){
		$.ajax({
			// 获取id，challenge，success（是否启用failback）
			url: "/ajax.php", // 加随机数防止缓存
			type: "post",
			dataType: "json",
			async: false,
			data: "act=getAllPayG&t=" + (new Date()).getTime(),
			success: function (data) {
				//console.log(data);
				// 使用initGeetest接口
				// 参数1：配置参数
				// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
				if(data.userID>10000){
					location.href="/";
					return true;
				}
				$('#right_top').html(data.righttop);
				$('#token').val(data.token);
				number = data.allPayG + '';
				$('#Head2_WithdrawCount').val(number);
				startrunnum();
			}
		});
	}else{
		return;
	}
	function setAnimate() {
		var citeS = ulTotalBuy.find('.klz_num cite');
		for (var i = 0; i < number.length; i++) {
			var c = citeS.eq(i);
			var top = 0;
			c.find('em').each(function () {
				var that = $(this);
				if (that.attr('t') == number.charAt(i)) {
					top = that.position().top;
					return;
				}
			});
			(function (top, c) {
				window.setTimeout(function () {
					c.animate({ 'top': -top }, { queue: false, duration: 2000 });
				}, (number.length * 200 - i * 200));
			})(top, c);
		}

	}
	//设置数字列表
	function setNumList(tmp) {
		var html = '';
		var tmpS = tmp;
		//var vtop = Math.floor($('#ulTotalBuy li').eq(0).height()*9);
		//$('.klz_number').attr('data-val',vtop);
		for (var i = 0, len = fNum.length; i < len; i++) {
			var s = tmpS.charAt(i);
			if (s === ",") {
				html += '<li class="klz_nobor">,</li>';
			} else {
				html += '<li class="klz_num"><cite style="top:-270px">';
				for (var m = 9; m >= 0; m--) {
					var n = m + parseFloat(s);
					if (n >= 10) {
						n = n - 10;
					}
					html += '<em t="' + n + '">' + n + '</em>'
				}
				html += '</cite></li>';
			}
		}
		ulTotalBuy.html(html);
	}
	//数字格式化
	function formatNum(s) {
		s = parseFloat((s + "").replace(/[^\d\.-]/g, "")) + "";
		var l = s.split("").reverse();
		var t = "";
		for (i = 0; i < l.length; i++) {
			t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
		}
		return t.split("").reverse().join("");
	}
	function startrunnum(){
		tmp = number;
		fNum = formatNum(tmp);
		setNumList((formatNum(1000000000000) + '').slice(-fNum.length));
		setAnimate();
	}
//	function hitsJumps(type,ID){$.ajax({type:"POST",url:"/ajax.php",dataType:"json",data:"act=hitsJump&type="+type+"&ID="+ID+"&key="+Math.random(),success:function(strJson){}})}
//	$('.righttop a').click(function(){hitsJumps('topright',10)});
});