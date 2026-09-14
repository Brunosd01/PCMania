package br.inatel.pcmania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Cliente cliente = new Cliente("Bruno Silva Defelicibus", "123.456.789-00");

        System.out.println("==============================================");
        System.out.println("          BEM-VINDO A PC MANIA!               ");
        System.out.println("==============================================");

        int opcao = 0;
        float matricula = 571f;
        int multiplicidadeClienteComputador = 0;
        do {
            System.out.println("\n--- Nossas Promoções Imperdíveis ---");
            System.out.println("1 - Promoção 1 (Apple, Core i5, 8GB RAM, 500GB HD, macOS, Pendrive 16GB)");
            System.out.println("2 - Promoção 2 (Samsung, Core i7, 16GB RAM, 1TB HD, Windows 8, Pendrive 32GB)");
            System.out.println("3 - Promoção 3 (Dell, Core i7, 32GB RAM, 2TB HD, Windows 10, HD Externo 1TB)");
            System.out.println("0 - Finalizar Carrinho de Compras");
            System.out.print("\nDigite o código da promoção que deseja comprar: ");

            if(multiplicidadeClienteComputador == 0){
                opcao = entrada.nextInt();
            }
            if(multiplicidadeClienteComputador >= 2){
                opcao = entrada.nextInt();
            }


            if(opcao == 0 && multiplicidadeClienteComputador == 0){
                break;
            }


            switch (opcao) {
                case 1:
                    System.out.println("> Promoção 1 adicionada ao carrinho!");
                    Computador pc1 = new Computador("Apple", matricula, "macOS Sequoia", 64);

                    pc1.getHardwareBasico()[0].setNome("Pentium Core i5");
                    pc1.getHardwareBasico()[0].setCapacidade(2200);
                    pc1.getHardwareBasico()[1].setNome("Memória RAM");
                    pc1.getHardwareBasico()[1].setCapacidade(8);
                    pc1.getHardwareBasico()[2].setNome("HD");
                    pc1.getHardwareBasico()[2].setCapacidade(500);

                    MemoriaUSB pendrive1 = new MemoriaUSB("Pen-drive", 16);
                    pc1.addMemoriaUSB(pendrive1);

                    cliente.adicionarComputador(pc1);
                    multiplicidadeClienteComputador++;
                    break;

                case 2:
                    System.out.println("> Promoção 2 adicionada ao carrinho!");
                    Computador pc2 = new Computador("Samsung", (matricula + 1), "Windows 8", 64);

                    pc2.getHardwareBasico()[0].setNome("Pentium Core i7");
                    pc2.getHardwareBasico()[0].setCapacidade(3370);
                    pc2.getHardwareBasico()[1].setNome("Memória RAM");
                    pc2.getHardwareBasico()[1].setCapacidade(16);
                    pc2.getHardwareBasico()[2].setNome("HD");
                    pc2.getHardwareBasico()[2].setCapacidade(1000);


                    MemoriaUSB pendrive2 = new MemoriaUSB("Pen-drive", 32);
                    pc2.addMemoriaUSB(pendrive2);

                    cliente.adicionarComputador(pc2);
                    multiplicidadeClienteComputador++;
                    break;

                case 3:
                    System.out.println("> Promoção 3 adicionada ao carrinho!");
                    Computador pc3 = new Computador("Dell", (matricula + 2), "Windows 10", 64);

                    pc3.getHardwareBasico()[0].setNome("Pentium Core i7");
                    pc3.getHardwareBasico()[0].setCapacidade(4500);
                    pc3.getHardwareBasico()[1].setNome("Memória RAM");
                    pc3.getHardwareBasico()[1].setCapacidade(32);
                    pc3.getHardwareBasico()[2].setNome("HD");
                    pc3.getHardwareBasico()[2].setCapacidade(2000);

                    MemoriaUSB hdExterno = new MemoriaUSB("HD Externo", 1000);
                    pc3.addMemoriaUSB(hdExterno);

                    cliente.adicionarComputador(pc3);
                    multiplicidadeClienteComputador++;
                    break;

                case 0:
                    System.out.println("\nFinalizando compra...");
                    break;

                default:
                    System.out.println("\nCódigo inválido! Tente novamente.");
                    break;
            }
            if(multiplicidadeClienteComputador < 2){
                System.out.println("\n--- Para participar da promoção adicione mais uma produto ao carrinho! ---");
                System.out.println("1 - Promoção 1 (Apple, Core i5, 8GB RAM, 500GB HD, macOS, Pendrive 16GB)");
                System.out.println("2 - Promoção 2 (Samsung, Core i7, 16GB RAM, 1TB HD, Windows 8, Pendrive 32GB)");
                System.out.println("3 - Promoção 3 (Dell, Core i7, 32GB RAM, 2TB HD, Windows 10, HD Externo 1TB)");
                System.out.print("\nDigite o código da promoção que deseja comprar: ");
                opcao = entrada.nextInt();
                while (opcao == 0 || opcao < 0 || opcao > 3){
                    System.out.println("Digite um número valido!");
                    opcao = entrada.nextInt();
                }
            }
        } while (opcao != 0 );

        ProcessarPedido.processar(cliente.getComputadores());

        System.out.println("\n==============================================");
        System.out.println("             RESUMO DA COMPRA                 ");
        System.out.println("==============================================");
        System.out.println("br.inatel.pcmania.Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        System.out.println("\n--- Itens Adquiridos ---");
        Computador[] compras = cliente.getComputadores();
        for (int i = 0; i < compras.length; i++) {
            if (compras[i] != null) {
                System.out.println("-> br.inatel.pcmania.Computador " + (i + 1) + ":");
                compras[i].mostraPCConfigs();
            }
        }

        System.out.println("----------------------------------------------");
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", cliente.calculaTotalCompra());
        System.out.println("==============================================");

        entrada.close();
    }
}