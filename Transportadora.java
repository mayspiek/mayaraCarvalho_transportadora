import java.io.*;

public class Transportadora extends Encomendas implements ImportacaoArquivos {
    EncomendasExpressas[] vetEE = new EncomendasExpressas[1000];{
        for(int i = 0; i<vetEE.length; i++){
            vetEE[i] = new EncomendasExpressas();
        }
    }
    EncomendasNormais[] vetEN = new EncomendasNormais[1000];{
        for(int i = 0; i<vetEE.length; i++){
            vetEN[i] = new EncomendasNormais();
        }
    }

    Float valorFreteEE, valorFreteEN;
    private Encomendas e1;
    int tam = 0;
    BufferedReader reader;
    int erro = 1;
    public static void main(String[] args) throws Exception {
        Transportadora tp = new Transportadora();
        tp.reader = new BufferedReader(new InputStreamReader(System.in));
        tp.e1 = new Encomendas();

        System.out.println("Informe o arquivo de configuraçao: ");
        while(tp.erro == 1){
            try {
                String arqConfig = tp.reader.readLine();
                tp.carregarConfiguracoes(arqConfig);
                tp.erro = 0;
            } catch (Exception fileNotFoundException) {
                System.out.println("\n\nArquivo não encontrado. Digite novamente: ");
            }
        }
        tp.menu();

    }

    public void menu() throws Exception{
        int op = 0;
        
        while (op != 4){
            System.out.println("\n----[MENU]----");
            System.out.println("[1]-Importar arquivo de encomendas.");
            System.out.println("[2]-Exibir a lista de encomendas Normais.");
            System.out.println("[3]-Exibir a lista de encomendas Expressas.");
            System.out.println("[4]-Sair.");

            System.out.println("\nEscolha uma opcao: ");
            op = Integer.parseInt(this.reader.readLine());

            switch(op){
                case 1:
                System.out.println("Digite o nome do arquivo para importar(csv apenas): ");
                this.erro = 1;
                while(erro == 1) {
                    try {
                        String arqEntrada = this.reader.readLine();
                        this.importarDados(arqEntrada); 
                        this.erro = 0;
                    } catch (Exception fileNotFoundException) {
                        System.out.println("\n\nArquivo não encontrado. Digite novamente: ");
                    }
                }
                System.out.println("\nImportado com sucesso!\n\n");
                break;
                
                case 2:
                    imprimeEN();
                break;
                case 3:
                    imprimeEE();
                break;

            }


        }
    }

    public void imprimeEN(){
        System.out.println("-----[ENCOMENDAS NORMAIS]-----");
        System.out.println("Nro do pedido; Peso; Valor do frete");
        for(int a =0; a < tam ;a++){
            if(this.vetEN[a].getSigla() != null){
                System.out.println(this.vetEN[a].getNroPedido() + ";" +
                                this.vetEN[a].getPeso() + ";" +
                                this.vetEN[a].calculaFrete(this.vetEN[a].getPeso(), 
                                this.valorFreteEN));

            }
    }
}

    public void imprimeEE(){
        System.out.println("------[ENCOMENDAS EXPRESSAS]-----");
        System.out.println("Nro do pedido; Peso; Valor do frete");
        for(int a = 0; a < tam ;a++){
            if (this.vetEE[a].getSigla() != null) {
                System.out.println(this.vetEE[a].getNroPedido() + ";" 
                                + this.vetEE[a].getPeso() + ";" 
                                + this.vetEE[a].calculaFrete(this.vetEE[a].getPeso(),  
                                this.valorFreteEE, 
                                this.vetEE[a].getPrazoEntrega()));
            }
        }
    }
    
    @Override
    public void carregarConfiguracoes(String arqConfig) throws IOException {
        BufferedReader arqLeitura = new BufferedReader(
            new FileReader(arqConfig));
            int i = 1;
        String linhas;
        boolean primeiralinha = true;
        while ((linhas = arqLeitura.readLine()) != null || i==2) {
            String[] arrayValores = linhas.split(";");
            if (primeiralinha) {
                primeiralinha = false;
                continue;
            }
            if (i == 1) {
                this.e1.setSigla(arrayValores[1]);
                valorFreteEN = Float.parseFloat(arrayValores[2]);
                i++;
            } else if (i == 2){
                this.e1.setSigla(arrayValores[1]);
                valorFreteEE = Float.parseFloat(arrayValores[2]);
                this.e1.setValorFrete(valorFreteEE);
                i++;
            }
        }
        arqLeitura.close();
    }
    
    @Override
    public void importarDados(String arqEntrada) throws IOException {
        // traz os dados cadastrados no csv
        BufferedReader arqLeitura = new BufferedReader(
            new FileReader(arqEntrada));

        String linha;
        boolean primeiraLinha = true;
        while ((linha = arqLeitura.readLine()) != null) {
        String[] arrayValores = linha.split(";");
            if(primeiraLinha){
                primeiraLinha=false;
                continue; 
            }

            if(arrayValores[2].equals("EN")){
                vetEN[tam].setNroPedido(Integer.parseInt(arrayValores[0]));
                vetEN[tam].setDtPostagem(arrayValores[1]);
                vetEN[tam].setSigla(arrayValores[2]);
                vetEN[tam].setPeso(Float.parseFloat(arrayValores[4]));
                tam++;
            }

            if(arrayValores[2].equals("EE")){
                vetEE[tam].setNroPedido(Integer.parseInt(arrayValores[0]));
                vetEE[tam].setDtPostagem(arrayValores[1]);
                vetEE[tam].setSigla(arrayValores[2]);
                vetEE[tam].setPrazoEntrega(Integer.parseInt(arrayValores[3]));
                vetEE[tam].setPeso(Float.parseFloat(arrayValores[4]));
                vetEE[tam].setTelefone(arrayValores[5]);
                tam++;
            }
        }
    arqLeitura.close();
    }
}
