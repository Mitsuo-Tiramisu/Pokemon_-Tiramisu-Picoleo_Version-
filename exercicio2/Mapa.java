
import java.awt.Event;
import java.util.Random;

public class Mapa{
	int MAX_X;
	int MAX_Y;
	int Atual_X;
	int Atual_Y;
	int terreno [][]= {
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0}
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
		          System.out.println("Voce andou para cima, e esta em: ["+this.Atual_X+","+this.Atual_Y+"]");
		        }
		      }
		      else
		        if(this.Atual_Y>0){
		          this.Atual_Y--;
		          System.out.println("Voce andou para baixo, e esta em: ["+this.Atual_X+","+this.Atual_Y+"]");
		        }
		    }
		    else{
		      if(sentido == 1){
		        if(this.Atual_X<this.MAX_X){
		          this.Atual_X++;
		          System.out.println("Voce andou para direita, e esta em: ["+this.Atual_X+","+this.Atual_Y+"]");
		        }
		      }
		      else
		        if(this.Atual_X>0){
		          this.Atual_X--;
		          System.out.println("Voce andou para esquerda, e esta em: ["+this.Atual_X+","+this.Atual_Y+"]");
		        }
					}
				System.out.println("");
	}


	public static void main(String[] args){
		int passos = 0;
		Random r = new Random();
		Selvagem wild;
		Event e1;
		int mapinha[][] = {
			{0,1,1,1,0},
			{1,0,1,1,1},
			{1,1,0,1,1},
			{0,1,0,1,0},
			{0,1,1,1,1}
		};
		Mapa maps = new Mapa(3,3,mapinha);
		Treinador2 mit = new Treinador2("Mit");
		while(passos < 50){
			passos ++;
			wild = new Selvagem ();
			int a, b, c;
			a = r.nextInt(2);
			b = r.nextInt(2);
			c = r.nextInt(4);
			maps.andar(a,b);
			if (maps.terreno[maps.Atual_X][maps.Atual_Y] == 1){
				if(c < 1){
					e1 = new Encontro(0);
					e1.action(mit, wild);
				}
			}
		}
	}
}

class Encontro extends Event{
	public Encontro (int prioridade){
    super(prioridade);
  }
	public void action(Treinador mit, Treinador wild){
		Batalha.executar(mit, wild);
	}
}

class Selvagem extends Treinador{

	public Selvagem() {
		super("Wild");
		this.quantidadePokemon = 1;
		int n;
		Random r = new Random();
		n = r.nextInt(12);

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
