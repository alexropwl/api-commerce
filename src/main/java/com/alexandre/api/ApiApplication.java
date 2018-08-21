package com.alexandre.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.api.domain.Categoria;
import com.alexandre.api.domain.Cidade;
import com.alexandre.api.domain.Estado;
import com.alexandre.api.domain.Produto;
import com.alexandre.api.repositories.CategoriaRepository;
import com.alexandre.api.repositories.CidadeRepository;
import com.alexandre.api.repositories.EstadoRepository;
import com.alexandre.api.repositories.ProdutoRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository catRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	

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
	     
	     
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
