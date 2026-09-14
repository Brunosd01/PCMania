package br.inatel.pcmania;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;

    public Cliente(String nome, String cpf){
        this.setNome(nome);
        this.setCpf(cpf);
        this.computadores = new Computador[10];
    }
    public float calculaTotalCompra(){
        float total = 0;
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] != null) {
                total += computadores[i].getPreco();
            }
        }
        return total;
    }

    public void adicionarComputador(Computador pc) {
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] == null) {
                computadores[i] = pc;
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }
}
