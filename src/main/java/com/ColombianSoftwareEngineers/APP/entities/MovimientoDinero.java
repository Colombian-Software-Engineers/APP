package com.ColombianSoftwareEngineers.APP.entities;

import javax.persistence.*;

@Entity
@Table(name="movimiento")
public class MovimientoDinero {
    @Id  //Genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO)  //genera el valor incremental del ID
    private Long idMovimiento;
    @Column(name="monto")
    private Integer montoMovimiento;
    @Column(name="concepto")
    private String  conceptoMovimiento;
    @Column(name="usuario")
    private String usuarioMovimiento;

    @ManyToOne
    @JoinColumn(name="idEmpleado")  //nombre de la columna
    private Empleado empleado;       //id

    //constructor
    public MovimientoDinero(){

    }

    //metodos get set

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
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
                "idUsuario=" + idMovimiento +
                ", montoMovimiento=" + montoMovimiento +
                ", conceptoMovimiento='" + conceptoMovimiento + '\'' +
                ", usuarioMovimiento='" + usuarioMovimiento + '\'' +
                '}';
    }
}
