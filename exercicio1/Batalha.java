package exercicio1;
class Batalha {
	
	public static void Atacando(Treinador t, Pokemon adversario){
		System.out.println(t.pokemonAtual.nome+" usou "+t.ataqueAtual+" causando "+t.dano+" de dano!");
		adversario.ferido(t.dano);
	}
	
	public static void main(String[] args){
		
		boolean flag = true, morreu = false;
		int escolha1,escolha2;
		Treinador1 t1 = new Treinador1("Leo");
		Treinador2 t2 = new Treinador2("Mit");
		Event e1 = null,e2 = null;
		
		t1.euEscolhoVoce();
		t2.euEscolhoVoce();
		t1.defineAtaque(t2.pokemonAtual);
		t2.defineAtaque(t1.pokemonAtual);
		
		for(int round=1;flag;round++){
			
			if(!morreu) {
				System.out.println("");
				System.out.println("ROUND "+round);
				t1.pokemonAtual.imprimeVida();
				t2.pokemonAtual.imprimeVida();
			}
			else{
				morreu = false;
				round--;
			}
			
			escolha1 = t1.oQueFarei();
			escolha2 = t2.oQueFarei();
			
			if(escolha1 == 0){
				e1 = new Fugir(0);
				e1.action(t1, t2);
				flag = false;
				continue;
			}
			
			if(escolha2 == 0){
				e2 = new Fugir(0);
				e2.action(t2, t1);
				flag = false;
				continue;
			}
			
			if(escolha1 == 1){
				e1 = new TrocarPokemon(1);
				e1.action(t1, t2);
				t2.defineAtaque(t1.pokemonAtual);
				t1.defineAtaque(t2.pokemonAtual);
				continue;
			}
			
			if(escolha2 == 1){
				e2 = new TrocarPokemon(1);
				e2.action(t2, t1);
				t1.defineAtaque(t2.pokemonAtual);
				t2.defineAtaque(t1.pokemonAtual);
				continue;
			}

			if(escolha1 == 2){
				e1 = new Curar(2);
			}
			
			if(escolha2 == 2){
				e2 = new Curar(2);
			}
			
			if(escolha1 == 3){
				e1 = new Atacar(3);
			}
			
			if(escolha2 == 3){
				e2 = new Atacar(3);
			}
			
			if(e1.getPrio() <= e2.getPrio()){
				e1.action(t1, t2);
				if(t2.pokemonAtual.atualHP <= 0) morreu = true;
				if(!morreu){
					e2.action(t2, t1);
				}
				if(t1.pokemonAtual.atualHP <= 0) morreu = true;
			}
			else{
				e2.action(t2, t1);
				if(t1.pokemonAtual.atualHP <= 0) morreu = true;
				if(!morreu){
					e1.action(t1, t2);
				}
				if(t2.pokemonAtual.atualHP <= 0) morreu = true;
			}
		}
		
	}
}
