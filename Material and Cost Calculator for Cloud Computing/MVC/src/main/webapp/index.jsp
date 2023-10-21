<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Material and Cost Calculator</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<h1>Welcome To Vincent's Material and Cost Calculator!</h1>

<form action="calculate" method="get">

<br>

<label for="slabWidth">Width (feet):</label>
<input type="text" id="slabWidth" name="slabWidth">

<br>

<label for="slabHeight">Length (feet):</label>
<input type="text" id="slabHeight" name="slabHeight">

<br>

<label for="slabThickness">Thickness (inches):</label>
<input type="text" id="slabThickness" name="slabThickness">

<br>

<label for="bagSize">Bag Size:</label>
<select id="bagSize" name="bagSize">
<option value="80">80 lbs.
<option value="60">60 lbs.
<option value="50">50 lbs.
</select>

<br>

<p>
<input type="submit" name="submit" value="Submit" />
<input type="reset" name="reset" value="Reset" />
</p>


</form>





</body>
</html>