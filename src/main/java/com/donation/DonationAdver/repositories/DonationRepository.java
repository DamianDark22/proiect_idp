package com.donation.DonationAdver.repositories;

import com.donation.DonationAdver.models.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DonationRepository extends MongoRepository<Donation, UUID> {
}
