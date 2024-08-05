import java.util.*;
public class MultiSolver {
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
        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf){
        if(src == dest){
            System.out.println(psf + " "+ wsf);
            if(wsf>lpathwt){
                lpathwt = wsf;
                lpath = psf;
            }
            if(wsf<spathwt){
                spathwt = wsf;
                spath = psf;
            }
            if(wsf>criteria){
                if(wsf<cpathwt){
                    cpathwt = wsf;
                    cpath = psf;
                }
            }
            if(wsf<criteria){
                if(wsf>fpathwt){
                    fpathwt = wsf;
                    fpath = psf;
                }
            }
            if(pq.size()<k){
                pq.add(new Pair(wsf,psf));
            }else if(pq.size()==k){
                if(pq.peek().wsf<wsf){
                    pq.remove();
                    pq.add(new Pair(wsf,psf));
                }
            }
            return;
        }
        visited[src] = true;
        for(Edge e:graph[src]){
            if(visited[e.nbr]==false){
                multisolver(graph, e.nbr, dest, visited, criteria, k, psf+e.nbr, wsf+e.wt);
            }
        }
        visited[src] = false;
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
        int dest = sc.nextInt();
        int criteria = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visited = new boolean[graph.length];
        multisolver(graph, src, dest, visited, criteria, k, src+"", 0);
    }
}
