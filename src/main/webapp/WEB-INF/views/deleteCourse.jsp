<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/7/26
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除课程信息</title>
</head>
<body>
    <form class="form" action="${pageContext.request.contextPath}/deleteCourse" method="post" id="deleteCou">
        课程号：<input type="text" name="courseNo" id="courseNo" value="${messageModel.object.courseNo}">
        <br>
        <span id="msg" style="font-size: 12px;color: #ff0000">${messageModel.msg}</span>
        <br>
        <input type="submit" value="提交" id="deleteBtn">
        <br><br>
        <a href="/courseView">返回</a>
    </form>
</body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">

    $("#deleteBtn").click(function () {
        var courseNo = $("#courseNo").val();

        if(isEmpty(courseNo)){
            alert("课程号不能为空！");
            return;
        }

        $("#deleteCou").submit();


    });

    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }


</script>

</html>
