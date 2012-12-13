package br.com.videira.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.videira.database.CreateTables;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public static JDesktopPane desktopPane;
	private JMenuItem menuCadastroCelulas, menuCadastroFuncoes,
			menuCadastroMembros, menuServicosFrequenciaCulto, menuServicosFrequenciaCelula, menuRelatorioFrequencia;
	private JMenuBar menuBar;
	private JMenu menuCadastro, menuRelatorio, menuServicos;
	//private CadastroFuncao frameCadastroFuncao;
	private EditarFuncao frameEditarFuncao;
	private EditarCelula frameEditarCelula;

	public Main() throws InstantiationException, IllegalAccessException {

		super("Controle de Celulas");
		
		new CreateTables().createTableCelula();
		new CreateTables().createTableCelulaLiderTreinee();
		new CreateTables().createTableFuncao();
		new CreateTables().createTableMembro();

		int inset = 50;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);

		desktopPane = new JDesktopPane();

		// cor do fundo do desktop
		desktopPane.setBackground(Color.WHITE);

		menuCadastroCelulas = new JMenuItem("Células");
		menuCadastroCelulas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				if (frameEditarCelula == null) {
					frameEditarCelula = new EditarCelula();
					frameEditarCelula.setVisible(true);
					desktopPane.add(frameEditarCelula);
					frameEditarCelula.requestFocus();
					try {
						frameEditarCelula.setSelected(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (!frameEditarCelula.isVisible()) {
					frameEditarCelula.setVisible(true);
					desktopPane.add(frameEditarCelula);
					frameEditarCelula.requestFocus();
					try {
						frameEditarCelula.setSelected(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		menuCadastroFuncoes = new JMenuItem("Funções");
		menuCadastroFuncoes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (frameEditarFuncao == null) {
					try {
						frameEditarFuncao = new EditarFuncao();
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frameEditarFuncao.setVisible(true);
					desktopPane.add(frameEditarFuncao);
					frameEditarFuncao.requestFocus();
					try {
						frameEditarFuncao.setSelected(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (!frameEditarFuncao.isVisible()) {
					frameEditarFuncao.setVisible(true);
					desktopPane.add(frameEditarFuncao);
					frameEditarFuncao.requestFocus();
					try {
						frameEditarFuncao.setSelected(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		menuCadastroMembros = new JMenuItem("Membros");
		menuCadastroMembros.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				/*
				 * if(frameDois == null){ frameDois = new InternalFrameDois();
				 * frameDois.setVisible(true); desktopPane.add(frameDois); }
				 * else if(!frameDois.isVisible()){ frameDois.setVisible(true);
				 * desktopPane.add(frameDois); }
				 */
			}
		});
		
		menuServicosFrequenciaCulto = new JMenuItem("Frequencia Culto");
		menuServicosFrequenciaCulto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				/*
				 * if(frameDois == null){ frameDois = new InternalFrameDois();
				 * frameDois.setVisible(true); desktopPane.add(frameDois); }
				 * else if(!frameDois.isVisible()){ frameDois.setVisible(true);
				 * desktopPane.add(frameDois); }
				 */
			}
		});
		
		menuServicosFrequenciaCelula = new JMenuItem("Frequencia Célula");
		menuServicosFrequenciaCelula.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				/*
				 * if(frameDois == null){ frameDois = new InternalFrameDois();
				 * frameDois.setVisible(true); desktopPane.add(frameDois); }
				 * else if(!frameDois.isVisible()){ frameDois.setVisible(true);
				 * desktopPane.add(frameDois); }
				 */
			}
		});
		
		menuRelatorioFrequencia = new JMenuItem("Frequencia Mensal");
		menuRelatorioFrequencia.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				/*
				 * if(frameDois == null){ frameDois = new InternalFrameDois();
				 * frameDois.setVisible(true); desktopPane.add(frameDois); }
				 * else if(!frameDois.isVisible()){ frameDois.setVisible(true);
				 * desktopPane.add(frameDois); }
				 */
			}
		});

		menuBar = new JMenuBar();
		menuCadastro = new JMenu("Cadastros");

		setContentPane(desktopPane);

		menuCadastro.add(menuCadastroCelulas);
		menuCadastro.add(menuCadastroFuncoes);
		menuCadastro.add(menuCadastroMembros);
		
//		menuServicos.add(menuServicosFrequenciaCulto);
//		menuServicos.add(menuServicosFrequenciaCelula);
		
//		menuRelatorio.add(menuRelatorioFrequencia);

		menuBar.add(menuCadastro);
	//	menuBar.add(menuServicos);
	//	menuBar.add(menuRelatorio);

		setJMenuBar(menuBar);

		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {

		try {
			Main m = new Main();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
