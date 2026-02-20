package com.thiha.API.Project;
import java.util.Objects;
public class FootballClubsNames {

    //declare variables
    private Integer id;
    private String clubName;
    private String playerNames;

//    public FootballClubsNames {
//
//    }
    //constructors
    public FootballClubsNames(Integer id, String clubName, String playerNames) {
        this.id = id;
        this.clubName = clubName;
        this.playerNames = playerNames;
    }

    // getter and setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(String playerNames) {
        this.playerNames = playerNames;
    }

    // equal and hash code for data identification

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClubsNames that = (FootballClubsNames) o;
        return Objects.equals(id, that.id) && Objects.equals(clubName, that.clubName) && Objects.equals(playerNames, that.playerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clubName, playerNames);
    }
}
