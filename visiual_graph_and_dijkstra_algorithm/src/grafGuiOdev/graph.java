package grafGuiOdev;

/*
 * @author Mehmet Efe Bardak
 */
class node {

    int contents;

    public node(int contents) {
        this.contents = contents;
    }
}

public class graph {

    int[][] adjacencyMatrix;
    int nodeCount;
    int[][] shortPath;

    public graph(int nodeCount) {
        this.nodeCount = nodeCount;
        adjacencyMatrix = new int[nodeCount][nodeCount];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    void kenarEkle(int startNode, int finishNode, int weight) {
        adjacencyMatrix[startNode][finishNode] = weight;
        adjacencyMatrix[finishNode][startNode]= weight;
    }

    String showEdge() {
        String adjacency = "         ";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacency += i + "  |  ";
        }
        adjacency += "\n         ";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacency += "-----";
        }
        adjacency += "\n";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacency += String.valueOf(i) + " ->  ";
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (j == adjacencyMatrix[i].length - 1) {
                    adjacency += adjacencyMatrix[i][j];
                    continue;
                }
                adjacency += adjacencyMatrix[i][j] + "  ,  ";
            }
            adjacency += "\n";
        }
        return adjacency;
    }
}
