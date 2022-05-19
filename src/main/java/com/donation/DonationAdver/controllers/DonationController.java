package com.donation.DonationAdver.controllers;

import com.donation.DonationAdver.dtos.CreateDonationDTO;
import com.donation.DonationAdver.models.Donation;
import com.donation.DonationAdver.services.DonationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
public class DonationController {

    private static final Logger logger = LoggerFactory.getLogger(DonationController.class);

    private DonationService donationService;

    private ModelMapper mapper;

    public DonationController(DonationService donationService, ModelMapper mapper) {
        this.donationService = donationService;
        this.mapper = mapper;
    }

    @PostMapping("donation")
    public ResponseEntity createDonation(@RequestBody() CreateDonationDTO createDonationDTO, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            Donation donations = this.donationService.createDonation(mapper, createDonationDTO);
            return new ResponseEntity<>(donations, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("donation/bid")
    public ResponseEntity bidDonation(@RequestParam() String donationId, @RequestParam() String userId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            this.donationService.bidDonation(UUID.fromString(donationId), UUID.fromString(userId));
            return new ResponseEntity<>("Bided", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("donation/accept")
    public ResponseEntity acceptDonation(@RequestParam() String donationId, @RequestParam() String userId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            this.donationService.acceptDonation(UUID.fromString(donationId), UUID.fromString(userId));
            return new ResponseEntity<>("Donation closed", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("donations")
    public ResponseEntity getAllDonations(HttpServletRequest request){
        try {
            String token = request.getHeader("Authorization");
            List<Donation> donations = this.donationService.getAllDonations();
            return new ResponseEntity<>(donations, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("donation")
    public ResponseEntity getDonation(@RequestParam() String donationId, HttpServletRequest request) throws IOException {
        try {
            String token = request.getHeader("Authorization");
            Donation donation = this.donationService.getDonation(donationId);
            return new ResponseEntity<>(donation, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("donation")
    public ResponseEntity deleteDonation(@RequestParam() String donationId, HttpServletRequest request) throws IOException {
        try {
            String token = request.getHeader("Authorization");
            this.donationService.deleteDonation(donationId);
            return new ResponseEntity<>("Donation Deleted", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error has occurred in donations of DonationController", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
