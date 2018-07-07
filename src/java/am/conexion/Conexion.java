
package utp.edu.pe.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
public static Connection conexion=null;
    
public static Connection getConnection()
{
 if(conexion==null)
 {  
 try
 {   
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  String url = "jdbc:sqlserver://localhost;databaseName=semana04db;user=sa;password=alumno;";
  conexion=DriverManager.getConnection(url);
 }catch(Exception ex){
    conexion=null;
 }
 finally
  {
    return conexion; 
  }
 }
  return conexion;
}



    
    
}
