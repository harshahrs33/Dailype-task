package com.dailpe.application.Services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dailpe.application.Dtos.CreateUser;
import com.dailpe.application.Dtos.DeleteUser;
import com.dailpe.application.Models.User;
import com.dailpe.application.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<String> createUser(CreateUser createUser) {
        User user=new User();

        user.setFullName(createUser.getFullName());
        user.setManagetId(createUser.getManagetId());
        user.setMobileNumber(createUser.getMobileNumber());
        user.setPanNumber(createUser.getPanNumber());
        user.setActive(true);

        Date date=new Date(System.currentTimeMillis());

        user.setCreateAt(date);
        user.setUpdatedAt(date);

        user.setUserId(this.getUuid());

        userRepository.save(user);
        return ResponseEntity.ok().body("User created with id:"+user.getUserId());
    }

    public ResponseEntity<List<User>> getUsers(int pageNumber,int pageSize) {
        Pageable page=PageRequest.of(Math.max(pageNumber-1,0), pageSize);
        List<User> users=userRepository.findAllUsers(page);
        return ResponseEntity.ok().body(users);
    }

    private String getUuid(){
        String uuid=UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    public ResponseEntity<String> deleteUser(DeleteUser deleteUser) {
        
        List<User> users=userRepository.findByUserIdOrMobileNumber(deleteUser.getUserId(),deleteUser.getMobNum());
        if(users==null || users.size()==0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        else if(users.size()==2)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Multipule user found");
        userRepository.delete(users.get(0));
        return ResponseEntity.ok().body("User successfully deleted");
    }
}
