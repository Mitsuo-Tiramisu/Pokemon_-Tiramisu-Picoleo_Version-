package exercicio1;

public class TrocarPokemon extends Event {

	public TrocarPokemon(int prioridade) {
		super(prioridade);
	}

	void action(Treinador t1, Treinador t2) {
		t1.euEscolhoVoce();
	}
	
}
