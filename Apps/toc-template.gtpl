<html>
<head>

<title>Groovy Goodness</title>

<link href="styles/reset.css" rel="stylesheet" type="text/css" />
<link href="styles/shCore.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="Stylesheet" href="styles/shBlackWhite.css"/>
<link href="styles/blog.css" rel="stylesheet" type="text/css" />

</head>
<body class="toc">

<div class="titlewrapper">
	<h1 class="title">Groovy Goodness</h1>
	<h2 class="description">assert 'mrhaki' == ['Hubert','Alexander','Klein','Ikkink'].inject('mr') { c,n -&gt; c += n[0].toLowerCase() }</h2>
</div>

<div class="toc">
    <ul>
	<% toc.each { %>
	    <li><a href="$it.link">$it.title</a></li>
	<% } %>
	</ul>
</div>

</body>
</html>