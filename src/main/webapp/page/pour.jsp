<%@ page contentType="text/html;charset=UTF-8"
	trimDirectiveWhitespaces="true" language="java"%>
<html lang="en">

<head>
	<meta charset="gbk">
	<!--meta name="viewport" content="width=device-width, initial-scale=1.0"-->
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<script src="/myqq/js/jquery.min.js"></script>
	<script src="/myqq/js/jcshare.js"></script>
	<script src="/myqq/js/jc28.js"></script>
	<title>急速3星-快乐赚-网赚-数字游戏-玩游戏赚钱-网赚平台</title>
</head>

<body>
	<!-- 红色字体、背景rgb(253,101,100) 橙色字体rgb(255, 165, 83) 灰色字体rgb(102, 102, 102)-->
	<style>
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

		ul li {
			list-style: none;
		}

		.pour_box {
			width: 70%;
			height: auto;
			border: 1px solid #e5e5e5;
			padding: 10px;
			box-sizing: border-box;
			color: #333;
		}

		.pour_header {
			display: flex;
		}

		.pour_header .edit_nav_left {
			width: 50%;
			margin-right: 10px;
			box-sizing: border-box;
		}

		.edit_nav_left .model_tab {
			display: flex;
		}

		.edit_nav_left .model_tab a {
			width: 50%;
			display: inline-block;
			height: 40px;
			line-height: 40px;
			text-align: center;
			color: #333;
			background-color: rgb(242, 242, 242);
			border-radius: 4px;
			box-sizing: border-box;
		}

		.edit_nav_left .model_tab a.active {
			color: #fff;
			background-color: rgb(253, 101, 100);
		}

		.model_box .js_model_b {
			display: flex;
			flex-direction: column;
		}

		.model_box .js_model_b .bigsmall_box {
			width: 100%;
			display: flex;
			margin: 10px 0;
			box-sizing: border-box;
		}

		.model_box .js_model_b .bigsmall_box a {
			width: 50%;
			border: 1px solid #e5e5e5;
			border-radius: 4px;
			height: 60px;
			line-height: 60px;
			display: inline-block;
			font-size: 18px;
			font-weight: bold;
			color: rgb(255, 165, 83);
			text-align: center;
			box-sizing: border-box;
		}

		.model_box .js_model_b .bigsmall_box a span {
			font-size: 12px;
			font-weight: normal;
			color: rgb(102, 102, 102);
		}

		.model_box .js_model_b .jiou_box {
			width: 100%;
			height: 60px;
			display: flex;
			flex-wrap: nowrap;
		}

		.model_box .js_model_b .jiou_box a {
			width: 25%;
			margin-right: 10px;
			border: 1px solid #e5e5e5;
			border-radius: 4px;
			display: block;
			font-size: 16px;
			font-weight: bold;
			color: rgb(253, 101, 100);
			text-align: center;
			padding-top: 6px;
			box-sizing: border-box;
		}

		.model_box .js_model_b .jiou_box a:last-child {
			margin-right: 0;
		}

		.model_box .js_model_b .jiou_box a span {
			line-height: 30px;
			padding-top: 0;
			font-size: 12px;
			font-weight: normal;
			color: rgb(102, 102, 102);
		}

		.pour_header .edit_nav_right {
			width: 50%;
		}

		.edit_nav_right>p {
			width: 100%;
			color: #fff;
			height: 40px;
			line-height: 40px;
			border-radius: 4px;
			text-align: center;
			background-color: rgb(253, 101, 100);
		}

		.edit_nav_right .diy_model_box {
			padding: 10px;
			padding-bottom: 60px;
			display: flex;
			flex-wrap: wrap;
			box-sizing: border-box;
			background-color: rgb(242, 242, 242);
		}

		.diy_model_box a {
			display: inline-block;
			width: 18%;
			height: 26px;
			line-height: 26px;
			font-size: 12px;
			color: rgb(253, 101, 100);
			margin-right: 4px;
			margin-bottom: 10px;
			text-align: center;
			border: 1px solid rgb(253, 101, 100);
			border-radius: 4px;
			box-sizing: border-box;
		}

		.double_box {
			display: flex;
			margin: 10px 0;
			justify-content: space-between;
			padding: 0 10px;
			height: 40px;
			line-height: 40px;
			border: 1px solid #e5e5e5;
			border-radius: 4px;
			font-size: 12px;
			box-sizing: border-box;
		}

		.double_box .double_box_left a {
			padding: 4px 6px;
			border-radius: 4px;
			text-align: center;
			font-size: 10px;
			border: 1px solid #e5e5e5;
			box-sizing: border-box;
		}

		.double_box .double_box_left .ld {
			color: rgb(253, 101, 100);
			background-color: rgb(253, 101, 100);
		}

		.double_box .edit_top {
			display: flex;
		}

		.double_box .edit_top .bet_sure_btn {
			margin: 6px 4px;
			padding: 0 10px;
			border: none;
			border-radius: 4px;
			outline: none;
			color: #fff;
			background-color: rgb(253, 101, 100);
		}

		.double_box .edit_top .topSele_box a {
			padding: 4px 6px;
			border-radius: 4px;
			text-align: center;
			font-size: 12px;
			border: 1px solid #e5e5e5;
			box-sizing: border-box;
		}

		.jc_list_box .bj_con {
			display: flex;
			margin-right: 10px;
			box-sizing: border-box;
		}

		.bj_con .column {
			width: 33.3%;
			display: flex;
			flex-direction: column;
		}

		.jc_bj_item {
			display: flex;
			padding: 10px;
			font-size: 12px;
			border-radius: 4px;
			margin-right: 10px;
			margin-bottom: 10px;
			border: 1px solid #e5e5e5;
			box-sizing: border-box;
		}

		.jc_bj_item .ball {
			display: inline-block;
			width: 50px;
			height: 50px;
			line-height: 50px;
			font-size: 20px;
			margin-right: 10px;
			border-radius: 50%;
			color: #fff;
			text-align: center;
			background-color: rgb(253, 101, 100);
		}

		.jc_bj_item .chi {
			display: flex;
			flex-direction: column;
		}
		.chi >input{
			width: 80px;
		}
		.chi>span{
			line-height: 24px;
		}

		.jc_bj_item .fan {
			display: flex;
			flex-direction: column;
			margin-left: 10px;
		}

		.jc_bj_item .fan>p,
		.jc_bj_item .fan>div {
			line-height: 24px;
		}
		.jc_bj_item .fan .beishu{
			display: none;
		}
		.edit_bottom{
			height: 100%;
			margin-right: 10px;
			text-align: center;
		}
		.edit_bottom p{
			font-size: 16px;
			line-height: 40px;
			margin-top: 6%;
		}
		.edit_bottom p span{
			font-size: 20px;
			color: rgb(253, 101, 100);
		}
		.edit_bottom .bet_sure_btn{
			text-align: center;
			width: 100%;
			height: 40px;
			line-height: 40px;
			color: #fff;
			font-size: 20px;
			border: none;
			outline: none;
			border-radius: 4px;
			background-color: rgb(253, 101, 100);
		}
		.column3 .jc_bj_item{
			margin-right: 0;
		}
	</style>
	<div class="pour_box">
		<div class="pour_header">
			<div class="edit_nav_left">
				<div class="model_tab">
					<a href="/myqq/page/index.jsp" class="tab_b js_tab_btn active">主页</a> <a href="javascript:;"
					<a href="javascript:;" class="tab_b js_tab_btn active">基本模式</a> <a href="javascript:;"
						class="tab_a js_tab_btn">大神模式</a>
				</div>
				<div class="model_box">
					<div class="js_model_b">
						<div class="bigsmall_box">
							<a href="javascript:;" onClick="useModel(9)">压大<span>（14到27）</span></a>
							<a href="javascript:;" onClick="useModel(10)">压小<span>（0到13）</span></a></div>
						<div class="jiou_box">
							<a href="javascript:;" onClick="useModel(1)">单<br><span>（奇数1,3..27）</span></a>
							<a href="javascript:;" onClick="useModel(5)">双<br><span>（偶数2,4...26）</span></a>
							<a href="javascript:;" onClick="useModel(11)">中<br><span>（从10到17）</span></a>
							<a href="javascript:;" onClick="useModel(12)">边<br><span>（0到9,18到27）</span></a>
						</div>
					</div>
					<div class="js_model_a" style="display: none;">
						<a href="javascript:;" onClick="useModel(0)">全选</a> <a href="javascript:;"
							onClick="useModel(1)">单</a>
						<a href="javascript:;" onClick="useModel(2)">大单</a> <a href="javascript:;"
							onClick="useModel(3)">小单</a>
						<a href="javascript:;" onClick="useModel(4)">单边</a> <a href="javascript:;"
							onClick="useModel(5)">双</a>
						<a href="javascript:;" onClick="useModel(6)">大双</a> <a href="javascript:;"
							onClick="useModel(7)">小双</a>
						<a href="javascript:;" onClick="useModel(8)">双边</a> <a href="javascript:;"
							onClick="useModel(9)">大</a>
						<a href="javascript:;" onClick="useModel(10)">小</a> <a href="javascript:;"
							onClick="useModel(11)">中</a>
						<a href="javascript:;" onClick="useModel(12)">边</a> <a href="javascript:;"
							onClick="useModel(13)">大边</a>
						<a href="javascript:;" onClick="useModel(14)">小边</a> <a href="javascript:;"
							onClick="useModel(22)">0尾</a> <a href="javascript:;" onClick="useModel(15)">1尾</a> <a
							href="javascript:;" onClick="useModel(16)">2尾</a> <a href="javascript:;"
							onClick="useModel(17)">3尾</a> <a href="javascript:;" onClick="useModel(19)">4尾</a> <a
							href="javascript:;" onClick="useModel(18)">小尾</a> <a href="javascript:;"
							onClick="useModel(20)">5尾</a> <a href="javascript:;" onClick="useModel(21)">6尾</a> <a
							href="javascript:;" onClick="useModel(23)">7尾</a> <a href="javascript:;"
							onClick="useModel(24)">8尾</a> <a href="javascript:;" onClick="useModel(25)">9尾</a> <a
							href="javascript:;" onClick="useModel(26)">大尾</a> <a href="javascript:;"
							onClick="useModel(27)">3余0</a> <a href="javascript:;" onClick="useModel(28)">3余1</a> <a
							href="javascript:;" onClick="useModel(29)">3余2</a> <a href="javascript:;"
							onClick="useModel(30)">4余0</a> <a href="javascript:;" onClick="useModel(31)">4余1</a> <a
							href="javascript:;" onClick="useModel(32)">4余2</a> <a href="javascript:;"
							onClick="useModel(33)">4余3</a> <a href="javascript:;" onClick="useModel(34)">5余0</a> <a
							href="javascript:;" onClick="useModel(35)">5余1</a> <a href="javascript:;"
							onClick="useModel(36)">5余2</a> <a href="javascript:;" onClick="useModel(37)">5余3</a> <a
							href="javascript:;" onClick="useModel(38)">5余4</a> <a href="javascript:;"
							onClick="init();">清零</a>
					</div>
				</div>
			</div>
			<div class="edit_nav_right">
				<p>自定义模式</p>
				<div class="diy_model_box list_content">
					<a href="javascript:;" id="diy1237237" onClick="chgModel(0)" title="中规中矩">中规中矩</a>
					<a href="javascript:;" id="diy1238603" onClick="chgModel(1)" title="java">java</a>
					<a href="javascript:;" id="diy1251242" onClick="chgModel(2)" title="small_java">small_java</a>
					<a href="javascript:;" id="diy1252838" onClick="chgModel(3)" title="单">单</a>
					<a href="javascript:;" id="diy1252840" onClick="chgModel(4)" title="双">双</a>
					<a href="javascript:;" id="diy1254868" onClick="chgModel(5)" title="追极限">追极限</a>
					<a href="javascript:;" id="diy1259930" onClick="chgModel(6)" title="临时随意">临时随意</a>
					<a href="model.php" target="_blank">+新加模式</a>
				</div>
			</div>
		</div>
		<form id="fInsert" data-val="0" method="post" action="" autocomplete="off" onsubmit="return checkLedou()">
			<input type="hidden" id="tbID" name="tbID" value="" /> <input type="hidden" id="gameNO" name="gameNO"
				value="1410765" /> <input type="hidden" id="token" name="fast"
				value="7f9205a2bdd428f81241116298c29424" />
			<div class="double_box">
				<div class="double_box_left">
					<span>乐豆加倍</span>
					<input type="hidden" id="hidTimes" value="1" />
					<a href="javascript:;" onClick="chgAllTimes(0.5)">0.5倍</a>
					<a href="javascript:;" onClick="chgAllTimes(0.8)"> 0.8倍</a>
					<a href="javascript:;" onClick="chgAllTimes(1.5)">1.5倍</a>
					<a href="javascript:;" onClick="chgAllTimes(2)">2倍</a>
					<a href="javascript:;" onClick="chgAllTimes(5)">5倍</a>
					<a href="javascript:;" onClick="chgAllTimes(10)">10倍</a>
					<a href="javascript:;" onClick="chgAllTimes(100)">100倍</a>
					<a href="javascript:;" onClick="suoha()">拼了</a>
					<span>总参与：<span class="tbTotalG1">0</span><span class="ld"></span></span>
				</div>
				<div class="edit_top">
					<button id="pour" type="button" class="pourAll" data-state="0">参与</button>
					<div class="topSele_box">
						<a href="javascript:;" onClick="reloadNow()">刷新赔率</a>
						<a href="javascript:;" onClick="useModel(40)">上期参与</a>
						<a href="javascript:;" onClick="subSelect()">反选</a>
						<a href="javascript:;" onClick="init()">清零</a>
					</div>
				</div>
			</div>
			<div class="jc_list_box jc_edit">
				<div class="bianji_middle">
					<div class="bj_con">
						<div class="column column1">
							<div class="jc_bj_item js_bj_box" id="tbImg0">
								<span class="ball color_ball" onclick="insert(this,'0')">0</span>
								<div class="chi">
									<input id="tbNum0" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk0')"
										name="tbNum[0]">
									<span>当前赔率：<font id="rate_0">1002.45</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:1000.03</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'0')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum0',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum0',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum0',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum0',10)">10</a>
									</div>
									<p class="fan2">标准赔率:1000</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg1">
								<span class="ball color_ball" onclick="insert(this,'1')">1</span>
								<div class="chi">
									<input id="tbNum1" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk1')"
										name="tbNum[1]"> <span>当前赔率：<font id="rate_1">336.52</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:336.82</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'1')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum1',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum1',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum1',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum1',10)">10</a>
									</div>
									<p class="fan2">标准赔率:333.33</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg2">
								<span class="ball color_ball" onclick="insert(this,'2')">2</span>
								<div class="chi">
									<input id="tbNum2" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk2')"
										name="tbNum[2]"> <span>当前赔率：<font id="rate_2">168.17</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:168.52</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'2')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum2',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum2',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum2',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum2',10)">10</a>
									</div>
									<p class="fan2">标准赔率:166.67</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg3">
								<span class="ball color_ball" onclick="insert(this,'3')">3</span>
								<div class="chi">
									<input id="tbNum3" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk3')"
										name="tbNum[3]"> <span>当前赔率：<font id="rate_3">100.8</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:101.03</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'3')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum3',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum3',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum3',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum3',10)">10</a>
									</div>
									<p class="fan2">标准赔率:100</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg4">
								<span class="ball color_ball" onclick="insert(this,'4')">4</span>
								<div class="chi">
									<input id="tbNum4" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk4')"
										name="tbNum[4]"> <span>当前赔率：<font id="rate_4">67.09</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:67.12</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'4')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum4',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum4',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum4',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum4',10)">10</a>
									</div>
									<p class="fan2">标准赔率:66.66</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg5">
								<span class="ball color_ball" onclick="insert(this,'5')">5</span>
								<div class="chi">
									<input id="tbNum5" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk5')"
										name="tbNum[5]"> <span>当前赔率：<font id="rate_5">47.7</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:47.82</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'5')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum5',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum5',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum5',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum5',10)">10</a>
									</div>
									<p class="fan2">标准赔率:47.61</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg6">
								<span class="ball color_ball" onclick="insert(this,'6')">6</span>
								<div class="chi">
									<input id="tbNum6" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk6')"
										name="tbNum[6]"> <span>当前赔率：<font id="rate_6">35.61</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:35.7</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'6')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum6',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum6',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum6',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum6',10)">10</a>
									</div>
									<p class="fan2">标准赔率:35.71</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg7">
								<span class="ball color_ball" onclick="insert(this,'7')">7</span>
								<div class="chi">
									<input id="tbNum7" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk7')"
										name="tbNum[7]"> <span>当前赔率：<font id="rate_7">27.71</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:27.8</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'7')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum7',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum7',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum7',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum7',10)">10</a>
									</div>
									<p class="fan2">标准赔率:27.77</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg8">
								<span class="ball color_ball" onclick="insert(this,'8')">8</span>
								<div class="chi">
									<input id="tbNum8" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk8')"
										name="tbNum[8]"> <span>当前赔率：<font id="rate_8">22.3</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:22.25</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'8')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum8',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum8',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum8',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum8',10)">10</a>
									</div>
									<p class="fan2">标准赔率:22.22</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg9">
								<span class="ball color_ball" onclick="insert(this,'9')">9</span>
								<div class="chi">
									<input id="tbNum9" type="text" maxlength="8" value="" onkeyup="input(this,'tbChk9')"
										name="tbNum[9]"> <span>当前赔率：<font id="rate_9">18.06</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:18.12</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'9')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum9',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum9',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum9',2)">2</a>
										<a href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum9',10)">10</a>
									</div>
									<p class="fan2">标准赔率:18.18</p>
								</div>
							</div>
						</div>
						<div class="column column2">
							<div class="jc_bj_item js_bj_box" id="tbImg10">
								<span class="ball color_ball" onclick="insert(this,'10')">10</span>
								<div class="chi">
									<input id="tbNum10" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk10')" name="tbNum[10]"> <span>当前赔率：<font id="rate_10">
											15.82</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:15.8</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'10')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum10',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum10',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum10',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum10',10)">10</a>
									</div>
									<p class="fan2">标准赔率:15.87</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg11">
								<span class="ball color_ball" onclick="insert(this,'11')">11</span>
								<div class="chi">
									<input id="tbNum11" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk11')" name="tbNum[11]"> <span>当前赔率：<font id="rate_11">
											14.51</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:14.45</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'11')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum11',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum11',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum11',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum11',10)">10</a>
									</div>
									<p class="fan2">标准赔率:14.49</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg12">
								<span class="ball color_ball" onclick="insert(this,'12')">12</span>
								<div class="chi">
									<input id="tbNum12" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk12')" name="tbNum[12]"> <span>当前赔率：<font id="rate_12">
											13.77</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:13.7</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'12')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum12',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum12',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum12',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum12',10)">10</a>
									</div>
									<p class="fan2">标准赔率:13.69</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg13">
								<span class="ball color_ball" onclick="insert(this,'13')">13</span>
								<div class="chi">
									<input id="tbNum13" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk13')" name="tbNum[13]"> <span>当前赔率：<font id="rate_13">
											13.37</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:13.36</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'13')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum13',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum13',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum13',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum13',10)">10</a>
									</div>
									<p class="fan2">标准赔率:13.33</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg14">
								<span class="ball color_ball" onclick="insert(this,'14')">14</span>
								<div class="chi">
									<input id="tbNum14" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk14')" name="tbNum[14]"> <span>当前赔率：<font id="rate_14">
											13.29</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:13.34</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'14')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum14',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum14',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum14',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum14',10)">10</a>
									</div>
									<p class="fan2">标准赔率:13.33</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg15">
								<span class="ball color_ball" onclick="insert(this,'15')">15</span>
								<div class="chi">
									<input id="tbNum15" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk15')" name="tbNum[15]"> <span>当前赔率：<font id="rate_15">
											13.67</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:13.68</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'15')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum15',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum15',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum15',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum15',10)">10</a>
									</div>
									<p class="fan2">标准赔率:13.69</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg16">
								<span class="ball color_ball" onclick="insert(this,'16')">16</span>
								<div class="chi">
									<input id="tbNum16" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk16')" name="tbNum[16]"> <span>当前赔率：<font id="rate_16">
											14.54</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:14.42</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'16')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum16',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum16',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum16',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum16',10)">10</a>
									</div>
									<p class="fan2">标准赔率:14.49</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg17">
								<span class="ball color_ball" onclick="insert(this,'17')">17</span>
								<div class="chi">
									<input id="tbNum17" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk17')" name="tbNum[17]"> <span>当前赔率：<font id="rate_17">
											15.83</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:15.87</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'17')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum17',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum17',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum17',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum17',10)">10</a>
									</div>
									<p class="fan2">标准赔率:15.87</p>
								</div>
							</div>
							<div class="edit_bottom">
								<p>
									我的总参与<br>
									<span class="tbTotalG1" id="tbTotalG1">0</span>
									<span class="ld"></span>
								</p>
								<button type="button" class="pourAll" data-state="0">参与</button>
							</div>
						</div>
						<div class="column column3">
							<div class="jc_bj_item js_bj_box" id="tbImg18">
								<span class="ball color_ball" onclick="insert(this,'18')">18</span>
								<div class="chi">
									<input id="tbNum18" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk18')" name="tbNum[18]"> <span>当前赔率：<font id="rate_18">
											18.15</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:18.14</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'18')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum18',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum18',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum18',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum18',10)">10</a>
									</div>
									<p class="fan2">标准赔率:18.18</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg19">
								<span class="ball color_ball" onclick="insert(this,'19')">19</span>
								<div class="chi">
									<input id="tbNum19" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk19')" name="tbNum[19]"> <span>当前赔率：<font id="rate_19">
											22.08</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:22.17</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'19')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum19',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum19',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum19',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum19',10)">10</a>
									</div>
									<p class="fan2">标准赔率:22.22</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg20">
								<span class="ball color_ball" onclick="insert(this,'20')">20</span>
								<div class="chi">
									<input id="tbNum20" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk20')" name="tbNum[20]"> <span>当前赔率：<font id="rate_20">
											27.68</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:27.82</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'20')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum20',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum20',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum20',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum20',10)">10</a>
									</div>
									<p class="fan2">标准赔率:27.77</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg21">
								<span class="ball color_ball" onclick="insert(this,'21')">21</span>
								<div class="chi">
									<input id="tbNum21" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk21')" name="tbNum[21]"> <span>当前赔率：<font id="rate_21">
											35.64</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:35.75</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'21')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum21',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum21',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum21',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum21',10)">10</a>
									</div>
									<p class="fan2">标准赔率:35.71</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg22">
								<span class="ball color_ball" onclick="insert(this,'22')">22</span>
								<div class="chi">
									<input id="tbNum22" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk22')" name="tbNum[22]"> <span>当前赔率：<font id="rate_22">
											47.87</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:47.84</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'22')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum22',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum22',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum22',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum22',10)">10</a>
									</div>
									<p class="fan2">标准赔率:47.61</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg23">
								<span class="ball color_ball" onclick="insert(this,'23')">23</span>
								<div class="chi">
									<input id="tbNum23" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk23')" name="tbNum[23]"> <span>当前赔率：<font id="rate_23">
											67.03</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:67.01</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'23')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum23',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum23',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum23',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum23',10)">10</a>
									</div>
									<p class="fan2">标准赔率:66.66</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg24">
								<span class="ball color_ball" onclick="insert(this,'24')">24</span>
								<div class="chi">
									<input id="tbNum24" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk24')" name="tbNum[24]"> <span>当前赔率：<font id="rate_24">
											100.95</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:101.04</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'24')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum24',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum24',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum24',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum24',10)">10</a>
									</div>
									<p class="fan2">标准赔率:100</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg25">
								<span class="ball color_ball" onclick="insert(this,'25')">25</span>
								<div class="chi">
									<input id="tbNum25" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk25')" name="tbNum[25]"> <span>当前赔率：<font id="rate_25">
											168.33</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:168.32</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'25')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum25',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum25',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum25',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum25',10)">10</a>
									</div>
									<p class="fan2">标准赔率:166.66</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg26">
								<span class="ball color_ball" onclick="insert(this,'26')">26</span>
								<div class="chi">
									<input id="tbNum26" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk26')" name="tbNum[26]"> <span>当前赔率：<font id="rate_26">
											336.19</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:336.86</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'26')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum26',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum26',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum26',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum26',10)">10</a>
									</div>
									<p class="fan2">标准赔率:333.33</p>
								</div>
							</div>
							<div class="jc_bj_item js_bj_box" id="tbImg27">
								<span class="ball color_ball" onclick="insert(this,'27')">27</span>
								<div class="chi">
									<input id="tbNum27" type="text" maxlength="8" value=""
										onkeyup="input(this,'tbChk27')" name="tbNum[27]"> <span>当前赔率：<font id="rate_27">
											1003.57</font></span>
								</div>
								<div class="fan">
									<p class="fan1">
										<span class="none">上期赔率:1001.81</span>
									</p>
									<div class="beishu">
										<a href="javascript:;" class="icon_btn js_icon_btn"
											onclick="insert(this,'27')"></a>
										<span>x</span> <a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum27',0.1)">.1</a> <a href="javascript:;"
											class="beishu_btn" onclick="chgTimes('tbNum27',0.5)">.5</a> <a
											href="javascript:;" class="beishu_btn" onclick="chgTimes('tbNum27',2)">2</a>
										<a href="javascript:;" class="beishu_btn"
											onclick="chgTimes('tbNum27',10)">10</a>
									</div>
									<p class="fan2">标准赔率:1000</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function getCookie(cname) {
			var name = cname + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i].trim();
				if (c.indexOf(name) == 0) { return c.substring(name.length, c.length); }
			}
			return "";
		}
		$(".pourAll").click(function () {
			var userId = 2;
			var cookies = document.cookie;
			if (cookies != null) {
				userId = getCookie("userId");
			}
			var fastNO = location.href.split('?')[1].split('=')[1];
			var data = $('#fInsert').serialize();
			var array = data.split('&');
			var moban = new Object();
			for (var i = 3; i < array.length; i++) {
				var c = array[i].split('=');
				if (c[1] && i == 3) {
					moban.zero = c[1];
				} else if (c[1] && i == 4) {
					moban.one = c[1];
				} else if (c[1] && i == 5) {
					moban.two = c[1];
				} else if (c[1] && i == 6) {
					moban.three = c[1];
				} else if (c[1] && i == 7) {
					moban.four = c[1];
				} else if (c[1] && i == 8) {
					moban.five = c[1];
				} else if (c[1] && i == 9) {
					moban.six = c[1];
				} else if (c[1] && i == 10) {
					moban.seven = c[1];
				} else if (c[1] && i == 11) {
					moban.night = c[1];
				} else if (c[1] && i == 12) {
					moban.nine = c[1];
				} else if (c[1] && i == 13) {
					moban.ten = c[1];
				} else if (c[1] && i == 14) {
					moban.tenOne = c[1];
				} else if (c[1] && i == 15) {
					moban.tenTwo = c[1];
				} else if (c[1] && i == 16) {
					moban.tenThree = c[1];
				} else if (c[1] && i == 17) {
					moban.tenFour = c[1];
				} else if (c[1] && i == 18) {
					moban.tenFive = c[1];
				} else if (c[1] && i == 19) {
					moban.tenSix = c[1];
				} else if (c[1] && i == 20) {
					moban.tenSeven = c[1];
				} else if (c[1] && i == 21) {
					moban.tenNight = c[1];
				} else if (c[1] && i == 22) {
					moban.tenNine = c[1];
				} else if (c[1] && i == 23) {
					moban.twtenty = c[1];
				} else if (c[1] && i == 24) {
					moban.twtentyOne = c[1];
				} else if (c[1] && i == 25) {
					moban.twtentyTwo = c[1];
				} else if (c[1] && i == 26) {
					moban.twtentyThree = c[1];
				} else if (c[1] && i == 27) {
					moban.twtentyFour = c[1];
				} else if (c[1] && i == 28) {
					moban.twtentyFive = c[1];
				} else if (c[1] && i == 29) {
					moban.twtentySix = c[1];
				} else if (c[1] && i == 30) {
					moban.twtentySeven = c[1];
				}
			}
			var pen = {
				"moban": moban,
				"userId": userId,
				"fastNO": fastNO
			};
			$.ajax({
				type: "POST",
				url: "/myqq/qq/pourMoney",
				dataType: "text",
				contentType: 'application/json',//解决复杂对象传输
				data: JSON.stringify(pen),//解决复杂对象传输
				success: function (strJson) {
					alert(strJson);
				}
			});
		});
		var userD = parseInt($('#userD').attr('data-val'));
		var userG = parseInt($('#userG').attr('data-val'));
		var rate = parseInt($('#userLDou').attr('data-val'));
		var maxD = parseInt($('#userD').attr('data-key'));
		var fTimingKey = 'cSoundfast';
		var fTimingSun = 'insert.php';
		var fTimingNO = 0;
		var game = 'fast';
		var isStop = '0';
		var isRefresh = 1;
		//弹窗
		//战绩
		var addstring = '';
		addstring += '<div id="syxq_btn" style="display:none;"><div class="jc_bg"></div><div class="jc_content jc_big jc_sy"><div class="tc_title"><span class="bt_wenzi">战绩详情</span><a class="gb_anniu"  onclick="hideLDdiv(\'syxq_btn\')" href="javascript:;"></a></div> <div class="tc_xinxi"><div class="tk_text"><p class="bioati"><strong>今日：</strong><font class="todayD" color="#fa6700">0</font><span class="ld"></span></p><p class="bioati"><strong>昨日：</strong><font class="yesterdayD" color="#fa6700">0</font><span class="ld"></span></p><p class="bioati fengexian"><strong>本月：</strong><font class="monthD" color="#fa6700">0</font><span class="ld"></span></p><p class="bioati"><strong>上月：</strong><font class="lastmonthD" color="#fa6700">0</font><span class="ld"></span></p></div><div class="tc_anniu"><a onclick="hideLDdiv(\'syxq_btn\')" href="javascript:;">确定</a></div></div></div></div>';
		addstring += '<div id="msg_btn" style="display:none;"><div class="jc_bg"></div><div class="jc_content jc_small"><div class="tc_title"><span class="bt_wenzi">温馨提示</span><a class="gb_anniu" onclick="hideLDdiv(\'msg_btn\')" href="javascript:;"></a></div><div class="tc_xinxi"><div class="tk_text"><p class="bioati"></p></div><div class="tc_anniu"><a class="queding1" onclick="hideLDdiv(\'msg_btn\')" href="javascript:;">确定</a></div></div></div></div>';
		var resultJsonModel = { "arrJsonModel": [{ "ID": "1237237", "modelID": "4", "modelName": null, "N0": "12", "N1": "23", "N2": "57", "N3": "63", "N4": "156", "N5": "204", "N6": "242", "N7": "331", "N8": "452", "N9": "522", "N10": "604", "N11": "689", "N12": "786", "N13": "817", "N14": "683", "N15": "674", "N16": "691", "N17": "656", "N18": "578", "N19": "448", "N20": "389", "N21": "318", "N22": "216", "N23": "144", "N24": "137", "N25": "63", "N26": "37", "N27": "8" }, { "ID": "1238603", "modelID": "5", "modelName": "java", "N0": "700", "N1": "650", "N2": "1300", "N3": "2000", "N4": "1850", "N5": "6100", "N6": "1900", "N7": "7300", "N8": "2800", "N9": "3200", "N10": "3100", "N11": "8500", "N12": "3600", "N13": "750", "N14": "750", "N15": "4000", "N16": "1000", "N17": "3600", "N18": "3900", "N19": "2600", "N20": "7300", "N21": "1900", "N22": "6100", "N23": "1900", "N24": "2000", "N25": "1300", "N26": "650", "N27": "600" }, { "ID": "1251242", "modelID": "6", "modelName": "small_java", "N0": "87", "N1": "81", "N2": "162", "N3": "250", "N4": "231", "N5": "762", "N6": "237", "N7": "912", "N8": "350", "N9": "400", "N10": "387", "N11": "1062", "N12": "450", "N13": "93", "N14": "93", "N15": "500", "N16": "125", "N17": "450", "N18": "487", "N19": "325", "N20": "912", "N21": "237", "N22": "762", "N23": "237", "N24": "250", "N25": "162", "N26": "81", "N27": "75" }, { "ID": "1252838", "modelID": "7", "modelName": null, "N0": "40", "N1": "110", "N2": "30", "N3": "330", "N4": "40", "N5": "330", "N6": "0", "N7": "550", "N8": "0", "N9": "770", "N10": "0", "N11": "440", "N12": "0", "N13": "440", "N14": "0", "N15": "440", "N16": "0", "N17": "440", "N18": "0", "N19": "880", "N20": "0", "N21": "560", "N22": "22", "N23": "440", "N24": "55", "N25": "170", "N26": "55", "N27": "110" }, { "ID": "1252840", "modelID": "8", "modelName": "\u02eb", "N0": "36", "N1": "79", "N2": "108", "N3": "79", "N4": "476", "N5": "0", "N6": "799", "N7": "0", "N8": "1196", "N9": "0", "N10": "799", "N11": "0", "N12": "799", "N13": "0", "N14": "799", "N15": "0", "N16": "799", "N17": "0", "N18": "1196", "N19": "0", "N20": "799", "N21": "0", "N22": "799", "N23": "116", "N24": "316", "N25": "116", "N26": "79", "N27": "36" }, { "ID": "1254868", "modelID": "1", "modelName": null, "N0": "1211", "N1": "1211", "N2": "1211", "N3": "112", "N4": "0", "N5": "0", "N6": "0", "N7": "0", "N8": "0", "N9": "0", "N10": "0", "N11": "0", "N12": "0", "N13": "0", "N14": "0", "N15": "0", "N16": "0", "N17": "0", "N18": "0", "N19": "0", "N20": "0", "N21": "0", "N22": "0", "N23": "0", "N24": "222", "N25": "1211", "N26": "2211", "N27": "2111" }, { "ID": "1259930", "modelID": "2", "modelName": null, "N0": "700", "N1": "300", "N2": "0", "N3": "0", "N4": "0", "N5": "0", "N6": "0", "N7": "0", "N8": "0", "N9": "0", "N10": "0", "N11": "0", "N12": "0", "N13": "0", "N14": "0", "N15": "0", "N16": "0", "N17": "0", "N18": "0", "N19": "0", "N20": "0", "N21": "0", "N22": "0", "N23": "0", "N24": "0", "N25": "0", "N26": "200", "N27": "600" }] };
		var arrModel40 = new Array();
		//上期参与
		arrModel40[0] = 0;
		arrModel40[1] = 0;
		arrModel40[2] = 0;
		arrModel40[3] = 0;
		arrModel40[4] = 0;
		arrModel40[5] = 0;
		arrModel40[6] = 0;
		arrModel40[7] = 0;
		arrModel40[8] = 0;
		arrModel40[9] = 0;
		arrModel40[10] = 0;
		arrModel40[11] = 0;
		arrModel40[12] = 0;
		arrModel40[13] = 0;
		arrModel40[14] = 0;
		arrModel40[15] = 0;
		arrModel40[16] = 0;
		arrModel40[17] = 0;
		arrModel40[18] = 0;
		arrModel40[19] = 0;
		arrModel40[20] = 0;
		arrModel40[21] = 0;
		arrModel40[22] = 0;
		arrModel40[23] = 0;
		arrModel40[24] = 0;
		arrModel40[25] = 0;
		arrModel40[26] = 0;
		arrModel40[27] = 0;
		$('.bianji_middle input').val("");
	</script>
</body>

</html>