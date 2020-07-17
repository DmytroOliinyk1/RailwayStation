package com.epam.dto.mapper;

import com.epam.entity.Entity;

public interface DtoMapper<TEntity> {
    /**
     * Method converts Entity to TEntity.
     *
     * @param entity
     * @return object type of TEntity
     */
    TEntity fromDtoToEntity(Entity entity);
}