# Real-Time Chat Application

A real-time chat application built with Spring Boot and WebSocket that supports text messages, image sharing, and video sharing.

## Screenshot

![Screenshot 2025-03-14 080705](https://github.com/user-attachments/assets/5bf7b464-1c15-4075-8cf5-bff446a1db25)
![Screenshot 2025-03-14 080717](https://github.com/user-attachments/assets/1cf7b542-3b9d-4890-aeed-31161429432a)


*Screenshot: Chat interface showing real-time messaging and media sharing capabilities*

## Features

- 💬 Real-time messaging
- 🖼️ Image sharing support
- 🎥 Video sharing support
- 👤 User join/leave notifications
- 🌐 Cross-device compatibility
- 📱 Responsive design
- 🔍 Media preview functionality

## Technologies Used

- Backend:
  - Java 17
  - Spring Boot 2.7.0
  - Spring WebSocket
  - STOMP Protocol
  
- Frontend:
  - HTML5
  - CSS3
  - JavaScript


## Prerequisites

Before running this application, make sure you have:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- A modern web browser (Chrome, Firefox, Safari, or Edge)

## Installation & Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd realtime_chat_app
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application:
   - Open your browser and go to: `http://localhost:8081`
   - To access from other devices on the same network, use: `http://<your-ip-address>:8081`

## Usage

1. Enter your name to join the chat
2. Send text messages:
   - Type in the message box
   - Press Enter or click Send

3. Share images:
   - Click the image icon (📷)
   - Select an image file (supported formats: JPG, PNG, GIF)
   - Maximum file size: 8MB

4. Share videos:
   - Click the video icon (🎥)
   - Select a video file (recommended format: MP4)
   - Maximum file size: 8MB

## Media Sharing Guidelines

- **Images**:
  - Supported formats: JPG, PNG, GIF
  - Max file size: 8MB
  - Click on images to preview in full size

- **Videos**:
  - Recommended format: MP4
  - Max file size: 8MB
  - Built-in video player controls

## Configuration

Key application properties (src/main/resources/application.properties):

```properties
server.port=8081
server.address=0.0.0.0
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
spring.websocket.max-text-message-size=10485760
spring.websocket.max-binary-message-size=10485760
```

## Troubleshooting

1. Connection Issues:
   - Ensure the server is running
   - Check if the port 8081 is available
   - Verify you're on the same network for cross-device communication

2. Media Sharing Issues:
   - Ensure file size is under 8MB
   - Use recommended file formats
   - Try refreshing the page if connection is lost

3. Port Already in Use:
   ```bash
   netstat -ano | findstr :8081
   taskkill /PID <PID> /F
   ```

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

