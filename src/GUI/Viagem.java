package GUI;

import Classes.AutoComplete;
import Classes.Geral;
import Classes.viagem;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @Autor Lucas Santos dia 03/07/2016 às 01:25:51
 */
public class Viagem extends javax.swing.JFrame {

    private viagem viagem;
    private String id;
    
    public Viagem() {
        initComponents();
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        new AutoComplete(cb_cliente, "Clientes");
        new AutoComplete(cb_hotel, "Hospedagem");
        viagem = new viagem();
        povoa_tabela();
        setIcon();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/travel.png")));
    }
    
    private void povoa_tabela(){
        jt.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        jt.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        jt.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        jt.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        ArrayList<ArrayList<String>> arr = viagem.consultar();
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        
        for (int i = 0; i < arr.size(); i++) {
            if(!arr.get(i).isEmpty()){
                Object[] o = new Object[]{arr.get(i).get(0), pega_cliente(arr.get(i).get(1)), pega_hospedagem(arr.get(i).get(2)), arr.get(i).get(3), arr.get(i).get(4)};
                mod.addRow(o);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abas = new javax.swing.JTabbedPane();
        principal = new javax.swing.JPanel();
        btn_cadastrar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cb_cliente = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cb_hotel = new javax.swing.JComboBox();
        tf_data_chegada = new javax.swing.JFormattedTextField();
        tf_data_saida = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Viagens");
        setResizable(false);

        principal.setBackground(new java.awt.Color(255, 255, 255));

        btn_cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ok.png"))); // NOI18N
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setToolTipText("Confirmar cadastro");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        btn_remover.setBackground(new java.awt.Color(255, 255, 255));
        btn_remover.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btn_remover.setText("Remover");
        btn_remover.setToolTipText("Remover esta viagem");
        btn_remover.setEnabled(false);
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/volta.png"))); // NOI18N
        btn_voltar.setText("Voltar");
        btn_voltar.setToolTipText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        cb_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hotel em:");

        cb_hotel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tf_data_chegada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "     Data de chegada:     ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        try {
            tf_data_chegada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_data_chegada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_data_chegada.setToolTipText("Data de chegada");
        tf_data_chegada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tf_data_saida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "     Data de saída:     ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        try {
            tf_data_saida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_data_saida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_data_saida.setToolTipText("Data de saída");
        tf_data_saida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_voltar)
                .addGap(0, 105, Short.MAX_VALUE)
                .addComponent(btn_remover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cadastrar)
                .addContainerGap())
            .addGroup(principalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_data_chegada)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(cb_cliente, 0, 370, Short.MAX_VALUE)
                    .addComponent(cb_hotel, 0, 370, Short.MAX_VALUE)
                    .addComponent(tf_data_saida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_hotel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_data_chegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_data_saida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        abas.addTab("Viagem", principal);

        jt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Hotel em", "Data de chegada", "Data de saída"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt);

        abas.addTab("Consultar", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        if(tf_data_chegada.getText().length() > 0 && tf_data_saida.getText().length() > 0 && cb_cliente.getSelectedIndex() != -1 && cb_hotel.getSelectedIndex() != -1){
            if(btn_cadastrar.getText().equals("Cadastrar")){    
                viagem.cadastrar(pega_id_cliente(), pega_id_hospedagem(), tf_data_chegada.getText(), tf_data_saida.getText());
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastrado",JOptionPane.INFORMATION_MESSAGE);
            }else{//editar
                if(JOptionPane.showConfirmDialog(null, "Deseja salvar as alterções?", "Editar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                    new Geral().editar("Viagem", id, new String[]{id, pega_id_cliente(), pega_id_hospedagem(), tf_data_chegada.getText(), tf_data_saida.getText()}, id+"_"+pega_id_cliente()+"_"+pega_id_hospedagem());
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Alterado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else
            JOptionPane.showMessageDialog(null, "Por favor forneça todos os campos!","Falta informações",JOptionPane.WARNING_MESSAGE);
        limpar();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        if(btn_voltar.getText().equals("Cancelar"))
            limpar();
        else
            dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
        if(evt.getClickCount() == 2){
            abas.setSelectedIndex(0);
            cb_cliente.setSelectedItem(jt.getValueAt(jt.getSelectedRow(), 1));
            cb_hotel.setSelectedItem(jt.getValueAt(jt.getSelectedRow(), 2));
            tf_data_chegada.setText(jt.getValueAt(jt.getSelectedRow(), 3)+"");
            tf_data_saida.setText(jt.getValueAt(jt.getSelectedRow(), 4)+"");
            btn_cadastrar.setText("Editar");
            btn_voltar.setText("Cancelar");
            btn_remover.setEnabled(true);
            btn_cadastrar.setToolTipText("Confirmar edição");
            btn_remover.setToolTipText("Remover esta viagem");
            btn_voltar.setToolTipText("Cancelar edição");
            btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limp.png")));
            id = jt.getValueAt(jt.getSelectedRow(), 0)+"";
        }
    }//GEN-LAST:event_jtMouseClicked

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente remover este registro?", "Remover?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
            new Geral().remover("Viagem", id);
            limpar();
        }
    }//GEN-LAST:event_btn_removerActionPerformed

    private void limpar(){
        tf_data_chegada.setText("");
        tf_data_saida.setText("");
        cb_cliente.setSelectedIndex(-1);
        cb_hotel.setSelectedIndex(-1);
        povoa_tabela();
        btn_cadastrar.setText("Cadastrar");
        btn_voltar.setText("Voltar");
        btn_remover.setEnabled(false);
        btn_cadastrar.setToolTipText("Confirmar cadastro");
        btn_remover.setToolTipText(null);
        btn_voltar.setToolTipText("Voltar");
        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/volta.png")));
    }
    
    private String pega_id_cliente(){
        File f = new File(System.getProperty("user.dir")+"\\Clientes");
        String list[] = f.list(), id = null;
        for (int i = 0; i < list.length; i++) {
            if(list[i].contains(cb_cliente.getSelectedItem()+"")){
                id = list[i].substring(0, list[cb_cliente.getSelectedIndex()].indexOf("_"));
                break;
            }
        }
        return id;
    }
    
    private String pega_id_hospedagem(){
        File f = new File(System.getProperty("user.dir")+"\\Hospedagem");
        String list[] = f.list(), id = null;
        for (int i = 0; i < list.length; i++) {
            if(list[i].contains(cb_hotel.getSelectedItem()+"")){
                id = list[i].substring(0, list[cb_hotel.getSelectedIndex()].indexOf("_"));
                break;
            }
        }
        return id;
    }
    
    private String pega_cliente(String id){
        File f = new File(System.getProperty("user.dir")+"\\Clientes");
        String list[] = f.list(), x = "";
        for (int i = 0; i < list.length; i++) {
            if(list[i].contains(id+"_")){
                x = list[i];
                break;
            }
        }
        x = x.substring(x.indexOf("_")+1);
        return x.substring(0, x.length()-4);
    }
    
    private String pega_hospedagem(String id){
        File f = new File(System.getProperty("user.dir")+"\\Hospedagem");
        String list[] = f.list(), x = "";
        for (int i = 0; i < list.length; i++) {
            if(list[i].contains(id+"_")){
                x = list[i];
                break;
            }
        }
        x = x.substring(x.indexOf("_")+1);
        return x.substring(0, x.length()-4);
    }
    
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Viagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.JComboBox cb_hotel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JPanel principal;
    private javax.swing.JFormattedTextField tf_data_chegada;
    private javax.swing.JFormattedTextField tf_data_saida;
    // End of variables declaration//GEN-END:variables
}