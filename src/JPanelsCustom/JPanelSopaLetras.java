/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPanelsCustom;

import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Javier
 */
public class JPanelSopaLetras extends JPanel{

    private static final int FILAS = 6;
    private static final int COLUMNAS = 6;
    
    Button [][] palabras = new Button[6][6];
    
    public JPanelSopaLetras() {
        super();
        this.setLayout(new GridLayout(6, 6));
    }
    
    
    
    
    
}
