<?php
$host = "localhost";
$username = "root";
$password ="";
$dbname ="resturant";
$conn = new mysqli($host,$username,$password,$dbname);
if($conn ->connect_error){
    die("Connection failed". $conn->connect_error);
}
else{
    $sql = "select * from dinner";
    $result = $conn->query($sql);
    $resultarry = array();
    while($row = mysqli_fetch_assoc($result)){
        $resultarry[] = $row;
    }
}
echo json_encode($resultarry);
$conn->close();
?>