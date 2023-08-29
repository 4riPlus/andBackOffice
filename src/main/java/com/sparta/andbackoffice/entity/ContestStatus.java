package com.sparta.andbackoffice.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum ContestStatus {
    ONGOING("접수중"),
    UPCOMING("접수예정"),
    CLOSING("마감임박"),
    CLOSED("마감");

    private String displayText;

    private ContestStatus(String displayText){
        this.displayText=displayText;
    }
}


