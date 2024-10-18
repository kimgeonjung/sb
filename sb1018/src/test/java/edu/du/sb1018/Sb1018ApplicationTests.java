package edu.du.sb1018;

import edu.du.sb1018.entity.Dept;
import edu.du.sb1018.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;

@SpringBootTest
class Sb1018ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    @Test
    void 영속성테스트_find() {
        // 트랜젝션 시작
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Dept dept = em.find(Dept.class, 10);
//        dept.setDname("서울");
        System.out.println(dept);
        transaction.commit();
    }

    @Test
    void 영속성테스트_merge() {
        // 트랜젝션 시작
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Dept dept = em.find(Dept.class, 10);
        dept.setDname("성남");
        System.out.println(dept);
        em.detach(dept);
        em.merge(dept);
        transaction.commit();
    }

    @Test
    void 영속성테스트_persist() {
        // 트랜젝션 시작
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 저장할 객체 생성
        Dept newDept = new Dept();
        newDept.setDeptno(50);
        newDept.setDname("연구소");
        newDept.setLoc("서울");

        // 엔티티를 데이터베이스에 저장
        em.persist(newDept); // persist = insert

        // 트랜젝션 커밋
        em.getTransaction().commit();
    }

    @Test
    void 영속성테스트_remove() {
        // 트랜젝션 시작
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Dept dept = em.find(Dept.class, 50);
        System.out.println(dept);
        em.remove(dept); // remove = delete

        em.getTransaction().commit();
    }

    @Test
    void 테스트_원래대로돌리기() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Dept dept = em.find(Dept.class, 10);
        System.out.println(dept);
        dept.setDname("ACCOUNTING");
        em.getTransaction().commit();
    }

    @Test
    void DEPT_createQuery_테스트() {
        Dept dept = em.find(Dept.class, 10);
        System.out.println(dept);
        System.out.println("------------------------------------------------");
        TypedQuery<Dept> query = em.createQuery("select d from Dept d", Dept.class);
        List<Dept> depts = query.getResultList();
        for(Dept d : depts) {
            System.out.println(d);
        }
    }

    @Test
    void EMP_createQuery_테스트(){
        Emp emp = em.find(Emp.class, 7839);
        System.out.println(emp);
        System.out.println("------------------------------------------------");
        TypedQuery<Emp> query = em.createQuery("select d from Emp d", Emp.class);
        List<Emp> emps = query.getResultList();
        for(Emp e : emps) {
            System.out.println(e);
        }
    }

    @Test
    void DEPT_createQuery_영속성테스트(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("------------------------------------------------");
        TypedQuery<Dept> query = em.createQuery("select d from Dept d", Dept.class);
        List<Dept> depts = query.getResultList();
        for(Dept d : depts) {
            System.out.println(d);
        }
        System.out.println(depts.get(0).getLoc());
        depts.get(0).setLoc("서울");
        em.getTransaction().commit();
    }

    @Test
    void DEPT_createQuery_테스트2() {
        String jpql = "select d from Dept d where d.dname = :deptName";
        TypedQuery<Dept> query = em.createQuery(jpql, Dept.class);
        query.setParameter("deptName", "ACCOUNTING");
        List<Dept> deptList = query.getResultList();
        Dept dept = deptList.get(0);
        System.out.println(deptList.get(0).getLoc());

        String jpql2 = "select e from Emp e where e.deptno = :deptNo";
        TypedQuery<Emp> query2 = em.createQuery(jpql2, Emp.class);
        query2.setParameter("deptNo", dept.getDeptno());
        List<Emp> empList = query2.getResultList();
        for(Emp e : empList) {
            System.out.println(e);
        }
    }
}
