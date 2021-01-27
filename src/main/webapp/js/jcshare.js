function chkStrLen(str,minLength,maxLength){
	if(str.length < minLength){
		return false;
	}
	if(maxLength != null && str.length > maxLength){
		return false;
	}
	return true;
}
function chkInt(int,minLength,maxLength,pattern){
	pattern = typeof(pattern) == 'undefined' ? '^-?[1-9]+[0-9]*$' : pattern;
	pattern = new RegExp(pattern);
	if(pattern.test(int)==false){
		return false;
	}
	return chkStrLen(int,minLength,maxLength);
}
function removecomma(str){
	return str.replace(/,/g,"");
}
function setCookie(cookieName,cookieValue){
	createCookie(cookieName,cookieValue,24000);
}
function createCookie(name,value,time){
	var expires=new Date();
	expires.setTime(expires.getTime()+time*3600*1000);
	var expiryDate=expires.toGMTString();
	document.cookie=name+"="+value+";path=/;expires="+expiryDate;
}
function readCookie(cookieName){
	var aCookie = document.cookie.split("; ");
	for(var i = 0; i < aCookie.length; i++){
		var aCrumb = aCookie[i].split("=");
		if (cookieName == aCrumb[0]) return unescape(aCrumb[1]);
	}
	return null;
}
function delCookie(name){ 
    var expires = new Date(); 
    expires.setTime(expires.getTime() - 1); 
    var cval=readCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+expires.toGMTString(); 
}
function nn2c(num){   
	num += "";
	var renum=num;
	l = num.length;
	if(l >= 5){
		a = num.substr(l-4,4);
		b = num.substr(0,l-4);
		renum =  b+'万'+a;
	}
	if(l>=9){
		a = num.substr(l-4,4);
		b = num.substr(l-8,4);
		c = num.substr(0,l-8);
		renum =  c+'亿'+b+'万'+a;
	}
	return renum;
}
function formatNum(s){
	var type=0;
	if(/[^0-9\.]/.test(s)) return "0";
	if(s == null || s == "") return "0";
	s = s.toString().replace(/^(\d*)$/, "$1.");
	s = (s + "00").replace(/(\d*\.\d\d)\d*/, "$1");
	s = s.replace(".", ",");
	var re = /(\d)(\d{3},)/;
	while (re.test(s))
	s = s.replace(re, "$1,$2");
	s = s.replace(/,(\d\d)$/, ".$1");
	if(type == 0){// 不带小数位(默认是有小数位)
		var a = s.split(".");
		if(a[1] == "00"){
			s = a[0];
		}
	}
	return s;
}
function numToWord(num){
	var arrMap = [['0','十'],['1','一'],['2','二'],['3','三'],['4','四'],['5','五'], ['6','六'],['7','七'],['8','八'],['9','九']];
	var leng = String(num).length;
	var arrNum = String(num).split('');
	var vWord = '模式';
	if(num!=10){
		for(var i=0;i<leng;i++){
			vWord += arrMap[arrNum[i]][1];
		}
	}else{
		vWord += '十';
	}
	return vWord;
}
function sixToWord(num){
	var vShow = '<span>?</span><span>?</span><span>?</span>';
	if(num!='?'){
		var word1 = '小';
		var word2 = '边';
		var word3 = '单';
		if(num>13){
			word1 = '大';
		}
		if(num>9&&num<18){
			word2 = '中';
		}
		if(num%2==0){
			word3 = '双';
		}
		vShow = '<span>'+word1+'</span><span>'+word2+'</span><span>'+word3+'</span>';
	}
	$('.pig_main .ball').html(vShow);
}
function ball_down(t,num){
	sixToWord(num)
	if(t==1){//显示球
		$('.gold_pig_con .result_box').animate({top:"50px",opacity:1});
		$('.gold_pig_con .ball').animate({top:"50px"});
		$('.gold_pig_con .countdown_text').fadeOut();
	}
	else{//隐藏球
		$('.gold_pig_con .result_box').animate({top:"0px",opacity:0});
		$('.gold_pig_con .ball').animate({top:"0px"});
		$('.gold_pig_con .countdown_text').fadeIn();
	}
}
var HTTP_DOMAIN = '';

