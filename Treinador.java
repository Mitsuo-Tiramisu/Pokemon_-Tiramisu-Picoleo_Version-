
abstract class Treinador {
	
	String nome;
	Pokemon[] pokemons = new Pokemon[6];
	
	Pokemon pokemonAtual;
	int nxt = 0;
	String ataqueAtual;
	int dano;
	
	double efectividade[][] = {
			{1,   1,   1,   1,   1,  1,   1,   1},//NORMAL
			{1, 0.5, 0.5,   1,   2,  1,   1,   1},//FIRE
			{1,   2, 0.5,   1, 0.5,  1,   1,   1},//WATER
			{1,   1,   2, 0.5, 0.5,  1,   2,   1},//ELETRIC
			{1, 0.5,   2,   1, 0.5,  1, 0.5,   1},//GRASS
			{2,   1,   1,   1,   1,  1, 0.5, 0.5},//FIGHTING
			{1,   1,   1, 0.5,   2,  2,   1,   1},//FLYING
			{1,   1,   1,   1,   1,  2,   1, 0.5} //PSYCHIC
		};
	
	public Treinador(String nome){
		this.nome = nome;
	}
	
	public void euEscolhoVoce(){
		pokemonAtual = pokemons[nxt++];
		System.out.println(nome+" escolhe pokemon "+pokemonAtual.nome);
	}
	
	public void defineAtaque(Pokemon adversario){
		int n;
		int danoParcial;
		dano = -1;
		for(int i=0;i<4;i++){
			n = pokemonAtual.ataques[i].tipo;
			danoParcial = (int) (efectividade[n][adversario.tipo])*(pokemonAtual.ataques[i].dano);
			if(danoParcial > dano){
				dano = danoParcial;
				ataqueAtual = pokemonAtual.ataques[i].nome;
			}
		}
	}
	
	public int oQueFarei(){
		if(nxt == 6){
			return 0;
		}
		
		else if(pokemonAtual.atualHP == 0){
			//System.out.println("O pokemon "+pokemonAtual.nome+" foi  gravemente ferido!");
			return 1;
		}
		
		else if(pokemonAtual.atualHP <= 10){
			return 2;
		}
		
		else{
			return 3;
		}
		
	}

	public void fugir() {
		System.out.println(nome+" fugiu da batalha!");
	}

	public void ganhou() {
		System.out.println(nome+" ganhou a batalha!!");
	}
	
}

class Treinador1 extends Treinador{
	
	
	public Treinador1(String nome) {	
		super(nome);
		pokemons[0] = new Bulbasaur("Bulba");
		pokemons[1] = new Snorlax("Snor");
		pokemons[2] = new Mewtwo("Mew");
		pokemons[3] = new Pikachu("Pika");
		pokemons[4] = new Butterfree("Butter");
		pokemons[5] = new Pidgeot("Pidg");
	}
	
}

class Treinador2 extends Treinador{
	
	public Treinador2(String nome) {
		super(nome);
		pokemons[0] = new Hitmonchan("Hitmon");
		pokemons[1] = new Charizard("Chari");
		pokemons[2] = new Wartortle("Warto");
		pokemons[3] = new Jigglypuff("Jiggly");
		pokemons[4] = new Meowth("Meowth");
		pokemons[5] = new Lapras("Lapras");
	}
	
}
