<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网站首页</title>
    <style type="text/css">
        .pic{
            width: 100%;
        }

        #slidershow {
            width: 80%;
            height: 650px;
            margin: 0 auto;
        }

        #background {
            background-color: darkcyan;
        }
    </style>
    <script type="text/javascript" src="static/js/jquery-2.0.0.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-default" style="margin: 0;">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">网站首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">网站影评</a></li>
                <li><a href="#">电影海报</a></li>
                <li><a href="#">预告片</a></li>
                <li><a href="#">参与投票</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索热门电影">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><img src="//static.hdslb.com/images/akari.jpg" style="width: 50px;height: 50px"></li>
                <li><a href="#">注册</a></li>
                <li><a href="#">登录</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div id="background">
    <div class="carousel slide" id="slidershow" data-ride="carousel" data-interval="3000">
        <!--计数器-->
        <ol class="carousel-indicators">
            <li class="active" data-target="#slidershow" data-slide-to="0"></li>
            <li data-target="#slidershow" data-slide-to="1"></li>
            <li data-target="#slidershow" data-slide-to="2"></li>
            <li data-target="#slidershow" data-slide-to="3"></li>
            <li data-target="#slidershow" data-slide-to="4"></li>
        </ol>
        <!--图片容器-->
        <div class="carousel-inner">
            <div class="item active">
                <img src="./static/images/1.jpg" class="pic" style="height: 650px"/>
                <!--添加对应标题和内容-->
                <div class="carousel-caption">
                    <h4>图一</h4>
                    <span>内容</span>
                </div>
            </div>
            <div class="item">
                <img src="./static/images/2.jpg" class="pic" style="height: 650px"/>
                <!--添加对应标题和内容-->
                <div class="carousel-caption">
                    <h4>图二</h4>
                </div>
            </div>
            <div class="item">
                <img src="./static/images/3.jpg" class="pic" style="height: 650px"/>
                <!--添加对应标题和内容-->
                <div class="carousel-caption">
                    <h4>图三</h4>
                </div>
            </div>
            <div class="item">
                <img src="./static/images/4.jpg" class="pic" style="height: 650px"/>
                <!--添加对应标题和内容-->
                <div class="carousel-caption">
                    <h4>图四</h4>
                </div>
            </div>
            <div class="item">
                <img src="./static/images/5.jpg" class="pic" style="height: 650px"/>
                <!--添加对应标题和内容-->
                <div class="carousel-caption">
                    <h4>图五</h4>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
