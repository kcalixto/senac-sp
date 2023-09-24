package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;

	@Before
	public void setUp() {

		/* Montagem do cenário */

		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "joão", 31, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 34, "maria@gmail.com", 1, true);

		// inserindo os clientes criados na lista de cliente do banco
		List<Cliente> clienteDoBanco = new ArrayList<>();
		clienteDoBanco.add(cliente01);
		clienteDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clienteDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	/*
	 * teste básico da culta de um cliente a partir do seu id
	 */

	@Test
	public void testPesquisaCliente() {
		/* ==========Execução */
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);

		/* ==========Verificação========= */
		assertEquals(cliente.getId(), idCliente01);
	}

	/**
	 * Teste básico da remoção de um cliente a partir do seu id
	 * 
	 */
	@Test
	public void testRemoverCliente() {

		/* ======== Execução ======== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);

		/* ========Verificação ========== */
		assertTrue(clienteRemovido);
		assertEquals(gerClientes.getClientesDoBanco().size(), 1);
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}

}
