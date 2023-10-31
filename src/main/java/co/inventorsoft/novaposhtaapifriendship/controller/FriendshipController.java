package co.inventorsoft.novaposhtaapifriendship.controller;

import co.inventorsoft.novaposhtaapifriendship.service.FriendshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FriendshipController {

    private final FriendshipService friendshipService;

    @GetMapping("/cities")
    public ResponseEntity<?> getCities(@RequestParam(required = false) String city,
                                       @RequestParam(required = false) String limit,
                                       @RequestParam(required = false) String page
    ) {

        return friendshipService.getCities(city,limit, page);
    }
}
