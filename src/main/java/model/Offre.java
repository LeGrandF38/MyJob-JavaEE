package model;

public class Offre implements IOffre{
    private int offreId;
    private int idRecruteur;
    private String datePublication;
    private String dateExpiration;
    private String type;

    //constructeur

    public Offre(int offreId, int idRecruteur, String datePublication, String dateExpiration, String type) {
        this.offreId = offreId;
        this.idRecruteur = idRecruteur;
        this.datePublication = datePublication;
        this.dateExpiration = dateExpiration;
        this.type = type;
    }


    // getteurs and setters

    public int getOffreId() {
        return offreId;
    }

    public void setOffreId(int offreId) {
        this.offreId = offreId;
    }

    public int getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void createOffre(Offre offre) {

    }

    @Override
    public void updateOffre(Offre newOffre) {

    }

    @Override
    public void deleteOffre(int offreId) {

    }




}
