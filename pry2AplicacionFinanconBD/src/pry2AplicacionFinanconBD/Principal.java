package pry2AplicacionFinanconBD;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		Principal here = new Principal();
		
        String nombre,cedula;
        int plazo=0;
        double val_pres=0;
        double total_interes=0;
        double comi_cierre=0;
        double gastos_leg=0;
        double seg_vida=0;	
        double pago_men=0;
        double total_pago=0;
        int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
        while (opcion == 0)
		{
            nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre Completo");
            cedula = JOptionPane.showInputDialog(null, "Ingrese Cédula");
            val_pres = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el Valor del Prestamo"));
            plazo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el plazo (meses) de pago"));
            total_interes = (val_pres*0.0225);
            gastos_leg = (val_pres*0.0375);
            comi_cierre =(val_pres*0.0975);
            seg_vida = (val_pres*0.0425);
            total_pago = (val_pres + total_interes + comi_cierre + gastos_leg + seg_vida);
            pago_men= (total_pago / plazo);
        
		String url = "jdbc:mysql://localhost:3306/bdmultiserfin";
		String username= "root";
		String password = "";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
        
		Statement insertreg=connection.createStatement();
		
        insertreg.executeUpdate("INSERT INTO prestafacil(Cedula_cliente, Nombre_cliente, Valor_prestamo, Plazo_pago, Total_intereses, Comision_cierre, Gastos_legales, Seguro_vida, Total_a_pagar,"
                + " Pago_mensual) values ('"+cedula + "','"+ nombre +"','"+ val_pres +"','"+ plazo + "','"+ total_interes + "','"+ comi_cierre+ "','" + gastos_leg + "','"+ seg_vida + "','"+total_pago+"','"+ pago_men +"')");
        
        JOptionPane.showMessageDialog(null, "Registro de Cliente\n"+"Registro Exitoso en la Base de Datos");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Registro de Cliente\n"+"Registro No Cargado en la Base de Datos");
			e.printStackTrace();}
		
		int opcionreporte = JOptionPane.showConfirmDialog(null, "¿Desea Reporte de Todos los Prestamos?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);	
	
		while (opcionreporte == 0)
		{
			try{
				Connection connection = DriverManager.getConnection(url, username, password);
				here.viewTable(connection);
			} catch(SQLException e){e.printStackTrace();}
			opcionreporte = JOptionPane.showConfirmDialog(null, "¿Desea Reporte de Todos los Prestamos?",
					"Seleccione una Opción", JOptionPane.YES_NO_OPTION); 
		}
		
			opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
					"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
		}
        	
	}	
	
		 public void viewTable(Connection connection) throws SQLException {
			    String query = "select Cedula_cliente, Nombre_cliente, Valor_Prestamo, Plazo_pago, Total_intereses,Comision_cierre,Gastos_legales,Seguro_vida,Total_a_pagar,Pago_mensual from prestafacil";
			    DecimalFormat df = new DecimalFormat("##.##");
			    try (Statement stmt = connection.createStatement()) {
			      ResultSet rs = stmt.executeQuery(query);
			      System.out.println("Cedula\t   Nombre\t       Valor prestamo\tPlazo pago\tTotalintereses\tComision Cierre\tGastoslegales\tSeguro vida\tTotal a pagar\tPago Mensual");
			      while (rs.next()) {
			        String cedula = rs.getString("Cedula_cliente");
			        String nombre = rs.getString("Nombre_cliente");
			        double valorprestamo = rs.getDouble("Valor_prestamo");
			        int plazop = rs.getInt("Plazo_pago");
			        double totalint = rs.getDouble("Total_intereses");
			        double com_cierre = rs.getDouble("Comision_cierre");
			        double gastos_leg = rs.getDouble("Gastos_legales");
			        double segvida= rs.getDouble("Seguro_vida");
			        double totalapagar= rs.getDouble("Total_a_pagar");
			        double pagomensual= rs.getDouble("Pago_mensual");
			        System.out.println(cedula+", "+nombre+", "+df.format(valorprestamo)+", \t\t"+df.format(plazop)+", \t"+df.format(totalint)+", \t"+df.format(com_cierre)+", \t"+df.format(gastos_leg)+", \t"+df.format(segvida)+", \t"+df.format(totalapagar)+", \t"+df.format(pagomensual));
			      }
			    } catch (SQLException e) {
			    	e.printStackTrace();
			    }
			  }
}