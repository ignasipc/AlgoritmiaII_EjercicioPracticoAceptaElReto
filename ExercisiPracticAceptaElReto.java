/**
 * Fecha inicio:
 * Fecha fin:
 *
 * @author Ignasi Paredes
 */

package exercisipracticaceptaelreto;

import java.util.Collections;
import java.util.PriorityQueue;
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
            
            //Obtenemos los H números con sus tamaños dentro de un array
            String [] partesCapacidadHangares = new Scanner(System.in).nextLine().split(" ");
            
            int [] hangares = new int [numeroHangares];
            for (int i = 0; i < numeroHangares; i++) {
                hangares[i] = Integer.parseInt(partesCapacidadHangares[i]);
            }

            //Obtenemos la cantidad de naves que llegan a la base
            int cantidadNaves = new Scanner(System.in).nextInt();
            
            //Obtenemos los tamaños de las naves por orden de llegada
            String [] partesCantidadNaves = new Scanner(System.in).nextLine().split(" ");
            
            int [] tamañoNaves = new int [cantidadNaves];
            for (int i = 0; i < cantidadNaves; i++) {
                tamañoNaves[i] = Integer.parseInt(partesCantidadNaves[i]);
            }
            
            ////////////////////////////////////////////////////////////////////
            // Ahora empezamos con el algoritmo heapSort
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int num : hangares) { 
                heap.offer(num); 
            }

            String resultadoIteracion = "SI\n";
            //Iteramos en cada nave por orden de llegada comprobando si podemos meterla
            for (int nave : tamañoNaves) {
                if (heap.peek() < nave) {
                    resultadoIteracion = "NO\n";
                    break;
                }
                heap.offer(heap.poll() - nave);
            }
            salida += resultadoIteracion;
        }
        
        System.out.print(salida);
    }
}