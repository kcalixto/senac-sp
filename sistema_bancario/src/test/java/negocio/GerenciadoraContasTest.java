package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {
    private GerenciadoraContas gerContas;
    static final int idConta01 = 1;
    static final int idConta02 = 2;

    // Saldo suficiente em ambas as contas
    @Test
    public void testiransferevalor01() {
        ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
        ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

        // Inserindo os clientes criados no lista de clientes do banco
        List<ContaCorrente> contasDoBanco = new ArrayList<>();

        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);
        gerContas = new GerenciadoraContas(contasDoBanco);
        float valorTransferencia = 100.00f;
        boolean sucesso = gerContas.transfereValor(idConta01, valorTransferencia, idConta02);

        // Delta é a diferença máxima entre os dois valores flutuantes!
        float delta = 0.0f;
        assertTrue(sucesso);
        assertEquals(conta01.getSaldo(), 100.0, delta);
        assertEquals(conta02.getSaldo(), 100.0, delta);
    }

    // Saldo insuficiente e positivo na Conta 1
    @Test
    public void testiransferevalor02() {
        ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
        ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

        // Inserindo os clientes criados no lista de clientes do banco
        List<ContaCorrente> contasDoBanco = new ArrayList<>();

        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);
        gerContas = new GerenciadoraContas(contasDoBanco);
        float valorTransferencia = 200.00f;
        boolean sucesso = gerContas.transfereValor(idConta01, valorTransferencia, idConta02);

        // Delta é a diferença máxima entre os dois valores flutuantes!
        float delta = 0.0f;
        assertTrue(sucesso);
        assertEquals(conta01.getSaldo(), -100.00, delta);
        assertEquals(conta02.getSaldo(), 200.0, delta);
    }

    // Saldo insuficiente e negativo na Conta 1
    @Test
    public void testiransferevalor03() {
        ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
        ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

        // Inserindo os clientes criados no lista de clientes do banco
        List<ContaCorrente> contasDoBanco = new ArrayList<>();

        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);
        gerContas = new GerenciadoraContas(contasDoBanco);
        float valorTransferencia = 200.00f;
        boolean sucesso = gerContas.transfereValor(idConta01, valorTransferencia, idConta02);

        // Delta é a diferença máxima entre os dois valores flutuantes!
        float delta = 0.0f;
        assertTrue(sucesso);
        assertEquals(conta01.getSaldo(), -300.00, delta);
        assertEquals(conta02.getSaldo(), 200.0, delta);
    }

    // Saldo insuficiente em ambas as contas
    @Test
    public void testiransferevalor04() {
        ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
        ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);

        // Inserindo os clientes criados no lista de clientes do banco
        List<ContaCorrente> contasDoBanco = new ArrayList<>();

        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);
        gerContas = new GerenciadoraContas(contasDoBanco);
        float valorTransferencia = 200.00f;
        boolean sucesso = gerContas.transfereValor(idConta01, valorTransferencia, idConta02);

        // Delta é a diferença máxima entre os dois valores flutuantes!
        float delta = 0.0f;
        assertTrue(sucesso);
        assertEquals(conta01.getSaldo(), -300.00, delta);
        assertEquals(conta02.getSaldo(), 100.0, delta);
    }
}
