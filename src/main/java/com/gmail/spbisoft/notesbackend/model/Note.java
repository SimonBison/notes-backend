package com.gmail.spbisoft.notesbackend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Note {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notebook notebook;

    private Date lastModifiedOn;

    protected Note() {
        this.id = UUID.randomUUID();
        this.lastModifiedOn = new Date();
    }

    public Note(String title, String text, Notebook notebook) {
        this();
        this.title = title;
        this.text = text;
        this.notebook = notebook;
    }

    public Note(String id, String title, String text, Notebook notebook) {
        this(title, text, notebook);
        if (id != null) {
            this.id = UUID.fromString(id);
        }
    }


    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public String getNotebookId() {
        return this.notebook.getId().toString();
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}