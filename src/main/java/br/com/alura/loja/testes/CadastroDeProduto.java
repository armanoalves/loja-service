package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
//		Produto celular = new Produto("S23 FE", "Muito Legal", new BigDecimal("2600"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao produtoDao = new ProdutoDao(em);
//		CategoriaDao categoriaDao = new CategoriaDao(em);	
		
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNome("Iphone 15");
		
		em.flush();
		em.clear();
		
//		categoriaDao.cadastrar(celulares);
//		produtoDao.cadastrar(celular); 
		
		celulares = em.merge(celulares);
		celulares.setNome("1221");
		em.flush();
		em.remove(celulares);
		em.flush();
	}
}
