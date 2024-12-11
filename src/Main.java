import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Boas-vindas ao IMD Corp!");
        Operacoes operacoes = new Operacoes();
        operacoes.getBanco().carregarDados();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n==== MENU ====");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Técnico Administrativo");
            System.out.println("3. Listar Professores");
            System.out.println("4. Listar Técnicos Administrativos");
            System.out.println("5. Deletar Professor");
            System.out.println("6. Deletar Técnico Administrativo");
            System.out.println("7. Buscar Professor");
            System.out.println("8. Buscar Técnico Administrativo");
            System.out.println("9. Calcular Salário");
            System.out.println("0. Salvar e sair");

            Integer opcao = InputUtils.lerInteger("Escolha uma opção: ");

            switch(opcao){
                case 1:
                    clearScreen();
                    System.out.println("================== 1: Cadastro de professor ==================");
                    operacoes.cadastrarProfessor();
                    break;

                case 2:
                    clearScreen();
                    System.out.println("================== 2: Cadastro de técnico administrativo ==================");
                    operacoes.cadastrarTecnicoADM();
                    break;

                case 3:
                    clearScreen();
                    System.out.println("================== 3: Listagem de professores ==================");
                    operacoes.listarProfessores();
                    break;

                case 4:
                    clearScreen();
                    System.out.println("================== 4: Listagem de técnicos administrativos ==================");
                    operacoes.listarTecnicosADM();
                    break;

                case 5:
                    clearScreen();
                    System.out.println("================== 5: Deletar professor ==================");
                    Long matriculaProf = InputUtils.lerLong("Matrícula do professor a ser deletado: ");
                    operacoes.deletarProfessor(matriculaProf);
                    break;

                case 6:
                    clearScreen();
                    System.out.println("================== 6: Deletar técnico administrativo ==================");
                    Long matriculaTec = InputUtils.lerLong("Matrícula do técnico a ser deletado: ");
                    operacoes.deletarTecnicoADM(matriculaTec);
                    break;
                case 7:
                    clearScreen();
                    System.out.println("================== 7: Buscar professor ==================");
                    Long matriculaProfBusca =InputUtils.lerLong("Matrícula do professor: ");
                    operacoes.buscarProfessor(matriculaProfBusca);
                    break;
                case 8:
                    clearScreen();
                    System.out.println("================== 8: Buscar técnico administrativo ==================");
                    Long matriculaTecBusca = InputUtils.lerLong("Matrícula do técnico administrativo: ");
                    operacoes.buscarTecnicoADM(matriculaTecBusca);
                    break;
                case 0:
                    clearScreen();
                    System.out.println("================== 0: Salvar e Sair ==================");
                    operacoes.getBanco().salvarDados();
                    System.out.println("Dados salvos. Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");

            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}