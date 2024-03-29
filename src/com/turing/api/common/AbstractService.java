package com.turing.api.common;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save (T t) throws SQLException;
    public abstract List<T> findAll() throws SQLException;
    public abstract Optional<T> findById(Long id);
    public abstract String count();
    public abstract Optional<T> getOne(String id) throws SQLException;
    public abstract Messenger delete (T t);
    public abstract Boolean existsById(Long id);

}
