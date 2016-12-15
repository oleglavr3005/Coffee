package lab.epam.olavr.dao;

import java.util.List;

public interface IDao<TEntity> {

    // Create
    boolean insert(TEntity entity);

    // Read
    TEntity getById(Long id);

    List<TEntity> getByFieldName(String fieldName, String text);

    List<TEntity> getAll();

    // Update
    boolean updateByFieldName(String fieldName, String text);

    // Delete
    boolean deleteById(Long id);

    boolean delete(TEntity entity);

}
