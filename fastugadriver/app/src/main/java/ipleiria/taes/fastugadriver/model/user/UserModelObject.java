package ipleiria.taes.fastugadriver.model.user;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class UserModelObject {
    JsonObject data;

    public JsonObject getUser() {
        return data;
    }

    public class data {
        int id;
        String name;
        String email;
        String password;
        String type;
        String photo_url;
        int blocked;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getType() {
            return type;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public int getBlocked() {
            return blocked;
        }
    }
}
