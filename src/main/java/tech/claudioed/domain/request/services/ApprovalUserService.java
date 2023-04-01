package tech.claudioed.domain.request.services;

import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.request.repositories.ApprovalUserRepository;

@ApplicationScoped
public class ApprovalUserService {

  private final ApprovalUserRepository approvalUserRepository;

  public ApprovalUserService(ApprovalUserRepository approvalUserRepository) {
    this.approvalUserRepository = approvalUserRepository;
  }




}
