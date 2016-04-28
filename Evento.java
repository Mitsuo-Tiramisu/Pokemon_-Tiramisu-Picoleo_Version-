abstract public class Evento {
	public int prioridade;
	protected Treinador ator;
	protected Treinador alvo;
	public String tipo;
	abstract public void executar();
}
