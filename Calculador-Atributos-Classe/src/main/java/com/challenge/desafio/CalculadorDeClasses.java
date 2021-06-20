package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CalculadorDeClasses implements Calculavel {

    private BigDecimal calcular(Object object, Class classe) {
        ArrayList<BigDecimal> listaSoma = new ArrayList<>();
        ArrayList<BigDecimal> listaSubtracao = new ArrayList<>();
//        System.out.println("Nome da classe: " + object.getClass().getName());
//        System.out.println("Tipo da classe: " + object.getClass().getTypeName());
        Field[] atributos = object.getClass().getDeclaredFields();
        for (Field atributo : atributos) {
            atributo.setAccessible(true);
//            System.out.println("Nome do atributo: " + atributo.getName());
//            System.out.println("Tipo do atributo: " + atributo.getType());
            try {
                if (atributo.getAnnotation(classe).annotationType().equals(Somar.class) && atributo.get(object) != null) {
                    listaSoma.add((BigDecimal) atributo.get(object));
                } else if (atributo.getAnnotation(classe).annotationType().equals(Subtrair.class) && atributo.get(object) != null){
                    listaSubtracao.add((BigDecimal) atributo.get(object));
                }
//                System.out.println("Valor do atributo: " + atributo.get(object));
//                System.out.println("Nome do atributo: " + atributo.getName());
            } catch (IllegalAccessException | NullPointerException e) {
            }
        }
//        System.out.println("Lista Soma: " + listaSoma);
//        System.out.println("Lista Subtrai: " + listaSubtracao);
//        System.out.println("***************************************");
        if (classe.equals(Somar.class) && listaSoma.size() != 0) {
            return (BigDecimal) listaSoma.stream().reduce(BigDecimal.ZERO,BigDecimal::add);
        } else if (classe.equals(Subtrair.class) && listaSubtracao.size() != 0) {
            return (BigDecimal) listaSubtracao.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal somar(Object object) {
        return calcular(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calcular(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        BigDecimal sumValue = calcular(object, Somar.class);
        BigDecimal subtractValue = calcular(object, Subtrair.class);
        return sumValue.subtract(subtractValue);
    }
}
