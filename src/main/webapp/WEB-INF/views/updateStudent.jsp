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
    <title>更新学生信息</title>
</head>
<body>
    <form class="form" action="${pageContext.request.contextPath}/updateStudent" method="post" id="updateStu">
        学号：<input type="text" name="studentNo" id="studentNo" value="${messageModel.object.studentNo}">
        <br>
        修改信息
        <br>
        姓名：<input type="text" name="studentName" id="studentName" value="${messageModel.object.studentName}">
        <br>
        性别：<input type="text" name="gender" id="gender" value="${messageModel.object.gender}">
        <br>
        出生日期：<input type="date" name="birthday" id="birthday" value="${messageModel.object.birthday}">
        <br>
        <input type="submit" value="确认修改" id="updateBtn">
        <br>
        <br>
        <span id="msg" style="font-size: 12px;color: #ff0000">${messageModel.msg}</span>
        <br>
        <a href="/userView">返回</a>

    </form>
</body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script>
    $("#updateBtn").click(function () {

        var studentNo = $("#studentNo").val();
        var studentName = $("#studentName").val();
        var gender = $("#gender").val();
        var birthday = $("#birthday").val();

        if(isEmpty(studentNo)){
            alert("学号不能为空！")
            return;
        }
        else {
            if (isEmpty(studentName)){
                alert("姓名不能为空！")
                return;
            }
            else {
                if(isEmpty(gender)){
                    alert("性别不能为空！")
                    return;
                }
                else {
                    if(isEmpty(birthday)){
                        alert("出生日期不能为空！")
                        return;
                    }
                }
            }
        }


        $("#updateStu").submit();

    });

    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }



</script>

</html>
