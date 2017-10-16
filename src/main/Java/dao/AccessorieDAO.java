package dao;

import model.Accessorie;

public interface AccessorieDAO {
    void add(Accessorie accessorie);
    void delete(Accessorie accessorie);
    Accessorie find(long id);
}
