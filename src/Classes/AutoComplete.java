package Classes;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import ca.odell.glazedlists.swing.EventComboBoxModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Lucas
 */

public class AutoComplete {
    
    private SortedList<String> lista = new SortedList<>(new BasicEventList<>());
    private ArrayList<String> dados  = new ArrayList<>(new BasicEventList<String>());
    private EventComboBoxModel<String> modelo = new EventComboBoxModel<>(lista);
    
    private final String caminho = System.getProperty("user.dir")+"\\Cidades";
    
    public AutoComplete(){}
    
    public AutoComplete(JComboBox cb){//retorna um autocomplete com os estados do Brasil
        cb.setModel(modelo);
        AutoCompleteSupport.install(cb, lista);
        File file = new File(caminho);
        String[] arqs = file.list();
        povoa(RetiraExtesao(arqs));
    }
    
    public AutoComplete(JComboBox cb, String pasta){//retorna um autocomplete com as hospedagens disponíveis ou clientes criados
        cb.setModel(modelo);
        AutoCompleteSupport.install(cb, lista);
        File file = new File(System.getProperty("user.dir")+"\\"+pasta);
        String[] arqs = file.list();
        for (int i = 0; i < arqs.length; i++) {
            try {
                FileReader ler = new FileReader(System.getProperty("user.dir")+"\\"+pasta+"\\"+arqs[i]);
                BufferedReader lerb = new BufferedReader(ler);        
                String linha;
                int cont = 1;
                while((linha = lerb.readLine()) != null){
                    if(pasta.equals("Clientes")){
                        if(cont == 2){
                            arqs[i] = linha.substring(linha.indexOf(": ")+2)+"....";
                            break;
                        }
                        cont++;
                    }else{
                        if(!linha.equals("")){
                            linha = linha.substring(linha.indexOf("CIDADE:<")+8);
                            arqs[i] = linha.substring(0, linha.indexOf(">E"))+"....";
                            break;
                        }
                    }
                }
                lerb.close();
                ler.close();
            }catch(IOException e){
                System.out.println(e.getMessage());           
            }
        }
        povoar(RetiraExtesao(arqs));
    }
    
    public void setAutoComplete(JComboBox cb){
        cb.setModel(modelo);
        AutoCompleteSupport.install(cb, lista);
    }
    
    public void setAutoComplete(String nome, boolean limpar){
        if(limpar)
            lista.clear();
        povoa(Ler(caminho+"\\"+nome));
    }
    
    private void povoa(ArrayList<String> list){
        dados = list;
        for (int i = 0; i < dados.size(); i++) {
            lista.add(dados.get(i));
        }
    }
    
    private void povoar(ArrayList<String> list){
        dados = list;
        for (int i = 0; i < dados.size(); i++) {
            lista.add(dados.get(i).substring(dados.get(i).indexOf("_")+1));
        }
    }
    
    private ArrayList<String> Ler(String url){
        ArrayList<String> list = new ArrayList<>();
        try{
            File arq = new File(url);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));//isso tudo é apenas pra considerar os acentos na hora da leitura
            String linha;                      
            while((linha = leitor.readLine()) != null){
                list.add(linha);
            }
            leitor.close();         
        }catch(Exception e){
            System.err.println(e);
        }   
        return list;
    }
    
    private ArrayList<String> RetiraExtesao(String[] arqs){
        ArrayList<String> arquivos = new ArrayList<>();
        for (int i = 0; i < arqs.length; i++) {
            arquivos.add(arqs[i].substring(0, arqs[i].length()-4));
        }
        return arquivos;
    }
}