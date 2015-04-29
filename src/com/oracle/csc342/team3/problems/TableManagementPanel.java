package com.oracle.csc342.team3.problems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TableManagementPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_product_productID;
	private JTextField txt_product_productLineID;
	private JTextField txt_product_productDescription;
	private JTextField txt_product_productFinish;
	private JTextField txt_product_productStandardPrice;
	
	private JButton btnGo;
	private JButton btnSearch;

	JComboBox cmb_OperationChoice;
	JComboBox cmb_TableChoice;
	private JLabel lblSelectYourTable;
	private JLabel lblSelectYourOperation;
	
	JLabel lblProductId;
	JLabel lblProductLineId;
	JLabel lblProductDescription;
	JLabel lblProductFinish;
	JLabel lblProductStandardPrice;
	private JTextField txt_vendor_vendorID;
	
	private JTextArea resultsArea;
	private JTextField txt_vendor_vendorName;
	private JTextField txt_vendor_street;
	private JTextField txt_vendor_city;
	private JTextField txt_vendor_state;
	private JTextField txt_vendor_postalCode;
	private JTextField txt_vendor_fax;
	private JTextField txt_vendor_phone;
	private JTextField txt_vendor_contact;
	private JTextField txt_vendor_taxID;
	private JLabel lblVendorId;
	private JLabel lblVendorName;
	private JLabel lblStreet;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblPostalCode;
	private JLabel lblFax;
	private JLabel lblPhone;
	private JLabel lblContact;
	private JLabel lblTaxId;
	private JTextField txt_person_personID;
	private JTextField txt_person_firstName;
	private JTextField txt_person_lastName;
	private JTextField txt_person_street;
	private JTextField txt_person_city;
	private JTextField txt_person_state;
	private JTextField txt_person_postalCode;
	private JTextField txt_person_phone;
	private JTextField txt_person_fax;
	private JLabel lblPersonId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblStreet_1;
	private JLabel lblCity_1;
	private JLabel lblState_1;
	private JLabel lblPostalCode_1;
	private JLabel lblPhone_1;
	private JLabel lblFax_1;
	private JLabel lblBirthDate;
	private JTextField txt_person_birthDate;
	
	/**
	 * Create the application.
	 */
	public TableManagementPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(null);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(363, 174, 99, 23);
		this.add(btnSearch);
		
		String[] operationNames = {"Create", "View", "Update", "Delete"};
		cmb_OperationChoice = new JComboBox(operationNames);
		cmb_OperationChoice.setBounds(435, 47, 99, 20);
		this.add(cmb_OperationChoice);
		
		String[] tableNames = {"Person", "Product", "Vendor"};
		cmb_TableChoice = new JComboBox(tableNames);
		cmb_TableChoice.setBounds(291, 47, 99, 20);
		this.add(cmb_TableChoice);
		cmb_TableChoice.addActionListener(this);
		
		btnGo = new JButton("GO!");
		btnGo.setBounds(377, 98, 65, 23);
		btnGo.addActionListener(this);
		this.add(btnGo);
		
		resultsArea = new JTextArea(30,40);
		resultsArea.setBounds(10,379,555,124);
		this.add(resultsArea);
		
		txt_product_productID = new JTextField();
		txt_product_productID.setBounds(133, 34, 70, 20);
		add(txt_product_productID);
		txt_product_productID.setColumns(10);
		
		txt_product_productLineID = new JTextField();
		txt_product_productLineID.setColumns(10);
		txt_product_productLineID.setBounds(133, 77, 70, 20);
		add(txt_product_productLineID);
		
		txt_product_productDescription = new JTextField();
		txt_product_productDescription.setColumns(10);
		txt_product_productDescription.setBounds(133, 125, 70, 20);
		add(txt_product_productDescription);
		
		txt_product_productFinish = new JTextField();
		txt_product_productFinish.setColumns(10);
		txt_product_productFinish.setBounds(133, 174, 70, 20);
		add(txt_product_productFinish);
		
		txt_product_productStandardPrice = new JTextField();
		txt_product_productStandardPrice.setColumns(10);
		txt_product_productStandardPrice.setBounds(133, 223, 70, 20);
		add(txt_product_productStandardPrice);
		
		lblProductId = new JLabel("Product ID:");
		lblProductId.setBounds(10, 37, 91, 14);
		add(lblProductId);
		
		lblProductLineId = new JLabel("Product Line ID:");
		lblProductLineId.setBounds(10, 80, 91, 14);
		add(lblProductLineId);
		
		lblProductDescription = new JLabel("Product Description:");
		lblProductDescription.setBounds(10, 128, 113, 14);
		add(lblProductDescription);
		
		lblProductFinish = new JLabel("Product Finish:");
		lblProductFinish.setBounds(10, 178, 91, 14);
		add(lblProductFinish);
		
		lblProductStandardPrice = new JLabel("Standard Price");
		lblProductStandardPrice.setBounds(10, 226, 127, 14);
		add(lblProductStandardPrice);
		
		lblSelectYourTable = new JLabel("Select Your Table");
		lblSelectYourTable.setBounds(291, 22, 99, 14);
		add(lblSelectYourTable);
		
		lblSelectYourOperation = new JLabel("Select Your Operation");
		lblSelectYourOperation.setBounds(435, 22, 113, 14);
		add(lblSelectYourOperation);
		
		txt_vendor_vendorID = new JTextField();
		txt_vendor_vendorID.setColumns(10);
		txt_vendor_vendorID.setBounds(133, 34, 70, 20);
		add(txt_vendor_vendorID);
		
		txt_vendor_vendorName = new JTextField();
		txt_vendor_vendorName.setColumns(10);
		txt_vendor_vendorName.setBounds(133, 77, 70, 20);
		add(txt_vendor_vendorName);
		
		txt_vendor_street = new JTextField();
		txt_vendor_street.setColumns(10);
		txt_vendor_street.setBounds(133, 125, 70, 20);
		add(txt_vendor_street);
		
		txt_vendor_city = new JTextField();
		txt_vendor_city.setColumns(10);
		txt_vendor_city.setBounds(133, 175, 70, 20);
		add(txt_vendor_city);
		
		txt_vendor_state = new JTextField();
		txt_vendor_state.setColumns(10);
		txt_vendor_state.setBounds(133, 223, 70, 20);
		add(txt_vendor_state);
		
		txt_vendor_postalCode = new JTextField();
		txt_vendor_postalCode.setColumns(10);
		txt_vendor_postalCode.setBounds(133, 263, 70, 20);
		add(txt_vendor_postalCode);
		
		txt_vendor_fax = new JTextField();
		txt_vendor_fax.setColumns(10);
		txt_vendor_fax.setBounds(133, 300, 70, 20);
		add(txt_vendor_fax);
		
		txt_vendor_phone = new JTextField();
		txt_vendor_phone.setColumns(10);
		txt_vendor_phone.setBounds(133, 331, 70, 20);
		add(txt_vendor_phone);
		
		txt_vendor_contact = new JTextField();
		txt_vendor_contact.setColumns(10);
		txt_vendor_contact.setBounds(338, 223, 70, 20);
		add(txt_vendor_contact);
		
		txt_vendor_taxID = new JTextField();
		txt_vendor_taxID.setColumns(10);
		txt_vendor_taxID.setBounds(338, 263, 70, 20);
		add(txt_vendor_taxID);
		
		lblVendorId = new JLabel("Vendor ID:");
		lblVendorId.setBounds(10, 37, 91, 14);
		add(lblVendorId);
		
		lblVendorName = new JLabel("Vendor Name:");
		lblVendorName.setBounds(10, 80, 91, 14);
		add(lblVendorName);
		
		lblStreet = new JLabel("Street:");
		lblStreet.setBounds(10, 128, 91, 14);
		add(lblStreet);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(10, 178, 91, 14);
		add(lblCity);
		
		lblState = new JLabel("State:");
		lblState.setBounds(10, 226, 91, 14);
		add(lblState);
		
		lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setBounds(10, 266, 91, 14);
		add(lblPostalCode);
		
		lblFax = new JLabel("Fax:");
		lblFax.setBounds(10, 303, 91, 14);
		add(lblFax);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 334, 91, 14);
		add(lblPhone);
		
		lblContact = new JLabel("Contact:");
		lblContact.setBounds(278, 226, 91, 14);
		add(lblContact);
		
		lblTaxId = new JLabel("Tax ID:");
		lblTaxId.setBounds(278, 266, 91, 14);
		add(lblTaxId);
		
		txt_person_personID = new JTextField();
		txt_person_personID.setColumns(10);
		txt_person_personID.setBounds(133, 34, 70, 20);
		add(txt_person_personID);
		
		txt_person_firstName = new JTextField();
		txt_person_firstName.setColumns(10);
		txt_person_firstName.setBounds(133, 77, 70, 20);
		add(txt_person_firstName);
		
		txt_person_lastName = new JTextField();
		txt_person_lastName.setColumns(10);
		txt_person_lastName.setBounds(133, 125, 70, 20);
		add(txt_person_lastName);
		
		txt_person_street = new JTextField();
		txt_person_street.setColumns(10);
		txt_person_street.setBounds(133, 175, 70, 20);
		add(txt_person_street);
		
		txt_person_city = new JTextField();
		txt_person_city.setColumns(10);
		txt_person_city.setBounds(133, 223, 70, 20);
		add(txt_person_city);
		
		txt_person_state = new JTextField();
		txt_person_state.setColumns(10);
		txt_person_state.setBounds(133, 263, 70, 20);
		add(txt_person_state);
		
		txt_person_postalCode = new JTextField();
		txt_person_postalCode.setColumns(10);
		txt_person_postalCode.setBounds(133, 300, 70, 20);
		add(txt_person_postalCode);
		
		txt_person_phone = new JTextField();
		txt_person_phone.setColumns(10);
		txt_person_phone.setBounds(133, 331, 70, 20);
		add(txt_person_phone);
		
		txt_person_fax = new JTextField();
		txt_person_fax.setColumns(10);
		txt_person_fax.setBounds(338, 223, 70, 20);
		add(txt_person_fax);
		
		lblPersonId = new JLabel("Person ID:");
		lblPersonId.setBounds(10, 37, 91, 14);
		add(lblPersonId);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 80, 91, 14);
		add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 128, 91, 14);
		add(lblLastName);
		
		lblStreet_1 = new JLabel("Street:");
		lblStreet_1.setBounds(10, 178, 91, 14);
		add(lblStreet_1);
		
		lblCity_1 = new JLabel("City");
		lblCity_1.setBounds(10, 226, 91, 14);
		add(lblCity_1);
		
		lblState_1 = new JLabel("State:");
		lblState_1.setBounds(10, 266, 91, 14);
		add(lblState_1);
		
		lblPostalCode_1 = new JLabel("Postal Code:");
		lblPostalCode_1.setBounds(10, 303, 91, 14);
		add(lblPostalCode_1);
		
		lblPhone_1 = new JLabel("Phone:");
		lblPhone_1.setBounds(10, 334, 91, 14);
		add(lblPhone_1);
		
		lblFax_1 = new JLabel("Fax:");
		lblFax_1.setBounds(278, 226, 91, 14);
		add(lblFax_1);
		
		lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setBounds(278, 266, 91, 14);
		add(lblBirthDate);
		
		txt_person_birthDate = new JTextField();
		txt_person_birthDate.setColumns(10);
		txt_person_birthDate.setBounds(338, 263, 70, 20);
		add(txt_person_birthDate);
		
		
		//products
		txt_product_productID.setVisible(false);
		txt_product_productLineID.setVisible(false);
		txt_product_productDescription.setVisible(false);
		txt_product_productFinish.setVisible(false);
		txt_product_productStandardPrice.setVisible(false);
		lblProductId.setVisible(false);
		lblProductLineId.setVisible(false);
		lblProductDescription.setVisible(false);
		lblProductFinish.setVisible(false);
		lblProductStandardPrice.setVisible(false);
		
		//vendors
		txt_vendor_vendorID.setVisible(false);
		txt_vendor_vendorName.setVisible(false);
		txt_vendor_street.setVisible(false);
		txt_vendor_city.setVisible(false);
		txt_vendor_state.setVisible(false);
		txt_vendor_postalCode.setVisible(false);
		txt_vendor_fax.setVisible(false);
		txt_vendor_phone.setVisible(false);
		txt_vendor_contact.setVisible(false);
		txt_vendor_taxID.setVisible(false);
		lblVendorId.setVisible(false);
		lblVendorName.setVisible(false);
		lblStreet.setVisible(false);
		lblCity.setVisible(false);
		lblState.setVisible(false);
		lblPostalCode.setVisible(false);
		lblFax.setVisible(false);
		lblPhone.setVisible(false);
		lblContact.setVisible(false);
		lblTaxId.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGo){
			
			//-----------------------------------------------------------------------------------------------------------------------
			// PEOPLE
			
			if(cmb_TableChoice.getSelectedIndex() == 0){
				PersonDAO personDAO = new PersonDAO();
				BigDecimal pid = BigDecimal.valueOf(Double.parseDouble(txt_person_personID.getText()));
				Person p = new Person(pid);
				p.setFirstName(txt_person_firstName.getText());
				p.setLastName(txt_person_lastName.getText());
				Address a = new Address();
				a.setStreetAddress(txt_person_street.getText());
				a.setCity(txt_person_city.getText());
				a.setState(txt_person_state.getText());
				a.setPostalCode(txt_person_postalCode.getText());
				p.setAddress(a);
				Timestamp bday = new Timestamp(Long.parseLong(txt_person_birthDate.getText()));
				p.setBirthDate(bday);
				p.setPhoneNum(txt_person_phone.getText());
				p.setFaxNum(txt_person_fax.getText());
				
				
				// create
				if(cmb_OperationChoice.getSelectedIndex() == 0){
					try {
						personDAO.createPerson(p);
						resultsArea.setText("Person Added Sucessfully");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				// view
				else if(cmb_OperationChoice.getSelectedIndex() == 1){
					try {
						resultsArea.setText(personDAO.viewPerson(pid).toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// update
				else if(cmb_OperationChoice.getSelectedIndex() == 2){
					try {
						personDAO.updatePerson(p);
						resultsArea.setText("Person Updated Sucessfully");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// delete
				else if(cmb_OperationChoice.getSelectedIndex() == 3){
					try {
						personDAO.deletePerson(p.getPersonId());
						resultsArea.setText("Person Deleted Sucessfully");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			//-----------------------------------------------------------------------------------------------------------------------
			// PRODUCTS
			else if(cmb_TableChoice.getSelectedIndex() == 1){
				
				ProductDAO pdao = new ProductDAO();
				BigDecimal pid1 = BigDecimal.valueOf(Double.parseDouble(txt_product_productID.getText()));
				BigDecimal lineID = BigDecimal.valueOf(Double.parseDouble(txt_product_productLineID.getText()));
				BigDecimal standardPrice = BigDecimal.valueOf(Double.parseDouble(txt_product_productStandardPrice.getText()));
				// create product
				Product p1 = new Product(pid1);
				p1.setLineID(lineID);
				p1.setProductDesc(txt_product_productDescription.getText());
				p1.setProductFinish(txt_product_productFinish.getText());
				p1.setProductStandardPrice(standardPrice);
				
				// create
				if(cmb_OperationChoice.getSelectedIndex() == 0){
					try {
						pdao.createProduct(p1);
						resultsArea.setText("Product Added Sucessfully");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				// view
				else if(cmb_OperationChoice.getSelectedIndex() == 1){
					try {
						resultsArea.setText(pdao.viewProduct(pid1).toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// update
				else if(cmb_OperationChoice.getSelectedIndex() == 2){
					try {
						pdao.updateProduct(p1);
						resultsArea.setText("Product Updated Sucessfully");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// delete
				else if(cmb_OperationChoice.getSelectedIndex() == 3){
					try {
						pdao.deleteProduct(p1.getProductID());
						resultsArea.setText("Product Deleted Sucessfully");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			// -----------------------------------------------------------------------------------------------------------------------
			// VENDORS
			else if(cmb_TableChoice.getSelectedIndex() == 2){
				
				VendorDAO vdao = new VendorDAO();
				BigDecimal vid = BigDecimal.valueOf(Double.parseDouble(txt_vendor_vendorID.getText()));
				String vendorName = txt_vendor_vendorName.getText();
				String street = txt_vendor_street.getText();
				String city = txt_vendor_city.getText();
				String state = txt_vendor_state.getText();
				String postalCode = txt_vendor_postalCode.getText();
				String fax = txt_vendor_fax.getText();
				String phone = txt_vendor_phone.getText();
				String contact = txt_vendor_contact.getText();
				BigDecimal tid = BigDecimal.valueOf(Double.parseDouble(txt_vendor_taxID.getText()));
				// create product
				Vendor v = new Vendor(vid);
				Address a1 = new Address(street, city, state, postalCode);
				v.setVendorName(vendorName);
				v.setAddress(a1);
				v.setFaxNum(fax);
				v.setPhoneNum(phone);
				v.setVendorContact(contact);
				v.setTaxID(tid);
				
				// create
				if(cmb_OperationChoice.getSelectedIndex() == 0){
					try {
						vdao.createVendor(v);
						resultsArea.setText("Vendor Added Sucessfully");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				// view
				else if(cmb_OperationChoice.getSelectedIndex() == 1){
					try {
						resultsArea.setText(vdao.viewVendor(v.getVendorID()).toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// update
				else if(cmb_OperationChoice.getSelectedIndex() == 2){
					try {
						vdao.updateVendor(v);
						resultsArea.setText("Vendor Updated Sucessfully");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// delete
				else if(cmb_OperationChoice.getSelectedIndex() == 3){
					try {
						vdao.deleteVendor(v.getVendorID());
						resultsArea.setText("Vendor Deleted Sucessfully");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		// need to display and hide the appropriate textboxs and labels
		else if(e.getSource() == cmb_TableChoice){
			// if person is selected
			if(cmb_TableChoice.getSelectedIndex() == 0){
				
				// people
				txt_person_personID.setVisible(true);
				txt_person_firstName.setVisible(true);
				txt_person_lastName.setVisible(true);
				txt_person_street.setVisible(true);
				txt_person_city.setVisible(true);
				txt_person_state.setVisible(true);
				txt_person_postalCode.setVisible(true);
				txt_person_phone.setVisible(true);
				txt_person_fax.setVisible(true);
				lblPersonId.setVisible(true);
				lblFirstName.setVisible(true);
				lblLastName.setVisible(true);
				lblStreet_1.setVisible(true);
				lblCity_1.setVisible(true);
				lblState_1.setVisible(true);
				lblPostalCode_1.setVisible(true);
				lblPhone_1.setVisible(true);
				lblFax_1.setVisible(true);
				lblBirthDate.setVisible(true);
				txt_person_birthDate.setVisible(true);
				
				//products
				txt_product_productID.setVisible(false);
				txt_product_productLineID.setVisible(false);
				txt_product_productDescription.setVisible(false);
				txt_product_productFinish.setVisible(false);
				txt_product_productStandardPrice.setVisible(false);
				lblProductId.setVisible(false);
				lblProductLineId.setVisible(false);
				lblProductDescription.setVisible(false);
				lblProductFinish.setVisible(false);
				lblProductStandardPrice.setVisible(false);
				
				//vendors
				txt_vendor_vendorID.setVisible(false);
				txt_vendor_vendorName.setVisible(false);
				txt_vendor_street.setVisible(false);
				txt_vendor_city.setVisible(false);
				txt_vendor_state.setVisible(false);
				txt_vendor_postalCode.setVisible(false);
				txt_vendor_fax.setVisible(false);
				txt_vendor_phone.setVisible(false);
				txt_vendor_contact.setVisible(false);
				txt_vendor_taxID.setVisible(false);
				lblVendorId.setVisible(false);
				lblVendorName.setVisible(false);
				lblStreet.setVisible(false);
				lblCity.setVisible(false);
				lblState.setVisible(false);
				lblPostalCode.setVisible(false);
				lblFax.setVisible(false);
				lblPhone.setVisible(false);
				lblContact.setVisible(false);
				lblTaxId.setVisible(false);
			}
			// if product is selected
			else if(cmb_TableChoice.getSelectedIndex() == 1){
				//products
				txt_product_productID.setVisible(true);
				txt_product_productLineID.setVisible(true);
				txt_product_productDescription.setVisible(true);
				txt_product_productFinish.setVisible(true);
				txt_product_productStandardPrice.setVisible(true);
				lblProductId.setVisible(true);
				lblProductLineId.setVisible(true);
				lblProductDescription.setVisible(true);
				lblProductFinish.setVisible(true);
				lblProductStandardPrice.setVisible(true);
				
				//vendors
				txt_vendor_vendorID.setVisible(false);
				txt_vendor_vendorName.setVisible(false);
				txt_vendor_street.setVisible(false);
				txt_vendor_city.setVisible(false);
				txt_vendor_state.setVisible(false);
				txt_vendor_postalCode.setVisible(false);
				txt_vendor_fax.setVisible(false);
				txt_vendor_phone.setVisible(false);
				txt_vendor_contact.setVisible(false);
				txt_vendor_taxID.setVisible(false);
				lblVendorId.setVisible(false);
				lblVendorName.setVisible(false);
				lblStreet.setVisible(false);
				lblCity.setVisible(false);
				lblState.setVisible(false);
				lblPostalCode.setVisible(false);
				lblFax.setVisible(false);
				lblPhone.setVisible(false);
				lblContact.setVisible(false);
				lblTaxId.setVisible(false);
				
				// people
				txt_person_personID.setVisible(false);
				txt_person_firstName.setVisible(false);
				txt_person_lastName.setVisible(false);
				txt_person_street.setVisible(false);
				txt_person_city.setVisible(false);
				txt_person_state.setVisible(false);
				txt_person_postalCode.setVisible(false);
				txt_person_phone.setVisible(false);
				txt_person_fax.setVisible(false);
				lblPersonId.setVisible(false);
				lblFirstName.setVisible(false);
				lblLastName.setVisible(false);
				lblStreet_1.setVisible(false);
				lblCity_1.setVisible(false);
				lblState_1.setVisible(false);
				lblPostalCode_1.setVisible(false);
				lblPhone_1.setVisible(false);
				lblFax_1.setVisible(false);
				lblBirthDate.setVisible(false);
				txt_person_birthDate.setVisible(false);
			}
			// if Vendor is selected
			else if(cmb_TableChoice.getSelectedIndex() == 2){
				//products
				txt_product_productID.setVisible(false);
				txt_product_productLineID.setVisible(false);
				txt_product_productDescription.setVisible(false);
				txt_product_productFinish.setVisible(false);
				txt_product_productStandardPrice.setVisible(false);
				lblProductId.setVisible(false);
				lblProductLineId.setVisible(false);
				lblProductDescription.setVisible(false);
				lblProductFinish.setVisible(false);
				lblProductStandardPrice.setVisible(false);
				
				//vendors
				txt_vendor_vendorID.setVisible(true);
				txt_vendor_vendorName.setVisible(true);
				txt_vendor_street.setVisible(true);
				txt_vendor_city.setVisible(true);
				txt_vendor_state.setVisible(true);
				txt_vendor_postalCode.setVisible(true);
				txt_vendor_fax.setVisible(true);
				txt_vendor_phone.setVisible(true);
				txt_vendor_contact.setVisible(true);
				txt_vendor_taxID.setVisible(true);
				lblVendorId.setVisible(true);
				lblVendorName.setVisible(true);
				lblStreet.setVisible(true);
				lblCity.setVisible(true);
				lblState.setVisible(true);
				lblPostalCode.setVisible(true);
				lblFax.setVisible(true);
				lblPhone.setVisible(true);
				lblContact.setVisible(true);
				lblTaxId.setVisible(true);
				
				// people
				txt_person_personID.setVisible(false);
				txt_person_firstName.setVisible(false);
				txt_person_lastName.setVisible(false);
				txt_person_street.setVisible(false);
				txt_person_city.setVisible(false);
				txt_person_state.setVisible(false);
				txt_person_postalCode.setVisible(false);
				txt_person_phone.setVisible(false);
				txt_person_fax.setVisible(false);
				lblPersonId.setVisible(false);
				lblFirstName.setVisible(false);
				lblLastName.setVisible(false);
				lblStreet_1.setVisible(false);
				lblCity_1.setVisible(false);
				lblState_1.setVisible(false);
				lblPostalCode_1.setVisible(false);
				lblPhone_1.setVisible(false);
				lblFax_1.setVisible(false);
				lblBirthDate.setVisible(false);
				txt_person_birthDate.setVisible(false);
			}
		}
		
	}
}
