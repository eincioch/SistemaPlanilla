

package c4_persistencia.daoPostgreSQL;

import c3_dominio.entidades.Empleado;
import c4_persistencia.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author EnriqueDavidJose
 * @version 1.0
 * @created 26-ago-2015 02:20:29 a.m.
 */

public class EmpleadoDAOPostgre {
    //GestorJDBC: c4_persistencia
    GestorJDBC gestorJDBC;
    
    public EmpleadoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public Empleado buscar(int tipodocumentoid,String numerodocumento) throws SQLException {
        Empleado empleado = null;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT apellidopaterno, apellidomaterno, nombre, empleadoid, tipodocumentoid, " +
                            "       numerodocumento, ubigeoid, direccion, estadocivilid, telefono, " +
                            "       celular, email, asignacionfamiliar, essalud, estado, tipoempleadoid, " +
                            "       departamentoid, cargoid, centrocostoid, niveleducacionid, periodicidadid, " +
                            "       nacionalidadid, generoid, fechanacimiento, fecharegistro" +
                            "  FROM empleado "
                + " Where tipodocumentoid = " + tipodocumentoid + " and numerodocumento = '" + numerodocumento + "';";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultado.next()){            
            empleado = new Empleado();
            empleado.setApellidopaterno(resultado.getString("apellidopaterno"));
            empleado.setApellidomaterno(resultado.getString("apellidomaterno"));
            empleado.setNombre(resultado.getString("nombre"));
            //empleado.setTipodocumento((TipoDocumento) resultado.getInt("tipodocumentoid"));
            empleado.setNumerodocumento(resultado.getString("numerodocumento"));
            empleado.setEmpleadoid(resultado.getInt("empleadoid"));
        }
        resultado.close();
        return empleado;  
    }
    
    public int ingresar(Empleado empleado) throws SQLException {
        String sentenciaSQL = "insert into empleado(fecharegistro,apellidopaterno,apellidomaterno,nombre,"
                + " fechanacimiento,generoid,tipodocumentoid,numerodocumento,ubigeoid,direccion,estadocivilid,telefono,celular,email,"
                + " asignacionfamiliar,essalud,estado,tipoempleadoid,departamentoid,cargoid,centrocostoid,niveleducacionid,periodicidadid,nacionalidadid) "
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        //PreparedStatement: Un objeto que representa una sentencia SQL precompilado.
        //      Una sentencia SQL se precompila y se almacena en un PreparedStatement objeto. 
        //      Este objeto se puede usar entonces para ejecutar eficientemente esta declaración varias veces.
        //mas info: http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        
        //problmes con tipo de dato fecha hay que convertir (Date)
        //new Date(peli.getFecha().getTime())
        sentencia.setString(1, empleado.getFecharegistro());
        sentencia.setString(2, empleado.getApellidopaterno());
        sentencia.setString(3, empleado.getApellidomaterno());
        sentencia.setString(4, empleado.getNombre());
        sentencia.setString(5, empleado.getFechanacimiento());
        sentencia.setInt(6,empleado.getGenero().getGeneroid());
        //para que aparesca "getTipodocumentoid()" hay que crear los metodos Get en la Clase "TipoDocumento"
        sentencia.setInt(7, empleado.getTipodocumento().getTipodocumentoid());
        sentencia.setString(8, empleado.getNumerodocumento());
        sentencia.setInt(9, empleado.getUbigeo().getUbigeoid());
        sentencia.setString(10, empleado.getDireccion());
        sentencia.setInt(11, empleado.getEstadocivil().getEstadocivilid());
        sentencia.setString(12, empleado.getTelefono());
        sentencia.setString(13, empleado.getCelular());
        sentencia.setString(14, empleado.getEmail());
        sentencia.setString(15, empleado.getAsignacionfamiliar());
        sentencia.setString(16, empleado.getEssalud());
        sentencia.setInt(17, empleado.getEstado()); //1-activo; 0-no activo
        sentencia.setInt(18, empleado.getTipoempleado().getTipoempleadoid());
        sentencia.setInt(19, empleado.getDepartamento().getDepartamentoid());
        sentencia.setInt(20, empleado.getCargo().getCargoid());
        sentencia.setInt(21, empleado.getCentrocosto().getCentrocostoid());
        sentencia.setInt(22, empleado.getNiveleducativo().getNiveleducacionid());
        sentencia.setInt(23, empleado.getPeriodicidadpago().getPeriodicidadid());
        sentencia.setInt(24, empleado.getNacionalidad().getNacionalidadid());
        
        return sentencia.executeUpdate();
    }
}
