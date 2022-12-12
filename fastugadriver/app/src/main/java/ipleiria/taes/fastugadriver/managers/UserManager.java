package ipleiria.taes.fastugadriver.managers;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.api.UserService;
import ipleiria.taes.fastugadriver.entities.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserManager {
    private static final UserManager instance = new UserManager();
    private LinkedList<User> users;
    private User userLogged;

    public UserManager() {
        users = new LinkedList<>();
        users.add(new User("PrimeiroNome", "Apelido", "customer_6@mail.pt", "12345678", "912345678",0, 0, 0, 0.0, "AA-00-AA"));
        users.add(new User("PrimeiroNome", "Apelido", "contacto@email.pt", "password", "912345678",0 ,0, 0, 0.0, "AA-00-AA"));
        users.add(new User("PrimeiroNome", "Apelido", "rodrigo.campos@mail.pt", "12345678", "912345678",0, 0, 0, 0.0, "AA-00-AA"));
        users.add(new User("PrimeiroNome", "Apelido", "dsfsdfsdf@mail.pt", "12345678", "912345678",0, 0, 0, 0.0, "AA-00-AA"));
        userLogged = null;
    }

    public static UserManager getManager() {
        return instance;
    }

    public User getUser(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public int getLoggedUserBalance(){
        if(userLogged != null){
            return userLogged.getBalance();
        }
        //If no user is logged, then show 0€
        return 0;
    }


    public boolean licenseExists(String licensePlate) {
        for(User user : users){
            if(user.getLicensePlate().equals(licensePlate)){
                return true;
            }
        }
        return false;
    }

    public boolean logInUser(String email, String password){
        User user = getUser(email);
        if(user == null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    public void logOutUser(){
        userLogged = null;
    }

    public void optOut(){
        deleteUser(userLogged.getEmail());
        userLogged = null;
    }

    public int registerUser(String firstName, String lastName, String email, String password, String phoneNumber, String licensePlate){
        User user = getUser(email);
        Boolean licensePlateExists = licenseExists(licensePlate);

        if(user != null && licensePlateExists){
            return -3;
        }

        if(user != null) {
            return -1;
        }

        if(licensePlateExists){
            return -2;
        }
        user = new User(firstName, lastName, email, password, phoneNumber, 0, 0, 0, 0, licensePlate);
        users.add(user);
        return 0;
    }

    public void setUserLogged(String email){
        if(email.trim().isEmpty()){
            return;
        }
        userLogged = getUser(email);
    }

    public User getUserLogged() {
        return userLogged;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }

    private void deleteUser(String email) {
        // Creates Service
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        Call<ResponseBody> call = service.deleteUser(email);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure : " + t.getMessage());
            }
        });
    }

    public void updateBalance(int earning) {
        if(userLogged != null){
            userLogged.updateBalance(earning);
        }
    }

    public boolean updatePassword(String newPasword) {
        if(userLogged != null){
            userLogged.setPassword(newPasword);
            return true;
        }
        return false;
    }
    public boolean updateName(String firstName, String lastName) {
        if(userLogged != null){
            userLogged.setFirstName(firstName);
            userLogged.setLastName(lastName);
            return true;
        }
        return false;
    }

    public void incrementDeliveries(){
        if(userLogged != null){
            userLogged.incrementDeliveries();
        }
    }

    public void incrementDeliveryTime(LocalDateTime time){
        if(userLogged != null){
            LocalDateTime now = LocalDateTime.now();
            long minutes = ChronoUnit.MINUTES.between(time, now);
            userLogged.incrementDeliveryTime(minutes);
        }
    }

    public void addCustomerServed(int customer_id) {
        if(userLogged != null){
            userLogged.addCustomerServed(customer_id);
        }
    }

    public long getLoggedUserTotalDeliveryTime(){
        if(userLogged != null){
            return userLogged.getTotalDeliveryMinutes();
        }
        return 0;
    }

    public long getLoggedUserAverageDeliveryTime() {
        if(userLogged != null){
            int totalDeliveries = userLogged.getTotalDeliveries();
            if (totalDeliveries==0) {
                return 0;
            }
            return userLogged.getTotalDeliveryMinutes()/totalDeliveries;
        }
        return 0;
    }

    public long getLoggedUserClientsServed() {
        if(userLogged != null){
            return userLogged.getDistinctCustomers();
        }
        return 0;
    }

    public int getLoggedUserTotalDeliveries(){
        if(userLogged != null){
            return userLogged.getTotalDeliveries();
        }
        return 0;
    }

    public void incrementAverageSpeed(double distance, int minutes ) {
        if(userLogged != null){
            if (minutes != 0) {
                userLogged.incrementTotalAverageSpeed(distance / (minutes / 60.0));
            } else {
                userLogged.incrementTotalAverageSpeed(distance / (1 / 60.0));
            }
        }
    }

    public double getLoggedUserAverageSpeed(){
        if(userLogged != null){
            int totalDeliveries = userLogged.getTotalDeliveries();
            if (totalDeliveries==0) {
                return 0;
            }
            return userLogged.getTotalAverageSpeed()/totalDeliveries;
        }
        return 0;
    }
}
