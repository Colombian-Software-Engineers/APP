package Entidades;

import javax.persistence.*;

public class MovimientoDinero {
    @Id  //Genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO)  //genera el valor incremental del ID

    private Integer idUsuario;
    private Integer montoMovimiento;
    private String  conceptoMovimiento;
    private String usuarioMovimiento;
    @ManyToOne
    @JoinColumn(name="empleado_id")  //nombre de la columna
    private Empleado empleado;       //id

    //constructor
    public MovimientoDinero(){

    }

    //metodos get set

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(Integer montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getUsuarioMovimiento() {
        return usuarioMovimiento;
    }

    public void setUsuarioMovimiento(String usuarioMovimiento) {
        this.usuarioMovimiento = usuarioMovimiento;
    }
    //metodo toString


    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "idUsuario=" + idUsuario +
                ", montoMovimiento=" + montoMovimiento +
                ", conceptoMovimiento='" + conceptoMovimiento + '\'' +
                ", usuarioMovimiento='" + usuarioMovimiento + '\'' +
                '}';
    }
}
