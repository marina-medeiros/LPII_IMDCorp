import java.io.Serializable;

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco(String rua, Integer numero, String bairro, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() { return rua; }
    public void setRua(String rua) {this.rua = rua;}
    public Integer getNumero() {return numero;}
    public void setNumero(Integer numero) {this.numero = numero;}
    public String getBairro() {return bairro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}

}
