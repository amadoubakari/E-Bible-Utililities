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
        String in = "1«Gwat kum magaka ar sipi jiviɗ kumo, jam lesl, anja ki gaka a mihiri mizli ɓa a purukum ta. Da kanah na, naɓa Cine kum misi a muŋ anta sa wurkukum ta. 2Mizli miɓi mi cuw cuwoyo, a vulaka gwat da misi murgahaya ar hay ngi dira dibiɗey, yo a jiviɗ madiɗahay, a tilam di mi ɓa mizli a gaka taŋ dudoko. Gisiŋ, yi ɓukum na: taŋ a lumaka migir taŋ le si. Amma ka, da ki ra vul gwat da misi murgahay na, anja ki gi ka taŋ na ta. 3Da ka, ki ra vul gwat da misi murgahay na, gwat haŋ vay hazum ɗik maga na, anja haŋ gula ɗik a si na ta. 4Anja gwat ɗik ka mavula a ndir i gwat miyaŋŋa, ɓa Cine ɗik mapur ar li miyaŋŋa na, a sa wurkuw minjeˀe.";
        SortedSet<Verset> versets = new TreeSet<>();
        Gson gson = new Gson();
        // convert your list to json
        String jsonCartList = gson.toJson(versetHandle(in, versets));
        // print your generated json
        System.out.println("***********   versets: " + jsonCartList);
    }

    /**
     *
     * @param message
     * @param versets
     * @return
     */
    static SortedSet<Verset> versetHandle(String message, SortedSet<Verset> versets) {
        //Nous testons s'il y a au moins un élément dans la chaine avant de faire quoi que ce soit
        if (message.length() > 0) {
            //Le numéro qui pourra contenir le numéro du verset
            String versetNumber = "";
            StringBuilder versetContent = new StringBuilder();
            //Tant qu'il y a des chiffres, je les extrait
            while (Character.isDigit(message.charAt(0))) {
                versetNumber = versetNumber + message.charAt(0);
                message = message.substring(1);
            }

            //Tant que les caratères ne sont plus de digits alors la longue chaine de caractères va constituer le verset
            while (message.length()>0 && !Character.isDigit(message.charAt(0))) {
                versetContent.append(message.charAt(0));
                message = message.substring(1);
            }

            versets.add(new Verset(Integer.parseInt(versetNumber), versetContent.toString()));

            //S'il y a encore un élément, je refais la routine
            if (message.length() > 0) {
                versetHandle(message, versets);
            }

        }
        return versets;
    }

}
