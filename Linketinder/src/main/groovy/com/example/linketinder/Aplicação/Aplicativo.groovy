package com.example.linketinder.Aplicacao
import com.example.linketinder.Aplicação.BancodeDados
import com.example.linketinder.Aplicação.Candidato
import com.example.linketinder.Aplicação.Competencia
import com.example.linketinder.Aplicação.Empresa
import com.example.linketinder.Aplicação.TabelaDeVagas;

class Aplicativo {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in)
        boolean exit = false;
        while(!exit){
            print("Escolha uma opção : " + "\n 1 Listar Empresas " + "\n 2 Listar Empresas " + "\n 3 Listar Empresas " + "\n 4 Listar Empresas " + "\n 5 Listar Empresas ")
            int opcao = input.nextInt();
            switch (opcao){
                case 1 :
                    Candidato.listar_Candidato()
                    break;
                case 2 :
                    Empresa.listar_Empresa()
                    break;
                case 3 :
                    Competencia.competencia_Candidatos()
                    break;
                case 4 :
                    TabelaDeVagas.tabela_De_Vagas()
                    break;
                case 5 :
                    exit = true;
                    break;
                default :
                    println("Escolha uma opção válida");
            }
        }
    }
}
