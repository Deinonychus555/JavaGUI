package ipo;

import JPanelsCustom.JPanelCustom;
import com.alee.laf.optionpane.WebOptionPane;
import com.alee.managers.notification.NotificationManager;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 *
 * @author Javier Cañadilla, Juan Antonio Echeverrías, Oscar Miranda
 */
public class UI extends javax.swing.JFrame implements BasicPlayerListener, ListSelectionListener {
    /*Variables Globales*/

    Cursor mickey;
    Font font_titulos, font_subtitulos;
    String fontName = "/img/GinSSB60.ttf";
    Font font;
    boolean musica_isActive;

    /* Varibles Javi */
    Profesor profesor;
    ImageIcon fondo_inicio;
    BasicPlayer player = new BasicPlayer();
    BasicController control = (BasicController) player;
    File array_musica;
    boolean control_pausado;
    String[] nombres_lista_alumnos = new String[8];
   /* String[] nombres_lista_alumnos = new String[]{"1 Armada Antonio, María", "2 Campos Campos, Beatriz",
        "3 Cañadilla Casco, Javier", "4 Echeverrias Aranda, Juan Antonio",
        "5 Miranda Bravo, Oscar", "6 Pérez Navarro, José", "7 Romero Álvarez, Gustavo", "8 Ruiz Valenzuela, Fernando"};
    */
    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    TableModel modelo_tabla_resultados;
    boolean componentes_alumno_activados = false;
    /* Variables Juanan */
    /* Variables Oscar */

