package com.example.stock_system.ranking;

import com.example.stock_system.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {
    @Query("SELECT r FROM Ranking r WHERE r.seedMoney >= :minSeedMoney AND r.seedMoney <= :maxSeedMoney ORDER BY r.evluPflsRt DESC")
    Optional<List<Ranking>> findBySeedMoneyAndOrderByEvluPflsRt(@Param("minSeedMoney")int minSeedMoney,@Param("maxSeedMoney") int maxSeedMoney);

    Optional<List<Ranking>> findByAccountIn(List<Account> accounts);
}
