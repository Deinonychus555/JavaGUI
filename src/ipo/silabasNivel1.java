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
public class silabasNivel1 extends javax.swing.JFrame {
    Cursor mickey;
    Font font_boton_niveles, font_titulo_niveles;
    String fontName = "/img/GinSSB60.ttf";
    Font font;

    /**
     * Creates new form NivelesFase1
     */
    
    
    public silabasNivel1() {
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
        panel_nivel1fase2 = new JPanelCustom("/img/fondoBarco.png");
        TituloSilabas1 = new com.alee.laf.label.WebLabel();
        backSilabas1 = new javax.swing.JButton();
        homeSilabas1 = new javax.swing.JButton();
        silabasImg1 = new javax.swing.JButton();
        soluciónsilabas1 = new javax.swing.JButton();
        boton1silabas1 = new javax.swing.JButton();
        boton2silabas1 = new javax.swing.JButton();
        boton3silabas1 = new javax.swing.JButton();
        ff11_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panel_nivel1fase2.setBackground(new java.awt.Color(204, 255, 204));
        panel_nivel1fase2.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_nivel1fase2.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_nivel1fase2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloSilabas1.setForeground(new java.awt.Color(0, 51, 255));
        TituloSilabas1.setText("Selecciona la sílaba correcta");
        TituloSilabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        panel_nivel1fase2.add(TituloSilabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        backSilabas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backSilabas1.setBorderPainted(false);
        backSilabas1.setContentAreaFilled(false);
        backSilabas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSilabas1MouseClicked(evt);
            }
        });
        panel_nivel1fase2.add(backSilabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 512, -1, -1));

        homeSilabas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeSilabas1.setBorderPainted(false);
        homeSilabas1.setContentAreaFilled(false);
        homeSilabas1.setEnabled(false);
        panel_nivel1fase2.add(homeSilabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 512, -1, -1));

        silabasImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soccer_ball.png"))); // NOI18N
        silabasImg1.setBorderPainted(false);
        silabasImg1.setContentAreaFilled(false);
        panel_nivel1fase2.add(silabasImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        soluciónsilabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        soluciónsilabas1.setText("Pe-lota");
        soluciónsilabas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soluciónsilabas1ActionPerformed(evt);
            }
        });
        panel_nivel1fase2.add(soluciónsilabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        boton1silabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton1silabas1.setText("Ca-mión");
        panel_nivel1fase2.add(boton1silabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        boton2silabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton2silabas1.setText("A-renero");
        panel_nivel1fase2.add(boton2silabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        boton3silabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton3silabas1.setText("Me-lón");
        boton3silabas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3silabas1ActionPerformed(evt);
            }
        });
        panel_nivel1fase2.add(boton3silabas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        ff11_titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 68)); // NOI18N
        ff11_titulo.setForeground(new java.awt.Color(0, 204, 51));
        ff11_titulo.setText("NIVEL 1");
        panel_nivel1fase2.add(ff11_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_nivel1fase2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_nivel1fase2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backSilabas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSilabas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas1MouseClicked

    private void soluciónsilabas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soluciónsilabas1ActionPerformed
        // TODO add your handling code here:
            //acertado.setVisible(true);
    }//GEN-LAST:event_soluciónsilabas1ActionPerformed

    private void boton3silabas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3silabas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton3silabas1ActionPerformed

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
            java.util.logging.Logger.getLogger(silabasNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(silabasNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(silabasNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(silabasNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new silabasNivel1().setVisible(true);
            }
        });
    }

     private javax.swing.JButton boton_sonido;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.alee.laf.label.WebLabel TituloSilabas1;
    private javax.swing.JButton backSilabas1;
    private javax.swing.JButton boton1silabas1;
    private javax.swing.JButton boton2silabas1;
    private javax.swing.JButton boton3silabas1;
    private javax.swing.JLabel ff11_titulo;
    private javax.swing.JButton homeSilabas1;
    private javax.swing.JPanel panel_nivel1fase2;
    private javax.swing.JButton silabasImg1;
    private javax.swing.JButton soluciónsilabas1;
    private com.alee.managers.version.VersionInfo versionInfo1;
    // End of variables declaration//GEN-END:variables
}
