package model.exceptions;

@SuppressWarnings("serial")
public class DomainExcpetion extends Exception {// ou extends RuntimeException. RuntimeException o compilador n�o obriga
												// a tratar, por�m o programa quebra se n�o for tratada a poss�vel exce��o
	
	public DomainExcpetion(String mensagem) {//Por que este passo � feito?
		super(mensagem);						//Para permitir que se possa instanciar a exce��o personalizada
	}											//passando uma mensagem para ela			
	
		
}
