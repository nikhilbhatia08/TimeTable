package com.example.nikhil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.InvalidTransactionException;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.List;

@Repository
public class FacultyRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int insertWithQuery(Faculty fac, String day) {
        int EXECUTE_CODE;
        try{
            entityManager.createNativeQuery("INSERT INTO staff (id, subject, name, day) VALUES (?,?,?, ?)")
                    .setParameter(1, fac.getId())
                    .setParameter(2, fac.getSubject())
                    .setParameter(3, fac.getName())
                    .setParameter(4, day)
                    .executeUpdate();
            EXECUTE_CODE = 1;
        }
        catch(Exception e) {
            System.out.println(e);
            EXECUTE_CODE = 0;
        }
        return EXECUTE_CODE;
    }
    @Transactional
    public List<Faculty> queryForFaculty(int id){
        List<Object[]> faculty = entityManager.createNativeQuery("Select * from staff where staff.id=?")
                .setParameter(1, id)
                .getResultList();
        List<Faculty> Output = new ArrayList<>();
//        for(int i = 0; i < faculty.size(); i++) {
//            System.out.println(facul);
//        }
        //System.out.println(faculty.get(0));
        for(Object[] fac: faculty) {
            //System.out.println(fac[0] + " " + fac[1]);
            Faculty out = new Faculty();
            out.setId((Integer) fac[0]);
            out.setSubject((String) fac[1]);
            out.setName((String) fac[2]);
            out.setDay((String) fac[3]);
            out.setOne((String) fac[4]);
            out.setTwo((String) fac[5]);
            out.setThree((String) fac[6]);
            out.setFour((String) fac[7]);
            out.setFive((String) fac[8]);
            out.setSix((String)fac[9]);
            Output.add(out);
        }
        return Output;
    }
}
