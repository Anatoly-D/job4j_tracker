package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found mine.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid mine");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", false),
                new User("Ivan Ivanov", false),
                new User("Sidor Sidorov", true)
        };
        try {
            User user = findUser(users, "Petr Artsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException invalidException) {
            System.out.println("The user is invalid.");
            invalidException.printStackTrace();
        } catch (UserNotFoundException notFoundException) {
            System.out.println("The user was not found");
            notFoundException.printStackTrace();
        }
    }
}
