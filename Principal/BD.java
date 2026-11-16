package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class BD {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
    private static final String USUARIO = "CRUD_BASICAO";
    private static final String SENHA = "Teste@123";
    
    public Connection get_connection(){
        try{
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
        return null;
    }
    
    
}
