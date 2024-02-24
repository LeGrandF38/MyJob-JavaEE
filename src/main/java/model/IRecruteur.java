package model;

import java.util.List;

public interface IRecruteur {
    void createRecruteur (Recruteur recruteur);
    void updateRecruteur (Recruteur newRecruteur);
    void deleteRecruteur (int recruteurId);
    List<Recruteur> findAll();
    User user();
    Entreprise entreprise();
}
