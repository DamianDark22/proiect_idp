package com.donation.DonationAdver.controllers;

import com.donation.DonationAdver.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    //TODO check auth
    @PutMapping("accept_donation")
    public ResponseEntity acceptDonation(@RequestParam() String donationId, HttpServletRequest request) throws IOException {
        try {
            String token = request.getHeader("Authorization");
            this.adminService.acceptDonation(donationId);
            return new ResponseEntity<>("Donation Accepted", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of AdminController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("accept_user")
    public ResponseEntity acceptUser(@RequestParam() String userId, HttpServletRequest request) throws IOException {
        try {
            String token = request.getHeader("Authorization");
            this.adminService.acceptUser(userId);
            return new ResponseEntity<>("User Accepted", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in accounts of AdminController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
