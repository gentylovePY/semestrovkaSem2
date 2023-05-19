package itis.giniyatov.repos;

import itis.giniyatov.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserActivityRepository extends JpaRepository<User, Long> {

    @Query("select p from User p where p.active = true ")
    List<User> findMySuperPosts(String title, long id);
}