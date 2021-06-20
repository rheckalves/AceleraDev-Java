import com.challenge.desafio.CalculadorDeClasses;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Teste teste = new Teste(new BigDecimal(5), new BigDecimal(1), new BigDecimal(8), new BigDecimal(9));
        CalculadorDeClasses calculador = new CalculadorDeClasses();
        System.out.println(calculador.somar(teste));
        System.out.println(calculador.subtrair(teste));
        System.out.println(calculador.totalizar(teste));
    }
}
