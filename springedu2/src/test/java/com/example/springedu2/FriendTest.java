package com.example.springedu2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(false)
public class FriendTest {

    @Autowired
    FriendRepository friendRepository;

    @Test
    public Friend createFriend() {
        Friend dain = Friend.builder().fname("dain").fage(20).build();
        System.out.println(dain.toString());
        Friend savedDain = friendRepository.save(dain);

//        System.out.println(savedDain);
        assertNotNull(savedDain.getId());
        return savedDain;
    }

    @Test
    public void readFriend() {
        Friend savedDain = createFriend();
        friendRepository.findById(savedDain.getId());
        assertNotNull(savedDain);
        assertEquals("dain",savedDain.getFname());
        assertEquals(20,savedDain.getFage());
    }

    @Test
    public Friend updateFriend() {
        Friend savedDain = createFriend();
        savedDain.setFname("dainee");
        savedDain.setFage(22);
        Friend updatedDain = friendRepository.save(savedDain);
        assertEquals("dainee", updatedDain.getFname());
        assertEquals(22, updatedDain.getFage());
        return updatedDain;
    }

    @Test
    public void deleteFriend() {
        Friend savedDain = createFriend();
        friendRepository.delete(savedDain);
        assertFalse(friendRepository.existsById(savedDain.getId()));
    }

}
