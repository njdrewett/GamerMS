package com.gamer.controller.gamer;

import com.gamer.api.Gamer;
import com.gamer.api.GamerCriteria;
import com.gamer.api.gamer.CreateGamerRequest;
import com.gamer.api.gamer.FindGamerRequest;
import com.gamer.api.gamer.RetrieveGamerResponse;
import com.gamer.api.gamer.UpdateGamerRequest;

import java.util.List;
import java.util.stream.Collectors;

public class GamerConverter {

    public static Gamer toGamer(final CreateGamerRequest createGamerRequest) {
        return new Gamer(null, createGamerRequest.getDisplayName(), createGamerRequest.getDateOfBirth(),
                createGamerRequest.getEmailAddress(),createGamerRequest.getTelephoneNumber(),
                createGamerRequest.getIntroductionText());
    }

    public static Gamer toGamer(final UpdateGamerRequest updateGamerRequest) {
        return new Gamer(updateGamerRequest.getId(), updateGamerRequest.getDisplayName(),
                updateGamerRequest.getDateOfBirth(),updateGamerRequest.getEmailAddress(),
                updateGamerRequest.getTelephoneNumber(),
                updateGamerRequest.getIntroductionText());
    }

    public static RetrieveGamerResponse toRetrieveGamerResponse(final Gamer gamer) {
        return new RetrieveGamerResponse(gamer.getId(), gamer.getDisplayName(), gamer.getDateOfBirth(),
                gamer.getEmailAddress(),gamer.getTelephoneNumber(),gamer.getIntroductionText());
    }

    public static List<RetrieveGamerResponse> toRetrieveGamerResponse(final List<Gamer> gamers) {
       return gamers.stream().map(GamerConverter::toRetrieveGamerResponse).collect(Collectors.toList());
    }

    public static GamerCriteria toGamerCriteria(final FindGamerRequest findGamerRequest) {
        return new GamerCriteria(findGamerRequest.getId(),findGamerRequest.getDisplayName(),findGamerRequest.getDateOfBirth(),
                findGamerRequest.getEmailAddress(), findGamerRequest.getTelephoneNumber(),findGamerRequest.getExcludeId());
    }

}
