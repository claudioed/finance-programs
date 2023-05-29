package arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import tech.claudioed.domain.shared.event.DomainEvent;

@AnalyzeClasses(packages = "tech.claudioed")
public class NamingConventions {

  @ArchTest
  static ArchRule eventsImplementationAndPackageNaming =
      classes()
          .that().resideInAPackage("..events..")
          .should().implement(DomainEvent.class);


}
