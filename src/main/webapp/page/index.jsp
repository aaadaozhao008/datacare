<%@ page contentType="text/html;charset=UTF-8"
	trimDirectiveWhitespaces="true" language="java"%>
<html lang="en">

<head>
<meta charset="gbk">
<!--meta name="viewport" content="width=device-width, initial-scale=1.0"-->
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="/myqq/js/jquery.min.js"></script>
<style>
/* 红字字体rgb(224,36,35) 橙色背景深rgb(255,76,1) */
html {
	width: 100%;
	height: 100%;
}

* {
	margin: 0;
	padding: 0;
}

a {
	color: #333;
	text-decoration: none;
}

ul, li {
	list-style: none;
}

.page {
	width: 100%;
	height: 100%;
	padding: 10px;
	box-sizing: border-box;
}

.pageBox {
	display: flex;
}

.gameStart {
	width: 80%;
	margin-right: 10px;
}

.pageRightBox {
	width: 20%;
}

.gameStart .jc_list_bt {
	display: flex;
	flex-wrap: nowrap;
	width: 100%;
	height: 40px;
	line-height: 40px;
	border: 1px solid #e5e5e5;
	background: rgb(244, 245, 249);
	box-sizing: border-box;
}

.jc_list_bt p {
	/* width: 12.5%; */
	width: 16.6%;
	text-align: center;
}

.gameStart ul {
	display: flex;
	flex-wrap: nowrap;
}

.gameStart ul li {
	/* width: 12.5%; */
	width: 16.6%;
	line-height: 46px;
	text-align: center;
	border-bottom: 1px solid #e5e5e5;
	box-sizing: border-box;
}

.gameStart ul:hover {
	background: #e9ebf3;
}

.gameStart ul #issue a {
	background-color: rgb(253, 101, 100);
	color: #fff;
	padding: 4px 10px;
	border-radius: 4px;
	box-sizing: border-box;
}

.gameStart ul li.kjhm {
	overflow: hidden;
	display: flex;
	flex-wrap: nowrap;
	width: 180px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.gameStart ul li .white_ball {
	display: inline-block;
	width: 22px;
	height: 22px;
	line-height: 22px;
	font-size: 14px;
	border: 1px solid #D6D2CE;
	background-color: #ffffff;
	text-align: center;
	font-weight: bold;
	border-radius: 50%;
	margin: 0 2px;
	color: rgb(253, 101, 100);
}

.gameStart ul li .color_ball {
	display: inline-block;
	width: 22px;
	height: 22px;
	line-height: 22px;
	font-size: 14px;
	border: 1px solid rgb(253, 101, 100);
	color: #ffffff;
	text-align: center;
	font-weight: bold;
	border-radius: 50%;
	margin: 0 2px;
	background-color: rgb(253, 101, 100);
}

.gameStart ul .sr {
	display: flex;
	line-height: 24px;
	flex-direction: column;
}

.gameStart ul li a {
	width: 100%;
	height: 100%;
}

.pageRightBox .small-nav {
	border: 1px solid #e5e5e5;
	padding: 10px;
	border-radius: 4px;
	margin-bottom: 10px;
	box-sizing: border-box;
}

.pageRightBox .small-nav .loginBox {
	display: flex;
	height: 100px;
	margin-bottom: 10px;
}

.pageRightBox .small-nav .login_list p {
	height: 30px;
	line-height: 30px;
	display: flex;
	justify-content: space-between;
}

.pageRightBox .small-nav .login_list p b {
	font-weight: normal;
}

.pageRightBox .small-nav .login_list p b span {
	color: rgb(255, 76, 1);
	margin-right: 4px;
}

.pageRightBox .small-nav .login_img {
	width: 100px;
	height: 100%;
	border-radius: 50%;
	margin-right: 10px;
	background: rgb(244, 245, 249);
}

.pageRightBox .small-nav .login_dec {
	display: flex;
	flex-direction: column;
}

.pageRightBox .small-nav .login_dec p, .pageRightBox .small-nav .login_dec button
	{
	line-height: 30px;
	text-align: center;
}

.pageRightBox .small-nav .login_dec .top-out {
	width: 80px;
	color: #fff;
	border: none;
	outline: none;
	margin-top: 5px;
	border-radius: 4px;
	background-color: rgb(255, 76, 1);
}

.winPlayer {
	width: auto;
}

.winPlayer .tr-bg {
	height: 40px;
	line-height: 40px;
	font-size: 14px;
	border: 1px solid #e5e5e5;
	color: #333;
	display: flex;
	background: rgb(244, 245, 249);
	box-sizing: border-box;
}

.winPlayer .tr-bg li {
	color: #333;
	width: 33.3%;
	text-align: center;
}

.winPlayer #dayRankList ul {
	display: flex;
	border: 1px solid #e5e5e5;
	border-top: none;
	box-sizing: border-box;
}

