package view;

import controller.Register;
import db.Store;
import model.*;

import javax.swing.*;
import java.awt.*;
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

public class JFrameEnterItems extends javax.swing.JFrame implements IObserver, IDisplaySale 
{
	private static final long serialVersionUID = 2L;
	private JDesktopPane jDesktopPane1;
	private JTextField jTextFieldItemId;
	private JLabel jLabelAmount;
	private JLabel jLabelItemId;
	private JButton jButtonEndSale;
	private JButton jButtonEnter;
	private JTextField jTextFieldAmount;
	private JLabel jLabelProdHoev;
	private JLabel jLabelProdEenhPr;
	private JLabel jLabelProdTotal;
	private JLabel jLabelSubTotal;
	private JTextField jTextFieldSubTotal;
	private JTextField jTextFieldProdTotal;
	private JTextField jTextFieldProdEenhPr;
	private JTextField jTextFieldProdHoev;
	private JTextField jTextFieldProdBeschr;
	private JLabel jLabelProdBeschr;
	private JTextField jTextFieldProdNr;
	private Register testregister;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			private Register testregister;

			public void run() {
				JFrameEnterItems inst = new JFrameEnterItems(testregister);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public JFrameEnterItems (ISubject saleData){
		super();
		initGUI();
		this.testregister = (Register)saleData;
		saleData.registerObserver(this);
	}


	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jDesktopPane1 = new JDesktopPane();
				getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
				jDesktopPane1.setPreferredSize(new java.awt.Dimension(505, 244));
				{
					jTextFieldItemId = new JTextField();
					jDesktopPane1.add(jTextFieldItemId);
					jTextFieldItemId.setBounds(122, 60, 90, 22);
				}
				{
					jTextFieldAmount = new JTextField();
					jDesktopPane1.add(jTextFieldAmount);
					jTextFieldAmount.setBounds(128, 110, 50, 22);
					jTextFieldAmount.setText("1");
				}
				{
					jButtonEnter = new JButton();
					jDesktopPane1.add(jButtonEnter);
					jButtonEnter.setText("Enter");
					jButtonEnter.setBounds(67, 158, 96, 32);
					jButtonEnter.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jButtonEnterMouseClicked(evt);
						}
					});
				}
				{
					jButtonEndSale = new JButton();
					jDesktopPane1.add(jButtonEndSale);
					jButtonEndSale.setText("End Sale");
					jButtonEndSale.setBounds(67, 201, 96, 31);
					jButtonEndSale.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jButtonEndSaleMouseClicked(evt);
						}
					});
				}
				{
					jLabelItemId = new JLabel();
					jDesktopPane1.add(jLabelItemId);
					jLabelItemId.setText("Item ID");
					jLabelItemId.setBounds(43, 63, 61, 16);
					jLabelItemId.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				{
					jLabelAmount = new JLabel();
					jDesktopPane1.add(jLabelAmount);
					jLabelAmount.setText("Amount");
					jLabelAmount.setBounds(55, 113, 61, 16);
					jLabelAmount.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				{
					jPanelstatus = new JPanel();
					GridLayout jPanelstatusLayout = new GridLayout(6, 2);
					jPanelstatusLayout.setColumns(2);
					jPanelstatusLayout.setRows(6);
					jPanelstatusLayout.setHgap(5);
					jPanelstatusLayout.setVgap(5);
					jDesktopPane1.add(jPanelstatus);
					jPanelstatus.setLayout(jPanelstatusLayout);
					jPanelstatus.setBounds(234, 60, 301, 172);
					{
						jLabelProdNr = new JLabel();
						jPanelstatus.add(jLabelProdNr);
						jLabelProdNr.setText("Product Nummer:");
					}
					{
						jTextFieldProdNr = new JTextField();
						jPanelstatus.add(jTextFieldProdNr);
						jTextFieldProdNr.setText("0");
						jTextFieldProdNr.setEditable(false);
					}
					{
						jLabelProdBeschr = new JLabel();
						jPanelstatus.add(jLabelProdBeschr);
						jLabelProdBeschr.setText("Product Beschrijving:");
					}
					{
						jTextFieldProdBeschr = new JTextField();
						jPanelstatus.add(jTextFieldProdBeschr);
						jTextFieldProdBeschr.setText("onbekend");
						jTextFieldProdBeschr.setEditable(false);
					}
					{
						jLabelProdHoev = new JLabel();
						jPanelstatus.add(jLabelProdHoev);
						jLabelProdHoev.setText("Product Hoeveelheid:");
					}
					{
						jTextFieldProdHoev = new JTextField();
						jPanelstatus.add(jTextFieldProdHoev);
						jTextFieldProdHoev.setText("0");
						jTextFieldProdHoev.setEditable(false);
					}
					{
						jLabelProdEenhPr = new JLabel();
						jPanelstatus.add(jLabelProdEenhPr);
						jLabelProdEenhPr.setText("Product Eenheidsprijs:");
					}
					{
						jTextFieldProdEenhPr = new JTextField();
						jPanelstatus.add(jTextFieldProdEenhPr);
						jTextFieldProdEenhPr.setText("0");
						jTextFieldProdEenhPr.setEditable(false);
					}
					{
						jLabelProdTotal = new JLabel();
						jPanelstatus.add(jLabelProdTotal);
						jLabelProdTotal.setText("Totaal voor dit Product:");
					}
					{
						jTextFieldProdTotal = new JTextField();
						jPanelstatus.add(jTextFieldProdTotal);
						jTextFieldProdTotal.setText("0");
						jTextFieldProdTotal.setEditable(false);
					}
					{
						jLabelSubTotal = new JLabel();
						jPanelstatus.add(jLabelSubTotal);
						jLabelSubTotal.setText("Subtotaal Aankoop:");
					}
					{
						jTextFieldSubTotal = new JTextField();
						jPanelstatus.add(jTextFieldSubTotal);
						jTextFieldSubTotal.setText("0");
						jTextFieldSubTotal.setEditable(false);
					}
				}
			}
			pack();
			this.setSize(563, 280);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int itemId=1;
	private double amount=1.00;
	private JLabel jLabelProdNr;
	private JPanel jPanelstatus;

	private void jButtonEnterMouseClicked(MouseEvent evt) {
		
		System.out.println("jButtonEnter.mouseClicked, event="+evt);
		this.itemId = Integer.parseInt(jTextFieldItemId.getText());
		jTextFieldItemId.setText("");
		this.amount = Double.parseDouble(jTextFieldAmount.getText());
		jTextFieldAmount.setText("1");
		scanProductInRegister(itemId, amount);
	}
	

	private void jButtonEndSaleMouseClicked(MouseEvent evt) {
		
		System.out.println("jButtonEndSale.mouseClicked, event="+evt);
		itemId = 0;
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void scanProductInRegister (int ID, double amount){
		
		try {
			testregister.scanProdukt(ID, amount);

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "product bestaat niet" + e.getMessage());
		}

	}

	@Override
	public void update(int itemId, double amount, Sale sale) {
		Product product = Store.getProductCatalog().getProductCatalog().get(itemId);
		jTextFieldProdNr.setText(String.format("%d", itemId));
		jTextFieldProdBeschr.setText(product.getDescription());
		jTextFieldProdHoev.setText(String.format("%.2f", amount));
		jTextFieldProdEenhPr.setText(String.format("%.2f", product.getPrice()));
		jTextFieldProdTotal.setText(String.format("%.2f", (amount * product.getPrice())));
		jTextFieldSubTotal.setText(String.format("%.2f", (sale.getTotalCost() + (amount * product.getPrice()))));
	}

	@Override
	public void displaySale() 
	{}
	
}
