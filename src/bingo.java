import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class bingo {
    /*
    - Utilizar un arrays para guardad los 10 números del carton
    - Utilizar Math.random() para generar los aleatorios
    - Utilizarlas estructuras de control if, do while, swtich para
      poder decidir la partes del programa que se deben ejecutar

    1. Creará un cartón de bingo, el cual está formado por 10 números aleatorios (no
       repetidos entre el 1-99)
    2. Pedirá una cantidad que servirá como aputesta del jugador
    3. Pedirá la cantidad de números que se prevé que en la que se acertará el bingo
    4. Una vez creado el cartón, el sistema irá sacando números aleatorio entre el 1-99
        (no repetidos) hasta que se cante bingo (todos los números han sido acertados)
        Una vez el cartón cante bingo se deberá mostrar la siguiente información
        - Cuantos números han tenido que salir para cantar bingo (acertar todos los
        números del cartón)
        - Cuando números han tenido que salir para cantar línea (acertar 5 números)
        - Si el bingo se ha acertado en el número indicando al principio, deberá mostrarse
        el premio obtenido (apuesta introducida por 10).
        Se valorará el uso de métodos
    */

    public static void main(String[] args) {
        int[] NumerosAleatorios = new int[99];
        int[] carton = new int[10];
        boolean encontrado = false;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Di la cantidad de números que prevees que en la que se acertará el bingo");
        int apuesta = teclado.nextInt();
        for (int i = 0; i < carton.length; i++) {
            carton[i] = (int) (Math.random() * 100);
        }
        System.out.println("Tu cartón");
        for (int ItemCarton : carton) {
            System.out.print("\t" + ItemCarton);

            for (int i = 0; i < NumerosAleatorios.length; i++) {
                NumerosAleatorios[i] = (int) (Math.random() * 100);
                System.out.println("\n Empieza el bingo");

                for (int ItemNumero : NumerosAleatorios) {
                    System.out.print("\t" + ItemNumero);
                }

                if (ItemNumero == ItemCarton) {
                    System.out.println(ItemCarton);
                }
            }
        }




    }
}
