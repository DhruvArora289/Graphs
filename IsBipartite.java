import java.util.*;
public class IsBipartite {
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
    public static class IsBipartitePair{
        int vtx, level;
        IsBipartitePair(int vtx, int level){
            this.vtx = vtx;
            this.level = level;
        }
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int visited[] = new int[graph.length];
        Arrays.fill(visited, -1);
        for(int vtx = 0; vtx < graph.length; vtx++){
            if(visited[vtx] == -1){
                boolean res = isBipartiteHelper(graph, vtx, visited);
                if(!res){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartiteHelper(ArrayList<Edge>[] graph, int vtx, int[] visited){
        Queue<IsBipartitePair> queue = new ArrayDeque<>();
        queue.add(new IsBipartitePair(vtx, 0));

        while(queue.size()>0){
            IsBipartitePair pair = queue.remove();

            if(visited[pair.vtx] == -1){
                visited[pair.vtx] = pair.level;

                for(Edge e:graph[pair.vtx]){
                    if(visited[e.nbr] == -1){
                        queue.add(new IsBipartitePair(e.nbr, pair.level+1));
                    }
                }
            }else{
                if(pair.level != visited[pair.vtx]){
                    return false;
                }
            }
        }
        return true;
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
        System.out.println(isBipartite(graph));
    }
}
