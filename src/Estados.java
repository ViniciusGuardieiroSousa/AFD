import java.util.ArrayList;
import java.util.List;
/*
Essa classe representa o conjunto de estados do AFD
o método addEstado serve para adicionar um estado no arraylist
o método posicaoEstado retorna a posição de um estado no arrayList
o método EstadoNaPosição retorna o estado na posição desejada
Metodo qtdElementos retorna a quantidade de elementos no Estado
 */
public class Estados {
    private List<String> estado = new ArrayList<String>();
    public void addEstado(String estado){
        this.estado.add(estado);
    }
    public int posicaoEstado(String estado){
        return this.estado.indexOf(estado);
    }
    public String estadoNaPosicao(int posicao){
        return estado.get(posicao);
    }
    public int qtdElementos(){
        return this.estado.size();
    }
    public String ultimoEstado(){
        return this.estado.get(this.estado.size()-1);
    }
    public void imprimirEstados(){
        for(int i = 0; i < this.estado.size();i++){
            System.out.println(estado.get(i));
        }
    }
}
