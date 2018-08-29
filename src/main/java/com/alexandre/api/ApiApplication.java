package com.alexandre.api;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.api.domain.Categoria;
import com.alexandre.api.domain.Cidade;
import com.alexandre.api.domain.Cliente;
import com.alexandre.api.domain.Endereco;
import com.alexandre.api.domain.Estado;
import com.alexandre.api.domain.ItemPedido;
import com.alexandre.api.domain.Pagamento;
import com.alexandre.api.domain.PagamentoComBoleto;
import com.alexandre.api.domain.PagamentoComCartao;
import com.alexandre.api.domain.Pedido;
import com.alexandre.api.domain.Produto;
import com.alexandre.api.domain.enuns.EstadoPagamento;
import com.alexandre.api.domain.enuns.TipoCliente;
import com.alexandre.api.repositories.CategoriaRepository;
import com.alexandre.api.repositories.CidadeRepository;
import com.alexandre.api.repositories.ClienteRepository;
import com.alexandre.api.repositories.EnderecoRepository;
import com.alexandre.api.repositories.EstadoRepository;
import com.alexandre.api.repositories.ItemPedidoRepository;
import com.alexandre.api.repositories.PagamentoRepository;
import com.alexandre.api.repositories.PedidoRepository;
import com.alexandre.api.repositories.ProdutoRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPeditoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora", 200.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		
		//associando produtos a categorias
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		//associando caregorias a produtos
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		

		catRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"Sao Paulo");
		
		Cidade c1 = new Cidade(null,"Juiz de Fora", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
	       
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		
	     estadoRepository.saveAll(Arrays.asList(est1, est2));
	     
	     cidadeRepository.saveAll(Arrays.asList(c1, c2));
	     
	     
		 Cliente cli1 = new Cliente(null, "alexandre", "alex@gmail", "07391489662", TipoCliente.PESSOAFISICA);
		 cli1.getTelefones().addAll(Arrays.asList("991022832"));
		 
		 
		
		Endereco e1 = new Endereco(c1, null, "olegario maciel", "00", "nenhum", "centro", "0000", cli1);
		
		Endereco e2 = new Endereco(c2, null, "padre cafe", "50", "nenhum", "sao pedro", "66666", cli1);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("28/08/2018 10:30"), cli1, e1);
		
        Pedido ped2 = new Pedido(null,sdf.parse("30/08/2018 12:00"), cli1, e2);
        
        
      Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 10);
      ped1.setPagamento(pgto1);
      
      Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,sdf.parse("01/09/2018 00:00"),null );
      
      ped2.setPagamento(pgto2);

      
      
      cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
      
      
       
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2.000);
		
		ItemPedido ip2 = new ItemPedido(ped2, p3, 0.00, 2, 5.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1));
		
		ped2.getItens().addAll(Arrays.asList(ip2));
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
		
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		
		
		itemPeditoRepository.saveAll(Arrays.asList(ip1,ip2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
