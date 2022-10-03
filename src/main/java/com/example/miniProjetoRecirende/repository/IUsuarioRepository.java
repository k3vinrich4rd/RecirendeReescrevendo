package com.example.miniProjetoRecirende.repository;

import com.example.miniProjetoRecirende.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    //Validações(Query method)
    public boolean existsByCpfDoUsuario(String cpfDoUsuario);

    public boolean existsByEmailDoUsuario(String emailDoUsuario);

    public boolean existsByTelefoneDoUsuario(String telefoneDoUsuario);

}
