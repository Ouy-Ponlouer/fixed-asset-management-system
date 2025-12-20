package ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "movement_types")
@Table(name="movement_types")
public class MovementType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false,unique = true)
    private String movementTypeEn;

    @Column(nullable = false,unique = true)
    private String movementTypeKh;

    private LocalDate createAt;
}
