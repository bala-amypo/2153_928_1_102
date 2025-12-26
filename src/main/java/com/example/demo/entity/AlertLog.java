import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime alertTime;

    @ManyToOne
    private Warranty warranty;

    public void prePersist() {
        this.alertTime = LocalDateTime.now();
    }
}
