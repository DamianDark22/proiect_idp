package com.donation.DonationAdver.services;

import com.donation.DonationAdver.dtos.LoadFile;
import com.donation.DonationAdver.models.User;
import com.donation.DonationAdver.repositories.UserRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User creatUser(ModelMapper mapper, Object dto) {
        User user = mapper.map(dto, User.class);
        user.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
        user.setStatus("Waiting for approve");
        return user;
    }

    public void uploadFile(UUID userId, MultipartFile file) throws Exception {
        LoadFile loadFile = new LoadFile();
        loadFile.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        loadFile.setFileSize(String.valueOf(file.getSize()));
        loadFile.setFileType(file.getContentType());
        loadFile.setFilename(file.getName());
        Optional<User> user = this.userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new Exception("Invalid user");
        }
        user.get().setFile(loadFile);
        this.userRepository.save(user.get());
    }

    public String getFile(UUID userId) throws Exception {
        Optional<User> user = this.userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new Exception("Invalid user");
        }
        return Base64.getEncoder().encodeToString(user.get().getFile().getFile().getData());
    }

    public User getUser(UUID userId) {
        return this.userRepository.findById(userId).get();
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
