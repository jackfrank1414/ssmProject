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
    <title>添加学生</title>
</head>
<body>
    <form class="form" action="${pageContext.request.contextPath}/addStudent" method="post" id="addStu">
        学号：<input type="text" name="studentNo" id="studentNo" value="${messageModel.object.studentNo}">
        <br>
        姓名：<input type="text" name="studentName" id="studentName" value="${messageModel.object.studentName}">
        <br>
        性别：<input type="radio" name="gender"  id="male" value="男" checked="checked">男
             <input type="radio" name="gender" id="female" value="女">女
        <br>
        出生日期：<input type="date" name="birthday" id="birthday" value="${messageModel.object.birthday}">
        <br>
        <br>
        <input type="submit" value="提交" id="addBtn">
        <br>
        <br>
        <span id="msg" style="font-size: 12px;color: #ff0000">${messageModel.msg}</span>
        <br>
        <br>
        <a href="/userView">返回</a>
    </form>

</body>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">

    $("#addBtn").click(function (){
        var studentNo = $("#studentNo").val();
        var studentName = $("#studentName").val();

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
                if(isEmpty(birthday)){
                    alert("出生日期不能为空！")
                    return;
                }
            }
        }
        if(!isValidGender(gender)){
            alert("性别格式不正确！")
            return;
        }

        $("#addStu").submit();

    });

    function isEmpty(str) {
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }

    function isValidGender(str) {
        if(str == null || "".equals(str.trim()) || "M".equals(str) || "F".equals(str) || "男".equals(str) || "女".equals(str) || "male".equals(str) || "Male".equals(str) || "female".equals(str) || "Female".equals(str)){
            return true;
        }
        else {
            return false;
        }
    }


</script>
</html>
