package com.sifast.stage.controller;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sifast.stage.ihm.MembresDeGarde;
import com.sifast.stage.model.Docteur;
import com.sifast.stage.model.PrefEnum;



public class PdfClass {
	public static void main(String arg[]) throws Exception {
		
		
		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream("planning.pdf"));
		document.open();
		
		document.add(new Paragraph("Planning des Gardes Medicales"));
		document.add(new Paragraph(Service.plan.getNomPlanning()));
		document.add(new Paragraph("du " + String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateDebut().getDate()) + " au "
				+ String.format("%1$td/%1$tm/%1$tY", Service.plan.getDateFin().getDate())));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		
		
		
		Boolean test2 = true;
		int indice = 0;
		for (Object elem1 : MembresDeGarde.dates) {
			test2 = true;
			while (test2) {
				Docteur docteur = Service.docteurs.get(indice % Service.docteurs.size());
				if (!(docteur.getPreference().containsKey(elem1))) // champ
																	// vide=
																	// dispo
				{
					document.add(new Paragraph("Le " + elem1 + ", le docteur:  " + Service.docteurs.get(indice % Service.docteurs.size()).getNom() + " en garde "));
					indice++;
					break;
				}
				if (docteur.getPreference().get(elem1).equals(PrefEnum.not_dispo)) {
					indice++;
				}
				if (docteur.getPreference().get(elem1).equals(PrefEnum.dispo_but)) {
					Boolean test = false;
					// recherche du docteur disponible
					for (int i = 0; i < Service.docteurs.size(); i++) {
						if (!(Service.docteurs.get(i).getPreference().containsKey(elem1))) {
							document.add(new Paragraph("Le " + elem1 + ", le docteur:  " + Service.docteurs.get(i).getNom() + " en garde "));
							test = true;
							indice++;
							test2 = false;
							break;
						}
					}
					if (!test) {
						document.add(new Paragraph("Le " + elem1 + ", le docteur: " + Service.docteurs.get(indice % Service.docteurs.size()).getNom() + " en garde "));
						indice++;
						break;
					}
					break;
				}
			}
		}
	
		document.close();

		try {

			// TODO use relative path instead of absolut path
			if ((new File(
					"F:\\work\\projects\\PlanningDesGardesMedicales-master\\planning.pdf"))
					.exists()) {

				Process p = Runtime
						.getRuntime()
						.exec("rundll32 url.dll,FileProtocolHandler F:\\work\\projects\\PlanningDesGardesMedicales-master\\planning.pdf");
				p.waitFor();

			} else {

				System.out.println("File is not exists");

			}

			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
