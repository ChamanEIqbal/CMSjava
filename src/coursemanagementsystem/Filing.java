package coursemanagementsystem;
import java.io.*;
import java.util.ArrayList;

public class Filing {
    private static final String FILE_USERNAMES = "usernames.txt";
    private static final String FILE_PASSWORDS = "passwords.txt";
    private static final char ENCRYPTION_OFFSET = 1;

    /**
     * Used to add an admin, uses decrypt & OOS / OIS
     * gets ArrayList from file, decrypts it and changes it (adds new admin), encrypts it, then sends it to text files
     * @param username
     * @param password
     * @throws IOException
     * @throws ClassNotFoundException 
     */
public static void addUser(String username, String password) throws IOException, ClassNotFoundException {
File fileUsernames = new File(FILE_USERNAMES);
File filePasswords = new File(FILE_PASSWORDS);

String encryptedUsername = encrypt(username);
String encryptedPassword = encrypt(password);

if (fileUsernames.length() == 0 && filePasswords.length() == 0) {
    // If the files are empty, create new ObjectOutputStream instances
    ObjectOutputStream oosUser = new ObjectOutputStream(new FileOutputStream(FILE_USERNAMES));
    ObjectOutputStream oosPass = new ObjectOutputStream(new FileOutputStream(FILE_PASSWORDS));

    // Create ArrayLists to store usernames and passwords
    ArrayList<String> usernamesList = new ArrayList<>();
    ArrayList<String> passwordsList = new ArrayList<>();

    // Add encryptedUsername as a new item in the usernames ArrayList
    usernamesList.add(encryptedUsername);

    // Add encryptedPassword as a new item in the passwords ArrayList
    passwordsList.add(encryptedPassword);

    // Write the usernames ArrayList to the FILE_USERNAMES file
    oosUser.writeObject(usernamesList);
    oosUser.flush();
    oosUser.close();

    // Write the passwords ArrayList to the FILE_PASSWORDS file
    oosPass.writeObject(passwordsList);
    oosPass.flush();
    oosPass.close();
} 

else {
    // If the files are not empty, read the usernames from the FILE_USERNAMES file
    FileInputStream fis = new FileInputStream(FILE_USERNAMES);
    ObjectInputStream oisUser = new ObjectInputStream(fis);

    // Read the ArrayList of usernames from the file
    Object object = oisUser.readObject();
    if (object instanceof ArrayList) {
        ArrayList<String> usernamesList = (ArrayList<String>) object;

        // Add encryptedUsername as a new item in the usernames ArrayList
        usernamesList.add(encryptedUsername);

        try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(FILE_USERNAMES))) {
            // Rewrite the FILE_USERNAMES file with the updated usernames ArrayList
            objectStream.writeObject(usernamesList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oisUser.close();
        }
    }

    // Read the passwords from the FILE_PASSWORDS file
    ObjectInputStream oisPass = new ObjectInputStream(new FileInputStream(FILE_PASSWORDS));

    // Read the ArrayList of passwords from the file
    Object objectPass = oisPass.readObject();
    if (objectPass instanceof ArrayList) {
        ArrayList<String> passwordsList = (ArrayList<String>) objectPass;

        // Add encryptedPassword as a new item in the passwords ArrayList
        passwordsList.add(encryptedPassword);

        try(ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(FILE_PASSWORDS))) {
            // Rewrite the FILE_PASSWORDS file with the updated passwords ArrayList
            objectStream.writeObject(passwordsList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oisPass.close();
            }
        }
    }
  }
/**
 * gets the required password based on username
 * assumes that in the array list of decrypted users and passwords,the index is the same for a
 * successful login.
 * returns the password at the index where the parameter username matches
 * @param username
 * @return 
 */
   public static String getPassword(String username) {
    File userFile = new File(FILE_USERNAMES);
    File passFile = new File(FILE_PASSWORDS);
    boolean found = false;
    int index = 0;
    ArrayList<String> decryptedUsernames = new ArrayList<>();
    ArrayList<String> decryptedPasswords = new ArrayList<>();
    
    // Check if the files are empty
    if (userFile.length() == 0 || passFile.length() == 0) {
        System.out.println("File is empty, you cannot read.");
    } else {
        try {
            // Read and decrypt usernames
            ObjectInputStream inputStreamUser = new ObjectInputStream(new FileInputStream(FILE_USERNAMES));
            Object objectUser = inputStreamUser.readObject();
            
            if (objectUser instanceof ArrayList) {
                ArrayList<String> encryptedUsernames = (ArrayList) objectUser;
                
                for (String name : encryptedUsernames) {
                    decryptedUsernames.add(decrypt(name));
                }
            }
            
            System.out.println("Decrypted Usernames: ");
            for(String name: decryptedUsernames) {
                System.out.println(name);
            }
            
            
            // Read and decrypt passwords
            ObjectInputStream inputStreamPass = new ObjectInputStream(new FileInputStream(FILE_PASSWORDS));
            Object objectPass = inputStreamPass.readObject();
            
            if (objectPass instanceof ArrayList) {
                ArrayList<String> encryptedPasswords = (ArrayList) objectPass;
                
                for (String pws : encryptedPasswords) {
                    decryptedPasswords.add(decrypt(pws));
                }
            }
            
                        System.out.println("Decrypted Passwords: ");
            for(String name: decryptedPasswords) {
                System.out.println(name);
            }
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Search for the given username in the decrypted usernames list
        for (int i = 0; i < decryptedUsernames.size(); i++) {
            if (decryptedUsernames.get(i).equals(username)) {
                found = true;
                index = i;
                break;
            }
        }
        
        if (found) {
            return decryptedPasswords.get(index);
        } else {
            System.out.println("Error: Did not find username.");
        }
    }
    
    return null;
}

   /**
    * called in main frame
    * @param username
    * @param password
    * @return
    * @throws IOException 
    */
    public static boolean verifyPassword(String username, String password) throws IOException {
        String storedPassword = getPassword(username);
        
        if (storedPassword == null) {
            // If the username does not exist, return false
            return false;
        }


        return storedPassword.equals(password);
    }

  /**
   * encrypts by adding offset
   * @param input
   * @return 
   */
    private static String encrypt(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= ENCRYPTION_OFFSET;
        }
        return new String(chars);
    }

    /**
     * decrypts by subtracting offset
     * @param input
     * @return 
     */
    private static String decrypt(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += ENCRYPTION_OFFSET;
        }
        return new String(chars);
    }
}
