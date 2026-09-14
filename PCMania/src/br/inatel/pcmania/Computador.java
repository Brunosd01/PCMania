package br.inatel.pcmania;

public class Computador {
    private String marca; // Atributo
    private float preco;  // Atributo

    // Associações
    private MemoriaUSB memoriaUSB;
    private HardwareBasico[] hardwareBasico;
    private SistemaOperacional sistemaOperacional;

    // Construtor
    public Computador(String marca, float preco, String nomeSO, int tipoSO) {

        this.setMarca(marca);
        this.setPreco(preco);

        // Criando o Sistema Operacional e passando o nome e tipo recebidos
        this.sistemaOperacional = new SistemaOperacional(nomeSO, tipoSO);

        // Inicializando o Array de Hardwares e instanciando cada posição
        this.hardwareBasico = new HardwareBasico[3];
        for (int i = 0; i < hardwareBasico.length; i++) {
            this.hardwareBasico[i] = new HardwareBasico("", 0);
        }

    }

    public void mostraPCConfigs(){
        System.out.println("=== Configurações ===");
        System.out.println();
        System.out.println("Marca: " + getMarca());
        System.out.println("Preço: " + getPreco());
        System.out.println("--Hardware--");
        for (int i = 0; i < hardwareBasico.length; i++){
            System.out.println(getHardwareBasico()[i].getNome());
            System.out.println(getHardwareBasico()[i].getCapacidade());
        }
        System.out.println();
        System.out.println("--Sistema operacional--");
        System.out.println(getSistemaOperacional().getNome());
        System.out.println(getSistemaOperacional().getTipo());
        System.out.println();

        if (this.memoriaUSB != null) {
            System.out.println("--Memória USB--");
            System.out.println(getMemoriaUSB().getNome() + " " + getMemoriaUSB().getCapacidade() + "Gb");
        }
    }
    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoriaUSB = musb;
    }


    // Getter e Setter
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public MemoriaUSB getMemoriaUSB() {
        return memoriaUSB;
    }
    public HardwareBasico[] getHardwareBasico() {
        return hardwareBasico;
    }
    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }
}
