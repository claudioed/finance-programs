package arch;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "tech.claudioed")
public class HexagonalArchitectureRules {

  @ArchTest
  static final ArchRule layersRespected = layeredArchitecture().consideringAllDependencies()


      .layer("Domain").definedBy("tech.claudioed.domain..")
      .layer("Adapters").definedBy("tech.claudioed.adapter.http..")
      .layer("Repositories").definedBy("tech.claudioed.domain..repositories..")
      .layer("Services").definedBy("tech.claudioed.domain..services..")
      .layer("Ports").definedBy("tech.claudioed.port..")

      .whereLayer("Ports").mayOnlyBeAccessedByLayers("Adapters")
      .whereLayer("Adapters").mayNotBeAccessedByAnyLayer()
      .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services")
      .whereLayer("Services").mayOnlyBeAccessedByLayers("Adapters");

}
