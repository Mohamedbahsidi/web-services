<?php 
  $clientSoap=new SoapClient("http://localhost:8586/?wsdl");
      $code=$_GET['code'];

        $etudiant=new stdClass();
  $etudiant->code=$code;
    $r=$clientSoap->__soapCall("delete",array($etudiant));
    $resultat=$clientSoap->__soapCall("getall",array($etudiant));
   
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
	<div style="height: 25px;">
		
	</div>
  <div class="container text-center text-primary">
     <h4>Liste des Etudiants</h4>
      
    </div>
	<div class="container row">

		<div class="offset-10">
			
		</div>
		<div class="offset-10 mt-3">
			<a href="createEtudiant.php" class="btn btn-success">Ajouter Etudiant</a>
			
		</div>

		
	</div>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">id </th>
      <th scope="col">Nom </th>
      <th scope="col">Prénom</th>
      <th scope="col">Action</th>

    </tr>
  </thead>
  <tbody>




<?php   foreach ($resultat->return as $key => $value) {
?>




 <tr>
      <th scope="row"><?php echo  $value->code;  ?></th>
      <td><?php  echo  $value->nom;    ?> </td>
      <td><?php echo  $value->prenom;     ?></td>
      <td>
       <?php echo "<a class='btn btn-primary' href='updateEtudiant.php?code=".$value->code."'>Modifier</a>";  ?>
         <?php echo "<a class='btn btn-danger' href='deleteEtudiant.php?code=".$value->code."'>Suprimer</a>";  ?>

        
      </td>
     
    </tr>


<?php 

}
?>



   

    
   
  </tbody>
</table>

</body>
</html>