    /**
     * Creates new form UI.
     */
    public UI() {
        /**
         * Creación de profesores.
         */
        profesor = new Profesor("profesor", "pass");

        /**
         * Creacion de Alumnos.
         */
        alumnos.add(new Alumno("Maria", "Antonio Armada", "918113226", "Calle de la Piruleta, nº3"));
        alumnos.add(new Alumno("Beatriz", "Campos Campos", "918115626", "Calle de Alemania, nº8"));
        alumnos.add(new Alumno("Javier", "Cañadilla Casco", "918113226", "Calle de la Piruleta, nº3"));
        alumnos.add(new Alumno("Juan Antonio", "Echeverrias Aranda", "918119926", "Calle del Doctor Mateo, nº33"));
        alumnos.add(new Alumno("Oscar", "Miranda Bravo", "918183722", "Avenida de los mercados, nº5"));
        alumnos.add(new Alumno("José", "Pérez Navarro", "918185672", "Avenida de los barcos, nº15"));
        alumnos.add(new Alumno("Gustavo", "Romero Álvarez", "918168677", "Paseo del Alparrache, nº7"));
        alumnos.add(new Alumno("Fernando", "Ruiz Valenzuela", "918115478", "Paseo de la piruleta, nº37"));
        /*Cambiamos la foto por defecto. */
        alumnos.get(2).setImagen("/img/javier.png");
        alumnos.get(3).setImagen("/img/juanan.png");
        alumnos.get(4).setImagen("/img/oscar.PNG");
        
        generarListadoAlumnos();
        
        /**
         * RATON MICKEY.
         */
        Toolkit tk = getToolkit();
        ImageIcon imagen_cursor = new ImageIcon(getClass().getResource("/img/mano_mickey.png"));
        mickey = tk.createCustomCursor(imagen_cursor.getImage(), new Point(0, 0), "mickey");

        /**
         * INICIO FUENTE.
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
        /* Fuentes utilizadas */
        font_titulos = font.deriveFont(60f).deriveFont(Font.BOLD);
        font_subtitulos = font.deriveFont(40f).deriveFont(Font.BOLD);

        /**
         * INICIAMOS LOS COMPONENTES.
         */
        initComponents();

        /**
         * Ocultamos todos los paneles menos el INICIO.
         */
        panel_inicio.setVisible(true);
        panel_profesor.setVisible(false);

        /**
         * INICIAMOS LA MÚSICA.
         */
        try {

            control.open(new File(System.getProperty("user.dir"), "/src/musica/musica1.mp3"));
            control.play();
            control_pausado = false;
            musica_isActive = true;
            player.addBasicPlayerListener(this);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * Lista alumnos -> IU PROFESOR
         */
        lista_nombres_alumnos.addListSelectionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_profesor = new JPanelCustom("/img/fondo_profesor.png");
        boton_atras_profesor = new javax.swing.JButton();
        titulo_profesor = new com.alee.laf.label.WebLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_resultados = new com.alee.laf.table.WebTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_observaciones = new com.alee.laf.text.WebTextArea();
        label_observaciones = new com.alee.laf.label.WebLabel();
        boton_guardar = new com.alee.laf.button.WebButton();
        webLabel1 = new com.alee.laf.label.WebLabel();
        webLabel2 = new com.alee.laf.label.WebLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_nombre_alumno = new javax.swing.JLabel();
        label_apellidos_alumno = new javax.swing.JLabel();
        label_telefono_alumno = new javax.swing.JLabel();
        label_direccion_alumno = new javax.swing.JLabel();
        nombre_alumno_profe = new com.alee.laf.text.WebTextField();
        apellido_alumno_profe = new com.alee.laf.text.WebTextField();
        telefono_alumno_profe = new com.alee.laf.text.WebTextField();
        direccion_alumno_profe = new com.alee.laf.text.WebTextField();
        foto_alumno = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        lista_nombres_alumnos = new javax.swing.JList(nombres_lista_alumnos);
        panel_inicio = new JPanel();
        label_bienvenido = new com.alee.laf.label.WebLabel();
        boton_profe1 = new com.alee.laf.button.WebButton();
        label_infantil = new com.alee.laf.label.WebLabel();
        panel_login_profesor = new javax.swing.JPanel();
        nombre_profe = new com.alee.laf.text.WebTextField();
        password_profe = new com.alee.laf.text.WebPasswordField();
        boton_entrar = new com.alee.laf.button.WebButton();
        boton_1A = new com.alee.laf.button.WebButton();
        label_primaria = new com.alee.laf.label.WebLabel();
        boton_sonido = new javax.swing.JButton();
        boton_1B = new com.alee.laf.button.WebButton();
        boton_2A = new com.alee.laf.button.WebButton();
        boton_2B = new com.alee.laf.button.WebButton();
        boton_profe3 = new com.alee.laf.button.WebButton();
        boton_profe4 = new com.alee.laf.button.WebButton();
        boton_profe2 = new com.alee.laf.button.WebButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación de lectura");
        setBounds(new java.awt.Rectangle(800, 600, 600, 600));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panel_profesor.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_profesor.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_profesor.setPreferredSize(new java.awt.Dimension(800, 600));

        boton_atras_profesor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boton_atras_profesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras_profe.png"))); // NOI18N
        boton_atras_profesor.setToolTipText("Atrás");
        boton_atras_profesor.setBorderPainted(false);
        boton_atras_profesor.setContentAreaFilled(false);
        boton_atras_profesor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_atras_profesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_atras_profesorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_atras_profesorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_atras_profesorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_atras_profesorMouseReleased(evt);
            }
        });
        boton_atras_profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_atras_profesorActionPerformed(evt);
            }
        });

        titulo_profesor.setForeground(new java.awt.Color(0, 0, 102));
        titulo_profesor.setText("PROFESOR");
        titulo_profesor.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titulo_profesor.setDrawShade(true);
        titulo_profesor.setShadeColor(Color.white);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 600));

        modelo_tabla_resultados = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1),  new Integer(1), null},
                { new Integer(1),  new Integer(2), null},
                { new Integer(1),  new Integer(3), null},
                { new Integer(1),  new Integer(4), null},
                { new Integer(2),  new Integer(1), null},
                { new Integer(2),  new Integer(2), null},
                { new Integer(2),  new Integer(3), null},
                { new Integer(3),  new Integer(1), null},
                { new Integer(3),  new Integer(2), null},
                { new Integer(3),  new Integer(3), null},
                { new Integer(3),  new Integer(4), null},
                { new Integer(4),  new Integer(1), null},
                { new Integer(4),  new Integer(2), null},
                { new Integer(4),  new Integer(3), null},
                { new Integer(5),  new Integer(1), null}
            },
            new String [] {
                "Fase", "Nivel", "Fallos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        tabla_resultados.setModel(modelo_tabla_resultados);
        tabla_resultados.setEditable(false);
        tabla_resultados.setEnabled(false);
        tabla_resultados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tabla_resultados);
        tabla_resultados.getAccessibleContext().setAccessibleName("");

        textArea_observaciones.setBackground(new java.awt.Color(255, 255, 153));
        textArea_observaciones.setColumns(20);
        textArea_observaciones.setRows(5);
        textArea_observaciones.setToolTipText("");
        textArea_observaciones.setEnabled(false);
        jScrollPane2.setViewportView(textArea_observaciones);

        label_observaciones.setText("Observaciones:");
        label_observaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        boton_guardar.setText("Guardar");
        boton_guardar.setToolTipText("Guardar las observaciones");
        boton_guardar.setEnabled(false);
        boton_guardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        webLabel1.setText("Lista de alumnos:");
        webLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        webLabel2.setText("Progreso:");
        webLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Estadísticas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(90, 90, 90))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del alumno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        label_nombre_alumno.setText("Nombre:");

        label_apellidos_alumno.setText("Apellidos:");

        label_telefono_alumno.setText("Teléfono:");

        label_direccion_alumno.setText("Dirección:");
        label_direccion_alumno.setToolTipText("");

        nombre_alumno_profe.setEnabled(false);
        nombre_alumno_profe.setInputPrompt("Nombre del alumno");

        apellido_alumno_profe.setEnabled(false);
        apellido_alumno_profe.setInputPrompt("Apellidos del alumno");

        telefono_alumno_profe.setEnabled(false);
        telefono_alumno_profe.setInputPrompt("Número del alumno");

        direccion_alumno_profe.setEnabled(false);
        direccion_alumno_profe.setInputPrompt("Dirección del alumno");

        foto_alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        foto_alumno.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(foto_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_apellidos_alumno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_nombre_alumno, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_telefono_alumno)
                            .addComponent(label_direccion_alumno))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellido_alumno_profe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_alumno_profe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono_alumno_profe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccion_alumno_profe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(foto_alumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_nombre_alumno)
                            .addComponent(nombre_alumno_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_apellidos_alumno)
                            .addComponent(apellido_alumno_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_telefono_alumno)
                            .addComponent(telefono_alumno_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_direccion_alumno)
                            .addComponent(direccion_alumno_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane4.setViewportView(lista_nombres_alumnos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(label_observaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(webLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout panel_profesorLayout = new javax.swing.GroupLayout(panel_profesor);
        panel_profesor.setLayout(panel_profesorLayout);
        panel_profesorLayout.setHorizontalGroup(
            panel_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_profesorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(boton_atras_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259)
                .addComponent(titulo_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_profesorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panel_profesorLayout.setVerticalGroup(
            panel_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_profesorLayout.createSequentialGroup()
                .addGroup(panel_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_profesorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boton_atras_profesor))
                    .addGroup(panel_profesorLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(titulo_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_inicio.setBackground(new java.awt.Color(195, 226, 226));
        panel_inicio.setCursor(mickey);
        panel_inicio.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_inicio.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_inicio.setPreferredSize(new java.awt.Dimension(800, 600));

        label_bienvenido.setForeground(new java.awt.Color(0, 0, 255));
        label_bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_bienvenido.setText("Bienvenido");
        label_bienvenido.setToolTipText("");
        label_bienvenido.setFont(font_titulos);
        label_bienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_bienvenido.setMargin(new java.awt.Insets(10, 0, 0, 0));

        boton_profe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/javier.png"))); // NOI18N
        boton_profe1.setText("Javier Cañadilla");
        boton_profe1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        boton_profe1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_profe1.setMaximumSize(new java.awt.Dimension(138, 130));
        boton_profe1.setMinimumSize(new java.awt.Dimension(138, 130));
        boton_profe1.setPreferredSize(new java.awt.Dimension(138, 130));
        boton_profe1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        boton_profe1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        label_infantil.setForeground(new java.awt.Color(0, 0, 255));
        label_infantil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_infantil.setText("Infantil");
        label_infantil.setFont(font_subtitulos);

        panel_login_profesor.setBackground(new java.awt.Color(195, 226, 226));
        panel_login_profesor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)), "Profesor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(51, 102, 255)));

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

        javax.swing.GroupLayout panel_login_profesorLayout = new javax.swing.GroupLayout(panel_login_profesor);
        panel_login_profesor.setLayout(panel_login_profesorLayout);
        panel_login_profesorLayout.setHorizontalGroup(
            panel_login_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_login_profesorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_login_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_login_profesorLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(password_profe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panel_login_profesorLayout.createSequentialGroup()
                        .addComponent(nombre_profe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panel_login_profesorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(boton_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_login_profesorLayout.setVerticalGroup(
            panel_login_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_login_profesorLayout.createSequentialGroup()
                .addComponent(nombre_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_profe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        boton_1A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_A.png"))); // NOI18N

        label_primaria.setForeground(new java.awt.Color(0, 0, 255));
        label_primaria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_primaria.setText("Primaria");
        label_primaria.setFont(font_subtitulos);
        label_primaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        boton_1B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_B.png"))); // NOI18N

        boton_2A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2_A.png"))); // NOI18N

        boton_2B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2_B.png"))); // NOI18N

        boton_profe3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/oscar.PNG"))); // NOI18N
        boton_profe3.setText("Óscar Miranda");
        boton_profe3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        boton_profe3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_profe3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        boton_profe4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        boton_profe4.setText("Profe Prueba");
        boton_profe4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        boton_profe4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_profe4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        boton_profe2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/juanan.png"))); // NOI18N
        boton_profe2.setText("Juan Antonio");
        boton_profe2.setToolTipText("");
        boton_profe2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        boton_profe2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_profe2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panel_inicioLayout = new javax.swing.GroupLayout(panel_inicio);
        panel_inicio.setLayout(panel_inicioLayout);
        panel_inicioLayout.setHorizontalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                .addComponent(boton_1A, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_inicioLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(boton_profe1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_inicioLayout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(boton_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)))
                        .addGap(40, 40, 40)
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addComponent(label_bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(panel_login_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(boton_1B, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton_profe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(boton_2A, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton_profe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel_inicioLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(boton_2B, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boton_profe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(label_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(label_primaria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panel_inicioLayout.setVerticalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_login_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(boton_sonido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_profe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_profe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_profe3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_profe4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(label_primaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_1A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_1B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_2A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_2B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
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
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
            /*PAUSE DE LA MUSICA*/
            try {
                control.pause();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
            /* CONTINUAR MUSICA */
            try {
                if (control_pausado) {
                    control.play();
                } else {
                    control.resume();
                }
                control_pausado = false;
            } catch (BasicPlayerException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (musica_isActive) {
            musica_isActive = false;
        } else {
            musica_isActive = true;
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
            musica_isActive = false;
            /* STOP DE LA MUSICA */
            try {
                control_pausado = true;
                control.stop();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                musica_isActive = false;
                boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
                /* STOP DE LA MUSICA */
                try {
                    control.stop();
                    control_pausado = true;
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    }//GEN-LAST:event_password_profeKeyPressed

    private void boton_atras_profesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_atras_profesorActionPerformed
        panel_profesor.setVisible(false);
        panel_inicio.setVisible(true);
        nombre_profe.clear();
        password_profe.clear();
    }//GEN-LAST:event_boton_atras_profesorActionPerformed

    private void boton_atras_profesorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_atras_profesorMouseEntered
        boton_atras_profesor.setIcon(new ImageIcon(getClass().getResource("/img/atras_profe_hover.png")));
    }//GEN-LAST:event_boton_atras_profesorMouseEntered

    private void boton_atras_profesorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_atras_profesorMouseExited
        boton_atras_profesor.setIcon(new ImageIcon(getClass().getResource("/img/atras_profe.png")));
    }//GEN-LAST:event_boton_atras_profesorMouseExited

    private void boton_atras_profesorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_atras_profesorMousePressed
        boton_atras_profesor.setIcon(new ImageIcon(getClass().getResource("/img/atras_profe_pulsado.png")));
    }//GEN-LAST:event_boton_atras_profesorMousePressed

    private void boton_atras_profesorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_atras_profesorMouseReleased
        boton_atras_profesor.setIcon(new ImageIcon(getClass().getResource("/img/atras_profe.png")));
    }//GEN-LAST:event_boton_atras_profesorMouseReleased

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        if (lista_nombres_alumnos.getSelectedIndex() != -1) {
            Alumno elegido = alumnos.get(lista_nombres_alumnos.getSelectedIndex());
            int seleccion = WebOptionPane.showConfirmDialog(this, "¿Está seguro de modificar la información del alumno?", "Confirmar", WebOptionPane.YES_NO_OPTION,
                    WebOptionPane.QUESTION_MESSAGE);
            if (seleccion == 0) { //SI
                elegido.setNombre(nombre_alumno_profe.getText());
                elegido.setApellidos(apellido_alumno_profe.getText());
                elegido.setTelefono(telefono_alumno_profe.getText());
                elegido.setDireccion(direccion_alumno_profe.getText());
                elegido.setObservaciones(textArea_observaciones.getText());
                generarListadoAlumnos();
                NotificationManager.showNotification("Datos modificados correctamente.").setDisplayTime(2000);
                lista_nombres_alumnos.updateUI(); //Actualizamos la lista con los datos modificados.
            } else {
                cargarDatosAlumno(elegido);
                NotificationManager.showNotification("Datos del alumno restaurados.").setDisplayTime(2000);
            }
        }
    }//GEN-LAST:event_boton_guardarActionPerformed
    /**
     * Métodos de Javi.
     */
    
    public void generarListadoAlumnos(){
        int i = 0;
        for(Alumno elegido : alumnos){
            nombres_lista_alumnos[i] = elegido.getApellidos()+", "+elegido.getNombre();
            i++;
        }
    }

    /**
     * Iniciar sesión con el Nombre y Password que se nos pasa del formulario.
     *
     * @param nombre Nombre de usuario
     * @param pass Password para ese usuario
     * @return True/false si se inicia sesión o no.
     */
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
     * Controlar la música.
     */
    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        if ((bpe.getCode() == BasicPlayerEvent.STOPPED) && musica_isActive) {
            try {
                control.play();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /*Métodos no necesarios de la música */

    @Override
    public void setController(BasicController bc) {
    }

    @Override
    public void opened(Object o, Map map) {
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
    }
    /*Fin metodos no necesarios de la música*/

    /*Métodos necesarios para la lista de alumnos de la IU PROFESOR */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int item = lista_nombres_alumnos.getSelectedIndex();
        Alumno elegido = alumnos.get(item);
        if (!componentes_alumno_activados) {
            activarComponentesDatosAlumno();
        }
        cargarDatosAlumno(elegido);
        cargarFallos(elegido);
    }
    /*Activamos los componentes de la UI profesor */

    public void activarComponentesDatosAlumno() {
        nombre_alumno_profe.setEnabled(true);
        apellido_alumno_profe.setEnabled(true);
        telefono_alumno_profe.setEnabled(true);
        direccion_alumno_profe.setEnabled(true);
        foto_alumno.setEnabled(true);
        textArea_observaciones.setEnabled(true);
        tabla_resultados.setEnabled(true);
        boton_guardar.setEnabled(true);
    }

    /* Cargamos los datos del alumno elegido */
    public void cargarDatosAlumno(Alumno elegido) {
        nombre_alumno_profe.setText(elegido.getNombre());
        apellido_alumno_profe.setText(elegido.getApellidos());
        telefono_alumno_profe.setText(elegido.getTelefono());
        direccion_alumno_profe.setText(elegido.getDireccion());
        foto_alumno.setIcon(elegido.getImagen());
        textArea_observaciones.setText(elegido.getObservaciones());
    }
    /* Cargamos los fallos del alumno elegido en la tabla del profesor */

    public void cargarFallos(Alumno elegido) {
        for (int i = 0; i < 15; i++) {
            modelo_tabla_resultados.setValueAt(elegido.getFallos(i), i, 2);
        }
    }

    /**
     * Fin métodos de Javi.
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    private com.alee.laf.text.WebTextField apellido_alumno_profe;
    private com.alee.laf.button.WebButton boton_1A;
    private com.alee.laf.button.WebButton boton_1B;
    private com.alee.laf.button.WebButton boton_2A;
    private com.alee.laf.button.WebButton boton_2B;
    private javax.swing.JButton boton_atras_profesor;
    private com.alee.laf.button.WebButton boton_entrar;
    private com.alee.laf.button.WebButton boton_guardar;
    private com.alee.laf.button.WebButton boton_profe1;
    private com.alee.laf.button.WebButton boton_profe2;
    private com.alee.laf.button.WebButton boton_profe3;
    private com.alee.laf.button.WebButton boton_profe4;
    private javax.swing.JButton boton_sonido;
    private com.alee.laf.text.WebTextField direccion_alumno_profe;
    private javax.swing.JButton foto_alumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_apellidos_alumno;
    private com.alee.laf.label.WebLabel label_bienvenido;
    private javax.swing.JLabel label_direccion_alumno;
    private com.alee.laf.label.WebLabel label_infantil;
    private javax.swing.JLabel label_nombre_alumno;
    private com.alee.laf.label.WebLabel label_observaciones;
    private com.alee.laf.label.WebLabel label_primaria;
    private javax.swing.JLabel label_telefono_alumno;
    private javax.swing.JList lista_nombres_alumnos;
    private com.alee.laf.text.WebTextField nombre_alumno_profe;
    private com.alee.laf.text.WebTextField nombre_profe;
    private javax.swing.JPanel panel_inicio;
    private javax.swing.JPanel panel_login_profesor;
    private javax.swing.JPanel panel_profesor;
    private com.alee.laf.text.WebPasswordField password_profe;
    private com.alee.laf.table.WebTable tabla_resultados;
    private com.alee.laf.text.WebTextField telefono_alumno_profe;
    private com.alee.laf.text.WebTextArea textArea_observaciones;
    private com.alee.laf.label.WebLabel titulo_profesor;
    private com.alee.laf.label.WebLabel webLabel1;
    private com.alee.laf.label.WebLabel webLabel2;
    // End of variables declaration//GEN-END:variables
}
