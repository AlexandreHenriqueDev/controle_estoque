package br.com.treinamento.backend;

import br.com.treinamento.dto.ProdutoDto;
import br.com.treinamento.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ControleEstoqueApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProdutoService service;

	@Test
	public void buscarProdutosTest() throws Exception {
		List<ProdutoDto> produtos = service.buscarTodos();


	}

}
