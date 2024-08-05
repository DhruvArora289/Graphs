import java.util.*;
public class ShortestPathInWeights {
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
    public static class Pair implements Comparable<Pair>{
        int vtx, wsf;
        String psf;
        Pair(int vtx, String psf, int wsf){
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];
        pq.add(new Pair(src, ""+src, 0));

        while(pq.size()>0){
            Pair tmp = pq.remove();
            if(visited[tmp.vtx] == false){
                visited[tmp.vtx] = true;

                if(tmp.vtx != -1){
                    System.out.println(tmp.vtx + "via" + tmp.psf + "@" +tmp.wsf);
                }

                for(Edge e : graph[tmp.vtx]){
                    if(!visited[e.nbr]){
                        pq.add(new Pair(e.nbr, tmp.psf+e.nbr, tmp.wsf+e.wt));
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
        dijkstra(graph, src);
    }
}
