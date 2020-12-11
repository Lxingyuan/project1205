<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Colorlib Balita — Minimal Blog Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300, 400,700" rel="stylesheet">

    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/animate.css">
    <link rel="stylesheet" href="static/css/owl.carousel.min.css">

    <link rel="stylesheet" href="static/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="static/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/fonts/flaticon/font/flaticon.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="static/css/style.css">

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style type="text/css">
        .pic {
            width: 100%;
        }

        #slidershow {
            width: 100%;
            height: 650px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" style="margin: 0;">
    <div class="container-fluid" style="display: block">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">网站首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" style="display: block">
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
            <ul class="nav navbar-nav navbar-right"  style="display: block">
                <li><img src="//static.hdslb.com/images/akari.jpg" style="width: 50px;height: 50px"></li>
                <li><a href="#">注册</a></li>
                <li><a href="#">登录</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<header role="banner">
    <div class="container logo-wrap">
        <div class="row pt-5">
            <div class="col-12 text-center">
                <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button" aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
                <h1 class="site-logo"><a href="index.html">Best Movie To You</a></h1>
            </div>
        </div>
    </div>

</header>
<!-- END header -->

<section class="site-section pt-5">
    <div class="container">
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


</section>
<!-- END section -->

<section class="site-section py-sm">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 class="mb-4">热门影片</h2>
            </div>
        </div>
        <div class="row blog-entries">
            <div class="col-md-12 col-lg-8 main-content">
                <div class="row">
                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_5.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Food</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_6.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Travel</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>

                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_7.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Travel, Asia</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_8.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Travel</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>

                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_9.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Travel</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_10.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Lifestyle</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>

                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_11.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Lifestyle</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6">
                        <a href="blog-single.html" class="blog-entry element-animate fadeIn element-animated" data-animate-effect="fadeIn">
                            <img src="static/images/img_12.jpg" alt="Image placeholder">
                            <div class="blog-content-body">
                                <div class="post-meta">
                                    <span class="category">Food</span>
                                    <span class="mr-2">March 15, 2018 </span> •
                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                </div>
                                <h2>There’s a Cool New Way for Men to Wear Socks and Sandals</h2>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 text-center">
                        <nav aria-label="Page navigation" class="text-center">
                            <ul class="pagination">
                                <li class="page-item  active"><a class="page-link" href="#">Prev</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>






            </div>

            <!-- END main-content -->

            <div class="col-md-12 col-lg-4 sidebar">
                <div class="sidebar-box search-form-wrap">
                    <form action="#" class="search-form">
                        <div class="form-group">
                            <span class="icon fa fa-search"></span>
                            <input type="text" class="form-control" id="s" placeholder="Type a keyword and hit enter">
                        </div>
                    </form>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <div class="bio text-center">
                        <img src="static/images/person_1.jpg" alt="Image Placeholder" class="img-fluid">
                        <div class="bio-body">
                            <h2>Meagan Smith</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem facilis sunt repellendus excepturi beatae porro debitis voluptate nulla quo veniam fuga sit molestias minus.</p>
                            <p><a href="#" class="btn btn-primary btn-sm">Read my bio</a></p>
                            <p class="social">
                                <a href="#" class="p-2"><span class="fa fa-facebook"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-twitter"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-instagram"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-youtube-play"></span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <h3 class="heading">Popular Posts</h3>
                    <div class="post-entry-sidebar">
                        <ul>
                            <li>
                                <a href="">
                                    <img src="static/images/img_2.jpg" alt="Image placeholder" class="mr-4">
                                    <div class="text">
                                        <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                                        <div class="post-meta">
                                            <span class="mr-2">March 15, 2018 </span> •
                                            <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="static/images/img_4.jpg" alt="Image placeholder" class="mr-4">
                                    <div class="text">
                                        <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                                        <div class="post-meta">
                                            <span class="mr-2">March 15, 2018 </span> •
                                            <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <img src="static/images/img_12.jpg" alt="Image placeholder" class="mr-4">
                                    <div class="text">
                                        <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                                        <div class="post-meta">
                                            <span class="mr-2">March 15, 2018 </span> •
                                            <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Categories</h3>
                    <ul class="categories">
                        <li><a href="#">Courses <span>(12)</span></a></li>
                        <li><a href="#">News <span>(22)</span></a></li>
                        <li><a href="#">Design <span>(37)</span></a></li>
                        <li><a href="#">HTML <span>(42)</span></a></li>
                        <li><a href="#">Web Development <span>(14)</span></a></li>
                    </ul>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Tags</h3>
                    <ul class="tags">
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                    </ul>
                </div>
            </div>
            <!-- END sidebar -->

        </div>
    </div>
</section>

<footer class="site-footer">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-4">
                <h3>热门影评</h3>
                <p>
                    <img src="static/images/img_1.jpg" alt="Image placeholder" class="img-fluid">
                </p>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi, accusantium optio unde perferendis eum illum voluptatibus dolore tempora, consequatur minus asperiores temporibus reprehenderit.</p>
            </div>
            <div class="col-md-6 ml-auto">
                <div class="row">
                    <div class="col-md-7">
                        <h3>Latest Post</h3>
                        <div class="post-entry-sidebar">
                            <ul>
                                <li>
                                    <a href="">
                                        <img src="static/images/img_6.jpg" alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">March 15, 2018 </span> •
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="static/images/img_3.jpg" alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">March 15, 2018 </span> •
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="static/images/img_4.jpg" alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">March 15, 2018 </span> •
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                    <div class="col-md-4">

                        <div class="mb-5">
                            <h3>Quick Links</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Travel</a></li>
                                <li><a href="#">Adventure</a></li>
                                <li><a href="#">Courses</a></li>
                                <li><a href="#">Categories</a></li>
                            </ul>
                        </div>

                        <div class="mb-5">
                            <h3>Social</h3>
                            <ul class="list-unstyled footer-social">
                                <li><a href="#"><span class="fa fa-twitter"></span> Twitter</a></li>
                                <li><a href="#"><span class="fa fa-facebook"></span> Facebook</a></li>
                                <li><a href="#"><span class="fa fa-instagram"></span> Instagram</a></li>
                                <li><a href="#"><span class="fa fa-vimeo"></span> Vimeo</a></li>
                                <li><a href="#"><span class="fa fa-youtube-play"></span> Youtube</a></li>
                                <li><a href="#"><span class="fa fa-snapchat"></span> Snapshot</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright ©<script>document.write(new Date().getFullYear());</script>20202020 All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
        </div>
    </div>
</footer>
<!-- END footer -->

<!-- loader -->
<div id="loader" class="fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"></circle><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"></circle></svg></div>

<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/jquery-migrate-3.0.0.js"></script>
<script src="static/js/popper.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/owl.carousel.min.js"></script>
<script src="static/js/jquery.waypoints.min.js"></script>
<script src="static/js/jquery.stellar.min.js"></script>

<script src="static/js/main.js"></script>

</body>
</html>
