package br.com.setbit.saa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.setbit.saa.model.Perfil;
import br.com.setbit.saa.model.Sistema;
import br.com.setbit.saa.repository.PerfilRepository;
import br.com.setbit.saa.repository.PerfilRotinaRepository;
import br.com.setbit.saa.repository.SistemaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	PerfilRepository perfiRepository;
	
	@Autowired
	SistemaRepository sistemaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Sistema s1 = new Sistema(null, "SAA", "SAA", "AUTENTICACAO E AUTORIZACAO", "SAA");
		Sistema s2 = new Sistema(null, "INV", "INV", "INVENTARIO", "INV");
		
		sistemaRepository.saveAll(Arrays.asList(s1, s2));
		
		Perfil p1 = new Perfil(null, "CONFIGURACAO", "CONFIGURACAO", s1);		
		Perfil p2 = new Perfil(null, "RELATORIO", "RELATORIO", s1);
		
		perfiRepository.saveAll(Arrays.asList(p1, p2));
		
		
	}

}
