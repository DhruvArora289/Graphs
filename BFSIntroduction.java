import java.util.*;
public class BFSIntroduction {
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
            System.out.print(i+" --> ");
            for(Edge e:list){
                System.out.print(e.nbr+" ");
            }
            System.out.println();
        }
    }
    public static class BFSPair{
        int vtx;
        String psf;
        BFSPair(int vtx, String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void BFS(ArrayList<Edge>[] graph, int vtx){
        Queue<BFSPair> queue = new ArrayDeque<>();
        queue.add(new BFSPair(vtx, vtx+""));
        boolean[] visited = new boolean[graph.length];

        while(queue.size()>0){
            BFSPair pair = queue.remove();
            if(!visited[pair.vtx]){
                visited[pair.vtx] = true;

                System.out.println(pair.vtx + "@" + pair.psf);

                for(Edge e : graph[pair.vtx]){
                    if(!visited[e.nbr]){
                        queue.add(new BFSPair(e.nbr, pair.psf + e.nbr));
                    }
                }
            }
        }
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
        BFS(graph, src);
    }
}
