/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPanelsCustom;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Javier
 */
public class JPanelCustom extends JPanel {

    ImageIcon fondo;

    public JPanelCustom(String nombreImagen) {
        if (nombreImagen != null) {
            fondo = new ImageIcon(getClass().getResource(nombreImagen));
        }
    }

    public void setImagenFondo(String nombreImagen) {
        fondo = new ImageIcon(getClass().getResource(nombreImagen));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (fondo != null) {
            //    g.drawImage: dibujamos la imagen (guardada en el atributo “imagen”) en toda la extension del panel
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

            //    setOpaque(false): le indicamos al panel que no dibuje su fondo por defecto (sino este taparía la imagen)
            setOpaque(false);
        } else {

            setOpaque(true);
        }

//    super.paint(g): le indicamos al panel que continúe dibujando el resto de los componentes
        super.paint(g);
    }

}
