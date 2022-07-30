/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author AGUSTIN HERNANDEZ
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double total = 0;
        int opcion = 0;
        double segundoValor = 0;
        
        //Generamos un bucle do-while para evitar escribir de nuevo las acciones de toma de opción.
        do {            
            System.out.println("Ingrese la siguiente acción. \n1) Sumar. \n2) Restar. \n3) Multiplicar. \n4) Dividir. \n5) Sacar Residuo. \n0) Salir.");
            opcion = teclado.nextInt();
            
            //A partir de la opción tomada, generamos un switch que tomará en cuenta cada caso que nosotros deseemos.
            switch (opcion) {
                
                //La opción 0 nos sacará del programa mostrando el total.
                case 0: 
                    mensaje("El total es: " + total); 
                    System.exit(0);
                break;
                //La opción 1 tomará en cuenta una variable secundaria con el que se va a sumar el total.
                case 1:
                    mensaje("Ingrese valor a añadir: ");
                    segundoValor = teclado.nextDouble();
                    total = sumar(total, segundoValor);
                break;
                //La opción 2 tomará en cuenta una variable secundaria con el que se va a restar el total.
                case 2:
                    mensaje("Ingrese valor a restar: ");
                    segundoValor = teclado.nextDouble();
                    total = restar(total, segundoValor);
                    break;
                //La opción 3 tomará en cuenta una variable secundaria con el que se va a multiplicar el total.
                case 3:
                    mensaje("Ingrese valor a multiplicar: ");
                    segundoValor = teclado.nextDouble();
                    total = multiplicar(total, segundoValor);
                    break;
                //La opción 4 tomará en cuenta una variable secundaria con el que se va a dividir el total.
                //Antes de realizar la operación, evaluará primero si el segundo valor en realidad es 0 o no.
                //Como es una variable double, no importa si uno pone valores como 0,00001. Realizará la operación.
                case 4:
                    mensaje("Ingrese valor a dividir:");
                    segundoValor = teclado.nextDouble();
                    if(segundoValor == 0){
                        mensaje("No se puede dividir entre 0");
                    }
                    else{
                        total = dividir(total, segundoValor);
                    }
                    break;
                //La opción 5 tomará en cuenta una variable secundaria con el que se va a sacar el residuo de operación del total.
                //Antes de realizar la operación, evaluará primero si el segundo valor en realidad es 0 o no.
                //Como es una variable double, no importa si uno pone valores como 0,00001. Realizará la operación.
                case 5:
                    mensaje("Ingrese valor a sacar residuo:");
                    segundoValor = teclado.nextDouble();
                    if(segundoValor == 0){
                        mensaje("No se puede dividir entre 0");
                    }
                    else{
                        total = mod(total, segundoValor);
                    }
                    break;
                //En caso que no seleccione ninguna de las opciones anteriores, nos mandará un error en consola haciendo que no se
                //pueda continuar con el programa.
                default:
                    throw new AssertionError();
            }
        } while (opcion != 0);
    }
    
    
    //Los métodos siguientes a mensaje(String mensaje) toman en cuenta dos valores y a partir de eso, el valor 1 va a ser la variable afectada.
    private static void mensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static double sumar(double valor1, double valor2){
        return valor1 + valor2;
    }
    
    public static double restar(double valor1, double valor2){
        return valor1 - valor2;
    }
    
    public static double multiplicar(double valor1, double valor2){
        return valor1 * valor2;
    }
    
    public static double dividir(double valor1, double valor2){
        return valor1 / valor2;
    }
    
    public static double mod(double valor1, double valor2){
        return valor1 % valor2;
    }
}
