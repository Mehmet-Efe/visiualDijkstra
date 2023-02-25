package grafGuiOdev;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @author Mehmet Efe Bardak
 */
public class draw extends JPanel {

    int nodeCount, queueNode = 0, degree;
    int[] location = new int[2];
    int[][] adjacencyMatrix;
    String name;

    public draw(int nodeCount, int[][] komMatris,String name) {
        this.nodeCount = nodeCount;
        this.degree = 360 / nodeCount;
        this.adjacencyMatrix = komMatris;
        this.name=name;
        init();
    }

    public void paintComponent(Graphics g) {

        //Center point of circle of nodes x=265, y= 250;
        
        queueNode = 0;
        super.paintComponent(g);
        this.setBackground(Color.black);
        g.setColor(Color.white);
        for (int i = 0; i < nodeCount; i++) {
            location = calculate();
            g.drawOval(location[0], location[1], 50, 50);
            g.setColor(Color.yellow);
            g.drawString(String.valueOf(i), location[0] + 22, location[1] + 30);
            g.setColor(Color.white);
            queueNode++;
        }

        location = new int[4];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    location = drawLine(i, j);
                    g.drawLine(location[0], location[1], location[2], location[3]);
                    g.setColor(Color.red);
                    g.drawString(String.valueOf(adjacencyMatrix[i][j]), (location[0] + location[2]) / 2, (location[1] + location[3]) / 2);
                    g.setColor(Color.white);
                }
            }
        }
    }

    private int[] drawLine(int first, int last) {
        int coordinates[] = new int[4];
        double radFirst = Math.toRadians(degree * first);
        double radLast = Math.toRadians(degree * last);
        if (0 <= degree * first && degree * first < 90) {
            coordinates[0] = 265 - (int) (185 * Math.cos(radFirst));
            coordinates[1] = 250 - (int) (185 * Math.sin(radFirst));
        } else if (90 <= degree * first && degree * first < 180) {
            radFirst %= 90;
            coordinates[0] = 265 - (int) (185 * Math.cos(radFirst));
            coordinates[1] = 250 - (int) (185 * Math.sin(radFirst));
        } else if (180 <= degree * first && degree * first < 270) {
            radFirst %= 90;
            coordinates[0] = 265 - (int) (185 * Math.cos(radFirst));
            coordinates[1] = 250 - (int) (185 * Math.sin(radFirst));
        } else if (270 <= degree * first && degree * first < 360) {
            radFirst %= 90;
            coordinates[0] = 265 - (int) (185 * Math.cos(radFirst));
            coordinates[1] = 250 - (int) (185 * Math.sin(radFirst));
        }

        if (0 <= degree * last && degree * last < 90) {
            coordinates[2] = 265 - (int) (185 * Math.cos(radLast));
            coordinates[3] = 250 - (int) (185 * Math.sin(radLast));
        } else if (90 <= degree * last && degree * last < 180) {
            radLast %= 90;
            coordinates[2] = 265 - (int) (185 * Math.cos(radLast));
            coordinates[3] = 250 - (int) (185 * Math.sin(radLast));
        } else if (180 <= degree * last && degree * last < 270) {
            radLast %= 90;
            coordinates[2] = 265 - (int) (185 * Math.cos(radLast));
            coordinates[3] = 250 - (int) (185 * Math.sin(radLast));
        } else if (270 <= degree * last && degree * last < 360) {
            radLast %= 90;
            coordinates[2] = 265 - (int) (185 * Math.cos(radLast));
            coordinates[3] = 250 - (int) (185 * Math.sin(radLast));
        }

        return coordinates;
    }

    private int[] calculate() {
        int coordinates[] = {0, 0};
        if (0 <= degree * queueNode && degree * queueNode < 90) {
            double rad = Math.toRadians(queueNode * degree);
            coordinates[0] = 240 - (int) (210 * Math.cos(rad));
            coordinates[1] = 225 - (int) (210 * Math.sin(rad));
        } else if (90 <= degree * queueNode && degree * queueNode < 180) {
            double rad = Math.toRadians((queueNode * degree) % 90);
            coordinates[0] = 240 + (int) (210 * Math.sin(rad));
            coordinates[1] = 225 - (int) (210 * Math.cos(rad));
        } else if (180 <= degree * queueNode && degree * queueNode < 270) {
            double rad = Math.toRadians(queueNode * degree % 90);
            coordinates[0] = 240 + (int) (210 * Math.cos(rad));
            coordinates[1] = 225 + (int) (210 * Math.sin(rad));
        } else if (270 <= degree * queueNode && degree * queueNode < 360) {
            double rad = Math.toRadians((queueNode * degree) % 90);
            coordinates[0] = 240 - (int) (210 * Math.sin(rad));
            coordinates[1] = 225 + (int) (210 * Math.cos(rad));
        }

        return coordinates;
    }

    private void init() {
        JFrame f = new JFrame();
        f.setSize(537, 580);
        f.setResizable(false);
        f.setVisible(true);
        f.add(this);
        f.setLocationRelativeTo(null);
        f.setTitle(name);
    }

}
