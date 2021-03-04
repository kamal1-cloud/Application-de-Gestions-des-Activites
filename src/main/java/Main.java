import ma.youcode.GestionsDesActivites.DAO.*;
import ma.youcode.GestionsDesActivites.HibernateUtil;
import ma.youcode.GestionsDesActivites.Models.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


       SpecialiteDaoImpl ser = new SpecialiteDaoImpl();
       SpecialiteEntity spe = new SpecialiteEntity("Flutter","6");
    //   ser.saveSpecialite(spe);
//        ser.showAllSpecialities();
          ser.updateStudent(spe);
        // get Specialities
        List<SpecialiteEntity> specialites = ser.showAllSpecialities();
        specialites.forEach(s -> System.out.println(s.getNom()));
        //::::::::::::::::


    }
}