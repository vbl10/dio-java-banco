public class TransacaoResgate extends Transacao {
    
    public final InfoAplicacao info;

    public TransacaoResgate(double saldo, double valor, InfoAplicacao info)
    {
        super(saldo, valor, "Resgate " + info.nome);
        this.info = info;
    }

    @Override
    public void imprimir()
    {
        super.imprimir();
        System.out.printf("%s\n", info.nome);
    }
}
