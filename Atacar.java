
public class Atacar extends Event {

	public Atacar(int prioridade) {
		super(prioridade);
	}

	void action(Treinador t1, Treinador t2) {
		System.out.println(t1.pokemonAtual.nome+" usou "+t1.ataqueAtual+" causando "+t1.dano+" de dano!");
		t2.pokemonAtual.ferido(t2.dano);
		if(t2.pokemonAtual.atualHP <= 0){
			System.out.println("Pokemon "+t2.pokemonAtual.nome+" foi gravemente ferido!");
		}
	}
	
}
