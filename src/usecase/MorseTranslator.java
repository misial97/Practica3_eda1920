package usecase;


import material.Position;
import material.tree.binarytree.LinkedBinaryTree;
import material.tree.iterators.InorderBinaryTreeIterator;

public class MorseTranslator {
    //TODO: Practica 3 Ejercicio 3
    //derecha -
    //izquierda .
    private final char LEFT_DOT = '.';
    private final char RIGHT_DASH = '-';
    private LinkedBinaryTree<String> tree;

    public MorseTranslator(){

        char[] standardCharset = {};
        String[] standardCodes = {};
        treeInitializer(standardCharset, standardCodes);
    }
    /**
     * Generates a new MorseTranslator instance given two arrays:
     * one with the character set and another with their respective
     * morse code.
     *
     * @param charset
     * @param codes
     */
    public MorseTranslator(char[] charset, String[] codes) {
        this.tree = new LinkedBinaryTree<>();
        this.tree.addRoot("start");
        treeInitializer(charset, codes);
    }

    private void treeInitializer(char[] charset, String[] codes){
        Position<String> position;
        int i = 0;
        for(String code: codes){
            position = this.tree.root();
            while(!code.equals("")){
                if (code.charAt(0) == this.LEFT_DOT) {
                    if(code.length()==1){
                        String toInsert = "" + charset[i];
                        if(!this.tree.hasLeft(position))
                            position = this.tree.insertLeft(position, toInsert);
                        else {
                            Position<String> leftChild = this.tree.left(position);
                            this.tree.replace(leftChild, toInsert);
                        }
                    }else {
                        if(!this.tree.hasLeft(position))
                            position = this.tree.insertLeft(position, "");
                        else
                            position = this.tree.left(position);
                    }
                }else if (code.charAt(0) == this.RIGHT_DASH) {
                    if(code.length()==1){
                        String toInsert = "" + charset[i];
                        if(!this.tree.hasRight(position))
                            position = this.tree.insertRight(position, toInsert);
                        else {
                            Position<String> rightChild = this.tree.right(position);
                            this.tree.replace(rightChild, toInsert);
                        }
                    }else {
                        if(!this.tree.hasRight(position))
                            position = this.tree.insertRight(position, "");
                        else
                            position = this.tree.right(position);
                    }
                }
                code = code.substring(1);
            }
            i++;
        }
    }
    /**
     * Decodes a String with a message in morse code and returns
     * another String in plaintext. The input String may contain
     * the characters: ' ', '-' '.'.
     *
     * @param morseMessage
     * @return a plain text translation of the morse code
     */
    public String decode(String morseMessage) {
        throw new RuntimeException("Not yet implemented");
    }


    /**
     * Receives a String with a message in plaintext. This message
     * may contain any character in the charset.
     *
     * @param plainText
     * @return a morse code message
     */
    public String encode(String plainText) {
        throw new RuntimeException("Not yet implemented");
    }

    public void imprime(){
        InorderBinaryTreeIterator<String> it = new InorderBinaryTreeIterator<>(this.tree);
        while(it.hasNext()){
            System.out.println(it.next().getElement());
        }

    }
}
