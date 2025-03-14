<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>

    <h1>Lista de alumnos</h1>

    <div class="container">
        <a href="{{route('createAlumno')}}"><button>Crear alumno</button></a>

        <table class="table table-striped">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Edad</td>
                <td>Acciones</td>
            </tr>
            @foreach ($alumnos as $alumno)
            <tr>
                <td>{{ $alumno['id'] }}</td>
                <td>{{ $alumno['nombre'] }}</td>
                <td>{{ $alumno['apellido'] }}</td>
                <td>{{ $alumno['edad'] }}</td>
                <td>
                    <a href="{{route('showAlumno',$alumno['id'])}}"><button>Ver</button></a>
                    <a href="{{route('deleteAlumno',$alumno['id'])}}"><button>Borrar</button></a>
                </td>
            </tr>
            @endforeach
        </table>
    </div>

</body>
</html>