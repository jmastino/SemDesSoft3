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
			int tipodemadera;
			int cantmadera=0;  //no puede ser mayor a 1000   es la variable que dice la cantidad de pies
			float valordelmueble=0.0f; //	cantidad de madera * precio de madera recuerda el descuento por proveedor  ahora saca el 35% para abono 
			float abono=0.0f;
			float preciomanodeobra=0.0f; //multiplicado por el valordelmueble
			int tipoacabado;
			float preciodeacabado=0.0f;  //por el tipo de acabado
			float saldototaldelmueble=0.0f; //valordelmueble-descuentocliente frecuente-abono del 35%+valor de acabado+mano deobra
			float descclientefrecuente=0.0f; //ingrese% por descuento de cliente frecuente 
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
					new Object[] {"Muebles y Decoraciones S.A.", "Diseños & Muebles, S.A.", "Mobiliarios Rapidos, S.A."}," "); 
			tipodemadera = JOptionPane.showOptionDialog(null,
					"seleccione el tipo de madera","Registro de Orden de Compra",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Cedro", "Pino", "Caoba","Kira"}," ");
			while(cantmadera<=0||cantmadera>1000) {
			cantmadera = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de madera para el mueble MIN 1-MAX 1000"));
			}
			
			if(tipodemadera==0) {valordelmueble=(2.5f)*cantmadera;}
			if(tipodemadera==1) {valordelmueble=(3.5f)*cantmadera;}
			if(tipodemadera==2) {valordelmueble=(5.0f)*cantmadera;}
			if(tipodemadera==3) {valordelmueble=(6.5f)*cantmadera;}
			
			float preciodesc=0f;
			if(proveedor==0){preciodesc=valordelmueble*(0.035f);} 
			if(proveedor==1){preciodesc=valordelmueble*(0.045f);} 
			if(proveedor==2){preciodesc=valordelmueble*(0.055f);} 
			valordelmueble=valordelmueble-preciodesc;
			abono = valordelmueble*(0.35f);
			
			
			if(valordelmueble>=1||valordelmueble<=1850) {preciomanodeobra=valordelmueble*(0.30f);}
			if(valordelmueble>=1851||valordelmueble<=3000) {preciomanodeobra=valordelmueble*(0.20f);}	
			if(valordelmueble>=3001||valordelmueble<=5000) {preciomanodeobra=valordelmueble*(0.15f);}
			if(valordelmueble>5000) {preciomanodeobra=valordelmueble*(0.095f);}
				
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
			
			int esclientefrecuente = JOptionPane.showOptionDialog(null,
					"Es cliente Frecuente","Registro de Orden de Compra",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"NO", "SI"}," ");
			
			if(esclientefrecuente==0) {saldototaldelmueble=valordelmueble-abono+preciodeacabado+preciomanodeobra;}
			if(esclientefrecuente==1) {descclientefrecuente = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el porcentaje de descuento por cliente frecuente o no: ")) ;
			descclientefrecuente = descclientefrecuente/100;
			saldototaldelmueble=valordelmueble-descclientefrecuente-abono+preciodeacabado+preciomanodeobra;}
			
			
			
			if(tipopago==0) {
					float fdesc=saldototaldelmueble*0.02f;
					preciofinal=(saldototaldelmueble)-fdesc;}
			if(tipopago==1) {
				float fdesc=saldototaldelmueble*0.04f;
				preciofinal=(saldototaldelmueble)+fdesc;}
			if(tipopago==2) {preciofinal=saldototaldelmueble;}
			
			datos temp = new datos();
			temp.setCedula(cedula);
			temp.setNombre(nombre);
			temp.setCelular(celular);
			temp.setEmail(email);
			temp.setProveedor(proveedor);
			temp.setTipodemadera(tipodemadera);
			temp.setCantmadera(cantmadera);
			temp.setValordelmueble(valordelmueble);
			temp.setAbono(abono);
			temp.setPreciomanodeobra(preciomanodeobra);
			temp.setTipoacabado(tipoacabado);
			temp.setPreciodeacabado(preciodeacabado);
			temp.setSaldototaldelmueble(saldototaldelmueble);
			temp.setDescclientefrecuente(descclientefrecuente);
			temp.setTipopago(tipopago);
			temp.setPreciofinal(preciofinal);

			registro[contreporte]= temp;

			
		}
	}
	
	public void mostrargui() {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'Hora:' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String ax= "\t\t\t\tDecoraciones Modernas, S.A\n\t\t\t\tPROPUESTA DE VENTA";
		ax+="\n\t\t\t\tFecha:"+(formatter.format(date));
		ax+="\nProgramador: JORDY MASTINO\t\t\t\t\t"+"CÉDULA: 4-781-1309";
		ax+="\n\nNO.  Cedula\tNombre\tCelular\tEmail\tProveedor\tTipo de Madera\tCant Madera\tValordelmueble\tAbono\tPrecio Mano de Obra\tPrecio Acabado\t  Saldo Total del Mueble\tDesc Cliente Frec\tTipo de Pago\tPrecio Final\n";
		JTextArea salida = new JTextArea();
		salida.setText(ax);
		
		for(int i=0;i<n;i++)
		{
			salida.append((i+1)+"   ");
			salida.append(registro[i].getCedula()+"\t");
			salida.append(registro[i].getNombre()+"\t");
			salida.append(registro[i].getCelular()+"\t");
			salida.append(registro[i].getEmail()+"\t");
			salida.append(registro[i].getProveedor()+"\t");
			salida.append(registro[i].getTipodemadera()+"\t");
			salida.append(registro[i].getCantmadera()+"\t");
			salida.append(String.format("%.2f",registro[i].getValordelmueble())+"\t");
			salida.append(String.format("%.2f",registro[i].getAbono())+"\t");
			salida.append(String.format("%.2f",registro[i].getPreciomanodeobra())+"\t\t");
			salida.append(String.format("%.2f",registro[i].getPreciodeacabado())+"\t\t");
			salida.append(String.format("%.2f",registro[i].getSaldototaldelmueble())+"\t\t");
			salida.append(String.format("%.2f",registro[i].getDescclientefrecuente())+"\t\t");
			salida.append(registro[i].getTipopago()+"\t");
			salida.append(String.format("%.2f",registro[i].getPreciofinal())+"\t");
			salida.append("\n");
			}
		
	
		JOptionPane.showMessageDialog(null, salida,"Decoraciones Modernas, S.A.,",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "OFRECEMOS LOS MEJORES MUEBLES!!!");	
	}
	
		
}
