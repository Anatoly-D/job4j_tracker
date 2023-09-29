package early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    /**
     * Метод проверят пароль по правилам:
     *  1. Если password null, то выбросить исключение "Password can't be null";
     *  2. Длина пароля находится в диапазоне [8, 32],
     *     если нет то "Password should be length [8, 32]";
     *  3. Пароль содержит хотя бы один символ в верхнем регистре,
     *     если нет то "Password should contain at least one uppercase letter");
     *  4. Пароль содержит хотя бы один символ в нижнем регистре,
     *     если нет то "Password should contain at least one lowercase letter";
     *  5. Пароль содержит хотя бы одну цифру,
     *     если нет то"Password should contain at least one figure");
     *  6. Пароль содержит хотя бы один спец. символ (не цифра и не буква),
     *     если нет то "Password should contain at least one special symbol");
     *  7. Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user.
     *     Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п.
     *     если да, то "Password shouldn't contain substrings: qwerty, 12345, password, admin, user".
     * @param password Пароль
     * @return Вернет пароль или выбросит исключение.
     */
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasCorrectLength = false;
        boolean hasForbidden = false;
        int pwdLength = password.length();
        String pwdLowerCase = password.toLowerCase();

        if (pwdLength >= 8 && pwdLength <= 32) {
            hasCorrectLength = true;
        }

        for (char symbol : password.toCharArray()) {
            /* Блок проверки принадлежности символа к определенной группе - Character.is ... */
            if (Character.isUpperCase(symbol)) {
                hasUpCase = true;
            }
            if (Character.isLowerCase(symbol)) {
                hasLowCase = true;
            }
            if (Character.isDigit(symbol)) {
                hasDigit = true;
            }
            if (!Character.isLetter(symbol) && !Character.isDigit(symbol)) {
                hasSpecial = true;
            }
        }

        for (String string : FORBIDDEN) {
            if (pwdLowerCase.contains(string)) {
                hasForbidden = true;
                break;
            }
        }

        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (!hasCorrectLength) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (hasForbidden) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}