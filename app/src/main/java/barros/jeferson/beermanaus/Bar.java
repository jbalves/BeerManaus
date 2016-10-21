package barros.jeferson.beermanaus;

import java.io.Serializable;

/**
 * Created by Jeferson Barros on 10/20/16.
 */

public class Bar implements Serializable{
    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private String fotoDivulgacao;

    public Bar() {

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
