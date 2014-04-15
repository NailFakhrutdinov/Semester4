package com.kpfu.itis.dao;

import com.kpfu.itis.model.ToDo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository(value = "toDoDao")
@Transactional
public class ToDoCRUDDaoDerbyImpl  implements CRUDDao<ToDo>{

    private static final String SELECT_QUERY = "SELECT t from todo t";

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ToDo> getAll() {
        Query query = entityManager.createQuery("SELECT t FROM ToDo t");
        return query.getResultList();
    }

    @Override
    public void save(ToDo obj) {
        entityManager.persist(obj);
    }

    @Override
    public void update(ToDo obj) {
        ToDo todo = entityManager.find(ToDo.class,obj.getId());
        todo.setTitle(obj.getTitle());
    }

    @Override
    public void delete(Long id) {
        ToDo todo = entityManager.find(ToDo.class,id);
        entityManager.remove(todo);
    }

    @Override
    public ToDo getById(Long id) {
        return entityManager.find(ToDo.class,id);
    }
}
