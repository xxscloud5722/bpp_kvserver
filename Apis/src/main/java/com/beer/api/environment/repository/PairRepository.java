package com.beer.api.environment.repository;

import com.beer.api.environment.entity.Pair;
import com.billbear.common.datasource.CrudRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Locale;

@ApplicationScoped
public class PairRepository extends CrudRepository<Pair, Long> {

    public Pair getByKey(String key) {
        return this.find("WHERE key = ?1 ", key.toUpperCase(Locale.ROOT)).firstResult();
    }

    public List<Pair> getListByKey(String keyword) {
        return this.list("WHERE key LIKE CONCAT('%', ?1, '%') ", keyword.toUpperCase(Locale.ROOT)).stream().toList();
    }

    public boolean removeByKey(String key) {
        return this.delete("WHERE key = ?1 ", key.toUpperCase(Locale.ROOT)) > 0;
    }

    public List<Pair> getList() {
        return this.findAll(Sort.by("key")).stream().toList();
    }
}