.winPlayer #dayRankList ul li {
	color: #333;
	width: 33.3%;
	height: 32px;
	line-height: 32px;
	text-align: center;
}

.winPlayer #dayRankList ul:nth-child(even) li {
	background: rgb(244, 245, 249);
}

.winPlayer #dayRankList ul li:last-child {
	color: rgb(224, 36, 35);
}
</style>
<title>急速3星-快乐赚-网赚-数字游戏-玩游戏赚钱-网赚平台</title>
</head>

<body>
	<div class="page">
		<div class="popup_bg"></div>
		<div class="pageBox">
			<div class="gameStart">
				<ul class="jc_list_bt">
					<li class="qh">期号</li>
					<li class="kjsj">挑战时间</li>
					<li class="kjhm">挑战结果</li>
					<li class="chi">挑战乐豆数</li>
					<li class="zjss">完胜人数</li>
					<li class="sr">奖励/参与</li>
					<li class="cy">参与</li>
					<span></span>
				</ul>
				<!-- 	    <ul id="ul1408463" style="position:relative;">
								<li class="qh">1408463</li>
								<li class="kjsj">05-31 00:00</li>
								<li class="kjhm"><span class="ball white_ball">1</span> + <span class="ball white_ball">7</span> + <span class="ball white_ball">4</span> = <span class="ball color_ball">12</span></li>
								<li class="chi">31,163,251,389<span class="ld"></span></li>
								<li class="zjss"><a href="winList.php?fastNO=1408463" style="text-decoration:none;">547</a></li>
								<li class="sr"><p style="margin-top:5px;">奖：<span class="green">0</span></p><p>参：<a href="myDetails.php?fastNO=1408463">7000</a></p></li>
								<li class="cy" id="issue1408463"><a href="winList.php?fastNO=1408463">已结束</a></li>
												</ul> -->
			</div>
			<div class="pageRightBox">
				<!--小导航-->
				<div class="small-nav">
					<div class="width-1200">
						<div class="top-nav-left" id="home">
							<div class="loginBox">
								<div class="login_img">
									<!-- 头像 -->
								</div>
								<div class="login_dec">
									<p id="userName" class="user-name-small">请先登录</p>
									<button id="quit" onclick="quit()" class="top-out">退出</button>
									<button id="login" onclick="login()" class="top-out">登录</button>
								</div>
							</div>
							<div class="login_list">
								<p>
									距离开奖时间还差:<b><span id="getTime"></span>秒</b>
								</p>
								<p>
									我的人民币:<b><span id="getMoney"></span>元</b>
								</p>
								<p>
									今日人民币总盈亏:<b><span id="userTodayMoney"></span>元</b>
								</p>
								<!-- <embed id = "music" src="/myqq/music/123.mp3" hidden=true autostart=true loop="loop"> </embed> -->
							</div>

				<!-- 			<audio id="music" src="/myqq/music/123.mp3" controls="controls"
								autoplay="autoplay" loop="loop" hidden="hidden"></audio> -->
							<audio id="music" ></audio>
						</div>
					</div>
				</div>
				<div>
					<button class="top-out">
						<a href="/myqq/shenshou/shenshou.jsp" class="top-out"
							target="_blank">前往神兽区</a>
					</button>
				</div>
				<div class="winPlayer">
					<ul class="th tr-bg">
						<li class="width-30">排名</li>
						<li class="width-35">会员昵称</li>
						<li class="width-45">今日盈亏</li>
					</ul>
					<div id="dayRankList"></div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//音乐区
	window.onload = function(){
		var arr = ["/myqq/music/123.mp3","/myqq/music/仙侠战斗曲.mp3","/myqq/music/仙侠.mp3"];               //把需要播放的歌曲从后往前排，这里已添加两首音乐，可继续添加多个音乐
		var myAudio = new Audio();
		myAudio.preload = true;
		myAudio.controls = true;
		myAudio.src = arr.pop();         //每次读数组最后一个元素
		myAudio.addEventListener('ended', playEndedHandler, false);
		myAudio.play();
		document.getElementById("music").appendChild(myAudio);
		myAudio.loop = false;//禁止循环，否则无法触发ended事件
		function playEndedHandler(){
			myAudio.src = arr.pop();
			myAudio.play();
			console.log(arr.length);
			!arr.length && myAudio.removeEventListener('ended',playEndedHandler,false);//只有一个元素时解除绑定
		}
	}
		
	
	
	
		function getCookie(cname) {
			var name = cname + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i].trim();
				if (c.indexOf(name) == 0) { return c.substring(name.length, c.length); }
			}
			return "";
		}
		var cookies = document.cookie;
		if (cookies != null) {
			userName = getCookie("userName");
			$('#userName').html(userName);
		}
		function quit() {
			$.ajax({
				type: "POST",
				url: "/myqq/qq/quit",
				dataType: "text",
				success: function (strJson) {
					console.log(strJson);
					$('#userName').html('请先登录');
				}
			});
		}
		function getUser() {
			$.ajax({
				type: "POST",
				url: "/myqq/qq/getUser",
				dataType: "json",
				success: function (strJson) {
					$('#getMoney').html(strJson.money);
					$('#userTodayMoney').html(strJson.userTodayMoney);
				}
			});
		}
		getUser();
		function login() {
			$.ajax({
				type: "POST",
				url: "/myqq/qq/login",
				dataType: "json",
				success: function (strJson) {
					$('#userName').html(strJson.userName);
				}
			});
		}
		var time = 0;
		var isFirst = true;
		function getTime() {
			$.ajax({
				type: "POST",
				url: "/myqq/qq/getTime",
				dataType: "json",
				success: function (strJson) {
					time = strJson;
					$('#getTime').html(strJson);
				}
			});
		}
		getTime();
		function clock() {
			$('#getTime').html(time--);
			if (time <= 0) {
				getTime();
				$('.yiqide').remove();
				$('#dayRankList').empty();
				isFirst = true;
				getData();
			}
		}
		
		function music() {
			  var myAuto = document.getElementById('music');
// 			  myAuto.pause();
			  myAuto.play();
		}
		setInterval(music,272000);//4:12 
		var t = setInterval(clock, 1000);

		getData();
		function getData() {
			$.ajax({
				type: "POST",
				url: "/myqq/qq/getData",
				dataType: "json",
				success: function (strJson) {
					var pours = strJson.person;
					var results = strJson.result;
					var dugous = strJson.dugous;
					if (dugous) {
						$.each(dugous, function (i, obj) {
							var dugouView = "<ul id=\"ul" + next + "\" style=\"position: relative;\">" +
								"<li>" + (i + 1) + "</li>" +
								"<li >" + obj.userName + "</li>" +
								"<li >" + obj.userTodayMoney + "</li>" +
								"</ul>";
							$('#dayRankList').append(dugouView);
						});
					}
					if (JSON.stringify(results) == "{}") {
						var next = 2;
						var ddd =
							"<ul class='yiqide' id=\"ul" + next + "\" style=\"position: relative;\">" +
							"<li class=\"qh\">" + next + "</li>" +
							"<li class=\"kjsj\">-</li>" +
							"<li class=\"kjhm\">-</li>" +
							"<li class=\"chi\">-</li>" +
							"<li class=\"zjss\">-</li>" +
							"<li class=\"sr\">-</li>" +
							"<li class=\"cy\" id=\"issue\"><a href='/myqq/page/pour.jsp?fastNO=" + next + "' target=\"_blank\">待参与</a></li></ul>" +
							"</ul>";
						$('.gameStart').append(ddd);
						next1 = 1;
						ddd = "<ul class='yiqide' id=\"ul" + next1 + "\" style=\"position: relative;\">" +
							"<li class=\"qh\">" + next1 + "</li>" +
							"<li class=\"kjsj\">-</li>" +
							"<li class=\"kjhm\">-</li>" +
							"<li class=\"chi\">-</li>" +
							"<li class=\"zjss\">-</li>" +
							"<li class=\"sr\">-</li>" +
							"<li class=\"cy\" id=\"issue\"><a href='/myqq/page/pour.jsp?fastNO=" + next1 + "' target=\"_blank\">待参与</a></li></ul>" +
							"</ul>";
						$('.gameStart').append(ddd);
						return;
					}
					var fanzhuan = [];
					$.each(results, function (i, obj) {
						fanzhuan[i] = obj;
					});
					results = fanzhuan.reverse();
					$.each(results, function (i, obj) {
						if (isFirst) {
							var next = obj.fastNO + 2;
							var ddd =
								"<ul class='yiqide' id=\"ul" + next + "\" style=\"position: relative;\">" +
								"<li class=\"qh\">" + next + "</li>" +
								"<li class=\"kjsj\">-</li>" +
								"<li class=\"kjhm\">-</li>" +
								"<li class=\"chi\">-</li>" +
								"<li class=\"zjss\">-</li>" +
								"<li class=\"sr\">-</li>" +
								"<li class=\"cy\" id=\"issue\"><a href='/myqq/page/pour.jsp?fastNO=" + next + "' target=\"_blank\">待参与</a></li></ul>" +
								"</ul>";
							$('.gameStart').append(ddd);
							next1 = obj.fastNO + 1;
							ddd = "<ul class='yiqide' id=\"ul" + next1 + "\" style=\"position: relative;\">" +
								"<li class=\"qh\">" + next1 + "</li>" +
								"<li class=\"kjsj\">-</li>" +
								"<li class=\"kjhm\">-</li>" +
								"<li class=\"chi\">-</li>" +
								"<li class=\"zjss\">-</li>" +
								"<li class=\"sr\">-</li>" +
								"<li class=\"cy\" id=\"issue\"><a href='/myqq/page/pour.jsp?fastNO=" + next1 + "' target=\"_blank\">待参与</a></li></ul>" +
								"</ul>";
							$('.gameStart').append(ddd);
							isFirst = false;
						}
						var ccd;
						if (obj) {
							if (pours) {
								var abcd = true;//没找到
								$.each(pours, function (j, pour) {
									if (pour.fastNO == obj.fastNO) {
										ccd = "<li class=\"sr\"><p>奖：<span style=\"color:" + (pour.winMoney - pour.pourMoney > 0 ? 'red' : 'green') + ";\">" + pour.winMoney + "</span></p><p>参:" + pour.pourMoney + "</p></li>"
										abcd = false;
									}
								});
								if (abcd) {
									ccd = "<li class=\"sr\"><p>奖-</p><p> 参:-</p></li>"
								};
							} else {
								ccd = "<li class=\"sr\"><p>奖-</p><p> 参:-</p></li>"
							}
							var bbc;
							if (obj.status) {
								bbc = "<li class=\"kjhm\"><span class=\"ball white_ball\">" + obj.first + "</span> + <span class=\"ball white_ball\">" + obj.second + "</span> + <span class=\"ball white_ball\">" + obj.third + "</span>= <span class=\"ball color_ball\">" + obj.all + "</span></li>";
							} else {
								bbc = "<li class=\"kjhm\"><span class=\"ball white_ball\">-</span> + <span class=\"ball white_ball\">-</span> + <span class=\"ball white_ball\">-</span>= <span class=\"ball color_ball\">-</span></li>"
							}
							var stauts = obj.status ? ">已结束" : "><a href='/myqq/page/pour.jsp?fastNO=" + obj.fastNO + "' target=\"_blank\">待参与</a>"
							var abc = "<ul class='yiqide' id=\"ul" + obj.fastNO + "\" style=\"position: relative;\">" +
								"<li class=\"qh\">" + obj.fastNO + "</li>" +
								"<li class=\"kjsj\">" + obj.date + "</li>" +
								bbc +
								"<li class=\"chi\">" + obj.allMoney + "<span class=\"ld\"></span></li>" +
								"<li class=\"zjss\">664</li>" + ccd +
								"<li class=\"cy\" id=\"issue" + obj.fastNO + "\"" + stauts + "</li>" +
								"</ul>"
							$('.gameStart').append(abc);
						}
					});
				},
				error: function (str) {
					console.log(str);
				}
			});
		}
	</script>
</body>

</html>