package com.example.commandservice.Controller;

import com.example.commandservice.Service.ICommandService;
import com.example.commandservice.module.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/command")
public class CommandController {
    @Autowired
    ICommandService iCommandService;

    @GetMapping
    public ResponseEntity<List<Command>> getAllStades() {
        List<Command> stades = iCommandService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Command> getStadeById(@PathVariable Long id) {
        Optional<Command> stadeOptional = iCommandService.findById(id);

        if (stadeOptional.isPresent()) {
            Command stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Command registreForm(@RequestBody Command stade){
        System.out.println(stade.toString());
        return iCommandService.save(stade);
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        iCommandService.deleteById(id);
    }
    @PutMapping("/updateClient")
    public Command updateStade(@RequestBody Command stade){
        System.out.println(stade.toString());
        return iCommandService.update(stade);
    }
}
