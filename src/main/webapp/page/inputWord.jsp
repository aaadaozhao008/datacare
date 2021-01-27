<%@ page contentType ="text/html;charset=UTF-8" %>
<HTML>
<BODY bgcolor = cyan>
<FONT size=3>
<FROM size=3>
	<!-- <FROM action="showDictionary.jsp" mehthod=get name=form>
	请输入单词（用空格分隔）:<INPUT type=text" name="word">
	<BR><INPUt TYPE="submit" value="送出" name=submit>
	</FORM> -->
	请输入单词（用空格分隔）:<INPUT id="abc" type=text" name="word">
	<script type="text/javascript">
// 	var abc = $("#abc").val();
	var abc = document.getElementById("abc");
	function good(){
		window.location.href = "showDictionary.jsp?word="+abc.value;
	};
	</script>
	<BR><button  onclick="good()">送出</button>
</BODY>
</HTML>