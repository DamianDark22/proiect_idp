package com.donation.DonationAdver.models;

import com.donation.DonationAdver.dtos.LoadFile;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Timestamp;
import java.util.UUID;

@Data
@Document
public class Donation {

    @Id
    private UUID donationId;

    private UUID userIdFrom;

    private String userNameFrom;

    private UUID userIdTo;

    private String userNameTo;

    private String status;

    private String type;

    private String name;

    private String contactDetails;

    private String description;

    private LoadFile file;

    private Timestamp creationTimestamp;

    private Timestamp updatedTimestamp;

    public Donation(UUID donationId, UUID userIdFrom, String userNameFrom, UUID userIdTo, String userNameTo,
                    String status, String type, String name, String contactDetails, String description,
                    LoadFile file, Timestamp creationTimestamp, Timestamp updatedTimestamp) {
        this.donationId = donationId;
        this.userIdFrom = userIdFrom;
        this.userNameFrom = userNameFrom;
        this.userIdTo = userIdTo;
        this.userNameTo = userNameTo;
        this.status = status;
        this.type = type;
        this.name = name;
        this.contactDetails = contactDetails;
        this.description = description;
        this.file = file;
        this.creationTimestamp = creationTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public UUID getDonationId() {
        return donationId;
    }

    public void setDonationId(UUID donationId) {
        this.donationId = donationId;
    }

    public LoadFile getFile() {return file;}

    public void setFile(LoadFile file) {this.file = file;}

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

    public UUID getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(UUID userIdTo) {
        this.userIdTo = userIdTo;
    }

    public String getUserNameTo() {
        return userNameTo;
    }

    public void setUserNameTo(String userNameTo) {
        this.userNameTo = userNameTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}
