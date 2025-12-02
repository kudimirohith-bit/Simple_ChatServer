import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class Message {
    private String sender;
    private String content;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    @Override
    public String toString() {
        return sender + ": " + content;
    }
}

class ChatRoom {
    private List<User> users = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private User activeUser;

    public boolean addUser(String name) {
        if (name.trim().isEmpty()) return false;

        // avoid duplicates
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(name)) return false;
        }

        User newUser = new User(name);
        users.add(newUser);

        // set first user as default active
        if (activeUser == null) activeUser = newUser;

        return true;
    }

    public boolean switchUser(String name) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(name)) {
                activeUser = u;
                return true;
            }
        }
        return false;
    }

    public boolean sendMessage(String content) {
        if (activeUser == null) return false;
        if (content.trim().isEmpty()) return false;

        messages.add(new Message(activeUser.getUsername(), content));
        return true;
    }

    public void showHistory() {
        if (messages.isEmpty()) {
            System.out.println("No messages yet.");
            return;
        }

        System.out.println("----- Chat History -----");
        for (Message m : messages) {
            System.out.println(m);
        }
        System.out.println("-------------------------");
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("Users:");
        for (User u : users) {
            System.out.println("- " + u.getUsername());
        }
    }

    public String getActiveUser() {
        return activeUser != null ? activeUser.getUsername() : "None";
    }
}

public class ChatServer{
    private static Scanner scanner = new Scanner(System.in);
    private static ChatRoom chat = new ChatRoom();

    public static void main(String[] args) {
        System.out.println("=== Simple Chat Simulator ===");

        // default users
        chat.addUser("A");
        chat.addUser("B");

        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sendMessageFlow();
                    break;
                case "2":
                    switchUserFlow();
                    break;
                case "3":
                    chat.showHistory();
                    break;
                case "4":
                    createUserFlow();
                    break;
                case "5":
                    chat.listUsers();
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        System.out.println("Chat ended.");
    }

    private static void showMenu() {
        System.out.println("\nActive User: " + chat.getActiveUser());
        System.out.println("1. Send Message");
        System.out.println("2. Switch User");
        System.out.println("3. View Chat History");
        System.out.println("4. Create New User");
        System.out.println("5. List Users");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    private static void sendMessageFlow() {
        System.out.print("Enter message: ");
        String msg = scanner.nextLine();

        if (!chat.sendMessage(msg)) {
            System.out.println("Error: Message cannot be empty.");
        } else {
            System.out.println("Message sent.");
        }
    }

    private static void switchUserFlow() {
        chat.listUsers();
        System.out.print("Enter username to switch: ");
        String name = scanner.nextLine();

        if (chat.switchUser(name)) {
            System.out.println("Active user switched to: " + name);
        } else {
            System.out.println("User not found!");
        }
    }

    private static void createUserFlow() {
        System.out.print("Enter new username: ");
        String name = scanner.nextLine();

        if (chat.addUser(name)) {
            System.out.println("User '" + name + "' created.");
        } else {
            System.out.println("Invalid or duplicate username.");
        }
    }
}
