package main;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ClienteInterface;
import dao.ServicioInterface;
import dominio.Cliente;
import dominio.Servicio;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml"); 
		ClienteInterface clientes= (ClienteInterface)context.getBean("clienteDAO");
		ServicioInterface servicios=(ServicioInterface)context.getBean("servicioDAO");

		Cliente c= new Cliente(null,"Anais","Corbalan Sanchez","963852741","midulceotono@gmail.com",null);
		System.out.println("Altas clientes");
		for(int i=0;i<10;i++)	
		clientes.alta(c);
		
		System.out.println("Consulta cliente");
		Cliente consultado=clientes.consulta(1);
		consultado.setNombre("Otro nombre");
		System.out.println("A modificar " +consultado.toString());
		
		clientes.modificacion(consultado);
		System.out.println("Eliminando...");
		clientes.baja(consultado.getIdCliente());
					
	
		ArrayList<Cliente>lista=(ArrayList<Cliente>)clientes.consulta();
			Cliente cliente=lista.get(0);
		
			for(int i =0;i<20;i++) {
			Servicio s1 = new Servicio(cliente, "Servicio " +i);
			System.out.println("Alta de servicios");
			servicios.alta(s1);
			}
		
			ArrayList<Cliente>listaConsulta=(ArrayList<Cliente>)clientes.consulta();
			Cliente clienteAux=lista.get(0);
		System.out.println("El cliente es "+ clienteAux.toString());
		System.out.println("Sus servicios son:");
		
		for(Servicio s:clienteAux.getServicios()) System.out.println(s.toString());
		
			
	}
}
