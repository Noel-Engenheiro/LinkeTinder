import com.example.aczg.Candidato
import com.example.aczg.Empresa

//fazer uma lista de competências
//Dados dos Candidatos
//String competencias

//Strings e inteiros dos candidatos

int opcao = 0;


try (Scanner sc = new Scanner(System.in)) {
    List<Candidato> ListaDeCandidatos = new ArrayList<>();

    while (opcao != -1) {
        System.out.println("Escolha a opção do Menu\n" + "1 Criar Candidato\n" + "2 Listar Todos os candidatos\n" + "3 Listar as competências\n"
                + "4 Criar Empresa\n" + "5 Listar Todos as empresas\n")

        opcao = sc.nextInt();


        opcao = sc.nextInt();

        Candidato candidato = new Candidato()

        candidato.nome = 'ag'
        candidato.email = 'a'
        candidato.cpf = 'b'
        candidato.idade = 'c'
        candidato.estado = 'd'
        candidato.cep = 'e'
        candidato.descricaopessoal = 'f'
        candidato.python = 'python'

        candidato.ToString()
        candidato.Competenciapython()


        Candidato candidato2 = new Candidato()
        candidato2.nome = 'af'
        candidato2.email = 'a'
        candidato2.cpf = 'b'
        candidato2.idade = 'c'
        candidato2.estado = 'd'
        candidato2.cep = 'e'
        candidato2.descricaopessoal = 'f'
        candidato2.java = 'Java'

        candidato2.ToString()
        candidato2.Competenciajava()

        Candidato candidato3 = new Candidato()

        candidato3.nome = 'anv'
        candidato3.email = 'a'
        candidato3.cpf = 'b'
        candidato3.idade = 'c'
        candidato3.estado = 'd'
        candidato3.cep = 'e'
        candidato3.descricaopessoal = 'f'
        candidato3.angular = 'angular'

        candidato3.ToString()
        candidato3.Competenciaangular()


        Candidato candidato4 = new Candidato()

        candidato4.nome = 'bab'
        candidato4.email = 'a'
        candidato4.cpf = 'b'
        candidato4.idade = 'c'
        candidato4.estado = 'd'
        candidato4.cep = 'e'
        candidato4.descricaopessoal = 'f'
        candidato4.springFramework = 'springFramework'

        candidato4.ToString()
        candidato4.CompetenciaspringFramework()


        Candidato candidato5 = new Candidato()

        candidato5.nome = 'ac'
        candidato5.email = 'a'
        candidato5.cpf = 'b'
        candidato5.idade = 'c'
        candidato5.estado = 'd'
        candidato5.cep = 'e'
        candidato5.descricaopessoal = 'f'
        candidato5.javascript = 'javascript'


        candidato5.ToString()
        candidato5.Competenciajavascript()


        List<Candidato> candidatos = new ArrayList<>()

        candidatos.add(candidato)
        candidatos.add(candidato2)
        candidatos.add(candidato3)
        candidatos.add(candidato4)
        candidatos.add(candidato5)

        candidatos.each { x ->
            {
                x.ToString()
            }
        }


        Empresa empresa = new Empresa()

        empresa.nomedaempresa = 'f'
        empresa.emailcorporativo = 'a'
        empresa.cnpj = 'b'
        empresa.pais = 'c'
        empresa.estadoempresa = 'd'
        empresa.cepempresa = 'e'
        empresa.descricaodaempresa = 'f'

        empresa.toStrings()
        empresa.assiduidade()

        Empresa empresa2 = new Empresa()

        empresa2.nomedaempresa = 'f'
        empresa2.emailcorporativo = 'a'
        empresa2.cnpj = 'b'
        empresa2.pais = 'c'
        empresa2.estadoempresa = 'd'
        empresa2.cepempresa = 'e'
        empresa2.descricaodaempresa = 'f'

        empresa2.toStrings()
        empresa2.capadidadedeiniciativa()

        Empresa empresa3 = new Empresa()

        empresa3.nomedaempresa = 'f'
        empresa3.emailcorporativo = 'a'
        empresa3.cnpj = 'b'
        empresa3.pais = 'c'
        empresa3.estadoempresa = 'd'
        empresa3.cepempresa = 'e'
        empresa3.descricaodaempresa = 'f'

        empresa3.toStrings()
        empresa3.responsabilidade()

        Empresa empresa4 = new Empresa()

        empresa4.nomedaempresa = 'f'
        empresa4.emailcorporativo = 'a'
        empresa4.cnpj = 'b'
        empresa4.pais = 'c'
        empresa4.estadoempresa = 'd'
        empresa4.cepempresa = 'e'
        empresa4.descricaodaempresa = 'f'

        empresa4.toStrings()
        empresa4.disponibilidade()

        Empresa empresa5 = new Empresa()

        empresa5.nomedaempresa = 'f'
        empresa5.emailcorporativo = 'a'
        empresa5.cnpj = 'b'
        empresa5.pais = 'c'
        empresa5.estadoempresa = 'd'
        empresa5.cepempresa = 'e'
        empresa5.descricaodaempresa = 'f'

        empresa5.toStrings()
        empresa5.respeito()

        List<Candidato> empresas = new ArrayList<>()

        empresas.add(empresa)
        empresas.add(empresa2)
        empresas.add(empresa3)
        empresas.add(empresa4)
        empresas.add(empresa5)

    }
}