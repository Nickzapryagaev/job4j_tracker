package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает бизнес-логику работы банковской системы
 *
 * @author Nikolay Zapryagaev
 * @version 1.0
 */

public class BankService {
    /**
     * Коллекция типа HashMap для хранения юзеров
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в коллекцию нового юзера
     *
     * @param user - юзер, который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет юзера из коллекции
     *
     * @param passport - паспорт юзера, которого мы хотим удалить
     * @return при успешном удалении юзера возвращаем TRUE
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, null)) != null;

    }

    /**
     * Метод добавляет новый аккаунт юзеру
     * Для добавления аккаунта юзер должен существовать в коллекции
     * Если аккаунт уже существует, то метод закончит работу
     *
     * @param passport - паспорт юзера, которому мы добавляем аккаунт
     * @param account  - новый аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск юзера по паспорту
     *
     * @param passport - паспорт юзера, которого мы ищем
     * @return - возвращает юзера
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User value : users.keySet()) {
            if (value.getPassport().equals(passport)) {
                user = value;
                break;
            }
        }
        return user;
    }

    /**
     * Поиск аккаунта по реквизитам
     *
     * @param passport  - паспорт юзера, чей аккаунт мы ищем
     * @param requisite - реквизиты аккаунта
     * @return - возвращает аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account value : accounts) {
                if (value.getRequisite().equals(requisite)) {
                    account = value;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод осуществляет перевод средств между счетами юзеров
     *
     * @param srcPassport   - паспорт отправителя
     * @param srcRequisite  - реквизиты счета отправителя
     * @param destPassport  - паспорт получателя
     * @param destRequisite - реквизиты счета получателя
     * @param amount        - сумма перевода
     * @return - при успешном переводе возвращаем TRUE
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает коллекцию счетов юзера
     *
     * @param user - юзер, чьи счета мы возвращаем
     * @return возвращаем счета юзера
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}