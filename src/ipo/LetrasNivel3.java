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
public class LetrasNivel3 extends javax.swing.JFrame {

     Cursor mickey;
    Font font_titulos, font_subtitulos;
    String fontName = "/img/GinSSB60.ttf";
    Font font;
    ImageIcon fondo;
    
    public LetrasNivel3() {
        
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

        letrasNivel3_Panel = new JPanelCustom ("/img/fondoClase.png");
        fl31_titulo = new javax.swing.JLabel();
        fl31_imagen1 = new javax.swing.JButton();
        fl31_imagen2 = new javax.swing.JButton();
        fl31_imagen3 = new javax.swing.JButton();
        fl31_letra = new javax.swing.JLabel();
        backLetras3 = new javax.swing.JButton();
        homeLetras3 = new javax.swing.JButton();
        ff11_subtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        letrasNivel3_Panel.setMaximumSize(new java.awt.Dimension(800, 600));
        letrasNivel3_Panel.setMinimumSize(new java.awt.Dimension(800, 600));
        letrasNivel3_Panel.setPreferredSize(new java.awt.Dimension(800, 600));

        fl31_titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 68)); // NOI18N
        fl31_titulo.setForeground(new java.awt.Color(255, 255, 0));
        fl31_titulo.setText("NIVEL 3");

        fl31_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_pajaro.png"))); // NOI18N
        fl31_imagen1.setBorder(null);
        fl31_imagen1.setBorderPainted(false);
        fl31_imagen1.setContentAreaFilled(false);
        fl31_imagen1.setName(""); // NOI18N
        fl31_imagen1.setNextFocusableComponent(fl31_imagen2);
        fl31_imagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl31_imagen1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl31_imagen1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl31_imagen1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl31_imagen1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl31_imagen1MouseReleased(evt);
            }
        });
        fl31_imagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fl31_imagen1ActionPerformed(evt);
            }
        });

        fl31_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_tijeras.png"))); // NOI18N
        fl31_imagen2.setBorder(null);
        fl31_imagen2.setBorderPainted(false);
        fl31_imagen2.setContentAreaFilled(false);
        fl31_imagen2.setNextFocusableComponent(backLetras3);
        fl31_imagen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl31_imagen2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl31_imagen2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl31_imagen2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl31_imagen2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl31_imagen2MouseReleased(evt);
            }
        });

        fl31_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_moto.png"))); // NOI18N
        fl31_imagen3.setBorder(null);
        fl31_imagen3.setBorderPainted(false);
        fl31_imagen3.setContentAreaFilled(false);
        fl31_imagen3.setNextFocusableComponent(fl31_imagen1);
        fl31_imagen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fl31_imagen3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fl31_imagen3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fl31_imagen3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fl31_imagen3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fl31_imagen3MouseReleased(evt);
            }
        });

        fl31_letra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_m_minuscula.png"))); // NOI18N

        backLetras3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backLetras3.setBorderPainted(false);
        backLetras3.setContentAreaFilled(false);
        backLetras3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLetras3MouseClicked(evt);
            }
        });

        homeLetras3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeLetras3.setBorderPainted(false);
        homeLetras3.setContentAreaFilled(false);
        homeLetras3.setEnabled(false);

        ff11_subtitulo.setFont(new java.awt.Font("GinoSchoolScript", 1, 36)); // NOI18N
        ff11_subtitulo.setForeground(new java.awt.Color(204, 0, 102));
        ff11_subtitulo.setText("Selecciona el dibujo correcto");
        ff11_subtitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout letrasNivel3_PanelLayout = new javax.swing.GroupLayout(letrasNivel3_Panel);
        letrasNivel3_Panel.setLayout(letrasNivel3_PanelLayout);
        letrasNivel3_PanelLayout.setHorizontalGroup(
            letrasNivel3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel3_PanelLayout.createSequentialGroup()
                .addComponent(backLetras3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeLetras3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(letrasNivel3_PanelLayout.createSequentialGroup()
                .addGroup(letrasNivel3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(letrasNivel3_PanelLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(fl31_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(letrasNivel3_PanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(ff11_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(220, 227, Short.MAX_VALUE))
            .addGroup(letrasNivel3_PanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(fl31_imagen3)
                .addGap(74, 74, 74)
                .addComponent(fl31_imagen1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fl31_imagen2)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, letrasNivel3_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fl31_letra)
                .addGap(268, 268, 268))
        );
        letrasNivel3_PanelLayout.setVerticalGroup(
            letrasNivel3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(letrasNivel3_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fl31_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ff11_subtitulo)
                .addGap(33, 33, 33)
                .addGroup(letrasNivel3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fl31_imagen2)
                    .addComponent(fl31_imagen1)
                    .addComponent(fl31_imagen3))
                .addGap(76, 76, 76)
                .addComponent(fl31_letra)
                .addGap(8, 8, 8)
                .addGroup(letrasNivel3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backLetras3)
                    .addComponent(homeLetras3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel3_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(letrasNivel3_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fl31_imagen1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen1MouseExited
        fl31_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_pajaro.png")));
    }//GEN-LAST:event_fl31_imagen1MouseExited

    private void fl31_imagen1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen1MouseEntered
        fl31_imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_pajaro_hover.png")));
    }//GEN-LAST:event_fl31_imagen1MouseEntered

    private void fl31_imagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen1MouseClicked

    private void fl31_imagen1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen1MousePressed

    private void fl31_imagen1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen1MouseReleased

    private void fl31_imagen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen2MouseClicked

    private void fl31_imagen2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen2MouseEntered
        fl31_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_tijeras_hover.png")));
    }//GEN-LAST:event_fl31_imagen2MouseEntered

    private void fl31_imagen2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen2MouseExited
        fl31_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_tijeras.png")));
    }//GEN-LAST:event_fl31_imagen2MouseExited

    private void fl31_imagen2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen2MousePressed

    private void fl31_imagen2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen2MouseReleased

    private void fl31_imagen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen3MouseClicked

    private void fl31_imagen3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen3MouseEntered
        fl31_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_moto_hover.png")));
    }//GEN-LAST:event_fl31_imagen3MouseEntered

    private void fl31_imagen3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen3MouseExited
        fl31_imagen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fl_moto.png")));
    }//GEN-LAST:event_fl31_imagen3MouseExited

    private void fl31_imagen3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen3MousePressed

    private void fl31_imagen3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fl31_imagen3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen3MouseReleased

    private void fl31_imagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fl31_imagen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fl31_imagen1ActionPerformed

    private void backLetras3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLetras3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backLetras3MouseClicked

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
            java.util.logging.Logger.getLogger(LetrasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LetrasNivel3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LetrasNivel3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backLetras3;
    private javax.swing.JLabel ff11_subtitulo;
    private javax.swing.JButton fl31_imagen1;
    private javax.swing.JButton fl31_imagen2;
    private javax.swing.JButton fl31_imagen3;
    private javax.swing.JLabel fl31_letra;
    private javax.swing.JLabel fl31_titulo;
    private javax.swing.JButton homeLetras3;
    private javax.swing.JPanel letrasNivel3_Panel;
    // End of variables declaration//GEN-END:variables
}
