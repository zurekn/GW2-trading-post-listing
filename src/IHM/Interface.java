package IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Core.AutoSuggestor;
import Core.Calculate;
import Core.Data;
import Core.Search;
import Core.ShortItem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class Interface {

	private Calculate calculate;
	private Search search;
	private Data data;

	private JFrame frmGwtools;
	private JTextField poIn;
	private JTextField psIn;
	private JTextField pcIn;
	private JTextField poOut;
	private JTextField psOut;
	private JTextField pcOut;
	private JTextField number;
	private JTextField txtCost;
	private JTextField txtListingFee;
	private JTextField txtSellingFee;
	private JTextField txtProfit;
	private JTextField txtSearch;

	private JPanel panSearch;
	private JLabel lblItemName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmGwtools.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		calculate = new Calculate();
		search = new Search();
		data.initAPI();

		frmGwtools = new JFrame();
		frmGwtools.setMinimumSize(new Dimension(640, 480));
		frmGwtools.setTitle("GW2Tools");
		frmGwtools.setBounds(100, 100, 450, 300);
		frmGwtools.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane onglets = new JTabbedPane(JTabbedPane.TOP);
		frmGwtools.getContentPane().add(onglets, BorderLayout.CENTER);
		
				panSearch = new JPanel();
				onglets.addTab("Search Item", null, panSearch, null);
				panSearch.setEnabled(false);
				panSearch
						.setLayout(new MigLayout("", "[91px][528px]", "[][][][413px]"));
						panSearch.setLayout(new MigLayout("", "[1px][][][][][][][][][]", "[1px][][][][][][][][][][][][][]"));
										
												txtSearch = new JTextField();
												txtSearch.addCaretListener(new CaretListener() {
													public void caretUpdate(CaretEvent arg0) {

														AutoSuggestor autoSuggestor = new AutoSuggestor(txtSearch,
																frmGwtools, null, Color.WHITE.brighter(), Color.BLUE,
																Color.RED, 0.75f);
														search.updateName(txtSearch.getText());

													}
												});
												
														lblItemName = new JLabel("Item name (load 0)");
														panSearch.add(lblItemName, "cell 3 1,grow");
												panSearch.add(txtSearch, "flowx,cell 9 1,grow");
												txtSearch.setColumns(50);
														
																JButton btnBuy_1 = new JButton("Buy");
																btnBuy_1.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent arg0) {

																	}
																});
																panSearch.add(btnBuy_1, "cell 9 4,grow");

		JPanel panCalculate = new JPanel();
		onglets.addTab("Calculate", null, panCalculate, null);

		poIn = new JTextField();
		poIn.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!poIn.getText().isEmpty()) {
					calculate.setPoIn(Integer.parseInt(poIn.getText()));
					refresh();
				}
			}
		});
		poIn.setColumns(10);

		psIn = new JTextField();
		psIn.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!psIn.getText().isEmpty()) {
					calculate.setPsIn(Integer.parseInt(psIn.getText()));
					refresh();
				}
			}
		});
		psIn.setColumns(2);

		pcIn = new JTextField();
		pcIn.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!pcIn.getText().isEmpty()) {
					calculate.setPcIn(Integer.parseInt(pcIn.getText()));
					refresh();
				}
			}
		});
		pcIn.setColumns(2);

		poOut = new JTextField();
		poOut.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!poOut.getText().isEmpty()) {
					calculate.setPoOut(Integer.parseInt(poOut.getText()));
					refresh();
				}
			}
		});
		poOut.setColumns(10);

		psOut = new JTextField();
		psOut.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!psOut.getText().isEmpty()) {
					calculate.setPsOut(Integer.parseInt(psOut.getText()));
					refresh();
				}
			}
		});
		psOut.setColumns(2);

		pcOut = new JTextField();
		pcOut.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!pcOut.getText().isEmpty()) {
					calculate.setPcOut(Integer.parseInt(pcOut.getText()));
					refresh();
				}
			}
		});
		pcOut.setColumns(2);

		JLabel Po = new JLabel("Po");

		number = new JTextField();
		number.setText("1");
		number.setColumns(10);
		number.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (!number.getText().isEmpty()) {
					calculate.setNumber(Integer.parseInt(number.getText()));
					refresh();
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Number");

		JLabel lblBenef = new JLabel("Profit");

		JLabel lblNewLabel_1 = new JLabel("Cost");

		JLabel lblListingFee = new JLabel("Listing Fee");

		JLabel lblSellingFee = new JLabel("Selling Fee");

		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblPo = new JLabel("Po");

		JLabel lblPs = new JLabel("Ps");

		JLabel lblPs_1 = new JLabel("Ps");

		JLabel lblPc = new JLabel("Pc");

		JLabel lblPc_1 = new JLabel("Pc");

		JLabel lblProfitAfterSeling = new JLabel("Profit after seling for :");

		txtCost = new JTextField();
		txtCost.setEditable(false);
		txtCost.setEnabled(false);
		txtCost.setFocusable(false);
		txtCost.setText("Cost");
		txtCost.setColumns(10);

		txtListingFee = new JTextField();
		txtListingFee.setFocusable(false);
		txtListingFee.setEnabled(false);
		txtListingFee.setEditable(false);
		txtListingFee.setText("Listing Fee");
		txtListingFee.setColumns(10);

		txtSellingFee = new JTextField();
		txtSellingFee.setFocusable(false);
		txtSellingFee.setEnabled(false);
		txtSellingFee.setEditable(false);
		txtSellingFee.setText("Selling Fee");
		txtSellingFee.setColumns(10);

		txtProfit = new JTextField();
		txtProfit.setFocusable(false);
		txtProfit.setEditable(false);
		txtProfit.setEnabled(false);
		txtProfit.setText("Profit");
		txtProfit.setColumns(10);

		JLabel lblBuyingPrice = new JLabel("Buying price");

		JLabel lblSellingPrice = new JLabel("Selling price");
		GroupLayout gl_panCalculate = new GroupLayout(panCalculate);
		gl_panCalculate
				.setHorizontalGroup(gl_panCalculate
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panCalculate
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panCalculate
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblBuyingPrice)
														.addComponent(
																lblSellingPrice))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panCalculate
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panCalculate
																		.createSequentialGroup()
																		.addComponent(
																				lblProfitAfterSeling)
																		.addContainerGap())
														.addGroup(
																gl_panCalculate
																		.createSequentialGroup()
																		.addGroup(
																				gl_panCalculate
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panCalculate
																										.createSequentialGroup()
																										.addGroup(
																												gl_panCalculate
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																poIn,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																poOut,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_panCalculate
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																Po)
																														.addComponent(
																																lblPo))
																										.addGap(18)
																										.addGroup(
																												gl_panCalculate
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																psOut,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																psIn,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_panCalculate
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblPs)
																														.addComponent(
																																lblPs_1))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_panCalculate
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																btnBuy,
																																GroupLayout.DEFAULT_SIZE,
																																202,
																																Short.MAX_VALUE)
																														.addGroup(
																																gl_panCalculate
																																		.createSequentialGroup()
																																		.addGroup(
																																				gl_panCalculate
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								pcIn,
																																								GroupLayout.PREFERRED_SIZE,
																																								GroupLayout.DEFAULT_SIZE,
																																								GroupLayout.PREFERRED_SIZE)
																																						.addComponent(
																																								pcOut,
																																								GroupLayout.PREFERRED_SIZE,
																																								GroupLayout.DEFAULT_SIZE,
																																								GroupLayout.PREFERRED_SIZE))
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addGroup(
																																				gl_panCalculate
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								lblPc)
																																						.addComponent(
																																								lblPc_1))
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED,
																																				114,
																																				Short.MAX_VALUE)
																																		.addGroup(
																																				gl_panCalculate
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								lblSellingFee)
																																						.addComponent(
																																								lblListingFee)
																																						.addComponent(
																																								lblNewLabel_1)
																																						.addComponent(
																																								lblBenef))))
																										.addPreferredGap(
																												ComponentPlacement.RELATED))
																						.addGroup(
																								gl_panCalculate
																										.createSequentialGroup()
																										.addComponent(
																												number,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												lblNewLabel)))
																		.addGap(21)
																		.addGroup(
																				gl_panCalculate
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtCost,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtListingFee,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtSellingFee,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtProfit,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(97)))));
		gl_panCalculate
				.setVerticalGroup(gl_panCalculate
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panCalculate
										.createSequentialGroup()
										.addGap(28)
										.addGroup(
												gl_panCalculate
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(Po)
														.addComponent(
																psIn,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																pcIn,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																poIn,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1)
														.addComponent(lblPs)
														.addComponent(lblPc)
														.addComponent(
																txtCost,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblBuyingPrice))
										.addGap(21)
										.addGroup(
												gl_panCalculate
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblListingFee)
														.addComponent(
																txtListingFee,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_panCalculate
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																poOut,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																psOut,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																pcOut,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblSellingFee)
														.addComponent(lblPo)
														.addComponent(lblPs_1)
														.addComponent(lblPc_1)
														.addComponent(
																txtSellingFee,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblSellingPrice))
										.addGap(35)
										.addGroup(
												gl_panCalculate
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																number,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel)
														.addComponent(lblBenef)
														.addComponent(
																txtProfit,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(lblProfitAfterSeling)
										.addGap(7).addComponent(btnBuy)
										.addContainerGap(169, Short.MAX_VALUE)));
		panCalculate.setLayout(gl_panCalculate);
		frmGwtools.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { frmGwtools.getContentPane(), onglets,
						panCalculate, lblBenef, lblNewLabel_1, lblListingFee,
						lblSellingFee, btnBuy, number, lblNewLabel, poIn,
						poOut, Po, psIn, psOut, pcIn, pcOut }));
	}

	public void connected() {
		panSearch.setEnabled(true);

	}

	public void refreshCount(int i) {
		lblItemName.setText("Item name (load " + i + ")");
	}

	private void refresh() {
		// txtCost.setText(core.getCost());
		txtSellingFee.setText(calculate.getSellingFee());
		txtListingFee.setText(calculate.getListingFee());
		txtProfit.setText(calculate.getProfit());

	}
}
