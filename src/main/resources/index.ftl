<#-- @ftlvariable name="" type="com.kainos.training.dropwizard.login.frontends.views.LoginSuccessView" -->
<html xmlns="http://www.w3.org/1999/html">
	<head>
		<meta charset="UTF-8">
		<link href="/assets/stylesheets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<script src="/assets/javascripts/hello.js"></script>
	</head>
	
<main>

<ul>
	<#if frameworks??>
			<#list frameworks as framework>
			    <li>
			    	${framework.getFrameworkName()}
			    	</li> 
			</#list>
	<#else>
			<li>Go and get some friends....</li>
	</#if>
</ul>

</main>

</html>



