package BackEnd

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Empresa { static Scanner teclado = new Scanner(System.in);

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

    public static void listar_Empresa() {
        String listar_Empresa = "SELECT * FROM empresas";
        try {
            Connection conn = conectar();
            PreparedStatement empresa = conn.prepareStatement(
                    listar_Empresa,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resposta = empresa.executeQuery();
            resposta.last();
            int quantidade = resposta.getRow();
            resposta.beforeFirst();
            if (quantidade > 0) {
                println("Listando Empresas ");
                while (resposta.next()) {
                    println(" Código da empresa : " + resposta.getString(1))
                    println("Nome da empresa : " + resposta.getString(2))
                    println(" E-mail da empresa : " + resposta.getString(3))
                    println(" Descrição da empresa : " + resposta.getString(4))
                    println(" País da empresa : " + resposta.getString(5))
                    println(" CEP da empresa : " + resposta.getString(6))
                    println(" Senha da empresa : " + resposta.getString(7))
                    println("CNPJ da empresa : " + resposta.getString(8))
                    println("------------------------")
                }
            } else {
                println("Não existem empresas cadastradas.")
                println("------------------------")
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao buscar empresas.");
            System.exit(-42);
        }
    }
    public static void inserir_Empresa (){
        println("Informe o código da empresa : ");
        String cod_empresa = teclado.nextLine();
        println("Informe o nome da empresa : ");
        String nome = teclado.nextLine();
        println("Informe o e-mail da empresa : ");
        String e_mail = teclado.nextLine();
        println("Informe a descrição pessoal : ");
        String descricao_pessoal = teclado.nextLine();
        println("Informe o país da empresa : ");
        String pais_empresa = teclado.nextLine();
        println("Informe o cep da empresa : ");
        String cep = teclado.nextLine();
        println("Informe a senha : ");
        String senha = teclado.nextLine();
        println("Informe o cnpj da empresa : ");
        String cnpj = teclado.nextLine();



        String INSERIR = "INSERT INTO candidatos (cod_empresa, nome, e_mail, descricao_pessoal, pais_empresa, cep, senha, cnpj) VALUE (?, ?, ?, ?,?,?,?,?)";
        try{
            Connection conn = conectar();
            PreparedStatement salvar = conn.prepareStatement(INSERIR);

            salvar.setString(1, cod_empresa);
            salvar.setString(2, nome);
            salvar.setString(3, e_mail);
            salvar.setString(4, descricao_pessoal);
            salvar.setString(5, pais_empresa);
            salvar.setString(6,cep);
            salvar.setString(7, senha);
            salvar.setString(8, cnpj);

            salvar.executeUpdate();
            salvar.close();
            desconectar(conn);
            println("A empresa " + nome  + "foi inserida com sucesso.");
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao inserir a empresa.");
            System.exit(-42);
        }
    }
    public static void deletar(){
        String DELETAR = "DELETE FROM cadastro_empresa cod_empresa= ?";

        println("Nome da empresa : ");
        int cod_empresa = int.parseInt(teclado.nextLine());

        try {
            Connection conn = conectar();
            PreparedStatement empresa = conn.prepareStatement(
                    cod_empresa,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            empresa.setInt(1,cod_empresa);
            ResultSet resultado = empresa.executeQuery();

            resultado.last();
            int quantidade = resultado.getRow();
            resultado.beforeFirst();

            if (quantidade > 0){
                PreparedStatement deletar = conn.prepareStatement(DELETAR);
                deletar.setInt(1, cod_empresa);
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

