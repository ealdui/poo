package dominio;

public class Cliente {
	/* Cliente */
	@Override
	public String toString() {
		return "" + codigo + "," + nombres
				+ ", " + nombres + ", "
				+ apellidos + ", " + numeroDocumento + ", " + telefono
				+ ", " + correo + ", " + estado + ", "
				+ direccion + "";
	}
	
	private String codigo = "";
	private String nombres = "";
	private String apellidos = "";
	private int tipoCliente = 0; //1=prospecto, 2=contacto, 3=cliente
	private int codigoTipoDocumento = 0;
	private String numeroDocumento = "";
	private String telefono = "";
	private String correo = "";
	private String direccion = "";
	private String ciudad = "";
	private String estado = "";
	private String pais = "";
		
	public Cliente(String codigo, String nombres, String apellidos, int tipoCliente, int codigoTipoDocumento, String numeroDocumento,String telefono, String correo, String direccion, 
			String ciudad, String estado, String pais) {
		setCodigo(codigo);
		setNombres(nombres);
		setApellidos(apellidos);
		setTipoCliente(tipoCliente);
		setCodigoTipoDocumento(codigoTipoDocumento);
		setNumeroDocumento(numeroDocumento);
        setTelefono(telefono);
        setCorreo(correo);
        setDireccion(direccion);
        setCiudad(ciudad);
        setEstado(estado);
        setPais(pais);
    }

		
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(int codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String DarAltaCliente() {
		if(this.getCodigo()=="") return "ERROR, ingrese el codigo.";
		else if(this.getNombres()=="") return "ERROR, ingrese el nombre.";
		else if(this.getApellidos()=="") return "ERROR, ingrese el apellido.";
		else if(this.getTipoCliente()==0) return "ERROR, ingrese el tipo de cliente.";
		else if(this.getCodigoTipoDocumento()==0) return "ERROR, ingrese el codigo tipo de cliente.";
		else if(this.getNumeroDocumento()=="") return "ERROR, ingrese el numero de documento.";
		else if(this.getTelefono()=="") return "ERROR, ingrese el telefono.";
		else if(this.getCorreo()=="") return "ERROR, ingrese el correo.";
		else if(this.getDireccion()=="") return "ERROR, ingrese la dirección.";
		else if(this.getCiudad()=="") return "ERROR, ingrese la ciudad.";
		else if(this.getEstado()=="") return "ERROR, ingrese el estado.";
		else if(this.getPais()=="") return "ERROR, ingrese el pais.";
		else return "OK";
	}
	
}
