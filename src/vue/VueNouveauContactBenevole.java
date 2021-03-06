package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouveauBenevole;
import modele.contacts.Benevole;

public class VueNouveauContactBenevole extends JPanel{
	private int IdBenevole;
	private JFrame fen;
	private JTextField tfNom;
	private JTextField tfTelephone;
	private JTextField tfPrenom;
	private JTextField tfMail;
	private JTextField tfRole;
	private JTextField tfAdresse1;
	private JTextField tfAdresse2;
	private JLabel lbResponsable;
	private JCheckBox cbEstResponsableEquipe;
	private JCheckBox cbEstResponsableTache;
	private JTextField tfCP;
	private JTextArea taNote;
	private JTextField tfVille;
	private int idContactExt;


	public VueNouveauContactBenevole() {
		
		this.fen = new JFrame();
		this.fen.setTitle(": " + "cr�ation d'une nouvelle fiche BENEVOLE");
		this.fen.setLayout(new GridLayout(1,1));

		
		ControleurNouveauBenevole contr = new ControleurNouveauBenevole(this);
		
		this.setLayout(new BorderLayout());
		JPanel panneauPrincipal = new JPanel();
		this.add(panneauPrincipal, BorderLayout.NORTH);
		panneauPrincipal.setLayout(new GridBagLayout());
		panneauPrincipal.setBorder(new EmptyBorder(0,0,0,0));
		GridBagConstraints c = new GridBagConstraints();
		
		//ligne 0 : Nom ((Jlabel + JTextField) + T�l�phone (Jlabel + JTextField) 
		JLabel lbNom = new JLabel("Nom");
		c.insets = new Insets(5, 0, 5, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbNom,c); 

		tfNom = new JTextField();
		tfNom.setPreferredSize(new Dimension(170,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 1;
		c.gridy = 0;
		//c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfNom, c);
		
		JLabel lbTelephone = new JLabel("T�l�phone");
		lbTelephone.setBorder(new EmptyBorder(0,40,0,0));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 4;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbTelephone,c); 
		
		tfTelephone = new JTextField("");
		tfTelephone.setPreferredSize(new Dimension(120,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 5;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfTelephone, c);
		
		//ligne 1 : Pr�nom (JLabel + JTextField) + E-mail (Jlabel + JTextField)
		JLabel lbPrenom = new JLabel("Pr�nom");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbPrenom,c); 

		tfPrenom = new JTextField();
		tfPrenom.setPreferredSize(new Dimension(170,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfPrenom, c);
		
		JLabel lbMail = new JLabel("E-mail");
		lbMail.setBorder(new EmptyBorder(0,40,0,0));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 4;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbMail,c); 
		
		tfMail = new JTextField();
		tfMail.setPreferredSize(new Dimension(235,25));
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 5;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfMail, c);
		
		this.add(panneauPrincipal, BorderLayout.CENTER);
		//ligne 2 : R�le (JLabel + JComboList) + Adresse (JLabel + JTextField)
		JLabel lbRole = new JLabel("R�le");
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbRole,c);
		
		tfRole = new JTextField();
		tfRole.setPreferredSize(new Dimension(140,25));
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(tfRole, c);
		
		JLabel lbAdresse = new JLabel("Adresse");
		lbAdresse.setBorder(new EmptyBorder(0,40,0,0));
		c.gridx = 4;
		c.gridy = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panneauPrincipal.add(lbAdresse,c); 
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		c.gridx = 5;
		c.gridy = 2;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panneauPrincipal.add(p, c);
		//paragraphe 1 
		tfAdresse1 = new JTextField("");
		tfAdresse1.setPreferredSize(new Dimension(235,25));
		p.add(tfAdresse1);
		//ligne 3 :  + Adresse (JTextField) 
		//paragraphe 2 (Adresse)
		tfAdresse2 = new JTextField("");
		tfAdresse2.setPreferredSize(new Dimension(235,25));
		p.add(tfAdresse2);
		
