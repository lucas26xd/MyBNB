package GUI;

import Classes.AutoComplete;
import Classes.Geral;
import Classes.cliente;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @Autor Lucas Santos dia 03/07/2016 às 00:44:05
 */
public class Cliente extends javax.swing.JFrame {

    private AutoComplete autocomplete;
    private cliente cliente;
    private String id;
    
    public Cliente() {
        initComponents();
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        new AutoComplete(cb_estado);
        autocomplete = new AutoComplete();
        autocomplete.setAutoComplete(cb_cidade);
        cliente = new cliente();
        povoa_tabela();
        setIcon();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/user.png")));
    }
    
    private void povoa_tabela(){
        jt.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        jt.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        jt.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        jt.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        ArrayList<ArrayList<String>> arr = cliente.consultar();
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        for (int i = 0; i < arr.size(); i++) {
            if(!arr.get(i).isEmpty()){
                Object[] o = new Object[arr.get(i).size()-1];
                for (int j = 0; j < arr.get(i).size()-1; j++) {
                    o[j] = arr.get(i).get(j);
                }
                mod.addRow(o);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        abas = new javax.swing.JTabbedPane();
        principal = new javax.swing.JPanel();
        btn_cadastrar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        tf_nome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tf_outro = new javax.swing.JTextField();
        rb_dinheiro = new javax.swing.JRadioButton();
        rb_outro = new javax.swing.JRadioButton();
        rb_cartao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cb_cidade = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Clientes");
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
        btn_remover.setToolTipText("");
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

        tf_nome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_nome.setToolTipText("Nome");
        tf_nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "     Nome:     ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "   Forma de pagamento:   ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setToolTipText("Forma de pagamento");

        tf_outro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_outro.setEnabled(false);

        rb_dinheiro.setBackground(new java.awt.Color(255, 255, 255));
        grupo.add(rb_dinheiro);
        rb_dinheiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rb_dinheiro.setText("Dinheiro");
        rb_dinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_dinheiroActionPerformed(evt);
            }
        });

        rb_outro.setBackground(new java.awt.Color(255, 255, 255));
        grupo.add(rb_outro);
        rb_outro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rb_outro.setText("Outro:");
        rb_outro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_outroActionPerformed(evt);
            }
        });

        rb_cartao.setBackground(new java.awt.Color(255, 255, 255));
        grupo.add(rb_cartao);
        rb_cartao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rb_cartao.setText("Cartão");
        rb_cartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_cartaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_dinheiro)
                    .addComponent(rb_cartao)
                    .addComponent(rb_outro)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tf_outro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_dinheiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_cartao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_outro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_outro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_voltar)
                        .addGap(124, 124, 124)
                        .addComponent(btn_remover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cadastrar))
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        principalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_cidade, cb_estado});

        abas.addTab("Cliente", principal);

        jt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Cidade", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        abas.addTab("Consulta", jPanel2);

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

    private void cb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_estadoActionPerformed
        cb_cidade.setSelectedItem("");
        if(cb_estado.getSelectedItem() != null)
            autocomplete.setAutoComplete(cb_estado.getSelectedItem()+".txt", true);
    }//GEN-LAST:event_cb_estadoActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        if(tf_nome.getText().length() > 0 && cb_estado.getSelectedIndex() != -1 && cb_cidade.getSelectedIndex() != -1){
            if(!rb_cartao.isSelected() && !rb_dinheiro.isSelected() && !rb_outro.isSelected()){
                    JOptionPane.showMessageDialog(null, "Por favor digite a forma de pagamento!","Falta informações",JOptionPane.WARNING_MESSAGE);
            }else if(rb_outro.isSelected() && tf_outro.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Por favor digite a forma de pagamento!","Falta informações",JOptionPane.WARNING_MESSAGE);
             }else{
                String f_pag = tf_outro.getText();
                if(rb_cartao.isSelected())
                    f_pag = "Cartão";
                else if(rb_dinheiro.isSelected())
                    f_pag = "Dinheiro";
                
                if(btn_cadastrar.getText().equals("Cadastrar")){
                    cliente.cadastrar(tf_nome.getText(), cb_cidade.getSelectedItem()+"", cb_estado.getSelectedItem()+"", f_pag);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastrado",JOptionPane.INFORMATION_MESSAGE);
                }else{//editar
                    if(JOptionPane.showConfirmDialog(null, "Deseja salvar as alterções?", "Editar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                        new Geral().editar("Clientes", id, new String[]{id, tf_nome.getText(), cb_cidade.getSelectedItem()+"", cb_estado.getSelectedItem()+"", f_pag}, id+"_"+tf_nome.getText());
                        JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Alterado", JOptionPane.INFORMATION_MESSAGE);
                    }
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

    private void rb_outroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_outroActionPerformed
        tf_outro.setEnabled(rb_outro.isSelected());
    }//GEN-LAST:event_rb_outroActionPerformed

    private void rb_cartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_cartaoActionPerformed
        tf_outro.setEnabled(rb_outro.isSelected());
    }//GEN-LAST:event_rb_cartaoActionPerformed

    private void rb_dinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_dinheiroActionPerformed
        tf_outro.setEnabled(rb_outro.isSelected());
    }//GEN-LAST:event_rb_dinheiroActionPerformed

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
        if(evt.getClickCount() == 2){
            abas.setSelectedIndex(0);
            ArrayList<String> r = cliente.consultar(jt.getValueAt(jt.getSelectedRow(), 0)+"");
            tf_nome.setText(r.get(1));
            cb_estado.setSelectedItem(r.get(3));
            cb_cidade.setSelectedItem(r.get(2));
            if(r.get(4).equals("Dinheiro"))
                rb_dinheiro.setSelected(true);
            else if(r.get(4).equals("Cartão"))
                rb_cartao.setSelected(true);
            else{
                rb_outro.setSelected(true);
                tf_outro.setText(r.get(4));
                tf_outro.setEnabled(true);
            }
            btn_cadastrar.setText("Editar");
            btn_voltar.setText("Cancelar");
            btn_remover.setEnabled(true);
            btn_cadastrar.setToolTipText("Confirmar edição");
            btn_remover.setToolTipText("Remover esta cliente");
            btn_voltar.setToolTipText("Cancelar edição");
            btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limp.png")));
            id = jt.getValueAt(jt.getSelectedRow(), 0)+"";
        }
    }//GEN-LAST:event_jtMouseClicked

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente remover este registro?", "Remover?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
            new Geral().remover("Clientes", id);
            new Geral().removerViagem_Cliente(id);
            limpar();
        }
    }//GEN-LAST:event_btn_removerActionPerformed

    private void limpar(){
        tf_nome.setText("");
        tf_outro.setText("");
        cb_cidade.setSelectedIndex(-1);
        cb_estado.setSelectedIndex(-1);
        povoa_tabela();
        btn_cadastrar.setText("Cadastrar");
        btn_voltar.setText("Voltar");
        btn_remover.setEnabled(false);
        btn_cadastrar.setToolTipText("Confirmar cadastro");
        btn_remover.setToolTipText(null);
        btn_voltar.setToolTipText("Voltar");
        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/volta.png")));
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
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
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JPanel principal;
    private javax.swing.JRadioButton rb_cartao;
    private javax.swing.JRadioButton rb_dinheiro;
    private javax.swing.JRadioButton rb_outro;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_outro;
    // End of variables declaration//GEN-END:variables
}