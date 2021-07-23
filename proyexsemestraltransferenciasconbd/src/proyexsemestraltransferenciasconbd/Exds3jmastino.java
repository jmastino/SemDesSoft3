package proyexsemestraltransferenciasconbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exds3jmastino {
	
	public static void main(String[] args) {
		int opcionp = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
		while (opcionp==0) {
		
		String cedula, nombre_cliente,contacto,email,profesion;
		int numero_guia =(int)(Math. random()*100+1);;
		
		cedula = JOptionPane.showInputDialog(null, "Ingrese Cédula");
		nombre_cliente = JOptionPane.showInputDialog(null, "Ingrese Nombre Completo");
		contacto= JOptionPane.showInputDialog(null, "Ingrese Contacto");
		email=  JOptionPane.showInputDialog(null, "Ingrese email");
		profesion= JOptionPane.showInputDialog(null, "Ingrese Profesion");
		
		String[] agencia= {"Chiriqui","Bocas del Toro","Veraguas","Herrera","Los Santos","Coclé","Panama Oeste","Colón","Panama","Darién"};
		
		int ag_envia,ag_recibe;
		String nombre_recibe;
		
		
		ag_envia=JOptionPane.showOptionDialog(null,
				"Seleccione la agencia de origen de envio","Registro de Envios y Transferencias",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] {"Chiriquí", "Bocas del Toro", "Veraguas","Herrera","Los Santos","Coclé","Panama Oeste","Colón","Panamá","Darién"}," ");
		do {
			ag_recibe= JOptionPane.showOptionDialog(null,
					"Seleccione la agencia de destino de envio","Registro de Envios y Transferencias",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] {"Chiriquí", "Bocas del Toro", "Veraguas","Herrera","Los Santos","Coclé","Panama Oeste","Colón","Panamá","Darién"}," ");
		}while(ag_envia==ag_recibe);
		
		nombre_recibe= JOptionPane.showInputDialog(null, "Ingrese Nombre del que recibe");
		
		int cant_sobre_bl;
		String sobre_blanco;
		double costo_sobre_bl=2.75,valor_sobre_bl;
				
		cant_sobre_bl= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de sobre blanco: ")) ;
		sobre_blanco = JOptionPane.showInputDialog(null, "Ingrese contenido Sobre Blanco");
		valor_sobre_bl=costo_sobre_bl*cant_sobre_bl;
			
		
		int cant_sobre_am;
		double costo_sobre_am=3.25,valor_sobre_am;
		String sobre_amarillo;
		
		cant_sobre_am= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de sobre amarillo: ")) ;
		sobre_amarillo = JOptionPane.showInputDialog(null, "Ingrese contenido Sobre Amarillo");
		valor_sobre_am=costo_sobre_am*cant_sobre_am;
		
		int cant_cajas_b;
		String cajas_bultos;
		double costo_cajas_b=5.50,valor_cajas_b;

		cant_cajas_b= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de cajas bultos: ")) ;
		cajas_bultos= JOptionPane.showInputDialog(null, "Ingrese contenido cajas bultos");
		valor_cajas_b=costo_cajas_b*cant_cajas_b;
		
		double cant_dinero;  //cant_dinero
		String dinero; 
		
		do {
		cant_dinero= Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese cantidad de dinero a enviar: ")) ;
		}while(cant_dinero<100||cant_dinero>1500.00);
		
		dinero= JOptionPane.showInputDialog(null, "Ingrese descripcion de envio de dinero");
		int dine=(int)cant_dinero/100;
		int aux =((int)cant_dinero-(dine*100));
		if(aux>=75) {dine+=1;}
		
		double costo_dinero=0;  //costo_dinero
		double flete_dinero;
		
		flete_dinero=(dine*12.50);
		
		String[] tipaje= {"Efectivo","Cheque","Tarjeta"};
		int opcionpago= JOptionPane.showOptionDialog(null,
				"Seleccione el metodo de pago","Registro de Envios y Transferencias",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] {"Efectivo","Cheque","Tarjeta"}," ");    
		String tipo_pago=tipaje[opcionpago];
		
		double subtotal=0,porc_descto_pago=0.0325,valor_descto=0,porc_recargo_pago=0.0275;
		double valor_recargo=0,valor_final=0;
		
		subtotal=flete_dinero+cant_dinero+valor_cajas_b+valor_sobre_am+valor_sobre_bl;
		
		//efectivo cheque tarjetas de credito
		if(opcionpago==0) {//efectivo
			valor_recargo=0;
			valor_descto=(subtotal*porc_descto_pago);
			valor_final=subtotal-(valor_descto);
		}
		if(opcionpago==1) {//cheque
			valor_descto=0;
			valor_recargo=0;
			valor_final=subtotal;
		}
		if(opcionpago==2) {//tarjeta
			valor_descto=0;
			valor_recargo=(subtotal*porc_recargo_pago);
			valor_final=subtotal+(valor_recargo);
		}
		//preguntar si/no desea ver el reporte
		
		int opcion = JOptionPane.showConfirmDialog(null, "Desea ver la factura?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
        while (opcion == 0)
		{
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MMMM-yyyy");
		Date date = new Date(System.currentTimeMillis());
		DecimalFormat formatodin = new DecimalFormat("$####.##");
		
		String ax= "\tEnvíos & Transferencias Global Money, INC.\n\tcomprobante de recibo & envio de transferencias";
		ax+="\nFactura No. "+numero_guia+"\t Fecha:"+(formatter.format(date));
		ax+="\nProgramador: J Mastino\t\t\t"+"CÉDULA: x-xxx-xxxx";
		ax+="\nCedula:"+cedula+" Nombre: "+nombre_cliente+" Celular:"+contacto+" Email:"+email;
		ax+="\nAg. Envío:"+agencia[ag_envia]+" Ag. Recibe"+agencia[ag_recibe]+" Nombre que Recibe:"+nombre_recibe;
		ax+="\n\t\tDetalle del Envío:";
		ax+="\nCantidad\tTipo de Envio\tPrecio\tTotal x Linea";
		JTextArea salida = new JTextArea();
		salida.setText(ax);
		salida.append("\n"+cant_sobre_bl+"\tSobres o Cartas"+costo_sobre_bl+"\t"+valor_sobre_bl);
		salida.append("\n"+cant_sobre_am+"\tSobres amarillos"+costo_sobre_am+"\t"+valor_sobre_am);
		salida.append("\n"+cant_cajas_b+"\tcajas o bultos"+costo_cajas_b+"\t"+valor_cajas_b);
		//salida.append("\n0\tOtros\t0.00\t0.00");
		salida.append("\n"+cant_dinero+"\tEnvio de dinero\t"+flete_dinero+"\t"+(flete_dinero+cant_dinero));
		salida.append("\n\t\t\t"+formatodin.format(subtotal));
		salida.append("\nTipo Pago: "+tipo_pago);
		salida.append("\nSubTotal:\t\t\t\t"+formatodin.format(subtotal));
		salida.append("\nDescuento:"+formatodin.format(valor_descto));
		salida.append("\nRecargo:"+formatodin.format(valor_recargo));
		salida.append("\nValor Final a Pagar\t\t\t\t"+formatodin.format(valor_final));
		JOptionPane.showMessageDialog(null, salida,"Envíos & Transferencias Global Money, INC.",JOptionPane.INFORMATION_MESSAGE);
		
		opcion = JOptionPane.showConfirmDialog(null, "¿Desea seguir viendo la factura anterior?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
		}
		
        
		String url = "jdbc:mysql://localhost:3306/bdtransfint";
		String username= "root";
		String password = "";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
        
		Statement insertreg=connection.createStatement();
		
        insertreg.executeUpdate("INSERT INTO tabtransfint(numero_guia, cedula, nombre_cliente, contacto, email,profesion, ag_envia,ag_recibe,nombre_recibe,cant_sobre_bl,sobre_blanco,costo_sobre_bl,valor_sobre_bl,cant_sobre_am,costo_sobre_am,sobre_amarillo,valor_sobre_am,cant_cajas_b,cajas_bultos,costo_cajas_b,valor_cajas_b,cant_dinero,dinero,costo_dinero,flete_dinero,tipo_pago,subtotal,porc_descto_pago,valor_descto,porc_recargo_pago,valor_recargo,valor_final) values ('"+numero_guia + "','"+cedula + "','"+ nombre_cliente +"','"+ contacto+"','"+ email + "','"+ profesion + "','"+ agencia[ag_envia] + "','"+ agencia[ag_recibe] + "','"+ nombre_recibe + "','"+ cant_sobre_bl+ "','" + sobre_blanco+ "','"+ costo_sobre_bl+ "','"+ valor_sobre_bl + "','"+cant_sobre_am+"','"+costo_sobre_am+"','"+sobre_amarillo+"','"+valor_sobre_am+"','"+cant_cajas_b+"','"+cajas_bultos+"','"+costo_cajas_b+"','"+valor_cajas_b+"','"+cant_dinero+"','"+dinero+"','"+costo_dinero+"','"+flete_dinero+"','"+tipo_pago+"','"+subtotal+"','"+porc_descto_pago+"','"+valor_descto+"','"+porc_recargo_pago+"','"+valor_recargo+"','"+ valor_final+"')");
        
        JOptionPane.showMessageDialog(null, "Registro de Cliente\n"+"Registro Exitoso en la Base de Datos");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Registro de Cliente\n"+"Registro No Cargado en la Base de Datos");
			e.printStackTrace();}	
	
		opcionp = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la aplicación de nuevo?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
		}
	}	
}