		//ligne 4 : Equipe (JLabel + JTextField) + CodePostal (JLabel + JTextField)
		lbResponsable = new JLabel("Responsable d'�quipe");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbResponsable,c); 
		this.cbEstResponsableEquipe = new JCheckBox();
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.CENTER;
		panneauPrincipal.add(this.cbEstResponsableEquipe,c);
		
		JLabel lbCP = new JLabel("Code Postal");
		c.gridx = 4;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lbCP.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lbCP,c);
		
		tfCP = new JTextField();
		tfCP.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 5;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tfCP, c);
		
		//ligne 5 : Equipe (JLabel + JComboList) + Ville (JLabel + JTextField)
		JLabel lbEquipe = new JLabel("Equipe");
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(lbEquipe,c); 
		String [] EquipeExemple = {
				"Equipe 1",
				"Equipe 2",
				"Equipe 3",
				"..."
		};
		JComboBox<String> jc = new JComboBox<String>(EquipeExemple);
		jc.setEditable(true);
		jc.setPreferredSize(new Dimension(140,25));
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(jc, c);
		/*
		btAjouterEquipe = new JButton("+");
		c.gridx = 2;
		c.gridy = 6;
		panneauPrincipal.add(btAjouterEquipe,c);
		*/
		lbCP = new JLabel("Ville");
		c.gridx = 4;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lbCP.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lbCP,c); 
		
		this.tfVille = new JTextField();
		this.tfVille.setPreferredSize(new Dimension(50,25));
		c.gridx = 5;
		c.gridy = 6;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panneauPrincipal.add(tfVille, c);
		
		//ligne 8 : bouton "Equipe" + tableau Pr�t Mat�riel
		/*
		this.bpEquipe = new JButton();
		c.gridx = 1;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 1;
		c.insets = new Insets(0,0,0,115);
		c.ipady = 40;
		panneauPrincipal.add(bpEquipe,c);
		*/
		
		JLabel lbNote = new JLabel("Note");
		c.gridx = 4;
		c.gridy = 8;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		lbNote.setBorder(new EmptyBorder(0,40,0,0));
		panneauPrincipal.add(lbNote,c); 
		
		p = new JPanel();
		p.setLayout(new GridLayout(1,1));
		p.setBorder(new EmptyBorder(20,0,0,0));
		this.taNote = new JTextArea(10,5);
		JScrollPane textSP = new JScrollPane(this.taNote);
		textSP.setPreferredSize(new Dimension(250,125));
		p.add(textSP);
		c.gridheight = 5;
		c.gridx = 5;
		c.gridy = 8;
		c.anchor = GridBagConstraints.LINE_START;
		panneauPrincipal.add(p,c);

		//p : SUD
		JPanel ps = new JPanel();
		this.add(ps, BorderLayout.SOUTH);
		ps.setLayout(new GridLayout(1,2,150,0));
		ps.setBorder(new EmptyBorder(0,80,30,80));
		
		JButton bpAnnuler = new JButton("Annuler");
		bpAnnuler.setPreferredSize(new Dimension(40,40));
		ps.add(bpAnnuler);
		bpAnnuler.addActionListener(contr);
		
		JButton bpValider = new JButton("Valider");
		bpValider.setPreferredSize(new Dimension(40,40));
		ps.add(bpValider);
		bpValider.addActionListener(contr);
		
		//g�n�ration de la fen�tre
		this.fen.add(this);
		this.fen.pack();
		this.fen.setSize(900, 550);
		this.fen.setResizable(false);
		this.fen.setVisible(true);
		this.fen.setLocationRelativeTo(null);
	}


	public int getIdBenevole() {
		return IdBenevole;
	}

	public String getTfNom() {
		return tfNom.getText();
	}

	public String getTfPrenom() {
		return tfPrenom.getText();
	}

	public boolean getEstResponsableEquipe() {
		return this.cbEstResponsableEquipe.isSelected();
	}

	public boolean getEstResponsableTache() {
		return this.cbEstResponsableEquipe.isSelected();
	}
	
	public void rendreDisponible(boolean active) {
		this.tfNom.setEditable(active);
		this.tfTelephone.setEditable(active);
		this.tfPrenom.setEditable(active);
		this.tfMail.setEditable(active);
		this.tfRole.setEditable(active);
		this.tfAdresse1.setEditable(active);
		this.tfAdresse2.setEditable(active);
		this.tfCP.setEditable(active);
		this.tfVille.setEditable(active);
		this.taNote.setEditable(active);
		this.cbEstResponsableEquipe.setEnabled(active);
		//this.btAjouterEquipe.setEnabled(active);
		//this.bpEquipe.setEnabled(active);
	}

	public Map<String,Object> rassemblerDonnees() {
		if(!this.tfNom.getText().isEmpty()) {
			HashMap<String,Object> donnees = new HashMap<String, Object>();
			donnees.put("nom_benevole", this.tfNom.getText());
			donnees.put("prenom_benevole",this.tfPrenom.getText());
			donnees.put("adresse_benevole",this.tfAdresse1.getText());
			donnees.put("codePostal_benevole",this.tfCP.getText());
			donnees.put("ville_benevole",this.tfVille.getText());
			donnees.put("telephone_benevole",this.tfTelephone.getText());
			donnees.put("mail_personnel",this.tfMail.getText());
			donnees.put("commentaire_benevole",this.taNote.getText());
			return donnees;
		}else {
			if(this.tfNom.getText().isEmpty())
				this.tfNom.setBackground(Color.red);
		}
		return null;
	}
	
	public void afficherDonnees(int id, String nom, String prenom, String adresse, String cp, String ville, String telephone, String mail, String commentaire) {
		this.idContactExt = id;
		this.tfNom.setText(nom);
		this.tfPrenom.setText(prenom);
		this.tfAdresse1.setText(adresse);
		this.tfCP.setText(cp);
		this.tfVille.setText(ville);
		this.tfTelephone.setText(telephone);
		this.tfMail.setText(mail);
		this.taNote.setText(commentaire);
	}
	
	public JFrame getFen() {
		return fen;
	}
}
