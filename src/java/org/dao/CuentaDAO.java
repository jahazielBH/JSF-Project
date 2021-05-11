
package org.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.util.ConexionDB;


/**
 *
 * @author GabrielHS
 */
public class CuentaDAO {
    
    private PreparedStatement ps;
    private ResultSet rs;
    Cuenta cuenta =  new Cuenta();
    
    
    
    public boolean ingresar(Cuenta pojo) {
        String insert = "INSERT INTO cuentas (nombre,password) VALUES (?,?)";
        try {
            ps=ConexionDB.getInstance().getConnection().prepareStatement(insert);
            ps.setString(1, pojo.getNombre());
            ps.setString(2, pojo.getPassword());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public Cuenta mostrarById(String nombre, String password) {
        String insert = "SELECT * FROM cuentas WHERE nombre =? and password=?";
        try {
            ps=ConexionDB.getInstance().getConnection().prepareStatement(insert);
            ps.setString(1, nombre);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Cuenta c = new Cuenta();
                c.setNombre(rs.getString(1));
                c.setPassword(rs.getString(2));
                cuenta = c;
            } else {

                cuenta = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuenta;
    }
}
