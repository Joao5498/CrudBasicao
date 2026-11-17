package Principal;
import java.sql.*;
import javax.swing.JOptionPane;

public class GeraDB {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/FREE";
    private static final String USUARIO = "SYS as SYSDBA";
    private static final String SENHA = "Teste@123";
    
    public static boolean criaUsuario(){
        Connection conexao = conectar();
        try{
            String v_exist_u = "SELECT COUNT(*) FROM CDB_USERS WHERE USERNAME = 'CRUD_BASICAO'";
            PreparedStatement ps = conexao.prepareStatement(v_exist_u);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            int quantidade = rs.getInt(1);
            
            if(quantidade > 0){
                JOptionPane.showMessageDialog(null, "Usuário já existe");
            }else{
                String cria_usuario = "CREATE USER CRUD_BASICAO IDENTIFIED BY \"Teste@123\"";
                PreparedStatement ps1 = conexao.prepareStatement(cria_usuario);
                ps1.execute();
                System.out.println("Usuario criado com sucesso!");
                
                String priv = "GRANT CREATE TABLE TO CRUD_BASICAO";
                PreparedStatement ps2 = conexao.prepareStatement(priv);
                System.out.println("Privilegios concedidos ao novo usuário!");
                ps2.execute();
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }finally{
            desconectar(conexao);
        }
        return false;
    }

    public static boolean criaBanco() {
        Connection conexao = conectar();
        try {
            String v_exist_b = "SELECT COUNT(*) FROM V$PDBS WHERE NAME = ?";
            PreparedStatement ps = conexao.prepareStatement(v_exist_b);
            ps.setString(1, "CRUDPDB");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int quantidade = rs.getInt(1);

            if (quantidade > 0) {
                JOptionPane.showMessageDialog(null, "Banco de dados já existe");
            } else {
                String cria_db = "CREATE PLUGGABLE DATABASE CRUDPDB ADMIN USER CRUD_ADMIN IDENTIFIED BY \"Teste@123\" CREATE_FILE_DEST = '/opt/oracle/oradata/'";
                ps = conexao.prepareStatement(cria_db);
                ps.execute();

                System.out.println("Banco de dados criado com sucesso!");
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ERRO\n" + e.getErrorCode() + e.getMessage());
        } finally {
            desconectar(conexao);
        }
        return false;
    }

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectou");
            return conexao;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public static void desconectar(Connection conexao) {
        try {
            if (!conexao.isClosed() && conexao != null) {
                conexao.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
