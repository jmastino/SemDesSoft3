package pry1DSIII;


/**
 * Esta clase esta destinada para contener los datos que seran utilizados en la clase main del proyecto sobre cotización de polizas
 * <p><b>recuerde que son varias variables que seran utilizadas como metodo de array</b></p>
 * @author Jordy 
 */
public class Datos {

	private String cedula;
	private String nombre;
	private String direccion;
	//private Date fechanacimiento;
	private int añonacimiento;
	private int mesnacimiento;
	private int dianacimiento;
	private String contacto;
	private int idvip;   //es un numero autogenerado en cada run de programa
	private int opcionseguro=0;  //recuerda manejar la salida como arreglo
	private int compañiaaseguradora;
	private float bonovip; //necesitas que el numero generado sea checado con respecto a este espacio
	/* si id vip es de 1-20 bono vip es 5%   IDENTIFICADOR  1
	 * si id vip es de 21-50 bono vip es 7.5%  IDENTIFICADOR  2
	 * si id vip es de 51-100 bono vip es 	8.75% IDENTIFICADOR  3
	 * si id vip es de >100 bono vip es 10%  IDENTIFICADOR  4 */
	
	/*
	 * A PARTIR DE AQUI SOLO ES PARA EL CASO DE POLIZA DE AUTO 
	 * 
	 */
	private float valordelauto;
	private int añodelauto;
	private float depreciaciondelauto;
	private float nuevovalordeauto;
	private float valordepolizadelauto;
	
	
	//estas variables aplican tanto para casa como para auto y de vida-
	
	private float descuentobonovip; //este debe ser calculado en codigo por el numero de bono vip
	private float nuevovalordelapoliza;
	private int plazodepago;
	private float letramensual;
	//la secuencia de meses debe imprimirse para las letras y su respectiva amortizacion
	//secuencia 		valor de la poliza		LETRA 		nuevo saldo 
	
	/**
	 * RECUERDE AHORA ES PARA EL CASO DE SEGURO DE CASA YA NO ES DE AUTOMOVIL 
	 * 
	 */
	private float valordelacasa;

	private float depreciaciondelacasa;
	private float nuevovalordelacasa;
	private float valordepolizadelacasa;
	//recordad la variable descuentobonovip se usa aqui y las demas ultimas 
	

	
	
	// private float sumapropuestasegurovida; esta variable no es necesaria
	// desde 10,000.00 hasta 100,000.00
	private float valorasegurar;  //valor a asegurar 
	private int edad;
	private float valorpolizadevida;
	/**
	 * a tener en cuenta por las edades 1-25 es 100%
	 * 									26-50 es 88.75%
	 * 									51-75 es 54.15%
	 * 									76-100 es 38.50%
	 * 									> 100  es 23.75%
	 */
	
	private float porvida;
	
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getAñonacimiento() {
		return añonacimiento;
	}
	public void setAñonacimiento(int añonacimiento) {
		this.añonacimiento = añonacimiento;
	}
	public int getMesnacimiento() {
		return mesnacimiento;
	}
	public void setMesnacimiento(int mesnacimiento) {
		this.mesnacimiento = mesnacimiento;
	}
	public int getDianacimiento() {
		return dianacimiento;
	}
	public void setDianacimiento(int dianacimiento) {
		this.dianacimiento = dianacimiento;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public int getIdvip() {
		return idvip;
	}
	public void setIdvip(int idvip) {
		this.idvip = idvip;
	}
	public int getOpcionseguro() {
		return opcionseguro;
	}
	public void setOpcionseguro(int opcionseguro) {
		this.opcionseguro = opcionseguro;
	}
	public int getCompañiaaseguradora() {
		return compañiaaseguradora;
	}
	public void setCompañiaaseguradora(int compañiaaseguradora) {
		this.compañiaaseguradora = compañiaaseguradora;
	}
	public float getBonovip() {
		return bonovip;
	}
	public void setBonovip(float bonovip) {
		this.bonovip = bonovip;
	}
	public float getValordelauto() {
		return valordelauto;
	}
	public void setValordelauto(float valordelauto) {
		this.valordelauto = valordelauto;
	}
	public int getAñodelauto() {
		return añodelauto;
	}
	public void setAñodelauto(int añodelauto) {
		this.añodelauto = añodelauto;
	}
	public float getDepreciaciondelauto() {
		return depreciaciondelauto;
	}
	public void setDepreciaciondelauto(float depreciaciondelauto) {
		this.depreciaciondelauto = depreciaciondelauto;
	}
	public float getNuevovalordeauto() {
		return nuevovalordeauto;
	}
	public void setNuevovalordeauto(float nuevovalordeauto) {
		this.nuevovalordeauto = nuevovalordeauto;
	}
	public float getValordepolizadelauto() {
		return valordepolizadelauto;
	}
	public void setValordepolizadelauto(float valordepolizadelauto) {
		this.valordepolizadelauto = valordepolizadelauto;
	}
	public float getDescuentobonovip() {
		return descuentobonovip;
	}
	public void setDescuentobonovip(float descuentobonovip) {
		this.descuentobonovip = descuentobonovip;
	}
	public float getNuevovalordelapoliza() {
		return nuevovalordelapoliza;
	}
	public void setNuevovalordelapoliza(float nuevovalordelapoliza) {
		this.nuevovalordelapoliza = nuevovalordelapoliza;
	}
	public int getPlazodepago() {
		return plazodepago;
	}
	public void setPlazodepago(int plazodepago) {
		this.plazodepago = plazodepago;
	}
	public float getLetramensual() {
		return letramensual;
	}
	public void setLetramensual(float letramensual) {
		this.letramensual = letramensual;
	}
	public float getValordelacasa() {
		return valordelacasa;
	}
	public void setValordelacasa(float valordelacasa) {
		this.valordelacasa = valordelacasa;
	}
	public float getDepreciaciondelacasa() {
		return depreciaciondelacasa;
	}
	public void setDepreciaciondelacasa(float depreciaciondelacasa) {
		this.depreciaciondelacasa = depreciaciondelacasa;
	}
	public float getNuevovalordelacasa() {
		return nuevovalordelacasa;
	}
	public void setNuevovalordelacasa(float nuevovalordelacasa) {
		this.nuevovalordelacasa = nuevovalordelacasa;
	}
	public float getValordepolizadelacasa() {
		return valordepolizadelacasa;
	}
	public void setValordepolizadelacasa(float valordepolizadelacasa) {
		this.valordepolizadelacasa = valordepolizadelacasa;
	}
	public float getValorasegurar() {
		return valorasegurar;
	}
	public void setValorasegurar(float valorasegurar) {
		this.valorasegurar = valorasegurar;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getValorpolizadevida() {
		return valorpolizadevida;
	}
	public void setValorpolizadevida(float valorpolizadevida) {
		this.valorpolizadevida = valorpolizadevida;
	}
	
	public float getPorvida() {
		return porvida;
	}
	public void setPorvida(float porvida) {
		this.porvida = porvida;
	}
}
