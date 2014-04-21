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
import javax.swing.JButton;
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
    Font font_titulos, font_subtitulos, font_titulo_login;
    String fontName = "/img/GinSSB60.ttf";
    String fontNametildes = "/img/palmemim.ttf";
    Font font, font_tildes;
    boolean musica_isActive;

    /* Varibles Javi */
    Profesor profesor;
    ImageIcon fondo_inicio;
    BasicPlayer player = new BasicPlayer();
    BasicController control = (BasicController) player;
    File array_musica;
    boolean control_pausado;
    String[] nombres_lista_alumnos = new String[8];
    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    TableModel modelo_tabla_resultados;
    boolean componentes_alumno_activados = false;
    private boolean[] gato = {false, false, false, false};
    private boolean[] sol = {false, false, false};
    private boolean[] lapiz = {false, false, false, false, false};
    private boolean[] goma = {false, false, false, false};
    /* Variables Juanan */
    boolean letraJ = false;
    boolean letraU = false;
    boolean letraA = false;
    boolean letraN = false;
    /* Variables Oscar */
    Font font_boton_niveles, font_titulo_niveles;

    /**
     * Creates new form UI.
     */
    public UI() {
        /**
         * Creación de profesor/es.
         */
        profesor = new Profesor("profesor", "pass");

        /**
         * Creación de Alumnos.
         */
        alumnos.add(new Alumno("Maria", "Antonio Armada", "918113226", "Calle de la Piruleta, nº3"));
        alumnos.add(new Alumno("Beatriz", "Campos Campos", "918115626", "Calle de Alemania, nº8"));
        alumnos.add(new Alumno("Javier", "Cañadilla Casco", "918113226", "Calle de la Piruleta, nº3"));
        alumnos.add(new Alumno("Juan Antonio", "Echeverrias Aranda", "918119926", "Calle del Doctor Mateo, nº33"));
        alumnos.add(new Alumno("Oscar", "Miranda Bravo", "918183722", "Avenida de los mercados, nº5"));
        alumnos.add(new Alumno("José", "Pérez Navarro", "918185672", "Avenida de los barcos, nº15"));
        alumnos.add(new Alumno("Gustavo", "Romero Álvarez", "918168677", "Paseo del Alparrache, nº7"));
        alumnos.add(new Alumno("Fernando", "Ruiz Valenzuela", "918115478", "Paseo de la piruleta, nº37"));
        /**
         * Cambiamos la foto por defecto.
         */
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
         * INICIALIZACIÓN FUENTE.
         */
        try {
            //Se carga la fuente
            InputStream is = getClass().getResourceAsStream(fontNametildes);
            font_tildes = Font.createFont(Font.TRUETYPE_FONT, is);
            InputStream is2 = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is2);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
            font_tildes = new Font("Arial", Font.PLAIN, 14);

        }
        /**
         * Fuentes utilizadas por Javi.
         */
        font_titulos = font.deriveFont(70f).deriveFont(Font.BOLD);
        font_titulo_login = font_tildes.deriveFont(60f).deriveFont(Font.BOLD);
        font_subtitulos = font.deriveFont(40f).deriveFont(Font.BOLD);

        /**
         * Fuentes utilizadas por Oscar.
         */
        font_boton_niveles = font.deriveFont(30f).deriveFont(1);
        font_titulo_niveles = font.deriveFont(50f).deriveFont(1);

        /**
         * INICIAMOS LOS COMPONENTES.
         */
        initComponents();

        /**
         * Ocultamos todos los paneles menos el INICIO.
         */
        panel_inicio.setVisible(true);
        panel_profesor.setVisible(false);
        panel_login.setVisible(false);
        panel_fase1.setVisible(false);
        panel_fases.setVisible(false);
        panel_pass_infantil.setVisible(false);
        panel_pass_primaria.setVisible(false);
        panel_nivel1fase2.setVisible(false);
        panel_nivel2fase2.setVisible(false);
        panel_nivel3fase2.setVisible(false);
        panel_acertado.setVisible(false);
        panel_fase2.setVisible(false);
        panelPalabrasNivel1.setVisible(false);
        panel_fase3.setVisible(false);

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
         * Lista alumnos -> IU PROFESOR.
         */
        lista_nombres_alumnos.addListSelectionListener(this); //Agregamos el listener.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_fases =  new JPanelCustom("/img/fondoFases.png");
        escuela = new javax.swing.JButton();
        barco = new javax.swing.JButton();
        piramide = new javax.swing.JButton();
        selva = new javax.swing.JButton();
        biblioteca = new javax.swing.JButton();
        titulo_fases = new com.alee.laf.label.WebLabel();
        boton_sonido2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panel_login = new javax.swing.JPanel();
        boton_sonido1 = new javax.swing.JButton();
        atras_login = new javax.swing.JButton();
        home_login = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        alumno1 = new javax.swing.JButton();
        alumno2 = new javax.swing.JButton();
        alumno3 = new javax.swing.JButton();
        alumno4 = new javax.swing.JButton();
        alumno5 = new javax.swing.JButton();
        alumno6 = new javax.swing.JButton();
        alumno7 = new javax.swing.JButton();
        alumno8 = new javax.swing.JButton();
        titulo_login = new javax.swing.JLabel();
        panel_fase1 = new JPanelCustom("/img/fondoClase.png");
        nivel1fase1 = new javax.swing.JButton();
        nivel2fase1 = new javax.swing.JButton();
        nivel3fase1 = new javax.swing.JButton();
        nivel4fase1 = new javax.swing.JButton();
        TituloFase1 = new com.alee.laf.label.WebLabel();
        backFase1 = new javax.swing.JButton();
        homeFase1 = new javax.swing.JButton();
        panel_pass_infantil = new JPanelCustom("/img/fondo_password2.jpg");
        globo1 = new javax.swing.JButton();
        globo2 = new javax.swing.JButton();
        globo3 = new javax.swing.JButton();
        globo4 = new javax.swing.JButton();
        globo5 = new javax.swing.JButton();
        globo6 = new javax.swing.JButton();
        globo7 = new javax.swing.JButton();
        globo8 = new javax.swing.JButton();
        globo9 = new javax.swing.JButton();
        globo10 = new javax.swing.JButton();
        globo11 = new javax.swing.JButton();
        globo12 = new javax.swing.JButton();
        globo13 = new javax.swing.JButton();
        globo14 = new javax.swing.JButton();
        globo15 = new javax.swing.JButton();
        globo16 = new javax.swing.JButton();
        globo17 = new javax.swing.JButton();
        globo18 = new javax.swing.JButton();
        globo19 = new javax.swing.JButton();
        globo20 = new javax.swing.JButton();
        globo21 = new javax.swing.JButton();
        globo22 = new javax.swing.JButton();
        globo23 = new javax.swing.JButton();
        globo24 = new javax.swing.JButton();
        globo25 = new javax.swing.JButton();
        titulo_password2 = new com.alee.laf.label.WebLabel();
        boton_sonido3 = new javax.swing.JButton();
        back_pass_infantil = new javax.swing.JButton();
        home_pass_infantil = new javax.swing.JButton();
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
        panel_pass_primaria = new JPanelCustom("/img/fondo_password1.jpg");
        letra1 = new javax.swing.JButton();
        letra2 = new javax.swing.JButton();
        letra3 = new javax.swing.JButton();
        letra4 = new javax.swing.JButton();
        letra5 = new javax.swing.JButton();
        letra6 = new javax.swing.JButton();
        letra7 = new javax.swing.JButton();
        letra8 = new javax.swing.JButton();
        letra9 = new javax.swing.JButton();
        letra10 = new javax.swing.JButton();
        letra11 = new javax.swing.JButton();
        letra12 = new javax.swing.JButton();
        letra13 = new javax.swing.JButton();
        letra14 = new javax.swing.JButton();
        letra15 = new javax.swing.JButton();
        letra16 = new javax.swing.JButton();
        letra17 = new javax.swing.JButton();
        letra18 = new javax.swing.JButton();
        letra19 = new javax.swing.JButton();
        letra20 = new javax.swing.JButton();
        letra21 = new javax.swing.JButton();
        letra22 = new javax.swing.JButton();
        letra23 = new javax.swing.JButton();
        letra24 = new javax.swing.JButton();
        letra25 = new javax.swing.JButton();
        letra26 = new javax.swing.JButton();
        letra27 = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        letraJprimaria = new javax.swing.JLabel();
        letraUprimaria = new javax.swing.JLabel();
        letraAprimaria = new javax.swing.JLabel();
        letraNprimaria = new javax.swing.JLabel();
        back_login_primaria = new javax.swing.JButton();
        home_login_primaria = new javax.swing.JButton();
        sonido_LoginPrimaria = new javax.swing.JButton();
        panel_nivel1fase2 = new JPanelCustom("/img/fondoBarco.png");
        TituloSilabas1 = new com.alee.laf.label.WebLabel();
        backSilabas1 = new javax.swing.JButton();
        homeSilabas1 = new javax.swing.JButton();
        silabasImg1 = new javax.swing.JButton();
        soluciónsilabas1 = new javax.swing.JButton();
        boton1silabas1 = new javax.swing.JButton();
        boton2silabas1 = new javax.swing.JButton();
        boton3silabas1 = new javax.swing.JButton();
        panel_nivel2fase2 = new JPanelCustom("/img/fondoBarco.png");
        TituloSilabas2 = new com.alee.laf.label.WebLabel();
        backSilabas2 = new javax.swing.JButton();
        homeSilabas2 = new javax.swing.JButton();
        silabasImg2 = new javax.swing.JButton();
        soluciónsilabas2 = new javax.swing.JButton();
        boton1silabas2 = new javax.swing.JButton();
        boton2silabas2 = new javax.swing.JButton();
        boton3silabas2 = new javax.swing.JButton();
        panel_nivel3fase2 = new JPanelCustom("/img/fondoBarco.png");
        TituloSilabas3 = new com.alee.laf.label.WebLabel();
        backSilabas3 = new javax.swing.JButton();
        homeSilabas3 = new javax.swing.JButton();
        silabasImg3 = new javax.swing.JButton();
        boton1silabas3 = new javax.swing.JButton();
        boton2silabas3 = new javax.swing.JButton();
        solucionsilabas3 = new javax.swing.JButton();
        boton3silabas3 = new javax.swing.JButton();
        panel_acertado = new JPanelCustom("/img/acertado.png");
        panel_fase2 = new JPanelCustom("/img/fondoBarco.png");
        nivel1fase2 = new javax.swing.JButton();
        nivel2fase2 = new javax.swing.JButton();
        nivel3fase2 = new javax.swing.JButton();
        TituloFase2 = new com.alee.laf.label.WebLabel();
        backFase2 = new javax.swing.JButton();
        homeFase2 = new javax.swing.JButton();
        panelPalabrasNivel1 = new JPanelCustom("/img/fondoPiramide.png");
        sopaLetras = new JPanel();
        letraG_gato = new javax.swing.JButton();
        letraA_gato = new javax.swing.JButton();
        letraT_gato = new javax.swing.JButton();
        letraO_gato = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        letraG_goma = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        letraO_goma = new javax.swing.JButton();
        letraS_sol = new javax.swing.JButton();
        letraO_sol = new javax.swing.JButton();
        letraL_sol = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        letraM_goma = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        letraA_goma = new javax.swing.JButton();
        letraL_lapiz = new javax.swing.JButton();
        letraA_lapiz = new javax.swing.JButton();
        letraP_lapiz = new javax.swing.JButton();
        letraI_lapiz = new javax.swing.JButton();
        letraZ_lapiz = new javax.swing.JButton();
        imagenGato = new javax.swing.JLabel();
        imagenGoma = new javax.swing.JLabel();
        imagenLapiz = new javax.swing.JLabel();
        imagenSol = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        panel_fase3 = new JPanelCustom("/img/fondoPiramide.png");
        nivel1fase3 = new javax.swing.JButton();
        nivel2fase3 = new javax.swing.JButton();
        nivel3fase3 = new javax.swing.JButton();
        nivel4fase3 = new javax.swing.JButton();
        TituloFase3 = new com.alee.laf.label.WebLabel();
        backFase3 = new javax.swing.JButton();
        homeFase3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación de lectura");
        setBounds(new java.awt.Rectangle(800, 600, 600, 600));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panel_fases.setCursor(mickey);
        panel_fases.setFont(font_titulos);
        panel_fases.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_fases.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_fases.setPreferredSize(new java.awt.Dimension(800, 600));

        escuela.setFont(font_titulos);
        escuela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/school.png"))); // NOI18N
        escuela.setBorder(null);
        escuela.setBorderPainted(false);
        escuela.setContentAreaFilled(false);
        escuela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        escuela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        escuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                escuelaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                escuelaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                escuelaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                escuelaMouseReleased(evt);
            }
        });
        escuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuelaActionPerformed(evt);
            }
        });

        barco.setFont(font_titulos);
        barco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barco.png"))); // NOI18N
        barco.setBorder(null);
        barco.setBorderPainted(false);
        barco.setContentAreaFilled(false);
        barco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        barco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barcoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barcoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barcoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                barcoMouseReleased(evt);
            }
        });
        barco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcoActionPerformed(evt);
            }
        });

        piramide.setFont(font_titulos);
        piramide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piramide.png"))); // NOI18N
        piramide.setBorder(null);
        piramide.setBorderPainted(false);
        piramide.setContentAreaFilled(false);
        piramide.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        piramide.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        piramide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piramideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                piramideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                piramideMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                piramideMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                piramideMouseReleased(evt);
            }
        });
        piramide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piramideActionPerformed(evt);
            }
        });

        selva.setFont(font_titulos);
        selva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Selva.png"))); // NOI18N
        selva.setBorder(null);
        selva.setBorderPainted(false);
        selva.setContentAreaFilled(false);
        selva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        selva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selvaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selvaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selvaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selvaMouseReleased(evt);
            }
        });

        biblioteca.setFont(font_titulos);
        biblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/biblioteca.png"))); // NOI18N
        biblioteca.setBorder(null);
        biblioteca.setBorderPainted(false);
        biblioteca.setContentAreaFilled(false);
        biblioteca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        biblioteca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        biblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bibliotecaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bibliotecaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bibliotecaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bibliotecaMouseReleased(evt);
            }
        });

        titulo_fases.setForeground(new java.awt.Color(0, 0, 255));
        titulo_fases.setText("¿Dónde quieres jugar hoy?");
        titulo_fases.setFont(new java.awt.Font("PalMeMim", 1, 36)); // NOI18N

        boton_sonido2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido.png"))); // NOI18N
        boton_sonido2.setBorderPainted(false);
        boton_sonido2.setContentAreaFilled(false);
        boton_sonido2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_sonido2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_sonido2MouseReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("PalMeMim", 1, 30)); // NOI18N
        jLabel2.setText("<html><center>La escuela de <br> las letras</center></html>");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("PalMeMim", 1, 30)); // NOI18N
        jLabel3.setText("<html><center>Viajando con<br> las sílabas</center></html>");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("PalMeMim", 1, 30)); // NOI18N
        jLabel4.setText("<html><center>Descubriendo las<br> palabras</center></html>");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("PalMeMim", 1, 30)); // NOI18N
        jLabel5.setText("La biblioteca de textos");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("PalMeMim", 1, 30)); // NOI18N
        jLabel6.setText("Explorando las frases");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setEnabled(false);

        javax.swing.GroupLayout panel_fasesLayout = new javax.swing.GroupLayout(panel_fases);
        panel_fases.setLayout(panel_fasesLayout);
        panel_fasesLayout.setHorizontalGroup(
            panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fasesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_fasesLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(escuela))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(barco)
                        .addGap(335, 335, 335))
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_fasesLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(boton_sonido2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(titulo_fases, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_fasesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panel_fasesLayout.createSequentialGroup()
                .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(selva)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fasesLayout.createSequentialGroup()
                        .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(piramide)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fasesLayout.createSequentialGroup()
                        .addComponent(biblioteca)
                        .addGap(69, 69, 69))))
        );
        panel_fasesLayout.setVerticalGroup(
            panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fasesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addComponent(boton_sonido2)
                        .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_fasesLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(barco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_fasesLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_fasesLayout.createSequentialGroup()
                                        .addComponent(escuela, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_fasesLayout.createSequentialGroup()
                                        .addComponent(piramide)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))))
                    .addComponent(titulo_fases, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(biblioteca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38))
                    .addGroup(panel_fasesLayout.createSequentialGroup()
                        .addComponent(selva)
                        .addGap(0, 0, 0)
                        .addGroup(panel_fasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panel_login.setBackground(new java.awt.Color(195, 226, 226));
        panel_login.setCursor(mickey    );
        panel_login.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_login.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_login.setPreferredSize(new java.awt.Dimension(800, 600));

        boton_sonido1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido.png"))); // NOI18N
        boton_sonido1.setBorderPainted(false);
        boton_sonido1.setContentAreaFilled(false);
        boton_sonido1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_sonido1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_sonido1MouseReleased(evt);
            }
        });

        atras_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        atras_login.setBorderPainted(false);
        atras_login.setContentAreaFilled(false);
        atras_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atras_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                atras_loginMouseExited(evt);
            }
        });
        atras_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras_loginActionPerformed(evt);
            }
        });

        home_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        home_login.setBorderPainted(false);
        home_login.setContentAreaFilled(false);
        home_login.setEnabled(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/up.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setEnabled(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/down.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setEnabled(false);

        alumno1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        alumno1.setText("María Antonio");
        alumno1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        alumno2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        alumno2.setText("Beatriz Campos");
        alumno2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        alumno3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/javier.png"))); // NOI18N
        alumno3.setText("Javier Cañadilla");
        alumno3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno3.setPreferredSize(new java.awt.Dimension(145, 139));
        alumno3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alumno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumno3ActionPerformed(evt);
            }
        });

        alumno4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/juanan.png"))); // NOI18N
        alumno4.setText("Juan Echeverrías");
        alumno4.setActionCommand("Juan Echeverrias");
        alumno4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno4.setPreferredSize(new java.awt.Dimension(145, 149));
        alumno4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alumno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumno4ActionPerformed(evt);
            }
        });

        alumno5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/oscar.PNG"))); // NOI18N
        alumno5.setText("Óscar Miranda");
        alumno5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno5.setPreferredSize(new java.awt.Dimension(145, 139));
        alumno5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        alumno6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        alumno6.setText("José Pérez");
        alumno6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno6.setPreferredSize(new java.awt.Dimension(145, 139));
        alumno6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        alumno7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        alumno7.setText("Gustavo Romero");
        alumno7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno7.setPreferredSize(new java.awt.Dimension(145, 139));
        alumno7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        alumno8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        alumno8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carnet_prueba.png"))); // NOI18N
        alumno8.setText("Fernando Ruiz");
        alumno8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alumno8.setPreferredSize(new java.awt.Dimension(145, 149));
        alumno8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        titulo_login.setFont(new java.awt.Font("PalMeMim", 1, 40)); // NOI18N
        titulo_login.setForeground(new java.awt.Color(0, 0, 255));
        titulo_login.setText("¿Cómo te llamas?");
        titulo_login.setToolTipText("");

        javax.swing.GroupLayout panel_loginLayout = new javax.swing.GroupLayout(panel_login);
        panel_login.setLayout(panel_loginLayout);
        panel_loginLayout.setHorizontalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_loginLayout.createSequentialGroup()
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(atras_login, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_login, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_loginLayout.createSequentialGroup()
                                        .addComponent(alumno5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(alumno6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(alumno7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_loginLayout.createSequentialGroup()
                                        .addComponent(alumno1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(alumno2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(alumno3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alumno4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alumno8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addComponent(boton_sonido1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(titulo_login)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_loginLayout.setVerticalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boton_sonido1)
                    .addComponent(titulo_login))
                .addGap(30, 30, 30)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alumno2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alumno3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alumno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alumno6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumno7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumno5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addComponent(alumno4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addGap(51, 51, 51)))
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alumno8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atras_login, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home_login))
                .addGap(45, 45, 45))
        );

        panel_fase1.setBackground(new java.awt.Color(204, 255, 204));
        panel_fase1.setCursor(mickey);
        panel_fase1.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_fase1.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_fase1.setPreferredSize(new java.awt.Dimension(800, 600));

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
        backFase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFase1ActionPerformed(evt);
            }
        });

        homeFase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeFase1.setBorderPainted(false);
        homeFase1.setContentAreaFilled(false);
        homeFase1.setEnabled(false);

        javax.swing.GroupLayout panel_fase1Layout = new javax.swing.GroupLayout(panel_fase1);
        panel_fase1.setLayout(panel_fase1Layout);
        panel_fase1Layout.setHorizontalGroup(
            panel_fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fase1Layout.createSequentialGroup()
                .addGroup(panel_fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fase1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(panel_fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nivel1fase1)
                            .addComponent(nivel3fase1))
                        .addGap(140, 140, 140)
                        .addGroup(panel_fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nivel2fase1)
                            .addComponent(nivel4fase1)))
                    .addGroup(panel_fase1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(TituloFase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_fase1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(backFase1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeFase1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        panel_fase1Layout.setVerticalGroup(
            panel_fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fase1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(nivel2fase1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(nivel4fase1)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fase1Layout.createSequentialGroup()
                .addGroup(panel_fase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_fase1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeFase1))
                    .addGroup(panel_fase1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(TituloFase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(nivel1fase1)
                        .addGap(51, 51, 51)
                        .addComponent(nivel3fase1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backFase1)))
                .addGap(40, 40, 40))
        );

        panel_pass_infantil.setCursor(mickey);
        panel_pass_infantil.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_pass_infantil.setMinimumSize(new java.awt.Dimension(800, 600));

        globo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo1.png"))); // NOI18N
        globo1.setBorder(null);
        globo1.setBorderPainted(false);
        globo1.setContentAreaFilled(false);
        globo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo1MouseReleased(evt);
            }
        });

        globo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo2.png"))); // NOI18N
        globo2.setBorder(null);
        globo2.setBorderPainted(false);
        globo2.setContentAreaFilled(false);
        globo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo2MouseReleased(evt);
            }
        });

        globo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo3.png"))); // NOI18N
        globo3.setBorder(null);
        globo3.setBorderPainted(false);
        globo3.setContentAreaFilled(false);
        globo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo3MouseReleased(evt);
            }
        });

        globo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo4.png"))); // NOI18N
        globo4.setBorder(null);
        globo4.setBorderPainted(false);
        globo4.setContentAreaFilled(false);
        globo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo4MouseReleased(evt);
            }
        });

        globo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo5.png"))); // NOI18N
        globo5.setBorder(null);
        globo5.setBorderPainted(false);
        globo5.setContentAreaFilled(false);
        globo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo5MouseReleased(evt);
            }
        });

        globo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo6.png"))); // NOI18N
        globo6.setBorder(null);
        globo6.setBorderPainted(false);
        globo6.setContentAreaFilled(false);
        globo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo6MouseReleased(evt);
            }
        });

        globo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo7.png"))); // NOI18N
        globo7.setBorder(null);
        globo7.setBorderPainted(false);
        globo7.setContentAreaFilled(false);
        globo7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo7MouseReleased(evt);
            }
        });

        globo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo8.png"))); // NOI18N
        globo8.setBorder(null);
        globo8.setBorderPainted(false);
        globo8.setContentAreaFilled(false);
        globo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo8MouseReleased(evt);
            }
        });

        globo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo9.png"))); // NOI18N
        globo9.setBorder(null);
        globo9.setBorderPainted(false);
        globo9.setContentAreaFilled(false);
        globo9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo9MouseReleased(evt);
            }
        });

        globo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo10.png"))); // NOI18N
        globo10.setBorder(null);
        globo10.setBorderPainted(false);
        globo10.setContentAreaFilled(false);
        globo10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo10MouseReleased(evt);
            }
        });

        globo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo11.png"))); // NOI18N
        globo11.setBorder(null);
        globo11.setBorderPainted(false);
        globo11.setContentAreaFilled(false);
        globo11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo11MouseReleased(evt);
            }
        });

        globo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo12.png"))); // NOI18N
        globo12.setBorder(null);
        globo12.setBorderPainted(false);
        globo12.setContentAreaFilled(false);
        globo12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo12MouseReleased(evt);
            }
        });

        globo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo13.png"))); // NOI18N
        globo13.setBorder(null);
        globo13.setBorderPainted(false);
        globo13.setContentAreaFilled(false);
        globo13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo13MouseReleased(evt);
            }
        });

        globo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo14.png"))); // NOI18N
        globo14.setBorder(null);
        globo14.setBorderPainted(false);
        globo14.setContentAreaFilled(false);
        globo14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo14MouseReleased(evt);
            }
        });

        globo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo15.png"))); // NOI18N
        globo15.setBorder(null);
        globo15.setBorderPainted(false);
        globo15.setContentAreaFilled(false);
        globo15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo15MouseReleased(evt);
            }
        });

        globo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo16.png"))); // NOI18N
        globo16.setBorder(null);
        globo16.setBorderPainted(false);
        globo16.setContentAreaFilled(false);
        globo16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo16MouseReleased(evt);
            }
        });

        globo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo17.png"))); // NOI18N
        globo17.setBorder(null);
        globo17.setBorderPainted(false);
        globo17.setContentAreaFilled(false);
        globo17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo17MouseReleased(evt);
            }
        });

        globo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo18.png"))); // NOI18N
        globo18.setBorder(null);
        globo18.setBorderPainted(false);
        globo18.setContentAreaFilled(false);
        globo18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo18MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo18MouseReleased(evt);
            }
        });

        globo19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo19.png"))); // NOI18N
        globo19.setBorder(null);
        globo19.setBorderPainted(false);
        globo19.setContentAreaFilled(false);
        globo19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo19MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo19MouseReleased(evt);
            }
        });

        globo20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo20.png"))); // NOI18N
        globo20.setBorder(null);
        globo20.setBorderPainted(false);
        globo20.setContentAreaFilled(false);
        globo20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo20MouseReleased(evt);
            }
        });

        globo21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo21.png"))); // NOI18N
        globo21.setBorder(null);
        globo21.setBorderPainted(false);
        globo21.setContentAreaFilled(false);
        globo21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo21MouseReleased(evt);
            }
        });

        globo22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo22.png"))); // NOI18N
        globo22.setBorder(null);
        globo22.setBorderPainted(false);
        globo22.setContentAreaFilled(false);
        globo22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo22MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo22MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo22MouseReleased(evt);
            }
        });

        globo23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo23.png"))); // NOI18N
        globo23.setBorder(null);
        globo23.setBorderPainted(false);
        globo23.setContentAreaFilled(false);
        globo23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo23MouseReleased(evt);
            }
        });

        globo24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo24.png"))); // NOI18N
        globo24.setBorder(null);
        globo24.setBorderPainted(false);
        globo24.setContentAreaFilled(false);
        globo24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo24MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo24MouseReleased(evt);
            }
        });

        globo25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo25.png"))); // NOI18N
        globo25.setBorder(null);
        globo25.setBorderPainted(false);
        globo25.setContentAreaFilled(false);
        globo25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                globo25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                globo25MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                globo25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                globo25MouseReleased(evt);
            }
        });

        titulo_password2.setForeground(new java.awt.Color(0, 0, 255));
        titulo_password2.setText("Introduce tu número de lista");
        titulo_password2.setFont(new java.awt.Font("PalMeMim", 1, 36)); // NOI18N

        boton_sonido3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido.png"))); // NOI18N
        boton_sonido3.setBorderPainted(false);
        boton_sonido3.setContentAreaFilled(false);
        boton_sonido3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_sonido3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_sonido3MouseReleased(evt);
            }
        });

        back_pass_infantil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        back_pass_infantil.setBorderPainted(false);
        back_pass_infantil.setContentAreaFilled(false);
        back_pass_infantil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_pass_infantilActionPerformed(evt);
            }
        });

        home_pass_infantil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        home_pass_infantil.setBorderPainted(false);
        home_pass_infantil.setContentAreaFilled(false);
        home_pass_infantil.setEnabled(false);

        javax.swing.GroupLayout panel_pass_infantilLayout = new javax.swing.GroupLayout(panel_pass_infantil);
        panel_pass_infantil.setLayout(panel_pass_infantilLayout);
        panel_pass_infantilLayout.setHorizontalGroup(
            panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_sonido3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(titulo_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(back_pass_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_pass_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(globo3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pass_infantilLayout.createSequentialGroup()
                                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                                .addComponent(globo1)
                                                .addGap(33, 33, 33))
                                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                                .addComponent(globo9)
                                                .addGap(44, 44, 44)))
                                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(globo2)
                                            .addComponent(globo10))
                                        .addGap(48, 48, 48)
                                        .addComponent(globo11)))
                                .addGap(40, 40, 40)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addComponent(globo4)
                                        .addGap(37, 37, 37)
                                        .addComponent(globo5)
                                        .addGap(48, 48, 48)
                                        .addComponent(globo6)
                                        .addGap(46, 46, 46)
                                        .addComponent(globo7))
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addComponent(globo12)
                                        .addGap(49, 49, 49)
                                        .addComponent(globo13)
                                        .addGap(58, 58, 58)
                                        .addComponent(globo14)
                                        .addGap(37, 37, 37)
                                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(globo24)
                                            .addComponent(globo15))))
                                .addGap(18, 18, 18)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(globo8)
                                    .addComponent(globo16)
                                    .addComponent(globo25)))
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addComponent(globo17)
                                .addGap(31, 31, 31)
                                .addComponent(globo18)
                                .addGap(30, 30, 30)
                                .addComponent(globo19)
                                .addGap(35, 35, 35)
                                .addComponent(globo20)
                                .addGap(44, 44, 44)
                                .addComponent(globo21)
                                .addGap(38, 38, 38)
                                .addComponent(globo22)
                                .addGap(29, 29, 29)
                                .addComponent(globo23)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panel_pass_infantilLayout.setVerticalGroup(
            panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pass_infantilLayout.createSequentialGroup()
                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(home_pass_infantil))
                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titulo_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_sonido3))
                        .addGap(29, 29, 29)
                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(globo6)
                                            .addComponent(globo8)
                                            .addComponent(globo4)
                                            .addComponent(globo2))
                                        .addGap(22, 22, 22))
                                    .addComponent(globo1))
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(globo12))
                                    .addComponent(globo10, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(globo5)
                                    .addComponent(globo7)
                                    .addComponent(globo3))
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(globo9))
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(globo11))
                                    .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(globo14))
                                            .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(globo15)
                                                .addComponent(globo13, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(globo16)))))))
                        .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(globo23)
                                    .addComponent(globo21)))
                            .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(globo25)
                                    .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(globo18)
                                        .addGroup(panel_pass_infantilLayout.createSequentialGroup()
                                            .addGap(44, 44, 44)
                                            .addComponent(globo19))
                                        .addComponent(globo20)
                                        .addComponent(globo24))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pass_infantilLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_pass_infantilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pass_infantilLayout.createSequentialGroup()
                                        .addComponent(globo17)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pass_infantilLayout.createSequentialGroup()
                                        .addComponent(globo22)
                                        .addGap(42, 42, 42)))))
                        .addGap(32, 32, 32)
                        .addComponent(back_pass_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

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
        jPanel3.setOpaque(false);
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

        webLabel1.setText("Seleccione un alumno de la lista:");
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
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del alumno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel2.setOpaque(false);

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
                .addGap(261, 261, 261))
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
                            .addComponent(jScrollPane1))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_profesorLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
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
                .addContainerGap(9, Short.MAX_VALUE))
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
        label_bienvenido.setFont(new java.awt.Font("GinoSchoolScript", 1, 45)); // NOI18N
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
        boton_profe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_profe1ActionPerformed(evt);
            }
        });

        label_infantil.setForeground(new java.awt.Color(0, 0, 255));
        label_infantil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_infantil.setText("Infantil");
        label_infantil.setFont(new java.awt.Font("GinoSchoolScript", 1, 24)); // NOI18N

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
        label_primaria.setFont(new java.awt.Font("GinoSchoolScript", 1, 24)); // NOI18N
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
                        .addGap(57, 57, 57)
                        .addComponent(label_primaria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boton_profe1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                        .addComponent(boton_sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                                        .addComponent(boton_1A, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(label_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                        .addComponent(boton_profe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panel_inicioLayout.createSequentialGroup()
                                .addComponent(label_bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel_login_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panel_inicioLayout.setVerticalGroup(
            panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_inicioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_login_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label_bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boton_sonido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addComponent(label_infantil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_profe1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_inicioLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boton_profe3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_profe4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_profe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panel_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_2A, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_2B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_inicioLayout.createSequentialGroup()
                        .addComponent(label_primaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton_1A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boton_1B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        panel_pass_primaria.setCursor(mickey);
        panel_pass_primaria.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_pass_primaria.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_pass_primaria.setPreferredSize(new java.awt.Dimension(800, 600));

        letra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_a.png"))); // NOI18N
        letra1.setBorder(null);
        letra1.setBorderPainted(false);
        letra1.setContentAreaFilled(false);
        letra1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                letra1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra1MouseReleased(evt);
            }
        });

        letra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_b.png"))); // NOI18N
        letra2.setBorder(null);
        letra2.setBorderPainted(false);
        letra2.setContentAreaFilled(false);
        letra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra2MouseReleased(evt);
            }
        });

        letra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_c.png"))); // NOI18N
        letra3.setBorder(null);
        letra3.setBorderPainted(false);
        letra3.setContentAreaFilled(false);
        letra3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra3MouseReleased(evt);
            }
        });

        letra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_d.png"))); // NOI18N
        letra4.setBorder(null);
        letra4.setBorderPainted(false);
        letra4.setContentAreaFilled(false);
        letra4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra4MouseReleased(evt);
            }
        });

        letra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_e.png"))); // NOI18N
        letra5.setBorder(null);
        letra5.setBorderPainted(false);
        letra5.setContentAreaFilled(false);
        letra5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra5MouseReleased(evt);
            }
        });

        letra6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_f.png"))); // NOI18N
        letra6.setBorder(null);
        letra6.setBorderPainted(false);
        letra6.setContentAreaFilled(false);
        letra6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra6MouseReleased(evt);
            }
        });

        letra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_g.png"))); // NOI18N
        letra7.setBorder(null);
        letra7.setBorderPainted(false);
        letra7.setContentAreaFilled(false);
        letra7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra7MouseReleased(evt);
            }
        });

        letra8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_h.png"))); // NOI18N
        letra8.setBorder(null);
        letra8.setBorderPainted(false);
        letra8.setContentAreaFilled(false);
        letra8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra8MouseReleased(evt);
            }
        });

        letra9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_i.png"))); // NOI18N
        letra9.setBorder(null);
        letra9.setBorderPainted(false);
        letra9.setContentAreaFilled(false);
        letra9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra9MouseReleased(evt);
            }
        });

        letra10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_j.png"))); // NOI18N
        letra10.setBorder(null);
        letra10.setBorderPainted(false);
        letra10.setContentAreaFilled(false);
        letra10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                letra10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra10MouseReleased(evt);
            }
        });
        letra10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letra10ActionPerformed(evt);
            }
        });

        letra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_k.png"))); // NOI18N
        letra11.setBorder(null);
        letra11.setBorderPainted(false);
        letra11.setContentAreaFilled(false);
        letra11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra11MouseReleased(evt);
            }
        });

        letra12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_l.png"))); // NOI18N
        letra12.setBorder(null);
        letra12.setBorderPainted(false);
        letra12.setContentAreaFilled(false);
        letra12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra12MouseReleased(evt);
            }
        });

        letra13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_m.png"))); // NOI18N
        letra13.setBorder(null);
        letra13.setBorderPainted(false);
        letra13.setContentAreaFilled(false);
        letra13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra13MouseReleased(evt);
            }
        });

        letra14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_n.png"))); // NOI18N
        letra14.setBorder(null);
        letra14.setBorderPainted(false);
        letra14.setContentAreaFilled(false);
        letra14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                letra14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra14MouseReleased(evt);
            }
        });

        letra15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_nn.png"))); // NOI18N
        letra15.setBorder(null);
        letra15.setBorderPainted(false);
        letra15.setContentAreaFilled(false);
        letra15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra15MouseReleased(evt);
            }
        });

        letra16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_o.png"))); // NOI18N
        letra16.setBorder(null);
        letra16.setBorderPainted(false);
        letra16.setContentAreaFilled(false);
        letra16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra16MouseReleased(evt);
            }
        });

        letra17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_p.png"))); // NOI18N
        letra17.setBorder(null);
        letra17.setBorderPainted(false);
        letra17.setContentAreaFilled(false);
        letra17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra17MouseReleased(evt);
            }
        });

        letra18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_q.png"))); // NOI18N
        letra18.setBorder(null);
        letra18.setBorderPainted(false);
        letra18.setContentAreaFilled(false);
        letra18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra18MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra18MouseReleased(evt);
            }
        });

        letra19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_r.png"))); // NOI18N
        letra19.setBorder(null);
        letra19.setBorderPainted(false);
        letra19.setContentAreaFilled(false);
        letra19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra19MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra19MouseReleased(evt);
            }
        });

        letra20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_s.png"))); // NOI18N
        letra20.setBorder(null);
        letra20.setBorderPainted(false);
        letra20.setContentAreaFilled(false);
        letra20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra20MouseReleased(evt);
            }
        });

        letra21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_t.png"))); // NOI18N
        letra21.setBorder(null);
        letra21.setBorderPainted(false);
        letra21.setContentAreaFilled(false);
        letra21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra21MouseReleased(evt);
            }
        });

        letra22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_u.png"))); // NOI18N
        letra22.setBorder(null);
        letra22.setBorderPainted(false);
        letra22.setContentAreaFilled(false);
        letra22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                letra22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra22MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra22MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra22MouseReleased(evt);
            }
        });

        letra23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_v.png"))); // NOI18N
        letra23.setBorder(null);
        letra23.setBorderPainted(false);
        letra23.setContentAreaFilled(false);
        letra23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra23MouseReleased(evt);
            }
        });

        letra24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_w.png"))); // NOI18N
        letra24.setBorder(null);
        letra24.setBorderPainted(false);
        letra24.setContentAreaFilled(false);
        letra24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra24MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra24MouseReleased(evt);
            }
        });

        letra25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_x.png"))); // NOI18N
        letra25.setBorder(null);
        letra25.setBorderPainted(false);
        letra25.setContentAreaFilled(false);
        letra25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra25MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra25MouseReleased(evt);
            }
        });

        letra26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_y.png"))); // NOI18N
        letra26.setBorder(null);
        letra26.setBorderPainted(false);
        letra26.setContentAreaFilled(false);
        letra26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra26MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra26MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra26MouseReleased(evt);
            }
        });

        letra27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_z.png"))); // NOI18N
        letra27.setBorder(null);
        letra27.setBorderPainted(false);
        letra27.setContentAreaFilled(false);
        letra27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                letra27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                letra27MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                letra27MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                letra27MouseReleased(evt);
            }
        });

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/juan.jpg"))); // NOI18N
        foto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        letraJprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/J.png"))); // NOI18N

        letraUprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/U.png"))); // NOI18N

        letraAprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/A.png"))); // NOI18N

        letraNprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/N.png"))); // NOI18N

        back_login_primaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        back_login_primaria.setBorderPainted(false);
        back_login_primaria.setContentAreaFilled(false);
        back_login_primaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_login_primariaActionPerformed(evt);
            }
        });

        home_login_primaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        home_login_primaria.setBorderPainted(false);
        home_login_primaria.setContentAreaFilled(false);
        home_login_primaria.setEnabled(false);

        sonido_LoginPrimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido.png"))); // NOI18N
        sonido_LoginPrimaria.setBorderPainted(false);
        sonido_LoginPrimaria.setContentAreaFilled(false);
        sonido_LoginPrimaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sonido_LoginPrimariaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sonido_LoginPrimariaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_pass_primariaLayout = new javax.swing.GroupLayout(panel_pass_primaria);
        panel_pass_primaria.setLayout(panel_pass_primariaLayout);
        panel_pass_primariaLayout.setHorizontalGroup(
            panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                .addComponent(letra19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letra26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(letra27))
                            .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                        .addComponent(letra1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra2))
                                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                        .addComponent(letra10)
                                        .addGap(10, 10, 10)
                                        .addComponent(letra11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(letra12)
                                    .addComponent(letra3))
                                .addGap(10, 10, 10)
                                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                        .addComponent(letra13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(letra17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra18))
                                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                        .addComponent(letra4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(letra8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(letra9))))))
                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(letraJprimaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letraUprimaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letraAprimaria)
                                .addGap(18, 18, 18)
                                .addComponent(letraNprimaria))
                            .addComponent(foto)))
                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(sonido_LoginPrimaria, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(back_login_primaria, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_login_primaria, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panel_pass_primariaLayout.setVerticalGroup(
            panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pass_primariaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(sonido_LoginPrimaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pass_primariaLayout.createSequentialGroup()
                        .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(letraAprimaria)
                            .addComponent(letraUprimaria)
                            .addComponent(letraNprimaria)
                            .addComponent(letraJprimaria))
                        .addGap(15, 15, 15)))
                .addGap(45, 45, 45)
                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letra9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letra18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letra10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letra19)
                    .addComponent(letra20)
                    .addComponent(letra21)
                    .addComponent(letra22)
                    .addComponent(letra23)
                    .addComponent(letra24)
                    .addComponent(letra25)
                    .addComponent(letra26)
                    .addComponent(letra27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(panel_pass_primariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back_login_primaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home_login_primaria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(47, 47, 47))
        );

        panel_nivel1fase2.setBackground(new java.awt.Color(204, 255, 204));
        panel_nivel1fase2.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_nivel1fase2.setMinimumSize(new java.awt.Dimension(800, 600));

        TituloSilabas1.setForeground(new java.awt.Color(0, 51, 255));
        TituloSilabas1.setText("Selecciona la sílaba correcta");
        TituloSilabas1.setFont(font_titulo_niveles);

        backSilabas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backSilabas1.setBorderPainted(false);
        backSilabas1.setContentAreaFilled(false);
        backSilabas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSilabas1MouseClicked(evt);
            }
        });

        homeSilabas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeSilabas1.setBorderPainted(false);
        homeSilabas1.setContentAreaFilled(false);
        homeSilabas1.setEnabled(false);

        silabasImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soccer_ball.png"))); // NOI18N
        silabasImg1.setBorderPainted(false);
        silabasImg1.setContentAreaFilled(false);

        soluciónsilabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        soluciónsilabas1.setText("Pe-lota");
        soluciónsilabas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soluciónsilabas1ActionPerformed(evt);
            }
        });

        boton1silabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton1silabas1.setText("Ca-mión");

        boton2silabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton2silabas1.setText("To-bogán");
        boton2silabas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2silabas1ActionPerformed(evt);
            }
        });

        boton3silabas1.setFont(new java.awt.Font("PalMeMim", 0, 36)); // NOI18N
        boton3silabas1.setText("Me-lón");
        boton3silabas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3silabas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_nivel1fase2Layout = new javax.swing.GroupLayout(panel_nivel1fase2);
        panel_nivel1fase2.setLayout(panel_nivel1fase2Layout);
        panel_nivel1fase2Layout.setHorizontalGroup(
            panel_nivel1fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nivel1fase2Layout.createSequentialGroup()
                .addGroup(panel_nivel1fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_nivel1fase2Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(TituloSilabas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_nivel1fase2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backSilabas1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeSilabas1))
                    .addGroup(panel_nivel1fase2Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(silabasImg1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel1fase2Layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(soluciónsilabas1)
                .addGap(41, 41, 41)
                .addComponent(boton1silabas1)
                .addGap(44, 44, 44)
                .addComponent(boton2silabas1)
                .addGap(44, 44, 44)
                .addComponent(boton3silabas1)
                .addGap(72, 72, 72))
        );
        panel_nivel1fase2Layout.setVerticalGroup(
            panel_nivel1fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel1fase2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(TituloSilabas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(silabasImg1)
                .addGap(104, 104, 104)
                .addGroup(panel_nivel1fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soluciónsilabas1)
                    .addComponent(boton1silabas1)
                    .addComponent(boton2silabas1)
                    .addComponent(boton3silabas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(panel_nivel1fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeSilabas1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backSilabas1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
        );

        panel_nivel2fase2.setBackground(new java.awt.Color(204, 255, 204));
        panel_nivel2fase2.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_nivel2fase2.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_nivel2fase2.setPreferredSize(new java.awt.Dimension(800, 600));

        TituloSilabas2.setForeground(new java.awt.Color(0, 51, 255));
        TituloSilabas2.setText("Selecciona la sílaba correcta");
        TituloSilabas2.setFont(font_titulo_niveles);

        backSilabas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backSilabas2.setBorderPainted(false);
        backSilabas2.setContentAreaFilled(false);
        backSilabas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSilabas2MouseClicked(evt);
            }
        });

        homeSilabas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeSilabas2.setBorderPainted(false);
        homeSilabas2.setContentAreaFilled(false);
        homeSilabas2.setEnabled(false);

        silabasImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/candy.png"))); // NOI18N
        silabasImg2.setBorderPainted(false);
        silabasImg2.setContentAreaFilled(false);

        soluciónsilabas2.setFont(font_boton_niveles);
        soluciónsilabas2.setText("Ca-ramelo");
        soluciónsilabas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soluciónsilabas2ActionPerformed(evt);
            }
        });

        boton1silabas2.setFont(font_boton_niveles);
        boton1silabas2.setText("Pe-lota");
        boton1silabas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1silabas2ActionPerformed(evt);
            }
        });

        boton2silabas2.setFont(font_boton_niveles);
        boton2silabas2.setText("Es-cuela");
        boton2silabas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2silabas2ActionPerformed(evt);
            }
        });

        boton3silabas2.setFont(font_boton_niveles);
        boton3silabas2.setText("San-dia");

        javax.swing.GroupLayout panel_nivel2fase2Layout = new javax.swing.GroupLayout(panel_nivel2fase2);
        panel_nivel2fase2.setLayout(panel_nivel2fase2Layout);
        panel_nivel2fase2Layout.setHorizontalGroup(
            panel_nivel2fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nivel2fase2Layout.createSequentialGroup()
                .addGroup(panel_nivel2fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_nivel2fase2Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(TituloSilabas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_nivel2fase2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backSilabas2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeSilabas2))
                    .addGroup(panel_nivel2fase2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(boton1silabas2)
                        .addGap(79, 79, 79)
                        .addComponent(boton2silabas2)
                        .addGap(79, 79, 79)
                        .addComponent(soluciónsilabas2)
                        .addGap(79, 79, 79)
                        .addComponent(boton3silabas2))
                    .addGroup(panel_nivel2fase2Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(silabasImg2)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        panel_nivel2fase2Layout.setVerticalGroup(
            panel_nivel2fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel2fase2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(TituloSilabas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(silabasImg2)
                .addGap(76, 76, 76)
                .addGroup(panel_nivel2fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton2silabas2)
                    .addComponent(boton3silabas2)
                    .addComponent(soluciónsilabas2)
                    .addComponent(boton1silabas2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(panel_nivel2fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeSilabas2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backSilabas2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
        );

        panel_nivel3fase2.setBackground(new java.awt.Color(204, 255, 204));
        panel_nivel3fase2.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_nivel3fase2.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_nivel3fase2.setPreferredSize(new java.awt.Dimension(800, 600));

        TituloSilabas3.setForeground(new java.awt.Color(0, 51, 255));
        TituloSilabas3.setText("Selecciona la sílaba correcta");
        TituloSilabas3.setFont(font_titulo_niveles);

        backSilabas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backSilabas3.setBorderPainted(false);
        backSilabas3.setContentAreaFilled(false);
        backSilabas3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backSilabas3MouseClicked(evt);
            }
        });

        homeSilabas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeSilabas3.setBorderPainted(false);
        homeSilabas3.setContentAreaFilled(false);
        homeSilabas3.setEnabled(false);

        silabasImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clover.png"))); // NOI18N
        silabasImg3.setBorderPainted(false);
        silabasImg3.setContentAreaFilled(false);

        boton1silabas3.setFont(font_boton_niveles);
        boton1silabas3.setText("Tri-ciclo");

        boton2silabas3.setFont(font_boton_niveles);
        boton2silabas3.setText("Tren");

        solucionsilabas3.setFont(font_boton_niveles);
        solucionsilabas3.setText("Tre-bol");
        solucionsilabas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solucionsilabas3ActionPerformed(evt);
            }
        });

        boton3silabas3.setFont(font_boton_niveles);
        boton3silabas3.setText("Bra-zo");

        javax.swing.GroupLayout panel_nivel3fase2Layout = new javax.swing.GroupLayout(panel_nivel3fase2);
        panel_nivel3fase2.setLayout(panel_nivel3fase2Layout);
        panel_nivel3fase2Layout.setHorizontalGroup(
            panel_nivel3fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nivel3fase2Layout.createSequentialGroup()
                .addGroup(panel_nivel3fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_nivel3fase2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backSilabas3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeSilabas3))
                    .addGroup(panel_nivel3fase2Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(TituloSilabas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel3fase2Layout.createSequentialGroup()
                .addGap(0, 162, Short.MAX_VALUE)
                .addGroup(panel_nivel3fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel3fase2Layout.createSequentialGroup()
                        .addComponent(boton1silabas3)
                        .addGap(79, 79, 79)
                        .addComponent(boton2silabas3)
                        .addGap(78, 78, 78)
                        .addComponent(solucionsilabas3)
                        .addGap(78, 78, 78)
                        .addComponent(boton3silabas3)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel3fase2Layout.createSequentialGroup()
                        .addComponent(silabasImg3)
                        .addGap(316, 316, 316))))
        );
        panel_nivel3fase2Layout.setVerticalGroup(
            panel_nivel3fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_nivel3fase2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(TituloSilabas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(silabasImg3)
                .addGap(85, 85, 85)
                .addGroup(panel_nivel3fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1silabas3)
                    .addComponent(boton2silabas3)
                    .addComponent(solucionsilabas3)
                    .addComponent(boton3silabas3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(panel_nivel3fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeSilabas3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backSilabas3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
        );

        panel_acertado.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_acertado.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_acertado.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout panel_acertadoLayout = new javax.swing.GroupLayout(panel_acertado);
        panel_acertado.setLayout(panel_acertadoLayout);
        panel_acertadoLayout.setHorizontalGroup(
            panel_acertadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panel_acertadoLayout.setVerticalGroup(
            panel_acertadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        panel_fase2.setBackground(new java.awt.Color(204, 255, 204));
        panel_fase2.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_fase2.setMinimumSize(new java.awt.Dimension(800, 600));
        panel_fase2.setPreferredSize(new java.awt.Dimension(800, 600));

        nivel1fase2.setFont(font_boton_niveles);
        nivel1fase2.setForeground(new java.awt.Color(255, 255, 255));
        nivel1fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red.png"))); // NOI18N
        nivel1fase2.setText("Nivel 1");
        nivel1fase2.setBorderPainted(false);
        nivel1fase2.setContentAreaFilled(false);
        nivel1fase2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel1fase2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel1fase2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel1fase2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel1fase2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel1fase2MouseReleased(evt);
            }
        });
        nivel1fase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel1fase2ActionPerformed(evt);
            }
        });

        nivel2fase2.setFont(font_boton_niveles);
        nivel2fase2.setForeground(new java.awt.Color(255, 255, 255));
        nivel2fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_grey.png"))); // NOI18N
        nivel2fase2.setText("Nivel 2");
        nivel2fase2.setBorderPainted(false);
        nivel2fase2.setContentAreaFilled(false);
        nivel2fase2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel2fase2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel2fase2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel2fase2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel2fase2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel2fase2MouseReleased(evt);
            }
        });
        nivel2fase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel2fase2ActionPerformed(evt);
            }
        });

        nivel3fase2.setFont(font_boton_niveles);
        nivel3fase2.setForeground(new java.awt.Color(255, 255, 255));
        nivel3fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange.png"))); // NOI18N
        nivel3fase2.setText("Nivel 3");
        nivel3fase2.setBorderPainted(false);
        nivel3fase2.setContentAreaFilled(false);
        nivel3fase2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel3fase2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel3fase2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel3fase2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel3fase2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel3fase2MouseReleased(evt);
            }
        });
        nivel3fase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel3fase2ActionPerformed(evt);
            }
        });

        TituloFase2.setForeground(new java.awt.Color(0, 51, 255));
        TituloFase2.setText("Escoge un nivel");
        TituloFase2.setFont(font_titulo_niveles);

        backFase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backFase2.setBorderPainted(false);
        backFase2.setContentAreaFilled(false);
        backFase2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backFase2MouseClicked(evt);
            }
        });

        homeFase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeFase2.setBorderPainted(false);
        homeFase2.setContentAreaFilled(false);
        homeFase2.setEnabled(false);
        homeFase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFase2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_fase2Layout = new javax.swing.GroupLayout(panel_fase2);
        panel_fase2.setLayout(panel_fase2Layout);
        panel_fase2Layout.setHorizontalGroup(
            panel_fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fase2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(nivel1fase2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(nivel2fase2)
                .addGap(148, 148, 148))
            .addGroup(panel_fase2Layout.createSequentialGroup()
                .addGroup(panel_fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fase2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backFase2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeFase2)
                        .addGap(140, 140, 140)
                        .addComponent(nivel3fase2))
                    .addGroup(panel_fase2Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(TituloFase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_fase2Layout.setVerticalGroup(
            panel_fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fase2Layout.createSequentialGroup()
                .addGroup(panel_fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fase2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(TituloFase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(nivel1fase2))
                    .addGroup(panel_fase2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(nivel2fase2)))
                .addGroup(panel_fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fase2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(nivel3fase2)
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fase2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backFase2)
                            .addComponent(homeFase2))
                        .addGap(40, 40, 40))))
        );

        panelPalabrasNivel1.setMaximumSize(new java.awt.Dimension(800, 600));
        panelPalabrasNivel1.setMinimumSize(new java.awt.Dimension(800, 600));

        sopaLetras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sopaLetras.setLayout(new java.awt.GridLayout(6, 6, 10, 10));

        letraG_gato.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraG_gato.setText("G");
        letraG_gato.setName("G_GATO"); // NOI18N
        letraG_gato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraG_gato);

        letraA_gato.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraA_gato.setText("A");
        letraA_gato.setName("A_GATO"); // NOI18N
        letraA_gato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraA_gato);

        letraT_gato.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraT_gato.setText("T");
        letraT_gato.setName("T_GATO"); // NOI18N
        letraT_gato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraT_gato);

        letraO_gato.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraO_gato.setText("O");
        letraO_gato.setName("O_GATO"); // NOI18N
        letraO_gato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraO_gato);

        jButton31.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton31.setText("R");
        jButton31.setName("name"); // NOI18N
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton31);

        jButton36.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton36.setText("P");
        jButton36.setName("name"); // NOI18N
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton36);

        jButton35.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton35.setText("I");
        jButton35.setName("name"); // NOI18N
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton35);

        jButton34.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton34.setText("L");
        jButton34.setName("name"); // NOI18N
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton34);

        jButton33.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton33.setText("N");
        jButton33.setName("name"); // NOI18N
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton33);

        jButton32.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton32.setText("J");
        jButton32.setName("name"); // NOI18N
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton32);

        jButton30.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton30.setText("O");
        jButton30.setName("name"); // NOI18N
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton30);

        jButton29.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton29.setText("Z");
        jButton29.setName("name"); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton29);

        letraG_goma.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraG_goma.setText("G");
        letraG_goma.setName("G_GOMA"); // NOI18N
        letraG_goma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraG_goma);

        jButton27.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton27.setText("U");
        jButton27.setName("name"); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton27);

        jButton28.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton28.setText("V");
        jButton28.setName("name"); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton28);

        jButton24.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton24.setText("S");
        jButton24.setName("name"); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton24);

        jButton23.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton23.setText("Q");
        jButton23.setName("name"); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton23);

        jButton22.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton22.setText("T");
        jButton22.setName("name"); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton22);

        letraO_goma.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraO_goma.setText("O");
        letraO_goma.setName("O_GOMA"); // NOI18N
        letraO_goma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraO_goma);

        letraS_sol.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraS_sol.setText("S");
        letraS_sol.setName("S_SOL"); // NOI18N
        letraS_sol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraS_sol);

        letraO_sol.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraO_sol.setText("O");
        letraO_sol.setName("O_SOL"); // NOI18N
        letraO_sol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraO_sol);

        letraL_sol.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraL_sol.setText("L");
        letraL_sol.setName("L_SOL"); // NOI18N
        letraL_sol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraL_sol);

        jButton16.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton16.setText("X");
        jButton16.setName("name"); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton16);

        jButton15.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton15.setText("M");
        jButton15.setName("name"); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton15);

        letraM_goma.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraM_goma.setText("M");
        letraM_goma.setName("M_GOMA"); // NOI18N
        letraM_goma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraM_goma);

        jButton14.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton14.setText("B");
        jButton14.setName("name"); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton14);

        jButton7.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton7.setText("W");
        jButton7.setName("name"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton7);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton2.setText("R");
        jButton2.setName("name"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton2);

        jButton6.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton6.setText("A");
        jButton6.setName("name"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton6);

        jButton8.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jButton8.setText("F");
        jButton8.setName("name"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(jButton8);

        letraA_goma.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraA_goma.setText("A");
        letraA_goma.setName("A_GOMA"); // NOI18N
        letraA_goma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraA_goma);

        letraL_lapiz.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraL_lapiz.setText("L");
        letraL_lapiz.setName("L_LAPIZ"); // NOI18N
        letraL_lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraL_lapiz);

        letraA_lapiz.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraA_lapiz.setText("A");
        letraA_lapiz.setName("A_LAPIZ"); // NOI18N
        letraA_lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraA_lapiz);

        letraP_lapiz.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraP_lapiz.setText("P");
        letraP_lapiz.setName("P_LAPIZ"); // NOI18N
        letraP_lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraP_lapiz);

        letraI_lapiz.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraI_lapiz.setText("I");
        letraI_lapiz.setName("I_LAPIZ"); // NOI18N
        letraI_lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraI_lapiz);

        letraZ_lapiz.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        letraZ_lapiz.setText("Z");
        letraZ_lapiz.setName("Z_LAPIZ"); // NOI18N
        letraZ_lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letraPulsadaEvent(evt);
            }
        });
        sopaLetras.add(letraZ_lapiz);

        imagenGato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gato_con_botas.png"))); // NOI18N

        imagenGoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/goma_milan.png"))); // NOI18N

        imagenLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lapiz.png"))); // NOI18N

        imagenSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sol.gif"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 68)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("NIVEL 1");

        jLabel8.setFont(new java.awt.Font("GinoSchoolScript", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("Busca las palabras de los dibujos");

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        jButton37.setBorderPainted(false);
        jButton37.setContentAreaFilled(false);

        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jButton38.setBorderPainted(false);
        jButton38.setContentAreaFilled(false);

        javax.swing.GroupLayout panelPalabrasNivel1Layout = new javax.swing.GroupLayout(panelPalabrasNivel1);
        panelPalabrasNivel1.setLayout(panelPalabrasNivel1Layout);
        panelPalabrasNivel1Layout.setHorizontalGroup(
            panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(imagenGato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPalabrasNivel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagenGoma)
                        .addGap(37, 37, 37)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addComponent(sopaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPalabrasNivel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(imagenLapiz)
                        .addGap(58, 58, 58))
                    .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(imagenSol)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPalabrasNivel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPalabrasNivel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(251, 251, 251))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPalabrasNivel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(145, 145, 145))))
                    .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelPalabrasNivel1Layout.setVerticalGroup(
            panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton38)
                    .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                        .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(panelPalabrasNivel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                                        .addComponent(imagenLapiz)
                                        .addGap(55, 55, 55)
                                        .addComponent(imagenSol))
                                    .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                                        .addComponent(imagenGato)
                                        .addGap(58, 58, 58)
                                        .addComponent(imagenGoma)))
                                .addGap(74, 74, 74))
                            .addGroup(panelPalabrasNivel1Layout.createSequentialGroup()
                                .addComponent(sopaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))
                        .addComponent(jButton37)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        panel_fase3.setBackground(new java.awt.Color(204, 255, 204));
        panel_fase3.setFont(font_titulo_niveles);
        panel_fase3.setMaximumSize(new java.awt.Dimension(800, 600));
        panel_fase3.setMinimumSize(new java.awt.Dimension(800, 600));

        nivel1fase3.setFont(font_boton_niveles);
        nivel1fase3.setForeground(new java.awt.Color(255, 255, 255));
        nivel1fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green.png"))); // NOI18N
        nivel1fase3.setText("Nivel 1");
        nivel1fase3.setBorderPainted(false);
        nivel1fase3.setContentAreaFilled(false);
        nivel1fase3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel1fase3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel1fase3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel1fase3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel1fase3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel1fase3MouseReleased(evt);
            }
        });
        nivel1fase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel1fase3ActionPerformed(evt);
            }
        });

        nivel2fase3.setFont(font_boton_niveles);
        nivel2fase3.setForeground(new java.awt.Color(255, 255, 255));
        nivel2fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange.png"))); // NOI18N
        nivel2fase3.setText("Nivel 2");
        nivel2fase3.setBorderPainted(false);
        nivel2fase3.setContentAreaFilled(false);
        nivel2fase3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel2fase3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel2fase3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel2fase3MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel2fase3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel2fase3MouseEntered(evt);
            }
        });
        nivel2fase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel2fase3ActionPerformed(evt);
            }
        });

        nivel3fase3.setFont(font_boton_niveles);
        nivel3fase3.setForeground(new java.awt.Color(255, 255, 255));
        nivel3fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow.png"))); // NOI18N
        nivel3fase3.setText("Nivel 3");
        nivel3fase3.setBorderPainted(false);
        nivel3fase3.setContentAreaFilled(false);
        nivel3fase3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel3fase3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel3fase3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel3fase3MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel3fase3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel3fase3MouseEntered(evt);
            }
        });
        nivel3fase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel3fase3ActionPerformed(evt);
            }
        });

        nivel4fase3.setFont(font_boton_niveles);
        nivel4fase3.setForeground(new java.awt.Color(255, 255, 255));
        nivel4fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue.png"))); // NOI18N
        nivel4fase3.setText("Nivel 4");
        nivel4fase3.setBorderPainted(false);
        nivel4fase3.setContentAreaFilled(false);
        nivel4fase3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nivel4fase3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nivel4fase3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nivel4fase3MouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nivel4fase3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nivel4fase3MouseEntered(evt);
            }
        });
        nivel4fase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel4fase3ActionPerformed(evt);
            }
        });

        TituloFase3.setForeground(new java.awt.Color(0, 51, 255));
        TituloFase3.setText("Escoge un nivel");
        TituloFase3.setFont(font_titulo_niveles);

        backFase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backFase3.setBorderPainted(false);
        backFase3.setContentAreaFilled(false);

        homeFase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        homeFase3.setBorderPainted(false);
        homeFase3.setContentAreaFilled(false);
        homeFase3.setEnabled(false);
        homeFase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFase3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_fase3Layout = new javax.swing.GroupLayout(panel_fase3);
        panel_fase3.setLayout(panel_fase3Layout);
        panel_fase3Layout.setHorizontalGroup(
            panel_fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fase3Layout.createSequentialGroup()
                .addGroup(panel_fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_fase3Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(panel_fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nivel1fase3)
                            .addComponent(nivel3fase3))
                        .addGap(109, 109, 109)
                        .addComponent(nivel2fase3))
                    .addGroup(panel_fase3Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(TituloFase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fase3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backFase3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeFase3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nivel4fase3)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        panel_fase3Layout.setVerticalGroup(
            panel_fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fase3Layout.createSequentialGroup()
                .addGroup(panel_fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fase3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(TituloFase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(nivel1fase3)
                        .addGap(48, 48, 48)
                        .addComponent(nivel3fase3)
                        .addGap(31, 31, 31)
                        .addGroup(panel_fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backFase3)
                            .addComponent(homeFase3)))
                    .addGroup(panel_fase3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(nivel2fase3)
                        .addGap(70, 70, 70)
                        .addComponent(nivel4fase3)))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_profesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_fase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_pass_infantil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_fases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_pass_primaria, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_nivel1fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(panel_nivel2fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_nivel3fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_acertado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(panelPalabrasNivel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(panel_fase3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_fase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_pass_infantil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_fases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_pass_primaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_nivel1fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_nivel2fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_nivel3fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_acertado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel_fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(panelPalabrasNivel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(panel_fase3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boton_sonidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonidoMouseReleased
        if (musica_isActive) { //Si está activa -> la desactivamos.
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
            musica_isActive = false;
            /*PAUSE DE LA MUSICA*/
            pausarMusica();
        } else {
            boton_sonido.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
            musica_isActive = true;
            /* CONTINUAR MUSICA */
            activarMusica();
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
            stopMusica();
        }
    }//GEN-LAST:event_boton_entrarActionPerformed

    private void password_profeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_profeKeyPressed
        //Cuando presionamos ENTER en el Password
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
                stopMusica();
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

    private void boton_profe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_profe1ActionPerformed
        panel_login.setVisible(true);
        panel_inicio.setVisible(false);
    }//GEN-LAST:event_boton_profe1ActionPerformed

    private void boton_sonido1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonido1MousePressed
        if (musica_isActive) {
            boton_sonido1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido_pulsado.png")));
        } else {
            boton_sonido1.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado_pulsado.png")));
        }
    }//GEN-LAST:event_boton_sonido1MousePressed

    private void boton_sonido1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonido1MouseReleased
        if (musica_isActive) { //Si está activa -> la desactivamos.
            boton_sonido1.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
            musica_isActive = false;
            /*PAUSE DE LA MUSICA*/
            pausarMusica();
        } else {
            boton_sonido1.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
            musica_isActive = true;
            /* CONTINUAR MUSICA */
            activarMusica();
        }
    }//GEN-LAST:event_boton_sonido1MouseReleased

    private void atras_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras_loginActionPerformed
        panel_inicio.setVisible(true);
        panel_login.setVisible(false);
    }//GEN-LAST:event_atras_loginActionPerformed

    private void atras_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atras_loginMouseEntered
        atras_login.setIcon(new ImageIcon(getClass().getResource("/img/back_hover.png")));
    }//GEN-LAST:event_atras_loginMouseEntered

    private void atras_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atras_loginMouseExited
        atras_login.setIcon(new ImageIcon(getClass().getResource("/img/back.png")));
    }//GEN-LAST:event_atras_loginMouseExited

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

    private void nivel3fase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3fase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel3fase1ActionPerformed

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

    private void nivel4fase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel4fase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel4fase1ActionPerformed

    private void backFase1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFase1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backFase1MouseClicked

    private void escuelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escuelaMouseEntered
        escuela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/school_hover.png")));
    }//GEN-LAST:event_escuelaMouseEntered

    private void escuelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escuelaMouseExited
        escuela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/school.png")));
    }//GEN-LAST:event_escuelaMouseExited

    private void escuelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escuelaMousePressed
        escuela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/school_press.png")));
    }//GEN-LAST:event_escuelaMousePressed

    private void escuelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escuelaMouseReleased
        escuela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/school.png")));
    }//GEN-LAST:event_escuelaMouseReleased

    private void escuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuelaActionPerformed
        panel_fases.setVisible(false);
        panel_fase1.setVisible(true);
    }//GEN-LAST:event_escuelaActionPerformed

    private void barcoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcoMouseEntered
        barco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barco_hover.png")));
    }//GEN-LAST:event_barcoMouseEntered

    private void barcoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcoMouseExited
        barco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barco.png")));
    }//GEN-LAST:event_barcoMouseExited

    private void barcoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcoMousePressed
        barco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barco_press.png")));
    }//GEN-LAST:event_barcoMousePressed

    private void barcoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcoMouseReleased
        barco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barco.png")));
    }//GEN-LAST:event_barcoMouseReleased

    private void barcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcoActionPerformed
        panel_fase2.setVisible(true);
        panel_fases.setVisible(false);
    }//GEN-LAST:event_barcoActionPerformed

    private void piramideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piramideMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_piramideMouseClicked

    private void piramideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piramideMouseEntered
        piramide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piramide_hover.png")));
    }//GEN-LAST:event_piramideMouseEntered

    private void piramideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piramideMouseExited
        piramide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piramide.png")));
    }//GEN-LAST:event_piramideMouseExited

    private void piramideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piramideMousePressed
        piramide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piramide_press.png")));
    }//GEN-LAST:event_piramideMousePressed

    private void piramideMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piramideMouseReleased
        piramide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piramide.png")));
    }//GEN-LAST:event_piramideMouseReleased

    private void piramideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piramideActionPerformed
        panel_fase3.setVisible(true);
        panel_fases.setVisible(false);
    }//GEN-LAST:event_piramideActionPerformed

    private void selvaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selvaMouseEntered
        selva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selva_hover.png")));
    }//GEN-LAST:event_selvaMouseEntered

    private void selvaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selvaMouseExited
        selva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selva.png")));
    }//GEN-LAST:event_selvaMouseExited

    private void selvaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selvaMousePressed
        selva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selva_press.png")));
    }//GEN-LAST:event_selvaMousePressed

    private void selvaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selvaMouseReleased
        selva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selva.png")));
    }//GEN-LAST:event_selvaMouseReleased

    private void bibliotecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bibliotecaMouseEntered
        biblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/biblioteca_hover.png")));
    }//GEN-LAST:event_bibliotecaMouseEntered

    private void bibliotecaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bibliotecaMouseExited
        biblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/biblioteca.png")));
    }//GEN-LAST:event_bibliotecaMouseExited

    private void bibliotecaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bibliotecaMousePressed
        biblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/biblioteca_press.png")));
    }//GEN-LAST:event_bibliotecaMousePressed

    private void bibliotecaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bibliotecaMouseReleased
        biblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/biblioteca.png")));
    }//GEN-LAST:event_bibliotecaMouseReleased

    private void boton_sonido2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonido2MousePressed
        if (musica_isActive) {
            boton_sonido2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido_pulsado.png")));
        } else {
            boton_sonido2.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado_pulsado.png")));
        }
    }//GEN-LAST:event_boton_sonido2MousePressed

    private void boton_sonido2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonido2MouseReleased
        if (musica_isActive) { //Si está activa -> la desactivamos.
            boton_sonido2.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
            musica_isActive = false;
            pausarMusica();
        } else {
            boton_sonido2.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
            musica_isActive = true;
            activarMusica();
        }
    }//GEN-LAST:event_boton_sonido2MouseReleased

    private void globo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo1MouseEntered
        globo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo1_hover.png")));
    }//GEN-LAST:event_globo1MouseEntered

    private void globo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo1MouseExited
        globo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo1.png")));
    }//GEN-LAST:event_globo1MouseExited

    private void globo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo1MousePressed
        globo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo1_press.png")));
    }//GEN-LAST:event_globo1MousePressed

    private void globo1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo1MouseReleased
        globo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo1.png")));
    }//GEN-LAST:event_globo1MouseReleased

    private void globo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo2MouseEntered
        globo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo2_hover.png")));
    }//GEN-LAST:event_globo2MouseEntered

    private void globo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo2MouseExited
        globo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo2.png")));
    }//GEN-LAST:event_globo2MouseExited

    private void globo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo2MousePressed
        globo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo2_press.png")));
    }//GEN-LAST:event_globo2MousePressed

    private void globo2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo2MouseReleased
        globo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo2.png")));
    }//GEN-LAST:event_globo2MouseReleased

    private void globo3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo3MouseEntered
        globo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo3_hover.png")));
    }//GEN-LAST:event_globo3MouseEntered

    private void globo3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo3MouseExited
        globo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo3.png")));
    }//GEN-LAST:event_globo3MouseExited

    private void globo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo3MousePressed
        globo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo3_press.png")));
    }//GEN-LAST:event_globo3MousePressed

    private void globo3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo3MouseReleased
        globo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo3.png")));
    }//GEN-LAST:event_globo3MouseReleased

    private void globo4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo4MouseEntered
        globo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo4_hover.png")));
    }//GEN-LAST:event_globo4MouseEntered

    private void globo4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo4MouseExited
        globo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo4.png")));
    }//GEN-LAST:event_globo4MouseExited

    private void globo4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo4MousePressed
        globo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo4_press.png")));
    }//GEN-LAST:event_globo4MousePressed

    private void globo4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo4MouseReleased
        globo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo4.png")));
    }//GEN-LAST:event_globo4MouseReleased

    private void globo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo5MouseEntered
        globo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo5_hover.png")));
    }//GEN-LAST:event_globo5MouseEntered

    private void globo5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo5MouseExited
        globo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo5.png")));
    }//GEN-LAST:event_globo5MouseExited

    private void globo5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo5MousePressed
        globo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo5_press.png")));
    }//GEN-LAST:event_globo5MousePressed

    private void globo5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo5MouseReleased
        globo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo5.png")));
    }//GEN-LAST:event_globo5MouseReleased

    private void globo6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo6MouseEntered
        globo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo6_hover.png")));
    }//GEN-LAST:event_globo6MouseEntered

    private void globo6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo6MouseExited
        globo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo6.png")));
    }//GEN-LAST:event_globo6MouseExited

    private void globo6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo6MousePressed
        globo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo6_press.png")));
    }//GEN-LAST:event_globo6MousePressed

    private void globo6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo6MouseReleased
        globo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo6.png")));
    }//GEN-LAST:event_globo6MouseReleased

    private void globo7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo7MouseEntered
        globo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo7_hover.png")));
    }//GEN-LAST:event_globo7MouseEntered

    private void globo7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo7MouseExited
        globo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo7.png")));
    }//GEN-LAST:event_globo7MouseExited

    private void globo7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo7MousePressed
        globo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo7_press.png")));
    }//GEN-LAST:event_globo7MousePressed

    private void globo7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo7MouseReleased
        globo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo7.png")));
    }//GEN-LAST:event_globo7MouseReleased

    private void globo8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo8MouseEntered
        globo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo8_hover.png")));
    }//GEN-LAST:event_globo8MouseEntered

    private void globo8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo8MouseExited
        globo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo8.png")));
    }//GEN-LAST:event_globo8MouseExited

    private void globo8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo8MousePressed
        globo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo8_press.png")));
    }//GEN-LAST:event_globo8MousePressed

    private void globo8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo8MouseReleased
        globo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo8.png")));
    }//GEN-LAST:event_globo8MouseReleased

    private void globo9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo9MouseEntered
        globo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo9_hover.png")));
    }//GEN-LAST:event_globo9MouseEntered

    private void globo9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo9MouseExited
        globo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo9.png")));// TODO add your handling code here:
    }//GEN-LAST:event_globo9MouseExited

    private void globo9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo9MousePressed
        globo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo9_press.png")));
    }//GEN-LAST:event_globo9MousePressed

    private void globo9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo9MouseReleased
        globo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo9.png")));
    }//GEN-LAST:event_globo9MouseReleased

    private void globo10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo10MouseEntered
        globo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo10_hover.png")));
    }//GEN-LAST:event_globo10MouseEntered

    private void globo10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo10MouseExited
        globo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo10.png")));
    }//GEN-LAST:event_globo10MouseExited

    private void globo10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo10MousePressed
        globo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo10_press.png")));
    }//GEN-LAST:event_globo10MousePressed

    private void globo10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo10MouseReleased
        globo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo10.png")));
    }//GEN-LAST:event_globo10MouseReleased

    private void globo11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo11MouseEntered
        globo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo11_hover.png")));
    }//GEN-LAST:event_globo11MouseEntered

    private void globo11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo11MouseExited
        globo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo11.png")));
    }//GEN-LAST:event_globo11MouseExited

    private void globo11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo11MousePressed
        globo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo11_press.png")));
    }//GEN-LAST:event_globo11MousePressed

    private void globo11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo11MouseReleased
        globo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo11.png")));
    }//GEN-LAST:event_globo11MouseReleased

    private void globo12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo12MouseEntered
        globo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo12_hover.png")));
    }//GEN-LAST:event_globo12MouseEntered

    private void globo12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo12MouseExited
        globo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo12.png")));
    }//GEN-LAST:event_globo12MouseExited

    private void globo12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo12MousePressed
        globo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo12_press.png")));
    }//GEN-LAST:event_globo12MousePressed

    private void globo12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo12MouseReleased
        globo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo12.png")));
    }//GEN-LAST:event_globo12MouseReleased

    private void globo13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo13MouseEntered
        globo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo13_hover.png")));
    }//GEN-LAST:event_globo13MouseEntered

    private void globo13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo13MouseExited
        globo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo13.png")));
    }//GEN-LAST:event_globo13MouseExited

    private void globo13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo13MousePressed
        globo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo13_press.png")));
    }//GEN-LAST:event_globo13MousePressed

    private void globo13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo13MouseReleased
        globo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo13.png")));
    }//GEN-LAST:event_globo13MouseReleased

    private void globo14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo14MouseEntered
        globo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo14_hover.png")));
    }//GEN-LAST:event_globo14MouseEntered

    private void globo14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo14MouseExited
        globo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo14.png")));
    }//GEN-LAST:event_globo14MouseExited

    private void globo14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo14MousePressed
        globo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo14_press.png")));
    }//GEN-LAST:event_globo14MousePressed

    private void globo14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo14MouseReleased
        globo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo14.png")));
    }//GEN-LAST:event_globo14MouseReleased

    private void globo15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo15MouseEntered
        globo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo15_hover.png")));
    }//GEN-LAST:event_globo15MouseEntered

    private void globo15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo15MouseExited
        globo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo15.png")));
    }//GEN-LAST:event_globo15MouseExited

    private void globo15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo15MousePressed
        globo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo15_press.png")));
    }//GEN-LAST:event_globo15MousePressed

    private void globo15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo15MouseReleased
        globo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo15.png")));
    }//GEN-LAST:event_globo15MouseReleased

    private void globo16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo16MouseEntered
        globo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo16_hover.png")));
    }//GEN-LAST:event_globo16MouseEntered

    private void globo16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo16MouseExited
        globo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo16.png")));
    }//GEN-LAST:event_globo16MouseExited

    private void globo16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo16MousePressed
        globo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo16_press.png")));
    }//GEN-LAST:event_globo16MousePressed

    private void globo16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo16MouseReleased
        globo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo16.png")));
    }//GEN-LAST:event_globo16MouseReleased

    private void globo17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo17MouseEntered
        globo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo17_hover.png")));
    }//GEN-LAST:event_globo17MouseEntered

    private void globo17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo17MouseExited
        globo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo17.png")));
    }//GEN-LAST:event_globo17MouseExited

    private void globo17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo17MousePressed
        globo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo17_press.png")));
    }//GEN-LAST:event_globo17MousePressed

    private void globo17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo17MouseReleased
        globo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo17.png")));
    }//GEN-LAST:event_globo17MouseReleased

    private void globo18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo18MouseEntered
        globo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo18_hover.png")));
    }//GEN-LAST:event_globo18MouseEntered

    private void globo18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo18MouseExited
        globo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo18.png")));
    }//GEN-LAST:event_globo18MouseExited

    private void globo18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo18MousePressed
        globo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo18_press.png")));
    }//GEN-LAST:event_globo18MousePressed

    private void globo18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo18MouseReleased
        globo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo18.png")));
    }//GEN-LAST:event_globo18MouseReleased

    private void globo19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo19MouseEntered
        globo19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo19_hover.png")));
    }//GEN-LAST:event_globo19MouseEntered

    private void globo19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo19MouseExited
        globo19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo19.png")));
    }//GEN-LAST:event_globo19MouseExited

    private void globo19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo19MousePressed
        globo19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo19_press.png")));
    }//GEN-LAST:event_globo19MousePressed

    private void globo19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo19MouseReleased
        globo19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo19.png")));
    }//GEN-LAST:event_globo19MouseReleased

    private void globo20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo20MouseEntered
        globo20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo20_hover.png")));
    }//GEN-LAST:event_globo20MouseEntered

    private void globo20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo20MouseExited
        globo20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo20.png")));
    }//GEN-LAST:event_globo20MouseExited

    private void globo20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo20MousePressed
        globo20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo20_press.png")));
    }//GEN-LAST:event_globo20MousePressed

    private void globo20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo20MouseReleased
        globo20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo20.png")));
    }//GEN-LAST:event_globo20MouseReleased

    private void globo21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo21MouseEntered
        globo21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo21_hover.png")));
    }//GEN-LAST:event_globo21MouseEntered

    private void globo21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo21MouseExited
        globo21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo21.png")));
    }//GEN-LAST:event_globo21MouseExited

    private void globo21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo21MousePressed
        globo21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo21_press.png")));
    }//GEN-LAST:event_globo21MousePressed

    private void globo21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo21MouseReleased
        globo21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo21.png")));
    }//GEN-LAST:event_globo21MouseReleased

    private void globo22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo22MouseEntered
        globo22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo22_hover.png")));
    }//GEN-LAST:event_globo22MouseEntered

    private void globo22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo22MouseExited
        globo22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo22.png")));
    }//GEN-LAST:event_globo22MouseExited

    private void globo22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo22MousePressed
        globo22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo22_press.png")));
    }//GEN-LAST:event_globo22MousePressed

    private void globo22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo22MouseReleased
        globo22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo22.png")));
    }//GEN-LAST:event_globo22MouseReleased

    private void globo23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo23MouseEntered
        globo23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo23_hover.png")));
    }//GEN-LAST:event_globo23MouseEntered

    private void globo23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo23MouseExited
        globo23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo23.png")));
    }//GEN-LAST:event_globo23MouseExited

    private void globo23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo23MousePressed
        globo23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo23_press.png")));
    }//GEN-LAST:event_globo23MousePressed

    private void globo23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo23MouseReleased
        globo23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo23.png")));
    }//GEN-LAST:event_globo23MouseReleased

    private void globo24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo24MouseEntered
        globo24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo24_hover.png")));
    }//GEN-LAST:event_globo24MouseEntered

    private void globo24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo24MouseExited
        globo24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo24.png")));
    }//GEN-LAST:event_globo24MouseExited

    private void globo24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo24MousePressed
        globo24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo24_press.png")));
    }//GEN-LAST:event_globo24MousePressed

    private void globo24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo24MouseReleased
        globo24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo24.png")));
    }//GEN-LAST:event_globo24MouseReleased

    private void globo25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo25MouseEntered
        globo25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo25_hover.png")));
    }//GEN-LAST:event_globo25MouseEntered

    private void globo25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo25MouseExited
        globo25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo25.png")));
    }//GEN-LAST:event_globo25MouseExited

    private void globo25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo25MousePressed
        globo25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo25_press.png")));
    }//GEN-LAST:event_globo25MousePressed

    private void globo25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_globo25MouseReleased
        globo25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/globo25.png")));
    }//GEN-LAST:event_globo25MouseReleased

    private void boton_sonido3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonido3MousePressed
        if (musica_isActive) {
            boton_sonido3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido_pulsado.png")));
        } else {
            boton_sonido3.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado_pulsado.png")));
        }
    }//GEN-LAST:event_boton_sonido3MousePressed

    private void boton_sonido3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_sonido3MouseReleased
        if (musica_isActive) { //Si está activa -> la desactivamos.
            boton_sonido3.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
            musica_isActive = false;
            pausarMusica();
        } else {
            boton_sonido3.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
            musica_isActive = true;
            activarMusica();
        }
    }//GEN-LAST:event_boton_sonido3MouseReleased

    private void alumno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumno3ActionPerformed
        panel_login.setVisible(false);
        panel_pass_infantil.setVisible(true);
    }//GEN-LAST:event_alumno3ActionPerformed

    private void letra1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra1MouseClicked
        letraAprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AA.png")));
        letraA = true;
        if (comprobarNombrePrimaria()) {
            panel_pass_primaria.setVisible(false);
            panel_fases.setVisible(true);
            desactivarNombre();
        }
    }//GEN-LAST:event_letra1MouseClicked

    private void letra1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra1MouseEntered
        letra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_a_hover.png")));
    }//GEN-LAST:event_letra1MouseEntered

    private void letra1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra1MouseExited
        letra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_a.png")));
    }//GEN-LAST:event_letra1MouseExited

    private void letra1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra1MousePressed
        letra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_a_press.png")));
    }//GEN-LAST:event_letra1MousePressed

    private void letra1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra1MouseReleased
        letra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_a.png")));
    }//GEN-LAST:event_letra1MouseReleased

    private void letra2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra2MouseEntered
        letra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_b_hover.png")));
    }//GEN-LAST:event_letra2MouseEntered

    private void letra2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra2MouseExited
        letra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_b.png")));
    }//GEN-LAST:event_letra2MouseExited

    private void letra2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra2MousePressed
        letra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_b_press.png")));
    }//GEN-LAST:event_letra2MousePressed

    private void letra2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra2MouseReleased
        letra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_b.png")));
    }//GEN-LAST:event_letra2MouseReleased

    private void letra3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra3MouseEntered
        letra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_c_hover.png")));
    }//GEN-LAST:event_letra3MouseEntered

    private void letra3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra3MouseExited
        letra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_c.png")));
    }//GEN-LAST:event_letra3MouseExited

    private void letra3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra3MousePressed
        letra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_c_press.png")));
    }//GEN-LAST:event_letra3MousePressed

    private void letra3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra3MouseReleased
        letra3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_c.png")));
    }//GEN-LAST:event_letra3MouseReleased

    private void letra4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra4MouseEntered
        letra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_d_hover.png")));
    }//GEN-LAST:event_letra4MouseEntered

    private void letra4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra4MouseExited
        letra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_d.png")));
    }//GEN-LAST:event_letra4MouseExited

    private void letra4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra4MousePressed
        letra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_d_press.png")));
    }//GEN-LAST:event_letra4MousePressed

    private void letra4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra4MouseReleased
        letra4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_d.png")));
    }//GEN-LAST:event_letra4MouseReleased

    private void letra5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra5MouseEntered
        letra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_e_hover.png")));
    }//GEN-LAST:event_letra5MouseEntered

    private void letra5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra5MouseExited
        letra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_e.png")));
    }//GEN-LAST:event_letra5MouseExited

    private void letra5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra5MousePressed
        letra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_e_press.png")));
    }//GEN-LAST:event_letra5MousePressed

    private void letra5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra5MouseReleased
        letra5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_e.png")));
    }//GEN-LAST:event_letra5MouseReleased

    private void letra6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra6MouseEntered
        letra6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_f_hover.png")));
    }//GEN-LAST:event_letra6MouseEntered

    private void letra6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra6MouseExited
        letra6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_f.png")));
    }//GEN-LAST:event_letra6MouseExited

    private void letra6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra6MousePressed
        letra6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_f_press.png")));
    }//GEN-LAST:event_letra6MousePressed

    private void letra6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra6MouseReleased
        letra6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_f.png")));
    }//GEN-LAST:event_letra6MouseReleased

    private void letra7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra7MouseEntered
        letra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_g_hover.png")));
    }//GEN-LAST:event_letra7MouseEntered

    private void letra7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra7MouseExited
        letra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_g.png")));
    }//GEN-LAST:event_letra7MouseExited

    private void letra7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra7MousePressed
        letra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_g_press.png")));
    }//GEN-LAST:event_letra7MousePressed

    private void letra7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra7MouseReleased
        letra7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_g.png")));
    }//GEN-LAST:event_letra7MouseReleased

    private void letra8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra8MouseEntered
        letra8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_h_hover.png")));
    }//GEN-LAST:event_letra8MouseEntered

    private void letra8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra8MouseExited
        letra8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_h.png")));
    }//GEN-LAST:event_letra8MouseExited

    private void letra8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra8MousePressed
        letra8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_h_press.png")));
    }//GEN-LAST:event_letra8MousePressed

    private void letra8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra8MouseReleased
        letra8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_h.png")));
    }//GEN-LAST:event_letra8MouseReleased

    private void letra9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra9MouseEntered
        letra9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_i_hover.png")));
    }//GEN-LAST:event_letra9MouseEntered

    private void letra9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra9MouseExited
        letra9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_i.png")));
    }//GEN-LAST:event_letra9MouseExited

    private void letra9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra9MousePressed
        letra9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_i_press.png")));
    }//GEN-LAST:event_letra9MousePressed

    private void letra9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra9MouseReleased
        letra9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_i.png")));
    }//GEN-LAST:event_letra9MouseReleased

    private void letra10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra10MouseClicked
        letraJprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JJ.png")));
        letraJ = true;
        if (comprobarNombrePrimaria()) {
            panel_pass_primaria.setVisible(false);
            panel_fases.setVisible(true);
            desactivarNombre();
        }
    }//GEN-LAST:event_letra10MouseClicked

    private void letra10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra10MouseEntered
        letra10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_j_hover.png")));
    }//GEN-LAST:event_letra10MouseEntered

    private void letra10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra10MouseExited
        letra10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_j.png")));
    }//GEN-LAST:event_letra10MouseExited

    private void letra10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra10MousePressed
        letra10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_j_press.png")));
    }//GEN-LAST:event_letra10MousePressed

    private void letra10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra10MouseReleased
        letra10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_j.png")));
    }//GEN-LAST:event_letra10MouseReleased

    private void letra11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra11MouseEntered
        letra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_k_hover.png")));
    }//GEN-LAST:event_letra11MouseEntered

    private void letra11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra11MouseExited
        letra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_k.png")));
    }//GEN-LAST:event_letra11MouseExited

    private void letra11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra11MousePressed
        letra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_k_press.png")));
    }//GEN-LAST:event_letra11MousePressed

    private void letra11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra11MouseReleased
        letra11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_k.png")));
    }//GEN-LAST:event_letra11MouseReleased

    private void letra12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra12MouseEntered
        letra12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_l_hover.png")));
    }//GEN-LAST:event_letra12MouseEntered

    private void letra12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra12MouseExited
        letra12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_l.png")));
    }//GEN-LAST:event_letra12MouseExited

    private void letra12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra12MousePressed
        letra12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_l_press.png")));
    }//GEN-LAST:event_letra12MousePressed

    private void letra12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra12MouseReleased
        letra12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_l.png")));
    }//GEN-LAST:event_letra12MouseReleased

    private void letra13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra13MouseEntered
        letra13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_m_hover.png")));
    }//GEN-LAST:event_letra13MouseEntered

    private void letra13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra13MouseExited
        letra13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_m.png")));
    }//GEN-LAST:event_letra13MouseExited

    private void letra13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra13MousePressed
        letra13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_m_press.png")));
    }//GEN-LAST:event_letra13MousePressed

    private void letra13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra13MouseReleased
        letra13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_m.png")));
    }//GEN-LAST:event_letra13MouseReleased

    private void letra14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra14MouseClicked
        letraNprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NNN.png")));
        letraN = true;
        if (comprobarNombrePrimaria()) {
            panel_pass_primaria.setVisible(false);
            panel_fases.setVisible(true);
            desactivarNombre();
        }
    }//GEN-LAST:event_letra14MouseClicked

    private void letra14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra14MouseEntered
        letra14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_n_hover.png")));
    }//GEN-LAST:event_letra14MouseEntered

    private void letra14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra14MouseExited
        letra14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_n.png")));
    }//GEN-LAST:event_letra14MouseExited

    private void letra14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra14MousePressed
        letra14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_n_press.png")));
    }//GEN-LAST:event_letra14MousePressed

    private void letra14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra14MouseReleased
        letra14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_n.png")));
    }//GEN-LAST:event_letra14MouseReleased

    private void letra15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra15MouseEntered
        letra15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_nn_hover.png")));
    }//GEN-LAST:event_letra15MouseEntered

    private void letra15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra15MouseExited
        letra15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_nn.png")));
    }//GEN-LAST:event_letra15MouseExited

    private void letra15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra15MousePressed
        letra15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_nn_press.png")));
    }//GEN-LAST:event_letra15MousePressed

    private void letra15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra15MouseReleased
        letra15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_nn.png")));
    }//GEN-LAST:event_letra15MouseReleased

    private void letra16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra16MouseEntered
        letra16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_o_hover.png")));
    }//GEN-LAST:event_letra16MouseEntered

    private void letra16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra16MouseExited
        letra16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_o.png")));
    }//GEN-LAST:event_letra16MouseExited

    private void letra16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra16MousePressed
        letra16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_o_press.png")));
    }//GEN-LAST:event_letra16MousePressed

    private void letra16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra16MouseReleased
        letra16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_o.png")));
    }//GEN-LAST:event_letra16MouseReleased

    private void letra17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra17MouseEntered
        letra17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_p_hover.png")));
    }//GEN-LAST:event_letra17MouseEntered

    private void letra17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra17MouseExited
        letra17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_p.png")));
    }//GEN-LAST:event_letra17MouseExited

    private void letra17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra17MousePressed
        letra17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_p_press.png")));
    }//GEN-LAST:event_letra17MousePressed

    private void letra17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra17MouseReleased
        letra17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_p.png")));
    }//GEN-LAST:event_letra17MouseReleased

    private void letra18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra18MouseEntered
        letra18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_q_hover.png")));
    }//GEN-LAST:event_letra18MouseEntered

    private void letra18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra18MouseExited
        letra18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_q.png")));
    }//GEN-LAST:event_letra18MouseExited

    private void letra18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra18MousePressed
        letra18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_q_press.png")));
    }//GEN-LAST:event_letra18MousePressed

    private void letra18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra18MouseReleased
        letra18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_q.png")));
    }//GEN-LAST:event_letra18MouseReleased

    private void letra19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra19MouseEntered
        letra19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_r_hover.png")));
    }//GEN-LAST:event_letra19MouseEntered

    private void letra19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra19MouseExited
        letra19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_r.png")));
    }//GEN-LAST:event_letra19MouseExited

    private void letra19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra19MousePressed
        letra19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_r_hover.png")));
    }//GEN-LAST:event_letra19MousePressed

    private void letra19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra19MouseReleased
        letra19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_r.png")));
    }//GEN-LAST:event_letra19MouseReleased

    private void letra20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra20MouseEntered
        letra20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_s_hover.png")));
    }//GEN-LAST:event_letra20MouseEntered

    private void letra20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra20MouseExited
        letra20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_s.png")));
    }//GEN-LAST:event_letra20MouseExited

    private void letra20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra20MousePressed
        letra20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_s_press.png")));
    }//GEN-LAST:event_letra20MousePressed

    private void letra20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra20MouseReleased
        letra20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_s.png")));
    }//GEN-LAST:event_letra20MouseReleased

    private void letra21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra21MouseEntered
        letra21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_t_hover.png")));
    }//GEN-LAST:event_letra21MouseEntered

    private void letra21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra21MouseExited
        letra21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_t.png")));
    }//GEN-LAST:event_letra21MouseExited

    private void letra21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra21MousePressed
        letra21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_t_press.png")));
    }//GEN-LAST:event_letra21MousePressed

    private void letra21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra21MouseReleased
        letra21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_t.png")));
    }//GEN-LAST:event_letra21MouseReleased

    private void letra22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra22MouseClicked
        letraUprimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UU.png")));
        letraU = true;
        if (comprobarNombrePrimaria()) {
            panel_pass_primaria.setVisible(false);
            panel_fases.setVisible(true);
            desactivarNombre();
        }
    }//GEN-LAST:event_letra22MouseClicked

    private void letra22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra22MouseEntered
        letra22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_u_hover.png")));
    }//GEN-LAST:event_letra22MouseEntered

    private void letra22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra22MouseExited
        letra22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_u.png")));
    }//GEN-LAST:event_letra22MouseExited

    private void letra22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra22MousePressed
        letra22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_u_press.png")));
    }//GEN-LAST:event_letra22MousePressed

    private void letra22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra22MouseReleased
        letra22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_u.png")));
    }//GEN-LAST:event_letra22MouseReleased

    private void letra23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra23MouseEntered
        letra23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_v_hover.png")));
    }//GEN-LAST:event_letra23MouseEntered

    private void letra23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra23MouseExited
        letra23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_v.png")));
    }//GEN-LAST:event_letra23MouseExited

    private void letra23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra23MousePressed
        letra23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_v_press.png")));
    }//GEN-LAST:event_letra23MousePressed

    private void letra23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra23MouseReleased
        letra23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_v.png")));
    }//GEN-LAST:event_letra23MouseReleased

    private void letra24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra24MouseEntered
        letra24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_w_hover.png")));
    }//GEN-LAST:event_letra24MouseEntered

    private void letra24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra24MouseExited
        letra24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_w.png")));
    }//GEN-LAST:event_letra24MouseExited

    private void letra24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra24MousePressed
        letra24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_w_press.png")));
    }//GEN-LAST:event_letra24MousePressed

    private void letra24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra24MouseReleased
        letra24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_w.png")));
    }//GEN-LAST:event_letra24MouseReleased

    private void letra25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra25MouseEntered
        letra25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_x_hover.png")));
    }//GEN-LAST:event_letra25MouseEntered

    private void letra25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra25MouseExited
        letra25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_x.png")));
    }//GEN-LAST:event_letra25MouseExited

    private void letra25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra25MousePressed
        letra25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_x_press.png")));
    }//GEN-LAST:event_letra25MousePressed

    private void letra25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra25MouseReleased
        letra25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_x.png")));
    }//GEN-LAST:event_letra25MouseReleased

    private void letra26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra26MouseEntered
        letra26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_y_hover.png")));
    }//GEN-LAST:event_letra26MouseEntered

    private void letra26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra26MouseExited
        letra26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_y.png")));
    }//GEN-LAST:event_letra26MouseExited

    private void letra26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra26MousePressed
        letra26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_y_press.png")));
    }//GEN-LAST:event_letra26MousePressed

    private void letra26MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra26MouseReleased
        letra26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_y.png")));
    }//GEN-LAST:event_letra26MouseReleased

    private void letra27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra27MouseEntered
        letra27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_z_hover.png")));
    }//GEN-LAST:event_letra27MouseEntered

    private void letra27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra27MouseExited
        letra27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_z.png")));
    }//GEN-LAST:event_letra27MouseExited

    private void letra27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra27MousePressed
        letra27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_z_press.png")));
    }//GEN-LAST:event_letra27MousePressed

    private void letra27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letra27MouseReleased
        letra27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/letras_z.png")));
    }//GEN-LAST:event_letra27MouseReleased

    private void alumno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumno4ActionPerformed
        panel_login.setVisible(false);
        panel_pass_primaria.setVisible(true);
    }//GEN-LAST:event_alumno4ActionPerformed

    private void letra10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letra10ActionPerformed

    }//GEN-LAST:event_letra10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        panel_fases.setVisible(false);
        panel_inicio.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void backFase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFase1ActionPerformed
        panel_fase1.setVisible(false);
        panel_fases.setVisible(true);
    }//GEN-LAST:event_backFase1ActionPerformed

    private void back_pass_infantilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_pass_infantilActionPerformed
        panel_pass_infantil.setVisible(false);
        panel_login.setVisible(true);
    }//GEN-LAST:event_back_pass_infantilActionPerformed

    private void back_login_primariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_login_primariaActionPerformed
        panel_pass_primaria.setVisible(false);
        panel_login.setVisible(true);
    }//GEN-LAST:event_back_login_primariaActionPerformed

    private void sonido_LoginPrimariaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sonido_LoginPrimariaMousePressed
        if (musica_isActive) {
            sonido_LoginPrimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton_sonido_pulsado.png")));
        } else {
            sonido_LoginPrimaria.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado_pulsado.png")));
        }
    }//GEN-LAST:event_sonido_LoginPrimariaMousePressed

    private void sonido_LoginPrimariaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sonido_LoginPrimariaMouseReleased
        if (musica_isActive) { //Si está activa -> la desactivamos.
            sonido_LoginPrimaria.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido_desactivado.png")));
            musica_isActive = false;
            pausarMusica();
        } else {
            sonido_LoginPrimaria.setIcon(new ImageIcon(getClass().getResource("/img/boton_sonido.png")));
            musica_isActive = true;
            activarMusica();
        }
    }//GEN-LAST:event_sonido_LoginPrimariaMouseReleased

    private void backSilabas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSilabas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas1MouseClicked

    private void soluciónsilabas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soluciónsilabas1ActionPerformed
        // TODO add your handling code here:
        panel_acertado.setVisible(true);
    }//GEN-LAST:event_soluciónsilabas1ActionPerformed

    private void boton3silabas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3silabas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton3silabas1ActionPerformed

    private void backSilabas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSilabas2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas2MouseClicked

    private void soluciónsilabas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soluciónsilabas2ActionPerformed
        // TODO add your handling code here:
        panel_acertado.setVisible(true);
    }//GEN-LAST:event_soluciónsilabas2ActionPerformed

    private void boton1silabas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1silabas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton1silabas2ActionPerformed

    private void boton2silabas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2silabas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton2silabas2ActionPerformed

    private void backSilabas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backSilabas3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backSilabas3MouseClicked

    private void solucionsilabas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solucionsilabas3ActionPerformed
        // TODO add your handling code here:
        panel_acertado.setVisible(true);
    }//GEN-LAST:event_solucionsilabas3ActionPerformed

    private void nivel1fase2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase2MousePressed
        // TODO add your handling code here:
        nivel1fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_red_pulsado.png")));
    }//GEN-LAST:event_nivel1fase2MousePressed

    private void nivel1fase2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase2MouseReleased
        // TODO add your handling code here:
        nivel1fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_red.png")));
    }//GEN-LAST:event_nivel1fase2MouseReleased

    private void nivel1fase2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase2MouseExited
        // TODO add your handling code here:
        nivel1fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_red.png")));
    }//GEN-LAST:event_nivel1fase2MouseExited

    private void nivel1fase2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase2MouseEntered
        // TODO add your handling cocircle_blue_pulsadode here:
        nivel1fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_red_hover.png")));
    }//GEN-LAST:event_nivel1fase2MouseEntered

    private void nivel1fase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel1fase2ActionPerformed
        panel_fase2.setVisible(false);
        panel_nivel1fase2.setVisible(true);
    }//GEN-LAST:event_nivel1fase2ActionPerformed

    private void nivel2fase2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase2MousePressed
        // TODO add your handling code here:
        nivel2fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_grey_pulsado.png")));
    }//GEN-LAST:event_nivel2fase2MousePressed

    private void nivel2fase2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase2MouseReleased
        // TODO add your handling code here:
        nivel2fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_grey.png")));
    }//GEN-LAST:event_nivel2fase2MouseReleased

    private void nivel2fase2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase2MouseExited
        // TODO add your handling code here:
        nivel2fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_grey.png")));
    }//GEN-LAST:event_nivel2fase2MouseExited

    private void nivel2fase2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase2MouseEntered
        // TODO add your handling code here:
        nivel2fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_grey_hover.png")));
    }//GEN-LAST:event_nivel2fase2MouseEntered

    private void nivel3fase2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase2MousePressed
        // TODO add your handling code here:
        nivel3fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange_pulsado.png")));
    }//GEN-LAST:event_nivel3fase2MousePressed

    private void nivel3fase2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase2MouseReleased
        // TODO add your handling code here:
        nivel3fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_orange.png")));
    }//GEN-LAST:event_nivel3fase2MouseReleased

    private void nivel3fase2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase2MouseExited
        // TODO add your handling code here:
        nivel3fase2.setIcon(new ImageIcon(getClass().getResource("/img/circle_orange.png")));
    }//GEN-LAST:event_nivel3fase2MouseExited

    private void nivel3fase2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase2MouseEntered
        // TODO add your handling code here:
        nivel3fase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange_hover.png")));
    }//GEN-LAST:event_nivel3fase2MouseEntered

    private void nivel3fase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3fase2ActionPerformed
        panel_nivel3fase2.setVisible(true);
        panel_nivel3fase2.setVisible(false);
    }//GEN-LAST:event_nivel3fase2ActionPerformed

    private void backFase2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backFase2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backFase2MouseClicked

    private void homeFase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFase2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeFase2ActionPerformed

    private void nivel2fase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel2fase2ActionPerformed
        panel_nivel2fase2.setVisible(true);
        panel_fases.setVisible(false);
    }//GEN-LAST:event_nivel2fase2ActionPerformed

    private void boton2silabas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2silabas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton2silabas1ActionPerformed

    private void letraPulsadaEvent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letraPulsadaEvent
        JButton boton_evento = (JButton) evt.getSource();
        /**
         * SECCION CRITICA.
         */
        switch (boton_evento.getText()) {
            case "G":
                if (boton_evento.getName().equals("G_GATO")) {
                    gato[0] = true;
                    letraG_gato.setSelected(true);
                    if (comprobarPalabra("gato")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGato.setEnabled(false);
                    }
                } else if (boton_evento.getName().equals("G_GOMA")) {
                    goma[0] = true;
                    letraG_goma.setSelected(true);
                    if (comprobarPalabra("goma")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGoma.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "A":
                if (boton_evento.getName().equals("A_GATO")) {
                    gato[1] = true;
                    letraA_gato.setSelected(true);
                    if (comprobarPalabra("gato")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGato.setEnabled(false);
                    }
                } else if (boton_evento.getName().equals("A_GOMA")) {
                    goma[3] = true;
                    letraA_gato.setSelected(true);
                    if (comprobarPalabra("goma")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGoma.setEnabled(false);
                    }
                } else if (boton_evento.getName().equals("A_LAPIZ")) {
                    lapiz[1] = true;
                    letraA_lapiz.setSelected(true);
                    if (comprobarPalabra("lapiz")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenLapiz.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "M":
                if (boton_evento.getName().equals("M_GOMA")) {
                    goma[2] = true;
                    letraM_goma.setSelected(true);
                    if (comprobarPalabra("goma")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGoma.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "O":
                if (boton_evento.getName().equals("O_GATO")) {
                    gato[3] = true;
                    letraO_gato.setSelected(true);
                    if (comprobarPalabra("gato")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGato.setEnabled(false);
                    }
                } else if (boton_evento.getName().equals("O_GOMA")) {
                    goma[1] = true;
                    letraO_goma.setSelected(true);
                    if (comprobarPalabra("goma")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGoma.setEnabled(false);
                    }
                } else if (boton_evento.getName().equals("O_SOL")) {
                    sol[1] = true;
                    letraO_sol.setSelected(true);
                    if (comprobarPalabra("sol")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenSol.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "L":
                if (boton_evento.getName().equals("L_LAPIZ")) {
                    lapiz[0] = true;
                    letraL_lapiz.setSelected(true);
                    if (comprobarPalabra("lapiz")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenLapiz.setEnabled(false);
                    }
                } else if (boton_evento.getName().equals("L_SOL")) {
                    sol[2] = true;
                    letraL_sol.setSelected(true);
                    if (comprobarPalabra("sol")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenSol.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "I":
                if (boton_evento.getName().equals("I_LAPIZ")) {
                    lapiz[3] = true;
                    letraI_lapiz.setSelected(true);
                    if (comprobarPalabra("lapiz")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenLapiz.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "P":
                if (boton_evento.getName().equals("P_LAPIZ")) {
                    lapiz[2] = true;
                    letraP_lapiz.setSelected(true);
                    if (comprobarPalabra("lapiz")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenLapiz.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "Z":
                if (boton_evento.getName().equals("Z_LAPIZ")) {
                    lapiz[4] = true;
                    letraZ_lapiz.setSelected(true);
                    if (comprobarPalabra("lapiz")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenLapiz.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "T":
                if (boton_evento.getName().equals("T_GATO")) {
                    gato[2] = true;
                    letraT_gato.setSelected(true);
                    if (comprobarPalabra("gato")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenGato.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            case "S":
                if (boton_evento.getName().equals("S_SOL")) {
                    sol[0] = true;
                    letraS_sol.setSelected(true);
                    if (comprobarPalabra("sol")) {
                        /**
                         * SONIDO BIEEEN.
                         */

                        /**/
                        imagenSol.setEnabled(false);
                    }
                } else {
                    desactivarLetras();
                }
                break;
            default:
                desactivarLetras();
                break;
        }
    }//GEN-LAST:event_letraPulsadaEvent

    private void nivel1fase3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase3MousePressed
        // TODO add your handling code here:
        nivel1fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_green_pulsado.png")));
    }//GEN-LAST:event_nivel1fase3MousePressed

    private void nivel1fase3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase3MouseReleased
        // TODO add your handling code here:
        nivel1fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_green.png")));
    }//GEN-LAST:event_nivel1fase3MouseReleased

    private void nivel1fase3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase3MouseExited
        // TODO add your handling code here:
        nivel1fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_green.png")));
    }//GEN-LAST:event_nivel1fase3MouseExited

    private void nivel1fase3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel1fase3MouseEntered
        // TODO add your handling cocircle_blue_pulsadode here:
        nivel1fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_green_hover.png")));
    }//GEN-LAST:event_nivel1fase3MouseEntered

    private void nivel2fase3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase3MousePressed
        // TODO add your handling code here:
        nivel2fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange_pulsado.png")));
    }//GEN-LAST:event_nivel2fase3MousePressed

    private void nivel2fase3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase3MouseReleased
        // TODO add your handling code here:
        nivel2fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_orange.png")));
    }//GEN-LAST:event_nivel2fase3MouseReleased

    private void nivel2fase3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase3MouseExited
        // TODO add your handling code here:
        nivel2fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_orange.png")));
    }//GEN-LAST:event_nivel2fase3MouseExited

    private void nivel2fase3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel2fase3MouseEntered
        // TODO add your handling code here:
        nivel2fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_orange_hover.png")));
    }//GEN-LAST:event_nivel2fase3MouseEntered

    private void nivel2fase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel2fase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel2fase3ActionPerformed

    private void nivel3fase3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase3MousePressed
        // TODO add your handling code here:
        nivel3fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow_pulsado.png")));
    }//GEN-LAST:event_nivel3fase3MousePressed

    private void nivel3fase3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase3MouseReleased
        // TODO add your handling code here:
        nivel3fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow.png")));
    }//GEN-LAST:event_nivel3fase3MouseReleased

    private void nivel3fase3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase3MouseExited
        // TODO add your handling code here:
        nivel3fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_yellow.png")));
    }//GEN-LAST:event_nivel3fase3MouseExited

    private void nivel3fase3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel3fase3MouseEntered
        // TODO add your handling code here:
        nivel3fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_yellow_hover.png")));
    }//GEN-LAST:event_nivel3fase3MouseEntered

    private void nivel3fase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3fase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel3fase3ActionPerformed

    private void nivel4fase3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase3MousePressed
        // TODO add your handling code here:
        nivel4fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue_pulsado.png")));
    }//GEN-LAST:event_nivel4fase3MousePressed

    private void nivel4fase3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase3MouseReleased
        // TODO add your handling code here:
        nivel4fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue.png")));
    }//GEN-LAST:event_nivel4fase3MouseReleased

    private void nivel4fase3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase3MouseExited
        // TODO add your handling code here:
        nivel4fase3.setIcon(new ImageIcon(getClass().getResource("/img/circle_blue.png")));
    }//GEN-LAST:event_nivel4fase3MouseExited

    private void nivel4fase3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivel4fase3MouseEntered
        // TODO add your handling code here:
        nivel4fase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle_blue_hover.png")));
    }//GEN-LAST:event_nivel4fase3MouseEntered

    private void nivel4fase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel4fase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivel4fase3ActionPerformed

    private void homeFase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeFase3ActionPerformed

    private void nivel1fase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel1fase3ActionPerformed
        panelPalabrasNivel1.setVisible(true);
        panel_fase3.setVisible(false);
    }//GEN-LAST:event_nivel1fase3ActionPerformed

    public void desactivarLetras() {

        for (int i = 0; i < gato.length; i++) {
            gato[i] = false;
        }
        for (int i = 0; i < goma.length; i++) {
            goma[i] = false;
        }
        for (int i = 0; i < sol.length; i++) {
            sol[i] = false;
        }
        for (int i = 0; i < lapiz.length; i++) {
            lapiz[i] = false;
        }

        letraG_gato.setSelected(false);
        letraG_goma.setSelected(false);
        letraA_gato.setSelected(false);
        letraA_goma.setSelected(false);
        letraA_lapiz.setSelected(false);
        letraL_lapiz.setSelected(false);
        letraL_sol.setSelected(false);
        letraI_lapiz.setSelected(false);
        letraM_goma.setSelected(false);
        letraO_gato.setSelected(false);
        letraO_goma.setSelected(false);
        letraO_sol.setSelected(false);
        letraS_sol.setSelected(false);
        letraZ_lapiz.setSelected(false);
        letraT_gato.setSelected(false);
        letraP_lapiz.setSelected(false);
    }

    public boolean comprobarPalabra(String palabra) {
        boolean completada = true;
        switch (palabra) {
            case "gato":
                for (int i = 0; i < gato.length; i++) {
                    if (!gato[i]) {
                        completada = false;
                    }
                }
                break;
            case "goma":
                for (int i = 0; i < goma.length; i++) {
                    if (!goma[i]) {
                        completada = false;
                    }
                }
                break;
            case "sol":
                for (int i = 0; i < sol.length; i++) {
                    if (!sol[i]) {
                        completada = false;
                    }

                }
                break;
            case "lapiz":
                for (int i = 0; i < lapiz.length; i++) {
                    if (!lapiz[i]) {
                        completada = false;
                    }
                }
                break;
        }
        return completada;
    }

    /**
     * Métodos de Javi.
     */
    /**
     * Generar la lista de alumnos con: Nº Lista + apellidos + , + Nombre.
     */
    public void generarListadoAlumnos() {
        int i = 0;
        for (Alumno elegido : alumnos) {
            nombres_lista_alumnos[i] = i + 1 + " " + elegido.getApellidos() + ", " + elegido.getNombre();
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
     *
     * @param bpe BasicPlayerEvent
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

    /**
     * Activar los componentes del alumno.
     */
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

    /**
     * Cargar datos del alumno en la interfaz profesor.
     *
     * @param elegido alumno elegido.
     */
    public void cargarDatosAlumno(Alumno elegido) {
        nombre_alumno_profe.setText(elegido.getNombre());
        apellido_alumno_profe.setText(elegido.getApellidos());
        telefono_alumno_profe.setText(elegido.getTelefono());
        direccion_alumno_profe.setText(elegido.getDireccion());
        foto_alumno.setIcon(elegido.getImagen());
        textArea_observaciones.setText(elegido.getObservaciones());
    }

    /**
     * Cargar Fallos del alumno.
     *
     * @param elegido alumno elegido.
     */
    public void cargarFallos(Alumno elegido) {
        for (int i = 0; i < 15; i++) {
            modelo_tabla_resultados.setValueAt(elegido.getFallos(i), i, 2);
        }
    }

    /**
     * Activar música.
     */
    public void activarMusica() {
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

    /**
     * Pausar Musica.
     */
    public void pausarMusica() {
        try {
            control.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Stop Musica.
     */
    public void stopMusica() {
        try {
            control.stop();
            control_pausado = true;
        } catch (BasicPlayerException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fin métodos de Javi.
     */
    /**
     * Inicio métodos Juanan.
     */
    public boolean comprobarNombrePrimaria() {
        return (letraJ && letraU && letraA && letraN);
    }

    public void desactivarNombre() {
        letraJ = false;
        letraJprimaria.setIcon(new ImageIcon(getClass().getResource("/img/J.png")));
        letraA = false;
        letraAprimaria.setIcon(new ImageIcon(getClass().getResource("/img/A.png")));
        letraU = false;
        letraUprimaria.setIcon(new ImageIcon(getClass().getResource("/img/U.png")));
        letraN = false;
        letraNprimaria.setIcon(new ImageIcon(getClass().getResource("/img/N.png")));
    }

    /**
     * Fin métodos Juanan
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.alee.laf.label.WebLabel TituloFase1;
    private com.alee.laf.label.WebLabel TituloFase2;
    private com.alee.laf.label.WebLabel TituloFase3;
    private com.alee.laf.label.WebLabel TituloSilabas1;
    private com.alee.laf.label.WebLabel TituloSilabas2;
    private com.alee.laf.label.WebLabel TituloSilabas3;
    private javax.swing.JButton alumno1;
    private javax.swing.JButton alumno2;
    private javax.swing.JButton alumno3;
    private javax.swing.JButton alumno4;
    private javax.swing.JButton alumno5;
    private javax.swing.JButton alumno6;
    private javax.swing.JButton alumno7;
    private javax.swing.JButton alumno8;
    private com.alee.laf.text.WebTextField apellido_alumno_profe;
    private javax.swing.JButton atras_login;
    private javax.swing.JButton backFase1;
    private javax.swing.JButton backFase2;
    private javax.swing.JButton backFase3;
    private javax.swing.JButton backSilabas1;
    private javax.swing.JButton backSilabas2;
    private javax.swing.JButton backSilabas3;
    private javax.swing.JButton back_login_primaria;
    private javax.swing.JButton back_pass_infantil;
    private javax.swing.JButton barco;
    private javax.swing.JButton biblioteca;
    private javax.swing.JButton boton1silabas1;
    private javax.swing.JButton boton1silabas2;
    private javax.swing.JButton boton1silabas3;
    private javax.swing.JButton boton2silabas1;
    private javax.swing.JButton boton2silabas2;
    private javax.swing.JButton boton2silabas3;
    private javax.swing.JButton boton3silabas1;
    private javax.swing.JButton boton3silabas2;
    private javax.swing.JButton boton3silabas3;
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
    private javax.swing.JButton boton_sonido1;
    private javax.swing.JButton boton_sonido2;
    private javax.swing.JButton boton_sonido3;
    private com.alee.laf.text.WebTextField direccion_alumno_profe;
    private javax.swing.JButton escuela;
    private javax.swing.JLabel foto;
    private javax.swing.JButton foto_alumno;
    private javax.swing.JButton globo1;
    private javax.swing.JButton globo10;
    private javax.swing.JButton globo11;
    private javax.swing.JButton globo12;
    private javax.swing.JButton globo13;
    private javax.swing.JButton globo14;
    private javax.swing.JButton globo15;
    private javax.swing.JButton globo16;
    private javax.swing.JButton globo17;
    private javax.swing.JButton globo18;
    private javax.swing.JButton globo19;
    private javax.swing.JButton globo2;
    private javax.swing.JButton globo20;
    private javax.swing.JButton globo21;
    private javax.swing.JButton globo22;
    private javax.swing.JButton globo23;
    private javax.swing.JButton globo24;
    private javax.swing.JButton globo25;
    private javax.swing.JButton globo3;
    private javax.swing.JButton globo4;
    private javax.swing.JButton globo5;
    private javax.swing.JButton globo6;
    private javax.swing.JButton globo7;
    private javax.swing.JButton globo8;
    private javax.swing.JButton globo9;
    private javax.swing.JButton homeFase1;
    private javax.swing.JButton homeFase2;
    private javax.swing.JButton homeFase3;
    private javax.swing.JButton homeSilabas1;
    private javax.swing.JButton homeSilabas2;
    private javax.swing.JButton homeSilabas3;
    private javax.swing.JButton home_login;
    private javax.swing.JButton home_login_primaria;
    private javax.swing.JButton home_pass_infantil;
    private javax.swing.JLabel imagenGato;
    private javax.swing.JLabel imagenGoma;
    private javax.swing.JLabel imagenLapiz;
    private javax.swing.JLabel imagenSol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JButton letra1;
    private javax.swing.JButton letra10;
    private javax.swing.JButton letra11;
    private javax.swing.JButton letra12;
    private javax.swing.JButton letra13;
    private javax.swing.JButton letra14;
    private javax.swing.JButton letra15;
    private javax.swing.JButton letra16;
    private javax.swing.JButton letra17;
    private javax.swing.JButton letra18;
    private javax.swing.JButton letra19;
    private javax.swing.JButton letra2;
    private javax.swing.JButton letra20;
    private javax.swing.JButton letra21;
    private javax.swing.JButton letra22;
    private javax.swing.JButton letra23;
    private javax.swing.JButton letra24;
    private javax.swing.JButton letra25;
    private javax.swing.JButton letra26;
    private javax.swing.JButton letra27;
    private javax.swing.JButton letra3;
    private javax.swing.JButton letra4;
    private javax.swing.JButton letra5;
    private javax.swing.JButton letra6;
    private javax.swing.JButton letra7;
    private javax.swing.JButton letra8;
    private javax.swing.JButton letra9;
    private javax.swing.JButton letraA_gato;
    private javax.swing.JButton letraA_goma;
    private javax.swing.JButton letraA_lapiz;
    private javax.swing.JLabel letraAprimaria;
    private javax.swing.JButton letraG_gato;
    private javax.swing.JButton letraG_goma;
    private javax.swing.JButton letraI_lapiz;
    private javax.swing.JLabel letraJprimaria;
    private javax.swing.JButton letraL_lapiz;
    private javax.swing.JButton letraL_sol;
    private javax.swing.JButton letraM_goma;
    private javax.swing.JLabel letraNprimaria;
    private javax.swing.JButton letraO_gato;
    private javax.swing.JButton letraO_goma;
    private javax.swing.JButton letraO_sol;
    private javax.swing.JButton letraP_lapiz;
    private javax.swing.JButton letraS_sol;
    private javax.swing.JButton letraT_gato;
    private javax.swing.JLabel letraUprimaria;
    private javax.swing.JButton letraZ_lapiz;
    private javax.swing.JList lista_nombres_alumnos;
    private javax.swing.JButton nivel1fase1;
    private javax.swing.JButton nivel1fase2;
    private javax.swing.JButton nivel1fase3;
    private javax.swing.JButton nivel2fase1;
    private javax.swing.JButton nivel2fase2;
    private javax.swing.JButton nivel2fase3;
    private javax.swing.JButton nivel3fase1;
    private javax.swing.JButton nivel3fase2;
    private javax.swing.JButton nivel3fase3;
    private javax.swing.JButton nivel4fase1;
    private javax.swing.JButton nivel4fase3;
    private com.alee.laf.text.WebTextField nombre_alumno_profe;
    private com.alee.laf.text.WebTextField nombre_profe;
    private javax.swing.JPanel panelPalabrasNivel1;
    private javax.swing.JPanel panel_acertado;
    private javax.swing.JPanel panel_fase1;
    private javax.swing.JPanel panel_fase2;
    private javax.swing.JPanel panel_fase3;
    private javax.swing.JPanel panel_fases;
    private javax.swing.JPanel panel_inicio;
    private javax.swing.JPanel panel_login;
    private javax.swing.JPanel panel_login_profesor;
    private javax.swing.JPanel panel_nivel1fase2;
    private javax.swing.JPanel panel_nivel2fase2;
    private javax.swing.JPanel panel_nivel3fase2;
    private javax.swing.JPanel panel_pass_infantil;
    private javax.swing.JPanel panel_pass_primaria;
    private javax.swing.JPanel panel_profesor;
    private com.alee.laf.text.WebPasswordField password_profe;
    private javax.swing.JButton piramide;
    private javax.swing.JButton selva;
    private javax.swing.JButton silabasImg1;
    private javax.swing.JButton silabasImg2;
    private javax.swing.JButton silabasImg3;
    private javax.swing.JButton solucionsilabas3;
    private javax.swing.JButton soluciónsilabas1;
    private javax.swing.JButton soluciónsilabas2;
    private javax.swing.JButton sonido_LoginPrimaria;
    private javax.swing.JPanel sopaLetras;
    private com.alee.laf.table.WebTable tabla_resultados;
    private com.alee.laf.text.WebTextField telefono_alumno_profe;
    private com.alee.laf.text.WebTextArea textArea_observaciones;
    private com.alee.laf.label.WebLabel titulo_fases;
    private javax.swing.JLabel titulo_login;
    private com.alee.laf.label.WebLabel titulo_password2;
    private com.alee.laf.label.WebLabel titulo_profesor;
    private com.alee.laf.label.WebLabel webLabel1;
    private com.alee.laf.label.WebLabel webLabel2;
    // End of variables declaration//GEN-END:variables
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
}
