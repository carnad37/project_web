<%@page pageEncoding="euc-kr" contentType="text/html; charset=euc-kr" %>
<%
	if(session.getAttribute("uid")==null)
	{
		out.println("세션이 모두 삭제 되었습니다. 다시 인증하세요 ");
	}
	else
	{
		out.println("세션이 존재합니다. 인증없이 진행합니다. ");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=MS949"/>
<title></title>
</head>
<body>
main page
</body>
</html>
