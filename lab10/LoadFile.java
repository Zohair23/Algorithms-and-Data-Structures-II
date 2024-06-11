import java.io.*;
import java.util.Scanner;

public class LoadFile {
    public static void main(String[] args) {
        File file = new File("./deliveries.csv");

        String[] addresses = new String[100];
        int[][] distances = new int[100][100];

        try {
            Scanner scan = new Scanner(file);

            for (int i = 0; i < 100; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(","); // Split the line by commas
                addresses[i] = parts[0]; //get the address
                for (int j = 0; j < 100; j++) { //get the distances
                    distances[i][j] = Integer.parseInt(parts[j + 1].trim());
                }
            }
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        int[] route = new int[101]; 
        route[0] = 0; 
        int totalDistance = 0;

        boolean[] visited = new boolean[100];
        visited[0] = true;

        for (int i = 0; i < 100; i++) {
            int currentHouse = route[i];
            int nearestNeighbor = -1;
            int smallest = Integer.MAX_VALUE;

            for (int j = 0; j < 100; j++) {
                if (!visited[j] && distances[currentHouse][j] != 0 && distances[currentHouse][j] < smallest) {
                    smallest = distances[currentHouse][j];
                    nearestNeighbor = j;
                }
            }

            if (nearestNeighbor != -1) {
                route[i + 1] = nearestNeighbor;
                totalDistance += smallest;
                visited[nearestNeighbor] = true;
            }
        }

        
        route[100] = 0;
        totalDistance += distances[route[99]][0];

        System.out.println("Minimum distance traveled: " + totalDistance + " meters.");
        System.out.print("Route: ");
        for (int i = 0; i < 101; i++) {
            System.out.print(addresses[route[i]]);
            if (i < 100) {
                System.out.print(" -> ");
            }
        }
    }
}
