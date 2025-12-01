import java.util.ArrayList;
import java.util.List;

public class GrafoMatrizAdjacencia implements Grafo {

    private int vertices;
    private double[][] matriz;

    public GrafoMatrizAdjacencia(int vertices) {
        this.vertices = vertices;
        matriz = new double[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    @Override
    public int getNumeroVertices() {
        return vertices;
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        adicionarAresta(origem, destino, 1.0);
    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) {
        matriz[origem][destino] = peso;   // <-- APENAS ISSO
    }

    @Override
    public List<Aresta> getAdjacentes(int vertice) {
        List<Aresta> lista = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (matriz[vertice][i] != 0) {
                lista.add(new Aresta(vertice, i, matriz[vertice][i]));
            }
        }
        return lista;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
