package com.nickrankin.ca1.CA1.Web.Services.controller;

import com.nickrankin.ca1.CA1.Web.Services.model.Return;
import com.nickrankin.ca1.CA1.Web.Services.repository.ReturnsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnController {
    private final ReturnsRepository repo;

    public ReturnController(ReturnsRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/returns")
    Return newReturn(@RequestBody Return taxreturn) {
        return repo.save(taxreturn);
    }

}
