import java.util.Scanner;

public class BinaryTree
{
    Node root;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the numbers to insert: ");
        String userInput = scan.nextLine();
        System.out.println();
        String [] myStrings = userInput.split(",");
        scan.close();
        

        //convert to int
        int[] myData = new int[myStrings.length];
        for (int i = 0; i < myStrings.length; i++) {

            myData[i] = Integer.parseInt(myStrings[i]);

        }
        
        BinaryTree myTree = new BinaryTree();

        //insert
        for(int j = 0; j < myData.length;j++)
        {
            myTree.insert(myData[j]);
        }
        
        int myOutput = myTree.countLevels(myTree.root);
        System.out.println("This binary tree has: " + myOutput + " levels");
    }

    public void insert(int id)
    {
        Node newNode = new Node(); // make new node
        newNode.data = id; // insert data
        if(root==null){ // no node in root
            root = newNode;
        }else{ // root occupied

            Node current = root; // start at root
            Node parent;
            while(true) { // (exits internally)

                parent = current;
                if(id < current.data) // go left?
                {
                    current = current.leftChild;
                    if(current == null) // if end of the line,
                    { // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.rightChild;
                    if(current == null) // if end of the line
                    { // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                } // end else go right
            } // end while
        } // end else not root
    } // end insert()

    private int countLevels(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = countLevels(node.leftChild);
            int rightDepth = countLevels(node.rightChild);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
       
}