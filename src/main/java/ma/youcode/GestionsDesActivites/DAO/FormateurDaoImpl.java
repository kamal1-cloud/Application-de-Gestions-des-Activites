package ma.youcode.GestionsDesActivites.DAO;

import ma.youcode.GestionsDesActivites.HibernateUtil;
import ma.youcode.GestionsDesActivites.Models.FormateurEntity;
import ma.youcode.GestionsDesActivites.Models.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.List;

public class FormateurDaoImpl {

    //:::::::::::::::::: GET BY ID

    public FormateurEntity getById(Long id) throws ClassNotFoundException, SQLException {
        FormateurEntity formateur = null;
        Session session = null;
        try {

            session = HibernateUtil.getFactory().openSession();
            // get joueur by id
            formateur = session.get(FormateurEntity.class, id);
            System.out.println("Le joueur lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return formateur;

    }


    //::::::::::::::::::::::::::

        public void saveFormateur(FormateurEntity formateur) throws ClassNotFoundException, SQLException {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getFactory().openSession()) {

                transaction = session.beginTransaction();
                session.persist(formateur);
                // lancer des mises à jour dans la session et faire automatiquement le commit
                session.flush();
                // transaction.commit();
                System.out.println("L'Utilisateur est bien crée !");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }

    }
    //:::::::::::::::: SUPPRIMER FORMATEUR

//    public void deleteFormateur(Long id) {
//        Transaction tran = null;
//        try (Session session = HibernateUtil.getFactory().openSession()) {
//            // start a transaction
//            tran = session.beginTransaction();
//
//            // Delete a persistent object
//            FormateurEntity formateur = session.get(FormateurEntity.class, id);
//            if (formateur != null) {
//                session.delete(formateur);
//                System.out.println("Formateur Supprimer");
//            }
//
//            // commit transaction
//            tran.commit();
//        } catch (Exception e) {
//            if (tran != null) {
//                tran.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//:::::::::::::::::::::::::::::::
public void delete(Long id) {

    Transaction transaction = null;
    try (Session session = HibernateUtil.getFactory().openSession()) {
        // start a transaction
        transaction = session.beginTransaction();

        // Delete a student object
        FormateurEntity formateur = session.get(FormateurEntity.class, id);
        if (formateur != null) {
            String hql = "DELETE FROM Formateur " + "WHERE id = :idFormateur";
            Query query = session.createQuery(hql);
            query.setParameter("idFormateur", id);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
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

    //::::::::::::::::::::: Update
    public void Update(Long id) throws ClassNotFoundException, SQLException {
        FormateurEntity formateur = null;
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            // get joueur by id
            // joueur = session.get(Joueur.class, id);
            formateur = getById(id);
            session.merge(formateur);
            transaction.commit();
            System.out.println("Formateur modifier !");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    //:::::::::::::::::::::::: Update

//    public void update(FormateurEntity formateur) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//
//            // save the student object
//            String hql = "UPDATE Formateur set nom = :nom " + "WHERE idFormaeur = :idFormateur";
//            Query query = session.createQuery(hql);
//            query.setParameter("nom", formateur.getNom());
//            query.setParameter("idFormateur", 1);
//            int result = query.executeUpdate();
//            System.out.println("Rows affected: " + result);
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }

    //::::::::::::::::::::



}
