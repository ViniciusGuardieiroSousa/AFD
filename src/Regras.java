/*
Regras ela define as regras, implementada na forma de tabela de transição
construtor cria a tabela conforme qtd de elementos do alfabeto e do conjunto de estados
metodo set regras serve para adicionar as regras
metodo estadoresultante serve para verificar qual o estado ao olhar a linha e coluna
 */

public class Regras {
    private int[][] tabelaDeRegras;
    public Regras(int qtdEstados, int qtdSimbolos){
        this.tabelaDeRegras =new int[qtdEstados][qtdSimbolos];

        for(int i = 0; i<qtdEstados;i++){
            for(int j = 0; j <qtdSimbolos;j++){
                this.tabelaDeRegras[i][j] = -1;
            }
        }
    }
    public void setRegra(int estado, int simbolo,int estadoResultante){
        this.tabelaDeRegras[estado][simbolo] = estadoResultante;
    }
    public int estadoResultante(int estado, int simbolo){
        return this.tabelaDeRegras[estado][simbolo];
    }
    public void afdValido() throws Exception{
        for(int i = 0; i <tabelaDeRegras.length;i++){
            for(int j = 0; j <tabelaDeRegras[i].length;j++){
                if(tabelaDeRegras[i][j]==-1) throw new Exception("AFD Invalido");
            }
        }

    }


}
