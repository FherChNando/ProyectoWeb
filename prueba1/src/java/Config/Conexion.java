
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas_bj","root","");
        }catch(Exception e){
            System.err.println("Error"+e);
            System.out.println("Conexión exitosa");
        }
        return con;
    }     
}
