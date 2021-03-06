<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./Style.css">
  <link rel="stylesheet" href="./navbar.css">
  <link rel="stylesheet" href="./tabla.css">
  <title>Consulta</title>

</head>
<body>
<!-- navbar -->
<div class="navbar">
  <div class="navbar-central">
    <!-- navbar lado izquierdo -->
    <div class="navbar-izquierdo">
      <img src="img/logo.png" alt="">
      <a href="index.jsp" class="boton-navbar-izquierdo">Life Sea Mx</a>
    </div>
    <!-- navbar lado derecho -->
    <div class="navbar-derecho">
      <a href="Consulta.jsp" class="boton-navbar-derecho">Consulta</a>
      <a href="Formulario.jsp" class="boton-navbar-derecho">Solicitud</a>
    </div>
  </div>
</div>

<link rel="stylesheet" href="tabla.css">
<div class="container-clock">
  <h1 id="time">00:00:00</h1>
  <p id="date"></p>
</div>
<div class="form-group">
  <input type="text" class="form-control pull-right" style="width:20%" id="search" placeholder="Buscador">
</div>
<script src="./clock.js"></script>
<table class="table-bordered table pull-right" id="mytable" cellspacing="0" style="width: 100%;">
  <thead>
  <tr role="row">
    <th>Asociación</th>
    <th>Estado</th>
    <th>Ciudad</th>
    <th>Descripción</th>
    <th>e-mail</th>
    <th>Teléfono</th>
    <th>Categoría</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>kokorolitos</td>
    <td>CDMX</td>
    <td>Gustavo A. Madero</td>
    <td>team kokorolitos</td>
    <td>kokorolitos@innovacion.mx</td>
    <td>5523898423</td>
    <td>just for fun</td>
  </tr>
  </tbody>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
  // Write on keyup event of keyword input element
  $(document).ready(function(){
    $("#search").keyup(function(){
      _this = this;
      // Show only matching TR, hide rest of them
      $.each($("#mytable tbody tr"), function() {
        if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
          $(this).hide();
        else
          $(this).show();
      });
    });
  });
</script>
</body>
</html>