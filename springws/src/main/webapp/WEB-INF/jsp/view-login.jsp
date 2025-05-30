<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
</head>
<body>

<h2>User Login</h2>

<div>${message}</div><br/><br/>

<form method="post" action="/login">
  <label for="username">Username:</label><br>
  <input type="text" id="username" name="username" required><br>

  <label for="passwd">Password:</label><br>
  <input type="password" id="passwd" name="passwd" required><br>

  <label for="dob">Date of Birth:</label><br>
  <input type="date" id="dob" name="dob" required><br><br>

  <input type="submit" value="Login">
</form>

<p>Clicking the "Login" button will send your input data to the login handler.</p>

</body>
</html>
