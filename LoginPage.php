<html>
    <body>
        <?php
            //Creating variables and establishing a connection to the database
            session_start();
            if ($_SESSION['loggedin'] == true) {
                header("Location: ProtectedPage.php");
                exit();
            }
            $uname = "";
            $pass = "";
            $outPut = "";
            $connection = new mysqli("localhost", "wfordyce", "boP5N-d_cr2i3ATB", "users465");
            if ($connection->connect_error) {
                die("Connection failed: " . $connection->connect_error);
            }

            //Displayin important info to the user
            echo "<h1>Jesse Pinkman Login Page</h1>";
            echo "<h3>Welcome, yo.</h1>";
            echo "Connected successfully<br>";
            
            //Process client request, check for validity
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                $uname = $_POST["name"];
                $pass = $_POST["password"];
                $sql = "SELECT Usernames, Passwords FROM userinfo WHERE Usernames = ?";
                $stmt = $connection->prepare($sql);
                $stmt->bind_param("s",$uname);
                $stmt->execute();
                $result = $stmt->get_result(); 
                $stmt->close();
                $connection->close();
                if ($result->num_rows > 0) {
                    while($row = $result->fetch_assoc()) {
                        if ($row["Passwords"] == $_POST["password"] && !empty($_POST["password"])) {
                            $_SESSION["loggedin"] = true;
                        }
                        else {
                            $outPut = "Wrong password";
                        }
                    }
                } 
                else if (!empty($_POST["name"])) {
                    $outPut = "There is no account with this Username";
                } 
            }  

            //If login information is valid take user to protected page
            if ($_SESSION["loggedin"] == true) {
                header('Location:ProtectedPage.php');
            }
        ?>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method=post>
			    Username:  <input required name=name><br>
                Password:  <input required name=password><br>
			    <input type=submit>
	    </form>
        <?php       
            echo "<h3>$outPut<h3><br>"; 
            echo "<h4>Don't have an account, yo?</h4>";
        ?>
        <a href="CreateUser.php">Create User</a>
    </body>
</html>