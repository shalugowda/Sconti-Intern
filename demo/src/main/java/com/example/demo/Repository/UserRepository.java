package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User,Long> {
    @Query("match(u:User) return u")
    List<User> findAll();
    @Query("match(u:User) where id(u)=$id return u")

    Optional<User>findById(Long id);
    @Query("create(u:User{Name:$name,Email:$email}) return u")
    User saveUser(String name,String email);
    @Query("match(u:User) where id(u)=$id set u.Name=$name  return u")
    User updatename(Long id,String name);
    @Query("match(u:User) where id(u)=$id detach delete u")
    Boolean deleteuser(Long id);
}
