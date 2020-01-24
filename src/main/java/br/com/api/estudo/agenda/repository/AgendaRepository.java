package br.com.api.estudo.agenda.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.estudo.agenda.exception.ResourceNotFoundException;
import br.com.api.estudo.agenda.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer>{
	
	
	
//COMENTADO IMPLAMENTAÇÃO POIS DEIXARÁ DE CRIAR NA MEMÓRIA LOCAL E PASSARÁ A UTILIZAR SPRING DATA
	
//	private List<Agenda> agendas = new ArrayList<Agenda>();
//	private int contadorDeID;
//
//	public List<Agenda> all(){
//		
//		return this.agendas;
//	}
//	
//	
//	public Optional<Agenda> pegarPor(Integer id) {
//
//		for (Agenda agenda: this.agendas) {
//			if (agenda.getId() == id) {
//				return Optional.of(agenda);
//			}
//		}
//		return Optional.empty();
		
		//Java 8 - Funcionalidade optional funciona para fazer filtro e pesquisa. Funciona igual for e if acima
//		Optional<Agenda> optional = this.agendas
//				.stream()
//				.filter(agenda -> agenda.getId() == id)
//				.findFirst();
//		return optional.orElse(agendaDefault);
//	} 
//	
//	public Agenda salvar(Agenda agenda) {
//		
//		agenda.setId(getContadorDeID());
//		this.agendas.add(agenda);
//		return agenda;
//	}
//	
//	private int getContadorDeID() {
//		
//		this.contadorDeID++; 
//		return contadorDeID;
//	}
//	
//	@PostConstruct
//	private void load() {
//		Agenda agenda = new Agenda();
//		agenda.setId(getContadorDeID());
//		agenda.setNome("Agenda 1");
//		agenda.setTelefone("(11)98765-4321");
//		agendas.add(agenda);
//		
//		Agenda agenda2 = new Agenda();
//		agenda2.setId(getContadorDeID());
//		agenda2.setNome("Agenda 2");
//		agenda2.setTelefone("(11)91234-5678");
//		agendas.add(agenda2);
//	}
//
//
//	public Agenda alterar(Agenda agenda) {
//
//		for (int i = 0; i < this.agendas.size(); i++) {
//			if (this.agendas.get(i).getId() == agenda.getId()) {
//				this.agendas.remove(i);
//				this.agendas.add(i, agenda);
//				return agenda;
//			}
//		}
//		throw new ResourceNotFoundException();
//	}
//
//
//	public void excluir(Agenda agenda) {
//		
//		this.agendas.remove(agenda);
//		
//	}
}
