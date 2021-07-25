<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/7/21
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>jQuery表格模糊搜索代码 - 站长素材</title>

    <style>
        .content {
            width: 600px;
            height: 600px;
            /* background: yellow; */
            margin: 50px auto;
        }
        #table-1 {
            width: 500px;
            line-height: 35px;

        }

        #lin {
            margin: 20px 0;
            height: 30px;
            padding: 5px;
            box-sizing: border-box;
        }
    </style>

</head>
<body>

<div class="content">

    <input type="text" id="lin" placeholder="请输入需要搜索的内容">
    <a href="/userView">查询学生</a>
    <a href="/turnToAddStudent" >添加学生</a>
    <a href="/turnToDeleteStudent">删除学生</a>
    <a href="/turnToUpdateStudent">更新学生信息</a>

    <table id="table-1" cellspacing='0' border="1" style="text-align: center;">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>    </th>
        </tr>

        <c:forEach items="${studentList}" var="b">
            <tr>
                <td>${b.studentNo}</td>
                <td>${b.studentName}</td>
                <td>${b.gender}</td>
                <td>${b.birthday}</td>
                <td><a href="/turnToUpdateStudent?studentNo=${b.studentNo}">修改</a></td>
            </tr>
        </c:forEach>


    </table>
</div>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/lin_search.js"></script>
<script type="text/javascript">
    var table = document.getElementById("table-1");
    var input = document.getElementById("lin");


    input.onkeyup = function () {
        new Search(table, input)
    }
</script>

</body>
</html>
