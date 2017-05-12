package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by developer on 27/09/16.
 */
@Document(collection = "Person")
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
    private String country;
    private String adress;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person client = (Person) o;

        if (!getName().equals(client.getName())) return false;
        return email.equals(client.email);

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
