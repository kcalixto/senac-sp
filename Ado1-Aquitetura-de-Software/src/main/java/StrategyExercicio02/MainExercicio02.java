package StrategyExercicio02;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kcalixto
 * 
 * 2) Considerando que existem vários impostos (ip1,ip2, ip3) sobre
produtos ou serviços. E que a taxas são:
● ip1 - 10%
● ip2 - 15%
● ip3 - 25%
Escreva um projeto Java, tendo como base o padrão de projeto
strategy, que determine o cálculo de orçamento envolvendo
serviços e/ou produtos. Considere as incidências dos impostos
listados acima. O seu projeto deve eliminar as cadeias de if/else
ou switch/case e também manter em classes específicas, os
algoritmos de cálculos de impostos. Escreva uma classe de
contexto que teste todos os impostos listados anteriormente.
Cálculo: valor orçamento*imposto
O Orcamento é uma classe que contém uma lista de valores dos
serviços/produtos.
 */

// Classe de teste que cria um orçamento com valores e calcula os impostos 
//com diferentes tipos de impostos.
public class MainExercicio02 {

    public static void main(String[] args) {
        List<Double> valores = Arrays.asList(100.0, 200.0, 300.0); // Cria uma lista de valores.

        Orcamento orcamento = new Orcamento(valores); // Cria um objeto de orçamento com os valores.
        MetodoCalcularImposto calculadora = new MetodoCalcularImposto(); // Cria um objeto de calculadora de impostos.

        Imposto ip1 = new Ip1(); // Cria um imposto Ip1.
        Imposto ip2 = new Ip2(); // Cria um imposto Ip2.
        Imposto ip3 = new Ip3(); // Cria um imposto Ip3.

        double impostoIp1 = calculadora.calcular(orcamento, ip1); // Calcula o imposto Ip1.
        double impostoIp2 = calculadora.calcular(orcamento, ip2); // Calcula o imposto Ip2.
        double impostoIp3 = calculadora.calcular(orcamento, ip3); // Calcula o imposto Ip3.

        // Imprime os resultados dos cálculos de imposto.
        System.out.println("Imposto IP1: " + impostoIp1);
        System.out.println("Imposto IP2: " + impostoIp2);
        System.out.println("Imposto IP3: " + impostoIp3);
    }
}    

