package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //저장
    public void save(Member member) {
        em.persist(member);
    }
    //조회_단건
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    //조회_다건(jpql 사용)
    public List<Member> findAll(){
       return em.createQuery("select m from Member m" , Member.class).getResultList();
    }
    //조회_이름으로
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name" , Member.class)
                .setParameter("name" , name)
                .getResultList();
    }
}
