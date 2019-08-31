import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ManipulacaoArquivo {
    public void salvarArquivos(String path, String serSalvo)throws IOException{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,true));
        buffWrite.append(serSalvo);
        buffWrite.close();

    }
    public ArrayList<String> lerArquivos(String path) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> linhas1 = new ArrayList<String>();
        String linha = "";
        while (true) {
            if (linha != null) {
                linhas1.add(linha);

            } else
                break;
            linha = br.readLine();
        }
        br.close();
        return linhas1;
    }
}
