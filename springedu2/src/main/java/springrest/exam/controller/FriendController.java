package springrest.exam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendRepository friendRepository;

//    List<Friend> friendList = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Friend>> friendAll() {
        return new ResponseEntity<>(friendRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{friendId}")
    public ResponseEntity friendById(@PathVariable("friendId") int friendId) {
        try {
            Friend friend = friendRepository.findById(friendId).get();
            return new ResponseEntity(friend, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(Map.of("BAD_ID", friendId), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/name")
    public ResponseEntity friendByName(@RequestParam String fname) {
        try {
            List<Friend> friendList = friendRepository.findByfname(fname);
            return new ResponseEntity<>(friendList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(Map.of("BAD_NAME", fname), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity insertFriend(@RequestBody Friend friend) {
        try {
            return new ResponseEntity(friendRepository.save(friend), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("삽입도중 에러 발생", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFriend(@PathVariable int id, @RequestBody Friend friend) {
        try {
            Friend friendById = friendRepository.findById(id).get();
            System.out.println(friendById.toString());
            friendById.setFname(friend.getFname());
            friendById.setFage(friend.getFage());
            friendRepository.save(friendById);
            return new ResponseEntity(HttpStatus.RESET_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFriend(@PathVariable int id) {
        try {
            friendRepository.delete(friendRepository.findById(id).get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
