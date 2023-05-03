package GUI;

import Classes.AutoComplete;
import Classes.Geral;
import Classes.hospedagem;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @Autor Lucas Santos dia 03/07/2016 às 12:04:18
 */
public class Hospedagem extends javax.swing.JFrame {

    private AutoComplete autocomplete;
    private hospedagem hospedagem;
    private String id;
    
    public Hospedagem() {
        initComponents();
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        new AutoComplete(cb_estado);
        autocomplete = new AutoComplete();
        autocomplete.setAutoComplete(cb_cidade);
        hospedagem = new hospedagem();
        povoa_tabela();
        setIcon();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/home.png")));
    }
    
    private void povoa_tabela(){
        jt.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        jt.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        jt.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        jt.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        ArrayList<ArrayList<String>> arr = hospedagem.consultar();
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        for (int i = 0; i < arr.size(); i++) {
            if(!arr.get(i).isEmpty()){
                Object[] o = new Object[arr.get(i).size()];
                for (int j = 0; j < arr.get(i).size(); j++) {
                    o[j] = arr.get(i).get(j);
                }
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
        tf_endereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cb_cidade = new javax.swing.JComboBox();
        tf_preco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Hospedagem");
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
        btn_remover.setToolTipText("Remover esta hospedagem");
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

        tf_endereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_endereco.setToolTipText("Endereço");
        tf_endereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "     Endereco:     ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Estado:");

        cb_estado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_estadoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cidade:");

        cb_cidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tf_preco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_preco.setToolTipText("Preço da hospedagem");
        tf_preco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "     Preço:     ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tf_preco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_precoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_remover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cadastrar)
                .addContainerGap())
            .addGroup(principalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(tf_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        abas.addTab("Hospedagem", principal);

        jt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado", "Cidade", "Endereço", "Preço"
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        if(tf_endereco.getText().length() > 0 && tf_preco.getText().length() > 0 && cb_estado.getSelectedIndex() != -1 && cb_cidade.getSelectedIndex() != -1){
            if(btn_cadastrar.getText().equals("Cadastrar")){
                hospedagem.cadastrar(cb_cidade.getSelectedItem()+"", tf_endereco.getText(), tf_preco.getText(), cb_estado.getSelectedItem()+"");
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
            }else{//editar
                if(JOptionPane.showConfirmDialog(null, "Deseja salvar as alterções?\n(Ao confirmar, você irá desvincular todas as viagens relacionadas com esta hospedagem)", "Editar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                    new Geral().editar("Hospedagem", id, new String[]{id, cb_estado.getSelectedItem()+"", cb_cidade.getSelectedItem()+"", tf_endereco.getText(), tf_preco.getText()}, id+"_"+cb_cidade.getSelectedItem());
                    new Geral().removerViagem_Hospedagem(id);
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Alterado", JOptionPane.INFORMATION_MESSAGE);
                }//referencia só ao primeiro registro OLHAR DEPOIS
            }
        }else
            JOptionPane.showMessageDialog(null, "Por favor forneça todos os campos!", "Falta informações", JOptionPane.WARNING_MESSAGE);
        limpar();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        if(btn_voltar.getText().equals("Cancelar"))
            limpar();
        else
            dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void cb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_estadoActionPerformed
        cb_cidade.setSelectedItem("");
        if(cb_estado.getSelectedItem() != null)
            autocomplete.setAutoComplete(cb_estado.getSelectedItem()+".txt", true);
    }//GEN-LAST:event_cb_estadoActionPerformed

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
        if(evt.getClickCount() == 2){
            abas.setSelectedIndex(0);
            cb_estado.setSelectedItem(jt.getValueAt(jt.getSelectedRow(), 1)+"");
            cb_cidade.setSelectedItem(jt.getValueAt(jt.getSelectedRow(), 2));
            tf_endereco.setText(jt.getValueAt(jt.getSelectedRow(), 3)+"");
            tf_preco.setText(jt.getValueAt(jt.getSelectedRow(), 4)+"");
            btn_cadastrar.setText("Editar");
            btn_voltar.setText("Cancelar");
            btn_remover.setEnabled(true);
            btn_cadastrar.setToolTipText("Confirmar edição");
            btn_remover.setToolTipText("Remover esta hospedagem");
            btn_voltar.setToolTipText("Cancelar edição");
            btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limp.png")));
            id = jt.getValueAt(jt.getSelectedRow(), 0)+"";
        }
    }//GEN-LAST:event_jtMouseClicked

    private void tf_precoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_precoFocusLost
        tf_preco.setText(NumberFormat.getCurrencyInstance().format(converte(tf_preco.getText())));
    }//GEN-LAST:event_tf_precoFocusLost

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente remover este registro?\n(Ao confirmar, você irá desvincular todas as viagens relacionadas com esta hospedagem)", "Remover?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
            new Geral().remover("Hospedagem", id);
            new Geral().removerViagem_Hospedagem(id);
            limpar();
        }
    }//GEN-LAST:event_btn_removerActionPerformed
    
    private void limpar(){
        cb_cidade.setSelectedIndex(-1);
        cb_estado.setSelectedIndex(-1);
        tf_endereco.setText("");
        tf_preco.setText("");
        povoa_tabela();
        btn_cadastrar.setText("Cadastrar");
        btn_voltar.setText("Voltar");
        btn_remover.setEnabled(false);
        btn_cadastrar.setToolTipText("Confirmar cadastro");
        btn_remover.setToolTipText(null);
        btn_voltar.setToolTipText("Voltar");
        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/volta.png")));
    }
    
    private double converte(String s){
        try{
            if(s.length() > 2){
                if(s.charAt(s.length()-2) == '.' || s.charAt(s.length()-3) == '.')
                    s = s.replaceAll("\\.", ",");
            }
            return Double.parseDouble(s.replaceAll("\\.", "").replaceAll(",", "\\.").replaceAll("R\\$ ", ""));
        }catch(Exception e){
            return 0;
        }
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
            java.util.logging.Logger.getLogger(Hospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hospedagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox cb_cidade;
    private javax.swing.JComboBox cb_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JPanel principal;
    private javax.swing.JTextField tf_endereco;
    private javax.swing.JTextField tf_preco;
    // End of variables declaration//GEN-END:variables
}