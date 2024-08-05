import java.util.*;
public class IsGraphCyclic {
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
    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for(int vtx = 0; vtx < graph.length; vtx++){
            if(!vis[vtx]){
                boolean res = isCyclicHelper(graph, vtx, vis);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCyclicHelper(ArrayList<Edge>[] graph, int vtx, boolean[] vis){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vtx);

        while(queue.size()>0){
            int tvtx = queue.remove();
            if(vis[tvtx] = true){
                return true;
            }else{
                vis[tvtx] = true;
                for(Edge e : graph[vtx]){
                    if(vis[e.nbr] == false){
                        queue.add(e.nbr);
                    }
                }
            }
        }
        return false;
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
        System.out.println(isCyclic(graph));
    }
}
