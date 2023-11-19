import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class bingo {
    public static void main(String[] args) {

        int numero = 20;

        if (numero > 100) {

            for (int i = numero++; i < numero + 20; i++) {
                System.out.println(i);
                i += 1;

            }

        } else {
            for (int j = numero++; j < numero+10; j++) {
                System.out.println(j);

           /* for ( int j = numero2; j < numero+10 ;j--) {
                System.out.println(j);

            }*/
            }
        }
    }
}


