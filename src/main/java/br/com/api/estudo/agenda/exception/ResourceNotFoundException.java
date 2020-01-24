package br.com.api.estudo.agenda.exception;

public class ResourceNotFoundException extends RuntimeException {
    
	public ResourceNotFoundException() {
        super("Recurso não encontrado");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
} 
