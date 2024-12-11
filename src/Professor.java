import java.time.LocalDate;
import java.util.List;
import java.io.Serializable;

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

    public Nivel getNivelProfessor() {return nivelProfessor;}
    public List<String> getDisciplinas() {return disciplinas;}
    public Formacao getFormacaoProfessor() {return formacaoProfessor;}
}
