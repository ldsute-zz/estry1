package com.ldsute.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldsute.dto.AclRuleList;
import com.ldsute.entities.AclRule;
import com.ldsute.repositories.AclRuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by justin on 2/22/17.
 */
@RestController
@RequestMapping("/aclrules")
class AclRuleController {

    Logger logger = LoggerFactory.getLogger(AclRuleController.class);

    @Autowired
    private final AclRuleRepository aclRuleRepository = null;

    @RequestMapping(method = RequestMethod.GET)
    AclRuleList readAclRules() throws JsonProcessingException {
        logger.info("Getting the acl rules");
        return new AclRuleList(this.aclRuleRepository.findAll());
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