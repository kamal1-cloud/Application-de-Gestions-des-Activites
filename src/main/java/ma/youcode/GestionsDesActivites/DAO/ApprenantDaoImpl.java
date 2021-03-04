package ma.youcode.GestionsDesActivites.DAO;

import ma.youcode.GestionsDesActivites.HibernateUtil;
import ma.youcode.GestionsDesActivites.Models.ApprenantEntity;
import ma.youcode.GestionsDesActivites.Models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApprenantDaoImpl {

    //:::::::::::::: Ajouter Un Apprenant
    public ApprenantEntity saveApprenant(ApprenantEntity apprenant) {
        Transaction t = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            t = session.beginTransaction();
            Long id = (Long) session.save(apprenant);
            apprenant.setIduser(id);
            t.commit();

        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return apprenant;
    }
}
