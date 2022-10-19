import java.sql.*;
import java.util.*;

class BancoDeDados {
    static Scanner teclado = new Scanner(System.in);
    public static Connection conectar(){
        Properties props = new Properties();
        props.setProperty("user", "Servers");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/LinkeTinder";

        try{
            return  DriverManager.getConnection(URL_SERVIDOR, props);
        } catch(Exception e) {
            e.printStackTrace();
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão.");
            } else {
                System.err.println("Verifique se o servidor está ativo.");
            }
            System.exit(-42);
            return null;
        }
    }
    public static void desconectar (Connection conn) {
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void listar(){
        String listar_Candidatos = "SELECT * FROM candidatos";
        try{
            Connection conn = conectar();
            PreparedStatement candidatos = conn.prepareStatement(
                    listar_Candidatos,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resposta = candidatos.executeQuery();
            resposta.last();
            int quantidade = resposta.getRow();
            resposta.beforeFirst();
            if(quantidade > 0){
                println("Listando Candidatos ");
                while(resposta.next()) {
                    println("Nome : " + resposta.getString(2))
                    println("Sobrenome : " + resposta.getString(3))
                    println("Descrição Pessoal : " + resposta.getString(9))
                    println("------------------------")
                }
            } else {
                println("Não existem usuários cadastrados.")
                println("------------------------")
            }
        }catch(Exception e ) {
            e.printStackTrace();
            System.err.println("Erro ao buscar candidatos.");
            System.exit(-42);
            }
    }
}
