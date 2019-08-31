import java.util.ArrayList;
/*
    Essa classe configura o AFD e calcula o percurso e verifica se a cadeia faz parte da linguagem
    o método lerArquivo serve para ler o arquivo base.txt que contem o afd
    o método configuraAFD serve para setar os atributos da classe, ele é feito com base no arquivo txt
    o método percursoNoAFD serve para calcular o percurso
    o método pertenceAoAFD serve para ter certeza de que a cadeia pertence a linguagem

 */
public class AFD {
    private Estados conjuntoDeEstados = new Estados(),  conjuntoEstadosFinais = new Estados(); //armazenam os estados
    private int estadoInicial;
    private Alfabeto alfabetoAFD = new Alfabeto();
    private Regras regrasAFD;
    private ManipulacaoArquivo manipuladorParaLeitura = new ManipulacaoArquivo();;


    public AFD()throws Exception{
        configuraAFD();
    }


    private ArrayList<String> lerArquivo(){
        ArrayList<String> aux = new ArrayList<String>();
        try{
            aux = manipuladorParaLeitura.lerArquivos("base.txt");
       }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return aux;
    }


    private void configuraAFD() throws Exception{
        int i;
        ArrayList<String> textoEmArquivo = lerArquivo(); // recupera todos os dados do arquivo txt que contem o AFD
        String[] aux;
        //divide cada linha no " "
        String aux1 = textoEmArquivo.get(1);
        aux = aux1.split(" ");


        //adiciona a linha correspondente ao alfabeto no alfabetoAFD
        for(i = 0; i < aux.length;i++){
            alfabetoAFD.addElemento(aux[i]);
        }

        aux1 = textoEmArquivo.get(2);
        aux = aux1.split(" ");
        //adiciona a linha correspondete ao conjunto de estado no conjuntoDeEstados
        for(i = 0; i < aux.length;i++){
            conjuntoDeEstados.addEstado(aux[i]);

        }

        //cria as regras
        this.regrasAFD = new Regras(conjuntoDeEstados.qtdElementos(),alfabetoAFD.qtdElementos() );


        aux1 = textoEmArquivo.get(3);
        aux = aux1.split(" ");
        //laço para configurar as regras
        for(i = 0; i < aux.length;i++){
            //separa cada regra nas suas tres partes, estado, simbolo e saida
            String[] aux2 = aux[i].split(";");

            //adiciona a regra no regrasAFD
            regrasAFD.setRegra(conjuntoDeEstados.posicaoEstado(aux2[0]),alfabetoAFD.posicaoSimbolo(aux2[1]),conjuntoDeEstados.posicaoEstado(aux2[2]));
        }
        //verifica se o afd é valido
        regrasAFD.afdValido();

        //define estado inicial
        aux1 = textoEmArquivo.get(4);
        estadoInicial = conjuntoDeEstados.posicaoEstado(aux1);

        //define conjunto estados finais
        aux1 = textoEmArquivo.get(5);
        aux = aux1.split(" ");

        for(i = 0; i < aux.length;i++){
            conjuntoEstadosFinais.addEstado(aux[i]);
        }

    }


    public Estados percusoNoAFD(String cadeia) {

        Estados percurso = new Estados();
        //adiciona o estado inicial
        percurso.addEstado(conjuntoDeEstados.estadoNaPosicao(estadoInicial));
        //laço que calcula o novo estado do automato
        for(int i = 0; i < cadeia.length();i++){
            int coluna = alfabetoAFD.posicaoSimbolo(new String(String.valueOf(cadeia.charAt(i)))); //pega o valor da coluna correspondente ao símbolo lido
            if(coluna < 0)//garantir que o símbolo é válido
                return null;
            estadoInicial = regrasAFD.estadoResultante(estadoInicial,coluna);
            percurso.addEstado(conjuntoDeEstados.estadoNaPosicao(estadoInicial));
        }
        return percurso;
    }

    //certo
    public Boolean pertenceAoAFD(String ultimoEstado){

        for(int i = 0; i < conjuntoEstadosFinais.qtdElementos();i++){
            if(ultimoEstado.equals(conjuntoEstadosFinais.estadoNaPosicao(i)))
                return true;
        }
        return false;
    }

}
