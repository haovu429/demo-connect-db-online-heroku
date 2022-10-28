package hcmute.edu.haovu.demo_template.entities;

import jakarta.persistence.*; //version hibernate > 6.
import lombok.*;


//import javax.persistence.*; for version hibernate < 6.

// lombok

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private long price;
    @Column(name = "size")
    private String size;
    @Column(name = "color")
    private String color;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
