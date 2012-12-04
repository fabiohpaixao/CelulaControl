package br.com.videira.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.videira.dao.CreateTables;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JDesktopPane desktopPane;
	private JMenuItem menuCadastroCelulas, menuCadastroFuncoes,
			menuCadastroMembros;
	private JMenuBar menuBar;
	private JMenu menuCadastro, menuRelatorio, menuServicos;
	private CadastroFuncao frameCadastroFuncao;

	@SuppressWarnings("serial")
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

				/*
				 * if(frameUm == null){ frameUm = new InternalFrameUm();
				 * frameUm.setVisible(true); desktopPane.add(frameUm); } else
				 * if(!frameUm.isVisible()){ frameUm.setVisible(true);
				 * desktopPane.add(frameUm); }
				 */
			}
		});

		menuCadastroFuncoes = new JMenuItem("Funções");
		menuCadastroFuncoes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (frameCadastroFuncao == null) {
					frameCadastroFuncao = new CadastroFuncao();
					frameCadastroFuncao.setVisible(true);
					desktopPane.add(frameCadastroFuncao);
				} else if (!frameCadastroFuncao.isVisible()) {
					frameCadastroFuncao.setVisible(true);
					desktopPane.add(frameCadastroFuncao);
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

		menuBar = new JMenuBar();
		menuCadastro = new JMenu("Cadastros");

		setContentPane(desktopPane);

		menuCadastro.add(menuCadastroCelulas);
		menuCadastro.add(menuCadastroFuncoes);
		menuCadastro.add(menuCadastroMembros);

		menuBar.add(menuCadastro);

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
