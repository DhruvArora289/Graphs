import java.util.*;
public class HasPath {
    public static class Edge{
        int src, nbr, wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void display(ArrayList<Edge>[] graph){
        int vtces = graph.length;
        for(int i=0;i<vtces;i++){
            ArrayList<Edge> list = graph[i];
            System.out.print(i+"-->");
            for(Edge e:list){
                System.out.print(e.nbr+" ");
            }
            System.out.println();
        }
    }
    public static boolean haspath(ArrayList<Edge>[] graph, int src, int dest){
        boolean[] visited = new boolean[graph.length];
        return haspathHelper(graph,src,visited,dest);
    }
    public static boolean haspathHelper(ArrayList<Edge>[] graph, int vtx, boolean[] visited, int dest){
        if(vtx==dest){
            return true;
        }

        visited[vtx] = true;

        for(Edge e:graph[vtx]){
            if(visited[e.nbr]==false){
                boolean res = haspathHelper(graph, e.nbr, visited, dest);
            
            if(res){
                return true;
            }
        }
        }
        return false;
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
        System.out.println(haspath(graph, src, dest));
    }
}
