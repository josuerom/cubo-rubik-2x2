package interfaz;

import gfutria.SearchStateSpaces;
import java.util.ArrayList;
import mundo.Rubik;

public class InterfazApp {

    public static void main(String[] args) {
        Rubik rubik = new Rubik();
        ArrayList<String> lst;
        SearchStateSpaces sss;

        System.out.println("--| Cubo Rubik 2x2 :: S3Lib.jar :: @josuerom |--\n");

        rubik.h1();
        rubik.v1();
        rubik.v1();

        sss = new SearchStateSpaces("WWWWRRBBOOGGRRBBOOGGYYYY", rubik, 6); 
        lst = sss.solve();

        if (!lst.isEmpty()) {
            for (int i = 0; i < lst.size() - 1; i++) {
                printAction(lst.get(i));
                System.out.print("-");
            }
            printAction(lst.get(lst.size() - 1));
        } else System.out.println("No se encontró solución.");
        System.out.println("\nNúmero de pasos: " + lst.size());
    }

    private static void printAction(String action) {
        switch (action.substring(0, 2)) {
            case "A1" -> System.out.print("H0");
            case "A2" -> System.out.print("H1");
            case "A3" -> System.out.print("V0");
            case "A4" -> System.out.print("V1");
            case "A5" -> System.out.print("T0");
            case "A6" -> System.out.print("T1");
            default -> System.out.print("Acción desconocida");
        }
    }
}