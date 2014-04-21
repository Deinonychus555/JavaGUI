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
public class LetrasNivel4 extends javax.swing.JFrame {

     Cursor mickey;
    Font font_titulos, font_subtitulos;
    String fontName = "/img/GinSSB60.ttf";
    Font font;
    ImageIcon fondo;
    
    public LetrasNivel4() {
        
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

        letrasNivel4_Panel = new JPanelCustom ("/img/fondoClase.png");
        fl41_titulo = new javax.swing.JLabel();
        fl41_imagen1 = new javax.swing.JButton();
        fl41_imagen2 = new javax.swing.JButton();
        fl41_imagen3 = new javax.swing.JButton();
        fl41_letra = new javax.swing.JLabel();
        backLetras4 = new javax.swing.JButton();
        homeLetras4 = new javax.swing.JButton();
        ff11_subtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        letrasNivel4_Panel.setMaximumSize(new java.awt.Dimension(800, 600));
        letrasNivel4_Panel.setMinimumSize(new java.awt.Dimension(800, 600));
        letrasNivel4_Panel.setPreferredSize(new java.awt.Dimension(800, 60));

        fl41_titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 68)); // NOI18N
        fl41_titulo.setForeground(new java.awt.Color(255, 255, 0));
        fl41_titulo.setText("NIVEL 4");

        fl41_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_raton.png"))); // NOI18N
        fl41_imagen1.setBorder(null);
        fl41_imagen1.setBorderPainted(false);
        fl41_imagen1.setContentAreaFilled(false);
        fl41_imagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl41_imagen1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl41_imagen1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl41_imagen1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl41_imagen1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl41_imagen1MouseReleased(evt);
            }
        });
        fl41_imagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fl41_imagen1ActionPerformed(evt);
            }
        });

        fl41_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_lapiz.png"))); // NOI18N
        fl41_imagen2.setBorder(null);
        fl41_imagen2.setBorderPainted(false);
        fl41_imagen2.setContentAreaFilled(false);
        fl41_imagen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl41_imagen2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl41_imagen2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl41_imagen2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl41_imagen2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl41_imagen2MouseReleased(evt);
            }
        });

        fl41_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_conejo.png"))); // NOI18N
        fl41_imagen3.setBorder(null);
        fl41_imagen3.setBorderPainted(false);
        fl41_imagen3.setContentAreaFilled(false);
        fl41_imagen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl41_imagen3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl41_imagen3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl41_imagen3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl41_imagen3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl41_imagen3MouseReleased(evt);
            }
        });

        fl41_letra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_r_minuscula.png"))); // NOI18N

        backLetras4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backLetras4.setBorderPainted(false);
        backLetras4.setContentAreaFilled(false);
        backLetras4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLetras4MouseClicked(evt);
            }
        });

        homeLetras4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeLetras4.setBorderPainted(false);
        homeLetras4.setContentAreaFilled(false);
        homeLetras4.setEnabled(false);

        ff11_subtitulo.setFont(new java.awt.Font("GinoSchoolScript", 1, 36)); // NOI18N
        ff11_subtitulo.setForeground(new java.awt.Color(204, 0, 102));
        ff11_subtitulo.setText("Selecciona el dibujo correcto");
        ff11_subtitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout letrasNivel4_PanelLayout = new javax.swing.GroupLayout(letrasNivel4_Panel);
        letrasNivel4_Panel.setLayout(letrasNivel4_PanelLayout);
        letrasNivel4_PanelLayout.setHorizontalGroup(
            letrasNivel4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel4_PanelLayout.createSequentialGroup()
                .addComponent(backLetras4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeLetras4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(letrasNivel4_PanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(fl41_imagen3)
                .addGroup(letrasNivel4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(letrasNivel4_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(fl41_imagen1)
                        .addGap(104, 104, 104)
                        .addComponent(fl41_imagen2)
                        .addGap(55, 55, 55))
                    .addGroup(letrasNivel4_PanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(ff11_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel4_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(letrasNivel4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel4_PanelLayout.createSequentialGroup()
                        .addComponent(fl41_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel4_PanelLayout.createSequentialGroup()
                        .addComponent(fl41_letra)
                        .addGap(315, 315, 315))))
        );
        letrasNivel4_PanelLayout.setVerticalGroup(
            letrasNivel4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel4_PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fl41_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ff11_subtitulo)
                .addGap(24, 24, 24)
                .addGroup(letrasNivel4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fl41_imagen2)
                    .addComponent(fl41_imagen1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(fl41_letra)
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel4_PanelLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(fl41_imagen3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(letrasNivel4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homeLetras4)
                    .addComponent(backLetras4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel4_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel4_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fl41_imagen1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen1MouseExited
        fl41_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_raton.png")));
    }//GEN-LAST:event_fl41_imagen1MouseExited

    private void fl41_imagen1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen1MouseEntered
        fl41_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_raton_hover.png")));
    }//GEN-LAST:event_fl41_imagen1MouseEntered

    private void fl41_imagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen1MouseClicked

    private void fl41_imagen1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen1MousePressed

    private void fl41_imagen1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen1MouseReleased

    private void fl41_imagen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen2MouseClicked

    private void fl41_imagen2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen2MouseEntered
        fl41_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_lapiz_hover.png")));
    }//GEN-LAST:event_fl41_imagen2MouseEntered

    private void fl41_imagen2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen2MouseExited
        fl41_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_lapiz.png")));
    }//GEN-LAST:event_fl41_imagen2MouseExited

    private void fl41_imagen2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen2MousePressed

    private void fl41_imagen2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen2MouseReleased

    private void fl41_imagen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen3MouseClicked

    private void fl41_imagen3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen3MouseEntered
        fl41_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_conejo_hover.png")));
    }//GEN-LAST:event_fl41_imagen3MouseEntered

    private void fl41_imagen3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen3MouseExited
        fl41_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_conejo.png")));
    }//GEN-LAST:event_fl41_imagen3MouseExited

    private void fl41_imagen3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen3MousePressed

    private void fl41_imagen3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl41_imagen3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen3MouseReleased

    private void fl41_imagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fl41_imagen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl41_imagen1ActionPerformed

    private void backLetras4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLetras4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backLetras4MouseClicked

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
            java.util.logging.Logger.getLogger(LetrasNivel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LetrasNivel4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backLetras4;
    private javax.swing.JLabel ff11_subtitulo;
    private javax.swing.JButton fl41_imagen1;
    private javax.swing.JButton fl41_imagen2;
    private javax.swing.JButton fl41_imagen3;
    private javax.swing.JLabel fl41_letra;
    private javax.swing.JLabel fl41_titulo;
    private javax.swing.JButton homeLetras4;
    private javax.swing.JPanel letrasNivel4_Panel;
    // End of variables declaration//GEN-END:variables
}
