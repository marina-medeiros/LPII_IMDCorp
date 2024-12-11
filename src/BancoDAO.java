import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

public class BancoDAO implements Serializable {
    private static final long serialVersionUID = 1L;

    private static BancoDAO instance;
    private ArrayList<Pessoa> funcionarios;

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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.bin"))) {
            // Salva a lista inteira como um único objeto
            oos.writeObject(funcionarios);
            System.out.println("Funcionários salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"))) {
            // Realiza o casting seguro
            funcionarios = (ArrayList<Pessoa>) ois.readObject();

            // Verifica e corrige possíveis problemas nos objetos
            for (Pessoa pessoa : funcionarios) {
                if (pessoa.getEndereco() == null) {
                    pessoa.setEndereco(new Endereco("Desconhecido", 0, "Desconhecido", "Desconhecido", "00000-000"));
                }
            }

            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Um novo arquivo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }


}
