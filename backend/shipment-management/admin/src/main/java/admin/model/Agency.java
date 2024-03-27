package admin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String city;
    private String country;

    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;
}
