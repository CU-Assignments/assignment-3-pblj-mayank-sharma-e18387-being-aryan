import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter PIN: ");
            int enteredPIN = Integer.parseInt(scanner.nextLine());
            if (enteredPIN != CORRECT_PIN) {
                throw new InvalidPINException("Error: Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }
            
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}
