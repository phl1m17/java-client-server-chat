# Java Client–Server Chat Application

## Overview

This project is a client–server chat application developed in Java using socket programming.
The system allows multiple clients to connect to a central server and exchange messages in real time.

The application demonstrates core networking concepts such as client connections, message transmission, concurrent communication, and structured object-oriented design.

---

## Features

### Client–Server Communication

- Multiple clients can connect to a single server
- Messages are transmitted using network sockets
- Real-time communication between users

### Multi-Client Support

- Each client connection is handled independently
- The server can manage multiple users simultaneously

### Message Handling

- Users can send and receive messages
- Messages are forwarded through the server to other clients
- Separate components manage sending and receiving operations

### Object-Oriented Design

- Classes represent users, connections, and message entities
- Clear separation of responsibilities between components

---

## How the System Works

1. The **server** starts and listens for incoming client connections.
2. A **client** connects to the server using its network address and port.
3. Messages sent by one client are received by the server.
4. The server forwards messages to other connected clients.

---

## Running the Application

### Localhost Address

Use the following address when running the server and clients on the same computer:

```id="localhost"
127.0.0.1
```

---

### Compile the Program

To compile the project and place compiled files in the `bin` folder instead of the `src` folder:

```bash id="compile"
javac -d bin src/*.java
```

---

### Run the Program

Start the server:

```bash id="run-server"
java -cp bin Main
```

Then run additional clients in separate terminals using the same command.

You can also compile and run in a single command:

```bash id="compile-run"
javac -d bin src/*.java && java -cp bin Main
```

---

### If the Port Is Already in Use

If the server fails to start because the port is already in use, terminate existing Java processes with:

```bash id="kill-port"
pkill -9 -f java
```

---

## Project Structure

```id="structure"
java-client-server-chat/
│
├── src/
│   ├── ChatServer.java
│   ├── ChatClient.java
│   ├── ClientConnection.java
│   ├── MessageSender.java
│   ├── MessageReceiver.java
│   ├── User.java
│   ├── ChatEntity.java
│   └── Main.java
│
├── bin/
├── README.md
├── LICENSE
└── .gitignore
```

---

## Technologies Used

- Java
- Socket Programming
- Client–Server Architecture
- Object-Oriented Programming (OOP)

---

## Learning Objectives

This project demonstrates:

- Network communication using sockets
- Multi-client server design
- Message handling between processes
- Concurrent communication
- Structured object-oriented programming

---

## Author

Phil Clarence Manag
Java Networking Project
