package tech.claudioed.domain.request;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import tech.claudioed.port.inputs.request.FinanceConditionApprovalComment;

@Entity
@Table(name = "finance_condition_approvals")
public class FinanceConditionApprovals {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @ElementCollection
  private Set<UserId> requiredApprovers;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="id",column=@Column(name="proposal_id"))
  })
  private FinanceConditionProposalId proposalId;

  @OneToMany(fetch = FetchType.LAZY)
  private Set<IndividualApproval> approvals;


  public void addApproval(FinanceConditionApprovalComment comment ){
    this.approvals.add(new IndividualApproval(comment.getUserId(),comment.getEmail(),comment.getNotes(), LocalDateTime.now()));
  }


}
