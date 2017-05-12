package Repository;
import model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "person" , path="person")
public interface PersonRepository extends MongoRepository<Person,String> {
    @RestResource(path="byName")
    List<Person> findByName(@Param("name") String name);
}
