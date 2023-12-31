
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
            <nav class="navbar navbar-expand-lg navbar-light bg-info">
                <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav">
                    <li class="nav-item">
                      <a style="margin-left: 10px; border: none" class="nav-link active" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                      <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                      <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                      <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                      <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta" target="myFrame">Nueva Venta</a>
                    </li>
                  </ul>
                    <div class="dropdown">
                        <a style="border: none" href="#" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown">${usuario.getNombre()}</a>
                        <div class="dropdown-menu text-center dropdown-menu-right">
                                <a><img src="img/user.png" alt="80" width="80"></a><br>
                                <a>${usuario.getUser()}</a><br>
                                <a>DPI: ${usuario.getDpi()}</a>
                                <div class="dropdown-divider"></div>
                                <a href="index.jsp" class="dropdown-item">Salir</a> 
                        </div>
                        </div>
                </div>
            </nav>
                    <nav class="m-4" style="height: 550px;">
                        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>             
                    </nav>       
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
