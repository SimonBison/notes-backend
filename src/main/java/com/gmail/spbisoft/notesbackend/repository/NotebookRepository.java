package com.gmail.spbisoft.notesbackend.repository;


import com.gmail.spbisoft.notesbackend.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, UUID> {
}
