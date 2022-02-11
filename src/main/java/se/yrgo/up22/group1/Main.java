package se.yrgo.up22.group1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InitializedData initializedData = new InitializedData();


        /*
        Damfotboll!
        Välj nedan:
        1.Se alla Landslag (sorterade efter FIFA-ranking)
        2.Se alla Spelare (sorterade efter...)
        3.Se alla Matcher (sorterade efter...)
        4.Se alla Coacher (sortera efter...)


         */
        

        getMenuChoice();


        initializedData.getListOfCountries().stream()
                .sorted()
                .forEach(System.out::println);

    }

    private static int getMenuChoice() {
        try (Scanner scanner = new Scanner(System.in)){
            int result = scanner.nextInt();
            scanner.nextLine();
            return result;
        }
    }
}
