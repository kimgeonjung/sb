package edu.du.sb1018.service;

import edu.du.sb1018.entity.Emp;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class EmpService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public List<Emp> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Emp> empList = em.createQuery("from Emp", Emp.class).getResultList();
        em.getTransaction().commit();
        return empList;
    }

    public Emp findByEmpno(int empno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Emp emp = em.find(Emp.class, empno);
        em.getTransaction().commit();
        return emp;
    }

    public Emp updateEmp(Emp emp) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Emp employee = em.find(Emp.class, emp.getEmpno());

        employee.setEname(emp.getEname());
        employee.setJob(emp.getJob());
        employee.setMgr(emp.getMgr());
        employee.setHiredate(emp.getHiredate());
        employee.setSal(emp.getSal());
        employee.setComm(emp.getComm());
        employee.setDeptno(emp.getDeptno());

        em.getTransaction().commit();

        return employee;
    }

    public Emp addEmp(Emp emp) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }

    public void deleteEmp(int empno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Emp employee = em.find(Emp.class, empno);
        em.remove(employee);
        em.getTransaction().commit();
    }
}
