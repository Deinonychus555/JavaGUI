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
public class silabasNivel2 extends javax.swing.JFrame {
    Cursor mickey;
    Font font_boton_niveles, font_titulo_niveles;
    String fontName = "/img/GinSSB60.ttf";
    Font font;

    /**
     * Creates new form NivelesFase1
     */
    
    
    public silabasNivel2() {
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
        Fase1 = new JPanelCustom("/img/fondoClase.png");
        TituloSilabas2 = new com.alee.laf.label.WebLabel();
        backSilabas2 = new javax.swing.JButton();
        homeSilabas2 = new javax.swing.JButton();
        silabasImg2 = new javax.swing.JButton();
        soluciónsilabas2 = new javax.swing.JButton();
        boton1silabas2 = new javax.swing.JButton();
        boton2silabas2 = new javax.swing.JButton();
        boton3silabas2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        Fase1.setBackground(new java.awt.Color(204, 255, 204));
        Fase1.setMaximumSize(new java.awt.Dimension(800, 600));
        Fase1.setMinimumSize(new java.awt.Dimension(800, 600));

        TituloSilabas2.setForeground(new java.awt.Color(0, 51, 255));
        TituloSilabas2.setText("Selecciona la sílaba correcta");
        TituloSilabas2.setFont(font_titulo_niveles);

        backSilabas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backSilabas2.setBorderPainted(false);
        backSilabas2.setContentAreaFilled(false);
        backSilabas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSilabas2MouseClicked(evt);
            }
        });

        homeSilabas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeSilabas2.setBorderPainted(false);
        homeSilabas2.setContentAreaFilled(false);
        homeSilabas2.setEnabled(false);

        silabasImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candy.png"))); // NOI18N
        silabasImg2.setBorderPainted(false);
        silabasImg2.setContentAreaFilled(false);

        soluciónsilabas2.setFont(font_boton_niveles);
        soluciónsilabas2.setText("Ca-ramelo");

        boton1silabas2.setFont(font_boton_niveles);
        boton1silabas2.setText("Pe-lota");
        boton1silabas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1silabas2ActionPerformed(evt);
            }
        });

        boton2silabas2.setFont(font_boton_niveles);
        boton2silabas2.setText("Es-cuela");
        boton2silabas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2silabas2ActionPerformed(evt);
            }
        });

        boton3silabas2.setFont(font_boton_niveles);
        boton3silabas2.setText("San-dia");

        javax.swing.GroupLayout Fase1Layout = new javax.swing.GroupLayout(Fase1);
        Fase1.setLayout(Fase1Layout);
        Fase1Layout.setHorizontalGroup(
            Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Fase1Layout.createSequentialGroup()
                .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(TituloSilabas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backSilabas2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeSilabas2))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(silabasImg2))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(boton1silabas2)
                        .addGap(79, 79, 79)
                        .addComponent(boton2silabas2)
                        .addGap(79, 79, 79)
                        .addComponent(soluciónsilabas2)
                        .addGap(79, 79, 79)
                        .addComponent(boton3silabas2)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        Fase1Layout.setVerticalGroup(
            Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fase1Layout.createSequentialGroup()
                .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addContainerGap(386, Short.MAX_VALUE)
                        .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton2silabas2)
                            .addComponent(boton3silabas2)
                            .addComponent(soluciónsilabas2)
                            .addComponent(boton1silabas2))
                        .addGap(137, 137, 137))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(TituloSilabas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(silabasImg2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeSilabas2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backSilabas2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backSilabas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSilabas2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas2MouseClicked

    private void boton2silabas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2silabas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton2silabas2ActionPerformed

    private void boton1silabas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1silabas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton1silabas2ActionPerformed

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
            java.util.logging.Logger.getLogger(silabasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(silabasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(silabasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(silabasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new silabasNivel2().setVisible(true);
            }
        });
    }

     private javax.swing.JButton boton_sonido;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fase1;
    private com.alee.laf.label.WebLabel TituloSilabas2;
    private javax.swing.JButton backSilabas2;
    private javax.swing.JButton boton1silabas2;
    private javax.swing.JButton boton2silabas2;
    private javax.swing.JButton boton3silabas2;
    private javax.swing.JButton homeSilabas2;
    private javax.swing.JButton silabasImg2;
    private javax.swing.JButton soluciónsilabas2;
    private com.alee.managers.version.VersionInfo versionInfo1;
    // End of variables declaration//GEN-END:variables
}
