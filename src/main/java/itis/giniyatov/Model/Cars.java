package itis.giniyatov.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "cars")
    private Set<Buyer> buyers =new HashSet<>();

    public Cars(String name){
        this.name=name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Buyer)) return false;

        return id != null && id.equals(((Cars) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
