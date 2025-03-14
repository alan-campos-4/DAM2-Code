<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>

    <h3>Vista de alumno</h3>

    <div class="container">
        Nombre:     {{ $alumno['nombre'] }}<br>
        Apellido:   {{ $alumno['apellido'] }}<br>
        Edad:       {{ $alumno['edad'] }}<br>
        Correo:     {{ $alumno['correo'] }}<br>
    </div>

</body>
</html>