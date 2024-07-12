public class Aplicacao {
    public final InfoAplicacao info;
    public double montante;
    
    public Aplicacao(InfoAplicacao info, double montante)
    {
        this.info = info;
        this.montante = montante;
    }

    public void render()
    {
        montante *= 1 + info.rendimento;
    }
}
