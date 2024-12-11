import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Operacoes {
    private BancoDAO banco = BancoDAO.getInstance();

    public BancoDAO getBanco() {
        return banco;
    }

    public void cadastrarProfessor(){
        String nome = InputUtils.lerString("Nome: ");

        String cpf = InputUtils.lerString("CPF: ");

        LocalDate dataNascimento = InputUtils.lerData("Nascimento");

        Genero genero = InputUtils.lerGenero();

        Endereco endereco = cadastrarEndereco();

        Long matricula = InputUtils.lerLong("Matricula: ");

        String departamento = InputUtils.lerString("Departamento: ");

        Integer cargaHoraria = InputUtils.lerInteger("Carga Horaria: ");

        LocalDate dataIngresso = InputUtils.lerData("Ingresso");

        Nivel nivelProfessor = InputUtils.lerNivel();

        Formacao formacao = InputUtils.lerFormacao();

        List<String> disciplinas = InputUtils.lerDisciplinas();

        Professor professor = new Professor(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso, nivelProfessor, formacao, disciplinas);
        if(banco.getArrayPessoa().add(professor)){
            System.out.println("Professor cadastrado com sucesso!");
        }else{
            System.out.println("Erro ao cadastrar professor!");
        }
    }

    public void cadastrarTecnicoADM(){
        String nome = InputUtils.lerString("Nome: ");

        String cpf = InputUtils.lerString("CPF: ");

        LocalDate dataNascimento = InputUtils.lerData("Nascimento");

        Genero genero = InputUtils.lerGenero();

        Endereco endereco = cadastrarEndereco();

        Long matricula = InputUtils.lerLong("Matricula: ");

        String departamento = InputUtils.lerString("Departamento: ");

        Integer cargaHoraria = InputUtils.lerInteger("Carga Horaria: ");

        LocalDate dataIngresso = InputUtils.lerData("Ingresso");

        Nivel nivelTecnico = InputUtils.lerNivel();

        Formacao formacaoTecnico = InputUtils.lerFormacao();

        Boolean insalubridade = InputUtils.lerBool("Recebe insalubridade? (SIM/NÃO): ");

        Boolean funcaoGratificada = InputUtils.lerBool("Recebe função gratificada? (SIM/NÃO): ");

        TecnicoADM tecnicoADM = new TecnicoADM(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso, nivelTecnico, formacaoTecnico, insalubridade, funcaoGratificada);
        if(banco.getArrayPessoa().add(tecnicoADM)){
            System.out.println("TécnicoADM cadastrado com sucesso!");
        }else{
            System.out.println("Erro ao cadastrar técnicoADM!");
        }
    }

    public Endereco cadastrarEndereco(){
        System.out.println("----------------------------------");
        System.out.println("Cadastre o endereço:");

        String rua = InputUtils.lerString("Rua: ");
        Integer numero = InputUtils.lerInteger("Número: ");
        String bairro = InputUtils.lerString("Bairro: ");
        String cidade = InputUtils.lerString("Cidade: ");
        String cep = InputUtils.lerString("CEP: ");

        System.out.println("----------------------------------");

        return new Endereco(rua, numero, bairro, cidade, cep);
    }

    public void detalharEndereco(Pessoa pessoa){
        System.out.println("Endereço:");
        System.out.println("Rua: " + pessoa.getEndereco().getRua() + ", " + pessoa.getEndereco().getNumero() + ", " + pessoa.getEndereco().getBairro() + ". " + pessoa.getEndereco().getCidade());
        System.out.println("CEP: " + pessoa.getEndereco().getCep());
    }

    public void detalharProfessor(Professor professor){
        System.out.println("-----------------------------------");
        System.out.println("Professor: " + professor.getNome());
        System.out.println("CPF: " + professor.getCpf());
        System.out.println("Data de nascimento: " + professor.getDataNascimento());
        System.out.println("Genero: " + professor.getGenero());
        detalharEndereco(professor);
        System.out.println("Matricula: " + professor.getMatricula());
        System.out.println("Salario: R$ " + professor.getSalario());
        System.out.println("Departamento: " + professor.getDepartamento());
        System.out.println("Carga Horaria: " + professor.getCargaHoraria());
        System.out.println("Data de ingresso: " + professor.getDataIngresso());
        System.out.println("Nivel: " + professor.getNivelProfessor());
        System.out.println("Formação: " + professor.getFormacaoProfessor());
        System.out.println("Disciplinas: ");
        for(String disciplina: professor.getDisciplinas()){
            System.out.println(disciplina);
        }
        System.out.println("-----------------------------------");
    }

    public void detalharTecnicoADM(TecnicoADM tecnicoADM){
        System.out.println("-----------------------------------");
        System.out.println("Tecnico: " + tecnicoADM.getNome());
        System.out.println("CPF: " + tecnicoADM.getCpf());
        System.out.println("Data de nascimento: " + tecnicoADM.getDataNascimento());
        System.out.println("Genero: " + tecnicoADM.getGenero());
        detalharEndereco(tecnicoADM);
        System.out.println("Matricula: " + tecnicoADM.getMatricula());
        System.out.println("Salario: R$" + tecnicoADM.getSalario());
        System.out.println("Departamento: " + tecnicoADM.getDepartamento());
        System.out.println("Carga Horaria: " + tecnicoADM.getCargaHoraria());
        System.out.println("Data de ingresso: " + tecnicoADM.getDataIngresso());
        System.out.println("Nivel: " + tecnicoADM.getNivelTecnico());
        System.out.println("Formação: " + tecnicoADM.getFormacaoTecnico());
        System.out.println("-----------------------------------");
    }

    public void listarProfessores(){
        for(Pessoa p : banco.getArrayPessoa()){
            if(p instanceof Professor){
                detalharProfessor((Professor) p);
            }
        }
    }

    public void listarTecnicosADM(){
        for(Pessoa p : banco.getArrayPessoa()){
            if(p instanceof TecnicoADM){
                detalharTecnicoADM((TecnicoADM) p);
            }
        }

    }

    public void deletarProfessor(Long matricula){
        Pessoa professorDeletado = buscarProfessor(matricula);
        if(professorDeletado == null){
            System.out.println("Professor não encontrado.");
        }else{
            banco.getArrayPessoa().remove(professorDeletado);
            System.out.println("Professor removido com sucesso.");
        }
    }

    public void deletarTecnicoADM(Long matricula){
        Pessoa tecnicoDeletado = buscarTecnicoADM(matricula);
        if(tecnicoDeletado == null){
            System.out.println("TecnicoADM não encontrado.");
        }else{
            banco.getArrayPessoa().remove(tecnicoDeletado);
            System.out.println("TecnicoADM removido com sucesso.");
        }
    }

    public Pessoa buscarProfessor(Long matricula){
        for(Pessoa p : banco.getArrayPessoa()){
            if(p.getMatricula().equals(matricula)){
                if(p instanceof Professor){
                    detalharProfessor((Professor) p);
                    return p;
                }
            }
        }
        return null;
    }

    public Pessoa buscarTecnicoADM(Long matricula){
        for(Pessoa p : banco.getArrayPessoa()){
            if(p.getMatricula().equals(matricula)){
                if(p instanceof TecnicoADM){
                    detalharTecnicoADM((TecnicoADM) p);
                    return p;
                }
            }
        }
        return null;
    }

    public Double calcularSalario(Long matricula){
        Pessoa pessoa = buscarProfessor(matricula);
        if(pessoa == null){
            pessoa = buscarTecnicoADM(matricula);
        }

        if(pessoa instanceof Professor){
            return ((Professor) pessoa).getSalario();
        }else if(pessoa instanceof TecnicoADM){
            return ((TecnicoADM) pessoa).getSalario();
        }

        return null;
    }
}