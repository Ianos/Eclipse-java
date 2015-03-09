<?xml version="1.0"?>
 <xsl:stylesheet  version = "1.0"  xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Used Vehicles</title>
</head>
<body background="Money.jpg">
<h1 style="background-color: #446600;
color: #FFFFFF; font-size: 20pt; text-align: center;
letter-spacing: 1.0em">Used Vehicles</h1>
<table align="center" border="2">
<tr>
<th style="color : black;">Year</th>
<th style="color : black;">Make</th>
<th style="color : black;">Model</th>
<th style="color : black;">Mileage</th>
<th style="color : black;">Color</th>
<th style="color : black;">Price</th>
</tr>
<!--This template has had so far only presentation elements, -->
<!-- without any reference to the target xml document -->
<!-- We now refer to the the target xml document -->
<xsl:for-each select="vehicles/vehicle">
<tr>
<td><xsl:value-of select="@year"/></td>
<td><xsl:value-of select="@make"/></td>
<td><xsl:value-of select="@model"/></td>
<td><xsl:value-of select="mileage"/></td>
<td><xsl:value-of select="color"/></td>
<td><xsl:value-of select="price"/></td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>