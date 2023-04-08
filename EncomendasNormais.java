public class EncomendasNormais extends Encomendas{
    public float calculaFrete(float peso, float valorFreteEN){
        float valorFrete = peso * valorFreteEN;
        return valorFrete;
    }
}
