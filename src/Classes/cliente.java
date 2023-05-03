package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class cliente {
    
    private final String caminho = System.getProperty("user.dir")+"\\Clientes";
    private File arquivo;
    private int ID;
    
    public cliente(){
        arquivo = new File(caminho);
        if (!arquivo.exists()){
            arquivo.mkdir();
            ID = 1;
        }
    }
    
    public void cadastrar(String nome, String cidade, String estado, String f_pagamento){
        String vetArquivo[] = arquivo.list();
        if (vetArquivo.length == 0){
            ID = 1;
        }else{
            String ultimoArq = vetArquivo[vetArquivo.length - 1];
            String ID_ultimo = ultimoArq.substring(0,ultimoArq.indexOf("_"));
            ID = Integer.parseInt(ID_ultimo) + 1;
        }
        arquivo = new File(caminho+"\\"+ID+"_"+nome+".txt");
        try {
            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo); 
            BufferedWriter escreveb = new BufferedWriter(escrever);
            escreveb.write("ID: "+ID);
            escreveb.newLine();
            escreveb.write("Cliente: "+nome);
            escreveb.newLine();
            escreveb.write("Cidade: "+cidade);
            escreveb.newLine();
            escreveb.write("Estado: "+estado);
            escreveb.newLine();
            escreveb.write("Forma de pagamento: "+f_pagamento);
            escreveb.newLine();
            escreveb.close();
            escrever.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> consultar(String id){
        ArrayList<String> arr = new ArrayList<>();
        String url = caminho;
        arquivo = new File(caminho);
        String[] nomes = arquivo.list();
        
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
        
        for (int i = 0; i < nomes.length; i++) {
            if(nomes[i].contains(id+"_")){
                url += "\\"+nomes[i];
                break;
            }
        }
        try{ 
            FileReader ler = new FileReader(url);
            BufferedReader lerb = new BufferedReader(ler);        
            String linha;
            while((linha = lerb.readLine()) != null){
                if(!linha.equals(""))
                    arr.add(linha.substring(linha.indexOf(": ")+2));
            }
            lerb.close();
            ler.close();
        }catch(IOException e){
            System.out.println(e.getMessage());           
        }
        return arr;
    }
    
    public ArrayList<ArrayList<String>> consultar(){
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        arquivo = new File(caminho);
        String[] nomes = arquivo.list();
        for (int i = 0; i < nomes.length; i++) {
            arr.add(consultar(nomes[i].substring(0, nomes[i].indexOf("_"))));
        }
        return arr;
    }
}    