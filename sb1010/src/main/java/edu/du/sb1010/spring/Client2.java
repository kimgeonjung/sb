package edu.du.sb1010.spring;

public class Client2 {

    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    public void send(){
        System.out.println("Client2.send() to "+host);
    }

    public void close() throws Exception {
        System.out.println("Client2.close() called");
    }

    public void connect() throws Exception {
        System.out.println("Client2.connect() called");
    }
}
