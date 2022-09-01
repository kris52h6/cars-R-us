package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findMemberByEmail(String email);
    Member findMemberByFirstName(String name);
    Member findMemberByUsername(String username);
}
