package dao;

import Entity.MessageEntity;
import Entity.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Collection;

public class MessageManager {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public boolean save(MessageEntity message){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(message);
            entityManager.getTransaction().commit();
            return true;
        }finally{
            entityManager.close();
        }

    }
    public boolean update(MessageEntity message){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(message);
            entityManager.getTransaction().commit();
            return true;
        }finally{
            entityManager.close();
        }

    }
    public boolean delete(MessageEntity message){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(message);
            entityManager.getTransaction().commit();
            return true;
        }finally{
            entityManager.close();
        }
    }
    public Collection<MessageEntity> getAllMessagesByUserId(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM message WHERE iduser=?", MessageEntity.class);
        query.setParameter(1, id);
        Collection<MessageEntity> Messages = (Collection<MessageEntity>) query.getResultList();
        return Messages;
    }
    public MessageEntity getMessageById(int idmessage){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(MessageEntity.class, idmessage);
        } finally {
            entityManager.close();
        }
    }
    public Collection<MessageEntity> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<MessageEntity> query = cb.createQuery(MessageEntity.class);
            Root<MessageEntity> root = query.from(MessageEntity.class);
            query.select(root);
            return entityManager.createQuery(query).getResultList();
        } finally {
            entityManager.close();
        }

    }
}
