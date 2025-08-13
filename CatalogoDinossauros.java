package catalogodinossauros;

import java.util.Scanner;

public class CatalogoDinossauros {

    public static void LimpaTela() {
        for (int linha = 1; linha < 70; linha++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int opcao = 0;
        int quantidade = 0;
        int indice = -1;
        String nome, tipo, periodo;
        final int MAX = 10;

        // Três vetores para armazenar as informações dos dinossauros
        String[] nomes = new String[MAX];
        String[] tipos = new String[MAX];
        String[] periodos = new String[MAX];

        // Faixas de anos para cada período
        int inicio_triassico = 250;
        int fim_triassico = 201;
        int inicio_jurassico = 201;
        int fim_jurassico = 145;
        int inicio_cretaceo = 145;
        int fim_cretaceo = 66;

         // Dados do quiz
        String[] perguntas = {
            "Qual dinossauro tinha placas osseas ao longo das costas?",
            "Qual e o nome do periodo em que os dinossauros se extinguiram?",
            "Qual dinossauro tinha um pescoco longo e era um dos maiores herbivoros?",
            "Qual dinossauro e conhecido por ser o primeiro a ser identificado e nomeado?",
            "Qual dinossauro marinho gigante, com dentes afiados, era um dos predadores mais temidos?"
        };

        String[][] alternativas = {
            {"(a) Estegossauro", "(b) Espinossauro", "(c) Pterossauro", "(d) Iguanodon"},
            {"(a) Triassico", "(b) Jurassico", "(c) Cretaceo", "(d) Devoniano"},
            {"(a) Tiranossauro Rex", "(b) Brachiosauro", "(c) Velociraptor", "(d) Triceratops"},
            {"(a) Triceratops", "(b) Tiranossauro Rex", "(c) Estegossauro", "(d) Megalossauro"},
            {"(a) Mosassauro", "(b) Espinossauro", "(c) Plesiossauro", "(d) Megalodon"}
        };

        String[] respostas_corretas = {
            "a", // Estegossauro
            "c", // Cretaceo
            "b", // Brachiosauro
            "d", // Megalossauro
            "a"  // Mosassauro
        };

        int pontos = 0;

        do {
            do { // MENU
                System.out.println("0 - Listar todos os dinossauros");
                System.out.println("1 - Incluir dinossauro");
                System.out.println("2 - Alterar dinossauro");
                System.out.println("3 - Excluir dinossauro");
                System.out.println("4 - Buscar dinossauro");
                System.out.println("5 - Ordenar dinossauros");
                System.out.println("6 - Calcular anos de vida de um dinossauro");
                System.out.println("7 - Contar dinossauros por periodo");
                System.out.println("8 - Iniciar quiz sobre dinossauros");
                System.out.println("9 - Sair");
                opcao = tec.nextInt();
                tec.nextLine(); // Consumir nova linha

                if (opcao < 0 || opcao > 9) {
                    System.out.println("OPCAO INVALIDA");
                }
            } while (opcao < 0 || opcao > 9);

            LimpaTela();

            // LISTAR TODOS
            if (opcao == 0) {
                System.out.println("LISTAGEM DOS DINOSSAUROS");
                if (quantidade == 0) {
                    System.out.println("Nenhum dinossauro no catalogo.");
                    System.out.println("-----------------------------");
                } else {
                    for (int i = 0; i < quantidade; i++) {
                        System.out.println(i + " - Nome: " + nomes[i] + ", Tipo: " + tipos[i] + ", Periodo: " + periodos[i]);
                        System.out.println("-------------------------------------------------------------");
                    }
                }
            }

            // INCLUIR
            if (opcao == 1) {
                if (quantidade < MAX) {
                    System.out.println("DIGITE O NOME DO DINOSSAURO:");
                    nome = tec.nextLine();

                    System.out.println("DIGITE O TIPO DO DINOSSAURO(CARNIVORO, HERBIVORO, ONIVORO, ETC...):");
                    tipo = tec.nextLine();

                    System.out.println("DIGITE O PERIODO DO DINOSSAURO(TRIASSICO, JURASSICO OU CRETACEO):");
                    periodo = tec.nextLine();

                    nomes[quantidade] = nome;
                    tipos[quantidade] = tipo;
                    periodos[quantidade] = periodo;
                    quantidade++;

                    System.out.println("Dinossauro adicionado com sucesso!");
                    System.out.println("----------------------------------");
                } else {
                    System.out.println("CATALOGO CHEIO");
                    System.out.println("-----------------------------");
                }
            }

            // ALTERAR
            if (opcao == 2) {
                System.out.println("QUAL O INDICE VAI ALTERAR?");
                indice = tec.nextInt();
                tec.nextLine(); // Consumir nova linha
                if (indice < 0 || indice >= quantidade) {
                    System.out.println("INDICE INVALIDO");
                    System.out.println("-----------------------------");
                } else {
                    System.out.println("DIGITE O NOVO NOME DO DINOSSAURO:");
                    nome = tec.nextLine();

                    System.out.println("DIGITE O NOVO TIPO DO DINOSSAURO (CARNIVORO, HERBIVORO, ONIVORO, ETC...):");
                    tipo = tec.nextLine();

                    System.out.println("DIGITE O NOVO PERIODO DO DINOSSAURO(TRIASSICO, JURASSICO OU CRETACEO):");
                    periodo = tec.nextLine();

                    nomes[indice] = nome;
                    tipos[indice] = tipo;
                    periodos[indice] = periodo;

                    System.out.println("Dinossauro alterado com sucesso!");
                    System.out.println("-----------------------------");
                }
            }

             // EXCLUIR
            if (opcao == 3) {
                System.out.println("QUAL O INDICE DO DINOSSAURO A SER EXCLUIDO?");
                indice = tec.nextInt();
                tec.nextLine(); // Consumir a nova linha

                if (indice < 0 || indice >= quantidade) {
                    System.out.println("INDICE INVALIDO");
                    System.out.println("-----------------------------");
                } else {
                    for (int i = indice; i < quantidade - 1; i++) {
                        nomes[i] = nomes[i + 1];
                        tipos[i] = tipos[i + 1];
                        periodos[i] = periodos[i + 1];
                    }
                    // Reduz a quantidade
                    quantidade--;
                    System.out.println("Dinossauro excluido com sucesso!");
                    System.out.println("--------------------------------");
                }
            }

            // BUSCAR
            if (opcao == 4) {
                System.out.println("DIGITE O NOME DO DINOSSAURO PARA BUSCAR:");
                nome = tec.nextLine();
                int achei = -1;
                for (int i = 0; i < quantidade; i++) {
                    if (nomes[i].equalsIgnoreCase(nome)) {
                        achei = i;
                        break;
                    }
                }
                if (achei == -1) {
                    System.out.println("DINOSSAURO NAO ENCONTRADO");
                    System.out.println("-----------------------------");
                } else {
                    System.out.println("DINOSSAURO ENCONTRADO: ");
                    System.out.println("Nome: " + nomes[achei] + ", Tipo: " + tipos[achei] + ", Periodo: " + periodos[achei]);
                    System.out.println("------------------------------------------------------------");
                }
            }

            // ORDENAR
            if (opcao == 5) {
                if (quantidade == 0) {
                    System.out.println("Nenhum dinossauro para ordenar");
                    System.out.println("-----------------------------");
                } else {
                    for (int i = 0; i < quantidade - 1; i++) {
                        for (int j = i + 1; j < quantidade; j++) {
                            if (nomes[i].compareTo(nomes[j]) > 0) {
                                // Troca os dinossauros de lugar nos três vetores
                                String tempNome = nomes[i];
                                nomes[i] = nomes[j];
                                nomes[j] = tempNome;

                                String tempTipo = tipos[i];
                                tipos[i] = tipos[j];
                                tipos[j] = tempTipo;

                                String tempPeriodo = periodos[i];
                                periodos[i] = periodos[j];
                                periodos[j] = tempPeriodo;
                            }
                        }
                    }
                    System.out.println("Dinossauros ordenados por ordem alfabetica com sucesso!");
                    System.out.println("----------------------------------------------------------");
                }
            }

            // CALCULAR ANOS DE VIDA DE UM DINOSSAURO
            if (opcao == 6) {
                System.out.println("DIGITE O INDICE DO DINOSSAURO PARA CALCULAR ANOS DE VIDA:");
                indice = tec.nextInt();
                tec.nextLine(); // Consumir a nova linha

                if (indice < 0 || indice >= quantidade) {
                    System.out.println("INDICE INVALIDO");
                    System.out.println("-----------------------------");
                } else {
                    periodo = periodos[indice];
                    int anosVividos = 0;
                    if (periodo.equalsIgnoreCase("triassico")) {
                        anosVividos = inicio_triassico - fim_triassico;
                    } else if (periodo.equalsIgnoreCase("jurassico")) {
                        anosVividos = inicio_jurassico - fim_jurassico;
                    } else if (periodo.equalsIgnoreCase("cretaceo")) {
                        anosVividos = inicio_cretaceo - fim_cretaceo;
                    } else {
                        System.out.println("Periodo nao reconhecido");
                    }

                    if (anosVividos > 0) {
                        System.out.println("O dinossauro viveu aproximadamente " + anosVividos + " milhoes de anos");
                        System.out.println("------------------------------------------------------------");
                    }
                }
            }

            // CONTAR DINOSSAUROS POR PERÍODO
            if (opcao == 7) {
                int cont_triassico = 0;
                int cont_jurassico = 0;
                int cont_cretaceo = 0;

                for (int i = 0; i < quantidade; i++) {
                    if (periodos[i].equalsIgnoreCase("triassico")) {
                        cont_triassico++;
                    } else if (periodos[i].equalsIgnoreCase("jurassico")) {
                        cont_jurassico++;
                    } else if (periodos[i].equalsIgnoreCase("cretaceo")) {
                        cont_cretaceo++;
                    }
                }

                System.out.println("CONTAGEM DE DINOSSAUROS POR PERIODO:");
                System.out.println("Triassico: " + cont_triassico);
                System.out.println("Jurassico: " + cont_jurassico);
                System.out.println("Cretaceo: " + cont_cretaceo);
                System.out.println("-----------------------------");
            }

            if (opcao == 8) {
                for (int i = 0; i < perguntas.length; i++) {
                    System.out.println("Pergunta " + (i + 1) + ": " + perguntas[i]);
                    for (String alternativa : alternativas[i]) {
                        System.out.println(alternativa);
                    }
                    System.out.println("Digite sua resposta: ");
                    String resposta = tec.nextLine();

                    if (resposta.equalsIgnoreCase(respostas_corretas[i])) {
                        System.out.println("Resposta correta!");
                        pontos++;
                    } else {
                        System.out.println("Resposta incorreta. A resposta correta e: " + respostas_corretas[i]);
                    }
                    System.out.println("----------------------------------------------------");
                }
                System.out.println("Voce acertou " + pontos + " de " + perguntas.length + " perguntas.");
                System.out.println("------------------------------------------------------------");
            }

        } while (opcao != 9);

        System.out.println("Saindo...");
    }
}