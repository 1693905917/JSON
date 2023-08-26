<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/12/10
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="./js/jquery-1.11.0.js"></script>
    <style>
        div {
            width: 500px;
            border: 3px solid green;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<input type="text" id="username"/>
<button onclick="search()">搜索</button>
<hr/>
<table border="1px">
    <thead>
    <td>id</td>
    <td>username</td>
    <td>password</td>
    <td>name</td>
    <td>age</td>
    <td>gender</td>
    <td>phone</td>
    </thead>
    <tbody id="tbody">

    </tbody>
</table>
</body>
</html>

<script>
    function search() {
        $("#tbody").empty();
        var username = $("#username").val();
        $.ajax(
            {
                url: '/loginServlet',
                type: 'get',
                data: {"username": username},
                success: function (data) {
                    var stuJson = eval(data);
                    for (var i = 0; i < stuJson.length; i++) {
                        // console.log(stuJson[i].id,stuJson[i].username);
                        var tr = "<tr>\n" +
                            "            <td>"+stuJson[i].id+"</td>\n" +
                            "            <td>"+stuJson[i].username+"</td>\n" +
                            "            <td>"+stuJson[i].password+"</td>\n" +
                            "            <td>"+stuJson[i].name+"</td>\n" +
                            "            <td>"+stuJson[i].age+"</td>\n" +
                            "            <td>"+stuJson[i].gender+"</td>\n" +
                            "            <td>"+stuJson[i].phone+"</td>\n" +
                            "        </tr>";
                            $("#tbody").append(tr);
                    }
                },
                dataType: 'json'
            }
        )
    }
</script>
