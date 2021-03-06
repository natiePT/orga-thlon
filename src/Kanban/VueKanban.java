package Kanban;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VueKanban extends JPanel {
	private JPanel pAfaire;
	private JPanel pEnCours;
	private JPanel pEnAttente;
	private JPanel pTermine;
	private ModeleKanban modele ;
	private Map<String, LinkedList<VueCarte>> cartes;
	private JButton btNouvelleTache;
	
	public VueKanban(Map<String, LinkedList<VueCarte>> cartes, ModeleKanban modele){
		this.modele = modele ;
		this.setLayout(new BorderLayout());
		JPanel ptitres = new JPanel();
		ptitres.setLayout(new GridLayout(1,4));
		ptitres.add(new JLabel("A FAIRE", JLabel.CENTER));
		ptitres.add(new JLabel("EN COURS", JLabel.CENTER));
		ptitres.add(new JLabel("TERMINE", JLabel.CENTER));
		ptitres.add(new JLabel("EN ATTENTE", JLabel.CENTER));

		JPanel pCartes = new JPanel();
		pCartes.setLayout(new GridLayout(1,4));
		this.add(ptitres, BorderLayout.NORTH);
		this.add(pCartes);
		this.cartes = cartes;
		
		this.pAfaire = new JPanel();
		pAfaire.setBackground(Color.white);
		pAfaire.setBorder(new EmptyBorder(20,20,20,20));		
		this.pAfaire.setPreferredSize(new Dimension(50,600));
		this.btNouvelleTache= new JButton("Nouvelle carte"); 
		this.btNouvelleTache.setPreferredSize(new Dimension(150,50));
		pAfaire.add(this.btNouvelleTache);
		if(this.cartes.get("enCours") != null) {
		for (VueCarte carteAFaire : this.cartes.get("aFaire")) {
			pAfaire.add(carteAFaire);
		}
		}

		pCartes.add(pAfaire);
		
		this.pEnCours = new JPanel();
		pEnCours.setBackground(Color.LIGHT_GRAY);
		
		if(this.cartes.get("enCours") != null) {
		
			for (VueCarte carteEnCours : this.cartes.get("enCours")) {
				pEnCours.add(carteEnCours);
			}
		
		}
		pEnCours.setBorder(new EmptyBorder(20,20,20,20));		
		pCartes.add(pEnCours);
		
		this.pTermine = new JPanel();
		pTermine.setBackground(Color.gray);
		
		if(this.cartes.get("Terminee") != null) {
			
		
			
			for (VueCarte carteTerminee : this.cartes.get("Terminee")) {
				pTermine.add(carteTerminee);
			}
		
		}
		
		pTermine.setBorder(new EmptyBorder(20,20,20,20));	
		pCartes.add(pTermine);
		this.pEnAttente = new JPanel();
		pEnAttente.setBackground(Color.LIGHT_GRAY);
		
		if(this.cartes.get("enAttente") != null) {
			
		
			for (VueCarte carteEnAttente : this.cartes.get("enAttente")) {
				pEnAttente.add(carteEnAttente);
			}
		}
		pEnAttente.setBorder(new EmptyBorder(20,20,20,20));
		pCartes.add(pEnAttente);
		
	}

	
	public void retirerCarte (JPanel jp, VueCarte vc) {
		
		jp.remove(vc);
	}
	
	public void ajouterCarte (JPanel jp, VueCarte vc) {
		jp.add(vc) ;
	}

	
	public ModeleKanban getModele() {
		return this.modele;
	}
	

	
	
}
