import java.util.ArrayList;

public class ContaPoupanca extends Conta {

	public ArrayList<Aplicacao> aplicacoes = new ArrayList<>();

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirExtrato();
	}
	
	public void imprimirAplicacoes() {
		System.out.println("=== Aplicações Conta Poupança ===");
		imprimirInfo();

		double totalAplicado = pegarTotalAplicado();

		System.out.printf(
			"""
			Rendimento ao mês: %.2f%%
			Total aplicado:    %.2f
			Aplicações:
			\tNome\tRendimento\tValor Aplicado
			""",
			pegarRendimento() * 100,
			totalAplicado
		);
		
		for (int i = 0; i < aplicacoes.size(); i++)
			System.out.printf(
				"\t%s\t%.2f%%\t%.2f (%.2f%%)\n", 
				aplicacoes.get(i).info.nome, 
				aplicacoes.get(i).info.rendimento * 100, 
				aplicacoes.get(i).montante, 
				aplicacoes.get(i).montante / totalAplicado * 100
			);
	}

	public void aplicar(InfoAplicacao info, double valor)
	{
		if (valor > saldo)
		{
			System.out.println("Saldo insuficiente");
		}
		else
		{
			saldo -= valor;
			aplicacoes.add(new Aplicacao(info, valor));
			transacoes.add(new TransacaoAplicacao(saldo, valor, info));
		}
	}

	public void resgatar(int indiceAplicacao)
	{
		saldo += aplicacoes.get(indiceAplicacao).montante;
		aplicacoes.remove(indiceAplicacao);
		transacoes.add(new TransacaoResgate(saldo, aplicacoes.get(indiceAplicacao).montante, aplicacoes.get(indiceAplicacao).info));
	}

	public void render() {
		for (int i = 0; i < aplicacoes.size(); i++)
			aplicacoes.get(i).render();
	}

	public double pegarTotalAplicado()
	{
		double total = 0;
		for (int i = 0; i < aplicacoes.size(); i++)
			total += aplicacoes.get(i).montante;
		return total;
	}

	public double pegarRendimento()
	{
		double totalAplicado = pegarTotalAplicado();
		double rendimento = 0;
		for (int i = 0; i < aplicacoes.size(); i++)
			rendimento += aplicacoes.get(i).info.rendimento * (aplicacoes.get(i).montante / totalAplicado);
		return rendimento;
	}
}
