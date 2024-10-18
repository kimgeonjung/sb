package edu.du.sb1018.service;

import edu.du.sb1018.entity.Dept;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Log4j2
public class DeptService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public List<Dept> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Dept> deptList = em.createQuery("from Dept", Dept.class).getResultList();
        em.getTransaction().commit();
        return deptList;
    }

    public void addDept(Dept dept) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dept);
        em.getTransaction().commit();
    }

    public Dept findByDeptno(int deptno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dept dept = em.find(Dept.class, deptno);
        em.getTransaction().commit();
        return dept;
    }

    public Dept updateDept(Dept dept) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dept newdept = em.find(Dept.class, dept.getDeptno());
        newdept.setDeptno(dept.getDeptno());
        newdept.setDname(dept.getDname());
        newdept.setLoc(dept.getLoc());
        em.getTransaction().commit();
        return newdept;
    }

    public void deleteDept(int deptno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dept dept = em.find(Dept.class, deptno);
        em.remove(dept);
        em.getTransaction().commit();
    }

    public void reset() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Dept dept10 = em.find(Dept.class, 10);
        if(dept10 != null) {
            dept10.setDname("ACCOUNTING");
            dept10.setLoc("NEW YORK");
        }

        Dept dept20 = em.find(Dept.class, 20);
        if(dept20 != null) {
            dept20.setDname("RESEARCH");
            dept20.setLoc("DALLAS");
        }

        Dept dept30 = em.find(Dept.class, 30);
        if(dept30 != null) {
            dept30.setDname("SALES");
            dept30.setLoc("CHICAGO");
        }

        Dept dept40 = em.find(Dept.class, 40);
        if(dept40 != null) {
            dept40.setDname("OPERATIONS");
            dept40.setLoc("BOSTON");
        }

        em.getTransaction().commit();

    }



}
