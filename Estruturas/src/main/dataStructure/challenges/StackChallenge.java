package main.dataStructure.challenges;

import main.dataStructure.Stack;

// Inverta um conjunto de dados utilizando Pilhas.
public class StackChallenge {
    public static void main(String[] args) {

        int [] numeros = {5,4,3,2,1};
        reverse(numeros);
    }

    private static void reverse(final int[] numeros) {
        Stack stack = new Stack(numeros[0]);

        for (int i = 1; i < numeros.length; i++){
            stack.push(numeros[i]);
        }

        var node = stack.pop();
        while (node != null){
            System.out.println(node.getValue());
            node = stack.pop();
        }
    }
}