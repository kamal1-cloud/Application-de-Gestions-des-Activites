package ma.youcode.GestionsDesActivites.DAO;

import ma.youcode.GestionsDesActivites.HibernateUtil;
import ma.youcode.GestionsDesActivites.Models.SpecialiteEntity;
import ma.youcode.GestionsDesActivites.Models.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class UsersDaoImpl {
    public UsersEntity getById(Long id) {
        UsersEntity user;
        Session session = null;
        try {

            session = HibernateUtil.getFactory().openSession();
            // get joueur by id
            user = session.get(UsersEntity.class, id);
            System.out.println("User lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return user;

    }

    //::::::::::::::: Get List

    public List<UsersEntity> getUsersList(){

        Session session = null;
        List<UsersEntity> usrList = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            String queryStr = "select usr from Users usr";
            Query query = session.createQuery(queryStr);
            usrList = query.list();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return usrList;
    }

    //::::::::::::::::::::

//    public void saveUser(UsersEntity user) throws ClassNotFoundException, SQLException {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//
//            session = HibernateUtil.getFactory().openSession();
//            transaction = session.beginTransaction();
//            session.persist(user);
//            // lancer des mises à jour dans la session et faire automatiquement le commit
//            session.flush();
//            // transaction.commit();
//            System.out.println("L'Utilisateur est bien crée !");
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//
//    }
    //::::::::::::::::::::::::::::: Save Method

    public UsersEntity saveUser(UsersEntity user) {
        Transaction t = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            t = session.beginTransaction();
            Long id = (Long) session.save(user);
            user.setIduser(id);
            t.commit();
            System.out.println("L'Utilisateur est bien crée !");
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return user;
    }

    //:::::::::::::::::::::::::::::: Update Method

    public void updateUser(UsersEntity user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student object
            String hql = "UPDATE UsersEntity set nom = :nom , prenom = :prenom , cin = :cin, email = :email, password = :password , role = :role" +"WHERE idUser = :idUser";
            Query query = session.createQuery(hql);
            query.setParameter("nom", user.getNom());
            query.setParameter("prenom", user.getPrenom());
            query.setParameter("cin", user.getCin());
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            query.setParameter("role", user.getRole());
            query.setParameter("idSpecialite", 7);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }



//::::::::::::::::::: Delete Method for users

    public void deleteUser(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a persistent object
            UsersEntity user = session.get(UsersEntity.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("student 1 is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
