package com.ColombianSoftwareEngineers.APP.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity   //referencia que es una Entidad
@Table(name="empleado")
public class Empleado {
    @Id  //Genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //genera el valor incremental del ID
    private Long idEmpleado;
    @Column(name="nombre")
    private String nombreEmpleado;
    @Column(name="correo")
    private String correoEmpleado;
    @Column(name="empresa")
    private String empresaEmpleado;
    @Column(name="rol")
    private String rolEmpleado;
    // TODO define relation of empleado with user 

    @OneToMany(mappedBy = "empleado")   //Relacion de uno a muchos
    private List <MovimientoDinero> movimientoDineroList;  //atributo para la relacion de uno a muchos un empleado puede tener muchos movimientos por eso un listado

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idEmpresa")
    private Empresa empresa;

    public Empleado(){
        //constructor vacio
    }

    //metodos set y get

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(String empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public List<MovimientoDinero> getMovimientoDineroList() {
        return movimientoDineroList;
    }

    public void setMovimientoDineroList(List<MovimientoDinero> movimientoDineroList) {
        this.movimientoDineroList = movimientoDineroList;
    }

    //metodo toString


    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", empresaEmpleado='" + empresaEmpleado + '\'' +
                ", rolEmpleado='" + rolEmpleado + '\'' +
                '}';
    }
}
