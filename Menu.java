import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = 6;
        double densidade = 0.4;

        // O MESMO GRAFO em duas representações
        GrafoListaAdjacencia gLista = new GrafoListaAdjacencia(vertices);
        GrafoMatrizAdjacencia gMatriz = new GrafoMatrizAdjacencia(vertices);

        // GERAR ARESTAS (sincronizadas)
        GeradorGrafos.gerarArestas(gLista, gMatriz, vertices, densidade);

        // Ponteiro para o grafo em uso
        Grafo gAtual = gLista;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("Representação atual: " + gAtual.getClass().getSimpleName());
            System.out.println("1. BFS");
            System.out.println("2. DFS");
            System.out.println("3. TopSort");
            System.out.println("4. Kruskal");
            System.out.println("5. Prim");
            System.out.println("6. Dijkstra");
            System.out.println("7. Bellman-Ford");
            System.out.println("8. Floyd-Warshall");
            System.out.println("9. Mostrar grafo (Lista)");
            System.out.println("10. Mostrar grafo (Matriz)");
            System.out.println("11. Usar Lista de Adjacência");
            System.out.println("12. Usar Matriz de Adjacência");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();

            Cronometro c = new Cronometro();
            c.iniciar();

            switch (op) {

                case 1: BFS.executar(gAtual, 0); break;
                case 2: DFS.executar(gAtual, 0); break;
                case 3: TopSort.executar(gAtual); break;
                case 4: Kruskal.executar(gAtual); break;
                case 5: Prim.executar(gAtual, 0); break;
                case 6: Dijkstra.executar(gAtual, 0); break;
                case 7: BellmanFord.executar(gAtual, 0); break;
                case 8: FloydWarshall.executar(gAtual); break;

                case 9:
                    System.out.println("Grafo em LISTA:");
                    gLista.imprimir();
                    break;

                case 10:
                    System.out.println("Grafo em MATRIZ:");
                    gMatriz.imprimir();
                    break;

                case 11:
                    gAtual = gLista;
                    System.out.println("Agora usando LISTA DE ADJACÊNCIA.");
                    break;

                case 12:
                    gAtual = gMatriz;
                    System.out.println("Agora usando MATRIZ DE ADJACÊNCIA.");
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }

            if (op >= 1 && op <= 8) {
                System.out.printf("Tempo: %.4f ms\n", c.tempoDecorridoMs());
            }
        }
    }
}
