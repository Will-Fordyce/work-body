<html>
    <body>
        <?php
            session_start();
            if ($_SESSION['loggedin'] !== true) {
                header("Location: LoginPage.php");
                exit();
            }
            //Creating a connection to the database
            $connection = new mysqli("localhost", "wfordyce", "boP5N-d_cr2i3ATB", "users465");
            if ($connection->connect_error) {
                die("Connection failed: " . $connection->connect_error);
            }


            $validLogin = false;
            $outPut = "";
            echo "<h3>Enter your username and password to delete account</h3>";
            //Checking for password and username validity
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                $uname = $_POST["name"];
                $pass = $_POST["password"];
                $sql = "SELECT Usernames, Passwords FROM userinfo WHERE Usernames = '$uname'";
                $result = $connection->query($sql);   
                if ($result->num_rows > 0) {
                    while($row = $result->fetch_assoc()) {
                        if ($row["Passwords"] == $_POST["password"] && !empty($_POST["password"])) {
                            $validLogin = true;
                        }
                        else {
                            $outPut = "Wrong password";
                        }
                    }
                } 
                else if (!empty($_POST["name"])) {
                    $outPut = "There is no account with this Username";
                } 

                
                //If everything checks out delete the account
                if ($validLogin == true) {
                    $sql2 = "DELETE FROM userinfo WHERE Usernames = '$uname'";
                    $result2 = $connection->query($sql2);
                    $outPut = "Account succesfully deleted";
                }
            }  
            
        ?>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method=post>
			    Username:  <input required name=name><br>
                Password:  <input required name=password><br>
			    <input type=submit>
	    </form>
        <?php       
            echo "<h3>$outPut<h3><br>"; 
        ?>
        <a href="ProtectedPage.php">Home </a><br><br>
    <body>
<html>