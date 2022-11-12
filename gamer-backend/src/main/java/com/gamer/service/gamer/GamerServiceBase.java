package com.gamer.service.gamer;

import com.gamer.repository.GamerRepository;
import com.gamer.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GamerServiceBase implements GamerService {

    private final GamerRepository gamerRepository;

    @Autowired
    GamerServiceBase(
            GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    public GamerRepository getGamerRepository() {
        return gamerRepository;
    }

}
