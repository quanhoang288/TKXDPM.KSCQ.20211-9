package ecobike.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PaymentTransaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    private String  id;
    private String errorCode;
    private String content;
    private String method;
    private int amount;
    @Column(name = "createAt")
    private Date createAt;
    @OneToOne
    @JoinColumn(name = "bikeRentalInfoID", referencedColumnName = "id")
    private BikeRentalInfo bikeRentalInfo;

    public PaymentTransaction(String errorCode, String transactionId, String transactionContent, int amount) {
        this.errorCode = errorCode;
        this.id = transactionId;
        this.content = transactionContent;
        this.amount = amount;
    }

    public PaymentTransaction() {

    }

    public String getErrorCode() {
        return errorCode;
    }
}
