package fr.dampierre;

import java.util.ArrayList;
import java.util.List;

public class Parking {

  private int capacite;
  private List<String> immatriculationsPresentes = new ArrayList<String>();

  public Parking(int capacite) {
    this.capacite = capacite;
  }

  int getNbVehiculesPresents() {
    return immatriculationsPresentes.size();
  }

  boolean enregistrerEntree(String immatriculation) {
    if (!estPlein() && !estPresente(immatriculation)) {
      immatriculationsPresentes.add(immatriculation);
      return true;
    }
    return false;
  }

  boolean estPresente(String immatriculation) {
    return immatriculationsPresentes.contains(immatriculation);
  }

  boolean enregistrerSortie(String immatriculation) {
    return immatriculationsPresentes.remove(immatriculation);
  }

  private boolean estPlein() {
    return immatriculationsPresentes.size() >= capacite;
  }

  boolean estVide() {
    return immatriculationsPresentes.isEmpty();
  }

  void afficherImmatriculationsPresentes() {
    for (String imm : immatriculationsPresentes) {
      System.out.println(imm);
    }
  }

  public double tauxDOccupation() {
    return (double) immatriculationsPresentes.size() / capacite * 100.0;
  }

  public int getCapacite() {
    return capacite;
  }
}
