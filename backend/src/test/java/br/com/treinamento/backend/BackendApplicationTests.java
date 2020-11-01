package br.com.treinamento.backend;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	private ObjectMapper objectMapper;


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

	/**
		Teste da controller que insere um produto no estoque
	 */
	@Test
	public void inserirProduto() throws Exception {
		ProdutoDto produto = new ProdutoDto();
		produto.setCodigo("TESTE");
		produto.setNome("Teste");
		produto.setPreco(9.99);
		produto.setQuantidade(1);

		mockMvc
				.perform(MockMvcRequestBuilders.post("/api/controle/estoque/novo")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(produto))
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andDo(MockMvcResultHandlers.print());

	}


	/**
	 Teste da controller que edita um produto no estoque
	 */
	@Test
	public void editar() throws Exception {
		ProdutoDto produto = new ProdutoDto();
		produto.setCodigo("T1");
		produto.setNome("Teste de edição de produto");
		produto.setPreco(9.99);
		produto.setQuantidade(100);

		mockMvc
				.perform(MockMvcRequestBuilders.post("/api/controle/estoque/editar")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(produto))
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andDo(MockMvcResultHandlers.print());

	}

	/**
	 Teste da controller que remove um produto no estoque
	 */
	@Test
	public void remover() throws Exception {
		ProdutoDto produto = new ProdutoDto();
		produto.setCodigo("T1");

		mockMvc
				.perform(MockMvcRequestBuilders.post("/api/controle/estoque/remover")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(produto))
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andDo(MockMvcResultHandlers.print());

	}

}
