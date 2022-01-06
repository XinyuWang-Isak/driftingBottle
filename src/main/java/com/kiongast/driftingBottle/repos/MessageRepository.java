package com.kiongast.driftingBottle.repos;

import com.kiongast.driftingBottle.models.AppUser;
import com.kiongast.driftingBottle.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Override
    <S extends Message> S save(S entity);

    @Override
    <S extends Message> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Message> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Message> findAll();

    @Override
    Iterable<Message> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Message entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Message> entities);

    @Override
    void deleteAll();

    List<Message> findFirst10BySender(AppUser appUser);
}
