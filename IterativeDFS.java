import java.util.*;
public class IterativeDFS {
    public static class DFSPair{
        int vtx;
        String psf;
        DFSPair(int vtx, String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static class Edge{
        int src, nbr, wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void dfsIter(ArrayList<Edge>[] graph, int src){
        Stack<DFSPair> st = new Stack<>();
        st.push(new DFSPair(src, src+""));
        boolean visited[] = new boolean[graph.length];
        while(st.size()>0){
            DFSPair tpair = st.pop();

            if(visited[tpair.vtx]==false){
                visited[tpair.vtx]=true;

                System.out.println(tpair.vtx+"@"+tpair.psf);

                for(Edge e : graph[tpair.vtx]){
                    if(visited[e.nbr]==false){
                        st.push(new DFSPair(e.nbr, tpair.psf+e.nbr));
                    }
                }
            }
        }
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
        dfsIter(graph, src);
    }
}
