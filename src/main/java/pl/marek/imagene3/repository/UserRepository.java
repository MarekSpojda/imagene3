package pl.marek.imagene3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.marek.imagene3.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.userid=?1")
    User findByUserid(String userid);
}
