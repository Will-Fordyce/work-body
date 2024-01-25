<html>
    <body>
        <?php
            session_start();
            if ($_SESSION['loggedin'] !== true) {
                header("Location: LoginPage.php");
                exit();
            }
        ?>
        <img src="buffy.jpg" alt="Buffy the Vampire Slayer" style="width:250px;height:400px;"><br><br>
        <a href="UserList.php">List of Users </a><br><br>
        <a href="DeleteUser.php">Delete a User Account</a><br><br>
        <a href="LogoutPage.php">Logout</a>
    <body>
<html>