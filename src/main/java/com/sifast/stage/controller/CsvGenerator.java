package com.sifast.stage.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.sifast.stage.ihm.MembresDeGarde;
import com.sifast.stage.model.Docteur;
import com.sifast.stage.model.PrefEnum;

public class CsvGenerator {
	public static void CsvGeneratorFileNeurologie() throws IOException {
		MembresDeGarde M = new MembresDeGarde();
		FileWriter csvFile = new FileWriter("planning.csv");

		try {
			csvFile.append("Planning des Gardes Medicales");
			csvFile.write("\n");

			csvFile.append(Service.plan.getNomPlanning());
			csvFile.write("\n");

			csvFile.append("du " + String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateDebut().getDate()) + " au "
					+ String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateFin().getDate()));
			csvFile.write("\n");
			csvFile.write("\n");

			Boolean test2 = true;
			int indice = 0;
			Docteur docteur;
			for (Object elem1 : MembresDeGarde.dates) { // na3mlou test
				test2 = true;

				while (test2) {
					docteur = Service.docteurs.get(indice % Service.docteurs.size());
					if (!(docteur.getPreference().containsKey(elem1))) // champ
																		// vide=
																		// dispo
					{
						csvFile.append(elem1 + "," + Service.docteurs.get(indice % Service.docteurs.size()).getNom()
								+ ", en garde  " +M.combo.getItemAt(0) + "\n");
						System.out.println(M.combo.getItemAt(0));
						// csvFile.append(Service.docteurs.get(indice %
						// Service.docteurs.size()).getNom());

						indice++;
						test2 = false;
					} else {
						if (docteur.getPreference().get(elem1).equals(PrefEnum.not_dispo)) {
							indice++;
							test2 = false;
						} else if (docteur.getPreference().get(elem1).equals(PrefEnum.dispo_but)) {
							Boolean test = false;
							// recherche du docteur disponible
							for (int i = 0; i < Service.docteurs.size(); i++) {
								if (!(Service.docteurs.get(i).getPreference().containsKey(elem1))) {
									csvFile.append(elem1 + ", " + Service.docteurs.get(i).getNom() + ", en garde "
											+ M.combo.getItemAt(0) + "\n");
									System.out.println(M.combo.getItemAt(0));

									// csvFile.append(Service.docteurs.get(indice
									// % Service.docteurs.size()).getNom());
									test = true;
									indice++;
									test2 = false;
									break;
								}
							}
							if (!test) {
								csvFile.append(
										elem1 + "," + Service.docteurs.get(indice % Service.docteurs.size()).getNom()
												+ ", en garde " + M.combo.getItemAt(0) + "\n");
								System.out.println(M.combo.getItemAt(0));

								// affichage docteur
								// System.out.println(
								// Service.docteurs.get(indice %
								// Service.docteurs.size()).getNom());
								indice++;

								break;
							}
							break;
						} else {
							// rien faire

						}
					}
				}
			}

			csvFile.close();

			// TODO use relative path instead of absolut path
			if ((new File("F:\\work\\projects\\PlanningDesGardesMedicales\\planning.csv")).exists()) {

				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler F:\\work\\projects\\PlanningDesGardesMedicales\\planning.csv");
				p.waitFor();

			}

