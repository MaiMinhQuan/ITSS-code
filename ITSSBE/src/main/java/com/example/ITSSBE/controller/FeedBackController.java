//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.FeedBackDTO;
import com.example.ITSSBE.entity.User;
import com.example.ITSSBE.service.IFeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/feedback"})
@CrossOrigin
public class FeedBackController {
    @Autowired
    private IFeedbackService feedBackService;

    public FeedBackController() {
    }

    @GetMapping({"/"})
    public ResponseEntity<List<FeedBackDTO>> getAllFeedBack() {
        List<FeedBackDTO> feedBackList = this.feedBackService.getAllFeedBack();
        return ResponseEntity.ok(feedBackList);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<FeedBackDTO> getFeedBackById(@PathVariable int id) {
        FeedBackDTO feedBack = this.feedBackService.getFeedBack(id);
        return feedBack == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(feedBack);
    }

    @GetMapping({"/user/{userId}"})
    public ResponseEntity<List<FeedBackDTO>> getFeedBackByUser(@PathVariable int userId) {
        User user = new User();
        user.setId(userId);
        List<FeedBackDTO> feedBackList = this.feedBackService.getFromUser(user);
        return ResponseEntity.ok(feedBackList);
    }

    @PostMapping({"/"})
    public ResponseEntity<FeedBackDTO> addFeedBack(@RequestBody FeedBackDTO feedBackDTO) {
        FeedBackDTO newFeedBack = this.feedBackService.addFeedBack(feedBackDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFeedBack);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<FeedBackDTO> changeFeedBack(@RequestBody FeedBackDTO feedBackDTO, @PathVariable int id) {
        FeedBackDTO updatedFeedBack = this.feedBackService.changeFeedBack(feedBackDTO, id);
        return updatedFeedBack == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedFeedBack);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteFeedBack(@PathVariable int id) {
        this.feedBackService.deleteFeedBack(id);
        return ResponseEntity.noContent().build();
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.dto.FeedBackDTO;
//import com.example.ITSSBE.entity.User;
//import com.example.ITSSBE.service.IFeedbackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/feedback")
//@CrossOrigin
//public class FeedBackController {
//
//    @Autowired
//    private IFeedbackService feedBackService;
//
//    @GetMapping("/")
//    public ResponseEntity<List<FeedBackDTO>> getAllFeedBack() {
//        List<FeedBackDTO> feedBackList = feedBackService.getAllFeedBack();
//        return ResponseEntity.ok(feedBackList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FeedBackDTO> getFeedBackById(@PathVariable int id) {
//        FeedBackDTO feedBack = feedBackService.getFeedBack(id);
//        if (feedBack == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(feedBack);
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<FeedBackDTO>> getFeedBackByUser(@PathVariable int userId) {
//        User user = new User();
//        user.setId(userId);
//        List<FeedBackDTO> feedBackList = feedBackService.getFromUser(user);
//        return ResponseEntity.ok(feedBackList);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<FeedBackDTO> addFeedBack(@RequestBody FeedBackDTO feedBackDTO) {
//        FeedBackDTO newFeedBack = feedBackService.addFeedBack(feedBackDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newFeedBack);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<FeedBackDTO> changeFeedBack(@RequestBody FeedBackDTO feedBackDTO, @PathVariable int id) {
//        FeedBackDTO updatedFeedBack = feedBackService.changeFeedBack(feedBackDTO, id);
//        if (updatedFeedBack == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedFeedBack);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFeedBack(@PathVariable int id) {
//        feedBackService.deleteFeedBack(id);
//        return ResponseEntity.noContent().build();
//    }
//}
