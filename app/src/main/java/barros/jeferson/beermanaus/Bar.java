package barros.jeferson.beermanaus;

/**
 * Created by jbalves on 10/20/16.
 */

public class Bar {
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private String fotoDivulgacao;

    public Bar(String nome, String endereco, String horarioFuncionamento, String fotoDivulgacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
        this.fotoDivulgacao = fotoDivulgacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getFotoDivulgacao() {
        return fotoDivulgacao;
    }

    public void setFotoDivulgacao(String fotoDivulgacao) {
        this.fotoDivulgacao = fotoDivulgacao;
    }
}
