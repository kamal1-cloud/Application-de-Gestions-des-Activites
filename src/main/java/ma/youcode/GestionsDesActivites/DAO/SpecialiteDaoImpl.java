package ma.youcode.GestionsDesActivites.DAO;

import ma.youcode.GestionsDesActivites.HibernateUtil;
import ma.youcode.GestionsDesActivites.Models.SpecialiteEntity;
import ma.youcode.GestionsDesActivites.Models.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SpecialiteDaoImpl {

    //:::::::::::::: Ajouter une specialite
    public SpecialiteEntity saveSpecialite(SpecialiteEntity spe) {
        Transaction t = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            t = session.beginTransaction();
            Long id = (Long) session.save(spe);
            spe.setIdspecialite(id);
            t.commit();
            System.out.println("La specialité est bien crée !");
            System.out.println("L'Identifient Generer :"+" "+id);
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return spe;
    }
     //::::::::::::::::::: Update Specialite
     public void updateStudent(SpecialiteEntity specialite) {
         Transaction transaction = null;
         try (Session session = HibernateUtil.getFactory().openSession()) {
             // start a transaction
             transaction = session.beginTransaction();

             // save the student object
             String hql = "UPDATE SpecialiteEntity set nom = :nom , salle = :salle " +"WHERE idSpecialite = :idSpecialite";
             Query query = session.createQuery(hql);
             query.setParameter("nom", specialite.getNom());
             query.setParameter("salle", specialite.getSalle());
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

        //::::::::::::::::: GET SPECIALITE BY ID

        public void getById (Long id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // get Student entity using get() method
                SpecialiteEntity specialite = session.get(SpecialiteEntity.class, id);
                System.out.println(specialite.getNom());
                System.out.println(specialite.getSalle());

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        //::::::::::::: Delete

        public void delete(Long id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                // Delete a persistent object
                SpecialiteEntity spe = session.get(SpecialiteEntity.class, id);
                if (spe != null) {
                    session.delete(spe);
                    System.out.println("La specialite supprimer");
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

        //:::::::::::: GET ALL

        public List<SpecialiteEntity> showAllSpecialities() {
            List<SpecialiteEntity> specialiteList = new ArrayList();
            Session session = HibernateUtil.getFactory().openSession();
            Query query = session.createQuery("From SpecialiteEntity");
            specialiteList = query.list();
            return specialiteList;
        }

}
