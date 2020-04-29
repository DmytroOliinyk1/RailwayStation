package com.epam.dto.mapper;

import com.epam.entity.Entity;

public interface DtoMapper<TEntity> {
    TEntity fromDtoToEntity(Entity entity);
}