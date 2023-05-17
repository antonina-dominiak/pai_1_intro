package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {


        String adresUrl = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";
        // wyslanie requestu
        String response = request();

        // obrobka odpowiedzi
        process(response);
    }

    private static String request() {
        return "";

    }
    private static void process(String response1) {
        System.out.println(response1);
    }
}