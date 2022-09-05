package com.ColombianSoftwareEngineers.APP.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    //metod toString

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", direccionEmpresa='" + direccionEmpresa + '\'' +
                ", telefonoEmpresa='" + telefonoEmpresa + '\'' +
                ", nitEmpresa='" + nitEmpresa + '\'' +
                '}';
    }
}
