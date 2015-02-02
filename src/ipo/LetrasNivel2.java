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
public class LetrasNivel2 extends javax.swing.JFrame {

     Cursor mickey;
    Font font_titulos, font_subtitulos;
    String fontName = "/img/GinSSB60.ttf";
    Font font;
    ImageIcon fondo;
    
    public LetrasNivel2() {
        
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

        letrasNivel2_Panel = new JPanelCustom ("/img/fondoClase.png");
        fl21_titulo = new javax.swing.JLabel();
        fl21_imagen1 = new javax.swing.JButton();
        fl21_imagen2 = new javax.swing.JButton();
        fl21_imagen3 = new javax.swing.JButton();
        fl21_letra = new javax.swing.JLabel();
        backLetras2 = new javax.swing.JButton();
        homeLetras4 = new javax.swing.JButton();
        ff11_subtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        letrasNivel2_Panel.setMaximumSize(new java.awt.Dimension(800, 600));
        letrasNivel2_Panel.setMinimumSize(new java.awt.Dimension(800, 600));
        letrasNivel2_Panel.setPreferredSize(new java.awt.Dimension(800, 600));

        fl21_titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 68)); // NOI18N
        fl21_titulo.setForeground(new java.awt.Color(255, 255, 0));
        fl21_titulo.setText("NIVEL 2");

        fl21_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_planta.png"))); // NOI18N
        fl21_imagen1.setBorder(null);
        fl21_imagen1.setBorderPainted(false);
        fl21_imagen1.setContentAreaFilled(false);
        fl21_imagen1.setNextFocusableComponent(fl21_imagen2);
        fl21_imagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl21_imagen1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl21_imagen1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl21_imagen1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl21_imagen1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl21_imagen1MouseReleased(evt);
            }
        });
        fl21_imagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fl21_imagen1ActionPerformed(evt);
            }
        });

        fl21_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_tortuga.png"))); // NOI18N
        fl21_imagen2.setBorder(null);
        fl21_imagen2.setBorderPainted(false);
        fl21_imagen2.setContentAreaFilled(false);
        fl21_imagen2.setNextFocusableComponent(fl21_imagen3);
        fl21_imagen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl21_imagen2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl21_imagen2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl21_imagen2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl21_imagen2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl21_imagen2MouseReleased(evt);
            }
        });

        fl21_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_espejo.png"))); // NOI18N
        fl21_imagen3.setBorder(null);
        fl21_imagen3.setBorderPainted(false);
        fl21_imagen3.setContentAreaFilled(false);
        fl21_imagen3.setNextFocusableComponent(backLetras2);
        fl21_imagen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl21_imagen3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl21_imagen3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl21_imagen3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl21_imagen3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl21_imagen3MouseReleased(evt);
            }
        });

        fl21_letra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_e_minuscula.png"))); // NOI18N

        backLetras2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backLetras2.setBorderPainted(false);
        backLetras2.setContentAreaFilled(false);
        backLetras2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLetras2MouseClicked(evt);
            }
        });

        homeLetras4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeLetras4.setBorderPainted(false);
        homeLetras4.setContentAreaFilled(false);

        ff11_subtitulo.setFont(new java.awt.Font("GinoSchoolScript", 1, 36)); // NOI18N
        ff11_subtitulo.setForeground(new java.awt.Color(204, 0, 102));
        ff11_subtitulo.setText("Selecciona el dibujo correcto");
        ff11_subtitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout letrasNivel2_PanelLayout = new javax.swing.GroupLayout(letrasNivel2_Panel);
        letrasNivel2_Panel.setLayout(letrasNivel2_PanelLayout);
        letrasNivel2_PanelLayout.setHorizontalGroup(
            letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                .addGroup(letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addComponent(backLetras2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeLetras4))
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(fl21_imagen1)
                        .addGap(150, 150, 150)
                        .addComponent(fl21_imagen2)
                        .addGap(162, 162, 162)
                        .addComponent(fl21_imagen3))
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(ff11_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 530, Short.MAX_VALUE))
            .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                .addGroup(letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(fl21_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(fl21_letra)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        letrasNivel2_PanelLayout.setVerticalGroup(
            letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                .addComponent(fl21_titulo)
                .addGroup(letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(fl21_imagen3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(letrasNivel2_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ff11_subtitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel2_PanelLayout.createSequentialGroup()
                                .addComponent(fl21_imagen1)
                                .addGap(137, 137, 137))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel2_PanelLayout.createSequentialGroup()
                                .addComponent(fl21_imagen2)
                                .addGap(81, 81, 81)
                                .addComponent(fl21_letra)
                                .addGap(39, 39, 39)))))
                .addGroup(letrasNivel2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backLetras2)
                    .addComponent(homeLetras4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel2_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel2_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fl21_imagen1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen1MouseExited
        fl21_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_planta.png")));
    }//GEN-LAST:event_fl21_imagen1MouseExited

    private void fl21_imagen1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen1MouseEntered
        fl21_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_planta_hover.png")));
    }//GEN-LAST:event_fl21_imagen1MouseEntered

    private void fl21_imagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen1MouseClicked

    private void fl21_imagen1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen1MousePressed

    private void fl21_imagen1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen1MouseReleased

    private void fl21_imagen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen2MouseClicked

    private void fl21_imagen2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen2MouseEntered
        fl21_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_tortuga_hover.png")));
    }//GEN-LAST:event_fl21_imagen2MouseEntered

    private void fl21_imagen2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen2MouseExited
        fl21_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_tortuga.png")));
    }//GEN-LAST:event_fl21_imagen2MouseExited

    private void fl21_imagen2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen2MousePressed

    private void fl21_imagen2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen2MouseReleased

    private void fl21_imagen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen3MouseClicked

    private void fl21_imagen3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen3MouseEntered
        fl21_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_espejo_hover.png")));
    }//GEN-LAST:event_fl21_imagen3MouseEntered

    private void fl21_imagen3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen3MouseExited
        fl21_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_espejo.png")));
    }//GEN-LAST:event_fl21_imagen3MouseExited

    private void fl21_imagen3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen3MousePressed

    private void fl21_imagen3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl21_imagen3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen3MouseReleased

    private void fl21_imagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fl21_imagen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl21_imagen1ActionPerformed

    private void backLetras2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLetras2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backLetras2MouseClicked

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
            java.util.logging.Logger.getLogger(LetrasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LetrasNivel2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backLetras2;
    private javax.swing.JLabel ff11_subtitulo;
    private javax.swing.JButton fl21_imagen1;
    private javax.swing.JButton fl21_imagen2;
    private javax.swing.JButton fl21_imagen3;
    private javax.swing.JLabel fl21_letra;
    private javax.swing.JLabel fl21_titulo;
    private javax.swing.JButton homeLetras4;
    private javax.swing.JPanel letrasNivel2_Panel;
    // End of variables declaration//GEN-END:variables
}
