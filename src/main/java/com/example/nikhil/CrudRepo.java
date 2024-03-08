package com.example.nikhil;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepo<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    @Query(nativeQuery = true, value = "select * from company where name=:name")
    Optional<T> findByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "INSERT INTO staff (id, subject, name, day)values ")
    void CreateFac(Faculty fac);

    @Query(nativeQuery = true, value = "SELECT * from staff where id=:id")
    abstract Optional<Faculty> getParticularFacultyDetails(int id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAllById(Iterable<? extends ID> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();
}
