import java.util.*;
public class PrintAllPaths {
    public static class Edge{
        int src, nbr, wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String psf){
        boolean[] visited = new boolean[graph.length];
        allPathHelper(graph, src, visited, dest, ""+src);
    }

    public static void allPathHelper(ArrayList<Edge>[] graph, int vtx, boolean[] visited, int dest, String psf){
        if(vtx==dest){
            System.out.println(psf);
            return;
        }
        visited[vtx] = true;

        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                allPathHelper(graph, e.nbr, visited, dest, psf+e.nbr);
            }
        }
        visited[vtx] = false;
    
        
    }
    public static void main(String[] args){
        
            Scanner sc = new Scanner(System.in);
            int vtces = sc.nextInt();
            int edges = sc.nextInt();
            ArrayList<Edge>[] graph = new ArrayList[vtces];
            for(int i=0;i<vtces;i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0;i<edges;i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int wt = sc.nextInt();
                graph[v1].add(new Edge(v1, v2, wt));
                graph[v2].add(new Edge(v2, v1, wt));
            }
            int src = sc.nextInt();
            int dest = sc.nextInt();
            allPath(graph, src, dest, "");
        }
}
