/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipo;

import JPanelsCustom.JPanelCustom;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.InputStream;
import javax.swing.ImageIcon;
/**
 *
 * @author oscarmirandabravo
 */
public class silabasNivel3 extends javax.swing.JFrame {
    Cursor mickey;
    Font font_boton_niveles, font_titulo_niveles;
    String fontName = "/img/GinSSB60.ttf";
    Font font;

    /**
     * Creates new form NivelesFase1
     */
    
    
    public silabasNivel3() {
        Toolkit tk = getToolkit();
        ImageIcon imagen_cursor = new ImageIcon(getClass().getResource("/img/mano_mickey.png"));
        mickey = tk.createCustomCursor(imagen_cursor.getImage(), new Point(0, 0), "mickey");
        /* INICIO FUENTE
         */
        try {
            //Se carga la fuente
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        /*FIN FUENTE*/
        font_boton_niveles = font.deriveFont(30f).deriveFont(1);
        font_titulo_niveles = font.deriveFont(50f).deriveFont(1);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        versionInfo1 = new com.alee.managers.version.VersionInfo();
        panel_nivel3fase2 = new JPanelCustom("/img/fondoBarco.png");
        TituloSilabas3 = new com.alee.laf.label.WebLabel();
        backSilabas3 = new javax.swing.JButton();
        homeSilabas3 = new javax.swing.JButton();
        silabasImg3 = new javax.swing.JButton();
        boton1silabas3 = new javax.swing.JButton();
        boton2silabas3 = new javax.swing.JButton();
        solucionsilabas3 = new javax.swing.JButton();
        boton3silabas3 = new javax.swing.JButton();
        ff11_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panel_nivel3fase2.setBackground(new java.awt.Color(204, 255, 204));
        panel_nivel3fase2.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_nivel3fase2.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_nivel3fase2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloSilabas3.setForeground(new java.awt.Color(0, 51, 255));
        TituloSilabas3.setText("Selecciona la sílaba correcta");
        TituloSilabas3.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        panel_nivel3fase2.add(TituloSilabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        backSilabas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backSilabas3.setBorderPainted(false);
        backSilabas3.setContentAreaFilled(false);
        backSilabas3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSilabas3MouseClicked(evt);
            }
        });
        backSilabas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSilabas3ActionPerformed(evt);
            }
        });
        panel_nivel3fase2.add(backSilabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 512, -1, -1));

        homeSilabas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeSilabas3.setBorderPainted(false);
        homeSilabas3.setContentAreaFilled(false);
        homeSilabas3.setEnabled(false);
        panel_nivel3fase2.add(homeSilabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 512, -1, -1));

        silabasImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clover.png"))); // NOI18N
        silabasImg3.setBorderPainted(false);
        silabasImg3.setContentAreaFilled(false);
        panel_nivel3fase2.add(silabasImg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        boton1silabas3.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton1silabas3.setText("Tri-ciclo");
        panel_nivel3fase2.add(boton1silabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        boton2silabas3.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton2silabas3.setText("Tren");
        panel_nivel3fase2.add(boton2silabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        solucionsilabas3.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        solucionsilabas3.setText("Tre-bol");
        solucionsilabas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solucionsilabas3ActionPerformed(evt);
            }
        });
        panel_nivel3fase2.add(solucionsilabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));

        boton3silabas3.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton3silabas3.setText("Bra-zo");
        panel_nivel3fase2.add(boton3silabas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, -1, -1));

        ff11_titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 68)); // NOI18N
        ff11_titulo.setForeground(new java.awt.Color(255, 0, 0));
        ff11_titulo.setText("NIVEL 2");
        panel_nivel3fase2.add(ff11_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_nivel3fase2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_nivel3fase2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backSilabas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSilabas3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas3MouseClicked

    private void solucionsilabas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solucionsilabas3ActionPerformed
        // TODO add your handling code here:
       // acertado.setVisible(true);
    }//GEN-LAST:event_solucionsilabas3ActionPerformed

    private void backSilabas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSilabas3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(silabasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(silabasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(silabasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(silabasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new silabasNivel3().setVisible(true);
            }
        });
    }

     private javax.swing.JButton boton_sonido;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.alee.laf.label.WebLabel TituloSilabas3;
    private javax.swing.JButton backSilabas3;
    private javax.swing.JButton boton1silabas3;
    private javax.swing.JButton boton2silabas3;
    private javax.swing.JButton boton3silabas3;
    private javax.swing.JLabel ff11_titulo;
    private javax.swing.JButton homeSilabas3;
    private javax.swing.JPanel panel_nivel3fase2;
    private javax.swing.JButton silabasImg3;
    private javax.swing.JButton solucionsilabas3;
    private com.alee.managers.version.VersionInfo versionInfo1;
    // End of variables declaration//GEN-END:variables
}
