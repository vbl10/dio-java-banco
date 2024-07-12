
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		ContaPoupanca poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		InfoAplicacao infoAplicacoes[] = {
			new InfoAplicacao("CDB 105%", 0.05),
			new InfoAplicacao("CDB 108%", 0.08),
			new InfoAplicacao("CDB 110%", 0.10)
		};

		poupanca.aplicar(infoAplicacoes[0], 10);
		poupanca.aplicar(infoAplicacoes[1], 20);
		poupanca.aplicar(infoAplicacoes[2], 30);

		poupanca.imprimirAplicacoes();
	}

}
