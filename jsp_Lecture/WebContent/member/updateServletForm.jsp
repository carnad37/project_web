<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//1. ����̹��ε�
//2. Ŀ�ؼ� ����
//3. paredStatmemt ��ü ����
//---  �˻� - password
//4. SQL �����  -SELECT pw FROM bmember WHERE id = '?'
//5. set �޼ҵ��  SQL ? ��  ä���
//6. executeQuery
//7. ������ ������ ResultSet ���� ��������
//8 �Էµ� �н������  ��񿡼� ������ �н����� ��
//9 SQL ����� - update bememer set name='?' where id='?'
//10. 9���� ? ä��� set method
//11. executeUpdate�� ����
//12. SQL ����� - id name ����� ����
//13. set �޼ҵ��  SQL ? ��  ä���
//14. executeQuery-SELECT id, name FROM bmember WHERE id = '?'
//15. ResultSet ��ü�� id, name ���
%>
</body>
</html>