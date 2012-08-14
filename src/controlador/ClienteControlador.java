package controlador;

import java.util.ArrayList;
import java.util.List;

import dominio.BaseDatos;
import dominio.Cliente;

public class ClienteControlador {
	
		BaseDatos BD = new BaseDatos();
	
		public Cliente BuscarCliente(String codigo){		
				
				List<Cliente> listaCliente = BD.devolverClientes();
				
				for (Cliente item:listaCliente)
				{
					if (codigo.equals(item.getCodigo()))
						return item;				
				}
				
				return null;
				
			}

		public List<Cliente> buscarCliente(List<Cliente> aListadoCliente, Cliente sFiltros) {
			List<Cliente> aListado=new ArrayList<Cliente>();
			Cliente sCliente=null;
		
			if(sFiltros.getCodigo()=="0" && sFiltros.getNombres()=="" && sFiltros.getApellidos()==""
					&& sFiltros.getNumeroDocumento()=="")
			{
				aListado=aListadoCliente;
			}
			else{
				for (int i = 0; i < aListadoCliente.size(); i++) {
					Boolean bEncontro=false;	
					sCliente=aListadoCliente.get(i);
						if (sFiltros.getCodigo() != "0" &&  sCliente.getCodigo() == sFiltros.getCodigo() )
						{
							bEncontro=true;
						}
						if (sFiltros.getNombres()!="" && sFiltros.getNombres().equalsIgnoreCase(sCliente.getNombres()))
						{
							bEncontro=true;
						}
						if (sFiltros.getApellidos()!="" && sFiltros.getApellidos().equalsIgnoreCase(sCliente.getApellidos()))
						{
							bEncontro=true;
						}
						if (sFiltros.getNumeroDocumento()!="" && sFiltros.getNumeroDocumento().equalsIgnoreCase(sCliente.getNumeroDocumento()))
						{
							bEncontro=true;
						}
						
					if (bEncontro==true)
					{
						aListado.add(sCliente);
					}
				}	
			}
			
			
			//aListado=OrdenarXFecha(aListado);
			
			return aListado;
		}
					
		public Boolean buscarClienteXCodigo(List<Cliente> aListadoCliente, String iCodigo) {
			//Cliente sClienteResultado= new Cliente();
			Cliente sCliente=null;
			Boolean bEncontro=false;
			for (int i = 0; i < aListadoCliente.size(); i++) {	
				sCliente=aListadoCliente.get(i);
				if (sCliente.getCodigo()==iCodigo )
				{
					bEncontro=true;
				}
			}
			return bEncontro;
		}
		
		public Cliente buscarClienteXCodigo_v2(List<Cliente> aListadoCliente, String iCodigo) {
			Cliente sClienteResultado= new Cliente();
			Cliente sCliente=null;
			for (int i = 0; i < aListadoCliente.size(); i++) {
				Boolean bEncontro=false;	
				sCliente=aListadoCliente.get(i);
					if (sCliente.getCodigo()==iCodigo )
					{
						bEncontro=true;
					}
					
				if (bEncontro==true)
				{
					sClienteResultado=sCliente;
				}
			}
			
			return sClienteResultado;
		}

		public List<Cliente> GrabarCliente(List<Cliente> aListadoCliente, Cliente sCliente)
		{
			aListadoCliente.add(sCliente);
			return aListadoCliente;
		}
				
		public Boolean actualizarCliente(Cliente sCliente, String[] sFiltros) {
			boolean bEncontro=true;
			sCliente.setNombres(sFiltros[1]);
			sCliente.setApellidos(sFiltros[2]);
			sCliente.setNumeroDocumento(sFiltros[5]);
			sCliente.setTelefono(sFiltros[6]);
			sCliente.setCorreo(sFiltros[7]);
			sCliente.setEstado(sFiltros[10]);
			return bEncontro;
			
		}
		
		public Boolean EliminarCliente(Cliente sCliente) {
			boolean bEncontro=true;
			sCliente.setEstado("I");
			return bEncontro;
			
		}

		
}
