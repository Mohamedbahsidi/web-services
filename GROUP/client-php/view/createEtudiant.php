<?php

if(isset($_POST['submit'] ) ){
if(isset($_POST['nom'])){
	$nom=$_POST['nom'];
	$prenom=$_POST['prenom'];

	
		$clientSoap=new SoapClient("http://localhost:8586/?wsdl");
		
	$etudiant=new stdClass();
	$etudiant->nom=$nom;
		$etudiant->prenom=$prenom;

		$resultat=$clientSoap->__soapCall("newetudiant",array($etudiant));
		if($resultat->return==true) echo "le nom n'est pas null";
		else echo "le nom est null";

}




}



?>

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
		<form action="createEtudiant.php" method="POST">
  <div class="form-group mb-2">
    <label for="exampleInputEmail1">Nom</label>
    <input type="text" class="form-control" name="nom" id="exampleInputEmail1"  placeholder="Entrer votre nom">
  
  </div>
  <div class="form-group mb-2">
    <label for="exampleInputPassword1">Prénom</label>
    <input type="text" class="form-control" name="prenom" id="exampleInputPassword1" placeholder="Entrer votre prénom">
  </div>
 
<input type="submit" value="valider"  name="submit" class="btn btn-primary">
</form>
		
	</div>

</body>
</html>