package com.example.commandservice.Dao;

import com.example.commandservice.module.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "commmands", path = "command")

public interface CommandDAO extends JpaRepository<Command,Long> {
}