function ShowMsg(msg){
	$("#msg_btn .bioati").html(msg);
	$("#msg_btn").show();
}
function ShowSecond(fTimingNO,cDate,fTimingBase){
	if(fTimingNO != ""){
		var t0='第<span>'+fTimingNO+'</span>期';
		var t1=0;
		var t2="正在挑战中......";
		var fTiming ='reloadOpen()';
		if(fTimingSun=="index.php"&&game!="sixpig"){
			fTiming ='myrefresh()';
		}
		if(cDate>0){
			--cDate;
			if(cDate>fTimingBase){
				t1=cDate-fTimingBase;
			}
			if(cDate>=0){
				t2='距挑战时间还剩<span>'+cDate+'</span>秒';
				setTimeout("ShowSecond(" + fTimingNO + "," + cDate + "," + fTimingBase + ")", 1000);
			}
		}else{
			setTimeout(fTiming,getRefreshSeconds(game));
		}
		if(fTimingSun=="index.php"&&t1<1 && isStop!=1){
			$("#issue"+fTimingNO).html("挑战中");
		}
		var jumpNO = fTimingNO;
		if(t1<1){
			jumpNO = parseInt(jumpNO)+1;
		}
		var jumpKey ='fast';
		if(game.indexOf("luck") != -1){
			jumpKey ='luck';
		}
		else if(game.indexOf("happy") != -1){
			jumpKey ='happy';
		}
		else if(game.indexOf("fun") != -1){
			jumpKey ='fun';
		}
		else if(game.indexOf("six") != -1){
			jumpKey ='six';
			if(t1>0){
				$('.countdown_text').html('距'+t0+'参与截止还剩<span>'+t1+'</span>秒');
			}else{
				$('.countdown_text').html(t2);
			}
		}
		var vhref = 'insert.php?'+jumpKey+'NO='+jumpNO;
		if(game.indexOf("six") != -1||isStop==1){
			vhref = '/'+game;
		}
		$('.nowLink').attr('href',vhref);
		$('.countdown').html('<p>距'+t0+'参与截止还剩<span>'+t1+'</span>秒 '+t2+'</p><a href="javascript:;" onclick="'+fTiming+'">[刷新]</a>');
		if(fTimingSun=="index.php"&&readCookie(fTimingKey) == '1'&&((cDate <5 &&cDate%2==0)||cDate<1)){
			swfobject.embedSWF(HTTP_DOMAIN+'/assets/images/sound/security.swf', 'sound_bet', '0', '0', '8.0.0');
		}
	}
}
function changeAccount(strJson){
	$('.userD').attr('data-val',strJson.userD).attr('data-key',strJson.limitD).html(formatNum(strJson.userD));
	$('.userG').attr('data-val',strJson.userG).html(formatNum(strJson.userG));
	$('#userLDou').attr('data-val',strJson.userLDou);
	return true;
}
var allD = 0;
function sum(){
	allD = 0;
	for(var i=startI;i<endI;i++){
		var valN = parseInt($("#tbNum"+i).val());
		if(valN>0){
			allD = allD+valN;
			if(game.indexOf("pig") != -1){
				$("#tbImg"+i+' .bet_text').text(valN+'万');
				$("#tbImg"+i+" .lunch_box").addClass('lunch_box2');
				console.log('pig-sum'+i);
			}else{
				$("#tbImg"+i).addClass('jc_bj_item_active');
			}
			if(fTimingKey == 'cSoundhappy36'){
				$("#tbChk"+i).addClass('checked');
			}
		}else{
			$("#tbNum"+i).val("");	
			$("#tbImg"+i).removeClass('jc_bj_item_active');
			if(fTimingKey == 'cSoundhappy36'){
				$("#tbChk"+i).removeClass('checked');
			}
		}
	}
	var allDs = '0';
	if(game.indexOf("pig") != -1){
		allDs= allD+'万';
	}else{
		allDs = formatNum(allD);
	}
	$(".tbTotalG1").html(allDs);
	if(allD>maxD){
		ShowMsg("您参与的太多了，请减少些吧！");
		return false;
	}
}
function init(){
	for(i=startI;i<endI;i++){
		if(game.indexOf("pig") != -1){
			$("#tbImg"+i+' .bet_text').text('');
			$("#tbImg"+i+" .lunch_box").removeClass('lunch_box2');
			console.log('pig-init'+i);
		}else{
			$("#tbImg"+i).removeClass('jc_bj_item_active');
			if(fTimingKey == 'cSoundhappy36'){
				$("#tbChk"+i).removeClass('checked');
			}
		}
		$("#tbNum"+i).val('');
	}
	if(game.indexOf("pig") == -1){
		$("#hidTimes").val(1);
	}
	$(".tbTotalG1").text(0);
}
function chkNum(numID,times){
	var valN = parseInt($("#"+numID).val());
	var valF = Math.floor(valN * times);
	if(valF >= 1){
		$("#"+numID).val(valF);
	}
	else{
		$("#"+numID).val("");
	}
}
function chgTimes(numID,times){
	chkNum(numID,times);
	sum();
}
function chgAllTimes(times){
	$("#hidTimes").val($("#hidTimes").val() * times);
	for(i=startI;i<endI;i++){
		chkNum("tbNum"+i,times);
	}
	sum();
}
function insert(obj,numID){
	if($('#tbNum'+numID).val()==""){
		$('#tbNum'+numID).val(arrModel0[numID]);
	}else{
		$('#tbNum'+numID).val("");
	}
	sum();
}
function input(obj,chkID){
	if(obj.value<=0||chkInt(obj.value)==false){
		obj.value = "";
	}
	sum();
}
function useModel(index){
	init();
	var arrModel = eval("arrModel"+index);
	for(i=startI;i<endI;i++){
		if(arrModel[i]>0){
			$("#tbNum"+i).val(arrModel[i]);
		}
	}
	sum();
}
function subSelect(){
	var arrModel = eval("arrModel0");
	for(i=startI;i<endI;i++){
		if($("#tbNum"+i).val()==""){
			$("#tbNum"+i).val(arrModel[i]);
		}else{
			$("#tbNum"+i).val('');
		}
	}
	sum();
}
//拼了函数
function suoha(){
	var gg=userD;
	if(gg>maxD){
		gg = maxD;	
	}
	var allDG = 0;
	for(var k=startI;k<endI;k++){
		if($("#tbNum"+k).val()>0){
			allDG = allDG + parseInt($("#tbNum"+k).val());	
		}
	}
	if(allDG<=0){
		ShowMsg('请您先选择要拼了的号码');
		return false;
	}
	for(var k=startI;k<endI;k++){
		if($("#tbNum"+k).val()>0){
			$("#tbNum"+k).val(parseInt(gg/allDG*$("#tbNum"+k).val()));	
		}
	}
	sum();	
}
function chgModelNum(arrJsonModel,index){
	for(j=startI;j<endI;j++){
		var varN = parseInt(eval("arrJsonModel[index].N"+j));
		$("#tbNum"+j).val("");
		if(varN > 0){
			$("#tbNum"+j).val(varN);
		}
	}
	$("#tbID").val(arrJsonModel[index].ID);
}
function chgModel(index){
	init();
	if(resultJsonModel != null){
		var arrJsonModel = resultJsonModel.arrJsonModel;
		chgModelNum(arrJsonModel,index);
	}
	sum();
}
function chgModel2(index){
	init();
	var modelID = document.getElementById("tbModelID").options[index].value;
	//var modelID = index;
	$("#tbID").val('');
	document.getElementById("names").value = document.getElementById("tbModelID").options[index].text;	
	var flag = false;
	if(resultJsonModel != null){
		var arrJsonModel = resultJsonModel.arrJsonModel;
		for(i=0;i<arrJsonModel.length;i++){
			if(arrJsonModel[i].modelID==modelID){
				flag = true;
				index = i;
			}
		}
		if(flag){
			chgModelNum(arrJsonModel,index);
		}
	}
	sum();
}
function chkInsert(){
	if(chkInt($("#tbTotalG1").html())==false){
		ShowMsg('对不起，请先选择您要参与的号码，并输入相应的乐豆数！');
		return false;
	}
}
function checkLedous(){
	if(maxD<allD){
		ShowMsg('对不起，最大可以参与'+maxD+'乐豆！');
		//$("#submitButton").show();
		return false;
	}
	else if(allD<1){
		ShowMsg('对不起，请先选择您要参与的号码，并输入相应的乐豆数！');
		//$("#submitButton").show();
		return false;
	}
	return true;
}
function checkLedou(){
	if(gg<allD){
		ShowMsg('对不起，您的乐豆不足！');
		//$("#submitButton").show();
		return false;
	}
	return checkLedous();
}
function getRefreshSeconds(game){
	var seconds=5000;
	if(game=="sfluck"||game=="jndluck"){
		seconds=10000;
	}
	return seconds;
}
var ajaxUrl = '/ajaxJC.php';
/*刷新返奖率*/
function reloadNow(){
	$.ajax({
		type: "POST",
		url: ajaxUrl,
		dataType: "json",
		data : "act=reload&game="+game+"&gameNO="+fTimingNO+"&key="+Math.random()+"&key2="+Math.random(),
		success: function(strJson){
			for(var i=startI;i<endI;i++){
				$("#rate_"+i).html(strJson[i]);
			}
		}
	});
}
//获取开奖数据
function reloadOpen(){
	console.log(isRefresh);
	$.ajax({
		type: "POST",
		url: ajaxUrl,
		dataType: "json",
		data : "act=svcopen&game="+game+"&key="+Math.random()+"&key2="+Math.random(),
		success: function(strJson){
			if(strJson==null){
				if(isRefresh==1){
					setTimeout('reloadOpen()',getRefreshSeconds(game));
				}
				return false;
			}
			changeAccount(strJson);
			$('.outcome').html('第'+strJson.issueNO+'期挑战结果：<span class="kj_text"><span class="ball white_ball">'+strJson.num1+'</span> + <span class="ball white_ball">'+strJson.num2+'</span> + <span class="ball white_ball">'+strJson.num3+'</span> = <span class="ball color_ball">'+strJson.issueNum+'</span></span>');
			if(strJson.six>0){
				$('.pig_main .publish_text').html('第'+strJson.issueNO+'开奖号码：<span>'+strJson.issueNum+'</span>');
				$('.pig_main .num_bg').text(strJson.issueNum);
				var lockK = game+strJson.issueNO;
				var lockKT = game+(strJson.issueNO-1);
				if(readCookie(lockK)!=1){
					createCookie(lockK,1,1);
					delCookie(lockKT);
					ball_down(1,strJson.issueNum);
					setTimeout(function(){ball_down(0,'?')},3000);
				}else{
					ball_down(0,'?');
				} 
				arrModel40 = eval(strJson.myLast);
				init();
			}
			fTimingNO = strJson.fTimingNO;
			//||fTimingSun=="insert.php"
			if((game=='sixpig'&&fTimingSun=="index.php")){
				$("#gameNO").val(strJson.fTimingNO);
			}
			if(fTimingSun=="autoSet.php" && $('.auto_btn').attr('data-val')=="0"){
				var startNO = parseInt(strJson.fTimingNO)+1;
				var endNO = parseInt(strJson.fTimingNO) + parseInt($("#tbNums").val());
				$("#tbStartNO").val(startNO);
				$(".startNO").text(startNO);
				$("#endNO").val(endNO);
			}
			if(isRefresh==1){
				ShowSecond(strJson.fTimingNO,strJson.fTimingSecond,strJson.fTimingBase);
			}
		}
	});
}
//展示模式
function showModelName(arrJsonModel){
	if(arrJsonModel==null){
		return false;
	}
	var vLeng = arrJsonModel.length;
	var vString = '';
	for(var i=0;i<vLeng;i++){
		if(game.indexOf("pig") != -1){
			console.log('pigm');
			$("#tbModelID").find("option[value='"+arrJsonModel[i].modelID+"']").text(arrJsonModel[i].modelName).attr('label',arrJsonModel[i].modelName);
		}else{
			vString += '<a href="javascript:;" id="diy'+arrJsonModel[i].ID+'" onClick="chgModel('+i+')" title="'+arrJsonModel[i].modelName+'"><span data-val="'+arrJsonModel[i].ID+'">x</span>'+arrJsonModel[i].modelName+'</a>';
		}
	}
	$('.diy_model_box').html(vString);
	return true;
}
//保存模式
function saveModel(){
	var regx=/^[\u4E00-\u9FA5A-Za-z0-9]+$/;
	var hID = parseInt($('#tbID').val());
	var names = $('#names').val();
	var vModel = $('#fModel').attr('data-val');
	$('#model_msg').html("");
	if(hID<1 && ( names==""||regx.test(names)==false||names.length<2 ) ){
		$('#names').focus();
		if(game.indexOf("pig") != -1){
			ShowMsg('亲，参与模式名称至少2个字符！');
		}else{
			$('#model_msg').html("亲，参与模式名称至少2个字符！").show();
		}
		return false;
	}
	var data = $('#fModel').serialize();
	$.ajax({
		type: "POST",
		url: ajaxUrl,
		dataType: "json",
		data : "act=svcsavemodel&game="+game+"&names="+names+"&key="+Math.random()+"&"+data+"&key1="+Math.random(),
		success: function(strJson){
			if(strJson.error==10007){
				location.href='/login.html';
				return true;
			}
			if(strJson.error==10000){
				if(vhref.indexOf("model") != -1){
					if(strJson.data!=null){
						resultJsonModel = strJson.data;
						showModelName(resultJsonModel.arrJsonModel);
						if(game.indexOf("pig") == -1){
							$(".list_content").mCustomScrollbar({});
							if(hID>0){
								$('#diy'+hID).addClass('active');
							}
						}
					}
					$('#tbID').val(strJson.ID);
				}else{
					$('#fModel').attr('data-val',"0");
				}			
			}
			if(game.indexOf("pig") != -1||vModel != "1"){
				ShowMsg(strJson.msg);
			}else{
				if(strJson.error==10000){
					$('#model_btn .bioati').hide();
					$('#saveModel').html("确定").attr('onclick',"hideLDdiv('model_btn')");
				}
				$('#model_msg').html(strJson.msg).show();
			}
			return true;
		}
	});
}
//删除模式
function delModel(ID){
	$.ajax({
		type: "POST",
		url: ajaxUrl,
		dataType: "json",
		data : "act=svcdelmodel&game="+game+"&ID="+ID+"&key="+Math.random(),
		success: function(strJson){
			if(strJson==null){
				return false;
			}
			if(strJson.error==10007){
				location.href="/login.html";
			}else{
				if(strJson.error==10000){
					$('#tbID').val('');
					init();
					if(game.indexOf("pig") != -1){
						pigSelect();
					}else{
						$('#diy'+ID).remove();
					}
				}
				ShowMsg(strJson.msg);
			}
		}
	});
}
function pigSelect(){
	var objSld = $('#tbModelID option:selected');
	var text = numToWord(objSld.val());
	objSld.text(text);
	objSld.attr('label',text);
	$('#names').val(text);
}
function myrefresh() {
	window.location.reload();
}
//自动检测
function keyup(obj){
	var _change = obj.value;
	var regInt = /^[1-9]{1}[0-9]*$/;
	if(_change && !regInt.test(_change)){
		obj.value=0;
	}
	return;
}

