<?php 
  $clientSoap=new SoapClient("http://localhost:8586/?wsdl");
      $code=$_GET['code'];

        $etudiant=new stdClass();
  $etudiant->code=$code;
    $resultat=$clientSoap->__soapCall("getOne",array($etudiant));
   
   
   
?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" type="text/css" href="../style/bootstrap.css">
	<title></title>
</head>
<body>
	<div  style="height:25px;">
		
	</div>

	<div class="container text-center" style="width: 300px;">
		<form action="sumitUpdate.php" method="POST">
			<?php echo  "<input type='text' hidden=hidden class='form-control' name='code' id='nomid' value='". $resultat->return->code ."'> ";  ?>
  <div class="form-group mb-2">
    <label for="nomid">Nom</label>
   <?php echo  "<input type='text' class='form-control' name='nom' id='nomid' value='". $resultat->return->nom ."'> ";  ?>
  
  </div>
  <div class="form-group mb-2">
    <label for="prenomid">Prénom</label>
  <?php echo  "<input type='text' class='form-control' name='prenom' id='prenomid' value='". $resultat->return->prenom ."'> ";  ?>
  </div>
 
  <input class="btn btn-primary mb-2" type="submit" name="submit" value="valider"> 
</form>
		
	</div>

</body>
</html>