package com.donation.DonationAdver.repositories;

import com.donation.DonationAdver.models.Donation;
import com.donation.DonationAdver.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

}
