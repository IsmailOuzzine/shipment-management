package admin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identityNumber;
    private String name;
    private String email;
    private String phone;

    @ManyToMany
    private List<Role> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    private Agency agency;
}
