package com.bdabek.observer;

public class Main {

    public static void main(String[] args) {
        GroupChat groupChat = new GroupChat();

        Bob bob = new Bob(groupChat);
        Alice alice = new Alice(groupChat);
        Jim jim = new Jim(groupChat);

        bob.writeMessage("Hi! I'm Bob!");
        alice.writeMessage("Hi Bob! Alice here ;)");
        jim.writeMessage("Who added me to this group?!");
        groupChat.removeObserver(jim);
        alice.writeMessage("Someone's mad :D");
    }
}
