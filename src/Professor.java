import java.time.LocalDate;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends Pessoa implements Funcionario, Serializable{
    private static final long serialVersionUID = 1L;
    private Nivel nivelProfessor;
    private Formacao formacaoProfessor;
    private List<String> disciplinas;

    @Override
    public Double calculaSalario() {
        Double salarioBase = 4000.0;

        int formacao = formacaoProfessor.ordinal();
        Double adicionalFormação = salarioBase * (formacao + 1)*0.25;

        int nivel = nivelProfessor.ordinal();
        for(int i = 0; i < nivel; i++) {
            salarioBase = salarioBase * 1.05;
        }

        Double salarioFinal = salarioBase + adicionalFormação;

        return salarioFinal;
    }

    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
              Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso,
              Nivel nivelProfessor, Formacao formacao, List<String> disciplinas) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso);
        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacao;
        this.disciplinas = disciplinas;
        this.salario = calculaSalario();
    }

//    public Professor() {
//        super(); // Chama o construtor padrão da classe pai
//        this.nivelProfessor = null; // ou algum valor padrão
//        this.formacaoProfessor = null; // ou outro valor padrão
//        this.disciplinas = new ArrayList<>(); // Inicializa uma lista vazia
//        this.salario = 0.0; // ou outro valor padrão
//    }

    public Nivel getNivelProfessor() {return nivelProfessor;}
    public List<String> getDisciplinas() {return disciplinas;}
    public Formacao getFormacaoProfessor() {return formacaoProfessor;}
    public void setNivelProfessor(Nivel nivelProfessor) {this.nivelProfessor = nivelProfessor;}
    public void setFormacaoProfessor(Formacao formacaoProfessor) {this.formacaoProfessor = formacaoProfessor;}
    public void setDisciplinas(List<String> disciplinas) {this.disciplinas = disciplinas;}
}
