package br.com.codenation.calculadora;

public class Principal {
    public static void main(String[] args) {
        CalculadoraSalario calculadoraSalario = new CalculadoraSalario();
        System.out.println(calculadoraSalario.calcularSalarioLiquido(1000.00));
        System.out.println(calculadoraSalario.calcularSalarioLiquido(1500.01));
        System.out.println(calculadoraSalario.calcularSalarioLiquido(10000.00));
    }
}
