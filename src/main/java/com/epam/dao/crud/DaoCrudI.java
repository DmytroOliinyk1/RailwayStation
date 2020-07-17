package com.epam.dao.crud;

public interface DaoCrudI<TEntity> extends DaoReadI<TEntity> {
    /**
     * Method inserts object type of TEntity into database.
     *
     * @param object
     * @return boolean result of inserting
     */
    boolean insert(TEntity object);

    /**
     * Method updates database by id.
     *
     * @param args
     * @return boolean result of updating
     */
    boolean updateById(Object... args);

    /**
     * Method updates database by fields.
     *
     * @param fieldsValues
     * @return boolean result of updating
     */
    boolean updateByFields(Object... fieldsValues);

    /**
     * Method deletes from database by id.
     *
     * @param id
     * @return boolean result of deleting
     */
    boolean deleteById(Long id);

    /**
     * Method deletes from database by fields.
     *
     * @param fieldsValues
     * @return boolean result of deleting
     */
    boolean deleteByFields(Object... fieldsValues);
}