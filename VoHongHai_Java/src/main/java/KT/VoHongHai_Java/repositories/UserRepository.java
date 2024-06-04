package KT.VoHongHai_Java.repositories;

import KT.VoHongHai_Java.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Tìm kiếm người dùng bằng tên người dùng
    List<User> findByUsername(String username);
}
