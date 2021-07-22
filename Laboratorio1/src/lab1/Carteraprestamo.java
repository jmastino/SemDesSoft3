package lab1;

public class Carteraprestamo {
	private String cedula;
	private String nombre; 
	private String contacto;
	private String email;
	private int tipoempresa;
	private String departamento;
	private float salario;
	private float capacidadpago; //25% empresa privada 40% gobierno 50%independiente
	private int institucionfinan;
	private int opcionesprestamos;
	private float valorfinanciado;  //1000 max 10000
	private int mesescuota;
	private float intereses;
	private float comisionprest;
	private float totalfinanciamiento;
	private float letramensual;
	private boolean desenbolso;  //true or false only !!! 
	
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
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTipoempresa() {
		return tipoempresa;
	}
	public void setTipoempresa(int tipoempresa) {
		this.tipoempresa = tipoempresa;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getCapacidadpago() {
		return capacidadpago;
	}
	public void setCapacidadpago(float capacidadpago) {
		this.capacidadpago = capacidadpago;
	}
	public int getInstitucionfinan() {
		return institucionfinan;
	}
	public void setInstitucionfinan(int institucionfinan) {
		this.institucionfinan = institucionfinan;
	}
	public int getOpcionesprestamos() {
		return opcionesprestamos;
	}
	public void setOpcionesprestamos(int opcionesprestamos) {
		this.opcionesprestamos = opcionesprestamos;
	}
	public float getValorfinanciado() {
		return valorfinanciado;
	}
	public void setValorfinanciado(float valorfinanciado) {
		this.valorfinanciado = valorfinanciado;
	}
	public int getMesescuota() {
		return mesescuota;
	}
	public void setMesescuota(int mesescuota) {
		this.mesescuota = mesescuota;
	}
	public float getIntereses() {
		return intereses;
	}
	public void setIntereses(float intereses) {
		this.intereses = intereses;
	}
	public float getComisionprest() {
		return comisionprest;
	}
	public void setComisionprest(float comisionprest) {
		this.comisionprest = comisionprest;
	}
	public float getTotalfinanciamiento() {
		return totalfinanciamiento;
	}
	public void setTotalfinanciamiento(float totalfinanciamiento) {
		this.totalfinanciamiento = totalfinanciamiento;
	}
	public float getLetramensual() {
		return letramensual;
	}
	public void setLetramensual(float letramensual) {
		this.letramensual = letramensual;
	}
	public boolean isDesenbolso() {
		return desenbolso;
	}
	public void setDesenbolso(boolean desenbolso) {
		this.desenbolso = desenbolso;
	}
	
	

}
