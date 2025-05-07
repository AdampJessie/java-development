package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test

    public void checkIn_RegularCheckIn_RoomIsOccupiedANDDirty() {
        //Arrange
        Room testRoom = new Room(2, 50);
        //Act
        testRoom.checkIn();
        //Assert
        boolean occupiedAndDirty = (testRoom.isDirty() || testRoom.isOccupied());
        assertTrue(occupiedAndDirty);
    }

    public void checkIn_DirtyCheckIn_UserDeniedCheckIn() {
        //Arrange
        Room testRoom = new Room(2, 50);


        //Act

        //Assert

    }

    @Test
    public void checkOut_RegularCheckOut_RoomIsNOTOccupied() {
        //Arrange
        Room testRoom = new Room(2, 50);
        testRoom.checkIn();
        //Act
        testRoom.checkout();
        //Assert
        boolean isOccupied = testRoom.isOccupied();
        assertFalse(isOccupied);

    }


}