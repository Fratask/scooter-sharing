package ru.fratask.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fratask.model.dto.ScooterDto;
import ru.fratask.service.ScooterService;

@Controller
@RequestMapping(ScooterController.BASE_MAPPING)
public class ScooterController {

    protected final static String BASE_MAPPING = "/scooter/v1";
    private final static String ADD_MAPPING = "/add";
    private final static String UPDATE_MAPPING = "/update";
    private final static String GET_MAPPING = "/{id}";

    @Autowired
    private ScooterService service;

    @PostMapping(ADD_MAPPING)
    public ResponseEntity<?> add(@RequestBody ScooterDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping(UPDATE_MAPPING)
    public ResponseEntity<?> update(@RequestBody ScooterDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(GET_MAPPING)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScooterById(id));
    }
}
