import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static LocalDate lerData(String tipoData){
        while (true) {
            try {
                System.out.println("Data de " + tipoData + " (yyyy-mm-dd): ");
                String input = scanner.nextLine();
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Por favor, insira a data no formato yyyy-mm-dd.");
            }
        }
    }

    public static Genero lerGenero(){
        while(true) {
            try{
                System.out.print("Gênero (MASC/FEM): ");
                return Genero.valueOf(scanner.nextLine().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Entrada inválida! Por favor, insira um gênero válido (MASC/FEM).");
            }
        }
    }

    public static Nivel lerNivel(){
        while(true){
            try{
                System.out.print("Nível (I, II, III, IV, V, VI, VII, VIII): ");
                return Nivel.valueOf(scanner.nextLine().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Entrada inválida! Por favor, insira um nível válido (I, II, III, IV, V, VI, VII, VIII).");
            }
        }
    }

    public static Formacao lerFormacao(){
        while(true){
            try{
                System.out.print("Formação do Técnico (ESPECIALIZACAO, MESTRADO, DOUTORADO): ");
                return Formacao.valueOf(scanner.nextLine().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Entrada inválida! Por favor, insira uma formação válida (ESPECIALIZACAO, MESTRADO, DOUTORADO).");
            }
        }
    }

    public static Boolean lerBool(String mensagem){
        System.out.println(mensagem);
        while (true) {
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (entrada.equals("SIM")) {
                return true;
            } else if (entrada.equals("NÃO") || !entrada.equals("NAO")) {
                return false;
            }
            System.out.println("Resposta inválida! Por favor, digite 'SIM' ou 'NÃO'.");
        }
    }

    public static String lerString(String mensagem){
        System.out.println(mensagem);
        return scanner.nextLine().trim();
    }

    public static Long lerLong(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
            }
        }
    }

    public static Integer lerInteger(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
            }
        }
    }

    public static List<String> lerDisciplinas(){
        List<String> disciplinas = new ArrayList<>();

        while(disciplinas.isEmpty() || disciplinas == null) {
            try{
                System.out.println("Digite as disciplinas (separadas por vírgula): ");
                String input = scanner.nextLine();

                disciplinas = Arrays.stream(input.split(",")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());

                if(disciplinas.isEmpty()){
                    System.out.println("A lista de disciplinas não pode ser vazia. Tente novamente.");
                }
            }catch (Exception e){
                System.out.println("Erro ao processar entrada. Tente novamente.");
                disciplinas = null;
            }
        }

        return disciplinas;
    }
}
