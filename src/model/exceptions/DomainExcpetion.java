package model.exceptions;

@SuppressWarnings("serial")
public class DomainExcpetion extends Exception {// ou extends RuntimeException. RuntimeException o compilador não obriga
												// a tratar, porém o programa quebra se não for tratada a possível exceção
	
	public DomainExcpetion(String mensagem) {//Por que este passo é feito?
		super(mensagem);						//Para permitir que se possa instanciar a exceção personalizada
	}											//passando uma mensagem para ela			
	
		
}
