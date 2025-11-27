import java.util.Random;

public class GeradorGrafos {

    public static Grafo gerarGrafoLista(int vertices, double densidade) {
        GrafoListaAdjacencia g = new GrafoListaAdjacencia(vertices);
        Random r = new Random();
        int maxArestas = vertices * (vertices - 1) / 2;
        int numArestas = (int)(maxArestas * densidade);

        for (int i = 0; i < numArestas; i++) {
            int u = r.nextInt(vertices);
            int v = r.nextInt(vertices);
            if (u != v) {
                g.adicionarAresta(u, v, r.nextInt(10) + 1);
            }
        }
        return g;
    }

    public static Grafo gerarDigrafoLista(int vertices, double densidade) {
        DigrafoListaAdjacencia g = new DigrafoListaAdjacencia(vertices);
        Random r = new Random();
        int maxArestas = vertices * (vertices - 1);
        int numArestas = (int)(maxArestas * densidade);

        for (int i = 0; i < numArestas; i++) {
            int u = r.nextInt(vertices);
            int v = r.nextInt(vertices);
            if (u != v) {
                g.adicionarAresta(u, v, r.nextInt(10) + 1);
            }
        }
        return g;
    }
}
