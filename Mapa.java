import java.util.Random;

public class Mapa{
  int MAX_X;
  int MAX_Y;
  int Atual_X;
  int Atual_Y;
  int terreno [][] = {
    {0,1,0},
    {1,0,1},
    {0,1,0}
  };  //0-Comum,  1-Grama
  public Mapa(int X, int Y, int mapinha[][]){
    this.MAX_X = X;
    this.MAX_Y = Y;
    for (int i=0;i<X;i++){
      for(int j=0;j<Y;j++){
        this.terreno[i][j] = mapinha[i][j];
      }
    }
    this.Atual_Y = Y/2;
    this.Atual_X = X/2;
  }
  public void andar(int direcao,int sentido){ // 0-X, 1-Y
    if(direcao == 1){
      if(sentido == 1){
        if(this.Atual_Y+1< this.MAX_Y){
          this.Atual_Y++;
          System.out.println("Voce andou para cima");
        }
      }
      else
        if(this.Atual_Y>0){
          this.Atual_Y--;
          System.out.println("Voce andou para baixo");
        }
    }
    else{
      if(sentido == 1){
        if(this.Atual_X+1<this.MAX_X){
          this.Atual_X++;
          System.out.println("Voce andou para direita");
        }
      }
      else
        if(this.Atual_X>0){
          this.Atual_X--;
          System.out.println("Voce andou para esquerda");
        }
    }
  }


  public static void main(String[] args){
    int passos = 0;
    Random r = new Random();
    Selvagem wild;
    int mapinha[][] = {
      {0,1,0},
      {1,0,1},
      {0,1,0}
    };
    Mapa maps = new Mapa(3,3, mapinha);
    Evento encontro;
    Treinador2 mit = new Treinador2("Mit");
    while(passos < 15){
      passos ++;
      wild = new Selvagem ();
      int a, b, c;
      a = r.nextInt(2);
      b = r.nextInt(2);
      c = r.nextInt(4);
      System.out.println(c+""+a+""+b);
      maps.andar(a,b);
      if (maps.terreno[maps.Atual_X][maps.Atual_Y] == 1){
        if(c < 1){
          encontro = new Encontro(mit,wild);
          encontro.executar();
        }
      }
    }
  }
}

class  Selvagem extends Treinador{

	public Selvagem() {
		super("Wild");
    this.quantidadePokemon = 1;
    int n;
    Random r = new Random();
    n = r.nextInt(11);

		switch(n){
      case 0:
        pokemons[0] = new Hitmonchan("Hitmonchan");
        break;

      case 1:
        pokemons[0] = new Charizard("Charizard");
        break;

      case 2:
        pokemons[0] = new Wartortle("Wartortle");
        break;

      case 3:
        pokemons[0] = new Jigglypuff("Jigglypuff");
        break;

      case 4:
        pokemons[0] = new Meowth("Meowth");
        break;

      case 5:
        pokemons[0] = new Lapras("Lapras");
        break;

      case 6:
        pokemons[0] = new Bulbasaur("Bulbasaur");
        break;

      case 7:
        pokemons[0] = new Snorlax("Snorlax");
        break;

      case 8:
        pokemons[0] = new Mewtwo("Mewtwo");
        break;

      case 9:
        pokemons[0] = new Pikachu("Pikachu");
        break;

      case 10:
        pokemons[0] = new Butterfree("Butterfree");
        break;

      case 11:
        pokemons[0] = new Pidgeot("Pidgeot");
        break;
    }
	}
}


class Encontro extends Evento{
  public Encontro (Treinador2 cara, Selvagem selvagem){
    ator = cara;
    alvo = selvagem;
    prioridade = 0;
  }

  public void executar(){
    boolean flag = true, morreu = false;
		int escolha1;
    int escolha2;
		Event e1 = null,e2 = null;

		ator.euEscolhoVoce();
		ator.defineAtaque(ator.pokemonAtual);
		alvo.defineAtaque(alvo.pokemonAtual);

		for(int round=1;flag;round++){

			if(!morreu) {
				System.out.println("");
				System.out.println("ROUND "+round);
				ator.pokemonAtual.imprimeVida();
				alvo.pokemonAtual.imprimeVida();
			}
			else morreu = false;

			escolha1 = ator.oQueFarei();

      /*if (alvo.pokemonAtual.atualHP < )
			  escolha1 = 4;
      */

      if (alvo.pokemonAtual.atualHP > 2)
			  escolha2 = 3;
      else
        escolha2 = 0;

			if(escolha1 == 0){
				e1 = new Fugir(1);
				e1.action(ator, alvo);
				flag = false;
				continue;
			}

			if(escolha2 == 0){
				e2 = new Fugir(1);
				e1.action(alvo, ator);
				flag = false;
				continue;
			}

			if(escolha1 == 1){
				e1 = new TrocarPokemon(2);
				alvo.defineAtaque(ator.pokemonAtual);
				escolha2 = -1;
			}

			if(escolha1 == 2){
				e1 = new Curar(3);
			}

			if(escolha1 == 3){
				e1 = new Atacar(4);
			}

			if(escolha2 == 3){
				e2 = new Atacar(4);
			}

			if(e1.getPrio() <= e2.getPrio()){
				e1.action(ator, alvo);
				if(alvo.pokemonAtual.atualHP < 0) morreu = true;
				if(!morreu){
					e2.action(alvo, ator);
				}
			}
			else{
				e2.action(alvo, ator);
				if(ator.pokemonAtual.atualHP < 0) morreu = true;
				if(!morreu){
					e1.action(ator, alvo);
				}

			}
		}

  }
}
