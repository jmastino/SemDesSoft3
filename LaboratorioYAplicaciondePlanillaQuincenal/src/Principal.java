import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
		//Multi Service Infinity, S.A
		
		String[] tabcolaborador = {"Alberto Pinzón","Maldonado Xiu","Isabella Chavez","Daniel Contreras","Andrea Miranda","Yassy Del Carmen","Lucas Cardenas","Betzi Pinzon","Kirian Miranda"};
		String[] tabdepto={"Gerencia","Taller","Ventas","Taller","Gerencia","Taller","Ventas","Gerencia","Taller"};
		float[] tabpago_quincenal={1839.94f,2187.73f,1986.86f,2577.81f,2754.52f,2190.84f,3345.31f,4178.42f,3378.12f};
		float tabotros[]={9.75f,12.25f,10.75f,12.25f,14.75f,16.55f,8.79f,7.49f,9.25f};
		Principal here = new Principal();
		
		float[] tabsegsocial={0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for (int i=0;i<tabsegsocial.length;i++) {
			tabsegsocial[i]=0.0925f*tabpago_quincenal[i];
		}
		
		float[] tabsegeducativo={0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for(int i=0;i<tabsegeducativo.length;i++)
		{
			tabsegeducativo[i]=0.0125f*tabpago_quincenal[i];
		}
		
		float[] tabISR={0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for(int i=0;i<tabISR.length;i++) {
			tabISR[i]=0.1295f*tabpago_quincenal[i];
		}
		
		float[] tabotros2={0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for (int i=0;i<tabotros2.length;i++) {
			tabotros2[i]=(tabotros[i]/100)*tabpago_quincenal[i];
		}
		
		float[] tabincxdepto={0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for(int i=0;i<tabincxdepto.length;i++)  // rompe con depto
		{
			if(tabdepto[i]=="Gerencia"){
				tabincxdepto[i]=0.035f*tabpago_quincenal[i];
			}
			if(tabdepto[i]=="Ventas"){
				tabincxdepto[i]=0.0512f*tabpago_quincenal[i];
			}
			if(tabdepto[i]=="Taller") {
				tabincxdepto[i]=0.048f*tabpago_quincenal[i];
			}
		}
		
		float[] totaldesc= {0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for(int i=0;i<tabcolaborador.length;i++) {
			totaldesc[i]=(tabsegeducativo[i]+tabsegsocial[i]+tabISR[i]+tabotros2[i]);
		}
		
		
		float[] tabpagoneto={0f,0f,0f,0f,0f,0f,0f,0f,0f};
		for(int i=0;i<tabcolaborador.length;i++) {
			tabpagoneto[i]=(tabpago_quincenal[i]-totaldesc[i]+tabincxdepto[i]);
		}
			
		float[][] desglose = new float[9][9];
		DecimalFormat sr = new DecimalFormat("#");
		sr.setRoundingMode(RoundingMode.DOWN);
		DecimalFormat formatodin = new DecimalFormat("$####.##");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MMMM-yyyy 'Hora:' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		for(int i=0;i<tabcolaborador.length;i++) 
		{
			System.out.println("**************************************************************************************************************");
			System.out.println("\t\tMulti Service Infinity, S.A"+"\n\t\tBOLETA DE PAGO"+"\n\t\tAL: "+(formatter.format(date)));
			System.out.println("Programado por: xxxxxxxxxxxxxxxxx\t\t\tCédula:xxxxxxxxxxxxxxxxxxx ");
			System.out.println("Datos generales del empleado:");
			DecimalFormat formato = new DecimalFormat("000");
			System.out.println("Nombre:"+tabcolaborador[i]+ " Depto:"+tabdepto[i]+" Pago Quincenal: "+tabpago_quincenal[i]+" Boleta No."+formato.format(i+1));
			System.out.println("Descuentos Obligatorios:");
			
			System.out.println("Seguro Social: "+formatodin.format(tabsegsocial[i])+" Seguro Educativo: "+formatodin.format(tabsegeducativo[i])+" Imp Renta: "+formatodin.format(tabISR[i])+" Otros: "+formatodin.format(tabotros2[i]));
			System.out.println("Total Descuentos: "+formatodin.format(totaldesc[i])+" Incentivo: "+formatodin.format(tabincxdepto[i])+" Pago Neto a Cobrar: "+formatodin.format(tabpagoneto[i]));
			desglose=here.funcioncontar(tabpagoneto);
			System.out.println("\nDesglose de billetes y monedas: ");
			System.out.println("Billetes:\t\t\t\t\tTotales");
			System.out.println("$20.00  "+sr.format(desglose[i][0])+" $10.00  "+sr.format(desglose[i][1])+" $5.00  "+sr.format(desglose[i][2])+" $1.00  "+sr.format(desglose[i][3])+"\t\t"+formatodin.format(desglose[i][9]));
			System.out.println("Monedas");
			System.out.println("$0.50 "+sr.format(desglose[i][4])+"  $0.25 "+sr.format(desglose[i][5])+"  $0.10 "+sr.format(desglose[i][6])+"  $0.05 "+sr.format(desglose[i][7])+"  $0.01 "+sr.format(desglose[i][8])+"\t"+formatodin.format(desglose[i][10]));
			System.out.println("Total a Cobrar:\t\t\t\t\t"+formatodin.format(tabpagoneto[i]));
		}
		System.out.println("**************************************************************************************************************");
		
		//el desglose total de dinero
		float[] desglosetotal = new float[11];
		for(int i=0;i<9;i++) {
			desglosetotal[0]+=desglose[i][0];    //billete 20
			desglosetotal[1]+=desglose[i][1];	//billete 10
			desglosetotal[2]+=desglose[i][2];	//billete 5
			desglosetotal[3]+=desglose[i][3];	//billete 1
			desglosetotal[4]+=desglose[i][4];	//Moneda  0.50
			desglosetotal[5]+=desglose[i][5];	//Moneda  0.25
			desglosetotal[6]+=desglose[i][6];	//Moneda  0.10
			desglosetotal[7]+=desglose[i][7];	//Moneda  0.05
			desglosetotal[8]+=desglose[i][8];	//Moneda  0.01
		}
		for(int i=0;i<9;i++) {
		desglosetotal[9]=(int)(desglosetotal[0])*20+(int)(desglosetotal[1])*10+(int)(desglosetotal[2])*5+(int)(desglosetotal[3])*1;
		desglosetotal[10]=(int)(desglosetotal[4])*0.50f+(int)(desglosetotal[5])*0.25f+(int)(desglosetotal[6])*0.10f+(int)(desglosetotal[7])*0.05f+(desglosetotal[8])*0.01f;
		}
		System.out.println("Resumen Final de la Planilla Quincenal");
		System.out.println("Billetes:\t\t\t\t\tTotales");
		System.out.println("$20.00  "+sr.format(desglosetotal[0])+" $10.00  "+sr.format(desglosetotal[1])+" $5.00  "+sr.format(desglosetotal[2])+" $1.00  "+sr.format(desglosetotal[3])+"\t"+formatodin.format(desglosetotal[9] ));
		System.out.println("Monedas");
		System.out.println("$0.50 "+sr.format(desglosetotal[4])+"  $0.25 "+sr.format(desglosetotal[5])+"  $0.10 "+sr.format(desglosetotal[6])+"  $0.05 "+sr.format(desglosetotal[7])+"  $0.01 "+sr.format(desglosetotal[8])+"\t"+formatodin.format(desglosetotal[10]));
		System.out.println("Total Final:\t\t\t\t\t"+(desglosetotal[9]+desglosetotal[10]));
		System.out.println("\nPago Quincenal por Departamento:");
		
		 
		int mayorv=0,menorv=0,mayorg=0,menorg=0,mayort=0,menort=0;
		mayorv = menorv = mayorg = menorg = mayort= menort=0;
				
		for(int i=0;i<tabdepto.length;i++)
		{
			if(tabdepto[i]=="Ventas") 
			{	for(int j=tabdepto.length-1;j>=0;j--) {
				
			if(tabdepto[j]=="Ventas") {if(tabpago_quincenal[i]>tabpago_quincenal[j]) {mayorv=i; menorv=j;}
			
			}}}

			if(tabdepto[i]=="Gerencia")
			{	for(int j=tabdepto.length-1;j>=0;j--) {
				
				if(tabdepto[j]=="Gerencia") {if(tabpago_quincenal[i]>tabpago_quincenal[j]) {mayorg=i; menorg=j;}
				}
				}
			}
			if(tabdepto[i]=="Taller")  
			{	for(int j=tabdepto.length-1;j>=0;j--) {
				
				if(tabdepto[j]=="Taller") {if(tabpago_quincenal[i]>tabpago_quincenal[j]) {mayort=i; menort=j;}
				}	
			}
			
			}
		}
		
	System.out.println("el empleado: "+tabcolaborador[mayorv]+" del depto: "+tabdepto[mayorv]+" tiene el mayor pago quincenal recibido con: "+formatodin.format(tabpago_quincenal[mayorv]));			
	System.out.println("el empleado: "+tabcolaborador[menorv]+" del depto: "+tabdepto[menorv]+" tiene el menor pago quincenal recibido con: "+formatodin.format(tabpago_quincenal[menorv]));
	System.out.println();
	System.out.println("el empleado: "+tabcolaborador[mayort]+" del depto: "+tabdepto[mayort]+" tiene el mayor pago quincenal recibido con: "+formatodin.format(tabpago_quincenal[mayort]));			
	System.out.println("el empleado: "+tabcolaborador[menort]+" del depto: "+tabdepto[menort]+" tiene el menor pago quincenal recibido con: "+formatodin.format(tabpago_quincenal[menort]));
	System.out.println();
	System.out.println("el empleado: "+tabcolaborador[mayorg]+" del depto: "+tabdepto[mayorg]+" tiene el mayor pago quincenal recibido con: "+formatodin.format(tabpago_quincenal[mayorg]));			
	System.out.println("el empleado: "+tabcolaborador[menorg]+" del depto: "+tabdepto[menorg]+" tiene el menor pago quincenal recibido con: "+formatodin.format(tabpago_quincenal[menorg]));
	System.out.println("\nPago Neto:");
	System.out.println("el empleado: "+tabcolaborador[here.buscarmenor(tabpagoneto)]+" del depto: "+tabdepto[here.buscarmenor(tabpagoneto)]+" tiene el menor pago neto recibido con: "+formatodin.format(tabpagoneto[here.buscarmenor(tabpagoneto)]));
	System.out.println("el empleado: "+tabcolaborador[here.buscarmayor(tabpagoneto)]+" del depto: "+tabdepto[here.buscarmayor(tabpagoneto)]+" tiene el mayor pago neto recibido con: "+formatodin.format(tabpagoneto[here.buscarmayor(tabpagoneto)]));
	System.out.println("\n\t\t\tGRANDE Y FUERTE ES NUESTRO DIOS!");
	}
	
	
	public float[][] funcioncontar(float tabpagoneto[]) {
		float[][] desglose = new float[9][11];
		for(int i=0;i<tabpagoneto.length;i++)
		{ 
		float reserva;
		desglose[i][0]=(int)(tabpagoneto[i])/20.00f;   //veinted
		reserva=tabpagoneto[i]%20.00f;
		desglose[i][1]=(int)(reserva)/10.00f;    //diezd
		reserva=reserva%10.00f;
		desglose[i][2]=(int)(reserva)/5.00f;   //cincod
		reserva=reserva%5.00f;
		desglose[i][3]=(int)(reserva)/1.00f;     //unod
		reserva=reserva%1.00f;
		desglose[i][4]=reserva/0.50f;
		reserva=reserva%0.50f;
		desglose[i][5]=reserva/0.25f;	//veintecincom
		reserva=reserva%0.25f;
		desglose[i][6]=reserva/0.10f;	//diezm
		reserva=reserva%0.10f;
		desglose[i][7]=reserva/0.05f;  //cincom
		reserva=reserva%0.05f;
		desglose[i][8]=reserva/.01f;  //unom
		}
		
		
		for(int i=0;i<tabpagoneto.length;i++)
		{ 
			desglose[i][9]=(int)(desglose[i][0])*20+(int)(desglose[i][1])*10+(int)(desglose[i][2])*5+(int)(desglose[i][3])*1;
			desglose[i][10]=(int)(desglose[i][4])*0.50f+(int)(desglose[i][5])*0.25f+(int)(desglose[i][6])*0.10f+(int)(desglose[i][7])*0.05f+(desglose[i][8])*0.01f;
		}
		return desglose;
	}
	public int buscarmayor(float tabpago_quincenal[]) {
		int mayor;
		mayor = 1;
		for(int i=0;i<tabpago_quincenal.length;i++)
		{
			if(tabpago_quincenal[i]>tabpago_quincenal[mayor]) {
				mayor=i;
			} 
		}
		return mayor;
	}
	public int buscarmenor(float tabpago_quincenal[]) {
		int menor;
		menor = 1;
		for(int i=0;i<tabpago_quincenal.length;i++)
		{
			
			if(tabpago_quincenal[i]<tabpago_quincenal[menor]) {
				menor=i;
			}
		}
		return menor;
	}
	
}