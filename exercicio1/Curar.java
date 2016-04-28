package exercicio1;
public class Curar extends Event {

	public Curar(int prioridade) {
		super(prioridade);
	}

	void action(Treinador t1, Treinador t2) {
		t1.pokemonAtual.cura();
	}
	
	
}
