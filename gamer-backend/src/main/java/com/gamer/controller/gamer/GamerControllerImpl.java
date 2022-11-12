package com.gamer.controller.gamer;

import com.gamer.api.Gamer;
import com.gamer.api.GamerCriteria;
import com.gamer.api.gamer.*;
import com.gamer.service.GamerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/gamer")
public class GamerControllerImpl implements GamerController {

    private static final Logger log = LoggerFactory.getLogger(GamerControllerImpl.class);

    private final GamerService gamerService;

    @Autowired
    GamerControllerImpl(final GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @PostMapping
    public ResponseEntity<CreateGamerResponse> createGamer(@RequestBody final CreateGamerRequest createGamerRequest) {
        log.info("createGamer {}" , createGamerRequest);

        final Gamer gamer = GamerConverter.toGamer(createGamerRequest);
        final Gamer createResponse = gamerService.createGamer(gamer);

        final CreateGamerResponse response = new CreateGamerResponse(createResponse.getId(), Boolean.TRUE);

        log.info("Response: {}" , response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path="/{gamerId}")
    public ResponseEntity<RetrieveGamerResponse> retrieveGamer(@PathVariable(name = "gamerId") String gamerId) {
        log.info("retrieveGamer {} ", gamerId);

        final Gamer gamer = gamerService.retrieveGamer(gamerId);
        final RetrieveGamerResponse retrieveGamerResponse = GamerConverter.toRetrieveGamerResponse(gamer);

        log.info("retrieveGamer {}" , retrieveGamerResponse);
        return new ResponseEntity<>(retrieveGamerResponse, HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<RetrieveGamerResponse>> retrieveAllGamers() {
        log.info("retrieveAllGamers");

        final List<Gamer> gamers = gamerService.retrieveAllGamers();
        final List<RetrieveGamerResponse> retrieveAllGamersResponse = GamerConverter.toRetrieveGamerResponse(gamers);

        log.info("retrieveAllGamers {}" , retrieveAllGamersResponse);
        return new ResponseEntity<>(retrieveAllGamersResponse, HttpStatus.OK);
    }

    @PutMapping(path="/update")
    public ResponseEntity<UpdateGamerResponse> updateGamer(@RequestPart(name = "updateGamerRequest") UpdateGamerRequest updateGamerRequest, @RequestPart(name="profileImage") MultipartFile profileImage) {
        log.info("updateGamer {}", updateGamerRequest);


        final UpdateGamerResponse updateGamerResponse = new UpdateGamerResponse(null, false);

        final Gamer gamer = GamerConverter.toGamer(updateGamerRequest);
        final Gamer gamerResponse = gamerService.updateGamer(gamer);
        updateGamerResponse.setId(gamerResponse.getId());
        updateGamerResponse.setSuccess(true);

        log.info("updateGamer {}", updateGamerResponse);
        return new ResponseEntity<>(updateGamerResponse, updateGamerResponse.getSuccess()? HttpStatus.OK: HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path="{gamerId}")
    public void archiveGamer(@PathVariable("gamerId") String gamerId) {
        log.info("archiveGamer {} ", gamerId);

        gamerService.archiveGamer(gamerId);

        log.info("archiveGamer  ");
    }

    @GetMapping(path="/emailExists")
    public ResponseEntity<Boolean> emailExists(@RequestParam("emailAddress") final String emailAddress) {
        log.info("emailExists {}", emailAddress);

        final Boolean emailExists = gamerService.emailExists(emailAddress);

        log.info("emailExists {}" , emailExists);

        return new ResponseEntity<>(emailExists, HttpStatus.OK);
    }

    @PostMapping(path="/find")
    public ResponseEntity<List<RetrieveGamerResponse>> findGamer(@RequestBody final FindGamerRequest findGamerRequest) {
        log.info("findGamer {}" , findGamerRequest);

        final GamerCriteria gamerCriteria = GamerConverter.toGamerCriteria(findGamerRequest);
        final List<Gamer> gamers = gamerService.findGamers(gamerCriteria);
        final List<RetrieveGamerResponse> retrieveAllGamersResponse = GamerConverter.toRetrieveGamerResponse(gamers);

        log.info("retrieveAllGamers {}" , retrieveAllGamersResponse);

        return new ResponseEntity<>(retrieveAllGamersResponse, HttpStatus.OK);
    }


}
