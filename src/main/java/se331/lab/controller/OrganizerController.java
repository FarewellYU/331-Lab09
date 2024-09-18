package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizerService;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;
    HttpHeaders httpHeaders = new HttpHeaders();

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizers(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page
    ) {
        httpHeaders.set("x-total-count", String.valueOf(organizerService.getOrganizerSize()));
        return ResponseEntity.ok().headers(httpHeaders).body(organizerService.getOrganizers(perPage, page).getContent());
    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(organizerService.getOrganizer(id));
    }

    @PostMapping("organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer) {
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(output);
    }
}
