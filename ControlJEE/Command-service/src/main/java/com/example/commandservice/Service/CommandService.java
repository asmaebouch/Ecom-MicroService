package com.example.commandservice.Service;

import com.example.commandservice.Dao.CommandDAO;
import com.example.commandservice.module.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommandService implements ICommandService{
   @Autowired
    CommandDAO commandDAO;
    @Override
    public List<Command> getAll() {
        return commandDAO.findAll();
    }

    @Override
    public Command save(Command article) {
        return commandDAO.save(article);
    }

    @Override
    public void deleteById(Long id) {
        commandDAO.deleteById(id);
    }

    @Override
    public Optional<Command> findById(Long id) {
        return commandDAO.findById(id);
    }

    @Override
    public Command update(Command stade) {
        Long id = stade.getId();
        Optional<Command> optionalStade = commandDAO.findById(id);

        if (optionalStade.isPresent()) {
            Command existingStade = optionalStade.get();
            existingStade.setDescription(stade.getDescription());
            existingStade.setLibelle(stade.getLibelle());
            existingStade.setPrice(stade.getPrice());
            existingStade.setQuantity(stade.getQuantity());



            return commandDAO.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Command with ID " + id + " does not exist");
            return null;
        }

    }
}
