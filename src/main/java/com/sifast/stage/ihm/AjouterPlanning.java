package com.sifast.stage.ihm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sifast.stage.controller.Service;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class AjouterPlanning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	static private AjouterPlanning frame1;
	public static JDateChooser dateF;
	public static JDateChooser dateD;

	// classe principale
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame1= new AjouterPlanning();
					frame1.setVisible(true);
					frame1.setSize(600, 600);
					frame1.setLocationRelativeTo(null);
					frame1.setTitle("Ajouter Planning");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	// constructeur
	public AjouterPlanning() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Name of planning

		JLabel lblAjouterNouveauPlanning = new JLabel("Ajouter nouveau planning :");
		lblAjouterNouveauPlanning.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAjouterNouveauPlanning.setBounds(93, 32, 240, 32);
		contentPane.add(lblAjouterNouveauPlanning);

		JLabel lblNomDuPlanning = new JLabel("Nom du Planning:");
		lblNomDuPlanning.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNomDuPlanning.setBounds(138, 175, 128, 15);
		contentPane.add(lblNomDuPlanning);

		textField = new JTextField();
		textField.setBounds(310, 170, 154, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		// Date debut

		JLabel lblDateDeDbut = new JLabel("Date de d\u00E9but:");
		lblDateDeDbut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDateDeDbut.setBounds(138, 234, 110, 14);
		contentPane.add(lblDateDeDbut);

		dateF = new JDateChooser();
		dateF.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateF.getCalendarButton().setForeground(new Color(0, 0, 0));
		dateF.getCalendarButton().setBackground(SystemColor.activeCaption);
		dateF.setDateFormatString("dd-MM-yyyy");
		dateF.setBounds(310, 287, 97, 20);
		contentPane.add(dateF);

		// Date fin

		JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDateDeFin.setBounds(138, 287, 97, 14);
		contentPane.add(lblDateDeFin);

		dateD = new JDateChooser();
		dateD.getCalendarButton().setBackground(SystemColor.activeCaption);
		dateD.setDateFormatString("dd-MM-yyyy");
		dateD.setBounds(310, 228, 97, 20);
		contentPane.add(dateD);

		// bouton ajouter

		JButton butAjouter = new JButton("Ajouter");
		butAjouter.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		butAjouter.setBounds(197, 398, 200, 50);
		contentPane.add(butAjouter);

		butAjouter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String dateDebut1=dateD.getDate().getYear()+""+dateD.getDate().getMonth()+dateD.getDate().getDate();
				String dateFin1=dateF.getDate().getYear()+""+dateF.getDate().getMonth()+dateF.getDate().getDate();
				int dateDebut1_int = Integer.parseInt(dateDebut1);
				int dateFin1_int = Integer.parseInt(dateFin1);
				System.out.println(dateDebut1_int);
				System.out.println(dateFin1_int);

				if ((textField.getText().isEmpty()) || (dateDebut1==null) || (dateF.getDate()==null)) {
					JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vide\n \n                  Svp réssayez", "Erreur",
							JOptionPane.ERROR_MESSAGE);

				}
				
				else{
					
					if (dateDebut1.equals(dateFin1)){
				JOptionPane.showMessageDialog(butAjouter, "La date de debut doit etre differente de la date de fin\n \n                  Svp réssayez", "Erreur",
						JOptionPane.ERROR_MESSAGE);	}
				else{
					
					if ((!(textField.getText().isEmpty())) && (!(dateDebut1==null)) && (!(dateFin1==null))
				
						&& (dateDebut1_int < dateFin1_int)) {

//					plan.setDateDebut(dateD);
//					plan.setDateFin(dateF);
//					plan.setNomPlanning(textField.getText().toString());
				    Service.createPlanning(textField.getText().toString(), dateD, dateF);
					
					MembresDeGarde frame = new MembresDeGarde();
					frame.setSize(600, 600);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Membres de garde");
					frame.setVisible(true);
					frame1.dispose();
					}
			
				    else {
					JOptionPane.showMessageDialog(null, "La date de fin doit etre situé aprés la date début\n \n                  Svp réssayez", "Erreur",
							JOptionPane.ERROR_MESSAGE);

				}   }       
				                        
			}}

		});

	}
}
