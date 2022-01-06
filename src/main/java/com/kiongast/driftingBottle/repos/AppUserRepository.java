package com.kiongast.driftingBottle.repos;

import com.kiongast.driftingBottle.models.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    @Override
    <S extends AppUser> S save(S entity);

    @Override
    <S extends AppUser> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<AppUser> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<AppUser> findAll();

    @Override
    Iterable<AppUser> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(AppUser entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends AppUser> entities);

    @Override
    void deleteAll();

}
