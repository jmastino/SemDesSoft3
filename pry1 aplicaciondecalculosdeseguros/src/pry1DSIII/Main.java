package pry1DSIII;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main {
	int n=1;
	Datos registro[] = new Datos[n];
	
	public static void main(String[] args) {
		Main here = new Main();
		
		int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			while (opcion == 0)
			{
				here.mostrar();
				here.ingresarycalcular();
				here.reporte(); 
				opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
						"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			}
	}
	
	public void mostrar() {
	JOptionPane.showMessageDialog(null, "Bienvenido\n"+"Abastecedora de Seguros y Suministros, S.A");	
	//n=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de Seguros a procesar de este reporte"));
	
	}
	public void ingresarycalcular() {
		if(n>50||n<=0) {JOptionPane.showMessageDialog(null, "Sistema no reconoce la entrada min 1 - max 50");
		System.exit(1);}
		for(int i=0;i<n;i++) {
		String cedula;
		String nombre;
		String direccion;
		int dianacimiento;
		int mesnacimiento;
		int añonacimiento;
		String contacto;
		int idvip;   //es un numero autogenerado en cada run de programa
		int opcionseguro=0;  //recuerda manejar la salida como arreglo  0 auto 1 casa 2 vida
		int compañiaaseguradora; //0 vida libre 1 infinity 2 Oro Puro 3 Real insurance
		float bonovip=0f; //necesitas que el numero generado sea checado con respecto a este espacio
		/* si id vip es de 1-20 bono vip es 5%   IDENTIFICADOR  1
		 * si id vip es de 21-50 bono vip es 7.5%  IDENTIFICADOR  2
		 * si id vip es de 51-100 bono vip es 	8.75% IDENTIFICADOR  3
		 * si id vip es de >100 bono vip es 10%  IDENTIFICADOR  4 */
		
		/*
		 * A PARTIR DE AQUI SOLO ES PARA EL CASO DE POLIZA DE AUTO 
		 */
		float valordelauto=0f;
		int añodelauto=0;
		float depreciaciondelauto=0f;
		float nuevovalordeauto=0f;
		float valordepolizadelauto=0f;
		//estas variables aplican tanto para casa como para auto y de vida-
		float descuentobonovip=0f; //este debe ser calculado en codigo por el numero de bono vip
		float nuevovalordelapoliza=0f;
		int plazodepago=0;
		float letramensual=0f;
		
		/*
		 * RECUERDE AHORA ES PARA EL CASO DE SEGURO DE CASA YA NO ES DE AUTOMOVIL 
		 * 
		 */
		float valordelacasa=0f;
		float depreciaciondelacasa=0f;
		float nuevovalordelacasa=0f;
		float valordepolizadelacasa=0f;
		//recordad la variable descuentobonovip se usa aqui y las demas ultimas 
		// private float sumapropuestasegurovida; esta variable no es necesaria
		// desde 10,000.00 hasta 100,000.00
		float valorasegurar=0f;  //valor a asegurar 
		int edad=0;
		float valorpolizadevida=0f;
		float porvida=0f;
		
		JOptionPane.showMessageDialog(null, "Ingrese los datos del solicitante de seguro");
		cedula = JOptionPane.showInputDialog(null, "Ingrese Cédula");
		nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre Completo");
		direccion = JOptionPane.showInputDialog(null, "Ingrese Dirección");
		dianacimiento= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Día de Nacimiento"));
		mesnacimiento= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Mes de Nacimiento"));
		añonacimiento= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Año de Nacimiento"));
		contacto=JOptionPane.showInputDialog(null, "Ingrese Contacto");
		idvip=(i+1)*4;
		opcionseguro=JOptionPane.showOptionDialog(null,
				"Seleccione el tipo de seguro","Registro de Seguro",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] {"Auto", "Casa", "Vida"}," ");
		compañiaaseguradora=JOptionPane.showOptionDialog(null,
				"Seleccione la compañia Aseguradora","Registro de Seguro",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] {"Vida Libre","Infinity", "Oro Puro", "Real Insurance"}," ");
		if(idvip>=1||idvip<=20) {bonovip=0.05f;}  //5%
		if(idvip>=21||idvip<=50) {bonovip=0.075f;} //7.5%
		if(idvip>=51||idvip<=100) {bonovip=0.0875f;}  //8.75%
		if(idvip>100){bonovip=0.10f;}  //10%
		
		switch(opcionseguro){
		case 0:{
			//auto
			
			do{
				valordelauto=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el Valor del Auto ($5000 - $55000"));
				}while(valordelauto<5000f||valordelauto>55000f);
			
			do{	
				añodelauto=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año del Auto (>2015)"));
					}while(añodelauto<2015||añodelauto>2150);
				
			depreciaciondelauto=valordelauto*0.1475f;
			nuevovalordeauto=valordelauto-depreciaciondelauto;
			valordepolizadelauto=(nuevovalordeauto*0.15f);
			descuentobonovip=(valordepolizadelauto*bonovip);
			nuevovalordelapoliza=(valordepolizadelauto-descuentobonovip);
			do {
			plazodepago=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el plazo (meses) de pago (min 1 max 18)"));
			}while(plazodepago<1||plazodepago>18);
			letramensual=nuevovalordelapoliza/plazodepago;  
			break;}
		case 1:{
			//casa
			do {
			valordelacasa=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el Valor de la Casa (40,000-100,000)"));
			}while(valordelacasa<40000||valordelacasa>100000);
			
			depreciaciondelacasa=(valordelacasa*0.185f);
			nuevovalordelacasa=valordelacasa-depreciaciondelacasa;
			valordepolizadelacasa=(nuevovalordelacasa*0.485f);
			descuentobonovip=valordepolizadelacasa*bonovip;
			nuevovalordelapoliza=valordepolizadelacasa-descuentobonovip;
			do {
				plazodepago=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el plazo (meses) de pago (min 1 max 60)"));
			}while(plazodepago<1||plazodepago>60);
			letramensual=nuevovalordelapoliza/plazodepago;
			
			break;}
		case 2:{
			//vida
			
			do {
			valorasegurar=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la suma propuesta a asegurar vida (10,000-100,000)"));
			}while(valorasegurar<10000||valorasegurar>100000);
			
			edad=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la Edad de Cliente: "));
			
			/*
			 * a tener en cuenta por las edades 1-25 es 100%
			 * 									26-50 es 88.75%
			 * 									51-75 es 54.15%
			 * 									76-100 es 38.50%
			 * 									> 100  es 23.75%
			 */
			if(edad>=1||edad<=25) {valorpolizadevida=valorasegurar; porvida=100.00f;}
			if(edad>=26||edad<=50) {valorpolizadevida=valorasegurar*0.8875f; porvida=88.75f;}
			if(edad>=51||edad<=75) {valorpolizadevida=valorasegurar*0.5415f; porvida=54.15f;}
			if(edad>=76||edad<=100) {valorpolizadevida=valorasegurar*0.3850f; porvida=38.50f;}
			if(edad>100) {valorpolizadevida=valorasegurar*0.2375f; porvida=23.75f;}
			descuentobonovip=valorpolizadevida*bonovip;
			nuevovalordelapoliza=valorpolizadevida-descuentobonovip;
			do {
				plazodepago=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Plazo de Pago: (1-36 meses) "));  }while(plazodepago<1||plazodepago>36);
			letramensual=nuevovalordelapoliza/plazodepago;
			break;}
		}
		
		Datos temp = new Datos();
		temp.setCedula(cedula);
		temp.setNombre(nombre);
		temp.setDireccion(direccion);
		temp.setDianacimiento(dianacimiento);
		temp.setMesnacimiento(mesnacimiento);
		temp.setAñonacimiento(añonacimiento);
		temp.setContacto(contacto);
		temp.setIdvip(idvip);
		temp.setOpcionseguro(opcionseguro);
		temp.setCompañiaaseguradora(compañiaaseguradora);
		temp.setBonovip(bonovip);
		temp.setValordelauto(valordelauto);
		temp.setAñodelauto(añodelauto);
		temp.setDepreciaciondelauto(depreciaciondelauto);
		temp.setNuevovalordeauto(nuevovalordeauto);
		temp.setValordepolizadelauto(valordepolizadelauto);
		temp.setDescuentobonovip(descuentobonovip);
		temp.setNuevovalordelapoliza(nuevovalordelapoliza);
		temp.setPlazodepago(plazodepago);
		temp.setLetramensual(letramensual);
		temp.setValordelacasa(valordelacasa);
		temp.setDepreciaciondelacasa(depreciaciondelacasa);
		temp.setNuevovalordelacasa(nuevovalordelacasa);
		temp.setValordepolizadelacasa(valordepolizadelacasa);
		temp.setValorasegurar(valorasegurar);
		temp.setEdad(edad);
		temp.setValorpolizadevida(valorpolizadevida);
		temp.setPorvida(porvida);
		
		registro[i]= temp;
		}	
	}
		
	public void reporte() {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MMMM-yyyy 'Hora:' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		DecimalFormat formatodin = new DecimalFormat("$####.##");
		String ax= "\t\t\t\tABASTECEDORA DE SEGUROS Y SUMINISTROS, S.A\n\t\t\t\tCOTIZACION Y REPORTE DE SECUENCIA DE PAGOS";
		ax+="\n\t\t\t\t\tFecha:"+(formatter.format(date));
		ax+="\nProgramador: xxxxx xxxxxxxx\t\t\t\t\t"+"CÉDULA: x-xxx-xxxx";
		JTextArea salida = new JTextArea();
		salida.setText(ax);
		
		for(int i=0;i<n;i++)
		{	
			salida.append("\nGenerales del Cliente:");
			salida.append("\nCliente:"+(i+1)+" Nombre: "+registro[i].getNombre()+" \tDirección: "+registro[i].getDireccion()+" \tContacto: "+registro[i].getContacto());
			salida.append("\nDato del Seguro:");
			String vol[]= {"Vida Libre","Infinity", "Oro Puro", "Real Insurance"};
			String inst[]= {"Auto","Casa","Vida"};
			salida.append("\nCompañia de Seguro: "+vol[registro[i].getCompañiaaseguradora()]+" \tOpciones de Seguro: "+inst[registro[i].getOpcionseguro()]+" \tEdad: "+registro[i].getEdad()+" \tPorc: "+registro[i].getPorvida()+"%");
			salida.append("\n% Bono VIP:"+(registro[i].getBonovip()*100f)+"% "+" Valor a Asegurar: "+registro[i].getValorasegurar()+" \tAño: "+registro[i].getAñodelauto()+" \tValor Bono VIP: "+formatodin.format(registro[i].getDescuentobonovip()));
			
			float asteri=0f;
			if(registro[i].getValordepolizadelacasa()!=0) {asteri=registro[i].getValordepolizadelacasa();}
			if(registro[i].getValorpolizadevida()!=0) {asteri=registro[i].getValorpolizadevida();}
			if(registro[i].getValordepolizadelauto()!=0) {asteri=registro[i].getValordelauto();}
			
			salida.append("\nNuevo valor: "+formatodin.format(registro[i].getNuevovalordelapoliza())+" Valor de la poliza: "+formatodin.format(asteri)+"    Plazo de pago: "+registro[i].getPlazodepago()+" Meses");
			salida.append("\nLetra Mensual:"+formatodin.format(registro[i].getLetramensual()));
			salida.append("\nSecuencia\tValor de la Poliza\tLetra\tNuevoSaldo");
			float interludio=registro[i].getNuevovalordelapoliza();
			int iop=0;
			if(registro[i].getPlazodepago()<=60) {iop=registro[i].getPlazodepago();}
			if(registro[i].getPlazodepago()<=36) {iop=registro[i].getPlazodepago();}
			if(registro[i].getPlazodepago()<=18) {iop=registro[i].getPlazodepago();}
			//la secuencia de meses debe imprimirse para las letras y su respectiva amortizacion
			//secuencia 		valor de la poliza		LETRA 		nuevo saldo
			for(int sec=0;sec<iop;sec++){
				salida.append("\n"+(sec+1)+"\t"+formatodin.format(interludio)+"\t"+formatodin.format(registro[i].getLetramensual())+"\t"+formatodin.format(interludio-registro[i].getLetramensual()));
				interludio-=registro[i].getLetramensual();
			}
		}
		JOptionPane.showMessageDialog(null, salida,"Abastecedora de Seguros y Suministros, S.A.,",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "En Seguros...\n¡Los Mas seguros!");
		}
	}