package com.example.miniProjetoRecirende.repository;

import com.example.miniProjetoRecirende.model.EmbalagemSalgadinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmbalagemSalgadinhoRepository extends JpaRepository<EmbalagemSalgadinhoModel, Long> {

    public boolean existsByNumeroDeSerieEmbalagem(String numeroDeSerieEmbalagem);
}
