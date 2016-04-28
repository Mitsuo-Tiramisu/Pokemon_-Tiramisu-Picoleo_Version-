
class Batalha {
	
	public static void Atacando(Treinador t, Pokemon adversario){
		System.out.println(t.pokemonAtual.nome+" usou "+t.ataqueAtual+" causando "+t.dano+" de dano!");
		adversario.ferido(t.dano);
	}
	
	public static void main(String[] args){
		
		boolean flag = true;
		int escolha1,escolha2;
		Treinador1 t1 = new Treinador1("Leo");
		Treinador2 t2 = new Treinador2("Mit");
		
		
		t1.euEscolhoVoce();
		t2.euEscolhoVoce();
		t1.defineAtaque(t2.pokemonAtual);
		t2.defineAtaque(t1.pokemonAtual);
		
		while(flag){
			
			t1.pokemonAtual.imprimeVida();
			t2.pokemonAtual.imprimeVida();
			
			escolha1 = t1.oQueFarei();
			escolha2 = t2.oQueFarei();

			
			if(escolha1 == 0){
				System.out.println("O treinador "+t2.nome+" venceu a partida!");
				flag = false;
			}
			
			else if(escolha2 == 0){
				System.out.println("O treinador "+t1.nome+" venceu a partida!");
				flag = false;
			}
			
			else{
				
				if(escolha1 == 1){
					t2.defineAtaque(t1.pokemonAtual);
					escolha1 = 3;
				}
				
				if(escolha2 == 1){
					t1.defineAtaque(t2.pokemonAtual);
					escolha2 = 3;
				}
				
				if(escolha1 == 3){
					if(t1.pokemonAtual.atualHP > 0){
						Batalha.Atacando(t1, t2.pokemonAtual);
					}
				}
				
				if(escolha2 == 3){
					if(t2.pokemonAtual.atualHP > 0){
						Batalha.Atacando(t2, t1.pokemonAtual);
					}

				}
				
			}
		}
		
	}
}
