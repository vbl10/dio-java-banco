import java.util.ArrayList;

public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	public ArrayList<Transacao> transacoes = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public void sacar(double valor) {
		saldo -= valor;
		transacoes.add(new Transacao(saldo, valor, "Saque"));
	}

	public void depositar(double valor) {
		saldo += valor;
		transacoes.add(new Transacao(saldo, valor, "Depósito"));
	}

	public void transferir(double valor, Conta contaDestino) {
		saldo -= valor;
		contaDestino.depositar(valor);
		transacoes.add(new TransacaoTransferencia(saldo, valor, this, contaDestino));
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void imprimirInfo()
	{
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public void imprimirExtrato() {
		imprimirInfo();
		System.out.println("\nTransações: ");
		for (int i = 0; i < transacoes.size(); i++)
			transacoes.get(i).imprimir();
	}
}
