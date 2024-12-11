import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

public class BancoDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static BancoDAO instance;
    private ArrayList<Pessoa> funcionarios;
    private static final String ARQUIVO_BINARIO = "dados.bin";

    private BancoDAO() {
        funcionarios = new ArrayList<>();
    }

    public static BancoDAO getInstance() {
        if (instance == null) {
            instance = new BancoDAO();
        }
        return instance;
    }

    public ArrayList<Pessoa> getArrayPessoa() {
        return funcionarios;
    }

    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BINARIO))) {
            oos.writeObject(funcionarios);
            System.out.println("Funcionários salvos com sucesso!");
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

//    public void carregarDados() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_BINARIO))) {
//            ArrayList<Pessoa> funcionariosCarregados = (ArrayList<Pessoa>) ois.readObject();
//            funcionarios.addAll(funcionariosCarregados);
//            System.out.println("Dados carregados com sucesso!");
//        } catch (FileNotFoundException e) {
//            System.out.println("Arquivo de dados não encontrado. Um novo arquivo será criado.");
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Erro ao carregar dados: " + e.getMessage());
//        }
//    }

    public void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_BINARIO))) {
            ArrayList<Pessoa> funcionariosCarregados = (ArrayList<Pessoa>) ois.readObject();

            // Verifica se todos os funcionários têm dados válidos
            for (Pessoa pessoa : funcionariosCarregados) {
                if (pessoa.getEndereco() == null) {
                    pessoa.setEndereco(new Endereco("Desconhecido", 0, "Desconhecido", "Desconhecido", "00000-000"));
                }
            }

            funcionarios.addAll(funcionariosCarregados);
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Um novo arquivo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

}
