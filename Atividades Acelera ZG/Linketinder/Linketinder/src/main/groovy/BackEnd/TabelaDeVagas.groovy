package BackEnd

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class TabelaDeVagas {
    static Scanner teclado = new Scanner(System.in)

    static Connection conectar() {
        Properties props = new Properties()
        props.setProperty("user", "Servers")
        props.setProperty("password", "123")
        props.setProperty("ssl", "false")
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/LinkeTinder"

        try {
            return DriverManager.getConnection(URL_SERVIDOR, props)
        } catch (Exception e) {
            e.printStackTrace()
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão.")
            } else {
                System.err.println("Verifique se o servidor está ativo.")
            }
            System.exit(-42)
            return null
        }
    }

     static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close()
            } catch (SQLException e) {
                e.printStackTrace()
            }
        }
    }

     static void tabela_De_Vagas() {
        String listar_tabela_De_Vaga = "SELECT * FROM tabela_vagas"
        try {
            Connection conn = conectar()
            PreparedStatement vaga = conn.prepareStatement(
                    listar_tabela_De_Vaga,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resposta = vaga.executeQuery()
            resposta.last()
            int quantidade = resposta.getRow()
            resposta.beforeFirst()
            if (quantidade > 0) {
                println("Listando vagas ")
                while (resposta.next()) {
                    println(" Código das vagas : " + resposta.getString(1))
                    println(" Nome das vagas : " + resposta.getString(2))
                    println(" Descrição das vagas : " + resposta.getString(3))
                    println(" Competências das vagas : " + resposta.getString(4))
                    println(" Local das vagas : " + resposta.getString(5))
                    println("------------------------")
                }
            } else {
                println("Não existem vagas cadastradas.")
                println("------------------------")
            }
        } catch (Exception e) {
            e.printStackTrace()
            System.err.println("Erro ao buscar vagas.")
            System.exit(-42)
        }
    }
     static void inserir (){
        println("Informe o código da vaga : ");
        String codigo = teclado.nextLine();
        println("Informe o nome da vaga  : ");
        String nome = teclado.nextLine();
        println("Informe a descrição pessoal : ");
        String descricao = teclado.nextLine();
        println("Informe as competências exigidas : ");
        String competencia = teclado.nextLine();
        println("Informe o local da vaga : ");
        String local = teclado.nextLine();



        String INSERIR = "INSERT INTO quantidade_Vagas (código, nome, descrição, competências, local) VALUE (?, ?, ?, ?, ?)";
        try{
            Connection conn = conectar();
            PreparedStatement salvar = conn.prepareStatement(INSERIR);

            salvar.setString(1, codigo);
            salvar.setString(2, nome);
            salvar.setString(3, descricao);
            salvar.setString(4, competencia);
            salvar.setString(5, local);

            salvar.executeUpdate();
            salvar.close();
            desconectar(conn);
            println("A vaga " + nome + "foi inserida com sucesso.");
            } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao inserir o nome.");
            System.exit(-42);
        }
    }
    public static void deletar(){
        String DELETAR = "DELETE FROM tabela_vagas cod_vagas= ?";

        println("Nome da vaga : ");
        int cod_vaga = int.parseInt(teclado.nextLine());

        try {
            Connection conn = conectar();
            PreparedStatement vaga = conn.prepareStatement(
                    cod_vaga,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            vaga.setInt(1,cod_vaga);
            ResultSet resultado = vaga.executeQuery();

            resultado.last();
            int quantidade = resultado.getRow();
            resultado.beforeFirst();

            if (quantidade > 0){
                PreparedStatement deletar = conn.prepareStatement(DELETAR);
                deletar.setInt(1, cod_vaga);
                deletar.executeUpdate();
                deletar.close();
                desconectar(conn);
                print("Vaga deletada com sucesso");

            }else{
                println("Não existe a vaga informada");
            }
        }
        catch(Exception e) {
                e.printStackTrace();
                System.err.println("Erro ao deletar vaga");
            }
        }
    }


