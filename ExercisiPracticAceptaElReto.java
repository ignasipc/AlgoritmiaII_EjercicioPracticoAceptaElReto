/**
* @author Ignasi Paredes Casasnovas
*/

package exercisipracticaceptaelreto;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ExercisiPracticAceptaElReto {
    public static void main(String[] args) {
        //Leemos la primera línea introducida
        Scanner scanner = new Scanner(System.in);
        
        //En cada iteración, leeremos la primera línea, que contiene la cantidad 
        //de hangares disponibles en una determinada base, mientras no sea 0.
        for (int numeroHangares = scanner.nextInt(); numeroHangares != 0; numeroHangares = scanner.nextInt()) {
            
            PriorityQueue<Hangar> heap = new PriorityQueue<Hangar>();
            
            //Obtenemos los H números con sus tamaños dentro de un array
            for (int i = 0; i < numeroHangares; i++) {
                heap.offer(new Hangar(scanner.nextInt()));
            }

            //Obtenemos la cantidad de naves que llegan a la base
            int cantidadNaves = scanner.nextInt();
            
            //Obtenemos los tamaños de las naves por orden de llegada            
            int [] tamañoNaves = new int [cantidadNaves];
            for (int i = 0; i < cantidadNaves; i++) {
                tamañoNaves[i] = scanner.nextInt();
            }

            String resultadoIteracion = "SI";
            //Iteramos en cada nave por orden de llegada comprobando si podemos meterla
            for (int nave : tamañoNaves) {
                if (heap.peek().capacidad < nave) {
                    resultadoIteracion = "NO";
                    break;
                }
                heap.offer(new Hangar(heap.poll().capacidad - nave));
            }
            System.out.println(resultadoIteracion);
        }
    }
    
    // Clase Hangar con prioridad según la capacidad
    public static class Hangar implements Comparable {
        private int capacidad;

        Hangar(int capacidad) {
            this.capacidad = capacidad;
        }

        @Override
        public int compareTo(Object o) {
            //Ordenar de manera descendiente por capacidad
            return ((Hangar)o).capacidad - this.capacidad;
        }
    }
}