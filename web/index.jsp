<%--
  User: ants_ypc
  Date: 6/29/16
  Time: 4:55 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  用户名
<input id="username">
  密码
  <input id="password">
  <button id="login">管理员登陆</button>
  </body>
  <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
  <script type="text/javascript">

      $("#login").on('click',function() {
          var password = $("#password").val();
          var username = $("#username").val();

          var data = {
              username : username,
              password : password
          };
          data = JSON.stringify(data);
          $.ajax({
              type:"POST",
              contentType:"application/json",
              dataType:"json",
              data: data,
              url:"/logging/admin/login",
              success : function(data) {
                  console.log(data);
              },
              error: function(data) {
                  console.log(data);
              }
          });
          return false;
      });
  </script>


</html>
