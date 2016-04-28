package exercicio1;

abstract class Pokemon {

	String nome;
	int maxHP,atualHP;
	int tipo;
	Ataque[] ataques = new Ataque[4];
	static final int NORMAL=0,FIRE=1,WATER=2,ELETRIC=3,GRASS=4,FIGHTING=5,FLYING=6,PSYCHIC=7;

	public Pokemon(String nome, int HP, int tipo){

		this.nome = nome;
		this.maxHP = HP;
		atualHP = maxHP;
		this.tipo = tipo;
		
	}
	
	public void cura(){
		System.out.println(nome+" usou cura e aumentou em 20 sua HP!");
		atualHP += 20;
		if(atualHP > maxHP){
			atualHP = maxHP;
		}
	}
	
	public void ferido(int dano){
		atualHP -= dano;
		if(atualHP < 0){
			atualHP = 0;
		}
	}

	public void imprimeVida() {
		System.out.println(nome+" esta com "+atualHP+" de HP!");
	}

}

class Ataque {

	String nome;
	int tipo;
	int dano;

	public Ataque(String nome, int tipo, int dano){

		this.nome = nome;
		this.tipo = tipo;
		this.dano = dano;
		this.dano = dano/5;

	}
}

class Bulbasaur extends Pokemon {

	public Bulbasaur(String nome){

		super(nome,45,GRASS);
		ataques[0] = new Ataque("Tackle",NORMAL,50);
		ataques[1] = new Ataque("Vine Whip",GRASS,45);
		ataques[2] = new Ataque("Razor Leaf",GRASS,55);
		ataques[3] = new Ataque("Seed Bomb",GRASS,80);

	}

}

class Snorlax extends Pokemon {

	public Snorlax(String nome){

		super(nome,160,NORMAL);
		ataques[0] = new Ataque("Tackle",NORMAL,50);
		ataques[1] = new Ataque("Giga Impact",NORMAL,150);
		ataques[2] = new Ataque("Fire Blast",FIRE,110);
		ataques[3] = new Ataque("Thunder",ELETRIC,110);
	}
}

class Mewtwo extends Pokemon {

	public Mewtwo(String nome){

		super(nome,106,PSYCHIC);
		ataques[0] = new Ataque("Psychic",PSYCHIC,90);
		ataques[1] = new Ataque("Psystrike",PSYCHIC,100);
		ataques[2] = new Ataque("Hyper Beam",NORMAL,150);
		ataques[3] = new Ataque("Energy Ball",GRASS,90);
	}
}

class Pikachu extends Pokemon {

	public Pikachu(String nome){

		super(nome,35,ELETRIC);
		ataques[0] = new Ataque("Thunder",ELETRIC,110);
		ataques[1] = new Ataque("Thunder Shock",ELETRIC,40);
		ataques[2] = new Ataque("Brick Break",FIGHTING,75);
		ataques[3] = new Ataque("Slam",NORMAL,80);

	}
}

class Butterfree extends Pokemon {

	public Butterfree(String nome){

		super(nome,60,NORMAL);
		ataques[0] = new Ataque("Psybeam",PSYCHIC,65);
		ataques[1] = new Ataque("Bug Buzz",NORMAL,90);
		ataques[2] = new Ataque("Aerial Ace",FLYING,60);
		ataques[3] = new Ataque("Giga Impact",NORMAL,150);

	}
}

class Pidgeot extends Pokemon {

	public Pidgeot(String nome){

		super(nome,83,FLYING);
		ataques[0] = new Ataque("Hurricane",FLYING,110);
		ataques[1] = new Ataque("Quick Attack",NORMAL,40);
		ataques[2] = new Ataque("Aerial Ace",FLYING,60);
		ataques[3] = new Ataque("Giga Impact",NORMAL,150);

	}
}

class Hitmonchan extends Pokemon {

	public Hitmonchan(String nome){

		super(nome,50,FIGHTING);
		ataques[0] = new Ataque("Mach Punch",FIGHTING,40);
		ataques[1] = new Ataque("Fire Punch",FIRE,75);
		ataques[2] = new Ataque("Brick Break",FIGHTING,75);
		ataques[3] = new Ataque("Mega Punch",NORMAL,120);

	}
}

class Charizard extends Pokemon {

	public Charizard(String nome){

		super(nome,78,FIRE);
		ataques[0] = new Ataque("Aerial Ace",FLYING,60);
		ataques[1] = new Ataque("Fire Punch",FIRE,75);
		ataques[2] = new Ataque("Fire Blast",FIRE,110);
		ataques[3] = new Ataque("Giga Impact",NORMAL,150);

	}
}

class Wartortle extends Pokemon {

	public Wartortle(String nome){

		super(nome,59,WATER);
		ataques[0] = new Ataque("Tackle",NORMAL,50);
		ataques[1] = new Ataque("Water Gun",WATER,40);
		ataques[2] = new Ataque("Hydro Pump",WATER,110);
		ataques[3] = new Ataque("Brick Break",FIGHTING,75);

	}
}

class Jigglypuff extends Pokemon {

	public Jigglypuff(String nome){

		super(nome,115,NORMAL);
		ataques[0] = new Ataque("Hyper Voice",NORMAL,90);
		ataques[1] = new Ataque("Fire Punch",FIRE,75);
		ataques[2] = new Ataque("Wake-Up Slap",FIGHTING,70);
		ataques[3] = new Ataque("Water Pulse",WATER,60);
	}
}

class Meowth extends Pokemon {

	public Meowth(String nome){

		super(nome,40,NORMAL);
		ataques[0] = new Ataque("Hyper Voice",NORMAL,90);
		ataques[1] = new Ataque("Slash",NORMAL,70);
		ataques[2] = new Ataque("Last Resort",NORMAL,140);
		ataques[3] = new Ataque("Water Pulse",WATER,60);
	}
}

class Lapras extends Pokemon {

	public Lapras(String nome){

		super(nome,130,NORMAL);
		ataques[0] = new Ataque("Hyper Beam",NORMAL,150);
		ataques[1] = new Ataque("Psychic",PSYCHIC,90);
		ataques[2] = new Ataque("Hydro Pump",WATER,110);
		ataques[3] = new Ataque("Thunder",ELETRIC,110);
	}
}
