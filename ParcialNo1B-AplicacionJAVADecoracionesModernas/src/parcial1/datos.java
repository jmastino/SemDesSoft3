package parcial1;

public class datos {

	private String cedula;
	private String nombre;
	private String celular;
	private String email;
	private int proveedor;
	private int[] tipodemadera= new int[4];
	private int cantmadera;  //no puede ser mayor a 1000   es la variable que dice la cantidad de pies
	private float valordelmueble; //recuerda el descuento por proveedor  ahora saca el 35% para abono 
	private float abono;
	private float preciomanodeobra; //multiplicado por el valordelmueble
	private int tipoacabado;
	private float preciodeacabado;  //por el tipo de acabado
	private float saldototaldelmueble; //valordelmueble-descuentocliente frecuente-abono del 35%+valor de acabado+mano deobra
	private int tipopago;
	private float fdesc;
	private float preciofinal;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public int[] getTipodemadera() {
		return tipodemadera;
	}
	public void setTipodemadera(int tipodemadera[]) {
		this.tipodemadera = tipodemadera;
	}
	public int getCantmadera() {
		return cantmadera;
	}
	public void setCantmadera(int cantmadera) {
		this.cantmadera = cantmadera;
	}
	public float getValordelmueble() {
		return valordelmueble;
	}
	public void setValordelmueble(float valordelmueble) {
		this.valordelmueble = valordelmueble;
	}
	
	public float getAbono() {
		return abono;
	}
	public void setAbono(float abono) {
		this.abono = abono;
	}
	public float getPreciomanodeobra() {
		return preciomanodeobra;
	}
	public void setPreciomanodeobra(float preciomanodeobra) {
		this.preciomanodeobra = preciomanodeobra;
	}
	
	
	public int getTipoacabado() {
		return tipoacabado;
	}
	public void setTipoacabado(int tipoacabado) {
		this.tipoacabado = tipoacabado;
	}
	public float getPreciodeacabado() {
		return preciodeacabado;
	}
	public void setPreciodeacabado(float preciodeacabado) {
		this.preciodeacabado = preciodeacabado;
	}
	public float getSaldototaldelmueble() {
		return saldototaldelmueble;
	}
	public void setSaldototaldelmueble(float saldototaldelmueble) {
		this.saldototaldelmueble = saldototaldelmueble;
	}
	
	public int getTipopago() {
		return tipopago;
	}
	public void setTipopago(int tipopago) {
		this.tipopago = tipopago;
	}
	
	public float getFdesc() {
		return fdesc;
	}
	public void setFdesc(float fdesc) {
		this.fdesc = fdesc;
	}
	
	public float getPreciofinal() {
		return preciofinal;
	}
	public void setPreciofinal(float preciofinal) {
		this.preciofinal = preciofinal;
	}
	
	
	
}

