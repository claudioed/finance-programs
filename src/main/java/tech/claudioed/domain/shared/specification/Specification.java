package tech.claudioed.domain.shared.specification;

public interface Specification<T> {
  public boolean isSatisfiedBy(T t);

}
