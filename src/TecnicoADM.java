import java.io.Serializable;
import java.time.LocalDate;

public class TecnicoADM extends Pessoa implements Funcionario, Serializable{
    private static final long serialVersionUID = 1L;
    private Nivel nivelTecnico;
    private Formacao formacaoTecnico;
    private Boolean insalubridade;
    private Boolean funcaoGratificada;

    @Override
    public Double calculaSalario() {
        Double salarioBase = 4000.0;

        int formacao = formacaoTecnico.ordinal();
        Double adicionalFormação = 0.0;
        switch(formacao) {
            case 0:
                adicionalFormação = salarioBase * 0.25;
                break;
            case 1:
                adicionalFormação = salarioBase * 0.5;
                break;
            case 2:
                adicionalFormação = salarioBase * 0.75;
                break;
        }

        Double adicionalInsalubidade = 0.0;

        if(insalubridade) {
            adicionalInsalubidade = salarioBase * 0.5;
        }

        Double adicionalGratificacao = 0.0;

        if(funcaoGratificada) {
            adicionalGratificacao = salarioBase * 0.5;
        }

        int nivel = nivelTecnico.ordinal();
        for(int i = 0; i < nivel; i++) {
            salarioBase = salarioBase * 1.03;
        }

        Double salarioFinal = salarioBase + adicionalFormação + adicionalInsalubidade + adicionalGratificacao;

        return salarioFinal;
    }

    public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
               Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso,
               Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso);
        this.nivelTecnico = nivelTecnico;
        this.formacaoTecnico = formacaoTecnico;
        this.insalubridade = insalubridade;
        this.funcaoGratificada = funcaoGratificada;
        this.salario = calculaSalario();
    }

    public Nivel getNivelTecnico() { return nivelTecnico;}
    public Formacao getFormacaoTecnico() { return formacaoTecnico;}
}