//Observer

package ex1;

public class Main {
    public static void main(String[] args) {
        // 5 produtos, 3 clientes e 1 gestor
        Produto p1 = new Produto(1,"Porsche 1901", 500000.0);
        Produto p2 = new Produto(2,"Diamante roxo", 200000.0);
        Produto p3 = new Produto(3,"Cartinhas de Yu-Gi-Oh!", 1250.0);
        Produto p4 = new Produto(4,"Monalisa 2.0 muito parecida", 150000.0);
        Produto p5 = new Produto(5,"Móvel com 500 anos", 5000.0);

        Cliente c1 = new Cliente("Tiago Caridade");
        Cliente c2 = new Cliente("Berto Sago");
        Cliente c3 = new Cliente("Anderson FIgueirense");

        Gestor g1 = new Gestor("Sardinha Almeida");

        System.out.println(
                "==================================== LEILÃO DO CEMITÉRIO ====================================");
        System.out.println();

        g1.receiveNotifys(p1);
        g1.receiveNotifys(p2);
        g1.receiveNotifys(p3);
        g1.receiveNotifys(p4);
        g1.receiveNotifys(p5);

        c1.receiveNotifys(p1);
        c1.receiveNotifys(p3);
        c1.receiveNotifys(p4);

        c2.receiveNotifys(p1);
        c2.receiveNotifys(p3);
        c2.receiveNotifys(p4);

        c3.receiveNotifys(p1);
        c3.receiveNotifys(p2);
        c3.receiveNotifys(p5);

        // Colocar os produtos em LEILAO:
        g1.atualizarEstado(p1, Estado.leilao);
        g1.atualizarEstado(p3, Estado.leilao);
        g1.atualizarEstado(p4, Estado.leilao); // não recebe licitações

        System.out.printf(
                "\n-----------------------------------------------------------------------------------------------------------------------n");

        c1.licitar(p2, 200500.0); // não está em leilão
        c2.licitar(p5, 5050.0); // não está em leilão

        System.out.printf(
                "\n-----------------------------------------------------------------------------------------------------------------------n");

        c1.licitar(p1, 512500.0);
        c3.licitar(p1, 513500.0);
        c2.licitar(p1, 511500.0); // NÃO VAI DAR PARA LICITAR
        c2.licitar(p1, 514500.0);
        g1.atualizarEstado(p1, Estado.vendas);

        System.out.printf(
                "-----------------------------------------------------------------------------------------------------------------------\n\n");

        c1.licitar(p3, 1350.0);
        c2.licitar(p3, 1400.0);
        g1.atualizarEstado(p3, Estado.vendas);

        System.out.printf(
            "-----------------------------------------------------------------------------------------------------------------------n\n");

        g1.atualizarEstado(p4, Estado.stock);

        System.out.printf(
                "-----------------------------------------------------------------------------------------------------------------------\n\n");

        g1.atualizarEstado(p5, Estado.leilao);
        c3.licitar(p5, 5050.5);
        g1.atualizarEstado(p5, Estado.vendas);
    }
}
