package villagegaulois;

import java.util.Iterator;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	private static class Marche {
		private Etal [] etals;
		
		private Marche(int NbEtal) {
			for (int i = 0; i < etals.length; i++) {
				etals = new Etal[NbEtal];
			}
		}
		
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			System.out.println("Le vendeur " + vendeur.getNom() + " arrive à l'étal n° " + indiceEtal);
			System.out.println("L'étal de " + vendeur.getNom() + " est garni de " + nbProduit
					+ " " + produit + "\n");
		}
		
		private int trouverEtalLibre() {
			int nbEtalRestant = etals.length;
			if  (nbEtalRestant > 0) {
				System.out.println("Cet étal est libre, un vendeur peut si installer");
				return nbEtalRestant -= 1;
			} else {
				System.out.println("Tous les étals sont occupés, le vendeur reviendra demain.");
				return -1;
			}
		}
		
		private Etal [] trouverEtals(String produit) {
			Etal [] etalsProduit;
			int nbEtalAvecProduit = 0;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].equals(produit)) {
					nbEtalAvecProduit ++;
				}
			}
			etalsProduit = new Etal[nbEtalAvecProduit];
			for (int i = 0, j = 0; i < etalsProduit.length; i++) {
				if (etals[i].equals(produit)) {
					etalsProduit[j] = etals [i];
					j ++;
				}
			}
			return etalsProduit;
		}
		
		private Etal trouverVendeur(Gaulois gaulois) {
			int numEtal = -1;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].equals(gaulois)) {
					numEtal = i;
					System.out.println("Le vendeur " + gaulois.getNom() + " c'est installé à l'étal n° " + numEtal);
				} else {
					System.out.println("Le vendeur " + gaulois.getNom() + "n'a pas d'étal");
				}
			}
			return null;
		}
		
		private void afficherMarche() {
			StringBuilder chaine = new StringBuilder("Les étals occupés du marché sont : ");
			for (int i = 0, j = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe()) {
					
				}
			}
			
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
}