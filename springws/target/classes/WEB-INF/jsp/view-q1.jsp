<!DOCTYPE html>
<html>
<body>

<h2>Question 1</h2>

<div>${message}</div><br/><br/>

<form method="post" action="/q1">
  <label for="number1">Enter first number:</label><br>
  <input type="text" id="number1" name="number1" required><br>

  <label for="number2">Enter second number:</label><br>
  <input type="text" id="number2" name="number2" required><br>

  <label for="result">Sum:</label><br>
  <input type="text" id="result" name="result" required><br><br>

  <input type="submit" value="Submit">
</form>

</body>
</html>
