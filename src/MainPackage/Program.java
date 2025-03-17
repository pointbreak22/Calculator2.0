package MainPackage;//import static java.lang.System.*;

import java.util.Scanner;
//import  java.lang.Exception;

public class Program {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку формата \"x + y\" c пробелами между числами");
        ScanString scan = new ScanString(in.nextLine());
        try {
            scan.Method();
        } catch (Exception ex) {
            System.out.println(ex.toString());

        }

    }
}
