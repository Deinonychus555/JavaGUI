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
public class NivelesFase1 extends javax.swing.JFrame {
    Cursor mickey;
    Font font_boton_niveles, font_titulo_niveles;
    String fontName = "/img/GinSSB60.ttf";
    Font font;

    /**
     * Creates new form NivelesFase1
     */
    
    
    public NivelesFase1() {
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
        nivel1fase1 = new javax.swing.JButton();
        nivel2fase1 = new javax.swing.JButton();
        nivel3fase1 = new javax.swing.JButton();
        nivel4fase1 = new javax.swing.JButton();
        TituloFase1 = new com.alee.laf.label.WebLabel();
        backFase1 = new javax.swing.JButton();
        homeFase1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        Fase1.setBackground(new java.awt.Color(204, 255, 204));
        Fase1.setMaximumSize(new java.awt.Dimension(800, 600));
        Fase1.setMinimumSize(new java.awt.Dimension(800, 600));

        nivel1fase1.setFont(font_boton_niveles);
        nivel1fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel1fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue.png"))); // NOI18N
        nivel1fase1.setText("Nivel 1");
        nivel1fase1.setBorderPainted(false);
        nivel1fase1.setContentAreaFilled(false);
        nivel1fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel1fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel1fase1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel1fase1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel1fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel1fase1MouseReleased(evt);
            }
        });

        nivel2fase1.setFont(font_boton_niveles);
        nivel2fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel2fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green.png"))); // NOI18N
        nivel2fase1.setText("Nivel 2");
        nivel2fase1.setBorder(null);
        nivel2fase1.setBorderPainted(false);
        nivel2fase1.setContentAreaFilled(false);
        nivel2fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel2fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel2fase1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel2fase1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel2fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel2fase1MouseReleased(evt);
            }
        });

        nivel3fase1.setFont(font_boton_niveles);
        nivel3fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel3fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red.png"))); // NOI18N
        nivel3fase1.setText("Nivel 3");
        nivel3fase1.setBorderPainted(false);
        nivel3fase1.setContentAreaFilled(false);
        nivel3fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel3fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel3fase1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel3fase1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel3fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel3fase1MouseReleased(evt);
            }
        });
        nivel3fase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel3fase1ActionPerformed(evt);
            }
        });

        nivel4fase1.setFont(font_boton_niveles);
        nivel4fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel4fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow.png"))); // NOI18N
        nivel4fase1.setText("Nivel 4");
        nivel4fase1.setBorderPainted(false);
        nivel4fase1.setContentAreaFilled(false);
        nivel4fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel4fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel4fase1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel4fase1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel4fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel4fase1MouseReleased(evt);
            }
        });
        nivel4fase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel4fase1ActionPerformed(evt);
            }
        });

        TituloFase1.setForeground(new java.awt.Color(0, 51, 255));
        TituloFase1.setText("Escoge un nivel");
        TituloFase1.setFont(font_titulo_niveles);

        backFase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backFase1.setBorderPainted(false);
        backFase1.setContentAreaFilled(false);
        backFase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backFase1MouseClicked(evt);
            }
        });

        homeFase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeFase1.setBorderPainted(false);
        homeFase1.setContentAreaFilled(false);
        homeFase1.setEnabled(false);

        javax.swing.GroupLayout Fase1Layout = new javax.swing.GroupLayout(Fase1);
        Fase1.setLayout(Fase1Layout);
        Fase1Layout.setHorizontalGroup(
            Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Fase1Layout.createSequentialGroup()
                .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nivel1fase1)
                            .addComponent(nivel3fase1))
                        .addGap(140, 140, 140)
                        .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nivel2fase1)
                            .addComponent(nivel4fase1)))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(TituloFase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backFase1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeFase1)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        Fase1Layout.setVerticalGroup(
            Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Fase1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(nivel2fase1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(nivel4fase1)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fase1Layout.createSequentialGroup()
                .addGroup(Fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeFase1))
                    .addGroup(Fase1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(TituloFase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(nivel1fase1)
                        .addGap(51, 51, 51)
                        .addComponent(nivel3fase1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(backFase1)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(326, 326, 326))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(271, 271, 271))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nivel1fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MouseEntered
        // TODO add your handling cocircle_blue_pulsadode here:
        nivel1fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue_hover.png")));
    }//GEN-LAST:event_nivel1fase1MouseEntered

    private void nivel1fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MouseExited
        // TODO add your handling code here:
        nivel1fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue.png")));
    }//GEN-LAST:event_nivel1fase1MouseExited

    private void nivel1fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MousePressed
        // TODO add your handling code here:
        nivel1fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue_pulsado.png")));
    }//GEN-LAST:event_nivel1fase1MousePressed

    private void nivel1fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MouseReleased
        // TODO add your handling code here:
        nivel1fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue.png")));
    }//GEN-LAST:event_nivel1fase1MouseReleased

    private void nivel2fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MouseEntered
        // TODO add your handling code here:
        nivel2fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green_hover.png")));
    }//GEN-LAST:event_nivel2fase1MouseEntered

    private void nivel2fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MouseExited
        // TODO add your handling code here:
        nivel2fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_green.png")));
    }//GEN-LAST:event_nivel2fase1MouseExited

    private void nivel2fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MousePressed
        // TODO add your handling code here:
        nivel2fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green_pulsado.png")));
    }//GEN-LAST:event_nivel2fase1MousePressed

    private void nivel2fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MouseReleased
        // TODO add your handling code here:
        nivel2fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_green.png")));
    }//GEN-LAST:event_nivel2fase1MouseReleased

    private void nivel3fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MouseEntered
        // TODO add your handling code here:
        nivel3fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red_hover.png")));
    }//GEN-LAST:event_nivel3fase1MouseEntered

    private void nivel3fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MouseExited
        // TODO add your handling code here:
        nivel3fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_red.png")));
    }//GEN-LAST:event_nivel3fase1MouseExited

    private void nivel3fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MousePressed
        // TODO add your handling code here:
        nivel3fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red_pulsado.png")));
    }//GEN-LAST:event_nivel3fase1MousePressed

    private void nivel3fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MouseReleased
        // TODO add your handling code here:
        nivel3fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_red.png")));
    }//GEN-LAST:event_nivel3fase1MouseReleased

    private void nivel4fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase1MouseEntered
        // TODO add your handling code here:
        nivel4fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow_hover.png")));
    }//GEN-LAST:event_nivel4fase1MouseEntered

    private void nivel4fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase1MouseExited
        // TODO add your handling code here:
        nivel4fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow.png")));
    }//GEN-LAST:event_nivel4fase1MouseExited

    private void nivel4fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase1MousePressed
        // TODO add your handling code here:
        nivel4fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow_pulsado.png")));
    }//GEN-LAST:event_nivel4fase1MousePressed

    private void nivel4fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase1MouseReleased
        // TODO add your handling code here:
        nivel4fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow.png")));
    }//GEN-LAST:event_nivel4fase1MouseReleased

    private void nivel3fase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3fase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel3fase1ActionPerformed

    private void nivel4fase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel4fase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel4fase1ActionPerformed

    private void backFase1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFase1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backFase1MouseClicked

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
            java.util.logging.Logger.getLogger(NivelesFase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NivelesFase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NivelesFase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NivelesFase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NivelesFase1().setVisible(true);
            }
        });
    }

     private javax.swing.JButton boton_sonido;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fase1;
    private com.alee.laf.label.WebLabel TituloFase1;
    private javax.swing.JButton backFase1;
    private javax.swing.JButton homeFase1;
    private javax.swing.JButton nivel1fase1;
    private javax.swing.JButton nivel2fase1;
    private javax.swing.JButton nivel3fase1;
    private javax.swing.JButton nivel4fase1;
    private com.alee.managers.version.VersionInfo versionInfo1;
    // End of variables declaration//GEN-END:variables
}
