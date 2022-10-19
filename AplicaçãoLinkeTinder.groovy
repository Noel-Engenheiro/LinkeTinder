import com.example.aczg.Candidato
import com.example.aczg.Empresa
import com.example.aczg.BancoDeDados


class AplicacaoLinkeTinder {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in)
        boolean exit = false;
        while(!exit){
            print("Escolha uma opção : " +
                    "\n 1 Listar Empresas "
            )
            int opcao = input.nextInt();
            switch (opcao){
                case 1 :
                    BancoDeDados.listar()
                    break;
                case 2 :
                    exit = true;
                    break;
                default :
                    println("Escolha uma opção válida");
            }
        }
    }
}