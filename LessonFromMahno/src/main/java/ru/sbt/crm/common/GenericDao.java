package ru.sbt.crm.common;

public interface GenericDao<T, PK> {
    T create(T t);
    T get(PK id);
    T update(T t);
    void delete(PK id);

    Class<T> getEntityClass();
}
