package ma.youcode.GestionsDesActivites.DAO;

import ma.youcode.GestionsDesActivites.HibernateUtil;
import ma.youcode.GestionsDesActivites.Models.TypeeventsEntity;
import ma.youcode.GestionsDesActivites.Models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeEventsDaoImpl {

    public TypeeventsEntity saveTypeEvent(TypeeventsEntity type) {
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(type);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("L'Utilisateur est bien crée !");
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
      return type;
    }

}
