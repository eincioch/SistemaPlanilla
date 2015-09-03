
package c4_persistencia.daoPostgreSQL;

import c4_persistencia.GestorJDBC;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Enrique Incio
 * @version 1.0
 * @created 25-ago-2015 12:50:18 p.m.
 */
public class GestorJDBCPostgre extends GestorJDBC {    

    @Override
    public void abrirConexion() throws Exception{        
        Class.forName("org.postgresql.Driver");
        //String url = "jdbc:postgresql:jdbc:postgresql://ec2-107-20-220-251.compute-1.amazonaws.com:5432/dccemkb85e3tul?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        String url = "jdbc:postgresql://ec2-107-20-220-251.compute-1.amazonaws.com:5432/dccemkb85e3tul";
        //conexion = DriverManager.getConnection(url, "postgres", "sadmin");   
        Properties props = new Properties();
        props.setProperty("user", "powykhqnctqgns");
        props.setProperty("password", "YZpoR5pCkb3aOoE3ueP_Phr7yp");
        props.setProperty("ssl", "true");
        //Configuración de la conexión URL parámetro SSLfactory = org.postgresql.ssl.NonValidatingFactory se apagará toda SSL de validación.
        props.setProperty("sslfactory","org.postgresql.ssl.NonValidatingFactory");
        conexion = DriverManager.getConnection(url, props);
        
//        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/planilla2";
//        conexion = DriverManager.getConnection(url, "postgres", "sadmin");   
 
    }
    
}
