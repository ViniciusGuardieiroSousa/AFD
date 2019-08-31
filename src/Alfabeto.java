import java.util.ArrayList;
import java.util.List;
/*
Essa classe serve para armazenar os simbolos do alfabeto da AFD
Método addElementos serve para adicionar elementos no arryList
Metodo posicaoSimbolo serve para retornar a posição do elemento dentro da arraylist
Metodo qtdElementos retorna a quantidade de elementos no alfabeto
 */

public class Alfabeto {
    private List<String> simbolos = new ArrayList<>();
    public void addElemento(String simbolo){
        this.simbolos.add(simbolo);
    }
    public int posicaoSimbolo(String simbolo){
        return simbolos.indexOf(simbolo);
    }
    public int qtdElementos(){
        return this.simbolos.size();
    }

}
