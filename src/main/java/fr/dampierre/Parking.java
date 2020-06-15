package fr.dampierre;

public class Parking {

  private int capacite;
  private final int nbInscritsMax = 10000;
  String[] inscriptionsDesImmatriculations = new String[nbInscritsMax];
  private int nbInscrits = 0;

  public Parking(int capacite) {

    this.capacite = capacite;

  }

  public String[] getInscriptionsDesImmatriculations() {
    return inscriptionsDesImmatriculations;
  }

  public int getNbInscrits() {
    return nbInscrits;
  }

  /**
   * Permet d'inscrire une nouvelle immatriculation
   *
   * @param immatriculation L'immatriculation à inscrire
   * @return vrai si l'inscription s'est bien passée
   */
  boolean inscrire(String immatriculation) {
    if (nbInscrits < 10000) {
      inscriptionsDesImmatriculations[nbInscrits] = immatriculation;
      nbInscrits++;
      return true;
    }
    return false;
  }

  boolean validerEntree(String immatriculation) {
    if (estAutorisee(immatriculation)) {
      return true;
    }
    return false;
  }

  private boolean estAutorisee(String immatriculation) {
    for (String imm : inscriptionsDesImmatriculations) {
      if (imm.equals(immatriculation)) {
        return true;
      }
    }
    return false;
  }

}
