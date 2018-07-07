//conn.php for connection (file one)

<?php
$host = "localhost";
$user = "root";
$pass = "root";
$db_name = "suntekhac";

$con = new mysqli($host,$user,$pass,$db_name);

if($con -> connect_error){
    echo "Connection error";
}
?>