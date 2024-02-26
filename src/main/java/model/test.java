package model;

import java.util.List;

public class test {
    public static void main(String[] args) {

        //...................................................test User....................................................
        // Création d'un objet User pour tester
//        User user = new User(1, "Doe", "John", "standard", "john.doe@example.com", "motdepasse", "123456789");

        // Test de la méthode createUser
//        System.out.println("Création d'un nouvel utilisateur...");
//        user.createUser(user);
//        System.out.println("Utilisateur créé avec succès.");

        // Test de la méthode updateUser
//        System.out.println("Mise à jour de l'utilisateur...");
//        user.setNom("Smith");
//        user.setPrenom("Jane");
//        user.setType("premium");
//        user.setMotDePasse("nouveaumotdepasse");
//        user.setContact("987654321");
//        user.updateUser(user);
//        System.out.println("Utilisateur mis à jour avec succès.");

        // Test de la méthode deleteUser
//        System.out.println("Suppression de l'utilisateur...");
//        user.deleteUser(user.getUserId());
//        System.out.println("Utilisateur supprimé avec succès.");

        //.................................................test entreprise................................................
        // Création d'une nouvelle entreprise
//        Entreprise nouvelleEntreprise = new Entreprise(1, 1, "Nouvelle Entreprise", "Adresse de la nouvelle entreprise", "Contact de la nouvelle entreprise");
//        int nouvelleEntrepriseId = nouvelleEntreprise.createEntreprise();
//        System.out.println("ID de la nouvelle entreprise : " + nouvelleEntrepriseId);

        // Recherche de toutes les entreprises
//        List<Entreprise> entreprises = nouvelleEntreprise.findAll();
//        System.out.println("Liste des entreprises :");
//        for (Entreprise entreprise : entreprises) {
//            System.out.println("ID : " + entreprise.getEntrepriseId() + ", Nom : " + entreprise.getNom());
//        }

        // Mise à jour de l'entreprise créée
//        if (nouvelleEntrepriseId != -1) {
//            nouvelleEntreprise.setNom("Nouve");
//            nouvelleEntreprise.updateEntreprise();
//            System.out.println("Entreprise mise à jour avec succès !");
//        }

        // Suppression de l'entreprise créée
//        if (nouvelleEntrepriseId != -1) {
//            nouvelleEntreprise.deleteEntreprise(4);
//            System.out.println("Entreprise supprimée avec succès !");
//        }



        //.........................................test Recruteur.............................................................

        // Création d'un recruteur de test
//        Recruteur recruteur = new Recruteur(1, "John", "Doe", "Recruteur", "john.doe@example.com", "password", "123456789", 0);
//
//        // Test de la méthode createRecruteur
//        System.out.println("Création d'un recruteur : ");
//        recruteur.createRecruteur(recruteur);
//        System.out.println("Recruteur créé avec succès.");

        // Test de la méthode updateRecruteur
//        System.out.println("Mise à jour des informations du recruteur : ");
//        recruteur.setNom("Jane");
//        recruteur.setPrenom("Doe");
//        recruteur.updateRecruteur(recruteur);
//        System.out.println("Informations du recruteur mises à jour avec succès.");

        // Test de la méthode deleteRecruteur
//        System.out.println("Suppression du recruteur : ");
//        recruteur.deleteRecruteur(recruteur.getUserId());
//        System.out.println("Recruteur supprimé avec succès.");

        // Test de la méthode findAll
//        System.out.println("Liste de tous les recruteurs : ");
//        List<Recruteur> recruteurs = recruteur.findAll();
//        for (Recruteur r : recruteurs) {
//            System.out.println("ID : " + r.getUserId() + ", Nom : " + r.getNom() + ", Prénom : " + r.getPrenom() + ", Entreprise ID : " + r.getEntrepriseId());
//            System.out.println("Mon User , son ID est : " + r.getUserId() + ", Nom : " + r.getNom() + ", Prénom : " + r.getPrenom() + ", Email : " + r.geteMail());
//            System.out.println("Mon Entreprise ID : " + r.getEntrepriseId() + ", Nom : " + r.getNom() + ", Adresse : " + r.geteMail() + ", Contact : " + r.getContact()  );
//        }

        //---------------------------------------------------test offres-------------------------------------------------------------

        // Création d'une offre
        Offre offre = new Offre(0, 1, "2024-02-24", "2024-03-24", "Contenu de l'offre", "CDI");

        // Test de création de l'offre
        int newOffreId = offre.createOffre(offre);
        if (newOffreId != -1) {
            System.out.println("Nouvelle offre créée avec succès. ID de l'offre : " + newOffreId);
        } else {
            System.out.println("Échec de la création de l'offre.");
        }

        // Test de mise à jour de l'offre
//        offre.setContenu("Nouveau contenu de l'offre");
//        offre.setType("CDD");
//        offre.updateOffre(offre);
//        System.out.println("Offre mise à jour avec succès.");

        // Test de suppression de l'offre
//        offre.deleteOffre(newOffreId);
//        System.out.println("Offre supprimée avec succès.");

        // Test de recherche de toutes les offres
//        List<Offre> offres = offre.findAll();
//        System.out.println("Liste des offres :");
//        for (Offre o : offres) {
//            System.out.println("ID : " + o.getOffreId() + ", Contenu : " + o.getContenu() + ", Type : " + o.getType());
//        }
    }



}






