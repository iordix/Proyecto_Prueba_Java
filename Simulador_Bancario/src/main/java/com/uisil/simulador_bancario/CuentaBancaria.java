/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uisil.simulador_bancario;

/**
 *
 * @author Thoka
 */
public class CuentaBancaria {
    /// Creacion de los atributos ///
    private int numeroCuenta;
    private String nombreTitular;
    private double saldo;

    /// Metodo de deposito///
    public void depositar(double monto){
        if (monto > 0){
            saldo += monto;
        }
        else{
            System.out.println("El monto debe ser mayor que cero.  ");
        }
    }
    /// Metodo de retirar///
    public void retirar(double monto) throws Exception{
      if (monto <=0){
          throw new IllegalArgumentException("El monto debe de ser mayor que cero. ");
      }
      if(monto > saldo){
      throw new Exception("Saldo insuficiente para realizar el retiro");
      }
      saldo -= monto;
    }
    /// Metodo de consulta de saldo///
    public double consultarSaldo(){
        return saldo;
    }
    /// Metodo de divicion de saldo///
    public void dividirSaldo(double divisor) throws Exception{
     if(divisor ==0){
         throw new ArithmeticException("No se puede dividir entre cero");
     }
     saldo = saldo/divisor;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public double getSaldo() {
        return saldo;
    }
    /// Metodo de menu///

}
