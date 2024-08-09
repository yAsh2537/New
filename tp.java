import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tp {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server listening on port 12345");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection from " + clientSocket.getInetAddress());

            String message = "Hello, this is a message from the server!";
            int shift = 3; // Caesar Cipher shift value

            String encryptedMessage = caesarCipher(message, shift);

            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(encryptedMessage.getBytes());

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}


// import java.io.IOException;
// import java.io.InputStream;
// import java.net.Socket;

// public class tp {
//     public static void main(String[] args) {
//         try {
//             Socket socket = new Socket("127.0.0.1", 12345);

//             InputStream inputStream = socket.getInputStream();
//             byte[] buffer = new byte[1024];
//             int bytesRead = inputStream.read(buffer);
//             String encryptedMessage = new String(buffer, 0, bytesRead);

//             int rails = 3; // Number of rails in the Rail Fence Cipher

//             String decryptedMessage = railFenceCipherDecrypt(encryptedMessage, rails);
//             System.out.println("Decrypted Message: " + decryptedMessage);

//             socket.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static String railFenceCipherDecrypt(String text, int rails) {
//         StringBuilder[] fences = new StringBuilder[rails];
//         for (int i = 0; i < rails; i++) {
//             fences[i] = new StringBuilder();
//         }

//         int rail = 0;
//         boolean down = true;
//         int index = 0;

//         while (index < text.length()) {
//             fences[rail].append(text.charAt(index++));

//             if (rail == rails - 1) {
//                 down = false;
//             } else if (rail == 0) {
//                 down = true;
//             }

//             rail += down ? 1 : -1;
//         }

//         StringBuilder result = new StringBuilder();
//         for (int i = 0; i < rails; i++) {
//             result.append(fences[i]);
//         }

//         return result.toString();
//     }
// }
