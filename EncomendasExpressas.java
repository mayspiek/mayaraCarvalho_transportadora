public class EncomendasExpressas extends Encomendas {
    private String dtPostagem;
    private int prazoEntrega;
    private String telefone;
    
    public float calculaFrete(float peso, float valorPorKg, Integer diasPEntrega) {
        if(diasPEntrega < 3){
            float valorFrete = peso * valorPorKg;
            return valorFrete + (valorFrete * 0.025f);
        } else {
            return peso * valorPorKg;
        }
    }

    public String getDtPostagem() {
        return dtPostagem;
    }

    public void setDtPostagem(String dtPostagem) {
        this.dtPostagem = dtPostagem;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
}
