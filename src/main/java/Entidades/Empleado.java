package Entidades;

import javax.persistence.*;
import java.util.List;

@Entity   //referencia que es una Entidad

public class Empleado {
    @Id  //Genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO)  //genera el valor incremental del ID
    private Integer idEmpleado;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String empresaEmpleado;
    private String rolEmpleado;

    @OneToMany(mappedBy = "empleado")   //Relacion de uno a muchos
    private List <MovimientoDinero> movimientoDineroList;  //atributo para la relacion de uno a muchos un empleado puede tener muchos movimientos por eso un listado
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;


    public Empleado(){
        //constructor vacio
    }

    //metodos set y get

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
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
