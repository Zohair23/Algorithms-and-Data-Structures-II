import java.io.*;
import java.util.Scanner;

public class LoadFile2 {
    public static void main(String[] args) {
        File file = new File("./deliveries.csv");

        String[] addresses = new String[100];
        int[][] distances = new int[100][100];

        try {
            Scanner scan = new Scanner(file);

            for (int i = 0; i < 100; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                addresses[i] = parts[0];
                for (int j = 0; j < 100; j++) {
                    distances[i][j] = Integer.parseInt(parts[j + 1].trim());
                }
            }
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        int minDistance = Integer.MAX_VALUE;
        int[] minRoute = new int[100];

        for (int startHouse = 0; startHouse < 100; startHouse++) {
            boolean[] visited = new boolean[100];
            int[] route = new int[101];
            route[0] = startHouse;
            visited[startHouse] = true;
            int totalDistance = 0;
            for (int i = 0; i < 99; i++) {
                int currentHouse = route[i];
                int nearestNeighbor = -1;
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < 100; j++) {
                    if (!visited[j] && distances[currentHouse][j] < minDist) {
                        nearestNeighbor = j;
                        minDist = distances[currentHouse][j];
                    }
                }
                route[i + 1] = nearestNeighbor;
                visited[nearestNeighbor] = true;
                totalDistance += minDist;
            }
            route[100] = startHouse;
            totalDistance += distances[route[99]][startHouse];
            if (totalDistance < minDistance) {
                minDistance = totalDistance;
                minRoute = route.clone();
            }
        }

        System.out.println("Minimum distance traveled: " + minDistance + " meters.");
        System.out.print("Route: ");
        for (int i = 0; i < minRoute.length; i++) {
            System.out.print(addresses[minRoute[i]]);
            if (i < minRoute.length - 1) {
                System.out.print(" -> ");
            }
        }
    }
}
