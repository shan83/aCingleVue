<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="style/style.css" rel="stylesheet" type="text/css">
<link href="style/sprymenubarhorizontal.css" rel="stylesheet" type="text/css">
<link href="style/zebra_dialog.css" rel="stylesheet" type="text/css">
 <link  rel="stylesheet" type="text/css" href="style/light.css" />

<link href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="style/simplePagination.css">

<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js"></script>
<script type="text/javascript" src="js/zebra_dialog.js"></script>
<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<script type="text/javascript">
if (typeof jQuery == 'undefined')
{
  document.write(unescape("%3Cscript src='%3Cc:url value=\"js/jquery-1.8.2.js\"/%3E' type='text/javascript'%3E%3C/script%3E"));
  document.write(unescape("%3Cscript src='%3Cc:url value=\"js/jquery-ui-1.9.1.custom.min.js\"/%3E' type='text/javascript'%3E%3C/script%3E"));
  document.write(unescape('%3link href="%3Cc:url value=\"style/jquery-ui-1.9.1.custom.min.css\"/%3E" rel="stylesheet" type="text/css"%3E'));
}
</script>
<script type="text/javascript" src="js/jquery.noty.js"></script>
<script type="text/javascript" src="js/layouts/top.js"></script>
<script type="text/javascript" src="js/layouts/topRight.js"></script>
<script type="text/javascript" src="js/themes/default.js"></script>
<script src="js/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.simplePagination.js"></script>

</head>

<body>

	<div class="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="body">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>