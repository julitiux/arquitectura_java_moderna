package com.c7.curso.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class MyArchitectureTest {
    @Test
    public void some_architecture_rule() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.c7.curso.arch");
        // otra forma de "importar" clases
        // JavaClasses classes = new ClassFileImporter().importPath("/some/path");`

        ArchRule rule = classes()
                .that().resideInAPackage("..service..")
                .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

        rule.check(classes);
    }
}
