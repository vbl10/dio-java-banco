public class TransacaoAplicacao extends Transacao {
    
    public final InfoAplicacao info;

    public TransacaoAplicacao(double saldo, double valor, InfoAplicacao info)
    {
        super(saldo, valor, "Aplicação " + info.nome);
        this.info = info;
    }

    @Override
    public void imprimir()
    {
        super.imprimir();
        System.out.printf("%s\n", info.nome);
    }
}
