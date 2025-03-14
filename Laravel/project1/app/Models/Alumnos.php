<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class alumnos extends Model
{
    use HasFactory;
    public $timestamps = false;
    protected $table = 'alumnos';
    protected $primarykey = 'id';
    protected $fillable = [
        'nombre',
        'apellido',
        'edad',
        'correo'
    ];
}
