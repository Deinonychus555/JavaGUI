/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipo;

import java.awt.Color;
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
public class FrasesNivel1 extends javax.swing.JFrame {

    
            
    public FrasesNivel1() {
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

        frasesNivel1Panel1 = new JPanelCustom("/img/fondoSelva.png");
        ff11_titulo = new javax.swing.JLabel();
        ff11_subtitulo = new javax.swing.JLabel();
        ff11_palabra1 = new javax.swing.JButton();
        ff11_palabra2 = new javax.swing.JButton();
        ff11_palabra3 = new javax.swing.JButton();
        ff11_palabra4 = new javax.swing.JButton();
        ff11_palabra5 = new javax.swing.JButton();
        backLetras1 = new javax.swing.JButton();
        homeLetras1 = new javax.swing.JButton();
        ff11_palabra6 = new javax.swing.JButton();
        ff11_palabra7 = new javax.swing.JButton();
        ff11_palabra8 = new javax.swing.JButton();
        ff11_palabra9 = new javax.swing.JButton();
        ff11_palabra10 = new javax.swing.JButton();
        ff11_palabra11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frasesNivel1Panel1.setMaximumSize(new java.awt.Dimension(800, 600));
        frasesNivel1Panel1.setMinimumSize(new java.awt.Dimension(800, 600));

        ff11_titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 68)); // NOI18N
        ff11_titulo.setForeground(new java.awt.Color(0, 204, 51));
        ff11_titulo.setText("NIVEL 1");
        ff11_titulo.setNextFocusableComponent(ff11_subtitulo);

        ff11_subtitulo.setFont(new java.awt.Font("GinoSchoolScript", 1, 36)); // NOI18N
        ff11_subtitulo.setForeground(new java.awt.Color(0, 0, 255));
        ff11_subtitulo.setText("Selecciona las palabras correctas");
        ff11_subtitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ff11_subtitulo.setNextFocusableComponent(ff11_palabra1);

        ff11_palabra1.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra1.setText("gato");
        ff11_palabra1.setBorder(null);
        ff11_palabra1.setBorderPainted(false);
        ff11_palabra1.setNextFocusableComponent(ff11_palabra2);
        ff11_palabra1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra1MouseExited(evt);
            }
        });
        ff11_palabra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ff11_palabra1ActionPerformed(evt);
            }
        });

        ff11_palabra2.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra2.setText("luna");
        ff11_palabra2.setBorder(null);
        ff11_palabra2.setBorderPainted(false);
        ff11_palabra2.setNextFocusableComponent(ff11_palabra3);
        ff11_palabra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra2MouseExited(evt);
            }
        });
        ff11_palabra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ff11_palabra2ActionPerformed(evt);
            }
        });

        ff11_palabra3.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra3.setText("pera");
        ff11_palabra3.setBorder(null);
        ff11_palabra3.setBorderPainted(false);
        ff11_palabra3.setNextFocusableComponent(ff11_palabra4);
        ff11_palabra3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra3MouseExited(evt);
            }
        });

        ff11_palabra4.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra4.setText("sol");
        ff11_palabra4.setBorder(null);
        ff11_palabra4.setBorderPainted(false);
        ff11_palabra4.setNextFocusableComponent(ff11_palabra5);
        ff11_palabra4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra4MouseExited(evt);
            }
        });

        ff11_palabra5.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra5.setText("perro");
        ff11_palabra5.setBorder(null);
        ff11_palabra5.setBorderPainted(false);
        ff11_palabra5.setNextFocusableComponent(ff11_palabra6);
        ff11_palabra5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra5MouseExited(evt);
            }
        });

        backLetras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backLetras1.setBorderPainted(false);
        backLetras1.setContentAreaFilled(false);
        backLetras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLetras1MouseClicked(evt);
            }
        });

        homeLetras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeLetras1.setBorderPainted(false);
        homeLetras1.setContentAreaFilled(false);

        ff11_palabra6.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra6.setText("El");
        ff11_palabra6.setBorder(null);
        ff11_palabra6.setBorderPainted(false);
        ff11_palabra6.setNextFocusableComponent(ff11_palabra7);
        ff11_palabra6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra6MouseExited(evt);
            }
        });

        ff11_palabra7.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ff_perro_ladrando.png"))); // NOI18N
        ff11_palabra7.setBorder(null);
        ff11_palabra7.setBorderPainted(false);
        ff11_palabra7.setNextFocusableComponent(ff11_palabra8);
        ff11_palabra7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra7MouseExited(evt);
            }
        });

        ff11_palabra8.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra8.setText("ladra");
        ff11_palabra8.setBorder(null);
        ff11_palabra8.setBorderPainted(false);
        ff11_palabra8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra8MouseExited(evt);
            }
        });

        ff11_palabra9.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra9.setText("a");
        ff11_palabra9.setBorder(null);
        ff11_palabra9.setBorderPainted(false);
        ff11_palabra9.setNextFocusableComponent(ff11_palabra10);
        ff11_palabra9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra9MouseExited(evt);
            }
        });

        ff11_palabra10.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra10.setText("la");
        ff11_palabra10.setBorder(null);
        ff11_palabra10.setBorderPainted(false);
        ff11_palabra10.setNextFocusableComponent(ff11_palabra11);
        ff11_palabra10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra10MouseExited(evt);
            }
        });

        ff11_palabra11.setFont(new java.awt.Font("GinoSchoolScript", 1, 48)); // NOI18N
        ff11_palabra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ff_luna.png"))); // NOI18N
        ff11_palabra11.setBorder(null);
        ff11_palabra11.setBorderPainted(false);
        ff11_palabra11.setNextFocusableComponent(backLetras1);
        ff11_palabra11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ff11_palabra11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ff11_palabra11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ff11_palabra11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout frasesNivel1Panel1Layout = new javax.swing.GroupLayout(frasesNivel1Panel1);
        frasesNivel1Panel1.setLayout(frasesNivel1Panel1Layout);
        frasesNivel1Panel1Layout.setHorizontalGroup(
            frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frasesNivel1Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ff11_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(ff11_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                        .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addComponent(backLetras1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeLetras1))
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(ff11_palabra1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(ff11_palabra2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ff11_palabra3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addComponent(ff11_palabra6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(ff11_palabra7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(ff11_palabra8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(ff11_palabra9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addComponent(ff11_palabra4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frasesNivel1Panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ff11_palabra10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addComponent(ff11_palabra5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frasesNivel1Panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(ff11_palabra11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))))
        );
        frasesNivel1Panel1Layout.setVerticalGroup(
            frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(ff11_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ff11_subtitulo)
                        .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frasesNivel1Panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ff11_palabra11))
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ff11_palabra3)
                                    .addComponent(ff11_palabra5)
                                    .addComponent(ff11_palabra1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                                .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ff11_palabra8)
                                    .addComponent(ff11_palabra9)
                                    .addComponent(ff11_palabra10))
                                .addGap(22, 22, 22))))
                    .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addComponent(ff11_palabra6)
                                .addGap(8, 8, 8))
                            .addGroup(frasesNivel1Panel1Layout.createSequentialGroup()
                                .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ff11_palabra2)
                                    .addComponent(ff11_palabra4))
                                .addGap(38, 38, 38)
                                .addComponent(ff11_palabra7)))))
                .addGap(47, 47, 47)
                .addGroup(frasesNivel1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backLetras1)
                    .addComponent(homeLetras1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frasesNivel1Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frasesNivel1Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backLetras1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLetras1MouseClicked
        
    }//GEN-LAST:event_backLetras1MouseClicked

    private void ff11_palabra1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra1MouseEntered
        if (ff11_palabra1.isEnabled()){
            ff11_palabra1.setForeground(Color.yellow);
        }  
    }//GEN-LAST:event_ff11_palabra1MouseEntered

    private void ff11_palabra1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra1MouseExited
         ff11_palabra1.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra1MouseExited

    private void ff11_palabra1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra1MouseClicked
        ff11_palabra1.setEnabled(false);
    }//GEN-LAST:event_ff11_palabra1MouseClicked

    private void ff11_palabra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ff11_palabra1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra1ActionPerformed

    private void ff11_palabra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ff11_palabra2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra2ActionPerformed

    private void ff11_palabra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra2MouseClicked
         ff11_palabra2.setEnabled(false);
        ff11_palabra11.setEnabled(true);
        if (!ff11_palabra5.isEnabled()){
            ;
        }
    }//GEN-LAST:event_ff11_palabra2MouseClicked

    private void ff11_palabra2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra2MouseEntered
        if (ff11_palabra2.isEnabled()){
            ff11_palabra2.setForeground(Color.yellow);
        }
    }//GEN-LAST:event_ff11_palabra2MouseEntered

    private void ff11_palabra2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra2MouseExited
         ff11_palabra2.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra2MouseExited

    private void ff11_palabra3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra3MouseClicked
       ff11_palabra3.setEnabled(false);
    }//GEN-LAST:event_ff11_palabra3MouseClicked

    private void ff11_palabra3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra3MouseEntered
        if (ff11_palabra3.isEnabled()){
            ff11_palabra3.setForeground(Color.yellow);
        }
    }//GEN-LAST:event_ff11_palabra3MouseEntered

    private void ff11_palabra3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra3MouseExited
        ff11_palabra3.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra3MouseExited

    private void ff11_palabra4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra4MouseClicked
        ff11_palabra4.setEnabled(false);
    }//GEN-LAST:event_ff11_palabra4MouseClicked

    private void ff11_palabra4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra4MouseEntered
         if (ff11_palabra4.isEnabled()){
            ff11_palabra4.setForeground(Color.yellow);
        }
    }//GEN-LAST:event_ff11_palabra4MouseEntered

    private void ff11_palabra4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra4MouseExited
         ff11_palabra4.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra4MouseExited

    private void ff11_palabra5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra5MouseClicked
        ff11_palabra5.setEnabled(false);
        ff11_palabra7.setEnabled(true);
        if (!ff11_palabra2.isEnabled()){
            ;
        }
    }//GEN-LAST:event_ff11_palabra5MouseClicked

    private void ff11_palabra5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra5MouseEntered
        if (ff11_palabra5.isEnabled()){
            ff11_palabra5.setForeground(Color.yellow);
        }
    }//GEN-LAST:event_ff11_palabra5MouseEntered

    private void ff11_palabra5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra5MouseExited
        ff11_palabra5.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra5MouseExited

    private void ff11_palabra6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra6MouseClicked

    private void ff11_palabra6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra6MouseEntered
        ff11_palabra6.setForeground(Color.yellow);
    }//GEN-LAST:event_ff11_palabra6MouseEntered

    private void ff11_palabra6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra6MouseExited
         ff11_palabra6.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra6MouseExited

    private void ff11_palabra7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra7MouseClicked

    private void ff11_palabra7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra7MouseEntered
        if (!ff11_palabra5.isEnabled()){
            ff11_palabra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ff_perro_ladrando_hover.png")));
        }
    }//GEN-LAST:event_ff11_palabra7MouseEntered

    private void ff11_palabra7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra7MouseExited
        if (!ff11_palabra5.isEnabled()){
            ff11_palabra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ff_perro_ladrando.png")));
        }
    }//GEN-LAST:event_ff11_palabra7MouseExited

    private void ff11_palabra8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra8MouseClicked

    private void ff11_palabra8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra8MouseEntered
        ff11_palabra8.setForeground(Color.yellow);
    }//GEN-LAST:event_ff11_palabra8MouseEntered

    private void ff11_palabra8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra8MouseExited
         ff11_palabra8.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra8MouseExited

    private void ff11_palabra9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra9MouseClicked

    private void ff11_palabra9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra9MouseEntered
        ff11_palabra9.setForeground(Color.yellow);
    }//GEN-LAST:event_ff11_palabra9MouseEntered

    private void ff11_palabra9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra9MouseExited
        ff11_palabra9.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra9MouseExited

    private void ff11_palabra10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra10MouseClicked

    private void ff11_palabra10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra10MouseEntered
        ff11_palabra10.setForeground(Color.yellow);
    }//GEN-LAST:event_ff11_palabra10MouseEntered

    private void ff11_palabra10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra10MouseExited
       ff11_palabra10.setForeground(Color.black);
    }//GEN-LAST:event_ff11_palabra10MouseExited

    private void ff11_palabra11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ff11_palabra11MouseClicked

    private void ff11_palabra11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra11MouseEntered
        if (!ff11_palabra2.isEnabled()){
            ff11_palabra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ff_luna_hover.png")));
        } 
    }//GEN-LAST:event_ff11_palabra11MouseEntered

    private void ff11_palabra11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ff11_palabra11MouseExited
        if (!ff11_palabra2.isEnabled()){
            ff11_palabra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ff_luna.png")));
        }
    }//GEN-LAST:event_ff11_palabra11MouseExited

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
            java.util.logging.Logger.getLogger(FrasesNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrasesNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrasesNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrasesNivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrasesNivel1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backLetras1;
    private javax.swing.JButton ff11_palabra1;
    private javax.swing.JButton ff11_palabra10;
    private javax.swing.JButton ff11_palabra11;
    private javax.swing.JButton ff11_palabra2;
    private javax.swing.JButton ff11_palabra3;
    private javax.swing.JButton ff11_palabra4;
    private javax.swing.JButton ff11_palabra5;
    private javax.swing.JButton ff11_palabra6;
    private javax.swing.JButton ff11_palabra7;
    private javax.swing.JButton ff11_palabra8;
    private javax.swing.JButton ff11_palabra9;
    private javax.swing.JLabel ff11_subtitulo;
    private javax.swing.JLabel ff11_titulo;
    private javax.swing.JPanel frasesNivel1Panel1;
    private javax.swing.JButton homeLetras1;
    // End of variables declaration//GEN-END:variables
}
