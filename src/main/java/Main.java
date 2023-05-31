import Entity.MessageEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Timestamp;

public class Main {





    public static void main(String[] args) {
//
//
//
//
//
////                try {
////                    // Création de la configuration Hibernate
////                    Configuration configuration = new Configuration();
////                    configuration.configure("Hibernate.cfg.xml")
////                            .addAnnotatedClass(User.class)
////                            .addAnnotatedClass(Message.class);
////
////                    // Création de la session factory
////                    SessionFactory sessionFactory = configuration.buildSessionFactory();
////
////                    // Création de la session
////                    Session session = sessionFactory.openSession();
////
////                    // Fermeture de la session et de la session factory
////                    session.close();
////                    sessionFactory.close();
////
////                    System.out.println("Tables créées avec succès.");
////
////                } catch (Exception e) {
////                    System.err.println("Erreur lors de la création des tables : " + e);
////
////                }
////            }
////        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
//            UsersEntity user = new UsersEntity();
//            user.setFirstName("said");
//            user.setLastName("BENCHAD");
//            user.setEmail("benchad@gmail.com");
//            user.setUsername("saidbenchad");
//            user.setPassword("12345678");
//            entityManager.persist(user);
//            MessageEntity msg = new MessageEntity();
//            msg.setIduser(1);
//            msg.setContent("Hello Felix");
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            msg.setTimestamp(timestamp);
//            entityManager.persist(msg);

            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
