package lab1;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class principal {
	int n=40;
	Carteraprestamo registro[] = new Carteraprestamo[n];
	
	public static void main(String[] args) {
		principal here = new principal();
		int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			while (opcion == 0)
			{
				here.inicio(); 
				here.ingresarycalcular();   
				here.ventanasaprobados();
				here.resultadoscalculos();
				opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
						"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			}
	}
	public void inicio() {
		JOptionPane.showMessageDialog(null, "Bienvenido\n"+"Préstamos y Financiamientos, S.A");
		n=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de prestamos a procesar de este reporte"));	
	}
	
	public void ingresarycalcular() {
		if(n>40||n<=0) {JOptionPane.showMessageDialog(null, "Sistema no reconoce la entrada min 1 - max 40");
			System.exit(1);}
		for(int contreporte=0;contreporte<n;contreporte++) {
			String cedula;
			String nombre; 
			String contacto;
			String email;
			int tipoempresa;
			String departamento;
			float salario;
			float capacidadpago;
			int institucionfinan;
			int opcionesprestamos;
			float valorfinanciado;
			int mesescuota;
			float intereses=0f;
			float comisionprest;
			float totalfinanciamiento;
			float letramensual=0f;
			boolean desenbolso=false;
			
			JOptionPane.showMessageDialog(null, "Ingrese los datos del solicitante de prestamo");
			cedula = JOptionPane.showInputDialog(null, "Ingrese Cédula");
			nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre Completo");
			contacto = JOptionPane.showInputDialog(null, "Ingrese Contacto");
			email = JOptionPane.showInputDialog(null, "Ingrese email");
			tipoempresa = JOptionPane.showOptionDialog(null,
					"seleccione el tipo de empresa","Registro de prestamo",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Independiente", "Gobierno", "E.Privada"}," "); 
			departamento = JOptionPane.showInputDialog(null, "Ingrese Departamento");
			salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el salario: ")) ;
			capacidadpago = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese su capacidad de pago: ")) ;
			
			switch(tipoempresa)   
			{
			case 0:{
				if(capacidadpago<(0.50f*salario)) {desenbolso=false; break;}
				else{desenbolso=true; break;}    //(capacidadpago<nuv)
			}
			case 1:{
				
				if (capacidadpago<(0.40f*salario)){desenbolso=false; break;}
				else{desenbolso=true; break;} //(capacidadpago<nuv)
			}
			case 2:{
				
				if (capacidadpago<(0.25f*salario)) {desenbolso=false; break;}
				else{desenbolso=true; break;}  //(capacidadpago<nuv) 
				}
			}
			
			institucionfinan = JOptionPane.showOptionDialog(null,
					"seleccione la institución de financiamiento","Registro de prestamo",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Cooperativa CACSA, R.L", "Canal Bank", "Financiera del Pueblo"}," "); 
			opcionesprestamos = JOptionPane.showOptionDialog(null,
					"seleccione el tipo de prestamo","Registro de prestamo",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Personales 2.75%", "Negocios 3.25%", "Otros 4.50%"}," ");
			do {
			valorfinanciado=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese su cantidad que desea Financiar: (1,000-10,000)")) ;
			}while(valorfinanciado<1000||valorfinanciado>10000);
			
			mesescuota =JOptionPane.showOptionDialog(null,
					"seleccione el plazo del prestamo","Registro de prestamo",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"1- 24 meses", "2- 48 Meses", "3- 60 Meses"}," ");
						
				
			if(salario<600||salario>3500) {
				desenbolso=false;
			}	//apaga el prestamo por su cantidad de salario
			
			/*
			if(valorfinanciado<1000||valorfinanciado>10000) {
				desenbolso=false;			} //apaga el prestamo si el desembolso no cumple los montos 1000 - 10000
			*/
			comisionprest=valorfinanciado*0.185f;
			
			switch(opcionesprestamos) {
			case 0:{
			if(mesescuota==0) {intereses=(valorfinanciado*0.0275f*24); break;}
			if(mesescuota==1) {intereses=(valorfinanciado*0.0275f*48); break;}
			if(mesescuota==2) {intereses=(valorfinanciado*0.0275f*60); break;}
					}
			case 1:{
			if(mesescuota==0){intereses=(valorfinanciado*0.0325f*24); break;}
			if(mesescuota==1){intereses=(valorfinanciado*0.0325f*48); break;}
			if(mesescuota==2){intereses=(valorfinanciado*0.0325f*60); break;}
			}
			case 2:{
			if(mesescuota==0){intereses=(valorfinanciado*0.0450f*24); break;}
			if(mesescuota==1){intereses=(valorfinanciado*0.0450f*48); break;}
			if(mesescuota==2){intereses=(valorfinanciado*0.0450f*60); break;}	
			}
			}
			
			totalfinanciamiento = (valorfinanciado+intereses+comisionprest);
			
			switch (mesescuota) {
			case 0:{letramensual = (totalfinanciamiento/24); break;}
			case 1:{letramensual = (totalfinanciamiento/48); break;}
			case 2:{letramensual = (totalfinanciamiento/60); break;}
			}
			
			if(desenbolso==true) 
			{
			if(capacidadpago>=letramensual) {desenbolso=true;}
			if(capacidadpago<letramensual) {desenbolso=false;}
			}
			
			
			//las variables se guardaron ya no procesar luego
			Carteraprestamo temp = new Carteraprestamo();
			
			temp.setCedula(cedula);
			temp.setNombre(nombre);
			temp.setContacto(contacto);
			temp.setEmail(email);
			temp.setTipoempresa(tipoempresa);
			temp.setDepartamento(departamento);
			temp.setSalario(salario);
			temp.setCapacidadpago(capacidadpago);
			temp.setInstitucionfinan(institucionfinan);
			temp.setOpcionesprestamos(opcionesprestamos);
			temp.setValorfinanciado(valorfinanciado);
			temp.setMesescuota(mesescuota);
			temp.setIntereses(intereses);
			temp.setComisionprest(comisionprest);
			temp.setTotalfinanciamiento(totalfinanciamiento);
			temp.setLetramensual(letramensual);
			temp.setDesenbolso(desenbolso);
			registro[contreporte]= temp;
		}
	}

	public void ventanasaprobados() {
		for(int i=0;i<n ;i++) {
			if(registro[i].isDesenbolso()==true) {JOptionPane.showMessageDialog(null,registro[i].getNombre()+"  Su Financiamiento Total del Prestamo ha sido Aprobado.");}
			if(registro[i].isDesenbolso()==false){JOptionPane.showMessageDialog(null,registro[i].getNombre()+"  Su Capacidad de Pago, NO cumple con los requisitos de la Institución...");}
			}
	}
		
	public void resultadoscalculos() {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MMMM-yyyy 'Hora:' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String ax= "\t\t\t\tPRESTAMOS Y FINANCIAMIENTOS, S.A\n\t\t\t\tREPORTE DE SOLICITUD DE PRESTAMOS";
		ax+="\n\t\t\t\t\t\t\t\t\t\t\tFecha:"+(formatter.format(date));
		ax+="\nProgramador: xxxxx xxxxxxx\t\t\t\t\t"+"CÉDULA: x-xxx-xxxx";
		ax+="\n\nNO.  Cedula\tNombre\tContacto\tEmail\t    Tipo de Empresa\tDepartamento\tSalario\tCapacidad de Pago\tInst Fin\t\tOpcion Prest\t\tValor de Prest\tTipo Cuotas\tIntereses\tCom Prest\tTotal Fin\tLetra Mes\tDesembolso\n";
		JTextArea salida = new JTextArea();
		salida.setText(ax);
		
		for(int i=0;i<n;i++)
		{
			salida.append((i+1)+"  ");
			salida.append(registro[i].getCedula()+"\t");
			salida.append(registro[i].getNombre()+"\t");
			salida.append(registro[i].getContacto()+"\t");
			salida.append(registro[i].getEmail()+"\t\t");
			String tipo[]={"Independiente","Gobierno","E.Privada"};
			salida.append(tipo[registro[i].getTipoempresa()]+"\t"); //agregado el arreglo nombre
			salida.append(registro[i].getDepartamento()+"\t");
			salida.append(String.format("%.2f",registro[i].getSalario())+"\t");
			salida.append(String.format("%.2f",registro[i].getCapacidadpago())+"\t\t   ");
			String inst[]= {"Cooperativa CACSA, R.L","Canal Bank","Financiera del Pueblo"};
			salida.append(inst[registro[i].getInstitucionfinan()]+"\t");  //agregado el nombre inst
			String opt[]= {"Personales 2.75%","Negocios 3.25%","Otros 4.50%"};
			salida.append(opt[registro[i].getOpcionesprestamos()]+"\t");  //agregado el nombre opciones de presta
			salida.append(String.format("%.2f",registro[i].getValorfinanciado())+"\t");
			String Downp[]={"24 meses","48 Meses","60 Meses"};
			salida.append(Downp[registro[i].getMesescuota()]+"\t");  //agregado el nombre tipo de coutas y cantidad 
			salida.append(String.format("%.2f",registro[i].getIntereses())+"\t");
			salida.append(String.format("%.2f",registro[i].getComisionprest())+"\t");
			salida.append(String.format("%.2f",registro[i].getTotalfinanciamiento())+"\t");
			salida.append(String.format("%.2f",registro[i].getLetramensual())+"\t");
			String valu="";
			if(registro[i].isDesenbolso()==true){valu="Sí";}
			if(registro[i].isDesenbolso()==false){valu="No";}
			salida.append(valu+"\n");  //poner SI y poner No

		}
		JOptionPane.showMessageDialog(null, salida,"Prestamos y Financiamientos, S.A.,",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "En prestamos y Financiamientos...\n¡Los Mejores!");
		}

}
