/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipo;

import com.alee.extended.painter.TitledBorderPainter;
import com.alee.laf.button.WebButton;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
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
public class NivelesFase2 extends javax.swing.JFrame {
    Cursor mickey;
    Font font_boton_niveles;
    String fontName = "/img/GinSSB60.ttf";
    Font font;

    /**
     * Creates new form NivelesFase1
     */
    
    
    public NivelesFase2() {
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

        jPanel1 = new javax.swing.JPanel();
        nivel1fase1 = new javax.swing.JButton();
        nivel2fase1 = new javax.swing.JButton();
        nivel3fase1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));

        nivel1fase1.setFont(font_boton_niveles);
        nivel1fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel1fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red.png"))); // NOI18N
        nivel1fase1.setText("Nivel 1");
        nivel1fase1.setBorderPainted(false);
        nivel1fase1.setContentAreaFilled(false);
        nivel1fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel1fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel1fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel1fase1MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel1fase1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel1fase1MouseEntered(evt);
            }
        });
        nivel1fase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel1fase1ActionPerformed(evt);
            }
        });

        nivel2fase1.setFont(font_boton_niveles);
        nivel2fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel2fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_grey.png"))); // NOI18N
        nivel2fase1.setText("Nivel 2");
        nivel2fase1.setBorderPainted(false);
        nivel2fase1.setContentAreaFilled(false);
        nivel2fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel2fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel2fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel2fase1MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel2fase1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel2fase1MouseEntered(evt);
            }
        });

        nivel3fase1.setFont(font_boton_niveles);
        nivel3fase1.setForeground(new java.awt.Color(255, 255, 255));
        nivel3fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange.png"))); // NOI18N
        nivel3fase1.setText("Nivel 3");
        nivel3fase1.setBorderPainted(false);
        nivel3fase1.setContentAreaFilled(false);
        nivel3fase1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel3fase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel3fase1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel3fase1MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel3fase1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel3fase1MouseEntered(evt);
            }
        });
        nivel3fase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel3fase1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(nivel1fase1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(nivel2fase1)
                .addGap(148, 148, 148))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(nivel3fase1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(nivel1fase1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(nivel2fase1)))
                .addGap(66, 66, 66)
                .addComponent(nivel3fase1)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(322, 322, 322))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nivel1fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MouseEntered
        // TODO add your handling cocircle_blue_pulsadode here:
        nivel1fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red_hover.png")));
    }//GEN-LAST:event_nivel1fase1MouseEntered

    private void nivel1fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MouseExited
        // TODO add your handling code here:
        nivel1fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_red.png")));
    }//GEN-LAST:event_nivel1fase1MouseExited

    private void nivel1fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MousePressed
        // TODO add your handling code here:
        nivel1fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_red_pulsado.png")));
    }//GEN-LAST:event_nivel1fase1MousePressed

    private void nivel1fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase1MouseReleased
        // TODO add your handling code here:
        nivel1fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_red.png")));
    }//GEN-LAST:event_nivel1fase1MouseReleased

    private void nivel2fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MouseEntered
        // TODO add your handling code here:
        nivel2fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_grey_hover.png")));
    }//GEN-LAST:event_nivel2fase1MouseEntered

    private void nivel2fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MouseExited
        // TODO add your handling code here:
        nivel2fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_grey.png")));
    }//GEN-LAST:event_nivel2fase1MouseExited

    private void nivel2fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MousePressed
        // TODO add your handling code here:
        nivel2fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_grey_pulsado.png")));
    }//GEN-LAST:event_nivel2fase1MousePressed

    private void nivel2fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase1MouseReleased
        // TODO add your handling code here:
        nivel2fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_grey.png")));
    }//GEN-LAST:event_nivel2fase1MouseReleased

    private void nivel3fase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MouseEntered
        // TODO add your handling code here:
        nivel3fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange_hover.png")));
    }//GEN-LAST:event_nivel3fase1MouseEntered

    private void nivel3fase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MouseExited
        // TODO add your handling code here:
        nivel3fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_orange.png")));
    }//GEN-LAST:event_nivel3fase1MouseExited

    private void nivel3fase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MousePressed
        // TODO add your handling code here:
        nivel3fase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange_pulsado.png")));
    }//GEN-LAST:event_nivel3fase1MousePressed

    private void nivel3fase1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase1MouseReleased
        // TODO add your handling code here:
        nivel3fase1.setIcon(new ImageIcon(getClass().getResource("/img/circle_orange.png")));
    }//GEN-LAST:event_nivel3fase1MouseReleased

    private void nivel1fase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel1fase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel1fase1ActionPerformed

    private void nivel3fase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3fase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel3fase1ActionPerformed

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
            java.util.logging.Logger.getLogger(NivelesFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NivelesFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NivelesFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NivelesFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NivelesFase2().setVisible(true);
            }
        });
    }

     private javax.swing.JButton boton_sonido;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nivel1fase1;
    private javax.swing.JButton nivel2fase1;
    private javax.swing.JButton nivel3fase1;
    // End of variables declaration//GEN-END:variables
}
