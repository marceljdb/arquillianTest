package br.com.arquillian.dao;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.spi.annotation.TestScoped;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.arquillian.modelo.Pessoa;

@RunWith(Arquillian.class)
public class PessoaDaoTeste {
	@Deployment
	public static Archive<?> criarArquivoTeste() {
		Archive<?> arquivoTest = ShrinkWrap.create(WebArchive.class, "aplicacaoTeste.war")
				.addPackage(PessoaDao.class.getPackage())
				.addClass(Pessoa.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		return arquivoTest;
	}
	
	@Inject
	PessoaDao pessoaDao;
	
	@Test
	public void testeSalvarPessoa()	{
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(10);
		pessoa.setNome("Teste");
		pessoaDao.Salvar(pessoa);
		
	}

}