			System.out.println("Le Planning a été crée avec succès");
			csvFile.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}
	public static void CsvGeneratorFilePneumologie() throws IOException {
		MembresDeGarde M = new MembresDeGarde();
		FileWriter csvFile = new FileWriter("planning.csv");

		try {
			csvFile.append("Planning des Gardes Medicales");
			csvFile.write("\n");

			csvFile.append(Service.plan.getNomPlanning());
			csvFile.write("\n");

			csvFile.append("du " + String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateDebut().getDate()) + " au "
					+ String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateFin().getDate()));
			csvFile.write("\n");
			csvFile.write("\n");

			Boolean test2 = true;
			int indice = 0;
			Docteur docteur;
			for (Object elem1 : MembresDeGarde.dates) { // na3mlou test
				test2 = true;

				while (test2) {
					docteur = Service.docteurs.get(indice % Service.docteurs.size());
					if (!(docteur.getPreference().containsKey(elem1))) // champ
																		// vide=
																		// dispo
					{
						csvFile.append(elem1 + "," + Service.docteurs.get(indice % Service.docteurs.size()).getNom()
								+ ", en garde  " +M.combo.getItemAt(1) + "\n");
						System.out.println(M.combo.getItemAt(1));
						// csvFile.append(Service.docteurs.get(indice %
						// Service.docteurs.size()).getNom());

						indice++;
						test2 = false;
					} else {
						if (docteur.getPreference().get(elem1).equals(PrefEnum.not_dispo)) {
							indice++;
							test2 = false;
						} else if (docteur.getPreference().get(elem1).equals(PrefEnum.dispo_but)) {
							Boolean test = false;
							// recherche du docteur disponible
							for (int i = 0; i < Service.docteurs.size(); i++) {
								if (!(Service.docteurs.get(i).getPreference().containsKey(elem1))) {
									csvFile.append(elem1 + ", " + Service.docteurs.get(i).getNom() + ", en garde "
											+ M.combo.getItemAt(1) + "\n");
									System.out.println(M.combo.getItemAt(1));

									// csvFile.append(Service.docteurs.get(indice
									// % Service.docteurs.size()).getNom());
									test = true;
									indice++;
									test2 = false;
									break;
								}
							}
							if (!test) {
								csvFile.append(
										elem1 + "," + Service.docteurs.get(indice % Service.docteurs.size()).getNom()
												+ ", en garde " + M.combo.getItemAt(1) + "\n");
								System.out.println(M.combo.getItemAt(1));

								// affichage docteur
								// System.out.println(
								// Service.docteurs.get(indice %
								// Service.docteurs.size()).getNom());
								indice++;

								break;
							}
							break;
						} else {
							// rien faire

						}
					}
				}
			}

			csvFile.close();

			// TODO use relative path instead of absolut path
			if ((new File("F:\\work\\projects\\PlanningDesGardesMedicales\\planning.csv")).exists()) {

				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler F:\\work\\projects\\PlanningDesGardesMedicales\\planning.csv");
				p.waitFor();

			}

			System.out.println("Le Planning a été crée avec succès");
			csvFile.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}
	public static void CsvGeneratorFileCardiologie() throws IOException {
		MembresDeGarde M = new MembresDeGarde();
		FileWriter csvFile = new FileWriter("planning.csv");

		try {
			csvFile.append("Planning des Gardes Medicales");
			csvFile.write("\n");

			csvFile.append(Service.plan.getNomPlanning());
			csvFile.write("\n");

			csvFile.append("du " + String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateDebut().getDate()) + " au "
					+ String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateFin().getDate()));
			csvFile.write("\n");
			csvFile.write("\n");

			Boolean test2 = true;
			int indice = 0;
			Docteur docteur;
			for (Object elem1 : MembresDeGarde.dates) { // na3mlou test
				test2 = true;

				while (test2) {
					docteur = Service.docteurs.get(indice % Service.docteurs.size());
					if (!(docteur.getPreference().containsKey(elem1))) // champ
																		// vide=
																		// dispo
					{
						csvFile.append(elem1 + "," + Service.docteurs.get(indice % Service.docteurs.size()).getNom()
								+ ", en garde  " +M.combo.getItemAt(2) + "\n");
						System.out.println(M.combo.getItemAt(2));
						// csvFile.append(Service.docteurs.get(indice %
						// Service.docteurs.size()).getNom());

						indice++;
						test2 = false;
					} else {
						if (docteur.getPreference().get(elem1).equals(PrefEnum.not_dispo)) {
							indice++;
							test2 = false;
						} else if (docteur.getPreference().get(elem1).equals(PrefEnum.dispo_but)) {
							Boolean test = false;
							// recherche du docteur disponible
							for (int i = 0; i < Service.docteurs.size(); i++) {
								if (!(Service.docteurs.get(i).getPreference().containsKey(elem1))) {
									csvFile.append(elem1 + ", " + Service.docteurs.get(i).getNom() + ", en garde "
											+ M.combo.getItemAt(2) + "\n");
									System.out.println(M.combo.getItemAt(2));

									// csvFile.append(Service.docteurs.get(indice
									// % Service.docteurs.size()).getNom());
									test = true;
									indice++;
									test2 = false;
									break;
								}
							}
							if (!test) {
								csvFile.append(
										elem1 + "," + Service.docteurs.get(indice % Service.docteurs.size()).getNom()
												+ ", en garde " + M.combo.getItemAt(2) + "\n");
								System.out.println(M.combo.getItemAt(2));

								// affichage docteur
								// System.out.println(
								// Service.docteurs.get(indice %
								// Service.docteurs.size()).getNom());
								indice++;

								break;
							}
							break;
						} else {
							// rien faire

						}
					}
				}
			}

			csvFile.close();

			// TODO use relative path instead of absolut path
			if ((new File("F:\\work\\projects\\PlanningDesGardesMedicales\\planning.csv")).exists()) {

				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler F:\\work\\projects\\PlanningDesGardesMedicales\\planning.csv");
				p.waitFor();

			}

			System.out.println("Le Planning a été crée avec succès");
			csvFile.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}
}
