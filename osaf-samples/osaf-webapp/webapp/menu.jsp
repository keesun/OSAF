<%@page contentType="text/html; charset=euc-kr" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
		<title>Untitled Document</title>
		<link rel="stylesheet" media="screen" type="text/css" href="css/base.css" />
		<script language="JavaScript" src="/js/prototype-1.6.x.js"></script>
		<script language="JavaScript" src="/js/osaf.js"></script>
		<style>
			#menu { margin-left: 5px; margin-right: 5px; border: #dbdce3 solid 1px; width: 120px; }
			#menu ul li { line-height: 25px; }
			#menu ul li a { padding-left: 22px; color: #637b89; text-decoration: none; font-weight: bold;}
			#menu ul li ul { display:none; }
			#menu ul li ul li { background-color: #e9f9ff; padding-left: 7px; line-height: 20px; } 
			#menu ul li ul li a { padding-left: 15px; color: #555; text-decoration: none; font-weight: normal;}
			
		</style>
	</head>
	<body>
		<div id="menu">
			<ul>
				<li style="background: #c3ebf9 url(images/l1-inbox.png) no-repeat">
					<a href="javascript:void(0)" onclick="toggledisplay('base');">샘플메뉴</a>
					<ul id="base">
						<li><a href="task/search.do" target="content">작업관리</a></li>
						<li><a href="employee/search.do" target="content">사원관리</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</body>
</html>

