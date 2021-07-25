<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/7/25
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">

<head>
    <title>Home</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""
    />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="css/style_new.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link rel="stylesheet" href="css/fontawesome-all.css">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->
    <!-- web-fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <!-- //web-fonts -->
</head>

<body>
<!-- bg effect -->
<div id="bg">
    <canvas></canvas>
    <canvas></canvas>
    <canvas></canvas>
</div>
<!-- //bg effect -->
<!-- title -->
<h1>Effect Login Form</h1>
<!-- //title -->
<!-- content -->
<div class="sub-main-w3">
    <form action="${pageContext.request.contextPath}/login2" method="post" id="loginForm">
        <h2>Login Now
            <i class="fas fa-level-down-alt"></i>
        </h2>
        <div class="form-style-agile">
            <label>
                <i class="fas fa-user"></i>
                Username
            </label>
            <input placeholder="Username" name="Name" type="text" id="uname" required="" value="${messageModel.object.userName}">
        </div>
        <div class="form-style-agile">
            <label>
                <i class="fas fa-unlock-alt"></i>
                Password
            </label>
            <input placeholder="Password" name="Password" type="password" id="upwd" required="" value="${messageModel.object.userPwd}">
        </div>
        <!-- checkbox -->
        <div class="wthree-text">
            <ul>
                <li>
                    <label class="anim">
                        <input type="checkbox" class="checkbox" required="">
                        <span>Stay Signed In</span>
                    </label>
                </li>
                <li>
                    <a href="register2.jsp">没有账号?</a>
                </li>
            </ul>
        </div>
        <!-- //checkbox -->
        <input type="submit" value="Log In" id="loginBtn">
        <span id="msg" style="font-size: 12px;color: #ff0000">${messageModel.msg}</span> <br>
    </form>
</div>
<!-- //content -->

<!-- copyright -->
<div class="footer">
    <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
</div>
<!-- //copyright -->

<!-- Jquery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- //Jquery -->

<!-- effect js -->
<script src="js/canva_moving_effect.js"></script>
<!-- //effect js -->

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">



    $("#loginBtn").click(function () {
        //获取用户名和密码
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();

        if(isEmpty(uname)){
            // $("#msg").html("用户名不能为空！");
            alert("用户名不能为空！");
            return;
        }
        else {
            if(isEmpty(upwd)){
                // $("#msg").html("密码不能为空！");
                alert("密码不能为空！");
                return;
            }
        }

        <%--if(code != "" && code != "1"){--%>
        <%--    alert("${messageModel.msg}");--%>
        <%--}--%>

        $("#loginForm").submit();


    });



    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }

</script>

</body>

</html>
