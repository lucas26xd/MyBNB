package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @Autor Lucas Santos dia 03/07/2016 às 17:33:58
 */
public class Geral {
    
    private final String caminho = System.getProperty("user.dir");
    
    public void remover(String pasta, String id){
        String aux = pega_nome_arquivo(pasta, id);
        File file = new File(caminho+"\\"+pasta+"\\"+aux);
        file.delete();//não funciona pq tem alguma stream do arquivo aberta
    }
    
    public void removerViagem_Hospedagem(String id_hospedagem){//destinado apenas para edição e remoção da hospedagem
        try{
            File file = new File(caminho+"\\Viagem");
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                if(list[i].contains("_"+id_hospedagem)){
                    if(!list[i].contains("_"+id_hospedagem+"_")){//pq pode ocorrer de terem ids de cliente igual ao de hospedagem
                        file = new File(caminho+"\\Viagem\\"+list[i]);
                        file.delete();
                    }else if(list[i].contains("_"+id_hospedagem+"_"+id_hospedagem)){
                        file = new File(caminho+"\\Viagem\\"+list[i]);
                        file.delete();
                    }
                }
            }
        }catch(NullPointerException e){
            System.err.println("Erro ao pegar dados da pasta viagens: "+e);
        }
    }
    
    public void removerViagem_Cliente(String id_cliente){
        try{
            File file = new File(caminho+"\\Viagem");
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                if(list[i].contains("_"+id_cliente+"_")){
                    file = new File(caminho+"\\Viagem\\"+list[i]);
                    file.delete();
                }
            }
        }catch(NullPointerException e){
            System.err.println("Erro ao pegar dados da pasta viagens: "+e);
        }
    }
    
    public void editar(String pasta, String id, String[] valores, String nome_arq){
        //String aux = pega_nome_arquivo(pasta, id);
        String[] parametros = new String[]{"ID:<",">","ESTADO:<",">","CIDADE:<",">","END:<",">","PRECO:<",">"};
        if(pasta.equals("Viagem"))
            parametros = new String[]{"ID_Viagem: ","","ID_Cliente: ","","ID_Hospedagem: ","","Data de Chegada: ","","Data de Saída: ",""};
        else if(pasta.equals("Clientes"))
            parametros = new String[]{"ID: ","","Cliente: ","","Cidade: ","","Estado: ","","Forma de pagamento: ",""};
        remover(pasta, id);
        CriaArquivo(caminho+"\\"+pasta+"\\"+nome_arq+".txt");
        escreve(caminho+"\\"+pasta+"\\"+nome_arq+".txt", parametros, valores);
        //File file = new File(caminho+"\\"+pasta+"\\"+aux);
        //file.renameTo(new File(caminho+"\\"+pasta+"\\"+nome_arq+".txt"));
    }
    
    private void escreve(String url, String[] parametros, String[] valores){
        try{
            FileWriter fw = new FileWriter(url, false);
            BufferedWriter bw = new BufferedWriter(fw);
            int cont = 0;
            for (int i = 0; i < valores.length; i++) {
                bw.write(parametros[cont]+valores[i]+parametros[++cont]);
                cont++;
                if(!url.contains("Hospedagem"))
                    bw.newLine();
            }
            
            bw.close();
            fw.close();
        }catch(IOException e){
            System.err.println(e);
        }catch(Exception e){
            System.err.println(e);
        }
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
    
    private String pega_nome_arquivo(String pasta, String id){
        File file = new File(caminho+"\\"+pasta);
        String[] list = file.list();
        String aux = "";
        Arrays.sort(list);
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
        }
        return aux;
    }
    
    public String pega_Data(){
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }//retorna a data atual
    
    public String pega_Hora(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }//retorna a data atual
}