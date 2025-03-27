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
            //Creamos la cola de prioridad de hangares de tamaño H (1 ≤ H ≤ 10)
            PriorityQueue<Hangar> heap = new PriorityQueue<>(numeroHangares);
            
            //Obtenemos los H números que indican la capacidad de los hangares
            //y los vamos introduciendo en la cola de prioridad
            //El bucle for se ejecuta n veces -> O(n)
            for (int i = 0; i < numeroHangares; i++) {
                //El coste de offer() -> O(log(n))
                heap.offer(new Hangar(scanner.nextInt()));
            }
            //Coste total del algoritmo = O(n)*O(log(n)) -> O(n * log(n))

            //Obtenemos la cantidad de naves que llegan a la base
            int cantidadNaves = scanner.nextInt();
            
            //Al inicio hay espacio suficiente para todas las naves
            boolean espacioSuficiente = true;
            
            //Iteramos en cada nave por orden de llegada comprobando si podemos 
            //meter la nave en el hangar más grande.
            //El bucle for se ejecuta n veces -> O(n)
            for (int i = 0; i < cantidadNaves; i++) {
                //Obtenemos el tamaño de la nave
                int nave = scanner.nextInt();
                
                if (!espacioSuficiente) continue;
                
                //Si no cabe la nave en el hangar más grande, quiere decir que no
                //hay espacio suficiente, por tanto, marcamos que no hay espacio 
                //suficiente y terminamos el bucle
                //El coste de peek() -> O(1)
                if (heap.peek().capacidad < nave) espacioSuficiente = false;
                
                //Por el contrario, si hay espacio suficiente, le restamos ese espacio
                //al hangar y lo volvemos a meter con su nuevo espacio disponible
                //en la cola de prioridad
                //El coste de poll() -> O(log(n))
                heap.offer(new Hangar(heap.poll().capacidad - nave));
            }
            //Coste total del algoritmo = O(n)*O(log(n)) -> O(n * log(n))
            
            //Imprimimos el resultado
            System.out.println(espacioSuficiente ? "SI" : "NO");
        }
    }
    
    // Clase Hangar con prioridad según la capacidad
    public static class Hangar implements Comparable<Hangar> {
        //Atributo indicando la capacidad del hangar
        private int capacidad;

        //Método constructor
        Hangar(int capacidad) {
            this.capacidad = capacidad;
        }

        //Modificamos el método compareTo para ordenar la capacidad de manera descendente
        @Override
        public int compareTo(Hangar o) {
            return o.capacidad - this.capacidad;
        }
    }
}