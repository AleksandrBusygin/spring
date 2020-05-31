package com.busygin.springapplication.service;

import com.busygin.springapplication.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    /**
     * Возвращает список всех имеющихся пользователей
     *
     * @return список пользователей
     */
    public List<User> getUsers();

    /**
     * Возвращает пользователя по его id
     *
     * @param id пользователя
     * @return объект клиента с данным id
     */
    public Optional<User> get(final Integer id);

    /**
     * Создает нового пользователя
     *
     * @param user пользователь
     * @return объект пользователя с присвоенным id
     */
    public User add(final User user);

    /**
     * Удаляет пользователя по его id
     *
     * @param id пользователя
     * @return true если пользователь найден и удален, иначе - false
     */
    public boolean delete(final Integer id);

    /**
     * Обновляет пользователя с заданным id,
     * в соответствии с переданным пользователем
     *
     * @param user - пользователь с данными на обновление
     * @param id - id пользователя, которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    public boolean edit(final Integer id, final User user);
}
