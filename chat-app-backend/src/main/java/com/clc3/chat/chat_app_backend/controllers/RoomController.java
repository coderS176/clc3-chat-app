package com.clc3.chat.chat_app_backend.controllers;

import com.clc3.chat.chat_app_backend.entities.Room;
import com.clc3.chat.chat_app_backend.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        if(roomService.checkByRoomId(roomId)){
            return  ResponseEntity.badRequest().body("Room Already Exist");
        }
        else{
            return new ResponseEntity<>(roomService.createRoom(roomId), HttpStatus.CREATED);
        }
    }

    // get room
    @GetMapping("/{roomId}")
    public ResponseEntity<?>  joinRoom(@PathVariable String roomId){
        if(roomService.checkByRoomId(roomId)){
           return new ResponseEntity<>(roomService.getRoom(roomId),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Room Not Found!",HttpStatus.BAD_REQUEST);
        }
    }


    // get messages
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<?> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0",required = false) int page,
            @RequestParam(value = "size",defaultValue = "10",required = false) int size
    ){
        Room room = roomService.getRoom(roomId);
        if(room==null){
            return new ResponseEntity<>("Room not available!",HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(room.getMessages(),HttpStatus.OK);
        }
    }

}
