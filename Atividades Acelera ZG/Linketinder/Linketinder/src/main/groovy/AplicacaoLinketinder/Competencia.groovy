package AplicacaoLinketinder

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Competencia {
    static Scanner teclado = new Scanner(System.in);

    public static Connection conectar() {
        Properties props = new Properties();
        props.setProperty("user", "Servers");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/LinkeTinder";

        try {
            return DriverManager.getConnection(URL_SERVIDOR, props);
        } catch (Exception e) {
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

    public static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void competencia_Candidatos() {
        String listar_Competencia = "SELECT * FROM  competencia";
        try {
            Connection conn = conectar();
            PreparedStatement competencia = conn.prepareStatement(
                    listar_Competencia,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resposta = competencia.executeQuery();
            resposta.last();
            int quantidade = resposta.getRow();
            resposta.beforeFirst();
            if (quantidade > 0) {
                println("Listando Competência ");
                while (resposta.next()) {
                    println(" Competência do candidato : " + resposta.getString(1))
                    println("Descrição : " + resposta.getString(2))
                    println("------------------------")
                }
            } else {
                println("Não existem competências cadastradas.")
                println("------------------------")
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao buscar competências.");
            System.exit(-42);
        }
    }
    public static void competencia_Candidato (){
        println("Informe a competência do Candidato : ");
        String cod_competencia_candidato = teclado.nextLine();
        println("Informe a descrição do Candidato  : ");
        String descricao = teclado.nextLine();



        String INSERIR = "INSERT INTO competencia (cod_competencia_candidato, descricao) VALUE (?, ?)";
        try{
            Connection conn = conectar();
            PreparedStatement salvar = conn.prepareStatement(INSERIR);

            salvar.setString(1, cod_competencia_candidato);
            salvar.setString(2, descricao);

            salvar.executeUpdate();
            salvar.close();
            desconectar(conn);
            println("A competência " + descricao + "foi inserida com sucesso.");
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao inserir a competência.");
            System.exit(-42);
        }
    }
    public static void deletar(){
        String DELETAR = "DELETE FROM competencia cod_competencia_candidato= ?";

        println("Nome da competência : ");
        int cod_competencia_candidato = int.parseInt(teclado.nextLine());

        try {
            Connection conn = conectar();
            PreparedStatement competencia = conn.prepareStatement(
                    cod_competencia_candidato,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            competencia.setInt(1,cod_competencia_candidato);
            ResultSet resultado = competencia.executeQuery();

            resultado.last();
            int quantidade = resultado.getRow();
            resultado.beforeFirst();

            if (quantidade > 0){
                PreparedStatement deletar = conn.prepareStatement(DELETAR);
                deletar.setInt(1, cod_competencia_candidato);
                deletar.executeUpdate();
                deletar.close();
                desconectar(conn);
                print("Competência deletada com sucesso");

            }else{
                println("Não existe a competência informada");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao deletar competência");
        }
    }
}
