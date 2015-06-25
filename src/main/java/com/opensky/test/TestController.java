package com.opensky.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<User> index() {

        User u1 = new User();
        u1.setFirstName("John");
        u1.setLastName("Doe");

        User u2 = new User();
        u2.setFirstName("Bob");
        u2.setLastName("Artman");

        User u3 = new User();
        u3.setFirstName("Ganny");
        u3.setLastName("Gunner");

        ArrayList<User> users = new ArrayList<>();

        users.add(u1);
        users.add(u2);
        users.add(u3);

        for (int counter = 0; counter < 1000; counter++) {
            User u = new User();
            u.setFirstName("John now is the time for all good cows to come to the aid of their systems.  Now is the itme for all good cows to come to the aid of their systems.  Now is the itme for all good cows to come to the aid of their systems.  Now is the itme for all good cows to come to the aid of their systems.  Now is the itme for all good cows to come to the aid of their systems." + counter);
            u.setLastName("Doe" + counter);

            u.setJunk(new Junk());
            u.getJunk().setJunkName("SomeRandomJunkName" + counter);
            u.getJunk().setJunkQuantity(counter);

            users.add(u);
        }

        return users;
    }

    class User {
        private String firstName;
        private String lastName;
        private Junk junk;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Junk getJunk() {
            return junk;
        }

        public void setJunk(Junk junk) {
            this.junk = junk;
        }
    }

    class Junk {
        private String junkName;
        private int junkQuantity;

        public String getJunkName() {
            return junkName;
        }

        public void setJunkName(String junkName) {
            this.junkName = junkName;
        }

        public int getJunkQuantity() {
            return junkQuantity;
        }

        public void setJunkQuantity(int junkQuantity) {
            this.junkQuantity = junkQuantity;
        }
    }
}
