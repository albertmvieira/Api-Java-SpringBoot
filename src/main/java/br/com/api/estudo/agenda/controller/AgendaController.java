package br.com.api.estudo.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.estudo.agenda.model.Agenda;
import br.com.api.estudo.agenda.repository.AgendaRepository;
import br.com.api.estudo.agenda.service.AgendaService;

@RestController
@RequestMapping("agendas")
public class AgendaController {
	
	private final AgendaService service;
	
	@Autowired
	public AgendaController(AgendaService service) {
		super();
		this.service = service;
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Agenda> exibirTodosRegistros(){
		return this.service.listarTodos();
	}
	
	@GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Agenda buscarAgendaPor(@PathVariable(name = "id") Integer idAgenda) {
		return this.service.buscarPor(idAgenda);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Agenda salvarAgenda(@RequestBody Agenda agenda) {
	
		return this.service.salvar(agenda);
	}
	
	@PutMapping("{id}")
	public Agenda alterarAgenda(@PathVariable Integer id, @RequestBody Agenda agenda) {
		
		return this.service.alterar(id, agenda);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		this.service.excluir(id);
	}
	
	
	
	
}
