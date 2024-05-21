package com.fdr.jo_project.dto;

import com.fdr.jo_project.entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long idUser;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String tokenUser;
    private boolean isAdmin;
    private List<Ticket> tickets;
}
