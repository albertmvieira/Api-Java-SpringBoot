package br.com.api.estudo.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.estudo.agenda.exception.ResourceNotFoundException;
import br.com.api.estudo.agenda.model.Agenda;
import br.com.api.estudo.agenda.repository.AgendaRepository;

@Service
public class AgendaService {
	
	private final AgendaRepository repository;
	
	@Autowired
	public AgendaService(AgendaRepository repository) {
		this.repository = repository;
	}
	
	public List<Agenda> listarTodos(){
		
		return repository.findAll();
		
	}
	
	public Agenda buscarPor(Integer id) {
		Optional<Agenda> optional = repository.findById(id);
		return optional.orElseThrow(() -> new ResourceNotFoundException("Agenda não encontrada"));
	}
	
	public Agenda salvar(Agenda agenda) {
		return this.repository.save(agenda);
	}
	
	public Agenda alterar(Integer id, Agenda agenda) {
		if (id != agenda.getId()) throw new ResourceNotFoundException("Id passado diferente do form.");
		buscarPor(id);
		Agenda agendaAlterada = salvar(agenda);
		return agendaAlterada;
	}
	
	public void excluir(Integer id) {
		Agenda agenda = this.buscarPor(id);
		this.repository.delete(agenda);
	}


}
