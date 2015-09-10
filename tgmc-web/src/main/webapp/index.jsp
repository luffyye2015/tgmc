<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.LineNumberReader"%>
<html>
<body>

<%
StringBuilder output=new StringBuilder();
String line="";
String[] cmds=new String[]{"/bin/sh","-c","pwd"};
Process process=Runtime.getRuntime().exec(cmds);
LineNumberReader br=new LineNumberReader(new InputStreamReader(process.getInputStream()));

while((line=br.readLine())!=null){
    output.append(line).append("\n");
}
%>
<h2>Hello World!</h2>

<%=output%>

</body>
</html>
