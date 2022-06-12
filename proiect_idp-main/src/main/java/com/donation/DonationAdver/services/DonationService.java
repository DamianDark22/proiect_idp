package com.donation.DonationAdver.services;

import com.donation.DonationAdver.dtos.CreateDonationDTO;
import com.donation.DonationAdver.models.Donation;
import com.donation.DonationAdver.models.User;
import com.donation.DonationAdver.repositories.DonationRepository;
import com.donation.DonationAdver.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DonationService {

    private static final Logger logger = LoggerFactory.getLogger(DonationService.class);

    private DonationRepository donationRepository;

    private UserRepository userRepository;

    public DonationService(DonationRepository donationRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }

    public List<Donation> getAllDonations() {
        return this.donationRepository.findAll();
    }

    public Donation getDonation(String donationId) throws Exception {
        Optional<Donation> donation = this.donationRepository.findById(UUID.fromString(donationId));

        if (!donation.isPresent()) {
            logger.error("Donation doesn't exist");
            throw new Exception("Donation doesn't exists");
        }

        return donation.get();
    }

    public void bidDonation(UUID donationId, UUID userId) throws Exception {
        Optional<User> user = this.userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new Exception("Invalid user");
        }

        Optional<Donation> donation = this.donationRepository.findById(donationId);

        if (!donation.isPresent()) {
            logger.error("Donation doesn't exist");
            throw new Exception("Donation doesn't exists");
        }

        donation.get().setStatus("Evaluation");
        donation.get().setUserIdTo(userId);
        donation.get().setUserNameTo(user.get().getCompanyName());
        this.donationRepository.save(donation.get());
    }


    public void acceptDonation(UUID donationId, UUID userId) throws Exception {
        Optional<Donation> donation = this.donationRepository.findById(donationId);

        if (!donation.isPresent()) {
            logger.error("Donation doesn't exist");
            throw new Exception("Donation doesn't exists");
        }

        if (!donation.get().getUserIdFrom().toString().equals(userId.toString())) {
            throw new Exception("You can't accept this donation");
        }

        donation.get().setStatus("Closed");
        this.donationRepository.save(donation.get());
    }

    public Donation createDonation(ModelMapper mapper, Object dto) {
        Donation donation = mapper.map(dto, Donation.class);
        donation.setDonationId(UUID.randomUUID());
        donation.setStatus("Waiting for approval");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        donation.setCreationTimestamp(timestamp);
        donation.setUpdatedTimestamp(timestamp);
        this.donationRepository.save(donation);
        return donation;
    }

    public void deleteDonation(String donationId) throws Exception {
        Optional<Donation> donation = this.donationRepository.findById(UUID.fromString(donationId));

        if (!donation.isPresent()) {
            logger.error("Donation doesn't exist");
            throw new Exception("Donation doesn't exists");
        }

        this.donationRepository.delete(donation.get());
    }
}
