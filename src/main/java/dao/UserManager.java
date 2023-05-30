package dao;

import Entity.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.sql.SQLException;
import java.util.Collection;

public class UserManager {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public boolean save(UsersEntity user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;
        }finally{
            entityManager.close();
        }

    }
    public boolean update(UsersEntity user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        }finally{
            entityManager.close();
        }

    }
    public boolean delete(UsersEntity user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            return true;
        }finally{
            entityManager.close();
        }
    }
    public UsersEntity getUserById(int iduser){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(UsersEntity.class, iduser);
        } finally {
            entityManager.close();
        }
    }
    public Collection<UsersEntity> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<UsersEntity> query = cb.createQuery(UsersEntity.class);
            Root<UsersEntity> root = query.from(UsersEntity.class);
            query.select(root);
            return entityManager.createQuery(query).getResultList();
        } finally {
            entityManager.close();
        }

    }

}
