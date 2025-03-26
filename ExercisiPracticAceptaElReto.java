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
            
            PriorityQueue<Integer> heap = new PriorityQueue<>(numeroHangares,Collections.reverseOrder());
            
            //Obtenemos los H números con sus tamaños dentro de un array
            for (int i = 0; i < numeroHangares; i++) {
                heap.offer(scanner.nextInt());
            }

            //Obtenemos la cantidad de naves que llegan a la base
            int cantidadNaves = scanner.nextInt();
            
            //Obtenemos los tamaños de las naves por orden de llegada            
            int [] tamañoNaves = new int [cantidadNaves];
            for (int i = 0; i < cantidadNaves; i++) {
                tamañoNaves[i] = scanner.nextInt();
            }
            
            ////////////////////////////////////////////////////////////////////
            // Ahora empezamos con el algoritmo heapSort

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