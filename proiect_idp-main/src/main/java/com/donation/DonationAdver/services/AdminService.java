package com.donation.DonationAdver.services;

import com.donation.DonationAdver.models.Donation;
import com.donation.DonationAdver.models.User;
import com.donation.DonationAdver.repositories.DonationRepository;
import com.donation.DonationAdver.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private DonationRepository donationRepository;

    private UserRepository userRepository;

    public AdminService(DonationRepository donationRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }

    public void acceptDonation(String donationId) throws Exception {
        Optional<Donation> donation = this.donationRepository.findById(UUID.fromString(donationId));

        if (!donation.isPresent()) {
            logger.error("Donation doesn't exist");
            throw new Exception("Donation doesn't exists");
        }

        donation.get().setStatus("Open");
        this.donationRepository.save(donation.get());
    }

    public void acceptUser(String userId) throws Exception {
        Optional<User> user = this.userRepository.findById(UUID.fromString(userId));

        if (!user.isPresent()) {
            logger.error("User doesn't exist");
            throw new Exception("User doesn't exists");
        }

        user.get().setStatus("Active");
        this.userRepository.save(user.get());
    }

}
