<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>学生主页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/aitehulian.min.css" />
	<link rel="stylesheet" type="text/css" href="css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="css/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="css/icheck.css" />
	<link rel="stylesheet" type="text/css" href="css/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	
	<script type="text/javascript" src="js/jquery.min.js"></script> 
	<script type="text/javascript" src="js/layer.js"></script> 
	<script type="text/javascript" src="js/H-ui.js"></script> 
	<script type="text/javascript" src="js/H-ui.admin.js"></script> 
	</head>
	<body>
		<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl">
				<a class="logo navbar-logo f-l mr-10 hidden-xs"
					href="/aboutHui.shtml">AiteHulian</a>
				<span class="logo navbar-slogan f-l mr-10 hidden-xs">v2.4</span>
				<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
					href="javascript:;">&#xe667;</a>
				<nav class="nav navbar-nav">
				<ul class="cl">
					<li class="dropDown dropDown_hover">
						<a href="javascript:;" class="dropDown_A">新增 </a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li>
								<a href="javascript:;"
									onclick="article_add('添加资讯','article-add.html')">留言</a>
							</li>
						</ul>
					</li>
				</ul>
				</nav>
				<nav id="Hui-userbar"
					class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li>
						学生
					</li>
					<li class="dropDown dropDown_hover">
						<a href="#" class="dropDown_A">student</a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li>
								<a href="EquryServlet">个人信息</a>
							</li>
							<li>
								<a href="#">切换账户</a>
							</li>
							<li>
								<a href="#">退出</a>
							</li>
						</ul>
					</li>
					<li id="Hui-msg">
						<a href="#" title="消息"><span class="badge badge-danger">1</span>
						</a>
					</li>
					<li id="Hui-skin" class="dropDown right dropDown_hover">
						<a href="javascript:;" class="dropDown_A" title="换肤">
						</a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li>
								<a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
							</li>
							<li>
								<a href="javascript:;" data-val="blue" title="蓝色">蓝色</a>
							</li>
							<li>
								<a href="javascript:;" data-val="green" title="绿色">绿色</a>
							</li>
							<li>
								<a href="javascript:;" data-val="red" title="红色">红色</a>
							</li>
							<li>
								<a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
							</li>
							<li>
								<a href="javascript:;" data-val="orange" title="绿色">橙色</a>
							</li>
						</ul>
					</li>
				</ul>
				</nav>
			</div>
		</div>
		</header>
		<aside class="Hui-aside">
		<input runat="server" id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2">
			<dl id="menu-article">
				<dt>
					<a href="EquryServlet" >个人信息管理</a>
				</dt>
			</dl>
			<dl id="menu-picture">
				<dt>
					 文件管理
				</dt>
			</dl>
			<dl id="menu-product">
				<dt>
					留言管理
				</dt>
			</dl>
			<dl id="menu-system">
				<dt>
					系统管理
				</dt>
				<dd>
					<ul>
						<li>
							<a _href="system-base.html" data-title="系统设置"
								href="javascript:void(0)">系统设置</a>
						</li>
						<li>
							<a _href="system-category.html" data-title="栏目管理"
								href="javascript:void(0)">栏目管理</a>
						</li>
						<li>
							<a _href="system-data.html" data-title="数据字典"
								href="javascript:void(0)">数据字典</a>
						</li>
						<li>
							<a _href="system-shielding.html" data-title="屏蔽词"
								href="javascript:void(0)">屏蔽词</a>
						</li>
						<li>
							<a _href="system-log.html" data-title="系统日志"
								href="javascript:void(0)">系统日志</a>
						</li>
					</ul>
				</dd>
			</dl>
		</div>
		</aside>
		
		<div class="dislpayArrow hidden-xs">
			<a class="pngfix" href="javascript:void(0);" onClick=displaynavbar(this);></a>
		</div>
		<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active">
						<span title="我的桌面" data-href="welcome.jsp">我的桌面</span><em></em>
					</li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i>
				</a><a id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i>
				</a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
			</div>
		</div>
		</section>
		<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
		<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
		<script type="text/javascript"
			src="static/h-ui.admin/js/H-ui.admin.js"></script>
		<script type="text/javascript">
	/*资讯-添加*/
	function article_add(title, url) {
		var index = layer.open( {
			type : 2,
			title : title,
			content : url
		});
		layer.full(index);
	}
	/*图片-添加*/
	function picture_add(title, url) {
		var index = layer.open( {
			type : 2,
			title : title,
			content : url
		});
		layer.full(index);
	}
	/*产品-添加*/
	function product_add(title, url) {
		var index = layer.open( {
			type : 2,
			title : title,
			content : url
		});
		layer.full(index);
	}
	/*用户-添加*/
	function member_add(title, url, w, h) {
		layer_show(title, url, w, h);
	}
</script>
		<script type="text/javascript">
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s)
	})();
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
			: " http://");
	document
			.write(unescape("%3Cscript src='"
					+ _bdhmProtocol
					+ "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
	</body>
</html>