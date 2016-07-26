<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>VerifyCode</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
        var path="<%=path%>";
        $( document ).ready(function() {
            $("#codeImg").on("click",function(){
                $('#codeImg').prop('src',path+'/jcaptcha.jpg?nocache='+new Date().getTime());
            });
        });
    </script>
</head>
<body style="text-align: center;">
	<h2>Hello World!</h2>
	<form action="http://localhost:8080/IndianaServer/api/1/users"
		method="post">
		<span style="margin: 10px 0 0 10px; vertical-align: baseline;">请输入手机号：
			<input name="userAccount" type="text" />
		</span> <span style="margin: 10px 0 0 10px; vertical-align: baseline;">请输入密码：
			<input name="userPassword" type="text" />
		</span> <span style="margin: 10px 0 0 10px; vertical-align: baseline;">请输入验证码：
			<input name="jcaptcha" type="text" />
		</span> <input name="" type="submit" value="提交" />
	</form>

	<img id="codeImg"
		style="vertical-align: bottom; margin: 10px 0 0 10px; cursor: pointer;"
		alt="验证码" src="<%=path%>/jcaptcha.jpg">
</body>
</html>
