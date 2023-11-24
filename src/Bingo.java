import java.util.Scanner;

public class Bingo {
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
        int[] numerosAleatorios = new int[99];
        boolean control;
        int cantoLinea = 0;
        int cantoBingo = 0;
        int intentosLinea = 0;
        int intentosBingo = 0;
        int cartonNuevo;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Tu apuesta:");
        int apuesta = teclado.nextInt();

        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Cuantos intentos prevees:");
        int intentos = teclado2.nextInt();

        for (int i = 0; i < carton.length; i++) {
            do {
                control = false;
                cartonNuevo = (int) ((Math.random() * 99) + 1);

                for (int j = 0; j < i; j++) {
                    if (carton[j] == cartonNuevo) {
                        control = true;
                        break;
                    }
                }
            } while (control);

            carton[i] = cartonNuevo;
        }

        // carton

        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = (int) ((Math.random() * 99) + 1);
        }

        for (int i = 0; i < carton.length; i++) {
            control = false;
            do {
                control = false;
                for (int j = 0; j < i; j++) {
                    if (numerosAleatorios[j] == carton[i]) {
                        control = true;
                        break;
                    }
                }

                if (control) {
                    carton[i] = (int) ((Math.random() * 99) + 1);
                }

            } while (control);
        }

        System.out.println("carton");
        for (int i = 0; i < carton.length; i++) {
            System.out.print(carton[i] + "\t");
        }

        for (int i = 0; i < carton.length; i++) {
            carton[i] = (int) ((Math.random() * 99) + 1);
        }

        // sorteo

        for (int e = 0; e < sorteo.length && cantoBingo < 10; e++) {
            control = false;
            do {
                control = false;
                numerosAleatorios[e] = (int) ((Math.random() * 99) + 1);

                for (int x = 0; x < e; x++) {
                    if (numerosAleatorios[x] == numerosAleatorios[e]) {
                        control = true;
                        break;
                    }
                }

            } while (control);

            sorteo[e] = numerosAleatorios[e];

            for (int j = 0; j < carton.length; j++) {
                if (carton[j] == numerosAleatorios[e]) {
                    cantoLinea++;
                    if (cantoLinea == 5) {
                        intentosLinea = e;
                    }
                    cantoBingo++;
                    if (cantoBingo == 10) {
                        intentosBingo = e;
                        break;  // Salir del bucle una vez que se alcanza el bingo
                    }
                }
            }
        }

        System.out.println("\n" + "sorteo");
        for (int e = 0; e < sorteo.length; e++) {
            System.out.print(sorteo[e] + "\t");
        }

        System.out.println();

        System.out.println("intentos linea " + intentosLinea);
        System.out.println("intentos bingo " + intentosBingo);
        if (intentosBingo == intentos) {
            System.out.println("Tu premio es: " + apuesta * 10);
        } else {
            System.out.println("Apuesta no premiada");
        }
    }
}