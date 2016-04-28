package exercicio1;

abstract class Event {
	int prioridade;
	
	public Event(int prioridade){
		this.prioridade = prioridade;
	}
	
	public int getPrio(){
		return prioridade;
	}
	
	abstract void action(Treinador t1, Treinador t2);
}
