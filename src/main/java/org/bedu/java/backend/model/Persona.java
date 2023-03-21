package org.bedu.java.backend.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Persona implements Comparable<Persona> {

    @NotBlank(message = "El nombre de usuario es un campo obligatorio.")
    private String nombre;
    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = "El teléfono debe tener un formato de ##-####-####")
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Bienvenido "+this.nombre+"\n Tu telefono es "+ this.telefono;
    }

    @Override
    public int compareTo( Persona persona ) {
        return this.nombre.compareTo( persona.nombre );
    }

}
