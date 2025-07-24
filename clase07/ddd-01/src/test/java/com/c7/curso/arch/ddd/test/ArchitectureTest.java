package com.c7.curso.arch.ddd.test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Repository;
import org.jmolecules.ddd.annotation.Service;
import org.junit.jupiter.api.Test;

public class ArchitectureTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages("com.c7.curso.arch.ddd");

    @Test
    void onlyAggregatesShouldAccessRepositories() {
        ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Service.class)
                .should().accessClassesThat().areAnnotatedWith(Repository.class)
                .check(classes);
    }

    @Test
    void aggregatesShouldBeAnnotatedAsAggregateRoots() {
        ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Aggregate")
                .should().beAnnotatedWith(AggregateRoot.class)
                .allowEmptyShould(true)
                .check(classes);
    }
}
