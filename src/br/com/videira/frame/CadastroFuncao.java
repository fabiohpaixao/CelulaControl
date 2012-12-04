package br.com.videira.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.videira.controller.FuncaoController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class CadastroFuncao extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtAbreviacao;

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

	/**
	 * Create the frame.
	 */
	public CadastroFuncao() {
		setClosable(true);
		setTitle("Cadastro de Fun\u00E7\u00F5es");
		setBounds(100, 100, 302, 195);
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
		
		JLabel lblAbreviao = new JLabel("Abrevia\u00E7\u00E3o");
		
		txtAbreviacao = new JTextField();
		txtAbreviacao.setColumns(10);
		btnSalvar.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		
		txtNome = new JTextField();
		txtNome.setColumns(15);
		
		JLabel lblDigiteAsInformaes = new JLabel("Digite as informa\u00E7\u00F5es das fun\u00E7\u00F5es");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addComponent(lblTitulo))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblAbreviao)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAbreviacao, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCancelar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSalvar))
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblDigiteAsInformaes)))
					.addGap(183))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblDigiteAsInformaes, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbreviao)
						.addComponent(txtAbreviacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	
	private void onClickSalvar() throws InstantiationException, IllegalAccessException, ParseException {
        FuncaoController cc = new FuncaoController();
        try {
            cc.salvar(txtNome.getText(), txtAbreviacao.getText());
            JOptionPane.showMessageDialog(this, "Função salva com sucesso!");
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a função!\n" + e.getLocalizedMessage());
        }
    }

}
