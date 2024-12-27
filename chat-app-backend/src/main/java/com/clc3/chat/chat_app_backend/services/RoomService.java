package com.clc3.chat.chat_app_backend.services;

import com.clc3.chat.chat_app_backend.entities.Room;
import com.clc3.chat.chat_app_backend.repositories.RoomRepositories;

public class RoomService {

    private final RoomRepositories roomRepositories;

    public RoomService(RoomRepositories roomRepositories) {
        this.roomRepositories = roomRepositories;
    }

    // check if roomId already exists or not
    public boolean checkByRoomId(String roomId){
        return roomRepositories.findByRoomId(roomId)!=null;
    }

    // create Room
    public Room createRoom(String roomId){

             Room  room = new Room();
             room.setId(roomId);
             return roomRepositories.save(room);
    }

    // get Room
    public Room getRoom(String roomId){
        return roomRepositories.findByRoomId(roomId);
    }

    public void updateRoom(Room room) {
        roomRepositories.save(room);
    }
}
