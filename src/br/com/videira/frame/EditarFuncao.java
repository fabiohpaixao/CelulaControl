package br.com.videira.frame;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.com.videira.controller.FuncaoController;
import br.com.videira.model.dto.FuncaoDTO;
import br.com.videira.model.table.TableModelFuncoes;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class EditarFuncao extends JInternalFrame {
	private JTextField textField;
	private CadastroFuncao frameCadastroFuncao;
	private static TableModelFuncoes tableModel = new TableModelFuncoes();
	private static FuncaoController funcoes = new FuncaoController();
	private static JTable table;	
	private static JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarFuncao frame = new EditarFuncao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private static TableModelFuncoes getTableModel() throws InstantiationException, IllegalAccessException {

			tableModel = new TableModelFuncoes(funcoes.listaFuncaos());
			return tableModel;
	}
	
	public static void atualizaModel() throws InstantiationException, IllegalAccessException{
		table.setModel(getTableModel());
		scrollPane.setViewportView(table);
	}
	
	/**
	 * Create the frame.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public EditarFuncao() throws InstantiationException, IllegalAccessException {
		setTitle("Cadastro de Fun\u00E7\u00F5es");
		setClosable(true);
		setBounds(100, 100, 414, 343);
		
		JButton btnOk = new JButton("Ok");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doDefaultCloseAction();
			}
		});
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (frameCadastroFuncao == null) {
					try {
						frameCadastroFuncao = new CadastroFuncao();
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					frameCadastroFuncao.setVisible(true);
					Main.desktopPane.add(frameCadastroFuncao);
					frameCadastroFuncao.requestFocus();
			        try {
			        	frameCadastroFuncao.setSelected(true);
			        } catch (PropertyVetoException ex) {
			        	ex.printStackTrace();
			        }
			        
				} else if (!frameCadastroFuncao.isVisible()) {
					frameCadastroFuncao.setVisible(true);
					
					Main.desktopPane.add(frameCadastroFuncao);
					frameCadastroFuncao.requestFocus();
			        try {
			        	frameCadastroFuncao.setSelected(true);
			        } catch (PropertyVetoException ex) {
			        	ex.printStackTrace();
			        }
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (frameCadastroFuncao == null) {
					try {
						int linha = table.getSelectedRow();
					//	table.getValueAt(linha, 0)
						frameCadastroFuncao = new CadastroFuncao((int)table.getValueAt(linha, 0), (String)table.getValueAt(linha, 1), (String)table.getValueAt(linha, 2));
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					frameCadastroFuncao.setVisible(true);
					Main.desktopPane.add(frameCadastroFuncao);
					frameCadastroFuncao.requestFocus();
			        try {
			        	frameCadastroFuncao.setSelected(true);
			        } catch (PropertyVetoException ex) {
			        	ex.printStackTrace();
			        }
			        
				} else if (!frameCadastroFuncao.isVisible()) {
					frameCadastroFuncao.setVisible(true);
					
					Main.desktopPane.add(frameCadastroFuncao);
					frameCadastroFuncao.requestFocus();
			        try {
			        	frameCadastroFuncao.setSelected(true);
			        } catch (PropertyVetoException ex) {
			        	ex.printStackTrace();
			        }
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		
		JLabel lblCadastroDeFunes = new JLabel("Cadastro de Fun\u00E7\u00F5es");
		lblCadastroDeFunes.setFont(new Font("Tahoma", Font.BOLD, 17));

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pesquise as fun\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCadastroDeFunes))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCancelar))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))))
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblCadastroDeFunes)
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancelar))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JLabel lblTituloabreviao = new JLabel("Titulo");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(4)
					.addComponent(lblTituloabreviao)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar)
						.addComponent(lblTituloabreviao)))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.setModel(getTableModel());
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
