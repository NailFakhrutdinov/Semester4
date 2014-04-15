package com.kpfu.itis.dao;


import java.util.List;

public interface CRUDDao<T> {
    public List<T> getAll();
    public void save(T obj);
    public void update(T obj);
    public void delete(Long id);
    public T getById(Long id);
}
