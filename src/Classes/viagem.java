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
 * @author Ângela Magalhães
 */
public class viagem {
    
    private static int id_viagem;
    private static final String caminho = System.getProperty("user.dir")+"\\Viagem";
    private static String aux;
    
    public viagem(){
        criaDiretorio(caminho); 
    }
    
    public void cadastrar(String id_cliente, String id_hospedagem, String dt_chegada, String dt_saida){
        File file = new File(caminho);
        String[] arqs = file.list();
        if(arqs.length > 0){
            int id_aux = Integer.parseInt(arqs[arqs.length-1].substring(0,arqs[arqs.length-1].indexOf("_")));
            id_viagem = id_aux + 1;
        }else{
            id_viagem = 1;
        }
        CriaArquivo(caminho+"\\"+id_viagem+"_"+id_cliente+"_"+id_hospedagem+".txt");
        escreve(caminho+"\\"+id_viagem+"_"+id_cliente+"_"+id_hospedagem+".txt", id_cliente, id_hospedagem, dt_chegada, dt_saida);
    }
    
    private void CriaArquivo(String nome){
        File file = new File(nome);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println("Erro ao criar arquivo! "+ex);
            }
        }
    }
     
    private void criaDiretorio(String diretorio){ 
        File file = new File(diretorio);
        if(!file.exists())
            file.mkdirs();
    }
     
    private void escreve(String arquivo, String id_cliente, String id_hospedagem, String dt_chegada, String dt_saida){
        try{
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("ID_Viagem: "+id_viagem);
            bw.newLine();
            bw.write("ID_Cliente: "+id_cliente);
            bw.newLine();
            bw.write("ID_Hospedagem: "+id_hospedagem);
            bw.newLine();
            bw.write("Data de Chegada: "+dt_chegada);
            bw.newLine();
            bw.write("Data de Saída: "+dt_saida);
            bw.newLine();
            
            bw.close();
            fw.close();
        }catch(IOException e){
            System.err.println(e);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    public ArrayList<String> consulta(String id){
        File diretorio = new File(caminho);
        String[] list = diretorio.list();
        
        int x[] = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            x[i] = Integer.parseInt(list[i].substring(0, list[i].indexOf("_")));
        }
        
        int aux_int = 0;
        String aux_string = null;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] < x[j]) {
                    aux_int = x[i];
                    aux_string = list[i];
                    x[i] = x[j];
                    list[i] = list[j];
                    x[j] = aux_int;
                    list[j] = aux_string;
                }
            }
        }
        
        for (int i=0; i < list.length; i++){
            if(list[i].contains(id+"_")){
                if(!list[i].contains("_"+id+"_")){//pq pode ocorrer de terem ids de cliente igual ao de viagem
                    aux = list[i];
                    break;
                }else if(list[i].contains(id+"_"+id+"_")){
                    aux = list[i];
                    break;
                }
            }
        }//fazer exatamente igual ao autocomplete pegar o conteúdo e não apenas o seu nome de arquivo
        ArrayList <String> lidos = new ArrayList <> ();
        try{
            FileReader fr = new FileReader(caminho+"//"+aux);
            BufferedReader br = new BufferedReader(fr);
            String linha = null;
            
            while((linha = br.readLine()) != null){
                if(!linha.equals("")){
                    lidos.add(linha.substring(linha.indexOf(": ")+2));
                }
            }

            br.close();
            fr.close();
        }catch(Exception e){
            System.err.println(e);
        }   
        return lidos;
    } 
    
    public ArrayList<ArrayList<String>> consultar(){
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        File arquivo = new File(caminho);
        String[] nomes = arquivo.list();
        for (int i = 0; i < nomes.length; i++) {
            arr.add(consulta(nomes[i].substring(0, nomes[i].indexOf("_"))));
        }
        return arr;
    }
} //Fedorentin <3 ^^