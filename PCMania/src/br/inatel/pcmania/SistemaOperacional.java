package br.inatel.pcmania;

public class SistemaOperacional {
    private String nome;
    private int tipo;
    private Computador[] computadores;

    public SistemaOperacional(String nome, int tipo) {

        this.setNome(nome);
        this.setTipo(tipo);

        this.computadores = new Computador[10];
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
