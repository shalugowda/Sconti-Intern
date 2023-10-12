package com.example.demo.Resolver;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
     private UserRepository userRepository;
    public List<User> getAllUser()
    {

        return userRepository.findAll();
    }

    public User getUser(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

public User createUser(String name,String email)
{
    return userRepository.saveUser(name,email);
}
public User updateUser(Long id,String name){
    return userRepository.updatename(id,name);
}

public Boolean deleteUser(Long id){
        if(userRepository.existsById(id)) {
            userRepository.deleteuser(id);
            return true;
        }
        return false;

}
}