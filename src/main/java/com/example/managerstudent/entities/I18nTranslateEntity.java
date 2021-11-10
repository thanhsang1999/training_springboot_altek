package com.example.managerstudent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "i18n_translate")
@Getter
@Setter
public class I18nTranslateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_i18n")
    private Long idI18n;

    @Column
    private String locate;

    @Column
    private String text;

}
