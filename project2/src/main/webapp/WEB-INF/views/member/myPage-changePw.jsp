<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 정보 페이지</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/myPage-style.css">
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="myPage-content">
            <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"/>
            
            <section class="myPage-main">
                <h1 class="myPage-title">비밀번호 변경</h1>
                <span class="myPage-subject">현재 비밀번호가 일치하는 경우 새 비밀번호로 변경할 수 있습니다.</span>
                <form action="changePw" method="post" name="myPage-frm" id="myPage-frm">
                    <div class="myPage-row">
                        <label>현재 비밀번호</label>
                        <input type="password" name="currentPw" maxlength="20">
                    </div>
                    <div class="myPage-row">
                        <label>새 비밀번호</label>
                        <input type="password" name="newPw"  maxlength="20">
                    </div>
                    <div class="myPage-row">
                        <label>새 비밀번호 확인</label>
                        <input type="password" name="newPwConfirm"  maxlength="20">
                    </div>
                    


                    <button class="myPage-submit">변경하기</button>
                </form>

            </section>

        </section>











    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>header.jsp include
        <!-- daum 주소 api 추가 -->
</body>
</html>