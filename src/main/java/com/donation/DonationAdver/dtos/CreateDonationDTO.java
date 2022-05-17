package com.donation.DonationAdver.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public class CreateDonationDTO {

    private UUID userIdFrom;

    private String userNameFrom;

    private String type;

    private String name;

    private String contactDetails;

    private String description;

    public UUID getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(UUID userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
