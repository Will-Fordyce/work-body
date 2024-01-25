<html>
    <body>
        <h3>Log Out?</h3>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method=post>
			    <input type=submit>
	    </form>
        <?php
            //Not much to see here (obviously)
            session_start();
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                $_SESSION["loggedin"] = false;
            }
            if ($_SESSION['loggedin'] !== true) {
                header("Location: LoginPage.php");
                exit();
            }
        ?>
    <body>
<html>