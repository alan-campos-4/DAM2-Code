<!--
	Es el punto de entrada principal del sitio. 
	Este archivo incluirá los elementos comunes de la página (cabecera, pie de página y menú) 
	y cargará dinámicamente el contenido según la sección solicitada.
-->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Pr�ctica include y require</title>
</head>
<body>
	<?php
		require "header.php";
		require "menu.php";

		include $_GET["path"];

		require "footer.php";
	?>
</body>
</html>
