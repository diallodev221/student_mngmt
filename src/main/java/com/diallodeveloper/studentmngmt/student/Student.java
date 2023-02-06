package com.diallodeveloper.studentmngmt.student;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
