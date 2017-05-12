package rest;
import Repository.PersonRepository;
import model.Message;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonRest {
    @Autowired
    private PersonRepository repository;
    @RequestMapping(value="/Person",method = RequestMethod.POST)
    public ResponseEntity<Message> save(@RequestBody Person person)  {
        Message message = new Message();
        String id = person.getId();
        if (repository.exists(id)) {
            message.setMessage("Person exists");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.save(person);
        message.setMessage("Person was saved succesfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value="/Person",method = RequestMethod.DELETE)
    public ResponseEntity<Message> delete(@RequestBody Person person) {
        Message message = new Message();
        if (!repository.exists(person.getId())) {
            message.setMessage("Person not exist");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message.setMessage("Person was deleted succesfully");
        repository.delete(person);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value="/Person",method = RequestMethod.PUT)
    public ResponseEntity<Message> update(@RequestBody Person person) {
        Message message = new Message();
        String id = person.getId();
        if (!repository.exists(id)) {
            message.setMessage("Person not exist");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.save(person);
        message.setMessage("Person was updated succesfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/People",method = RequestMethod.GET )
    public ResponseEntity<List<Person>> getByName(@RequestParam(value="name",defaultValue="all") String name) {
        List<Person> persons;
        if (name.equals("all")) {
          persons = repository.findAll();
        } else {
            persons = repository.findByName(name);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