function checkSub(){
	if($("#modelID").val()==null){
		ShowMsg("请选择模式");
		return false;
	}
	keyup($("#tbStartNO"));
	var val = $("#tbStartNO").val();
	var startNO = parseInt($("#startNO").text());
	if(val<startNO){
		ShowMsg("开始期号必须大于或等于"+startNO);
		return false;
	}
	keyup($("#tbNums"));
	var nums = $("#tbNums").val();
	if(nums<1||nums>maxPeriods){
		ShowMsg("参与期数区间为1到"+maxPeriods);
		return false;
	}
	return true;
}
var arrModel40 = new Array();//上期
var arrModel41 = new Array();//当期
var vhref = location.href;//当前页面

$(window).load(function () {
	// 自动检测
	$("#tbStartNO").blur(function(){
		keyup($(this));
		var val = $(this).val();
		var startNO = parseInt($("#startNO").text());
		if(val<startNO){
			$(this).focus();
			ShowMsg("开始期号必须大于或等于"+startNO);
			return false;
		}
	});
	$("#tbNums").blur(function(){
		keyup($(this));
		var val = parseInt($(this).val());
		if(val<1){
			ShowMsg("参与期数区间为1到"+maxPeriods);
			$(this).val(1);
			$(this).focus();
			return false;
		}
		if(val>maxPeriods){
			ShowMsg("参与期数区间为1到"+maxPeriods);
			$(this).val(maxPeriods);
			$(this).focus();
			return false;
		}
		var endNO = parseInt($('#tbStartNO').val())+val-1;
		$("#endNO").text(endNO);
	});
	$("#modelID").change(function(){
		var mID = $(this).val();
		$('#tbModelD').html($("#model"+mID+" .chi").html());
	});
	$('#tbModelD').html($("#model"+$("#modelID").val()+" .chi").html());
	$('#tbStartNO,#tbNums').on("keyup blur",function(){
		var startNO = parseInt($('#tbStartNO').val()),nums = parseInt($('#tbNums').val()),endNO = startNO+nums-1;
		$("#endNO").text(endNO);
	});
	//自动结束
	// 喇叭icon
	$('.js_video_btn').click(function () {
		var vbtn = parseInt($(this).attr('data-val'));
		if(vbtn==2){
			$('.js_video_btn').removeClass('video_icon2');
			$('.js_video_btn').addClass('video_icon1');
			vbtn = 1;
		}else{
			$('.js_video_btn').removeClass('video_icon1');
			$('.js_video_btn').addClass('video_icon2');
			vbtn = 2;
		}
		setCookie(fTimingKey,vbtn);
		$('.js_video_btn').attr('data-val',vbtn);
	});
	if(readCookie(fTimingKey)==1){
		$('.js_video_btn').removeClass('video_icon2');
		$('.js_video_btn').addClass('video_icon1');
	}
    // $('.diy_model_box a span').click(function (e) { //原直接删除js
    //     e.stopPropagation();
		// delModel(parseInt($(this).attr('data-val')));
    // });
    $('.diy_model_box a span').click(function (e) { //新删除弹窗
        e.stopPropagation();
        $('.delete_alert span').html($(this).attr('data-name'));
        $('.delete_alert .delete_sure').attr('data-val',parseInt($(this).attr('data-val')));
        $('.delete_alert').show();
    });
    $('.delete_sure').click(function (e) { //新删除弹窗确认删除
        e.stopPropagation();
        $('.delete_alert').hide();
        delModel(parseInt($(this).attr('data-val')));
    });
    $('.js_close').click(function (e) { //新删除弹窗取消隐藏
        e.stopPropagation();
        $('.delete_alert').hide();
    });
	$(".bet_sure_btn").click(function(){
		var vstate = $(this).attr('data-state');
		if(vstate!="0"||$('#msg_btn').css('display')!='none'){
			return false;
		}
		var totalD = parseInt($('#tbTotalG1').text());
		if(totalD<1){
			ShowMsg('对不起，请先选择您要参与的结果，并输入相应的乐豆数！');
			return false;
		}
		$(this).attr('data-state','1');
		var data = $('#fInsert').serialize();
		//console.log(data);
		$.ajax({
			type: "POST",
			url: ajaxUrl,
			dataType: "json",
			data : "act=svcBetting&game="+game+"&key="+Math.random()+"&"+data,
			success: function(strJson){
				if(strJson==null){
					return false;
				}
				$(".bet_sure_btn").attr('data-state','0');
				if(strJson.error==10007){
					location.href='/login.html';
					return false;
				}else{
					if(strJson.error==10000){
						changeAccount(strJson);
						if(game.indexOf("pig") != -1){
							$('.pig_bg .bet_text').removeClass('bet_color');
						}else{
							$('.queding1').attr('href',strJson.url);
						}
					}
					ShowMsg(strJson.msg);
				}
			}
		});
	});
	//console.log(fTimingKey+"="+readCookie(fTimingKey));
});

