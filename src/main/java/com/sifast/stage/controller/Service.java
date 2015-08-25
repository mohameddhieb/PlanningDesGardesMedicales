package com.sifast.stage.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import com.sifast.stage.model.Docteur;
import com.sifast.stage.model.PlanningGarde;
import com.sifast.stage.model.PrefEnum;
import com.toedter.calendar.JDateChooser;

public class Service {
	
	public static ArrayList<Docteur> docteurs = new ArrayList<Docteur>();
	public static PlanningGarde plan = new PlanningGarde();
	public static HashMap<String, PrefEnum> preference = new HashMap<String, PrefEnum>();

	public Service() {

	}

	public void createDoctor() {
		Docteur docteur = new Docteur();
		docteur.setPreference(new HashMap<String, PrefEnum>());
		docteurs.add(docteur);
	}

	public void deleteDoctor(int indice) {
		docteurs.remove(indice);
	}

	// fonction pour gerer le planning dans MembreDeGarde
	public ArrayList<Docteur> genererPlanning(JTable table) {

		for (int i = 0; i < table.getRowCount(); i++) {
			docteurs.get(i).setNom(table.getValueAt(i,0).toString());
		}
		return docteurs;
	}
	// fonction pour gerer la disponibilié dans Disponibilite

	public static ArrayList<Docteur> gererDisponiblite(JTable table, HashMap<String, PrefEnum> preference) {

		docteurs.get(table.getSelectedRow()).setPreference(preference);
		return docteurs;
	}

	// foncion pour creer un planning
	public static void createPlanning(String nom, JDateChooser dateD, JDateChooser dateF) {
		plan.setDateDebut(dateD);
		plan.setDateFin(dateF);
		plan.setNomPlanning(nom);
	}

	// fonction pour supprimer disponibilité
	public static void deletedisponiblity(Object[] row) {
		preference.remove(row);
	}

}