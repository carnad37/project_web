<%@page pageEncoding="euc-kr" contentType="text/html; charset=euc-kr" %>
<%
	if(session.getAttribute("uid")==null)
	{
		out.println("������ ��� ���� �Ǿ����ϴ�. �ٽ� �����ϼ��� ");
	}
	else
	{
		out.println("������ �����մϴ�. �������� �����մϴ�. ");
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
