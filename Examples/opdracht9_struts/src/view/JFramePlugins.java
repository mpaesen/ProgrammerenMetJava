package view;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import controller.Register;
import model.pricing.ISalePricingStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Rudy Nelen & Erwin Aernouts
 */

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
public class JFramePlugins extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox jComboBox1;
	private JPanel jPanel1;
	private String[] strategies;
	private JLabel jLabel1SelectionTitle;
	private JButton jButton1OK;
	
	private Register testRegister;
	private JTextField jTextField1;

	/**
	* Auto-generated main method to display this JFrame
	*/

	
	public JFramePlugins(String[] strat, Register testRegister) 
	{
		super();
		this.strategies = strat;
		this.testRegister = testRegister;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.NORTH);
				AnchorLayout jPanel1Layout = new AnchorLayout();
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(384, 237));
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1, new AnchorConstraint(424, 922, 554, 92, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTextField1.setText("uw keuze");
					jTextField1.setPreferredSize(new java.awt.Dimension(318, 31));
				}
				{
					jLabel1SelectionTitle = new JLabel();
					jPanel1.add(jLabel1SelectionTitle, new AnchorConstraint(289, 361, 352, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1SelectionTitle.setText("Selected Strategy :");
					jLabel1SelectionTitle.setPreferredSize(new java.awt.Dimension(115, 15));
				}
				{
					jButton1OK = new JButton();
					jPanel1.add(jButton1OK, new AnchorConstraint(694, 562, 837, 392, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton1OK.setText("OK");
					jButton1OK.setPreferredSize(new java.awt.Dimension(65, 34));
					jButton1OK.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jButton1OKMouseClicked(evt);
						}
					});
				}
				{
					ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(this.strategies);

					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1, new AnchorConstraint(65, 922, 213, 92, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setPreferredSize(new java.awt.Dimension(318, 35));
					jComboBox1.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							jComboBox1ItemStateChanged(evt);
						}
					});
				}
			}
			pack();
			this.setSize(399, 274);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1OKMouseClicked(MouseEvent evt) 
	{
		System.out.println("jButton1OK.mouseClicked, event="+evt);
		String strategy = (String) jComboBox1.getSelectedItem();
		for (ISalePricingStrategy discount : Register.getStore().getDiscountStrategies())
		{
			if (strategy == discount.getClass().getName())
			{
				testRegister.setDiscountStrategy(discount);
				testRegister.setDiscountStrategySet(true);
			}
		}
	}
	
	
	private void jComboBox1ItemStateChanged(ItemEvent evt) {
		jTextField1.setText(jComboBox1.getSelectedItem().toString());

	}
	


}
