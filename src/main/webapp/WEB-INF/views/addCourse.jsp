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
    <title>添加课程信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addCourse" method="post" id="addCou">
        课程号：<input type="text" name="courseNo" id="courseNo" value="${messageModel.object.courseNo}">
        <br>
        课程名称:<input type="text" name="courseName" id="courseName" value="${messageModel.object.courseName}">
        <br>
        学时：<input type="number" name="hour" id="hour" value="${messageModel.object.hour}">
        <br>
        学分：<input type="number" name="credit" id="credit" value="${messageModel.object.credit}">
        <br>
        <input type="submit" value="提交" id="addBtn">
        <br>
        <span id="msg" style="font-size: 12px;color: #ff0000">${messageModel.msg}</span>
        <br>
        <a href="/courseView">返回</a>
        <br>
    </form>
</body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">
    $("#addBtn").click(function () {
        var courseNo = $("#courseNo").val();
        var courseName = $("#courseName").val();
        var hour = $("#hour").val();
        var credit = $("#credit").val();

        if(isEmpty(courseNo)){
            alert("课程号不能为空！");
            return;
        }
        else if(isEmpty(courseName)){
            alert("课程名不能为空！");
            return;
        }
        else if(isEmpty(hour)){
            alert("学时不能为空！")
            return;
        }
        else if(isEmpty(credit)){
            alert("课程学分不能为空！");
            return;
        }

        $("#addCou").submit();

    });

    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }

</script>

</html>
