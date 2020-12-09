<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/12/9
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册网站账号</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/favicon.ico" />
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="static/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript">
        $(function () {

        })
    </script>
    <style type="text/css">
        .content {
            width: 1920px;
            height: 1080px;
            background-image: url("./static/images/loginBackground.jpg");
            background-repeat: no-repeat;
            overflow-x: hidden;
        }
    </style>
</head>
<body>
<div class="content" >
    <div class="div1">
        <span><i><b>欢迎光临本网站</b></i></span>
    </div>
    <div class="div2">
        <span><i><b>注册后</b></i></span><br>
        <span><i><b>与网友畅所欲言！</b></i></span>
    </div>
    <div class="div3">
        <br>
        <h1>&nbsp;&nbsp;&nbsp;&nbsp;<b>欢迎注册</b></h1>
        <span class="sp1">已有账号?</span>
        <span><a href="#" style="text-decoration: none">登录</a></span>
        <form>
            <div class="div4">
                <span>用户名:</span>
                <input class="form-control" placeholder="请输入用户名" name="username">
            </div>
            <div class="div4">
                <span>手机号:</span>
                <input class="form-control" placeholder="请输入手机号" name="telephone">
            </div>
            <div class="div4">
                <span>密码:</span>
                <input class="form-control" placeholder="请输入密码" name="password" type="password">
            </div>
            <div class="div4">
                <span>验证码:</span>
                <input class="form-control input1" placeholder="请输入验证码" name="code" >
                <button type="button" class="btn btn-default">获取验证码</button>
            </div>
            <button id="submitButton" type="submit" class="btn btn-lg btn-success" style="width: 300px;margin-left: 81px;">注册</button>

        </form>
    </div>
</div>



<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
