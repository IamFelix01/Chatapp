package dao;

import Entity.UsersEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Collection;
import java.util.List;

public class UserManager {
    @PersistenceContext

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
    public UsersEntity FindUserByUsername(String username){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE username=?",UsersEntity.class);
        query.setParameter(1, username);
        UsersEntity user = (UsersEntity) query.getSingleResult();
        return user;
    }

    public boolean checkUser(String username){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM USERS WHERE username = ?");
        query.setParameter(1, username);
        List<UsersEntity> users = query.getResultList();
        return !users.isEmpty();


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
