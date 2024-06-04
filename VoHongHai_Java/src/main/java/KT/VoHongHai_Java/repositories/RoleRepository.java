package KT.VoHongHai_Java.repositories;

import KT.VoHongHai_Java.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Override
    Role save(Role role);
    List<Role> findByRoleName(String roleName);
}
