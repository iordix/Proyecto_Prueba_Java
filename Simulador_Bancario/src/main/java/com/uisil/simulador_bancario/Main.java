/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uisil.simulador_bancario;

/**
 *
 * @author Thoka
 */
/// Aqui se importo las bibliotecas necesarias para el uso en el main ///
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        
            Scanner scanner = new Scanner(System.in); 
            CuentaBancaria cuentabancaria = new CuentaBancaria();
            int opcion = 0;
            boolean permiso = false;
            boolean error = false;
                /// Aqui se llama el metodo para mostrar el menu ///
        do{   cuentabancaria.menu();
            try {
               
                
                opcion = scanner.nextInt();
                switch(opcion){
                 /// Uso de switch case para la eleccion de las opciones del menu///
                case 1:{
                    System.out.print("Ingrese el número de cuenta: ");
                        int numeroCuenta = scanner.nextInt();
            
                   System.out.print("Ingrese el nombre del titular: ");
                        String nombreTitular = scanner.next();
            
                   System.out.print("Ingrese la cantidad a depositar: ");
                   Double saldo = scanner.nextDouble();
                   /// Validacion del ingreso de datos///
                   if(saldo >0){
                   cuentabancaria.depositar(saldo);
            
                   System.out.println("Cuenta creada exitosamente.");
                   System.out.println("Saldo actual: " + cuentabancaria.consultarSaldo());
                   permiso = true;
                   }
                   else{
                       /// Mensaje de la validacion///
                       System.out.println("El monto ingresado debe de ser mayor que cero. ");
                       permiso = false;
                       
                   }
                   
                   break;
                }
                case 2:{
                    System.out.print("Ingrese la cantidad a depositar: ");
                    Double monto = scanner.nextDouble();
                    if(monto >0){
                    cuentabancaria.depositar(monto);
                    System.out.println("Saldo actual: " + cuentabancaria.consultarSaldo());
                    break;
                    }
                    if(monto<=0){
                    permiso = false;
                    System.out.println("El monto debe ser mayor que cero.");
                    break;
                    }
                    
                }    
                case 3:{
                    System.out.print("Ingrese la cantidad a retirar: ");
                    Double monto = scanner.nextDouble();
                    cuentabancaria.retirar(monto);
                    System.out.println("El monto retirado es de: " + monto );
                    System.out.println("Saldo actual: " + cuentabancaria.consultarSaldo());
                    break;
                }
                case 4:{
                    System.out.println("Su saldo actual es: " + cuentabancaria.consultarSaldo());
                    break;
                }    
                case 5:{
                    System.out.print("Ingrese un numero para dividir su saldo: ");
                    Double divisor = scanner.nextDouble();
                    cuentabancaria.dividirSaldo(divisor);
                    System.out.println("El saldo fue dividido entre: " + divisor + " El saldo actual es: " + cuentabancaria.consultarSaldo());
                    break;
                }    
                case 6:{
                    System.out.println("Saliendo del programa...");
                    break;
                }   
                default:
                    System.out.println("Opcion no valida, intenta de nuevo...");
                }
                /// Captura de Exceptions para el uso del Switch Case///
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e + " Formato no compatible");
                scanner.nextLine();
                error = true;
            }
              catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e);
                    error = true;
            }    
              catch (ArithmeticException e) {
                System.out.println("Error: " + e);
                error = true;
               /// Uso de finally para mostrar mensajes a final del bucle
            } finally {
                
                 if(permiso == true){
                 System.out.println("Operacion exitosa, volviendo al menu...");
                 }
                 else{
                 System.out.println("Operacion fallida, volviendo al menu...");
                 } 
            }
            
        } while(opcion !=6);

         
        
        
       
        
       
       
    }
}
