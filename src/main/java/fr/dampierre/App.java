package fr.dampierre;

public class App {
  public static void main(String[] args) {
    Parc parc = new Parc();

    Parking parking1 = parc.creerParking(100);
    Parking parking2 = parc.creerParking(200);

    parc.inscrire("123-456");
    parc.inscrire("789-012");
    parc.inscrire("345-678");
    parc.inscrire("012");

    System.out.println("Liste des immatriculations autorisées : ");
    parc.afficherImmatriculationsAutorisees();

    parc.enregistrerEntree("123-456", parking1);
    parc.enregistrerEntree("789-012", parking2);

    System.out.println("Liste des immatriculations présentes sur tous les parkings : ");
    parc.afficherImmatriculationsPresentes();
  }
}
