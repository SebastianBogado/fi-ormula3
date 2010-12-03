package Vista;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaSeleccionPista extends JFrame {
	public VentanaSeleccionPista(MenuPrincipal menu){
		/** Se crea un file browser **/
		JFileChooser ventanaSelectora = new JFileChooser(UbicacionArchivo.Pistas);
		FileFilter filtroExtension = new FileNameExtensionFilter("Pistas en xml", "xml");
		ventanaSelectora.addChoosableFileFilter(filtroExtension);
		int returnVal = ventanaSelectora.showOpenDialog(this);
		/** Si se puede abrir se guarda la ruta **/
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File pista = ventanaSelectora.getSelectedFile();
			String pistaSeleccionada = pista.getAbsolutePath();
			menu.setPistaSeleccionada (pistaSeleccionada);
		}			
	}
}
