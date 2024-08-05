import java.util.*;
public class CompilationOrder {
    public static class Edge{
        int src, nbr;
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
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

            graph[v1].add(new Edge(v1, v2));
        }
        boolean[] vis = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for(int vtx = 0;vtx<vtces;vtx++){
            if(!vis[vtx]){
                dfs(graph, vis, vtx, st);
            }
        }
            while(st.size()>0){
                System.out.println(st.pop());
            }
        
    }
    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int src, Stack<Integer> st){
        vis[src] = true;
        for(Edge e:graph[src]){
            if(!vis[e.nbr]){
                dfs(graph, vis, e.nbr, st);
            }
        }
        st.push(src);
    }
}
