package GUI;

import Classes.Fundo;
import Classes.Geral;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @Autor Lucas Santos dia 03/07/2016 às 02:02:18
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        setContentPane(new Fundo());
        initComponents();
        t.start();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setIcon();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/icon.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_clientes = new javax.swing.JButton();
        btn_viagem = new javax.swing.JButton();
        btn_hotel = new javax.swing.JButton();
        boas_vindas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyBNB");

        btn_clientes.setBackground(new java.awt.Color(95, 150, 215));
        btn_clientes.setFont(new java.awt.Font("Futura Md BT", 1, 24)); // NOI18N
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        btn_clientes.setText("Clientes");
        btn_clientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_viagem.setBackground(new java.awt.Color(95, 150, 215));
        btn_viagem.setFont(new java.awt.Font("Futura Md BT", 1, 24)); // NOI18N
        btn_viagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/travel.png"))); // NOI18N
        btn_viagem.setText("Viagem");
        btn_viagem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_viagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viagemActionPerformed(evt);
            }
        });

        btn_hotel.setBackground(new java.awt.Color(95, 150, 215));
        btn_hotel.setFont(new java.awt.Font("Futura Md BT", 1, 24)); // NOI18N
        btn_hotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home.png"))); // NOI18N
        btn_hotel.setText("Hospedagem");
        btn_hotel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_hotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hotelActionPerformed(evt);
            }
        });

        boas_vindas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_viagem)
                            .addComponent(btn_hotel)
                            .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boas_vindas, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_clientes, btn_hotel, btn_viagem});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_hotel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_viagem)
                .addGap(25, 25, 25)
                .addComponent(boas_vindas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_clientes, btn_hotel, btn_viagem});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        new Cliente().setVisible(true);
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_viagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viagemActionPerformed
        File f1 = new File(System.getProperty("user.dir")+"\\Clientes");
        File f2 = new File(System.getProperty("user.dir")+"\\Hospedagem");
        if(f1.exists() && f2.exists()){
            if(f1.list().length > 0 && f2.list().length > 0)
                new Viagem().setVisible(true);
            else
                JOptionPane.showMessageDialog(null, "Cadastre ao menos um cliente e uma hospedagem!","Atenção",JOptionPane.ERROR_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "Cadastre ao menos um cliente e uma hospedagem!","Atenção",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btn_viagemActionPerformed

    private void btn_hotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hotelActionPerformed
        new Hospedagem().setVisible(true);
    }//GEN-LAST:event_btn_hotelActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    Thread t = new Thread(){
        public void run(){
            while (true){
                String data = new Geral().pega_Data();
                String hora = new Geral().pega_Hora();
                String mes = data.substring(data.indexOf("/")+1, data.length()-5);
                switch(mes){
                    case "01": mes = "Janeiro de "; break;
                    case "02": mes = "Fevereiro de "; break;
                    case "03": mes = "Março de "; break;
                    case "04": mes = "Abril  de "; break;
                    case "05": mes = "Maio  de "; break;
                    case "06": mes = "Junho de "; break;
                    case "07": mes = "Julho de "; break;
                    case "08": mes = "Agosto de "; break;
                    case "09": mes = "Setembro de "; break;
                    case "10": mes = "Outubro de "; break;
                    case "11": mes = "Novembro de "; break;
                    case "12": mes = "Dezembro de "; break;
                }
                boas_vindas.setText("   Seja Bem Vindo! Hoje é dia "+data.substring(0,data.indexOf("/"))+" de "+mes+data.substring(data.length()-4)+",  ás "+hora);
            }
        }
        };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boas_vindas;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_hotel;
    private javax.swing.JButton btn_viagem;
    // End of variables declaration//GEN-END:variables
}