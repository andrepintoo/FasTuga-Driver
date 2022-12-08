package ipleiria.taes.fastugadriver.model.user;

import java.util.ArrayList;

public class UserPasswordModelArray {
    ArrayList<UserModelArray.data> data;

    public ArrayList<UserModelArray.data> getUsers() {
        return data;
    }

        String password;
        String oldpassword;

        public String getPassword() {
            return oldpassword;
        }
        public String getOldPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public void setOldPassword(String oldpassword) {
            this.oldpassword = oldpassword;
        }
}
