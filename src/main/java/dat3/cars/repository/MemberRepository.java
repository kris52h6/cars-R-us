package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
    Member findMemberByEmail(String email);
    Member findMemberByFirstName(String name);
    Member findMemberByUsername(String username);
}
