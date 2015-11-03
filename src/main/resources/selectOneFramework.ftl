<!DOCTYPE html>
<html>
<head>
<title>KTech</title>
<link rel="stylesheet" type="text/css"
	href="/assets/stylesheets/styles.css" />
</head>
<body>
	<header>
		<div class="clearfix">



			<div class="logo pull-left">
				<h1 class="heading-one">
					KTech<span>Matrix</span>
				</h1>
			</div>

			<nav class="pull-left">

				<ul>

					<li class="image-replace technolgies active has-tip"
						data-tip="Technolgies">Technologies</li>
					<!--Enable if search functionaltiy is played-->
					<!--                    <li class="image-replace search">Search</li>-->

				</ul>
			</nav>
		</div>
	</header>
	<main>
	<div class="container">




		<div class="row clearfix">
			<p>
				<a href="/frameworksList" class="breadcrumb-item"><span>&#10094</span>Back</a>
			</p>
			<h1 class="heading-two pull-left">${framework.getFrameworkName()}</h1>
			<dl class="pull-left">
				<div class="dl-group pull-left">
					<dt class="uppercase pull-left">Vendor</dt>
					<dd class="pull-left">${framework.getVendor()}</dd>
				</div>
				<div class="dl-group pull-left">
					<dt class="uppercase pull-left">Licenses</dt>
					<dd class="pull-left">${framework.getLicense()}</dd>
				</div>

				<div class="dl-group pull-left">
					<dt class="uppercase pull-left">Expert</dt>
					<dd class="pull-left">${framework.getExpert()}</dd>
				</div>

			</dl>
		</div>

		<div class="col-6">
			<h2 class="heading-three-view">Projects</h2>
			<#if projects?has_content>
			<table class="projects-table">
				<caption class="visiually-hidden">Projects</caption>
				<summary class="visiually-hidden">A list of all projects
					the framework has been used on</summary>
				<thead>
					<tr>
						<th scope="col" class="uppercase">Projects</th>
					</tr>
				</thead>
				<tbody>
					<#list projects as project>
					<tr>
						<td>${project}</td>
					</tr>
					</#list>
				</tbody>
			</table>
			<#else>
			<p>No projects for framework</p>
			</#if>
		</div>

		<div class="col-6 last-child">
			<h2 class="heading-three-view">Developers</h2>
			<#if developers?has_content>
			<table class="people-table">
				<caption class="visiually-hidden">Developers</caption>
				<summary class="visiually-hidden">A list of all developers
					that have used this framework</summary>
				<thead>
					<tr>
						<th scope="col" class="uppercase">Developers</th>
					</tr>
				</thead>
				<tbody>
					<#list developers as developer>
					<tr>
						<td>${developer}</td>
					</tr>
					</#list>
				</tbody>
			</table>
			<#else>
			<p>No developers have used this framework</p>
			</#if>
		</div>
	</div>
	</main>


</body>
</html>