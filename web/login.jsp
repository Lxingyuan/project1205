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
            //判断字符串是否为空
            function isEmptyOrBlank(str) {
                if (str == null || str.length == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            //用户名
            function AccountName() {
                var $accN = $("#username").val();
                if (!isEmptyOrBlank($accN)) {	//不为空
                    var $zz = /^[a-zA-Z]{1}\w{3,15}$/;
                    if (!$zz.test($accN)) {
                        $("#user_prompt").html("用户名由英文字母和数字组成的4-16位字符，以字母开头");
                        return false;
                    } else {
                        return true;
                    }
                } else {			//为空
                    return false;
                }
            }
            //手机号
            function AccountTel() {
                // alert("开始检测手机号")
                var $accN = $("#telephone").val();
                if (!isEmptyOrBlank($accN)) {	//不为空
                    var $zz = /^1[3-9]\d{9}$/;
                    if (!$zz.test($accN)) {
                        $("#telephone_prompt").html("手机格式不正确！");
                        //$("#telephone_prompt").show();
                        return false;
                    } else {
                        return true;
                    }
                } else {			//为空
                    return false;
                }
            }

            //密码
            function password() {
                var $password = $("#password").val();
                if (!isEmptyOrBlank($password)) {
                    var $zz = /^\w{4,10}$/;
                    if (!$zz.test($password)) {
                        $("#pwd_prompt").show();
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    $("#pwd_prompt").show();
                    return false;
                }
            }

            //用户名
            $("#username").bind("focus", function () {
                $("#user_prompt").hide();
            });
            $("#username").bind("blur", function () {
                //AccountName();
                if (AccountName() == true) {//格式正确
                    //$("#user_prompt").show();
                    var username = $("#username").val();
                    $.ajax({
                        url: "/user.do",//TODO:添加Servlet url-pattern
                        data: {action: "queryUserByUsername", username: username},
                        type: "GET",
                        dataType: "text",//返回的数据类型
                        success: function (data) {
                            //data代表服务器回传的数据
                            console.log(data);
                            if (data == "true") {
                                $("#user_prompt").html("<font color=\"green\">用户名可用!</font>");
                            }
                            else {
                                $("#user_prompt").html("<font color=\"red\">用户名已存在!</font>");
                            }
                            $("#user_prompt").show();
                        }
                    });
                } else {//格式不正确
                    $("#user_prompt").show();
                    return false;
                }
            });
            //手机
            $("#telephone").bind("focus", function () {
                $("#telephone_prompt").hide();
            });
            $("#telephone").bind("blur", function () {
                //telephone();
                if (AccountTel() == true) {//格式正确
                    //$("#user_prompt").show();
                    var telephone = $("#telephone").val();
                    $.ajax({
                        url: "/user.do",//TODO:添加Servlet url-pattern
                        data: {action: "queryUserByTelephone", telephone: telephone},
                        type: "GET",
                        dataType: "text",//返回的数据类型
                        success: function (data) {
                            //data代表服务器回传的数据
                            console.log(data);
                            if (data == "true") {
                                $("#telephone_prompt").html("<font color=\"green\">手机号可用!</font>");
                            }
                            else {
                                $("#telephone_prompt").html("<font color=\"red\">手机号已存在!</font>");
                            }
                            $("#telephone_prompt").show();
                        }
                    });
                } else {//格式不正确
                    $("#telephone_prompt").show();
                    return false;
                }
            });
            //密码
            $("#password").bind("focus", function () {
                $("#pwd_prompt").hide();
            });
            $("#password").bind("blur", function () {
                password();
            });

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
                <input class="form-control" placeholder="请输入用户名" name="username" id="username">
            </div>
            <span id="user_prompt" class="sp2" >用户名由英文字母和数字组成的4-16位字符，以字母开头</span>
            <div class="div4">
                <span>手机号:</span>
                <input class="form-control" placeholder="请输入手机号" name="telephone" id="telephone">
            </div>
            <span id="telephone_prompt" class="sp2" ></span>
            <div class="div4">
                <span>密码:</span>
                <input class="form-control" placeholder="请输入密码" name="password" type="password" id="password">
            </div>
            <div class="div4">
                <span>验证码:</span>
                <input class="form-control input1" placeholder="请输入验证码" name="code" id="code">
                <button type="button" class="btn btn-default">获取验证码</button>
            </div>
            <button id="submitButton" type="submit" class="btn btn-lg btn-success" style="width: 300px;margin-left: 84px;margin-top: 50px">注册</button>

        </form>
    </div>
</div>



<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
