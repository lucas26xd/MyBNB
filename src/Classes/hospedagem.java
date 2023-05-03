package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hugo
 */
public class hospedagem {

    private final String url_pasta = System.getProperty("user.dir") + "\\Hospedagem";
    private File pasta;
    private int id;

    public hospedagem(){
        pasta = new File(url_pasta);
        if (!pasta.exists()) {
            pasta.mkdir();
            id = 1;
        }
    }
    
    public void cadastrar(String cidade, String end, String preco, String estado){
        String[] filevet = pasta.list();
        if(pasta.list().length > 0){
            int x[] = new int[filevet.length];
            for (int i = 0; i < filevet.length; i++) {
                x[i] = Integer.parseInt(filevet[i].substring(0, filevet[i].indexOf("_")));
            }
            Arrays.sort(x);
            id = x[x.length - 1];
            id++;
        }else
            id = 1;
        
        try{
            String nome_arq = id + "_" + cidade;
            File arquivo = new File(url_pasta + "\\" + nome_arq + ".txt");
            arquivo.createNewFile();
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("ID:<" + id + ">ESTADO:<" + estado + ">CIDADE:<" + cidade + ">END:<" + end + ">PRECO:<" + preco + ">\n");
            bw.close();
            fw.close();
        }catch(IOException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public ArrayList<String> consultar(String id) {
        ArrayList<String> array_da_linha = new ArrayList<>();
        String url_arquivo = url_pasta;
        pasta = new File(url_pasta);
        String[] nomes = pasta.list();

        int x[] = new int[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            x[i] = Integer.parseInt(nomes[i].substring(0, nomes[i].indexOf("_")));
        }

        int aux_int = 0;
        String aux_string = null;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] < x[j]) {
                    aux_int = x[i];
                    aux_string = nomes[i];
                    x[i] = x[j];
                    nomes[i] = nomes[j];
                    x[j] = aux_int;
                    nomes[j] = aux_string;
                }
            }
        }
        
        /*ordena o vetor para poder pesquisar o id escolhido, por exemplo, se não estiver ordenado, se o usuario pesquisa-se o id 2,
        ele ia pega o primeiro que tivesse "2_" no nome do arquivo, se tivese mais de 12 arquivos, ele iria pegar
        o arquivo de id 12 que tem: "12_", que estava antes do arquivo 2, que é o que queremos*/
        
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].contains(id + "_")) {
                url_arquivo += "\\" + nomes[i];
                break;
            }
        }
        
        try {
            FileReader lerFR = new FileReader(url_arquivo);
            BufferedReader lerBR = new BufferedReader(lerFR);
            String linha;
            
            while ((linha = lerBR.readLine()) != null) {
                linha = linha.substring(linha.indexOf("<")+1);
                array_da_linha.add(linha.substring(0, linha.indexOf(">")));
                linha = linha.substring(linha.indexOf("<")+1);
                array_da_linha.add(linha.substring(0, linha.indexOf(">")));
                linha = linha.substring(linha.indexOf("<")+1);
                array_da_linha.add(linha.substring(0, linha.indexOf(">")));
                linha = linha.substring(linha.indexOf("<")+1);
                array_da_linha.add(linha.substring(0, linha.indexOf(">")));
                linha = linha.substring(linha.indexOf("<")+1);
                array_da_linha.add(linha.substring(0, linha.indexOf(">")));
            }
            lerBR.close();
            lerBR.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return array_da_linha;
    }

    public ArrayList<ArrayList<String>> consultar() {
        ArrayList<ArrayList<String>> array_de_arrays = new ArrayList<>();
        String[] nomes = pasta.list();
        for (int i = 0; i < nomes.length; i++) {
            array_de_arrays.add(consultar(nomes[i].substring(0, nomes[i].indexOf("_"))));
        }
        return array_de_arrays;
    }
}