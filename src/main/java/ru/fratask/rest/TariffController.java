package ru.fratask.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.fratask.model.dto.TariffDto;
import ru.fratask.service.ScooterService;
import ru.fratask.service.TariffService;

@Controller
@RequestMapping(TariffController.BASE_MAPPING)
public class TariffController {

    protected final static String BASE_MAPPING = "/tariff/v1";
    private final static String ADD_MAPPING = "/add";
    private final static String UPDATE_MAPPING = "/update";
    private final static String GET_MAPPING = "/{id}";

    @Autowired
    private TariffService service;

    @PostMapping(ADD_MAPPING)
    public ResponseEntity<?> add(@RequestBody TariffDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }


    @PutMapping(UPDATE_MAPPING)
    public ResponseEntity<?> update(@RequestBody TariffDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(GET_MAPPING)
    public ResponseEntity<?> getById(@RequestBody Long id) {
        return ResponseEntity.ok(service.getTariffById(id));
    }
}
