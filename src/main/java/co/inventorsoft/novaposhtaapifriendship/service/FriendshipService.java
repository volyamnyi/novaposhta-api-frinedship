package co.inventorsoft.novaposhtaapifriendship.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FriendshipService {
    ResponseEntity<?> getCities(String city, String page, String limit);
}
