import java.util.*;
public class HamiltonianPathAndCycle {
    public static class Edge{
        int src, nbr, wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void hamiltonian(ArrayList<Edge>[] graph, int vtx, String psf, boolean[] visited, int vsf, int osrc){
        visited[vtx] = true;

        if(vsf == graph.length){
            boolean directEdge = false;
            for(Edge e : graph[vtx]){
                if(e.nbr == osrc){
                    directEdge = true;
                    break;
                }
            }
            if(directEdge){
                //hcycle
                System.out.println(psf+"*");
            }else{
                //hpath
                System.out.println(psf+".");
            }
        }

        for(Edge e : graph[vtx]){
            if(!visited[e.nbr]){
                hamiltonian(graph, e.nbr, psf+e.nbr, visited, vsf+1, osrc);
            }
        }
        visited[vtx] = false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vtces = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i=0;i<vtces;i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<edges;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w1 = sc.nextInt();

            graph[v1].add(new Edge(v1, v2, w1));
            graph[v2].add(new Edge(v2, v1, w1));
        }
        int src = sc.nextInt();

        hamiltonian(graph, src, ""+src, new boolean[vtces], 1, src);
    }
}
