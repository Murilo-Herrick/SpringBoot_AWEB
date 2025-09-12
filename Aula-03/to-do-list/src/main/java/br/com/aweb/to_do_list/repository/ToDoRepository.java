package br.com.aweb.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aweb.to_do_list.model.Todo;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Long> {

}
