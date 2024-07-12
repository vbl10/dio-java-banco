public class Transacao {
    public final double valor;
    public final double saldo;
    public final String tipo;
    
    public Transacao(double saldo, double valor, String tipo)
    {
        this.saldo = saldo;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public void imprimir()
    {
        System.out.printf("%s: R$ %.2f | Saldo: R$ %.2f\n", tipo, valor, saldo);
    }
}
