package view;

import controller.Register;
import db.FileIO;
import db.Store;
import model.service.ServicesFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JFrameEnterServices extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JButton jButtonCancel;
	private JLabel jLabelBusinessRules;
	private JLabel jLabelAccounting;
	private JButton jButtonEnter;
	private JComboBox jComboBoxBusiness;
	private JComboBox jComboBoxAccounting;
	private JLabel jLabelTitle;
	private Register testRegister;
	private String[] accountingAdapters;
	private String[] businessRules;
	
	/**
	* Auto-generated main method to display this JFrame
	*/

	public JFrameEnterServices(Register reg, String[] accounts, String[] business) 
	{
		super();
		FileIO.loadServices();
		this.testRegister = reg;
		this.accountingAdapters = accounts;
		this.businessRules = business;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setPreferredSize(new java.awt.Dimension(384, 166));
				{
					jLabelTitle = new JLabel();
					GroupLayout jLabelTitleLayout = new GroupLayout((JComponent)jLabelTitle);
					jLabelTitle.setLayout(jLabelTitleLayout);
					jPanel1.add(jLabelTitle);
					jLabelTitle.setText("\tSelect the Services to be used:");
					jLabelTitle.setPreferredSize(new java.awt.Dimension(320, 16));
					jLabelTitleLayout.setVerticalGroup(jLabelTitleLayout.createParallelGroup());
					jLabelTitleLayout.setHorizontalGroup(jLabelTitleLayout.createParallelGroup());
				}
				{
					jLabelAccounting = new JLabel();
					jPanel1.add(jLabelAccounting);
					jLabelAccounting.setText("Accounting Adapter:");
				}
				{
					ComboBoxModel jComboBoxAccountingModel = 
						new DefaultComboBoxModel(this.accountingAdapters);
					jComboBoxAccounting = new JComboBox();
					jPanel1.add(jComboBoxAccounting);
					jComboBoxAccounting.setModel(jComboBoxAccountingModel);
					jComboBoxAccounting.setPreferredSize(new java.awt.Dimension(290, 30));
					jComboBoxAccounting.setSize(290, 30);
				}
				{
					jLabelBusinessRules = new JLabel();
					jPanel1.add(jLabelBusinessRules);
					jLabelBusinessRules.setText("Business Rules:");
					jLabelBusinessRules.setPreferredSize(new java.awt.Dimension(107, 16));
					jLabelBusinessRules.setSize(10, 16);
				}
				{
					ComboBoxModel jComboBoxBusinessModel = 
						new DefaultComboBoxModel(this.businessRules);
					jComboBoxBusiness = new JComboBox();
					jPanel1.add(jComboBoxBusiness);
					jComboBoxBusiness.setModel(jComboBoxBusinessModel);
					jComboBoxBusiness.setPreferredSize(new java.awt.Dimension(290, 30));
					jComboBoxBusiness.setSize(290, 30);
				}
				{
					jButtonCancel = new JButton();
					jPanel1.add(jButtonCancel);
					jButtonCancel.setText("Cancel");
					jButtonCancel.setPreferredSize(new java.awt.Dimension(79, 31));
					jButtonCancel.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jButtonCancelMouseClicked(evt);
						}
					});
				}
				{
					jButtonEnter = new JButton();
					jPanel1.add(jButtonEnter);
					jButtonEnter.setText("Enter");
					jButtonEnter.setPreferredSize(new java.awt.Dimension(92, 31));
					jButtonEnter.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jButtonEnterMouseClicked(evt);
						}
					});
				}
			}
			pack();
			this.setSize(443, 190);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButtonEnterMouseClicked(MouseEvent evt) 
	{
		System.out.println("jButtonEnter.mouseClicked, event="+evt);
		
		String value1 = (String)jComboBoxAccounting.getSelectedItem();
		Register.getStore().getServiceProperties().setProperty("a1", value1);
		String value2 = (String)jComboBoxBusiness.getSelectedItem();
		Register.getStore().getServiceProperties().setProperty("b1", value2);
		
		FileIO.writeServices();
		Store.setServicesFactory(ServicesFactory.getServicesFactory());
		testRegister.setServicesSet(true);
	}
	
	private void jButtonCancelMouseClicked(MouseEvent evt) 
	{
		System.out.println("jButtonCancel.mouseClicked, event="+evt);
		
		if(!(new File("\\temp\\services.properties")).exists())
		{
			FileIO.writeServices();
			Store.setServicesFactory(ServicesFactory.getServicesFactory());
		}
		testRegister.setServicesSet(true);
	}

}
