/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

/**	Clase JDialogTest.java
 *  Autor Wilfredo Vargas Almendras
 *  Fecha 30/01/2007
 *  Hora 04:25:13 PM
 *  Proyecto Yachay Wasej Punkun
 *
 */
 
 
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
 
@SuppressWarnings("serial")
public class JDialogTest extends JDialog {
	
	private Toolkit toolkit;
	
	private Dimension dimension;
	private int width;
	private int height;
	
	private JFrame parent;
	
	private JTextField text;
	private JButton ok;
	
	public JDialogTest(){
		init();
	}
	
	public JDialogTest(JFrame parent) {
		super(parent);
		this.parent = parent;
		init();
	}
	
	public void init(){
		createComponents();
		setProperties();
		addComponents();
	}
	
	public void createComponents(){
		
		text = new JTextField("Wilfredo");
		ok = new JButton("ok");
		
		toolkit = Toolkit.getDefaultToolkit();
		
		dimension = toolkit.getScreenSize();
		width = dimension.width;
		height = dimension.height;
	}
	
	public void setProperties(){
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(1);
		setBounds(50, 50, 400, 300);
		
		setLayout(null);
		
		text.setBounds(20,50,100,20);
		ok.setBounds(20, 80, 80, 20);
		
		ok.addMouseListener( new MouseAdapter(){
			public void mouseClicked( MouseEvent e ){
				close();
			}
		});
	}
	
	private void addComponents() {
		add(text);
		add(ok);
	}
 
	public void setVisibleDialog( boolean b ){
		setVisible(b);
		text.requestFocusInWindow();
		parent.setEnabled(!b);
	}
	
	public void close(){
		setVisibleDialog(false);
	}
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setBounds(100,200,400,300);
		window.setTitle("TEST");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("show");
		window.add( button );
		
		final JDialogTest test = new JDialogTest(window);
		
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked( MouseEvent e){
				test.setVisibleDialog(true);
			}
		});
		
		window.setVisible(true);
		
	}
}
