package negocio;


import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ex1_2 {
	
	private GerenciadoraClientes gerClientes = new GerenciadoraClientes(null);
	static final int idCliente01 = 1;
	static final int idCliente02 = 2;
	static final int idCliente03 = 3;
	
	Cliente joao;
	Cliente maria;
	Cliente teresa;
	Cliente neymar;
	Cliente faustao;
	Cliente alex;
	
	@Before
	public void setUp() {
		joao = new Cliente(idCliente01, "joão", 65, "joao@gmail.com", 1, true);
		maria = new Cliente(idCliente02, "Maria", 64, "maria@gmail.com", 1, true);
		teresa = new Cliente(idCliente03, "teresa", 19, "faustao@gmail.com", 1, true);
		neymar = new Cliente(idCliente02, "Neymar Jr.", 18, "neymar@gmail.com", 1, true);
		faustao = new Cliente(idCliente03, "Faustão", 17, "faustao@gmail.com", 1, false);
		alex = new Cliente(idCliente03, "alex", 66, "faustao@gmail.com", 1, false);
	}
	
	@Test
	public void ValidaIdade() throws IdadeNaoPermitidaException {
		try {
			boolean idadeValida = gerClientes.validaIdade(neymar.getIdade());
			assertTrue(idadeValida);
		}catch(Exception e) {
			throw e;
		}
		
		try {
			boolean idadeValida = gerClientes.validaIdade(faustao.getIdade());
			assertFalse(idadeValida);
		}catch(Exception e) {
			assertEquals(e.getMessage(), IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		}
		
		try {
			boolean idadeValida = gerClientes.validaIdade(alex.getIdade());
			assertFalse(idadeValida);
		}catch(Exception e) {
			assertEquals(e.getMessage(), IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		}
	}
	
}










