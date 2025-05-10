package Structures;

public class Pila {
    public static int tope = -1;
    public static char[] pila;
     public static void inPila ( int tam, Character elem) {
        if (tope < tam - 1) {
            tope++;
            pila[tope] = elem;
          
        } else {
            System.out.println("No hay espacios, busque en otro lado. 😒");
        }
    }
    public static Character outPila (int tam) {
         if (tope == -1) {
            return null;
        } else {
            char elem = pila[tope];
            pila[tope] = '\0'; 
            tope--;

            return elem;
        }
    }


    
}

