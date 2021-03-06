package cliente;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JPanel;

import core.Fase;

public class Painel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7638259897070943178L;

	private static final int imgx = 800;
	private static final int imgy = 500;
	
	private Cliente cliente;
	private Fase fase;
	
	private final static Logger LOGGER = Logger.getLogger(Painel.class.getName());
	
	public Painel( Cliente cliente, Fase fase) throws IOException {
		
		this.setPreferredSize(new Dimension(imgx, imgy));
		
		this.cliente = cliente;
		this.fase = fase;
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		LOGGER.info("Desenhando Cliente:\t" + cliente.toString() );
		if (fase != null && cliente != null && cliente.getMario() != null && cliente.getLuigi() != null) {
			g.drawImage(fase.getBackground(), 0,0, this);
			
			g.drawImage(fase.getMarioDirImg(), cliente.getMario().getPosicao().getX(), cliente
					.getMario().getPosicao().getY(), this);
			
			g.drawImage(fase.getLuigiDirImg(), cliente.getLuigi().getPosicao().getX(), cliente
					.getLuigi().getPosicao().getY(), this);
		}
	}
}
