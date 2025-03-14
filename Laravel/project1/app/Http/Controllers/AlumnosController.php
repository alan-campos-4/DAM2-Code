<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Alumnos;

class AlumnosController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $alumnos = Alumnos::all();
        return view("alumnos.index")
            ->with('alumnos', $alumnos);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view("alumnos.create");
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        Alumnos::create($request->all());
        return redirect()->route('index.alumno')->with('success', 'Alumno registrado exitosamente.');
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $alumno = Alumnos::find($id)->get();
        return view("alumnos.show")
            ->with('alumnos', $alumno);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $alumno = Alumnos::find($id)->get();
        $alumno->delete();
        return redirect()->route('index.alumno')->with('success', 'Alumno borrado exitosamente.');
    }
}
