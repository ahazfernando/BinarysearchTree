package Node;

public class MorseNode {
    public char lightsignal;
    public String morsecode;
    public MorseNode left_subtree;
    public MorseNode right_subtree;

    public MorseNode(char lightsignal, String morseCode) {
        this.lightsignal = lightsignal;
        this.morsecode = morseCode;
        this.left_subtree = null;
        this.right_subtree = null;
    }
}
