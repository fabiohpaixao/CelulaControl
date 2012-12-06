package br.com.videira.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.com.videira.controller.FuncaoController;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CadastroFuncao extends JInternalFrame {
	private JTextField txtNome = new JTextField();
	private JTextField txtAbreviacao = new JTextField();
	private int ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncao frame = new CadastroFuncao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastroFuncao(int id, String Nome, String Abrv) throws PropertyVetoException{
		txtNome.setText(Nome);
		txtAbreviacao.setText(Abrv);
		ID=id;
		
		init();
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public CadastroFuncao() throws PropertyVetoException {
		init();
	}

	public void init() throws PropertyVetoException {
		setClosable(true);
		setTitle("Cadastro de Fun\u00E7\u00F5es");
		setBounds(100, 100, 344, 185);
		getContentPane().setLayout(new LayoutManager() {
			
			@Override
			public void removeLayoutComponent(Component comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Dimension preferredLayoutSize(Container parent) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dimension minimumLayoutSize(Container parent) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void layoutContainer(Container parent) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addLayoutComponent(String name, Component comp) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					try {
						onClickSalvar();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDefaultCloseAction();
			}
		});
		btnSalvar.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDigiteAsInformaes = new JLabel("Digite as informa\u00E7\u00F5es das fun\u00E7\u00F5es");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Insira os dados da fun\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
	//	txtNome = new JTextField();
		txtNome.setColumns(15);
		
	//	txtAbreviacao = new JTextField();
		txtAbreviacao.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		
		JLabel lblAbreviao = new JLabel("Abrevia\u00E7\u00E3o:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitulo, Alignment.TRAILING)
						.addComponent(lblAbreviao, Alignment.TRAILING))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAbreviacao, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbreviao)
						.addComponent(txtAbreviacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalvar))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
					.addGap(133)
					.addComponent(lblDigiteAsInformaes))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDigiteAsInformaes, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addGap(51))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	private void onClickSalvar() throws InstantiationException, IllegalAccessException, ParseException {
        FuncaoController cc = new FuncaoController();
        try {
        	if(ID > 0)
        		cc.alterar(ID, txtNome.getText(), txtAbreviacao.getText());
        	else
        		cc.salvar(txtNome.getText(), txtAbreviacao.getText());
            JOptionPane.showMessageDialog(this, "Função salva com sucesso!");
            EditarFuncao.atualizaModel();
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a função!\n" + e.getLocalizedMessage());
        }
    }
}
