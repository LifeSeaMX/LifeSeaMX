<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./Solicitud.css">
    <link rel="stylesheet" href="./Style.css">
    <link rel="stylesheet" href="./navbar.css">
    <title>Formulario Registro</title>
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

<!-- burbujas -->

<div class="burbujas">
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
    <div class="burbuja"></div>
</div>



<!-- formulario -->
<form method="post" action="MyServlet" autocomplete="off">

<section class="form-register">
    <h4>Formulario Registro</h4>
    <input class="controls" type="text" name="nombres" id="nombre" placeholder="Ingrese su Nombre">
    <br></br>
    <br></br>
    <input class="controls" type="text" name="estado" id="estado" placeholder="Estado a buscar">
    <br></br>
    <br></br>
    <input class="controls" type="text" name="ciudad" id="ciudad" placeholder="Ciudad">
    <br></br>
    <br></br>

    <input class="controls" type="email" name="correo" id="correo" placeholder="Email">

    <br></br>
    <br></br>

    <input class="controls" type="tel" name="telefono" id="telefono" maxlength="10" placeholder="Teléfono">

    <br></br>
    <br></br>

    <div class="select">
        <select name="Cat" id="categoria">
            <option value="RB">Reservas de la biosfera</option>
            <option value="PN">Parques Nacionales</option>
            <option value="MN">Monumentos Naturales</option>
            <option value="APRN">Áreas de Protección de Recursos</option>
            <option value="APFF">Áreas de Protección de Flora y Fauna</option>
            <option value="S">Santuarios</option>
        </select>
    </div>
    <br></br>
    <br></br>

    <button class="btn-neon" type="submit">ENVIAR</button>


</section>

</form>

</body>
</html>