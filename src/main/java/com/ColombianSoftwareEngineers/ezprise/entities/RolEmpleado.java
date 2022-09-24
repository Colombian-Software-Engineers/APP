package com.ColombianSoftwareEngineers.ezprise.entities;

public enum RolEmpleado {
    ADMIN("Admin"),
    OPERARIO("Operario");

    private final String rol;
    RolEmpleado(String rol) {
        this.rol = rol;
    }

    public String getRol(){
        return this.rol;
    }
}
