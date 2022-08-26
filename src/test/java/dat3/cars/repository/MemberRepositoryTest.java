package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    static String member1;
    static String member2;
    @BeforeAll
    public static void setupData(@Autowired MemberRepository memberRepository) {
        String passwordUsedByAll = "test12";
        Member m1 = new Member("user", passwordUsedByAll, "eet", "Sørn", "Matisen", "A gade", "København", 2200, true, 1);
        Member m2 = new Member("user5", passwordUsedByAll, "email2", "Jørn", "Snisen", "C gade", "København", 2200, true, 2);

        memberRepository.save(m1);
        memberRepository.save(m2);
        member1 = m1.getUsername();
        member2 = m2.getUsername();
    }

    @Test
    public void testFindByEmail() {
        Member result = memberRepository.findMemberByEmail("eet");
        assertEquals(member1, result.getUsername());

    }

    @Test
    public void testFindMemberByFirstName() {
        Member result = memberRepository.findMemberByFirstName("Sørn");
        assertEquals(member1, result.getUsername());
    }

    @Test
    public void testFindMemberByUsername() {
        Member result = memberRepository.findMemberByUsername("user");
        assertEquals(member1, result.getUsername());

    }



}