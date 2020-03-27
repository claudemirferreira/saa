package br.com.setbit.saa.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.setbit.saa.response.Response;
import br.com.setbit.saa.service.BaseService;
import br.com.setbit.saa.util.ObjectMapperUtils;

/**
 *
 * @param <T>   source Entity
 * @param <ID>  Entity's id
 * @param <DTO> DTO object to convert
 */
public abstract class AbstractController<T, ID, DTO> {

	protected abstract BaseService<T, ID> getService();

	protected abstract Class<DTO> getDtoClass();

	@RequestMapping(value = "", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<DTO>>> find() {
		Response<List<DTO>> response = new Response<List<DTO>>();
		response.setData(toDto(getService().findAll()));
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<DTO>> findById(@PathVariable("id") ID id) {
		Response<DTO> response = new Response<DTO>();
		try {
			DTO dto = toDto(getService().findById(id));
			response.setData(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable("id") ID id) {
		try {
			getService().deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<DTO>> findById(HttpServletResponse resp, @RequestBody T entity) {
		Response<DTO> response = new Response<DTO>();
		try {
			DTO dto = toDto(getService().save(entity));
			response.setData(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}

	private List<DTO> toDto(Collection<T> entityList) {
		return ObjectMapperUtils.mapAll(entityList, getDtoClass());
	}

	private DTO toDto(T entityList) {
		return ObjectMapperUtils.map(entityList, getDtoClass());
	}

}