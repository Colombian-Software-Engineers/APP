package com.ColombianSoftwareEngineers.APP.entities;

public enum RolEmpleado {
    ADMIN("Admin"),
    OPERARIO("Operario");

    private String rol;
    RolEmpleado(String rol) {
        this.rol = rol;
    }

    public String toString(){
        return this.rol;
    }
}
