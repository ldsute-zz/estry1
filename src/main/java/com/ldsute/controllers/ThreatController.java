package com.ldsute.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ldsute.dto.ThreatList;
import com.ldsute.repositories.ThreatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by justin on 2/22/17.
 */
@RestController
@RequestMapping("/aclrules")
class ThreatController {

    Logger logger = LoggerFactory.getLogger(ThreatController.class);

    @Autowired
    private final ThreatRepository threatRepository = null;

    @RequestMapping(method = RequestMethod.GET)
    ThreatList readThreats() throws JsonProcessingException {
        logger.info("Getting the threats");
        return new ThreatList(this.threatRepository.findAll());
    }

//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
//        this.validateUser(userId);
//
//        return this.accountRepository
//                .findByUsername(userId)
//                .map(account -> {
//                    Bookmark result = aclRuleRepository.save(new Bookmark(account,
//                            input.uri, input.description));
//
//                    URI location = ServletUriComponentsBuilder
//                            .fromCurrentRequest().path("/{id}")
//                            .buildAndExpand(result.getId()).toUri();
//
//                    return ResponseEntity.created(location).build();
//                })
//                .orElse(ResponseEntity.noContent().build());
//
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}")
//    Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
//        this.validateUser(userId);
//        return this.aclRuleRepository.findOne(bookmarkId);
//    }
}