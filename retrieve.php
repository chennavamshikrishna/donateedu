<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "donor";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT password FROM donor WHERE email = ?";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
    // output data of each row
    //Password is correct give login access
} else {
    // Password incorrect
}

mysqli_close($conn);
?>
