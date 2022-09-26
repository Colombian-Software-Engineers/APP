package com.ColombianSoftwareEngineers.ezprise.entities;

import com.ColombianSoftwareEngineers.ezprise.services.EmpleadoServices;
import com.ColombianSoftwareEngineers.ezprise.services.MovimientoServices;

import javax.persistence.*;
import java.util.ArrayList;
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
    @Column(name="rol")
    private RolEmpleado rolEmpleado;

    @OneToMany(mappedBy = "empleado")   //Relacion de uno a muchos
    private List <MovimientoDinero> movimientoDineroList;  //atributo para la relacion de uno a muchos un empleado puede tener muchos movimientos por eso un listado

    @ManyToOne
    @JoinColumn(name="idEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;

    public Empleado(){
        this.movimientoDineroList = new ArrayList<MovimientoDinero>();
    }

    public void deleteEmpleado(EmpleadoServices empleadoService, MovimientoServices movimientoServices){
        movimientoServices.deleteMovimientos(this.getMovimientoDineroList());
        empleadoService.deleteEmpleadoById(this.idEmpleado);
    }

    //metodos set y get

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        List<Empleado> empleadoList = empresa.getEmpleadoList();
        if(!empleadoList.contains(this)){
            empleadoList.add(this);
            empresa.setEmpleadoList(empleadoList);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        List<Empleado> empleadoList = user.getEmpleadoList();
        if(!empleadoList.contains(this)){
            empleadoList.add(this);
            user.setEmpleadoList(empleadoList);
        }
    }

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

    public RolEmpleado getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(RolEmpleado rolEmpleado) {
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
                ", rolEmpleado='" + rolEmpleado + '\'' +
                '}';
    }
}
