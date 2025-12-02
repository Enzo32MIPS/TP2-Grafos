import java.util.*;

public class TopSort {

    public static void executar(Grafo g) {
        int v = g.getNumeroVertices();
        boolean[] visitado = new boolean[v];
        // Novo array para detectar ciclos (nós atualmente na pilha de recursão)
        boolean[] emPilhaRecursiva = new boolean[v]; 
        Stack<Integer> pilha = new Stack<>();
        
        // Variável para sinalizar a existência de ciclo
        boolean temCiclo = false; 

        for (int i = 0; i < v; i++) {
            if (!visitado[i])
                // Chamada modificada para capturar o resultado da DFS
                temCiclo = dfs(g, i, visitado, emPilhaRecursiva, pilha); 
            
            // Se um ciclo for encontrado, interrompe e avisa
            if (temCiclo) {
                System.out.println("TopSort: IMPOSSÍVEL. O grafo contém um ciclo.");
                return;
            }
        }

        System.out.print("TopSort: ");
        // A pilha contém a ordenação topológica válida (inversa da ordem de término da DFS)
        while (!pilha.isEmpty())
            System.out.print(pilha.pop() + " ");
        System.out.println();
    }

    // Retorna true se um ciclo for encontrado
    private static boolean dfs(Grafo g, int v, boolean[] vis, boolean[] emPilha, Stack<Integer> p) {
        vis[v] = true;
        emPilha[v] = true; // Marca que o nó está no caminho atual

        for (Aresta e : g.getAdjacentes(v)) {
            
            // 1. Se o adjacente não foi visitado, chama a recursão
            if (!vis[e.destino]) {
                if (dfs(g, e.destino, vis, emPilha, p))
                    return true; // Propaga a descoberta do ciclo
            } 
            
            // 2. Se o adjacente JÁ ESTÁ na pilha de recursão, encontramos um ciclo!
            else if (emPilha[e.destino]) { 
                return true;
            }
        }
        
        emPilha[v] = false; // Tira o nó da pilha de recursão antes de empilhá-lo na TopSort
        p.push(v); // Empilha o nó (ordem inversa de término da DFS)
        return false; // Nenhum ciclo encontrado a partir deste nó
    }
}