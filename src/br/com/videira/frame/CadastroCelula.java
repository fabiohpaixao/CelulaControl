package br.com.videira.frame;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.com.videira.controller.CelulaController;
import br.com.videira.controller.MembroController;
import br.com.videira.model.dto.MembroDTO;
import br.com.videira.util.Util;

@SuppressWarnings("serial")
public class CadastroCelula extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCelula frame = new CadastroCelula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public CadastroCelula() throws InstantiationException, IllegalAccessException {
		init();
	}
	public void init() throws InstantiationException, IllegalAccessException {
		setTitle("Cadastro de C\u00E9lulas");
		setClosable(true);
		setBounds(100, 100, 450, 261);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Insira os dados da c\u00E9lula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalvar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnSalvar, btnCancelar});
		
		JLabel lblNome = new JLabel("Nome:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblLider = new JLabel("Lider:");
		
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		JComboBox comboBox_2 = new JComboBox();
		JComboBox comboBox_3 = new JComboBox();
		
		comboBox = populaComboBox();
		comboBox_1 = populaComboBox();
		comboBox_2 = populaComboBox();
		comboBox_3 = populaComboBox();
		
		JLabel lblAnfitrio = new JLabel("Anfitri\u00E3o:");
		
		JLabel lblNewLabel = new JLabel("Discipulador:");
		
		JLabel lblPastor = new JLabel("Pastor:");
		
		JLabel lblNewLabel_1 = new JLabel("Data In\u00EDcio:");
		
		JLabel lblDataDeMultiplicao = new JLabel("Data Multiplica\u00E7\u00E3o:");
		
		
		JLabel lblDiaDaClula = new JLabel("Dia da C\u00E9lula:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(Util.setMascara("##/##/####"));
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(Util.setMascara("##/##/####"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblNewLabel_1)
								.addComponent(lblLider)
								.addComponent(lblAnfitrio))
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox, 0, 120, Short.MAX_VALUE)
										.addComponent(comboBox_1, 0, 120, Short.MAX_VALUE)
										.addComponent(formattedTextField, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDataDeMultiplicao)
										.addComponent(lblNewLabel)
										.addComponent(lblPastor))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_3, Alignment.TRAILING, 0, 107, Short.MAX_VALUE)
										.addComponent(comboBox_2, Alignment.TRAILING, 0, 107, Short.MAX_VALUE)
										.addComponent(formattedTextField_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
								.addComponent(textField_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblDiaDaClula))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblDataDeMultiplicao)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLider)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnfitrio)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPastor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiaDaClula)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
	
	private void onClickSalvar() throws InstantiationException, IllegalAccessException, ParseException {
        CelulaController cc = new CelulaController();
        try {
        /*	if(ID > 0)
        		cc.alterar(ID, txt.getText(), txtAbreviacao.getText());
        	else
        		cc.salvar(txtNome.getText(), txtAbreviacao.getText());*/
            JOptionPane.showMessageDialog(this, "Fun��o salva com sucesso!");
            EditarFuncao.atualizaModel();
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a fun��o!\n" + e.getLocalizedMessage());
        }
    }
	
	private JComboBox populaComboBox() throws InstantiationException, IllegalAccessException{
		MembroController membroCtrl = new MembroController();
		
		List<MembroDTO> membros = new ArrayList<MembroDTO>();
		membros = membroCtrl.listaMembros();
		JComboBox<String> c = new JComboBox();
		//Remove todos os itens do model ComboBox  
		//comboBox.removeAllItems();  
  
        //O m�todo addItem adiciona objetos ao model do ComboBox  
        //Esse getNome do objeto c retorna uma String  
        for (MembroDTO membro : membros) {//T� usando aqui o for each, dispon�vel a partir da JVM 1.5  
        	c.addItem(membro.getNome());  
        }
		
        return c;
	}
}
