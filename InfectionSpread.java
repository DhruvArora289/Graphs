import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;
public class InfectionSpread {
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
    public static class ISPair{
        int vtx;
        int time;
        ISPair(int vtx, int time){
            this.vtx = vtx;
            this.time = time;
        }
    }
    public static int IsInfected(ArrayList<Edge>[] graph, int src, int t){
        boolean visited[] = new boolean[graph.length];
        return bfsHelper(graph, src, t, visited);

    }
    public static int bfsHelper(ArrayList<Edge>[] graph, int src, int t, boolean[] visited){
        Queue<ISPair> queue = new ArrayDeque<>();
        queue.add(new ISPair(src, 1));
        int count = 0;

        while(queue.size()>0){
            ISPair rem = queue.remove();

            if(visited[rem.vtx]){
                continue;
            }

            visited[rem.vtx] = true;
            if(rem.time>t){
                break;
            }
            count++;

            for(Edge e: graph[rem.vtx]){
                if(!visited[e.nbr]){
                    queue.add(new ISPair(e.nbr, rem.time+1));
                }
            }
        }
        return count;

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
        int time = sc.nextInt();
        System.out.println(IsInfected(graph, src, time));
    }
}
