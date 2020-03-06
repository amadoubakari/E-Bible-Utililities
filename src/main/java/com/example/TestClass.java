package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMADOU on 3/4/2020.
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.println("AKOUNA MATATA : il y a pas de problème.");

        //separateVersetToRest("11000Hakuna matata");
        extractIntFromString("110 demande", new StringBuilder(), new StringBuilder());
        //List<String> resultat = extractIntFromString("110 demande", new StringBuilder(), new StringBuilder());
        //System.out.println("Extracted text :  " + resultat);
    }

    /**
     * cette fonction prend en entrée une chaine de caractères et retourne un bloc de verset et le reste
     *
     * @param entry
     * @return
     */
    public static List<String> separateVersetToRest(String entry) {
        List<String> blocks = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char c : entry.toCharArray()
                ) {
            if (Character.isDigit(c)) {
                for (char e : entry.substring(1).toCharArray()
                        ) {
                    if (Character.isDigit(e)) {

                    }

                }
                System.out.println("le caractère correspondant est bel et bien un digit:   " + c);
            } else {
                System.out.println("le caractère correspondant n'est pas un digit:   " + c);
            }
        }
        return blocks;
    }


    /**
     * @param originalString
     * @return
     */
    static List<String> extractIntFromString(String originalString, StringBuilder result, StringBuilder restant) {
        //StringBuilder number = new StringBuilder();

        //Compteur de la boucle
        if (originalString.length() < 0) {
            return null;

        } else {
            int index = 0;
            for (char c : originalString.toCharArray()) {
                index++;
                if (Character.isDigit(c)) {
                    result.append(c);
                    originalString = originalString.substring(index);
                    System.out.println("Rest of string :  " + originalString);
                    if (originalString.length() > 0) {
                        extractIntFromString(originalString, result, restant);
                    }
                } else {
                    restant.append(c);
                    originalString = originalString.substring(index);
                    extractIntFromString(originalString, result, restant);
                }
            }
            List<String> stringList = new ArrayList<>();
            stringList.add(result.toString());
            stringList.add(restant.toString());
            return stringList;
        }
    }


}
