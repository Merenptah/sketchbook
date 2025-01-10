package org.example;

import org.openapitools.api.RocketsApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketsController implements RocketsApi {

    @Override
    public ResponseEntity<String> _rocketsRocketNamelaunchPost(String rocketName) throws Exception {
        System.out.println("Launching rocket: " + rocketName);
        return new ResponseEntity<>(String.format("Rocket '%s' launched successfully!", rocketName), HttpStatus.OK);
    }
}