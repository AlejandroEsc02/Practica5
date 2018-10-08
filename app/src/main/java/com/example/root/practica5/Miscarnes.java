package com.example.root.practica5;

public class Miscarnes {
        String ubicacion, direccion,horario;

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Miscarnes(String ubicacion, String direccion, String horario) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.horario = horario;
    }
}
