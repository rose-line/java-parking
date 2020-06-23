package fr.dampierre;

public class Parking {

  private int capacite;
  private int nbVehiculesPresents = 0;
  private final int nbInscritsMax = 10000;
  String[] immatriculationsAutorisees = new String[nbInscritsMax];
  private int nbInscrits = 0;
  String[] immatriculationsPresentes;

  public Parking(int capacite) {
    this.capacite = capacite;
    immatriculationsPresentes = new String[capacite];
  }

  String[] getImmatriculationsAutorisees() {
    return immatriculationsAutorisees;
  }

  int getNbInscrits() {
    return nbInscrits;
  }

  int getNbVehiculesPresents() {
    return nbVehiculesPresents;
  }

  /**
   * Permet d'inscrire une nouvelle immatriculation
   *
   * @param immatriculation L'immatriculation à inscrire
   * @return vrai si l'inscription s'est bien passée
   */
  boolean inscrire(String immatriculation) {
    if (nbInscrits < 10000) {
      immatriculationsAutorisees[nbInscrits] = immatriculation;
      nbInscrits++;
      return true;
    }
    return false;
  }

  boolean enregistrerEntree(String immatriculation) {
    if (estAutorisee(immatriculation) && !estPlein() && !estPresente(immatriculation)) {
      immatriculationsPresentes[premierIndexVide()] = immatriculation;
      nbVehiculesPresents++;
      return true;
    }
    return false;
  }

  boolean estPresente(String immatriculation) {
    for (String imm : immatriculationsPresentes) {
      if (imm != null) {
        if (imm.equals(immatriculation)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean enregistrerSortie(String immatriculation) {
    for (int i = 0; i < immatriculationsPresentes.length; i++) {
      if (immatriculationsPresentes[i].equals(immatriculation)) {
        immatriculationsPresentes[i] = null;
        nbVehiculesPresents--;
        return true;
      }
    }
    return false;
  }

  private int premierIndexVide() {
    for (int i = 0; i < immatriculationsPresentes.length; i++) {
      if (immatriculationsPresentes[i] == null) {
        return i;
      }
    }
    return -1;
  }

  private boolean estPlein() {
    return nbVehiculesPresents >= capacite;
  }

  boolean estVide() {
    return nbVehiculesPresents == 0;
  }

  private boolean estAutorisee(String immatriculation) {
    for (String imm : immatriculationsAutorisees) {
      if (imm != null && imm.equals(immatriculation)) {
        return true;
      }
    }
    return false;
  }

  void afficherImmatriculationsAutorisees() {
    for (String imm : immatriculationsAutorisees) {
      if (imm != null) {
        System.out.println(imm);
      }
    }
  }

  void afficherImmatriculationsPresentes() {
    for (String imm : immatriculationsPresentes) {
      if (imm != null) {
        System.out.println(imm);
      }
    }
  }

  public double tauxDOccupation() {
    return (double) nbVehiculesPresents / capacite * 100.0;
  }
}
