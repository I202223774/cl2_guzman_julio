package tests;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Rol;
import model.TipoCuenta;

public class JPACL2Test {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cl2");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Cliente cli = new Cliente();
		cli.setNombres("Julio");
		cli.setApellidoMaterno("Guzmán");
		cli.setApellidoPaterno("Cusipaucar");
		
		
		Cuenta cue = new Cuenta();
		cue.setNumeroCuenta("102030405060");
		cue.setSaldo(8000D);
		cue.setActiva(true);
		
		TipoCuenta tc = new TipoCuenta();
		tc.setDescripcion("Cuenta Ahorros");
		tc.setMoneda("USD");
		
		Movimiento mov = new Movimiento();
		mov.setDescripcion("Depósito inicial");
		mov.setFecha(LocalDate.now());
		mov.setMonto(500.00);
		
		Rol rol = new Rol();
		rol.setArchivo(null);
		rol.setDescripcion(null);
		
		Cliente cli1 = new Cliente();
		cli1.setApellidoMaterno("Gallardo");
		cli1.setApellidoPaterno("Pisco");
		cli1.setNombres("Karina");
		
		cue.setCliente(cli1);
		
		TipoCuenta tc1 = new TipoCuenta();
		tc1.setDescripcion("S/.");
		cue.setNumeroCuenta("102030415060");
		
		
		manager.persist(cue);
		tx.commit();
		List<Cliente> lista = manager.createQuery("from Cliente", Cliente.class).getResultList();
		for (Cliente cliente : lista)
		{
			System.out.println(cliente);
			
		}

	}

}
