package com.CursoPlatziFundamentos.SprontBoot.fundamentos.repository;

import com.CursoPlatziFundamentos.SprontBoot.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
