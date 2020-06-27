<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>登录 </title>
	<link rel="stylesheet" type="text/css" href="login/css/bootstrap-grid.min.css" /><!--CSS RESET-->
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="login/css/htmleaf-demo.css"><!--演示页面样式，使用时可以不引用-->
	<style>
		.demo{ padding: 20px 0;background: linear-gradient(to right,#7AB6B6 50%, #E5CFAA 50%); }

		.form-horizontal{
			background-color: #fff;
			font-family: 'Arimo', sans-serif;
			text-align: center;
			padding: 50px 30px 50px;
			box-shadow: 12px 12px 0 0 rgba(0,0,0,0.3);
		}

		.form-horizontal .heading{
			color: #555;
			font-size: 30px;
			font-weight: 600;
			letter-spacing: 1px;
			text-transform: capitalize;
			margin: 0 0 50px 0;
		}

		.form-horizontal .form-group{
			margin: 0 auto 30px;
			position: relative;
		}

		.form-horizontal .form-group:nth-last-child(2){ margin-bottom: 20px; }

		.form-horizontal .form-group:last-child{ margin: 0; }

		.form-horizontal .form-group>i{
			color: #999;
			transform: translateY(-50%);
			position: absolute;
			left: 5px;
			top: 50%;
		}

		.form-horizontal .form-control{
			color: #7AB6B6;
			background-color: #fff;
			font-size: 17px;
			letter-spacing: 1px;
			height: 40px;
			padding: 5px 10px 2px 25px;
			box-shadow: 0 0 0 0 transparent;
			border: none;
			border-bottom: 1px solid rgba(0,0,0,0.1);
			border-radius: 0;
			display: inline-block;
		}

		.form-control::placeholder{
			color: rgba(0,0,0,0.2);
			font-size: 16px;
		}

		.form-horizontal .form-control:focus{
			border-bottom: 1px solid #7AB6B6;
			box-shadow: none;
		}

		.form-horizontal .btn{
			color: #7AB6B6;
			background-color: #EDF6F5;
			font-size: 18px;
			font-weight: 700;
			letter-spacing: 1px;
			border-radius: 5px;
			width: 50%;
			height: 45px;
			padding: 7px 30px;
			margin: 0 auto 25px;
			border: none;
			display: block;
			position: relative;
			transition: all 0.3s ease;
		}

		.form-horizontal .btn:focus,
		.form-horizontal .btn:hover{
			color: #fff;
			background-color: #7AB6B6;
		}

		.form-horizontal .btn:before,
		.form-horizontal .btn:after{
			content: '';
			background-color: #7AB6B6;
			height: 50%;
			width: 2px;
			position: absolute;
			left: 0;
			bottom: 0;
			z-index: 1;
			transition: all 0.3s;
		}

		.form-horizontal .btn:after{
			bottom: auto;
			top: 0;
			left: auto;
			right: 0;
		}

		.form-horizontal .btn:hover:before,
		.form-horizontal .btn:hover:after{
			height: 100%;
			width: 50%;
			opacity: 0;
		}

		.form-horizontal .create_account{
			color: #D6BC8B;
			font-size: 16px;
			font-weight: 600;
			display: inline-block;
		}

		.form-horizontal .create_account:hover{
			color: #7AB6B6;
			text-decoration: none;
		}
	</style>
	<style>
		/* .left{
            background-color: aliceblue;
            color:black;
            margin: 10px;
            padding: 10px
        }
        li{
            margin: 10px;
        } */
		#cl-dashboard {
			position: fixed;
			top: 30px;
			right: 30px;
			display:none;
		}

	</style>
</head>
<body>
<div class="htmleaf-container">

	<div class="demo form-bg">
		<div class="container">

			<div class="row">
				<div class="col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6">
					<form class="form-horizontal"action="/news/UserLogin">
						<div class="heading">新闻系统-RG1702-26-zhangminghao</div>
						<div class="heading">登录</div>
						<div class="form-group">
							<i class="fa fa-user"></i><input required name="user.name"  type="text" class="form-control" placeholder="Username" id="exampleInputEmail1">
						</div>
						<div class="form-group">
							<i class="fa fa-lock"></i><input required name="user.pass"  type="password" class="form-control" placeholder="Password"/>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default"><i class="fa fa-arrow-right"></i></button>
							<span>测试账户：<br>RG1702-26-zmh<br> 密码：123<br><a href="./login/reg.html" class="create_account">点这注册</a></span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</div>

</body>
</html>