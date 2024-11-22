<!--
	Es el punto de entrada principal del sitio. Este archivo incluirá los elementos comunes de la página (cabecera, pie de página y menú) 
	y cargará dinámicamente el contenido según la sección solicitada.
-->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
</head>
<body>
	<?php 
		require "header.php";
		echo "<h1>Practica include y require</h1>";
		require "menu.php";
		require "footer.php";
	?>
</body>
</html>


