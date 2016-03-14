package homework08.question02;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bhanu on 13/03/2016.
 */
public class Test {

    /**
     * Print test red black node.
     *
     * @return the red black node
     */
    public static RedBlackNode printTest() {
        RedBlackNode root = new RedBlackNode(11);
        root.color = RedBlackNode.Color.BLACK;

        RedBlackNode n21 = new RedBlackNode(2);
        n21.color = RedBlackNode.Color.RED;
        n21.parent = root;

        RedBlackNode n22 = new RedBlackNode(14);
        n22.color = RedBlackNode.Color.BLACK;
        n22.parent = root;

        RedBlackNode n31 = new RedBlackNode(1);
        n31.color = RedBlackNode.Color.BLACK;
        n31.parent = n21;

        RedBlackNode n32 = new RedBlackNode(7);
        n32.color = RedBlackNode.Color.BLACK;
        n32.parent = n21;

        RedBlackNode n33 = new RedBlackNode(15);
        n33.color = RedBlackNode.Color.RED;
        n33.parent = n22;

        RedBlackNode n41 = new RedBlackNode(5);
        n41.color = RedBlackNode.Color.RED;
        n41.parent = n32;

        RedBlackNode n42 = new RedBlackNode(8);
        n42.color = RedBlackNode.Color.RED;
        n42.parent = n32;

        root.left = n21;
        root.right = n22;
        n21.left = n31;
        n21.right = n32;
        n22.right = n33;
        n32.left = n41;
        n32.right = n42;
        return root;
    }

    /**
     * Insert test red black node.
     *
     * @return the red black node
     */
    public static RedBlackTree createTree() {

        RedBlackTree tree = new RedBlackTree();
        tree.insert(11);
        tree.insert(2);
        tree.insert(14);
        tree.insert(1);
        tree.insert(7);
//        tree.insert(15);
//        tree.insert(5);
//        tree.insert(8);

        return tree;
    }

    /**
     * Gets input.
     *
     * @param inputFileLoc the input file loc
     * @return the input
     */
    public static List<String> getInput(String inputFileLoc) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileLoc))) {
            String sCurrentLine = null;
            while ((sCurrentLine = br.readLine()) != null) {
                stringList.addAll(Arrays.asList(sCurrentLine.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


    /**
     * Interactive test.
     */
    public static void interactiveTest(String inputFile) {
        List<String> input = getInput(inputFile);

        RedBlackTree rbt = null;

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Welcome to RTB Operations. Available commands are:");
        System.out.println("1. 'INSERT' ");
        System.out.println("2. 'PRINT' ");
        System.out.println("3. 'ROTATE_RIGHT' ");
        System.out.println("4. 'ROTATE_LEFT' ");
        System.out.println("5. 'SEARCH_<key value>' ");
        System.out.println("6. 'MIN_<key value>' ");
        System.out.println("7. 'MAX_<key value>' ");
        System.out.println("8. 'SUCCESSOR_<key value>' ");
        System.out.println("9. 'PREDECESSOR_<key value>' ");
        System.out.println("10. 'EXIT' ");
        String userInput = "start";
        while (!StringUtils.equalsIgnoreCase(userInput, "EXIT")) {
            userInput = reader.nextLine(); // Scans the next token of the input as an int.
            if (StringUtils.equalsIgnoreCase(userInput, "INSERT")) {
                System.out.println("Executing INSERT OPERATION");
                if (input != null && !input.isEmpty()) {
                    rbt = new RedBlackTree();
                    for (String s : input) {
                        rbt.insert(Integer.parseInt(s));
                        RBTreePrinter.printRBTree(rbt.root);
                    }
                } else {
                    System.out.println("Please provide input file.");
                }

            } else if (StringUtils.equalsIgnoreCase(userInput, "PRINT")) {
                System.out.println("Executing PRINT OPERATION");
                if (rbt != null) {
                    RBTreePrinter.printRBTree(rbt.root);
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.equalsIgnoreCase(userInput, "ROTATE_RIGHT")) {
                System.out.println("Executing ROTATE_RIGHT OPERATION");
                if (rbt != null) {
                    rbt.rotateRight(rbt.root);
                    RBTreePrinter.printRBTree(rbt.root);
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.equalsIgnoreCase(userInput, "ROTATE_LEFT")) {
                System.out.println("Executing ROTATE_LEFT OPERATION");
                if (rbt != null) {
                    rbt.rotateLeft(rbt.root);
                    RBTreePrinter.printRBTree(rbt.root);
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.startsWith(StringUtils.upperCase(userInput), "SEARCH")) {
                System.out.println("Executing SEARCH OPERATION");
                if (rbt != null) {
                    String key = userInput.split("_")[1];
                    RBTreePrinter.printRBTree(rbt.search(Integer.parseInt(key)));
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.startsWith(StringUtils.upperCase(userInput), "MIN")) {
                System.out.println("Executing MIN OPERATION");
                if (rbt != null) {
                    String key = userInput.split("_")[1];
                    RedBlackNode node = rbt.search(Integer.parseInt(key));
                    RBTreePrinter.printRBTree(rbt.min(node));
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.startsWith(StringUtils.upperCase(userInput), "MAX")) {
                System.out.println("Executing MAX OPERATION");
                if (rbt != null) {
                    String key = userInput.split("_")[1];
                    RedBlackNode node = rbt.search(Integer.parseInt(key));
                    RBTreePrinter.printRBTree(rbt.max(node));
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.startsWith(StringUtils.upperCase(userInput), "SUCCESSOR")) {
                System.out.println("Executing SUCCESSOR OPERATION");
                if (rbt != null) {
                    String key = userInput.split("_")[1];
                    RedBlackNode node = rbt.search(Integer.parseInt(key));
                    RBTreePrinter.printRBTree(rbt.successor(node));
                } else {
                    System.out.println("Please create RBT using insert.");
                }
            } else if (StringUtils.startsWith(StringUtils.upperCase(userInput), "PREDECESSOR")) {
                if (rbt != null) {
                    String key = userInput.split("_")[1];
                    RedBlackNode node = rbt.search(Integer.parseInt(key));
                    RBTreePrinter.printRBTree(rbt.predecessor(node));
                } else {
                    System.out.println("Please create RBT using insert.");
                }
                System.out.println("Executing PREDECESSOR OPERATION");
            } else {
                System.out.println("Command Not Recognised. Try again or type 'Exit' to finish.");
            }
        }
    }

    /**
     * Custom test.
     */
    public static void customTest() {

        RedBlackTree rbt = createTree();
        RBTreePrinter.printRBTree(rbt.root);
//        RBTreePrinter.printRBTree(rbt.root);
        RBTreePrinter.printRBTree(rbt.search(2));
//        RBTreePrinter.printRBTree(rbt.min(rbt.root));
//        RBTreePrinter.printRBTree(rbt.max(rbt.root));
//        RBTreePrinter.printRBTree(rbt.successor(rbt.root));
//        RBTreePrinter.printRBTree(rbt.predecessor(rbt.root));


    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Bhanu\\IdeaProjects\\CS5800-Algorithms\\PA\\" +
                "src\\homework08\\question02\\input\\test_input.txt";
        interactiveTest(inputFile);
//        customTest();

    }
}
