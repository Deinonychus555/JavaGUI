/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipo;

import com.alee.extended.image.WebImage;
import JPanelsCustom.JPanelCustom;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Font;
import java.io.InputStream;
import java.awt.Dimension;
import javax.imageio.ImageIO;

/**
 *
 * @author Juanan
 */
public class Nivel1Fase1 extends javax.swing.JFrame {

     Cursor mickey;
    Font font_titulos, font_subtitulos;
    String fontName = "/img/GinSSB60.ttf";
    Font font;
    ImageIcon fondo;
    
    public Nivel1Fase1() {
        
        Toolkit tk = getToolkit();
        ImageIcon imagen_cursor = new ImageIcon(getClass().getResource("/img/mano_mickey.png"));
        mickey = tk.createCustomCursor(imagen_cursor.getImage(), new Point(0, 0), "mickey");
        
        
          /*/ INICIO FUENTE
         /*/
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
        font_titulos = font.deriveFont(20f).deriveFont(1);
        font_subtitulos = font.deriveFont(40f).deriveFont(1);
        
        
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

        letrasNivel1_Panel = new JPanelCustom ("/img/fondo_fases_letras.jpg");
        fl11_imagen1 = new javax.swing.JButton();
        fl11_imagen2 = new javax.swing.JButton();
        fl11_imagen3 = new javax.swing.JButton();
        fl11_letra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        letrasNivel1_Panel.setMaximumSize(new java.awt.Dimension(800, 600));
        letrasNivel1_Panel.setMinimumSize(new java.awt.Dimension(800, 600));

        fl11_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_arbol.png"))); // NOI18N
        fl11_imagen1.setBorder(null);
        fl11_imagen1.setBorderPainted(false);
        fl11_imagen1.setContentAreaFilled(false);
        fl11_imagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl11_imagen1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl11_imagen1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl11_imagen1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl11_imagen1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl11_imagen1MouseReleased(evt);
            }
        });
        fl11_imagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fl11_imagen1ActionPerformed(evt);
            }
        });

        fl11_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_coche.PNG"))); // NOI18N
        fl11_imagen2.setBorder(null);
        fl11_imagen2.setBorderPainted(false);
        fl11_imagen2.setContentAreaFilled(false);
        fl11_imagen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl11_imagen2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl11_imagen2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl11_imagen2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl11_imagen2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl11_imagen2MouseReleased(evt);
            }
        });

        fl11_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_perro.png"))); // NOI18N
        fl11_imagen3.setBorder(null);
        fl11_imagen3.setBorderPainted(false);
        fl11_imagen3.setContentAreaFilled(false);
        fl11_imagen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl11_imagen3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl11_imagen3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl11_imagen3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl11_imagen3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl11_imagen3MouseReleased(evt);
            }
        });

        fl11_letra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/a_minuscula.png"))); // NOI18N

        javax.swing.GroupLayout letrasNivel1_PanelLayout = new javax.swing.GroupLayout(letrasNivel1_Panel);
        letrasNivel1_Panel.setLayout(letrasNivel1_PanelLayout);
        letrasNivel1_PanelLayout.setHorizontalGroup(
            letrasNivel1_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel1_PanelLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(fl11_imagen1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(fl11_imagen2)
                .addGap(200, 200, 200)
                .addComponent(fl11_imagen3)
                .addGap(85, 85, 85))
            .addGroup(letrasNivel1_PanelLayout.createSequentialGroup()
                .addGap(549, 549, 549)
                .addComponent(fl11_letra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        letrasNivel1_PanelLayout.setVerticalGroup(
            letrasNivel1_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel1_PanelLayout.createSequentialGroup()
                .addGroup(letrasNivel1_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(letrasNivel1_PanelLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(fl11_imagen2))
                    .addGroup(letrasNivel1_PanelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(fl11_imagen1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(fl11_letra)
                .addGap(89, 89, 89))
            .addGroup(letrasNivel1_PanelLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(fl11_imagen3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel1_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel1_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fl11_imagen1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen1MouseExited
        fl11_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_arbol.png")));
    }//GEN-LAST:event_fl11_imagen1MouseExited

    private void fl11_imagen1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen1MouseEntered
        fl11_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_arbol_hover.png")));
    }//GEN-LAST:event_fl11_imagen1MouseEntered

    private void fl11_imagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen1MouseClicked

    private void fl11_imagen1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen1MousePressed

    private void fl11_imagen1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen1MouseReleased

    private void fl11_imagen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen2MouseClicked

    private void fl11_imagen2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen2MouseEntered
        fl11_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_coche_hover.PNG")));
    }//GEN-LAST:event_fl11_imagen2MouseEntered

    private void fl11_imagen2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen2MouseExited
        fl11_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_coche.PNG")));
    }//GEN-LAST:event_fl11_imagen2MouseExited

    private void fl11_imagen2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen2MousePressed

    private void fl11_imagen2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen2MouseReleased

    private void fl11_imagen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen3MouseClicked

    private void fl11_imagen3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen3MouseEntered
        fl11_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_perro_hover.png")));
    }//GEN-LAST:event_fl11_imagen3MouseEntered

    private void fl11_imagen3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen3MouseExited
        fl11_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_perro.png")));
    }//GEN-LAST:event_fl11_imagen3MouseExited

    private void fl11_imagen3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen3MousePressed

    private void fl11_imagen3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl11_imagen3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen3MouseReleased

    private void fl11_imagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fl11_imagen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl11_imagen1ActionPerformed

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
            java.util.logging.Logger.getLogger(Nivel1Fase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nivel1Fase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nivel1Fase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nivel1Fase1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nivel1Fase1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fl11_imagen1;
    private javax.swing.JButton fl11_imagen2;
    private javax.swing.JButton fl11_imagen3;
    private javax.swing.JLabel fl11_letra;
    private javax.swing.JPanel letrasNivel1_Panel;
    // End of variables declaration//GEN-END:variables
}
