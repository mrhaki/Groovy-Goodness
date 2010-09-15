<html>
<head>

<title>$title</title>

<script language="javascript" src="scripts/shCore.js"></script> 
<script language="javascript" src="scripts/shLegacy.js"></script> 
<script language="javascript" src="scripts/shBrushJava.js"></script> 
<script language="javascript" src="scripts/shBrushXml.js"></script> 
<script language="javascript" src="scripts/shBrushJScript.js"></script> 
<script language="javascript" src="scripts/shBrushGroovy.js"></script> 
<script language="javascript" src="scripts/shBrushPlain.js"></script> 
<script language="javascript" src="scripts/shBrushBash.js"></script> 
 
<link href="styles/reset.css" rel="stylesheet" type="text/css" />
<link href="styles/shCore.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="styles/shThemeRDark.css"/>
<link href="styles/blog.css" rel="stylesheet" type="text/css" />

</head>
<body>

<a href="index.html">Back to index</a>

<h3 class="post-title">$title</h3>

<div class="post">
${content}
</div>

<script language="javascript"> 
SyntaxHighlighter.config.bloggerMode = true;
SyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';
SyntaxHighlighter.defaults['first-line'] = 0;
SyntaxHighlighter.defaults['auto-links'] = false;
SyntaxHighlighter.all();
dp.SyntaxHighlighter.HighlightAll('code');
</script>

</body>
</html>