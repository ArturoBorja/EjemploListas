package com.example.ejemplolistas;

public class Producto {
    public String nombre;
    public Double precio;
    public String imagen;

    public Producto(String nombre, Double precio, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

