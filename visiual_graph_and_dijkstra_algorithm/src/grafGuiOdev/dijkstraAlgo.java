package grafGuiOdev;

/*
 * @author Mehmet Efe Bardak
 */
public class dijkstraAlgo {

    int node;
    int[] path;

    public dijkstraAlgo(int node) {
        this.node = node;
    }

    int minDistance(int distance[], Boolean isVisited[]) {
        int smallest = Integer.MAX_VALUE, smallestLocation = -1;

        for (int i = 0; i < node; i++) {
            if (isVisited[i] == false && distance[i] <= smallest) {
                smallest = distance[i];
                smallestLocation = i;
            }
        }
        return smallestLocation;
    }

    public String shortPath(int path[]) {
        String sonuc = "";
        sonuc += ("Node \t Distance from source\n");
        for (int i = 0; i < node; i++) {
            sonuc += (i + " \t " + path[i] + "\n");
        }
        return sonuc;
    }

    public int[][] dijkstra(int[][] graph, int source) {

        int[][] visitedNodes = new int[graph.length][graph.length];
        int distance[] = new int[node];
        Boolean isVisited[] = new Boolean[node];

        for (int i = 0; i < node; i++) {
            distance[i] = Integer.MAX_VALUE;
            isVisited[i] = false;
        }

        distance[source] = 0;

        for (int i = 0; i < node - 1; i++) {

            int current = minDistance(distance, isVisited);
            isVisited[current] = true;
            visitedNodes[source][current] = graph[source][current];

            for (int j = 0; j < node; j++) {
                if (!isVisited[j] && graph[current][j] != 0 && distance[current] != Integer.MAX_VALUE
                        && distance[current] + graph[current][j] < distance[j]) {
                    distance[j] = distance[current] + graph[current][j];
                    visitedNodes[current][j] = graph[current][j];
                }
            }
        }
        this.path = distance;
        return visitedNodes;
    }
}
