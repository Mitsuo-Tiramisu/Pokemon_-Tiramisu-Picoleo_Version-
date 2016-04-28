package exercicio2;
import java.awt.Event;
import java.util.Random;

public class Mapa{
	int MAX_X;
	int MAX_Y;
	int Atual_X;
	int Atual_Y;
	int terreno [][];  //0-Comum,  1-Grama
	
	public Mapa(int X, int Y, int mapinha[][]){
		this.MAX_X = X;
		this.MAX_Y = Y;
		for (int i=0;i<X;i++){
			for(int j=0;j<Y;j++){
				this.terreno[i][j] = mapinha[i][j];
			}
		}
	}
	public void andar(int direcao,int sentido){ // 0-X, 1-Y
		if(direcao == 1){
			if(sentido == 1){
				if(Atual_Y<MAX_Y)
					this.Atual_Y++;
			}
			else
				if(Atual_Y>0)
					this.Atual_Y--;
		}
		else{
			if(sentido == 1){
				if(Atual_X<MAX_X)
					this.Atual_X++;
			}
			else
				if(Atual_X>0)
					this.Atual_X--;
		}
	}


	public static void main(String[] args){
		int passos = 0;
		Random r = new Random();
		Selvagem wild;
		int mapinha[][] = {{0,1,0},{1,0,1},{0,1,0}};
		Mapa maps = new Mapa(3,3,mapinha);
		Treinador2 mit = new Treinador2("Mit");
		while(passos < 15){
			passos ++;
			wild = new Selvagem ();
			int a, b, c;
			a = r.nextInt(1);
			b = r.nextInt(1);
			c = r.nextInt(3);
			maps.andar(a,b);
			if (maps.terreno[maps.Atual_X][maps.Atual_Y] == 1){
				if(c < 1){
					Batalha.executar(mit, wild);
				}
			}
		}
	}
}

class Selvagem extends Treinador{

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