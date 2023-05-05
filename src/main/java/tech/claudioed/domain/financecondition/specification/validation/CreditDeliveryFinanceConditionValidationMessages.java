package tech.claudioed.domain.financecondition.specification.validation;

public enum CreditDeliveryFinanceConditionValidationMessages {

  DOWN_PAYMENT_REQUIREMENTS("Down Payment requirements not reached."),

  AMOUNT_NOT_ALLOWED("Amount not allowed"),

  UTM_CODE_NOT_ALLOWED("UTM code not allowed"),

  DEALER_NOT_ALLOWED("Dealer not allowed"),

  CUSTOMER_NOT_ALLOWED("Customer not allowed"),

  PRODUCT_NOT_ALLOWED("Product not allowed"),

  PRODUCT_FAMILY_NOT_ALLOWED("Product family not allowed"),

  CULTURE_NOT_ALLOWED("Culture not allowed"),

  MARKET_SEGMENT_NOT_ALLOWED("Market segment not allowed"),

  LOAN_TIME_NOT_ALLOWED("Loan time not allowed");

  private final String message;

  CreditDeliveryFinanceConditionValidationMessages(String message) {
    this.message = message;
  }

  public String message() {
    return message;
  }

}
