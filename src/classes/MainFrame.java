package classes;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public final class MainFrame extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	private final DecimalFormat df = new DecimalFormat(",###.###");

	//Panel
	private JPanel contentPane;
	
	//Text Fields
	private JTextField tf_Input, tf_Output;
	
	//Buttons
	private JButton btnConvert;
	
	//Combo boxes
	private JComboBox<Object> comboBoxFrom, comboBoxTo, comboBoxUnidades;
	
	//Images
	private Image auxImage;
	private Image auxImageMod;
	private ImageIcon iconImage = null;
	private ImageIcon Img_1;
	
	//Labels
	private JLabel lblSymbol;
	private JLabel lblImg_1;
	private JLabel lbl_2;

	//Units arraysLists
	private final ArrayList<String> moneyUnits = new ArrayList<String>(Arrays.asList("ARS","USD","EUR","JPY","GBP","KRW"));
	private final ArrayList<String> tempUnits = new ArrayList<String>(Arrays.asList("Kelvin","Celsius","Fahrenheit"));
	private  final ArrayList<String> longUnits = new ArrayList<String>(Arrays.asList("Centímetro","Metro","Kilómetro","Milla","Milla náutica", "Yarda","Pulgada","Pie"));

	/*****************************************************************************************************
	 * Create the frame.
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		setTitle("Simple Unit Converter");
		iconImage = new ImageIcon((getClass().getResource("/LogoIcon.jpg")));
		setIconImage(iconImage.getImage());
		
		setResizable(false);
		
		initialize();

	}
	
	/*****************************************************************************************************
	 * initialize components
	 */
	public void initialize() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnConvert = new JButton("Convertir");
		btnConvert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvert.setBounds(294, 161, 180, 67);
	
		JLabel lbl_Tipo = new JLabel("Tipo de conversión:");
		lbl_Tipo.setBounds(149, 11, 180, 33);
		lbl_Tipo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Tipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		String tipos[] = {"Moneda","Temperatura","Longitud"}; 
		comboBoxUnidades = new JComboBox<Object>(tipos);
		comboBoxUnidades.setSelectedIndex(-1);
		comboBoxUnidades.setBounds(149, 55, 180, 20);
		
		tf_Input = new JTextField();
		tf_Input.setEnabled(false);
		tf_Input.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Input.setBounds(10, 161, 180, 23);
		tf_Input.setColumns(10);
		
		tf_Output = new JTextField();
		tf_Output.setEditable(false);
		tf_Output.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		tf_Output.setDisabledTextColor(new Color(0, 0, 0));
		tf_Output.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Output.setBounds(10, 205, 180, 23);
		tf_Output.setColumns(10);
		
		lblSymbol = new JLabel("");
		lblSymbol.setFocusable(false);
		lblSymbol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSymbol.setHorizontalAlignment(SwingConstants.CENTER);
		lblSymbol.setBounds(188, 205, 29, 23);
		
		comboBoxFrom = new JComboBox<Object>();
		comboBoxFrom.setBounds(10, 107, 180, 22);
		
		JLabel lbl_1 = new JLabel("→");
		lbl_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_1.setBounds(228, 108, 20, 20);
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_2 = new JLabel("Max digits: 12 + decimals");
		lbl_2.setForeground(SystemColor.textInactiveText);
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl_2.setBounds(10, 140, 122, 20);
		lbl_2.setVisible(false);
		
		comboBoxTo = new JComboBox<Object>();
		comboBoxTo.setBounds(294, 107, 180, 22);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(10, 86, 463, 10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(10, 140, 463, 10);
		
		Img_1 = new ImageIcon(getClass().getResource("/info-logo.png"));
		auxImage = Img_1.getImage();
		auxImageMod = auxImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		Img_1 = new ImageIcon(auxImageMod);
		
		lblImg_1 = new JLabel(Img_1);
		lblImg_1.setVisible(false);
		lblImg_1.setToolTipText("<html>" + "Last currencies values update: March 03 2023"
				+ "<br>" + "Provided by: https://www.oanda.com" + "<html>");
		lblImg_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ToolTipManager.sharedInstance().setInitialDelay(0);
		lblImg_1.setLocation(10, 10);
		lblImg_1.setSize(20, 20);
		
		//adding objects
		contentPane.setLayout(null);
		contentPane.add(btnConvert);
		contentPane.add(lbl_Tipo);
		contentPane.add(comboBoxUnidades);
		contentPane.add(tf_Input);
		contentPane.add(tf_Output);
		contentPane.add(comboBoxFrom);
		contentPane.add(lbl_1);
		contentPane.add(comboBoxTo);
		contentPane.add(verticalStrut);
		contentPane.add(verticalStrut_1);
		contentPane.add(lblSymbol);
		contentPane.add(lblImg_1);
		contentPane.add(lbl_2);
		
		//adding event listeners
		btnConvert.addActionListener(this);
		comboBoxUnidades.addItemListener(this);
		
	}

	/*****************************************************************************************************
	 * actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * if input field is not empty creates the pattern
		 * */
		if (btnConvert == e.getSource() && tf_Input.getText().isEmpty() == false) {
			Pattern pattern = Pattern.compile("^[+-]?(\\d{1,12})(\\.\\d+)?$", Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(tf_Input.getText());
			if (matcher.find()) {	
				/*
				 * creates class object based on unit types 
				 * */
				String a = comboBoxFrom.getSelectedItem().toString();
				Double b = Double.parseDouble(tf_Input.getText());
				switch (comboBoxUnidades.getSelectedItem().toString()) {
				
					/*************************Temperatura*************************/
					case ("Temperatura") : {
						TempUnits tempUnits = new TempUnits(a , b, null);
						/*
						 * convert to different units of temperature
						 * */
						switch (comboBoxTo.getSelectedItem().toString()) {
							case ("Celsius") : {
								tempUnits.toCelsius();
								break;
							}
							case ("Kelvin"):{
								tempUnits.toKelvin();
								break;
							}
							case ("Fahrenheit"):{
								tempUnits.toFahrenheit();
								break;
							}
						}
						tf_Output.setText(df.format(tempUnits.getValue()));
						lblSymbol.setText(tempUnits.getSymbol());
						break;
					}
					
					/*************************Longitud*************************/
					case ("Longitud"):{
						LenUnits lenUnits = new LenUnits(a, b, null);
						/*
						 * convert to different units of length
						 * */
						switch (comboBoxTo.getSelectedItem().toString()) {
							case ("Centímetro") : {
								lenUnits.toCentimetro();
								break;
							}
							case ("Metro"):{
								lenUnits.toMetro();
								break;
							}
							case ("Kilómetro"):{
								lenUnits.toKilometro();
								break;
							}
							case ("Milla"):{
								lenUnits.toMilla();
								break;
							}
							case ("Milla náutica"):{
								lenUnits.toMillaNautica();
								break;
							}
							case ("Yarda"):{
								lenUnits.toYarda();
								break;
							}
							case ("Pulgada"):{
								lenUnits.toPulgada();;
								break;
							}
							case ("Pie"):{
								lenUnits.toPie();
								break;
							}
						}
						
						tf_Output.setText(df.format(lenUnits.getValue()));
						lblSymbol.setText(lenUnits.getSymbol());
						break;
					}
					/*************************Moneda*************************/
					case ("Moneda"):{
						MoneyUnits moneyUnits = new MoneyUnits(a, b, null);
						/*
						 * convert to different currencies
						 * */
						switch (comboBoxTo.getSelectedItem().toString()) {
							case ("ARS"):{
								moneyUnits.toARS();
								break;
							}
							case ("USD"):{
								moneyUnits.toUSD();
								break;
							}
							case ("EUR"):{
								moneyUnits.toEUR();
								break;
							}
							case ("JPY"):{
								moneyUnits.toJPY();
								break;
							}
							case ("GBP"):{
								moneyUnits.toGBP();
								break;
							}
							case ("KRW"):{
								moneyUnits.toKRW();
								break;
							}
						}
						tf_Output.setText(df.format(moneyUnits.getValue()));
						lblSymbol.setText(moneyUnits.getSymbol());
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid value");
			}
		}
	}
	
	/*****************************************************************************************************
	 * itemStateChanged
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			lbl_2.setVisible(true);
			/*
			 *  switch between available units base on the type selected
			 */
			switch (comboBoxUnidades.getSelectedItem().toString()) {
				case ("Moneda") : {
					lblImg_1.setVisible(true);
					comboBoxFrom.removeAllItems();
					comboBoxTo.removeAllItems();
					for (String u : moneyUnits) {
						comboBoxFrom.addItem(u);
						comboBoxTo.addItem(u);
					}
					break;
				}
				case ("Temperatura") : {
					lblImg_1.setVisible(false);
					comboBoxFrom.removeAllItems();
					comboBoxTo.removeAllItems();
					for (String u : tempUnits) {
						comboBoxFrom.addItem(u);
						comboBoxTo.addItem(u);
					}
					break;
				}
				
				case ("Longitud") : {
					lblImg_1.setVisible(false);
					comboBoxFrom.removeAllItems();
					comboBoxTo.removeAllItems();
					for (String u : longUnits) {
						comboBoxFrom.addItem(u);
						comboBoxTo.addItem(u);
					}
					break;
				}
			}
			
			/*
			 * enable input field
			 */
			tf_Input.setEnabled(true);
		}
	}
}
