abstract public class Evento {
	public int prioridade;
	public Treinador ator;
	public Treinador alvo;
	public String tipo;
	abstract public void executar();
}
