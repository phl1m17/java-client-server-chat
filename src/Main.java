
/*
    Author: Phil Clarence Manag
    Student #: 501351456

    Problem Description:
    A lot of messaging apps require cell services and internet access. 
    For this project I am trying to create a lightweight terminal-based messaging application
    that allows users to communicate on the same network system, providing a fast and offline-friendly alternative

    How to Use:
    To test the app you can use 127.0.0.1 to test with localhost.
    First Run 3 versions of the app one will be a server and the other two are the clients.
    The server will require you to enter s
    The clients will require you to enter c, a username, and the an ip address in this case it 
    will be a localhost but will also work if the clients are on the same wifi and enter the server ip address
    If theres already a server instance running I have instructions to stop it
 */

import java.util.Scanner;

public class Main {
    // Create a scanner object that can be reused in other classes
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Ask what mode they are using ie. Server or Client
        while (true) {
            System.out.print("Start as server or client (s/c): ");
            String choice = sc.nextLine();

            // Check
            if (choice.equalsIgnoreCase("s")) {
                new ChatServer(6000).start();
                break;
            } else if (choice.equalsIgnoreCase("c")) {
                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter server IP: ");
                String ip = sc.nextLine();

                new ChatClient(ip, 6000, username).start();
                break;
            } else {
                System.out.println("Not a valid option");
            }
        }
    }
}

// For Localhost: 127.0.0.1
// To run without class files being created in src: javac -d bin src/*.java &&
// java -cp bin Main
// command to kill other existing servers in the port: pkill -9 -f java