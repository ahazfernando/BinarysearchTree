import Class.MorseTree;

public class Main {
    public static void main(String[] args) {
        MorseTree morseTree = new MorseTree();

        String[] morsecodelist = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        char[] lightsignals = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // Inserts all characters and their respective Morse codes into the tree
        for (int i = 0; i < morsecodelist.length; i++) {
            morseTree.addNode(lightsignals[i], morsecodelist[i]);
        }

        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Morse Code Dictionary using the Stack-based In-Order Traversal:");
        morseTree.traversal_InOrderStackImp();
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }

        String message = "-- . ..-. ...- --- .-. .--./ . .... -/ . -... ..-. --- .../ - ... .-. .. .-..";

        // The reversed message with the reversed morse code light bursts in morse code
        String encoded_message = morseTree.encoded_message(message);
        System.out.println("\nInitial transmitted Morse Code -> Start " + encoded_message + " End");

        String message_decoded = morseTree.decoded_message(encoded_message);
        System.out.println("Decoded Morse Code (Alphabets/Characters are in reverse order) -> " + message_decoded);

        // The actual message initially transmitted
        String message_received = new StringBuilder(message_decoded).reverse().toString();
        System.out.println("Actual Message transmitted -> " + message_received);

        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        // Display the Morse code of the actual message transmitted
        String actualMorseCode = morseTree.morse_encoding(message_received);
        System.out.println("\nMorse Code of Actual Message transmitted -> Start " + actualMorseCode + " End");
    }
}
