package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controlador.ClienteControlador;
import controlador.UsuarioControlador;
import dominio.OperacionCabecera.Estado;
import dominio.OperacionCabecera.TipoOperacion;
import dominio.Usuario1.Perfil;



public class BaseDatos {

	public List<OperacionCabecera> devolverOperacion(){
		List<OperacionCabecera> lista = new ArrayList<OperacionCabecera>();
		OperacionDetalle ventaDeta = null;
		OperacionCabecera ventaCabe = null;
        
		ClienteControlador clienteCo = new ClienteControlador();
        Cliente cli = clienteCo.BuscarCliente("0610428");
        
        UsuarioControlador usuarioCo = new UsuarioControlador();
        Usuario usu = usuarioCo.BuscarUsuario(1);    
        
        Date fechaVencimiento = Util.getFecha("10/08/2012");
        Date fechaPago = Util.getFecha("10/10/2012");        
        Date fechaEmision = Util.getFecha("10/09/2012");  
        
        ventaDeta = new OperacionDetalle("servicio de hosting", 410, 1, 90, 500);
        
        ventaCabe = new OperacionCabecera();        
        ventaCabe = new OperacionCabecera(1, 1, cli, 1, TipoOperacion.VENTA, usu, "IN00001", fechaEmision, "",fechaVencimiento, fechaPago, Estado.CANCELADA, ventaDeta);
        
        lista.add(ventaCabe);
        
		return lista;
	}

	public List<OperacionCabecera> devolverCompra(){
		List<OperacionCabecera> lista = new ArrayList<OperacionCabecera>();
		OperacionDetalle compraDeta = null;
		OperacionCabecera compraCabe = null;
        
		ClienteControlador clienteCo = new ClienteControlador();
        Cliente cli = clienteCo.BuscarCliente("0610430");
        
        UsuarioControlador usuarioCo = new UsuarioControlador();
        Usuario usu = usuarioCo.BuscarUsuario(1);    
        
        Date fechaVencimiento = Util.getFecha("10/08/2012");
        Date fechaPago = Util.getFecha("10/10/2012");        
        Date fechaEmision = Util.getFecha("10/09/2012");  
        
        compraDeta = new OperacionDetalle("servicio de hosting", 410, 1, 90, 500);
        
        compraCabe = new OperacionCabecera();        
        compraCabe = new OperacionCabecera(1, 1, cli, 1, TipoOperacion.COMPRA, usu, "CO00001", fechaEmision, "",fechaVencimiento, fechaPago, Estado.CANCELADA, compraDeta);
        
        lista.add(compraCabe);
        
		return lista;
	}
	
	public List<Cliente> devolverClientes(){
    	
		List<Cliente> lista = new ArrayList<Cliente>();
    	Cliente obj = null;
    	obj = new Cliente("0610428", "Luis", "Perez", 3, 1, "02145252", "5642012", "luisperez@gmail.com", "Av. La Paz 586", "Lima", "1", "Perú");
    	lista.add(obj);
    	obj = new Cliente("0610429", "carla", "Medina", 3, 1, "02145262", "5622010", "carlamedina@gmail.com", "Av. Larco 144", "Lima", "1", "Perú");
    	lista.add(obj);
    	obj = new Cliente("0610430", "Juan", "Caceres", 3, 1, "02145272", "5552012", "juancaceres@gmail.com", "Av. La Mar 255", "Lima", "1", "Perú");
    	lista.add(obj);
    	obj = new Cliente("0610431", "Maria", "Lozada", 3, 1, "02145282", "5603512", "marialozada@gmail.com", "Av. Diagonal 386", "Lima", "1", "Perú");
    	lista.add(obj);
    	obj = new Cliente("0610434", "Martha", "Lopez", 3, 1, "02145292", "5642100", "marthalopez@gmail.com", "Av. Ricardo Palma 222", "Lima", "1", "Perú");
    	lista.add(obj);    	
    	return lista;
    	
    }
    
    
	public List<Usuario1> devolverUsuarios(){
    	
    	List<Usuario1> lista = new ArrayList<Usuario1>();
    	
    	Usuario1 obj = null;
    	obj = new Usuario1(1, "Ricardo", "Linares", "rlinareslivia@gmail.com", "11111",Perfil.ADMINISTRADOR);
    	lista.add(obj);
    	obj = new Usuario1(2, "Ronald", "Quilca", "rquilca@gmail.com", "22222",Perfil.USUARIO);
    	lista.add(obj);
    	obj = new Usuario1(3, "Yovani", "Cueva", "yovanicueva@gmail.com", "33333",Perfil.USUARIO);
    	lista.add(obj);
    	
    	return lista;
    	
    }

    public static void listarObjeto(List<?> Lst){
    	if (Lst.size()>=1){
	    	for (int i = 0; i < Lst.size() ; i++) {
				System.out.println(Lst.get(i));
			}
    	}else{ 
    		System.out.println("No se encontraron resultados");
    		//MENSAJE POR NO ENCONTRAR RESULTADOS
    	}
    }
 }
    
    
    
        


