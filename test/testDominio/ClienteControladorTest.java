package testDominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dominio.BaseDatos;
import controlador.ClienteControlador;
import dominio.Cliente;

public class ClienteControladorTest {
	
	private List<Cliente> objListadoCli;

	@Before
	public void Inicio()
	{
		objListadoCli=new ArrayList<Cliente>();
		Cliente sCliente1 = new Cliente("1", "Luis", "Cabrera Aldui", 1, 0, "10771683", "4641228", "ealdui@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru" );
		Cliente sCliente2 = new Cliente("2", "Ricardo", "Linares Livia", 1, 0, "1111111", "4641228", "ealdui@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru" );
		Cliente sCliente3 = new Cliente("3", "Yovani", "Cueva Moron", 1, 0, "12345678", "4641228", "ealdui@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru" );
		Cliente sCliente4 = new Cliente("4", "Ronald", "Quilca Condori", 1, 0, "222222", "4641228", "ealdui@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru" );
		Cliente sCliente5 = new Cliente("5", "Miguel", "Dávila", 1, 0, "9876541", "4641228", "ealdui@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru" );
		
		objListadoCli.add(sCliente1);
		objListadoCli.add(sCliente2);
		objListadoCli.add(sCliente3);
		objListadoCli.add(sCliente4);
		objListadoCli.add(sCliente5);
	}
	
	//@Test
	public void testBuscarCliente() {
		List<Cliente> objListado= new  ArrayList<Cliente>();
		Cliente sFiltros = new Cliente("","","", 0, 0,"1111111","","","","","","");
		ClienteControlador oCtrCli= new ClienteControlador();
		objListado=oCtrCli.buscarCliente(objListadoCli, sFiltros);
		
		if (objListado.size()>0)
		{
			BaseDatos.listarObjeto(objListado);
			assertTrue(objListado.size()>0);
		}
		else
		{
			assertTrue("No se encontraron registros para los filtros ingresados", objListado.size()==0);
		}
	}

	//@Test
	public void testBuscarCliente1() {
		fail("Not yet implemented");
	}

	//@Test
	public void testBuscarClienteXCodigo() {
		fail("Not yet implemented");
	}

	//@Test
	public void testGrabarCliente() {
		Cliente sCliente6 = new Cliente("6", "Benjamin", "Cabrera Murazzo", 1, 0, "40408423", "4641228", "ealdui@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru");
		ClienteControlador oCtrCli= new ClienteControlador();
		//Validando si el DNI ya se encuentra registrado
		
		Boolean iResultado=oCtrCli.buscarClienteXCodigo(objListadoCli, sCliente6.getNumeroDocumento());
		if (iResultado==false)
		{
			objListadoCli=oCtrCli.GrabarCliente(objListadoCli, sCliente6);
			System.out.println("Datos registrados correctamente");
			assertFalse("Datos registrados correctamente", iResultado);
		}
		else
		{
			System.out.println("El codigo ya existe en la BD");
			assertTrue("El codigo ya existe en la BD", iResultado);
		}
	}

	@Test
	public void testActualizarCliente() {
		//Validando si el usuario existe por codigo
		String[] sCliente6 ={"3", "Benjamin", "Cabrera Murazzo", "1", "0", "40408423", "4641228", "benjamon@hotmail.com", "Jr Ferrer 237", "Lima", "Lima", "peru"};
		ClienteControlador oCtrCli= new ClienteControlador();
		
		Cliente sClienteResultado=oCtrCli.buscarClienteXCodigo_v2(objListadoCli, sCliente6[0]);
		
		Boolean bValor=false;
		
		if (sClienteResultado.getCodigo()!="0" &&  (!sClienteResultado.equals(null)))
		{
			bValor=oCtrCli.actualizarCliente(sClienteResultado, sCliente6);
			if (bValor==true)
			{
				System.out.println("Datos actualizados correctamente");
				assertTrue("Datos actualizados correctamente",bValor);
			}
		}
		else
		{
			System.out.println("El cliente a actualizar no existe en la BD");
			assertTrue("El cliente a actualizar no existe en la BD",bValor);
		}
	}

	//@Test
	public void testEliminarCliente() {
		String iCliente6 ="6";
		ClienteControlador oCtrCli= new ClienteControlador();
		Cliente sClienteResultado=oCtrCli.buscarClienteXCodigo_v2(objListadoCli, iCliente6);
		Boolean bValor=false;
		if (sClienteResultado.getCodigo() != "0" &&  (!sClienteResultado.equals(null)))
		{
			bValor=oCtrCli.EliminarCliente(sClienteResultado);				
			if (bValor==true)
			{
				System.out.println("Cliente eliminado correctamente");
				assertTrue("Cliente eliminado correctamente",bValor);
			}
		}
		else
		{
			System.out.println("El cliente a eliminar no existe en la BD");
			assertTrue("El cliente a eliminar no existe en la BD",bValor);
		}
	}

}
