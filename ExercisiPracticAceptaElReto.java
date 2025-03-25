/**
 * Fecha inicio:
 * Fecha fin:
 *
 * @author Ignasi Paredes
 */

package exercisipracticaceptaelreto;

import java.util.Scanner;

public class ExercisiPracticAceptaElReto {
    public static void main(String[] args) {
        //Creamos el string donde iremos guardando la salida del programa (los SI y NO)
        String salida = "";
        
        //Leemos la primera línea introducida
        Scanner scanner = new Scanner(System.in);
        
        //En cada iteración, leeremos la primera línea, que contiene la cantidad 
        //de hangares disponibles en una determinada base, mientras no sea 0.
        for (int numeroHangares = scanner.nextInt(); numeroHangares != 0; numeroHangares = scanner.nextInt()) {
            int [] hangares = new int [numeroHangares];
            
            scanner = new Scanner(System.in);
            String lineaCapacidadHangares = scanner.nextLine();
            String [] partesCapacidadHangares = lineaCapacidadHangares.split(" ");
            
            for (int i = 0; i < numeroHangares; i++) {
                hangares[i] = Integer.parseInt(partesCapacidadHangares[i]);
//                System.out.print(hangares[i]+" ");
            }
//            System.out.println("");
            
            //scanner = new Scanner(System.in);
        }
        
//        String numeros [] = numeroHangares.split(" ");
//        
//        int [] hangares = new int [numeros.length];
//        los H numeros con sus tamaños,
//        la cantidad de naves que llegan a la base y seguido de N números con sus tamaños, en este órden.
    }

}
