<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		* {margin: 0; padding: 0;}
		div {padding: 30px 0; width: 250px; box-sizing: border-box;  border: 2px solid black; margin: 20px auto;text-align: center;}
		p {margin-top: 20px;}
		p:nth-of-type(1) {margin-top:0px;}
		p.return {margin-top: 20px;}
	  	a {text-decoration: none; color:black;}
 	 	a:hover {color:blue; font-weight: bold;}
 	 	ul {list-style-type: none;} 	 	
	</style>
</head>
<body>
	<div>
		<ul>
			<c:choose>
				<c:when test="${result eq 'INSERT'}">
					<li>${insert}</li>
				</c:when>					
				<c:when test="${result eq 'PRINT_FAIL'}">
					<li>등록되지 않은 이름입니다.</li>
				</c:when>
				<c:when test="${result eq 'PRINT_PASS'}">
					<li>
						<p> 이름 : ${student.name}</p>
						<p> 국어 : ${student.lan}</p>
						<p> 영어 : ${student.eng}</p>
						<p> 수학 : ${student.mat}</p>
						<p> 과학 : ${student.sci}</p>
						<p> 사회 : ${student.com}</p>
						<p> 음악 : ${student.mus}</p>
						<p> 체육 : ${student.phy}</p>				
					</li>
				</c:when>
				<c:when test="${result eq 'AVG_FAIL'}">
					<li>등록되지 않은 이름입니다.</li>
				</c:when>
				<c:when test="${result eq 'AVG_PASS'}">
					<li>
						<p> 이름 : ${name}</p>
						<p> 평균 : ${avg}</p>		
					</li>
				</c:when>
				<c:when test="${result eq 'RANK_FAIL'}">
					<li>등록되지 않은 이름입니다.</li>
				</c:when>
				<c:when test="${result eq 'RANK_PASS'}">
					<c:forEach var="student" items="${stuList}">
						<li><strong>이름</strong> : ${student.name}, <strong>석차</strong> : ${student.rank}</li>					
					</c:forEach>
				</c:when>
				<c:when test="${result eq 'SAVG_FAIL'}">
					<li>데이터 베이스 연결에 실패하였습니다.</li>					
				</c:when>
				<c:when test="${result eq 'SAVG_PASS'}">
					<li><strong>국어 평균</strong> : ${subAvg["AVG_LAN"]}</li>
					<li><strong>영어 평균</strong> : ${subAvg["AVG_ENG"]}</li>
					<li><strong>수학 평균</strong> : ${subAvg["AVG_MAT"]}</li>
					<li><strong>과학 평균</strong> : ${subAvg["AVG_SCI"]}</li>
					<li><strong>사회 평균</strong> : ${subAvg["AVG_COM"]}</li>
					<li><strong>음악 평균</strong> : ${subAvg["AVG_MUS"]}</li>
					<li><strong>체육 평균</strong> : ${subAvg["AVG_PHY"]}</li>
				</c:when>
			</c:choose>
		</ul>
		<p class="return"><a href="main.jsp">메인메뉴로 돌아가기</a></p>
	</div>
</body>
</html>