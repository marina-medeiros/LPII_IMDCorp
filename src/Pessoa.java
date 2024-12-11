import java.io.Serializable;
import java.time.LocalDate;
import java.io.Serializable;

public abstract class Pessoa{
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Genero genero;
    private Endereco endereco;
    private Long matricula;
    protected Double salario;
    private String departamento;
    private Integer cargaHoraria;
    private LocalDate dataIngresso;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
                  Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.matricula = matricula;
        this.salario = null;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataIngresso = dataIngresso;
    }

    public Pessoa(){
        this.nome = null;
        this.cpf = null;
        this.dataNascimento = null;
        this.genero = null;
        this.endereco = null;
        this.matricula = null;
        this.salario = null;
        this.departamento = null;
        this.cargaHoraria = null;
        this.dataIngresso = null;
    }


    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public Genero getGenero() { return genero; }
    public Endereco getEndereco() { return endereco; }
    public Long getMatricula() { return matricula; }
    public Double getSalario() { return salario; }
    public String getDepartamento() { return departamento; }
    public Integer getCargaHoraria() { return cargaHoraria; }
    public LocalDate getDataIngresso() { return dataIngresso; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setDataNascimento(LocalDate data) { this.dataNascimento = data; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco;}
    public void setMatricula(Long matricula) { this.matricula = matricula; }
    public void setSalario(Double salario) { this.salario = salario; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public void setDataIngresso(LocalDate dataIngresso) {this.dataIngresso = dataIngresso;}
}
