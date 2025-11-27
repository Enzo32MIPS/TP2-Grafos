import java.util.*;

public class TopSort {

    public static void executar(Grafo g) {
        int v = g.getNumeroVertices();
        boolean[] visitado = new boolean[v];
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!visitado[i])
                dfs(g, i, visitado, pilha);
        }

        System.out.print("TopSort: ");
        while (!pilha.isEmpty())
            System.out.print(pilha.pop() + " ");
        System.out.println();
    }

    private static void dfs(Grafo g, int v, boolean[] vis, Stack<Integer> p) {
        vis[v] = true;

        for (Aresta e : g.getAdjacentes(v)) {
            if (!vis[e.destino])
                dfs(g, e.destino, vis, p);
        }

        p.push(v);
    }
}
