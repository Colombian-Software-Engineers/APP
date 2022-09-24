package com.ColombianSoftwareEngineers.ezprise.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name="name")
    private String nameUser;
    @Column(name="email", unique = true)
    private String emailUser;
    @Column(name="image")
    private String imageUser;
    @Column(name="auth0id", unique = true)
    private String auth0idUser;

    @OneToMany(mappedBy = "user")
    private List<Empleado> empleadoList;

    public User() {
    }

    public List<Empresa> getEmpleadosEmpresaList(){
        List<Empleado> empleadoList = this.getEmpleadoList();
        // Lista de las empresas dentro de la lista de empleados:
        List<Empresa> empresaList = empleadoList.stream().map(Empleado::getEmpresa).collect(Collectors.toList());
        return empresaList;
    }

    public Optional<Empleado> getEmpleadoByEmpresa(Empresa empresa){
        List<Empleado> userEmpleados = this.getEmpleadoList();
        List<Empleado> empresaEmpleados = empresa.getEmpleadoList();
        userEmpleados.retainAll(empresaEmpleados);
        return Optional.ofNullable(userEmpleados.get(0));
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public User(String nameUser, String emailUser, String imageUser, String auth0idUser) {
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.imageUser = imageUser;
        this.auth0idUser = auth0idUser;
    }

    public Empleado toEmpleado(){
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado(this.nameUser);
        empleado.setCorreoEmpleado(this.emailUser);
        empleado.setUser(this);
        return empleado;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getImageUser() {
        return imageUser;
    }

    public String getAuth0idUser() {
        return auth0idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }

    public void setAuth0idUser(String auth0idUser) {
        this.auth0idUser = auth0idUser;
    }
}
