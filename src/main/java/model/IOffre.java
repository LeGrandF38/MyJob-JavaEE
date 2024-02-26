package model;

import java.util.List;

public interface IOffre {
    int createOffre (Offre offre);
    void updateOffre (Offre newOffre);
    void deleteOffre (int offreId);
    List<Offre> findAll();
}
