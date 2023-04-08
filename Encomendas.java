public class Encomendas {
    private float peso;
    private int nroPedido;
    private String dtPostagem;
    private float valorFrete;
    private int qtdeEncomendas;
    private String sigla;


    public int getQtdeEncomendas() {
        return qtdeEncomendas;
    }



    public void setQtdeEncomendas(int qtdeEncomendas) {
        this.qtdeEncomendas = qtdeEncomendas;
    }



    public String getSigla() {
        return sigla;
    }



    public void setSigla(String sigla) {
        this.sigla = sigla;
    }



    public float getPeso() {

        return peso;
    }
    public void setPeso(float peso) {

        this.peso = peso;
    }
    public Integer getNroPedido() {

        return nroPedido;
    }
    public void setNroPedido(Integer nroPedido) {

        this.nroPedido = nroPedido;
    }
    public String getDtPostagem() {

        return dtPostagem;
    }
    public void setDtPostagem(String dtPostagem) {

        this.dtPostagem = dtPostagem;
    }
    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {

        this.valorFrete = valorFrete;
    }

}
