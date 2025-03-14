package com.example;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost"; // Server address (localhost for local communication)
    private static final int SERVER_PORT = 12345; // Server port number
    private static BufferedReader consoleReader;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            consoleReader = new BufferedReader(new InputStreamReader(System.in)); // Reader to read user input from the console

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Output stream to send messages to the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Input stream to read messages from the server

            // Start a new thread to listen for messages from the server
            new Thread(new MessageListener(in)).start();

            // Get the client's name
            System.out.println("Enter your name:");
            String name = consoleReader.readLine();
            out.println(name); // Send the client's name to the server

            // Read and send messages to the server
            String message;
            while (true) {
                message = consoleReader.readLine(); // Read user input
                if (message.equalsIgnoreCase("exit")) {
                    out.println(message); // Send "exit" to the server to disconnect
                    break;
                }
                out.println(message); // Send the message to the server
            }

            socket.close(); // Close the socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // A thread that listens for messages from the server
    private static class MessageListener implements Runnable {
        private BufferedReader in;

        public MessageListener(BufferedReader in) {
            this.in = in;
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message); // Display received message
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}