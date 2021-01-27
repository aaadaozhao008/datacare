<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<HTML>
<BODY>
	<Font Size=3> 
	<%!
	TreeSet<String> dictionary= new TreeSet<String>();
	public void addWord(String s){
		String[] word = {"1","2"};
		if(s != null){
			word= s.split(" ");
		}
		for(int i = 0;i<word.length;i++){
				dictionary.add(word[i]);
			}
		}
		%>
 <%
		String str =request.getParameter("word");
		addWord(str);
		Iterator<String>te=dictionary.iterator();
		while(te.hasNext()){
			String word=te.next();
			out.print(""+word);
		}
%>
	</FONT>
</BODY>
</HTML>