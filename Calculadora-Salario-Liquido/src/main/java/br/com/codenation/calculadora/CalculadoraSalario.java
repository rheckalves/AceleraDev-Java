package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioBruto = calcularInss(salarioBase);
		double result = 0;
		if (salarioBase < 1039.00) {
			return 0;
		}
		if (salarioBruto < 3000.00) {
			result = salarioBruto;
		}
		else if (salarioBruto > 3000.00 & salarioBruto <= 6000.00) {
			result = salarioBruto - salarioBruto * 0.075;
		} else if (salarioBruto > 6000.00) {
			result = salarioBruto - salarioBruto * 0.15;
		}
		return Math.round(result);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		boolean eightPercent = salarioBase <= 1500.00;
		boolean ninePercent = salarioBase > 1500.00 & salarioBase <= 4000.00;

		if(eightPercent) {
			return salarioBase - salarioBase * 0.08;
		} else if(ninePercent) {
			return salarioBase - salarioBase * 0.09;
		} else {
			return salarioBase - salarioBase * 0.11;
		}
	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/