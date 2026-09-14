package br.inatel.pcmania;

public class HardwareBasico {
    private String nome;
    private float capacidade;

    public HardwareBasico(String nome, float capacidade) {
        this.setNome(nome);
        this.setCapacidade(capacidade);
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getCapacidade() {
        return this.capacidade;
    }
    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }
}
