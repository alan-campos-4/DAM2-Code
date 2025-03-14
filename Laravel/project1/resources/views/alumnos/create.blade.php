<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>

    <h3>A&ntilde;adir alumno</h3>

    <div class="container">
        <form action="{{route('saveAlumno')}}" method="POST">
            @csrf
            Nombre:     <input type="text" name="nombre">   <br>
            Apellido:   <input type="text" name="apellido"> <br>
            Edad:       <input type="text" name="edad">     <br>
            Correo:     <input type="text" name="correo">   <br>
            <input type="submit" name="Guardar">
        </form>
    </div>

</body>
</html>