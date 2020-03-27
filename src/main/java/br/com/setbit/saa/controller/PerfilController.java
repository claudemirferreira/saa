package br.com.setbit.saa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.setbit.saa.dto.PerfilDTO;
import br.com.setbit.saa.model.Perfil;
import br.com.setbit.saa.service.BaseService;
import br.com.setbit.saa.service.PerfilService;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController extends AbstractController<Perfil, Integer, PerfilDTO> {

	@Autowired
	private PerfilService service;

	@Override
	protected BaseService<Perfil, Integer> getService() {
		return service;
	}

	@Override
	protected Class<PerfilDTO> getDtoClass() {
		return PerfilDTO.class;
	}
}