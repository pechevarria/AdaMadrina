package utp.edu.pe.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import utp.edu.pe.clases.Usuario;
import utp.edu.pe.conexiones.Conexion;

public class UsuarioDB {
    
private static Connection miconexion= new Conexion().getConnection();
Usuario u=new Usuario();

 public void registrarUsuario(Usuario u) throws SQLException
 {
     String usuarioP, clavep;
     int estadop;
     String resultado;
     
     usuarioP=u.getUsuario();
     clavep=u.getClave();
     estadop=u.getEstado();
  try
  {
           CallableStatement proc = miconexion.prepareCall("{CALL [sp_iUsuario](?,?,?,?)}");
           proc.setString(1, usuarioP);
           proc.setString(2, clavep);
           proc.setInt(3, estadop);
           proc.registerOutParameter(4, Types.VARCHAR);
           proc.executeUpdate();
           resultado = proc.getString("msg");
           miconexion.commit();
           proc.close();       
  
  }  
  catch(Exception ex)
  {   
   ex.printStackTrace();
  }
  finally
  {
   miconexion.close();
  }
     
 
 }   
 
 public String registrarUsuario2(Usuario u) throws SQLException
 {
     String usuarioP, clavep;
     int estadop;
     String resultado="";
     
     usuarioP=u.getUsuario();
     clavep=u.getClave();
     estadop=u.getEstado();
  try
  {
           CallableStatement proc = miconexion.prepareCall("{CALL [sp_iUsuario](?,?,?,?)}");
           proc.setString(1, usuarioP);
           proc.setString(2, clavep);
           proc.setInt(3, estadop);
           proc.registerOutParameter(4, Types.VARCHAR);
           proc.executeUpdate();
           resultado = proc.getString("msg");
           miconexion.commit();
           proc.close(); 
  }  
  catch(Exception ex)
  {   
       resultado=" "+ex.getMessage();
  }
  finally
  {
   miconexion.close();
   
   return resultado;
   
  }
     
 
 }   
 
 
 
 public void actualizarUsuario(Usuario u)
 {
     
 }
 
 
    
    
    
    
    
    
}
