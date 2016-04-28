public class Fugir extends Event {
	
	public Fugir(int prioridade){
		super(prioridade);
	}
	
	public void action(Treinador t1, Treinador t2){
		t1.fugir();
		t2.ganhou();
	}
	
}
