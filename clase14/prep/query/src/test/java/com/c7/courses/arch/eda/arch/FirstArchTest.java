package com.c7.courses.arch.eda.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.jupiter.api.Test;

public class FirstArchTest {

    @Test
    public void some_architecture_rule() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.c7");

        ArchRule rule = SlicesRuleDefinition.slices()
            .matching("com.c7.(*)..")
            .should().beFreeOfCycles();

        rule.check(classes);
    }

    @Test
    public void domain_should_not_depend_on_infrastructure() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.c7");

        ArchRule rule = ArchRuleDefinition.noClasses()
            .should().dependOnClassesThat()
            .resideInAPackage("..infrastructure..");

        rule.check(classes);
    }

}
