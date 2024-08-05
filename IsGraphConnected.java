import java.util.*;
public class IsGraphConnected {
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
    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph){
        ArrayList<ArrayList<Integer>> allcomps = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];

        for(int vtx=0;vtx<graph.length;vtx++){
            if(!visited[vtx]){
                ArrayList<Integer> comp = new ArrayList<>();
                gccHelper(graph, vtx, comp, visited);
                allcomps.add(comp);
            }
        }
        return allcomps;
    }
    public static void gccHelper(ArrayList<Edge>[] graph, int vtx, ArrayList<Integer> comp, boolean[] visited){
        visited[vtx] = true;
        comp.add(vtx);

        for(Edge e : graph[vtx]){
            if(!visited[e.nbr]){
                gccHelper(graph, e.nbr, comp, visited);
            }
        }
    }
    public static boolean IsGraphConnected(ArrayList<Edge>[] graph){
        return gcc(graph).size()==1;
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
        System.out.println(gcc(graph));
        System.out.println(IsGraphConnected(graph));
    }
}
