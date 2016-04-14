abstract class Pokemon {
	
	String nome;
	int HP;
	String tipo1,tipo2;
	Ataque[] ataques = new Ataque[4];
	
	public Pokemon(String nome, int HP, String tipo1, String tipo2){
		
		this.nome = nome;
		this.HP = HP;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}
	
	public Pokemon(String nome, int HP, String tipo1){
		this(nome,HP,tipo1,null);
	}
	
}

class Ataque {
	
	String nome;
	String tipo;
	int dano;
	
	public Ataque(String nome, String tipo, int dano){
		
		this.nome = nome;
		this.tipo = tipo;
		this.dano = dano;
		
	}
}

class Bulbasaur extends Pokemon {
	
	public Bulbasaur(String nome){
		
		super(nome,45,"GRASS","POISON");
		ataques[0] = new Ataque("Tackle","NORMAL",50);
		ataques[1] = new Ataque("Vine Whip","GRASS",45);
		ataques[2] = new Ataque("Razor Leaf","GRASS",55);
		ataques[3] = new Ataque("Seed Bomb","GRASS",80);
		
	}

}

class Snorlax extends Pokemon {
	
	public Snorlax(String nome){
		
		super(nome,160,"NORMAL");
		ataques[0] = new Ataque("Tackle","NORMAL",50);
		ataques[1] = new Ataque("Giga Impact","NORMAL",150);
		ataques[2] = new Ataque("Fire Blast","FIRE",110);
		ataques[3] = new Ataque("Thunder","ELETRIC",110);
	}
}

class Mewtwo extends Pokemon {
	
	public Mewtwo(String nome){
		
		super(nome,106,"PSYCHIC");
		ataques[0] = new Ataque("Psychic","PSYCHIC",90);
		ataques[1] = new Ataque("Psystrike","PSYCHIC",100);
		ataques[2] = new Ataque("Hyper Beam","NORMAL",150);
		ataques[3] = new Ataque("Energy Ball","GRASS",90);
	}
}

class Pikachu extends Pokemon {
	
	public Pikachu(String nome){
		
		super(nome,35,"ELETRIC");
		
		
	}
}
