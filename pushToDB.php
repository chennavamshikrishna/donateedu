//save.php(file two)
<?php
$name = $_POST['name'];
$password = $_POST['password'];
$email = $_POST['email'];
$mobile = $_POST['mobile'];
require_once('conn.php');

$sql = "INSERT INTO donor (name, password, email, mobile) VALUES ('$name',sha('$password'), '$email', $mobile)";

if($con -> query($sql) === TRUE) {
echo "User added";
}
//$con -> close();
?>
