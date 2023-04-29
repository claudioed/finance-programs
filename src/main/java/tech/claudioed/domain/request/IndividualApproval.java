package tech.claudioed.domain.request;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "approvals")
public class IndividualApproval {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  private String userId;

  private String email;

  private String notes;

  private LocalDateTime approvedAt;

  public IndividualApproval(){}

  public IndividualApproval(String userId, String email, String notes,LocalDateTime approvedAt) {
    this.userId = userId;
    this.email = email;
    this.notes = notes;
    this.approvedAt = approvedAt;
  }

  public UUID getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getEmail() {
    return email;
  }

  public String getNotes() {
    return notes;
  }

  public LocalDateTime getApprovedAt() {
    return approvedAt;
  }

}
