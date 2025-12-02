🏷️ Java Console Chat Simulator

A simple console-based chat simulator built using Java.
This project demonstrates Object-Oriented Programming concepts including classes, objects, user management, and message handling. It allows users to join a chat session, send messages, and view chat history — all inside the terminal.

🚀 Features

    Add users to the chat

    Send and receive messages

   View complete chat history

   Clean OOP structure (User, Message, ChatRoom)

   Real-time style message simulation

   Beginner-friendly and easy to extend

   No file handling — all data stored in memory


🛠️ Technologies Used

  Java (Core Java)

  OOP concepts: Encapsulation, Classes & Objects

  Console I/O

▶️ How to Run

  Compile the project:

    javac Main.java


  Run the project:

    java Main

🧪 Sample Output
Enter username: Rohith
Welcome Rohith!

1. Send Message
2. View Chat History
3. Exit

Enter option: 1
Type your message: Hello everyone!

[Rohith]: Hello everyone!

📘 Code Snippet
User user = new User("Rohith");
Message msg = new Message(user.getUsername(), "Hello!");
chatRoom.addMessage(msg);

📈 Future Enhancements

Add private messaging

Add GUI using JavaFX or Swing

Add timestamps to messages

Add message storage using files or database

🤝 Contributing

Pull requests are welcome.
If you want to propose a new feature, feel free to open an issue.

👤 Author

Rohith
Java Developer | DSA in C | Beginner Projects
