import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Grafo g = GeradorGrafos.gerarGrafoLista(6, 0.4);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 – BFS");
            System.out.println("2 – DFS");
            System.out.println("3 – TopSort");
            System.out.println("4 – Kruskal");
            System.out.println("5 – Prim");
            System.out.println("6 – Dijkstra");
            System.out.println("7 – Bellman-Ford");
            System.out.println("8 – Floyd-Warshall");
            System.out.println("9 – Mostrar grafo");
            System.out.println("0 – Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();

            Cronometro c = new Cronometro();
            c.iniciar();

            switch (op) {

                case 1: BFS.executar(g, 0); break;
                case 2: DFS.executar(g, 0); break;
                case 3: TopSort.executar(g); break;
                case 4: Kruskal.executar(g); break;
                case 5: Prim.executar(g, 0); break;
                case 6: Dijkstra.executar(g, 0); break;
                case 7: BellmanFord.executar(g, 0); break;
                case 8: FloydWarshall.executar(g); break;
                case 9: g.imprimir(); break;
                case 0: System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.printf("Tempo: %.4f ms\n", c.tempoDecorridoMs());
        }
    }
}
