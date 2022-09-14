package com.ColombianSoftwareEngineers.APP.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @Column(name="nombre")
    private String nombreEmpresa;
    @Column(name="direccion")
    private String direccionEmpresa;
    @Column(name="telefono")
    private String telefonoEmpresa;
    @Column(name="nit")
    private String nitEmpresa;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleadoList;

    @OneToMany(mappedBy = "empresa")
    private List<MovimientoDinero> movimientoDineroList;


    //constructor
    public Empresa(){
        this.empleadoList = new ArrayList<Empleado>();
        this.movimientoDineroList = new ArrayList<MovimientoDinero>();
    }

    //metodos set y get

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public List<MovimientoDinero> getMovimientoDineroList() {
        return movimientoDineroList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public void setMovimientoDineroList(List<MovimientoDinero> movimientoDineroList) {
        this.movimientoDineroList = movimientoDineroList;
    }


}
