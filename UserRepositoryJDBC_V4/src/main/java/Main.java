import entities.User;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:database.db")) {
            UserRepository repo = new UserRepository(con);
            Scanner reader = new Scanner(System.in);

            while (true) {
                System.out.println("1. Novo");
                System.out.println("2. Listar");
                System.out.println("3. Sair");
                System.out.print("> ");
                int opt = reader.nextInt();
                reader.nextLine();

                if (opt == 1) {
                    System.out.print("Nome: ");
                    String name = reader.nextLine();
                    System.out.print("Email: ");
                    String email = reader.nextLine();
                    System.out.print("Senha: ");
                    String password = reader.nextLine();
                    repo.save(new User(UUID.randomUUID(), name, email, password));
                } else if (opt == 2) {
                    List<User> all = repo.findAll();
                    for (User u : all) {
                        System.out.printf("UUID: %s - Nome: %s - Email: %s%n", u.getUuid(), u.getName(), u.getEmail());
                    }
                } else if (opt == 3) {
                    break;
                }
            }
        } catch (SQLException se) {
            System.err.println("Erro: " + se.getMessage());
        }
    }
}
