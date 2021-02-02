<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<style type="text/css">
#lottery{width:574px;height:584px;margin:20px auto 0;background:url(images/shenshou.png) no-repeat;padding:44px 42px;}
#lottery table td{width:42px;height:42px;text-align:center;vertical-align:middle;font-size:24px;color:#333;font-index:-999}
#lottery table td a{width:44px;height:42px;line-height:150px;display:block;text-decoration:none;}
#lottery table td.active{background-color:#ea0000;}
</style>

</head>
<body>

<div id="lottery">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td class="lottery-unit lottery-unit-1"><img src="images/dawugui.png"></td>
		</tr>
		<tr>
			<td class="lottery-unit lottery-unit-16"><img src="images/xiaowugui.png"></td>
			<td colspan="1" rowspan="1"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-2"><img src="images/xiaolong.png"></td>
		</tr>
		<tr>
			<td class="lottery-unit lottery-unit-15"><img src="images/xiaofenghuang.png"></td>
			<td colspan="1" rowspan="3"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-3"><img src="images/xiaohu.png"></td>
		</tr>
		<tr>
			<td class="lottery-unit lottery-unit-14"><img src="images/xiaohu.png"></td>
			<td colspan="1" rowspan="5"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-4"><img src="images/xiaofenghuang.png"></td>
		</tr>
        <tr>
			<td class="lottery-unit lottery-unit-13"><img src="images/dafenghuang.png"></td>
			<td colspan="1" rowspan="7"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-5"><img src="images/dalong.png"></td>
		</tr>
        <tr>
			<td class="lottery-unit lottery-unit-12"><img src="images/xiaolong.png"></td>
			<td colspan="1" rowspan="5"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-6"><img src="images/xiaowugui.png"></td>
		</tr>
        <tr>
			<td class="lottery-unit lottery-unit-11"><img src="images/xiaowugui.png"></td>
			<td colspan="1" rowspan="3"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-7"><img src="images/xiaolong.png"></td>
		</tr>
        <tr>
			<td class="lottery-unit lottery-unit-10"><img src="images/xiaofenghuang.png"></td>
			<td colspan="1" rowspan="1"><a href="#"></a></td>
			<td class="lottery-unit lottery-unit-8"><img src="images/xiaohu.png"></td>
		</tr>
        <tr>
            <td class="lottery-unit lottery-unit-9"><img src="images/dahu.png"></td>
		</tr>
	</table>
</div>

<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
var lottery={
	index:-1,	//当前转动到哪个位置，起点位置
	count:0,	//总共有多少个位置
	timer:0,	//setTimeout的ID，用clearTimeout清除
	speed:20,	//初始转动速度
	times:0,	//转动次数
	cycle:50,	//转动基本次数：即至少需要转动多少次再进入抽奖环节
	prize:-1,	//中奖位置
	init:function(id){
		if ($("#"+id).find(".lottery-unit").length>0) {
			$lottery = $("#"+id);
			$units = $lottery.find(".lottery-unit");
			this.obj = $lottery;
			this.count = $units.length;
			$lottery.find(".lottery-unit-"+this.index).addClass("active");
		};
	},
	roll:function(){
		var index = this.index;
		var count = this.count;
		var lottery = this.obj;
		$(lottery).find(".lottery-unit-"+index).removeClass("active");
		index += 1;
		if (index>count-1) {
			index = 0;
		};
		$(lottery).find(".lottery-unit-"+index).addClass("active");
		this.index=index;
		return false;
	},
	stop:function(index){
		this.prize=index;
		return false;
	}
};

function roll(){
	lottery.times += 1;
	lottery.roll();
	if (lottery.times > lottery.cycle+10 && lottery.prize==lottery.index) {
		clearTimeout(lottery.timer);
		lottery.prize=-1;
		lottery.times=0;
		click=false;
	}else{
		if (lottery.times<lottery.cycle) {
			lottery.speed -= 10;
		}else if(lottery.times==lottery.cycle) {
			var index = Math.random()*(lottery.count)|0;
			lottery.prize = index;		
		}else{
			if (lottery.times > lottery.cycle+10 && ((lottery.prize==0 && lottery.index==7) || lottery.prize==lottery.index+1)) {
				lottery.speed += 110;
			}else{
				lottery.speed += 20;
			}
		}
		if (lottery.speed<40) {
			lottery.speed=40;
		};
		//console.log(lottery.times+'^^^^^^'+lottery.speed+'^^^^^^^'+lottery.prize);
		lottery.timer = setTimeout(roll,lottery.speed);
	}
	return false;
}

var click=false;

window.onload=function(){
	lottery.init('lottery');
	$("#lottery a").click(function(){
		if (click) {
			return false;
		}else{
			lottery.speed=100;
			roll();
			click=true;
			return false;
		}
	});
};
</script>

</body>
</html>
