<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AlumnosController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/alumnos', [AlumnosController::class, 'index']);
Route::get('/alumnos/crear', [AlumnosController::class, 'create'])->name('createAlumno');
Route::post('/alumnos/guardar', [AlumnosController::class, 'store'])->name('saveAlumno');
Route::get('/alumnos/borrar', [AlumnosController::class, 'destroy'])->name('deleteAlumno');
Route::get('/alumnos/mostrar/{id}', [AlumnosController::class, 'show'])->name('showAlumno');
