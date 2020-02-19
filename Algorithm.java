import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = null;

        int choice = 0;

        do {

            System.out.println("\n\n--MAIN MENU--");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message");
            System.out.println("0. Quit");
            System.out.print("\nEnter your choice: ");

            choice = Integer.parseInt(br.readLine());

            AES aes = new AES();

            aes.createSession();

            switch (choice) {

                case 1: 

                        message = inputData("\nEnter the message to be encrypted: ");

                        String encryptedMessage = aes.encrypt(message);

                        System.out.println("\nYour message after encryption: " + encryptedMessage);

                        break;

                case 2: 

                        message = inputData("\nEnter the message to be decrypted: ");

                        String decryptedMessage = aes.decrypt(message);

                        System.out.println("\nYour message after encryption: " + decryptedMessage);

                        break;

                case 0:

                        break;

                default: 

                        System.out.println("\nInvalid option choosen! Enter again.");
                        break;
            }

        } while(choice != 0);

    }

    public static String inputData(String name) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(name);

        return br.readLine();

    }
}