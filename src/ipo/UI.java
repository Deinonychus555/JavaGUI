package ipo;

import com.alee.laf.optionpane.WebOptionPane;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javier
 */
public class UI extends javax.swing.JFrame {

    Cursor mickey;
    Font font_titulos, font_subtitulos;
    String fontName = "/img/GinSSB60.ttf";
    Font font;
    boolean musica_isActive;
    Profesor profesor;

    /**
     * Creates new form UI
     */
    public UI() {
        /**
         * Creación de profesores
         */
        profesor = new Profesor("profesor", "pass");

        /*
         Fin creación de profesores
         */
        /**
         * RATON MICKEY
         */
        Toolkit tk = getToolkit();
        ImageIcon imagen_cursor = new ImageIcon(getClass().getResource("/img/mano_mickey.png"));
        mickey = tk.createCustomCursor(imagen_cursor.getImage(), new Point(0, 0), "mickey");

        /**
         * INICIO FUENTE
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
        /* Fuentes utilizadas */
        font_titulos = font.deriveFont(60f).deriveFont(Font.BOLD);
        font_subtitulos = font.deriveFont(40f).deriveFont(Font.BOLD);

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

        panel_profesor = new javax.swing.JPanel();
        atras_profesor = new javax.swing.JButton();
        panel_inicio = new javax.swing.JPanel();
        webLabel1 = new com.alee.laf.label.WebLabel();
        webButton2 = new com.alee.laf.button.WebButton();
        webLabel3 = new com.alee.laf.label.WebLabel();
        jPanel2 = new javax.swing.JPanel();
        nombre_profe = new com.alee.laf.text.WebTextField();
        password_profe = new com.alee.laf.text.WebPasswordField();
        boton_entrar = new com.alee.laf.button.WebButton();
        webButton3 = new com.alee.laf.button.WebButton();
        webLabel4 = new com.alee.laf.label.WebLabel();
        boton_sonido = new javax.swing.JButton();
        webButton4 = new com.alee.laf.button.WebButton();
        webButton5 = new com.alee.laf.button.WebButton();
        webButton6 = new com.alee.laf.button.WebButton();
        webButton8 = new com.alee.laf.button.WebButton();
        webButton9 = new com.alee.laf.button.WebButton();
        webButton7 = new com.alee.laf.button.WebButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación de lectura");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panel_profesor.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_profesor.setMinimumSize(new java.awt.Dimension(800, 600));

        atras_profesor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        atras_profesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras_profe.png"))); // NOI18N
        atras_profesor.setBorderPainted(false);
        atras_profesor.setContentAreaFilled(false);
        atras_profesor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        atras_profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras_profesorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_profesorLayout = new javax.swing.GroupLayout(panel_profesor);
        panel_profesor.setLayout(panel_profesorLayout);
        panel_profesorLayout.setHorizontalGroup(
            panel_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_profesorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras_profesor)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        panel_profesorLayout.setVerticalGroup(
            panel_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_profesorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras_profesor)
                .addContainerGap(532, Short.MAX_VALUE))
        );

        panel_inicio.setBackground(new java.awt.Color(195, 226, 226));
        panel_inicio.setCursor(mickey);
        panel_inicio.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_inicio.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_inicio.setPreferredSize(new java.awt.Dimension(800, 600));

        webLabel1.setForeground(new java.awt.Color(0, 0, 255));
        webLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        webLabel1.setText("Bienvenido");
        webLabel1.setToolTipText("");
        webLabel1.setFont(font_titulos);
        webLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        webLabel1.setMargin(new java.awt.Insets(10, 0, 0, 0));

        webButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/foto carnet.png"))); // NOI18N
        webButton2.setText("Javier Cañadilla");
        webButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        webButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        webButton2.setMaximumSize(new java.awt.Dimension(138, 130));
        webButton2.setMinimumSize(new java.awt.Dimension(138, 130));
        webButton2.setPreferredSize(new java.awt.Dimension(138, 130));
        webButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        webButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        webLabel3.setForeground(new java.awt.Color(0, 0, 255));
        webLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        webLabel3.setText("Infantil");
        webLabel3.setFont(font_subtitulos);

        jPanel2.setBackground(new java.awt.Color(195, 226, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)), "Profesor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(51, 102, 255)));

        nombre_profe.setInputPrompt("Usuario");
        nombre_profe.setMaximumSize(new java.awt.Dimension(50, 20));
        nombre_profe.setMinimumSize(new java.awt.Dimension(50, 20));

        password_profe.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password_profe.setInputPrompt("Password");
        password_profe.setHideInputPromptOnFocus(false);
        password_profe.setMinimumSize(new java.awt.Dimension(10, 10));
        password_profe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_profeKeyPressed(evt);
            }
        });

        boton_entrar.setText("Entrar");
        boton_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_entrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(password_profe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nombre_profe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(boton_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(nombre_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        webButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_A.png"))); // NOI18N

        webLabel4.setForeground(new java.awt.Color(0, 0, 255));
        webLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        webLabel4.setText("Primaria");
        webLabel4.setFont(font_subtitulos);
        webLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        boton_sonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido.png"))); // NOI18N
        boton_sonido.setBorderPainted(false);
        boton_sonido.setContentAreaFilled(false);
        boton_sonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_sonidoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_sonidoMouseReleased(evt);
            }
        });

        webButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_B.png"))); // NOI18N

        webButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2_A.png"))); // NOI18N

        webButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2_B.png"))); // NOI18N

        webButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        webButton8.setText("Óscar Miranda");
        webButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        webButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        webButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        webButton9.setText("Profe Prueba");
        webButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        webButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        webButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        webButton7.setText("Juan Antonio");
        webButton7.setToolTipText("");
        webButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        webButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panel_inicioLayout = new javax.swing.GroupLayout(panel_inicio);
        panel_inicio.setLayout(panel_inicioLayout);
        panel_inicioLayout.setHorizontalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                .addComponent(webButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_inicioLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(webButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_inicioLayout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(boton_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)))
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(webButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(webButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(webButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(webButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(webButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(webButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(webLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(webLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panel_inicioLayout.setVerticalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(boton_sonido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(webLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(webButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(webButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(webButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(webButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(webLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(webButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(webButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(webButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_profesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_profesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boton_sonidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonidoMouseReleased
        if (musica_isActive) { //Si está activa -> la desactivamos.
            musica_isActive = false;
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
        } else {
            musica_isActive = true;
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
        }
    }//GEN-LAST:event_boton_sonidoMouseReleased

    private void boton_sonidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonidoMousePressed
        if (musica_isActive) {
            boton_sonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido_pulsado.png")));
        } else {
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado_pulsado.png")));
        }
    }//GEN-LAST:event_boton_sonidoMousePressed

    private void boton_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_entrarActionPerformed
        boolean inicio = iniciarSesion(nombre_profe.getText(), password_profe.getPassword());
        System.err.println("Inicio de sesión: " + inicio);
        if (!inicio) {
            WebOptionPane.showMessageDialog(this, "Nombre o password incorrecto", "Error", WebOptionPane.ERROR_MESSAGE);
        } else {
            panel_profesor.setVisible(true);
            panel_inicio.setVisible(false);
            inicio = false;
        }
    }//GEN-LAST:event_boton_entrarActionPerformed

    private void password_profeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_profeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean inicio = iniciarSesion(nombre_profe.getText(), password_profe.getPassword());
            System.err.println("Inicio de sesión: " + inicio);
            if (!inicio) {
                WebOptionPane.showMessageDialog(this, "Nombre o password incorrecto", "Error", WebOptionPane.ERROR_MESSAGE);

            } else {
                panel_profesor.setVisible(true);
                panel_inicio.setVisible(false);
                inicio = false;
            }
        }    }//GEN-LAST:event_password_profeKeyPressed

    private void atras_profesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras_profesorActionPerformed
        panel_profesor.setVisible(false);
        panel_inicio.setVisible(true);
        nombre_profe.clear();
        password_profe.clear();
    }//GEN-LAST:event_atras_profesorActionPerformed

    public boolean iniciarSesion(String nombre, char[] pass) {

        boolean nombre_ok = nombre.equals(profesor.getNombre());
        boolean pass_ok = true;
        String pass_profesor = profesor.getPassword();
        if (pass.length != 0) {
            for (int i = 0; i < profesor.getPassword().length(); i++) {
                if (pass[i] != pass_profesor.charAt(i)) {
                    pass_ok = false;
                }
            }
        } else {
            pass_ok = false;
        }
        return nombre_ok && pass_ok;
    }

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UI ui = new UI();
                ui.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras_profesor;
    private com.alee.laf.button.WebButton boton_entrar;
    private javax.swing.JButton boton_sonido;
    private javax.swing.JPanel jPanel2;
    private com.alee.laf.text.WebTextField nombre_profe;
    private javax.swing.JPanel panel_inicio;
    private javax.swing.JPanel panel_profesor;
    private com.alee.laf.text.WebPasswordField password_profe;
    private com.alee.laf.button.WebButton webButton2;
    private com.alee.laf.button.WebButton webButton3;
    private com.alee.laf.button.WebButton webButton4;
    private com.alee.laf.button.WebButton webButton5;
    private com.alee.laf.button.WebButton webButton6;
    private com.alee.laf.button.WebButton webButton7;
    private com.alee.laf.button.WebButton webButton8;
    private com.alee.laf.button.WebButton webButton9;
    private com.alee.laf.label.WebLabel webLabel1;
    private com.alee.laf.label.WebLabel webLabel3;
    private com.alee.laf.label.WebLabel webLabel4;
    // End of variables declaration//GEN-END:variables
}
