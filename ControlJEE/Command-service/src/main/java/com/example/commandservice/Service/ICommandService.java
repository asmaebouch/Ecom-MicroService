package com.example.commandservice.Service;

import com.example.commandservice.module.Command;

import java.util.List;
import java.util.Optional;

public interface ICommandService {
    List<Command> getAll();
    Command save(Command article);
    void deleteById(Long id);
    Optional<Command> findById(Long id);
    Command update(Command stade);
}
