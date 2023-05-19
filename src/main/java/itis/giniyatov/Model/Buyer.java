package itis.giniyatov.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


    @NoArgsConstructor
    @Data
    @Entity
    public class Buyer {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private String name;
        public Buyer(String name){
            this.name=name;
        }
        @ManyToMany(cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
        @JoinTable(name = "buyer_car",
                joinColumns = @JoinColumn(name = "buyer_id"),
                inverseJoinColumns = @JoinColumn(name = "car_id")
        )
        private List<Cars> cars =new ArrayList<>();

        public void addBook(Cars cars){
            this.cars.add(cars);
            cars.getBuyers().add(this);
        }

        public void removeBook(Cars cars){
            this.cars.remove(cars);
            cars.getBuyers().remove(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (!(o instanceof Buyer)) return false;

            return id != null && id.equals(((Buyer) o).getId());
        }

        @Override
        public int hashCode() {
            return 31;
        }
    }

