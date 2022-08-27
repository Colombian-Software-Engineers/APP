package com.ColombianSoftwareEngineers.APP;

import Entidades.Empleado;
import Entidades.Empresa;
import Entidades.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AppApplication.class, args);
		System.out.println("Hola Mundo");
		//Instancia de la clase empleado
		Empleado empleado = new Empleado();
		empleado.setNombreEmpleado("Hasan");
		empleado.setIdEmpleado(45);
		empleado.setCorreoEmpleado("sadad00");
		empleado.setRolEmpleado("Operador");
		empleado.setEmpresaEmpleado("ASDAD");
		System.out.println(empleado.toString());
		//Instancia clase empresa
		Empresa empresa = new Empresa();
		empresa.setDireccionEmpresa("dasda");
		empresa.setNitEmpresa("513");
		empresa.setNombreEmpresa("CSE");
		empresa.setTelefonoEmpresa("5353");
		empresa.setIdEmpresa(0);
		System.out.println(empresa.toString());
		//intancia de la clase moviemiento dinero
		MovimientoDinero movimieto = new MovimientoDinero();
		movimieto.setConceptoMovimiento("Retiro");
		movimieto.setMontoMovimiento(-8000);
		movimieto.setIdUsuario(0);
		movimieto.setUsuarioMovimiento("Camilo");
		System.out.println(movimieto.toString());
	}

}
