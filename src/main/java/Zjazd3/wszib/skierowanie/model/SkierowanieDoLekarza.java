package Zjazd3.wszib.skierowanie.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "Skierowania")
public class SkierowanieDoLekarza {

    @Id
    @GeneratedValue
    @Column
    int id;

    @Column(nullable = false)
    String lekarz;

    @Column(nullable = false)
    String pacjent;

    Date termin;

    public SkierowanieDoLekarza() {
    }

    public SkierowanieDoLekarza(int id, String lekarz, String pacjent, Date termin) {
        this.id = id;
        this.lekarz = lekarz;
        this.pacjent = pacjent;
        this.termin = termin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLekarz() {
        return lekarz;
    }

    public void setLekarz(String lekarz) {
        this.lekarz = lekarz;
    }

    public String getPacjent() {
        return pacjent;
    }

    public void setPacjent(String pacjent) {
        this.pacjent = pacjent;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }
}
