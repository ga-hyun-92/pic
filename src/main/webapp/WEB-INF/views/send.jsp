<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>사진 전송 페이지</h1>
    <!--form태그는 기본으로 application/x-www-form-urlencoded 타입이 날라간다. 
        기본 input이면? 굳이 안적어도 됨-->
    <!-- enctype="multipart/form-data" : 사진 전송하는 타입 , 
        원래 의미는 여러가지 타입이 들어갈때 사용!-->
    <form method="post" action="/image" enctype="multipart/form-data">
        <input type="file" name="pic" />
        <button>사진전송</button>
    </form>
</body>
</html>