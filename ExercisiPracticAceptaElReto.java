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
        
        //Mientras no sea 0, en cada iteración, leeremos las siguientes 3 líneas que contendrán la 
        for (int numeroHangares = scanner.nextInt(); numeroHangares != 0; numeroHangares = scanner.nextInt()) {
            int [] hangares = new int [numeroHangares];
            
            scanner = new Scanner(System.in);
            String lineaCapacidadHangares = scanner.nextLine();
            String [] partesCapacidadHangares = lineaCapacidadHangares.split(" ");
            
            for (int i = 0; i < numeroHangares; i++) {
                hangares[i] = Integer.parseInt(partesCapacidadHangares[i]);
                System.out.print(hangares[i]+" ");
            }
            System.out.println("");
            
            //scanner = new Scanner(System.in);
        }
        
//        String numeros [] = numeroHangares.split(" ");
//        
//        int [] hangares = new int [numeros.length];
    }

}
