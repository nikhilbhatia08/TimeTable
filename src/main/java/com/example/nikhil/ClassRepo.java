package com.example.nikhil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ClassRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertQuery(Clss Class, String day){
        try{
            entityManager.createNativeQuery("INSERT INTO class (classyr, branch_sec, day)values(?, ?, ?)")
                    .setParameter(1, Class.getClassyr())
                    .setParameter(2, Class.getBranch_sec())
                    .setParameter(3, day)
                    .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    @Transactional
    public void UpdateQuery(String day, int classyr, String branch_sec, String one, String two ,String three, String four, String five, String six) {
        try{
            entityManager.createNativeQuery("UPDATE class SET one=?, two=?, three=?,four=?,five=?,six=? WHERE classyr=? AND branch_sec=? AND day=?")
                    .setParameter(1, one)
                    .setParameter(2, two)
                    .setParameter(3, three)
                    .setParameter(4, four)
                    .setParameter(5, five)
                    .setParameter(6, six)
                    .setParameter(7, classyr)
                    .setParameter(8, branch_sec)
                    .setParameter(9, day)
                    .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
