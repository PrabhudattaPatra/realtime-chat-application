package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    private static final int PORT = 12345; // The port number for the server to listen on
    private static Set<PrintWriter> clientWriters = new HashSet<>(); // A set to keep track of client writers

    public static void main(String[] args) {
        System.out.println("Server is running...");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start(); // Accept incoming client connections and spawn a new thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ClientHandler class to handle communication with individual clients
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Input stream to receive messages from the client
                out = new PrintWriter(socket.getOutputStream(), true); // Output stream to send messages to the client

                // Ask the client for their name
                out.println("Enter your name:");
                clientName = in.readLine();

                synchronized (clientWriters) {
                    clientWriters.add(out); // Add client writer to the set
                    broadcast(clientName + " has joined the chat."); // Notify others about the new connection
                }

                // Receive and broadcast messages from the client
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        break; // If the message is "exit", disconnect the client
                    }
                    broadcast(clientName + ": " + message); // Broadcast message to all clients
                }

                synchronized (clientWriters) {
                    clientWriters.remove(out); // Remove the client from the set when they exit
                    broadcast(clientName + " has left the chat."); // Notify others that the client left
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close(); // Close the socket
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message); // Send the message to all clients
                }
            }
        }
    }
}