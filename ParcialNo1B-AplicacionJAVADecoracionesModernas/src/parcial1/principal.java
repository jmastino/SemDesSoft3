package parcial1;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class principal {
	int n=50;
	datos registro[]= new datos[n]; 

	public static void main(String[] args) {
		principal here = new principal();				
		int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
		while (opcion == 0)
			{
				here.inprocess();
				here.mostrargui();
				opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
						"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			}

	}
	
	public void inprocess() {
		JOptionPane.showMessageDialog(null, "Bienvenido\n"+"Decoraciones Modernas, S.A");
		n=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de ordenes de compra a procesar"));
		for(int contreporte=0;contreporte<n;contreporte++) {
			String cedula;
			String nombre;
			String celular;
			String email;
			int proveedor;
			int otipodemadera;
			int[] tipodemadera =new int[4];
			int cantmadera=0;  //no puede ser mayor a 1000   es la variable que dice la cantidad de pies
			float valordelmueble=0f; //	0  cedro 1 pino 2 caoba 3 kira 
			float abono=0.0f;
			float preciomanodeobra=0.0f; //multiplicado por el valordelmueble
			int tipoacabado;
			float preciodeacabado=0.0f;  //por el tipo de acabado
			float saldototaldelmueble=0.0f; //valordelmueble-descuentocliente frecuente-abono del 35%+valor de acabado+mano deobra
			float preciodesc=0f; 
			int tipopago;
			float preciofinal=0.0f;
			
			JOptionPane.showMessageDialog(null, "Ingrese los datos de solicitud de Mueble");
			cedula = JOptionPane.showInputDialog(null, "Ingrese Cédula");
			nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre");
			celular = JOptionPane.showInputDialog(null, "Ingrese Celular");
			email = JOptionPane.showInputDialog(null, "Ingrese email");
			proveedor = JOptionPane.showOptionDialog(null,
					"seleccione el proveedor de madera","Registro de Orden de Compra",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Muebles y Decoraciones S.A.", "Diseños & Muebles, S.A.", "Mobiliarios Rapidos, S.A."}," "); //0 = 3.5%  1= 4.5% 2=5.5%
			
			do {
			for(int i=0;i<4;i++) 
			{
					otipodemadera = JOptionPane.showOptionDialog(null,
					"seleccione el tipo de madera","Registro de Orden de Compra",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Cedro", "Pino", "Caoba","Kira"}," ");
			
			if(otipodemadera==0) {cantmadera = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de madera en Cedro"));
			tipodemadera[otipodemadera]=cantmadera;
			}
			if(otipodemadera==1) {cantmadera = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de madera en Pino"));
			tipodemadera[otipodemadera]=cantmadera;
			}
			if(otipodemadera==2) {cantmadera = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de madera en Caoba"));
			tipodemadera[otipodemadera]=cantmadera;
			}
			if(otipodemadera==3) {cantmadera = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de madera en Kira"));
			tipodemadera[otipodemadera]=cantmadera;
			}
			}
			}while((tipodemadera[0]+tipodemadera[1]+tipodemadera[2]+tipodemadera[3])<=0||(tipodemadera[0]+tipodemadera[1]+tipodemadera[2]+tipodemadera[3])>1000); 
			
			valordelmueble+=(2.5f)*tipodemadera[0];
			valordelmueble+=(3.5f)*tipodemadera[1];
			valordelmueble+=(5.0f)*tipodemadera[2];
			valordelmueble+=(6.5f)*tipodemadera[3];
			abono = valordelmueble*(0.35f);
			if(valordelmueble>=1||valordelmueble<=1850) {preciomanodeobra=valordelmueble*(0.30f);}
			if(valordelmueble>=1851||valordelmueble<=3000) {preciomanodeobra=valordelmueble*(0.20f);}	
			if(valordelmueble>=3001||valordelmueble<=5000) {preciomanodeobra=valordelmueble*(0.15f);}
			if(valordelmueble>5000) {preciomanodeobra=valordelmueble*(0.095f);}
			if(proveedor==0){preciodesc=valordelmueble*(0.035f);} 
			if(proveedor==1){preciodesc=valordelmueble*(0.045f);} 
			if(proveedor==2){preciodesc=valordelmueble*(0.055f);} 
			tipoacabado = JOptionPane.showOptionDialog(null,
					"seleccione el tipo de acabado","Registro de Orden de Compra",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"ninguno", "Barniz", "Pintura","Ambas"}," ");
			if(tipoacabado==0) {preciodeacabado=0.0f;}
			if(tipoacabado==1) {preciodeacabado=valordelmueble*(0.175f);}
			if(tipoacabado==2) {preciodeacabado=valordelmueble*(0.225f);}
			if(tipoacabado==3) {preciodeacabado=valordelmueble*(0.40f);}
			tipopago = JOptionPane.showOptionDialog(null,
					"Tipo de Pago","Registro de Orden de Compra",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"EFECTIVO", "CREDITO","CHEQUE"}," ");
			
			saldototaldelmueble=valordelmueble-preciodesc-abono+preciodeacabado+preciomanodeobra;
			float fdesc=0;
			if(tipopago==0) {
					fdesc=saldototaldelmueble*0.02f;
					preciofinal=(saldototaldelmueble)-fdesc;}
			if(tipopago==1) {
				 fdesc=saldototaldelmueble*0.04f;
				preciofinal=(saldototaldelmueble)+fdesc;}
			if(tipopago==2) {preciofinal=saldototaldelmueble;}
	
			datos temp = new datos();
			temp.setCedula(cedula);
			temp.setNombre(nombre);
			temp.setCelular(celular);
			temp.setEmail(email);
			temp.setProveedor(proveedor);
			temp.setTipodemadera(tipodemadera);  //0 cedro 1 pino 2 caoba 3 kira
			temp.setValordelmueble(valordelmueble);
			temp.setAbono(abono);
			temp.setPreciomanodeobra(preciomanodeobra);
			temp.setTipoacabado(tipoacabado);
			temp.setPreciodeacabado(preciodeacabado);
			temp.setSaldototaldelmueble(saldototaldelmueble);
			temp.setTipopago(tipopago);
			temp.setFdesc(fdesc);
			temp.setPreciofinal(preciofinal);
			registro[contreporte]= temp;
			
		}
	}
	
	public void mostrargui() {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MMMM-yyyy 'Hora:' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String ax= "\t\t\t\tDecoraciones Modernas, S.A\n\t\t\t\tPROPUESTA DE VENTA";
		ax+="\n\t\t\t\tFecha:"+(formatter.format(date));
		ax+="\nProgramador: xxxxx  xxxxxxxxx\t\t\t\t\t"+"CÉDULA: xxx-xxxxx-xx";
		ax+="\n\nNO.  Cedula\tNombre\tCelular\tEmail\t\tProveedor\tTipo de Madera y Cantidad Madera\t   Valordelmueble   Abono   Precio Mano de Obra     Precio Acabado  Saldo Total del Mueble   Tipo de Pago   Descuento\tRecargo\tPrecio Final\n";
		JTextArea salida = new JTextArea();
		salida.setText(ax);
		
		for(int i=0;i<n;i++)
		{
			salida.append((i+1)+"   ");
			salida.append(registro[i].getCedula()+"   ");
			salida.append(registro[i].getNombre()+"   ");
			salida.append(registro[i].getCelular()+"   ");
			salida.append(registro[i].getEmail()+"   ");
			String[] provee={"Muebles y Decoraciones S.A.","Diseños & Muebles, S.A.","Mobiliarios Rapidos, S.A."};
			salida.append(provee[registro[i].getProveedor()]+"   ");
			int anumadera[] = new int[4];
			anumadera=registro[i].getTipodemadera();
			salida.append("Cedro: "+anumadera[0]+"   ");
			salida.append("Pino: "+anumadera[1]+"   ");
			salida.append("Caoba: "+anumadera[2]+"   ");
			salida.append("Kira: "+anumadera[3]+"   \t");
			salida.append(String.format("%.2f",registro[i].getValordelmueble())+"\t   ");
			salida.append(String.format("%.2f",registro[i].getAbono())+"      ");
			salida.append(String.format("%.2f",registro[i].getPreciomanodeobra())+"\t\t");
			salida.append(String.format("%.2f",registro[i].getPreciodeacabado())+"\t   ");
			salida.append(String.format("%.2f",registro[i].getSaldototaldelmueble())+"\t   ");
			String pagu[]={"Efectivo","Credito","Cheque"};
			salida.append(pagu[registro[i].getTipopago()]+"\t");
			if(registro[i].getTipopago()==0) {salida.append("-"+String.format("%.2f",registro[i].getFdesc())+"\t");}
			if(registro[i].getTipopago()==1) {salida.append("\t+"+String.format("%.2f",registro[i].getFdesc()));}
			if(registro[i].getTipopago()==3) {salida.append("-\t-");}
			salida.append(String.format("\t"+"%.2f",registro[i].getPreciofinal()));
			salida.append("\n");
			}
		JOptionPane.showMessageDialog(null, salida,"Decoraciones Modernas, S.A.,",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "OFRECEMOS LOS MEJORES MUEBLES!!!");	
	}		
}