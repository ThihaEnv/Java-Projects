package com.thiha.API.Project;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/footballclub-names")
public class FootballClubNamesController {

    //temporary data set up as database
    private final List<FootballClubsNames> clubNames = new ArrayList<>(
            List.of(
                    new FootballClubsNames(
                            1,
                            "Manchester United",
                            "Fernandes, Cunha, Mbeumo, Senne Lammens"
                    ),
                    new FootballClubsNames(
                            2,
                            "Manchester City",
                            "Haaland,Donnarumma,Reijnders"
                    ),
                    new FootballClubsNames(
                            3,
                            "Arsenal",
                            "Raya,Gabriel, Saliba"
                    ),
                    new FootballClubsNames(
                            4,
                            "Chelsea",
                            "Enzo,Caicedo,Palmer"
                    ),
                    new FootballClubsNames(
                            5,
                            "Liverpool",
                            "Alisson,Wirtz, Gravenberch"
                    )
            )
    );
    @GetMapping
    public List<FootballClubsNames> getClubNames(){
        return clubNames;
    }
    @PostMapping
    public void addFootballClubs(@RequestBody FootballClubsNames clubName){
        clubNames.add(clubName);
    }

    @PutMapping("/{id}")
    public void updateClubNames(@PathVariable int id,
                             @RequestBody FootballClubsNames updateClubNames)
    {
        for(FootballClubsNames clubName : clubNames){
            if(clubName.getId() == id){
                clubName.setPlayerNames(updateClubNames.getPlayerNames());
                clubName.setClubName(updateClubNames.getClubName());
                break;
            }
        }
    }
    @DeleteMapping("/{id}")
    public void deleteFootballClubs(@PathVariable int id){
        clubNames.removeIf(clubName -> clubName.getId() == id);
    }

}
