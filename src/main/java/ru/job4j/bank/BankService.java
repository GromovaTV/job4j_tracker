package ru.job4j.bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы
 * @author TATIANA GROMOVA
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами:
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему.
     * По умолчанию к пользователю добавляется пустой список счетов.
     * @param user пользователь, которого нужно добавить.
     */
    public void addUser(User user) {
        List<Account> value = new ArrayList<Account>();
        users.putIfAbsent(user, value);
    }

    /**
     *  Метод принимает на вход номер паспорта и номер счета, который нужно
     *  добавить.
     * @param passport используется для поиска пользователя, которому нужно
     * добавить новый счет.
     * @param account после проверки, что у пользователя еще нет счета с
     * таким номером, добавлятся новый счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя.
     * @return возвращает пользователя или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает номер паспорта и реквизиты счета и находит по ним счет.
     * @param passport номер паспорта пользователя.
     * @param requisite реквизиты счета.
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номера паспортов, реквизиты счетов, сумму перевода и переводит
     * деньги с одного счета на другой.
     * @param srcPassport номер паспотра пользователя, который переводит деньги.
     * @param srcRequisite реквизиты счета, с которого списывают сумму.
     * @param destPassport номер паспотра пользователя, который получает деньги.
     * @param destRequisite реквизиты целевого счета.
     * @param amount сумма перевода.
     * @return возвращает true, если перевод выполнен или null, если не найден счет отправителя
     * или получателя или на счете отправителя недостаточно средств.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
        return rsl;
    }
}