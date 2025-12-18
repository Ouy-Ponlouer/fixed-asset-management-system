package ouyponlouer.site.fixedassetmanagementsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 20)
    private String positionNameEn;

    @Column(nullable = false,unique = true,length = 20)
    private String positionNameKh;

    private LocalDate createAt;



}
