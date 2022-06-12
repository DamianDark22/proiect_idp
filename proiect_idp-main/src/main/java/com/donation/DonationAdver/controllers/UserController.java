package com.donation.DonationAdver.controllers;

import com.donation.DonationAdver.dtos.CreateUserDTO;
import com.donation.DonationAdver.models.Donation;
import com.donation.DonationAdver.models.User;
import com.donation.DonationAdver.services.DonationService;
import com.donation.DonationAdver.services.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    private ModelMapper mapper;

    public UserController(ModelMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity createUser(@RequestBody() CreateUserDTO createUserDTO, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            User user = this.userService.creatUser(mapper, createUserDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("user/file")
    public ResponseEntity uploadUserFile(@RequestParam() MultipartFile file,@RequestParam() String userId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            this.userService.uploadFile(UUID.fromString(userId), file);
            return new ResponseEntity<>("File uploaded", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("user/file")
    public ResponseEntity getUserFile(@RequestParam() String userId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            String fileContent = this.userService.getFile(UUID.fromString(userId));
            return new ResponseEntity<>(fileContent, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("user/{userId}")
    public ResponseEntity getUserById(@PathVariable() String userId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            User user = this.userService.getUser(UUID.fromString(userId));
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("users")
    public ResponseEntity getUsers(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            List<User> users = this.userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
