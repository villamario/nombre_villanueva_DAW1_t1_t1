import java.util.Scanner;

public class Bingo2 {
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
        int[] carton = new int[10];
        int[] sorteo = new int[99];
        int[] NumerosAleatorios = new int[99];
        boolean control;
        int CantoLinea=0;
        int CantoBingo=0;
        int IntentosLinea=0;
        int IntentosBingo=0;
        int CartonNuevo;

        Scanner teclado= new Scanner(System.in);
        System.out.println("Tu apuesta:");
        int apuesta = teclado.nextInt();

        Scanner teclado2= new Scanner(System.in);
        System.out.println("Cuantos intentos prevees:");
        int intentos = teclado2.nextInt();

        for (int i = 0; i < carton.length; i++) {

            do {
                control = false;
                CartonNuevo = (int) ((Math.random() * 20) + 1);

                for (int j = 0; j < i; j++) {
                    if (carton[j] == CartonNuevo) {
                        control = true;
                        break;
                    }
                }
            } while (control);

            carton[i] = CartonNuevo;
        }

        // carton


        for (int i = 0; i < NumerosAleatorios.length; i++) {
            NumerosAleatorios[i] = (int) ((Math.random() * 20) + 1);
        }

        for (int i = 0; i < carton.length; i++) {
            control = false;
            do {
                control = false;
                for (int j = 0; j < i; j++) {
                    if (NumerosAleatorios[j] == carton[i]) {
                        control = true;
                        break;
                    }
                }

                if (control) {
                    carton[i] = (int) ((Math.random() * 20) + 1);
                }

            } while (control);
        }

        System.out.println("carton");
        for (int i = 0; i < carton.length; i++) {
            System.out.print(carton[i]+"\t");
        }

        for (int i = 0; i < carton.length; i++) {
            carton[i] = (int) ((Math.random() * 20) + 1);
        }

//sorteo

        for (int e = 0; e < sorteo.length && CantoBingo < 10; e++) {
            control = false;
            do {
                control = false;
                NumerosAleatorios[e] = (int) ((Math.random() * 99) + 1);

                for (int x = 0; x < e; x++) {
                    if (NumerosAleatorios[x] == NumerosAleatorios[e]) {
                        control = true;
                        break;
                    }
                }

            } while (control);

            sorteo[e] = NumerosAleatorios[e];

            for (int j = 0; j < carton.length; j++) {
                if (carton[j] == NumerosAleatorios[e]) {
                    CantoLinea++;
                    if (CantoLinea == 5) {
                        IntentosLinea = e;
                    }
                    CantoBingo++;
                    if (CantoBingo == 10) {
                        IntentosBingo = e;
                        break;  // Salir del bucle una vez que se alcanza el bingo
                    }
                }
            }
        }



        System.out.println("\n" + "sorteo");
        for (int e = 0; e < sorteo.length; e++) {
            System.out.print (sorteo[e]+"\t");
        }

        System.out.println();

        System.out.println("intentos linea "+IntentosLinea);
        System.out.println("intentos bingo "+IntentosBingo);
        if (IntentosBingo==intentos){
            System.out.println("Tu premio es: " +apuesta*10);
        }else {
            System.out.println("Apuesta no premiada");
        }
    }

}
