package jpql;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariaDBatHome");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();




        //삽입 구현
        tx.begin();
        try {
//            Member member = new Member();
////            member.setId(1L);
//            member.setAge(31);
//            member.setUsername("훈영");
//
//            em.persist(member);

            TypedQuery query = em.createQuery("select m from Member as m where m.username = :username", Member.class);
            //이렇게 쿼리를 바인딩하는것도 가능하다.
            query.setParameter("username", "훈영");
            // :이름 방식으로 해도되구 ?1 ?2 이렇게 사용도 가능하지만 순서가 밀릴수있다. 사용자제




            Member singleResult = (Member)query.getSingleResult();
            //이 경우 singleResult의 값도 영속성 컨텍스트에서 관리한다.
            System.out.println(singleResult.toString());



            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //모든 작업은 트랜젝션 안에서 작업해야한다.
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
//        이렇게 구성하는것이 정석적인 모습이다.



    }
}


//jpql의 경우 대소문자를 구분한다.