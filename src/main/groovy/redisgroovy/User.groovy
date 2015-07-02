package redisgroovy

import com.fasterxml.jackson.annotation.JsonAutoDetect
import groovy.transform.ToString

@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User {
    private String name
    private String email

    public void setName(String name) { this.name = name }

    public String getName() { name }

    public void setEmail(String email) { this.email = email }

    public String getEmail() { email }

    public String toString() { name + " " + email }
}