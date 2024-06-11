import java.util.*;

public class HuffmanCoding {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Part I: Read in a piece of text from the user and count letter frequencies
        System.out.print("Enter your sentence: ");
        String input = scanner.nextLine();
        int[] frequencyArray = new int[27]; // Including space; Assuming only lowercase letters and space
        
        // Count letter frequencies
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c) || c == ' ') {
                if (c == ' ') {
                    frequencyArray[26]++; // Increment space frequency
                } else {
                    frequencyArray[c - 'a']++; // Increment character frequency
                }
            }
        }
        
        // Print out the letter frequencies
        System.out.println("Letter frequencies:");
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                char letter = (i == 26) ? ' ' : (char) ('a' + i);
                System.out.printf("'%c' has a frequency of %d%n", letter, frequencyArray[i]);
            }
        }
        
        // Part II: Create a new Binary Tree for each letter and add them into a Priority Queue
        PriorityQueue<Tree> priorityQueue = createPriorityQueue(frequencyArray);
        
        // Keep combining the trees until only one is left
        while (priorityQueue.size() > 1) {
            Tree tree1 = priorityQueue.poll();
            Tree tree2 = priorityQueue.poll();
            Tree mergedTree = new Tree(tree1, tree2);
            priorityQueue.add(mergedTree);
        }
        
        // The last tree in the priority queue is the Huffman tree
        Tree huffmanTree = priorityQueue.poll();
        System.out.println("Huffman tree built successfully!");
        
        // Part III: Derive the Huffman encoding for the piece of text using the Huffman tree
        System.out.println("Huffman encoding:");
        generateHuffmanEncoding(huffmanTree.root, "", new StringBuilder());
    }
    
    // Helper method to create a priority queue of trees for each letter
    private static PriorityQueue<Tree> createPriorityQueue(int[] frequencyArray) {
        PriorityQueue<Tree> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                char letter = (i == 26) ? ' ' : (char) ('a' + i);
                Tree tree = new Tree(letter, frequencyArray[i]);
                priorityQueue.add(tree);
            }
        }
        return priorityQueue;
    }
    
    // Helper method to generate Huffman encoding for each letter in the Huffman tree
    private static void generateHuffmanEncoding(Node node, String encoding, StringBuilder sb) {
        if (node.leftChild == null && node.rightChild == null) {
            System.out.println("'" + node.letter + "' : " + sb.toString());
        } else {
            generateHuffmanEncoding(node.leftChild, encoding + "0", new StringBuilder(sb).append("0"));
            generateHuffmanEncoding(node.rightChild, encoding + "1", new StringBuilder(sb).append("1"));
        }
    }
}

// Tree and Node classes
class Tree implements Comparable<Tree> {
    public Node root;
    public int frequency;

    public Tree(char letter, int frequency) {
        this.root = new Node(letter);
        this.frequency = frequency;
    }

    public Tree(Tree left, Tree right) {
        this.root = new Node();
        this.root.leftChild = left.root;
        this.root.rightChild = right.root;
        this.frequency = left.frequency + right.frequency;
    }

    public int compareTo(Tree object) {
        return this.frequency - object.frequency;
    }
}

class Node {
    public char letter;
    public Node leftChild;
    public Node rightChild;

    public Node() {}

    public Node(char letter) {
        this.letter = letter;
    }
}
