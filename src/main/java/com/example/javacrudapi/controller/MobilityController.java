package com.example.javacrudapi.controller;

import com.example.javacrudapi.entity.MobilityDTO;
import com.example.javacrudapi.entity.MobilityEntity;
import com.example.javacrudapi.entity.UserEntity;
import com.example.javacrudapi.repository.MobilityRepository;
import com.example.javacrudapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value = "/mobility")
@AllArgsConstructor
public class MobilityController {

    private MobilityRepository mobilityRepository;
    private UserRepository userRepository;

    @GetMapping()
    public Iterable<MobilityEntity> getAllMobilities() {return this.mobilityRepository.findAll();}

    @GetMapping("/{id}")
    public Optional<MobilityEntity> getMobilityById(@PathVariable Long id) {return this.mobilityRepository.findById(id);}

    @GetMapping(value = "/user/{user_id}")
    public Iterable<MobilityEntity> getAllMobilitiesByUserId(@PathVariable Long user_id){
        return this.mobilityRepository.getAllByAuthor_Id(user_id);
    }

    @PostMapping()
    public void postMobility(@RequestBody MobilityDTO mobilityDTO) {
        UserEntity user = this.userRepository.findById(mobilityDTO.user_id).get();

        MobilityEntity mobility = new MobilityEntity();
        mobility.setCity(mobilityDTO.city);
        mobility.setCountry(mobilityDTO.country);
        mobility.setDescription(mobilityDTO.description);
        mobility.setPartner(mobilityDTO.partner);
        mobility.setType(mobilityDTO.type);
        mobility.setTitle(mobilityDTO.title);
        mobility.setStartedOn(mobilityDTO.startedOn);
        mobility.setFinishedOn(mobilityDTO.finishedOn);
        mobility.setAuthor(user);

        this.mobilityRepository.save(mobility);
    }
}
