package sn.faty.Formation_Spring.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private  Long id ;
       private String name;
        private  String url ;

    public FileDB(String name,String url ) {
        this.name = name;
        this.url = url;
    }
}
