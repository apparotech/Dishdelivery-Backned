package com.socialmore.dishdelivery.service.Impl;

import java.util.Collections;

import org.modelmapper.ModelMapper;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.socialmore.dishdelivery.entity.Admin;
import com.socialmore.dishdelivery.entity.User;
import com.socialmore.dishdelivery.enuk.Role;
import com.socialmore.dishdelivery.payloads.admindto;
import com.socialmore.dishdelivery.repository.AdminRepo;
import com.socialmore.dishdelivery.repository.UserRepository;
import com.socialmore.dishdelivery.service.AdminService;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
@Transactional

public class AdminServiceImpl  implements AdminService{

    private UserRepository userRepository;
    private AdminRepo adminrepo;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public admindto addAdmin(admindto admindto) {
       // throw new UnsupportedOperationException("Not supported yet.");

       if(userRepository.existsByUsername(admindto.getUsername())) {
        log.warn("Username {} already exists", admindto.getUsername());
        throw new IllegalArgumentException("Username already exists.");
       }

/* 
       //User user = new User();
      User user = new User();
      user.setUsername(admindto.getUsername());
      user.setPassword(passwordEncoder.encode(admindto.getPassword()));
      user.setRoles(Collections.singleton(Role.ADMIN));
      User savedUser = userRepository.save(user);
      log.info("Saved User: {}", savedUser);

      Admin admin = new Admin();
      admin.setUser(user);

     // adminrepo.save(admin);
     Admin adminsave = adminrepo.save(admin);


     admindto  reulstadmin  = modelMapper.map(adminsave, admindto.class);
     reulstadmin.setUsername(user.getUsername());
     reulstadmin.setPassword(null);

     return  reulstadmin;



    }
    */

     // Create and save User
     User user = new User();
     user.setUsername(admindto.getUsername());
     user.setPassword(passwordEncoder.encode(admindto.getPassword()));
     user.setRoles(Collections.singleton(Role.ADMIN));
     User savedUser = userRepository.save(user);
     log.info("Saved User: {}", savedUser);
 
     // Create and save Admin
     Admin admin = new Admin();
     admin.setUser(savedUser);
     Admin savedAdmin = adminrepo.save(admin);
     log.info("Saved Admin: {}", savedAdmin);
 
     // Map to DTO
     admindto resultAdmin = modelMapper.map(savedAdmin, admindto.class);
     resultAdmin.setUsername(savedUser.getUsername());
     resultAdmin.setPassword(null);
 
     return resultAdmin;
    
}
}