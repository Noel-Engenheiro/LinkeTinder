package com.example.aczg

class Empresa {

//Dados das empresas
//String nomedaempresa

            String nomedaempresa
    String emailcorporativo
    String cnpj
    String pais
    String estadoempresa
    String cepempresa
    String descricaodaempresa

//Competências esperadas pela empresa
    String assiduidade
    String capadidadedeiniciativa
    String responsabilidade
    String disponibilidade
    String respeito



    void toStrings() {
        println("Nome do candidato : " + nomedaempresa)
        println("Nome do candidato : " + emailcorporativo)
        println("Nome do candidato : " + cnpj)
        println("Nome do candidato : " + pais)
        println("Nome do candidato : " + estadoempresa)
        println("Nome do candidato : " + cepempresa)
        println("Nome do candidato : " + descricaodaempresa + "\n")


    }

    void assiduidade() {
        println("Nome da competência : " + assiduidade + "\n")
    }

    void capadidadedeiniciativa() {
        println("Qual é o e-mail : " + capadidadedeiniciativa + "\n")
    }

    void responsabilidade() {
        println("Número do CPF : " + responsabilidade + "\n")
    }

    void disponibilidade() {
        println("Qual é a idade : " + disponibilidade + "\n")
    }

    void respeito() {
        println("Qual é o Estado : " + respeito + "\n")
    }

}
