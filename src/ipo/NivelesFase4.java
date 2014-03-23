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
public class NivelesFase4 extends javax.swing.JFrame {
    Cursor mickey;
    Font font_boton_niveles, font_titulo_niveles;
    String fontName = "/img/GinSSB60.ttf";
    Font font;

    /**
     * Creates new form NivelesFase1
     */
    
    
    public NivelesFase4() {
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

        jPanel4 = new javax.swing.JPanel();
        nivel1fase4 = new javax.swing.JButton();
        nivel2fase4 = new javax.swing.JButton();
        nivel3fase4 = new javax.swing.JButton();
        webLabel1 = new com.alee.laf.label.WebLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel4.setMinimumSize(new java.awt.Dimension(800, 600));

        nivel1fase4.setFont(font_boton_niveles);
        nivel1fase4.setForeground(new java.awt.Color(255, 255, 255));
        nivel1fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow.png"))); // NOI18N
        nivel1fase4.setText("Nivel 1");
        nivel1fase4.setBorderPainted(false);
        nivel1fase4.setContentAreaFilled(false);
        nivel1fase4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel1fase4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel1fase4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel1fase4MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel1fase4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel1fase4MouseEntered(evt);
            }
        });
        nivel1fase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel1fase4ActionPerformed(evt);
            }
        });

        nivel2fase4.setFont(font_boton_niveles);
        nivel2fase4.setForeground(new java.awt.Color(255, 255, 255));
        nivel2fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue.png"))); // NOI18N
        nivel2fase4.setText("Nivel 2");
        nivel2fase4.setBorderPainted(false);
        nivel2fase4.setContentAreaFilled(false);
        nivel2fase4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel2fase4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel2fase4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel2fase4MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel2fase4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel2fase4MouseEntered(evt);
            }
        });

        nivel3fase4.setFont(font_boton_niveles);
        nivel3fase4.setForeground(new java.awt.Color(255, 255, 255));
        nivel3fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green.png"))); // NOI18N
        nivel3fase4.setText("Nivel 3");
        nivel3fase4.setBorderPainted(false);
        nivel3fase4.setContentAreaFilled(false);
        nivel3fase4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel3fase4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel3fase4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel3fase4MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel3fase4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel3fase4MouseEntered(evt);
            }
        });
        nivel3fase4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel3fase4ActionPerformed(evt);
            }
        });

        webLabel1.setForeground(new java.awt.Color(0, 51, 255));
        webLabel1.setText("Escoge un nivel");
        webLabel1.setFont(font_titulo_niveles);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(nivel1fase4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(nivel2fase4)
                .addGap(148, 148, 148))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(nivel3fase4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(nivel1fase4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(nivel2fase4)))
                .addGap(66, 66, 66)
                .addComponent(nivel3fase4)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nivel1fase4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase4MouseEntered
        // TODO add your handling cocircle_blue_pulsadode here:
        nivel1fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow_hover.png")));
    }//GEN-LAST:event_nivel1fase4MouseEntered

    private void nivel1fase4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase4MouseExited
        // TODO add your handling code here:
        nivel1fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow.png")));
    }//GEN-LAST:event_nivel1fase4MouseExited

    private void nivel1fase4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase4MousePressed
        // TODO add your handling code here:
        nivel1fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow_pulsado.png")));
    }//GEN-LAST:event_nivel1fase4MousePressed

    private void nivel1fase4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase4MouseReleased
        // TODO add your handling code here:
        nivel1fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow.png")));
    }//GEN-LAST:event_nivel1fase4MouseReleased

    private void nivel2fase4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase4MouseEntered
        // TODO add your handling code here:
        nivel2fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue_hover.png")));
    }//GEN-LAST:event_nivel2fase4MouseEntered

    private void nivel2fase4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase4MouseExited
        // TODO add your handling code here:
        nivel2fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue.png")));
    }//GEN-LAST:event_nivel2fase4MouseExited

    private void nivel2fase4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase4MousePressed
        // TODO add your handling code here:
        nivel2fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue_pulsado.png")));
    }//GEN-LAST:event_nivel2fase4MousePressed

    private void nivel2fase4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase4MouseReleased
        // TODO add your handling code here:
        nivel2fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue.png")));
    }//GEN-LAST:event_nivel2fase4MouseReleased

    private void nivel3fase4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase4MouseEntered
        // TODO add your handling code here:
        nivel3fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green_hover.png")));
    }//GEN-LAST:event_nivel3fase4MouseEntered

    private void nivel3fase4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase4MouseExited
        // TODO add your handling code here:
        nivel3fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_green.png")));
    }//GEN-LAST:event_nivel3fase4MouseExited

    private void nivel3fase4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase4MousePressed
        // TODO add your handling code here:
        nivel3fase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green_pulsado.png")));
    }//GEN-LAST:event_nivel3fase4MousePressed

    private void nivel3fase4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase4MouseReleased
        // TODO add your handling code here:
        nivel3fase4.setIcon(new ImageIcon(getClass().getResource("/img/circle_green.png")));
    }//GEN-LAST:event_nivel3fase4MouseReleased

    private void nivel1fase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel1fase4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel1fase4ActionPerformed

    private void nivel3fase4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3fase4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel3fase4ActionPerformed

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
            java.util.logging.Logger.getLogger(NivelesFase4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NivelesFase4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NivelesFase4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NivelesFase4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NivelesFase4().setVisible(true);
            }
        });
    }

     private javax.swing.JButton boton_sonido;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton nivel1fase4;
    private javax.swing.JButton nivel2fase4;
    private javax.swing.JButton nivel3fase4;
    private com.alee.laf.label.WebLabel webLabel1;
    // End of variables declaration//GEN-END:variables
}
