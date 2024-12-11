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
            oos.writeObject(funcionarios);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"))) {
            funcionarios = (ArrayList<Pessoa>) ois.readObject();

            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Um novo arquivo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }


}
