<html>
    <body>
        <?php

            //Creating variables
            $unameOk = false;
            $passOk = false;
            $uname = "";
            $pass = "";
            $outPut = "";

            //Connecting to the database
            $connection = new mysqli("localhost", "wfordyce", "boP5N-d_cr2i3ATB", "users465");
            if ($connection->connect_error) {
                die("Connection failed: " . $connection->connect_error);
            }

            //Header
            echo "<h1>Create User</h1>";
            echo "Connected successfully<br>";

            //Handling user creation
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                //Checking for appropriate username syntax
                if ((!empty($_POST["name"])) && preg_match("/[\W\s]/",($_POST["name"]))) {
                    $outPut = "No spaces or special characters in username";
                }
                else {
                    $unameOk = true;
                    $uname = $_POST["name"];
                }
                //Checking for appropriate password
                if ((!empty($_POST["pass1"])) && preg_match("/[\W\s]/",($_POST["pass1"]))) {
                    $outPut = "No spaces or special characters in password";
                }
                else  {
                    $passOk = true;
                    $pass = $_POST["pass1"];
                }
                //Creating account and telling user
                if ($passOk == true && $unameOk == true) {
                    if ($_POST["pass1"] == $_POST["pass2"]) {
                        $outPut = "SUCCESS";
                        $sql = "INSERT INTO userinfo VALUES(?,?);";
                        $stmt = $connection->prepare($sql);
                        $stmt->bind_param("ss", $uname, $pass);
                        $stmt->execute();
                        $stmt->close();
                        $connection->close();
                    }
                    else {
                        $outPut = "Passwords do not match";
                    }
                }
            }
        ?>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"method=post>
			    Create Username:  <input required name=name><br>
                Create Password:  <input required name=pass1><br>
                Re-Enter Password:  <input required name=pass2><br>
			    <input type=submit>
	    </form>
        <?php
            echo "<h2>Status:</h2>";
            echo "<h3>$outPut<h3><br>";
        ?>
        <a href="LoginPage.php">Login Page</a>
    </body>
<html>