public class TransacaoTransferencia extends Transacao {

    final Conta de, para;

    public TransacaoTransferencia(double saldo, double valor, Conta de, Conta para)
    {
        super(saldo, valor, "Transferência");
        this.de = de;
        this.para = para;
    }

    @Override
    public void imprimir()
    {
        super.imprimir();
        System.out.printf("%s -> %s\n", de.cliente.getNome(), para.cliente.getNome());
    }
}
