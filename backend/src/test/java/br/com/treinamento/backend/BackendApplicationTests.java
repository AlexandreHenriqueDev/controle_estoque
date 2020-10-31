package br.com.treinamento.backend;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ControleEstoqueApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProdutoService service;


	/**
		Teste da controller que busca todos os dados de produtos em estoque
	 */
	@Test
	public void buscarProdutosTest() throws Exception {
		mockMvc
				.perform(MockMvcRequestBuilders.get("/api/controle/estoque"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andDo(MockMvcResultHandlers.print());

	}

}
