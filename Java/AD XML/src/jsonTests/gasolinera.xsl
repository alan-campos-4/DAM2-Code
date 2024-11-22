<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:decimal-format name="euro" decimal-separator="," grouping-separator="."/>
<xsl:template match="/">
<html>
	<head>
		<title>Gasolinera</title>
		<link type="text/css" rel="stylesheet" href="gasolinera.css"/>
	</head>
	<body>
		<xsl:for-each select="gasolinera/año">
			<h2>Ventas de combustible año <xsl:value-of select="@id"/></h2>
			<table>
				<tr><th class="der">Mes</th><th class="der">Gasolina 95</th>
				<th class="der">Gasolina 98</th><th class="der">Gasóleo A</th>
				<th class="der">Gasóleo B</th><th class="der">Suma</th></tr>
				<xsl:for-each select="mes">
					<tr>
					<td class="der"><xsl:value-of select="@id"/></td>
					<td class="der"><xsl:value-of select="format-number(gasolina_95,'###.###','euro')"/></td>
					<td class="der"><xsl:value-of select="format-number(gasolina_98,'###.###','euro')"/></td>
					<td class="der"><xsl:value-of select="format-number(gasoleo_a,'###.###','euro')"/></td>
					<td class="der"><xsl:value-of select="format-number(gasoleo_b,'###.###','euro')"/></td>
					<td class="der"><xsl:value-of select="format-number(gasolina_95+gasolina_98+gasoleo_a+gasoleo_b,'###.###','euro')"/></td>
					</tr>
				</xsl:for-each>	
				<tr>
				<td class="der total">Totales</td>
				<td class="der total"><xsl:value-of select="format-number(sum(mes/gasolina_95),'###.###','euro')"/></td>
				<td class="der total"><xsl:value-of select="format-number(sum(mes/gasolina_98),'###.###','euro')"/></td>
				<td class="der total"><xsl:value-of select="format-number(sum(mes/gasoleo_a),'###.###','euro')"/></td>
				<td class="der total"><xsl:value-of select="format-number(sum(mes/gasoleo_b),'###.###','euro')"/></td>
				<td class="der total"><xsl:value-of select="format-number(sum(mes/gasolina_95)+
															sum(mes/gasolina_98)+
															sum(mes/gasoleo_a)+
															sum(mes/gasoleo_b),'###.###','euro')"/></td>
				</tr>
			</table>
		</xsl:for-each>	
		<h2>Ventas de combustible totales</h2>
		<table>
			<tr><th class="der">Mes</th><th class="der">Gasolina 95</th>
			<th class="der">Gasolina 98</th><th class="der">Gasóleo A</th>
			<th class="der">Gasóleo B</th><th class="der">Suma</th>
			</tr>
			<tr>
			<td class="der total">Totales</td>
			<td class="der total"><xsl:value-of select="format-number(sum(gasolinera/año/mes/gasolina_95),'###.###','euro')"/></td>
			<td class="der total"><xsl:value-of select="format-number(sum(gasolinera/año/mes/gasolina_98),'###.###','euro')"/></td>
			<td class="der total"><xsl:value-of select="format-number(sum(gasolinera/año/mes/gasoleo_a),'###.###','euro')"/></td>
			<td class="der total"><xsl:value-of select="format-number(sum(gasolinera/año/mes/gasoleo_b),'###.###','euro')"/></td>
			<td class="der total"><xsl:value-of select="format-number(sum(gasolinera/año/mes/gasolina_95)+
														sum(gasolinera/año/mes/gasolina_98)+
														sum(gasolinera/año/mes/gasoleo_a)+
														sum(gasolinera/año/mes/gasoleo_b),'###.###','euro')"/></td>
			</tr>
		</table>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>