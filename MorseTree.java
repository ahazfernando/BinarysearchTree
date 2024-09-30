package Class;

import Node.MorseNode;
import Stack.Stack;

import java.util.HashMap;
import java.util.Map;

public class MorseTree {
    private MorseNode root;
    private Map<String, Character> morse_characterMap;

//It's essenetial that the root node starts with a null value
    public MorseTree() {
        this.root = null;
        this.morse_characterMap = new HashMap<>();
    }

    public void addNode(char lightsignal, String morsecode) {
        MorseNode newNode = new MorseNode(lightsignal, morsecode);
        root = recursive_node(root, newNode);
        morse_characterMap.put(morsecode, lightsignal);
    }

    private MorseNode recursive_node(MorseNode root, MorseNode newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.morsecode.compareTo(root.morsecode) < 0) {
            root.left_subtree = recursive_node(root.left_subtree, newNode);
        } else if (newNode.morsecode.compareTo(root.morsecode) > 0) {
            root.right_subtree = recursive_node(root.right_subtree, newNode);
        }

        return root;
    }

    // Stack-based In Order Traversal method
    public void traversal_InOrderStackImp() {
        Stack stack = new Stack();
        MorseNode current = root;

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.stack_push(current);
                current = current.left_subtree;
            }

            current = stack.stack_pop();
            System.out.println(current.lightsignal + " : " + current.morsecode);

            current = current.right_subtree;
        }
    }

    public String decoded_message(String encodedMessage) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = encodedMessage.split("/");

        for (String word : words) {
            String[] characters = word.trim().split(" ");
            for (String morseChar : characters) {
                decodedMessage.append(morse_characterMap.get(morseChar));
            }
            decodedMessage.append(" ");
        }
        return decodedMessage.toString().trim();
    }

    public String morse_encoding(String message) {
        StringBuilder morseEncodedMessage = new StringBuilder();
        for (char c : message.toUpperCase().toCharArray()) {
            if (c != ' ') {
                morseEncodedMessage.append(morse_characterMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == c)
                        .map(Map.Entry::getKey)
                        .findFirst().orElse("")).append(" ");
            } else {
                morseEncodedMessage.append("/ ");
            }
        }
        return morseEncodedMessage.toString().trim();
    }

    public String encoded_message(String encodedMessage) {
        StringBuilder reversedMessage = new StringBuilder();
        String[] words = encodedMessage.split("/");

        for (String word : words) {
            String[] characters = word.trim().split(" ");
            for (String morseChar : characters) {
                String reversedMorse = new StringBuilder(morseChar).reverse().toString();
                reversedMessage.append(reversedMorse).append(" ");
            }
            reversedMessage.setLength(reversedMessage.length() - 1);
            reversedMessage.append("/");
        }
        reversedMessage.setLength(reversedMessage.length() - 1);
        return reversedMessage.toString();
    }
}
