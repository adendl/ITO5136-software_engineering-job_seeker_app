package controller;

import model.User;


public class SendMessageController {
    NavigationController navigationController;
    User user;
    //TODO: this constructor should take in a user
    public SendMessageController(NavigationController controller, User user){
        this.navigationController = controller;
        this.user = user;
    }

    public void doMessageSend(){

    }
}
