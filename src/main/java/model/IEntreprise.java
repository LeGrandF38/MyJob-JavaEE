package model;

import java.util.List;

public interface IEntreprise {
   int createEntreprise();
   void updateEntreprise();
   void deleteEntreprise(int entrepriseIdToDelete);
   List<Entreprise> findAll();


}
