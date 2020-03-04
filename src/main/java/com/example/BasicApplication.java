package com.example;

import java.util.SortedSet;
import java.util.TreeSet;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(new String("") , "UTF-16LE"));
        String in = "10Anja ki so zum buy a wuzla mizli.\n" +
                "Anja gwat ka mawuɗo, a gi a ruwuy\n" +
                "kaɓa naŋ magi a muŋ.\n" +
                "11Vula ndra ɗaf, ndra misi ti may naŋ dana.\n" +
                "12Pula gwat malambaˀ ndra migaka, kaɓa ndra mupulaka ngi mizli migam ndra di na ya.\n" +
                "13Ki pula ndra i cam ar li ngi tikin ta, amma laha ndra tisi haŋ ngi Satana.\n" +
                "[Asi Zumabuy, gidaŋ ati dudok i ngi ɗik hã ngi sete. Amin. .» ] 14«Naŋ kine, da ki ra pulaka gwat malambaˀ ngi mizli magukum di na, naɓa Cine kum misi a muŋ a sa pulukum di ya. 15Amma da kum anta ki pulaka gwat malambaˀ ngi mizli magukum di ta na, naɓa Cine kum anta sa pulukum di ta ya.";

        String s = "1a2b";
        char[] cs = s.toCharArray();
        SortedSet<Verset> versets = new TreeSet<>();

        Gson gson = new Gson();
        // convert your list to json
        String jsonCartList = gson.toJson(versetHandle(in, versets));
        // print your generated json
        System.out.println("***********   versets: " + jsonCartList);
        /*
        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                Verset v = new Verset();
                v.setNumero(Character.getNumericValue(cs[i]));
                StringBuilder desc = new StringBuilder();
                for (int j = i + 1; j < cs.length; j++) {
                    if (!Character.isDigit(cs[j])) {
                        desc.append(cs[j]);
                        v.setDescription(desc.toString());
                        versets.add(v);
                    } else {

                    }

                }

            } else {
                //
            }
        }

        versets.forEach((t) -> {
            System.out.println("----------------    Verset :" + t);
        });*/


        // create a new Gson instance
        //Gson gson = new Gson();
        // convert your list to json
        //String jsonCartList = gson.toJson();
        // print your generated json
        //System.out.println("jsonCartList: " + jsonCartList);

    }

    static SortedSet<Verset> versetHandle(String message, SortedSet<Verset> versets) {
        System.out.println("********************** msg : " + message);
        //Nous testons s'il y a au moins un élément dans la chaine avant de faire quoi que ce soit
        if (message.length() > 0) {
            //Initialisation du compteur
            int index = 0;
            //Nous commencons à parcourir la chaine de charactères
            for (char c : message.toCharArray()) {
                //Nous testons si le caractère courant est un entier
                if (Character.isDigit(c)) {
                    //Nous avancons avec l'index
                    index++;

                    //Tant que l'élément suivant est un entier, on l'ajout à la chaine contenant les entiers
                    // while ()
                    //Si tel est le cas, nous créeons un verset que nous allons remplir au fur et à mesures
                    Verset verset = new Verset();
                    //Nous commencons pas ajouter le numéro du verset
                    verset.setNumero(Character.getNumericValue(c));
                    //la chaine qui est supposé contenir le reste de charactères
                    StringBuilder desc = new StringBuilder();
                    //Maintenant cherchons à récupérer la chaine restante
                    String msg = message.substring(index);
                    for (char c1 : msg.toCharArray()) {
                        //Nous faisons encore avancer notre index
                        index++;
                        //Si le caratère en cours est une lettre
                        if (!Character.isDigit(c1)) {
                            desc.append(c1);
                            verset.setDescription(desc.toString());
                            versets.add(verset);
                        } else {
                            String newChain = msg.substring(index - 2);
                            versetHandle(newChain, versets);
                        }
                    }


                } else {
                    //System.out.println("**************  non digit : " + c);
                }
            }

        }
        Gson gson = new Gson();
        // convert your list to json
        String jsonCartList = gson.toJson(versets);
        // print your generated json
        System.out.println("jsonCartList: " + jsonCartList);
        //System.out.println("**************  versets : " + versets);
        return versets;
    }

}
