package net.ciprianlungu.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBBDD {
    public Connection conexion;
    private String usr;
    private String pwd;
    private String ip;
    private String bbddName;
    private int puerto;

    public GestorBBDD(String usr, String pwd, String ip, String bbddName, int puerto) {
        this.usr = usr;
        this.pwd = pwd;
        this.ip = ip;
        this.bbddName = bbddName;
        this.puerto = puerto;
    }
    public GestorBBDD(String usr, String pwd, String ip, String bbddName) {
        this.usr = usr;
        this.pwd = pwd;
        this.ip = ip;
        this.bbddName = bbddName;
        this.puerto = 3306;
    }
    //INDICAR EL DRIVER JDBC.
    public void establecerConexion() throws ClassNotFoundException, SQLException{
        String driver = "com.mysql.jdbc.Driver";

		Class.forName(driver);

        String servidor = "jdbc:mysql://"+ip+"/"+bbddName;
        String user = usr;
        String pass = pwd;
        
        //INTENTO DE CONEXION A LA BBDD
			conexion = DriverManager.getConnection(servidor, user, pass);

    }
    public void cerrarConexion() throws SQLException{
  
			conexion.close();

    }
}