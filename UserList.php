<html>
    <body>
        <?php
            session_start();
            if ($_SESSION['loggedin'] !== true) {
                header("Location: LoginPage.php");
                exit();
            }
            //Establishing a connection to the database
            $connection = new mysqli("localhost", "wfordyce", "boP5N-d_cr2i3ATB", "users465");
            if ($connection->connect_error) {
                die("Connection failed: " . $connection->connect_error);
            }

            //Displayin a list of accounts to the user
            echo "<h1>List of Users</h1>";
            $sql2 = "SELECT Usernames FROM userinfo";
            $result = $connection->query($sql2);
            if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                    echo "Username: " . $row["Usernames"]. "<br>"."<br>";
                }
            } 
            else {
                echo "No users :(";
            }
        ?>
        <a href="ProtectedPage.php">Home </a><br><br>
    <body>
<html>