<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/7/22
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
    <h1>删除学生</h1>
    <form class="form" action="${pageContext.request.contextPath}/deleteStudent" method="post" id="deleteStu">
        学号：<input type="text" name="studentNo" id="studentNo" value="${messageModel.object.studentNo}">
        <br>
        <span id="msg" style="font-size: 12px;color: #ff0000">${messageModel.msg}</span>
        <br>
        <input type="submit" value="提交" id="deleteBtn">
        <br><br>
        <a href="/userView">返回</a>
    </form>
</body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">

    $("#deleteBtn").click(function () {
        var studentNo = $("#studentNo").val();

        if(isEmpty(studentNo)){
            alert("学号不能为空！")
            return;
        }

        $("#deleteStu").submit();

    });

    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }

</script>

</html>
