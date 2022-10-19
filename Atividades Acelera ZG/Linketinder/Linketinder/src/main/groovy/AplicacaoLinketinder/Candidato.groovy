package AplicacaoLinketinder

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Candidato {


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

    static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void listar_Candidato() {
        String listar_Candidato = "SELECT * FROM candidatos";
        try {
            Connection conn = conectar();
            PreparedStatement candidato = conn.prepareStatement(
                    listar_Candidato,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resposta = candidato.executeQuery();
            resposta.last();
            int quantidade = resposta.getRow();
            resposta.beforeFirst();
            if (quantidade > 0) {
                println("Listando Candidatos ");
                while (resposta.next()) {
                    println("Código do candidato : " + resposta.getString(1))
                    println("Nome do candidato : " + resposta.getString(2))
                    println("Sobrenome do candidato : " + resposta.getString(3))
                    println("Data de nascimento do candidato : " + resposta.getString(4))
                    println("E-mail do candidato : " + resposta.getString(5))
                    println("CPF do candidato : " + resposta.getString(6))
                    println("País do candidato : " + resposta.getString(7))
                    println("CEP do candidato : " + resposta.getString(8))
                    println("Descrição pessoal do candidato : " + resposta.getString(9))
                    println("Senha do candidato : " + resposta.getString(10))
                    println("------------------------")
                }
            } else {
                println("Não existem usuários cadastrados.")
                println("------------------------")
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao buscar candidatos.");
            System.exit(-42);
        }
    }
    public static void inserir_Candidato (){
        println("Informe o código do Candidato : ");
        String cod_candidato = teclado.nextLine();
        println("Informe o nome do Candidato : ");
        String nome = teclado.nextLine();
        println("Informe sobrenome do Candidato : ");
        String sobrenome = teclado.nextLine();
        println("Informe a data de nascimento do Candidato : ");
        String data_de_nascimento = teclado.nextLine();
        println("Informe o e-mail do Candidato : ");
        String e_mail = teclado.nextLine();
        println("Informe o CPF do Candidato : ");
        String cpf = teclado.nextLine();
        println("Informe o país do Candidato : ");
        String pais = teclado.nextLine();
        println("Informe o CEP do Candidato : ");
        String cep = teclado.nextLine();
        println("Informe a descrição pessoal do Candidato : ");
        String descricao_pessoal = teclado.nextLine();
        println("Informe a senha do Candidato  : ");
        String senha = teclado.nextLine();


        String INSERIR = "INSERT INTO candidatos (cod_candidato, nome, sobrenome, data_de_nascimento, e_mail, cpf, pais, cep, descricao_pessoal, senha) VALUE (?, ?, ?,?,?,?,?,?,?,?)";
        try{
            Connection conn = conectar();
            PreparedStatement salvar = conn.prepareStatement(INSERIR);

            salvar.setString(1, cod_candidato);
            salvar.setString(2, nome);
            salvar.setString(3, sobrenome);
            salvar.setString(4, data_de_nascimento);
            salvar.setString(5, e_mail);
            salvar.setString(6, cpf);
            salvar.setString(7, pais);
            salvar.setString(8, cep);
            salvar.setString(9, descricao_pessoal);
            salvar.setString(10, senha);

            salvar.executeUpdate();
            salvar.close();
            desconectar(conn);
            println("O candidato " + nome sobrenome + "foi inserido com sucesso.");
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao inserir a candidato.");
            System.exit(-42);
        }
    }
    public static void deletar(){
        String DELETAR = "DELETE FROM candidatos cod_candidato= ?";

        println("Nome do candidato : ");
        int cod_candidato = int.parseInt(teclado.nextLine());

        try {
            Connection conn = conectar();
            PreparedStatement candidato = conn.prepareStatement(
                    cod_candidato,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            candidato.setInt(1,cod_candidato);
            ResultSet resultado = candidato.executeQuery();

            resultado.last();
            int quantidade = resultado.getRow();
            resultado.beforeFirst();

            if (quantidade > 0){
                PreparedStatement deletar = conn.prepareStatement(DELETAR);
                deletar.setInt(1, cod_candidato);
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