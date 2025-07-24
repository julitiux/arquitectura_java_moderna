package com.c7.curso.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;

@AnalyzeClasses(packages = "com.c7")
class ArchitectureLayeringTest {
    @ArchTest
    @SuppressWarnings("unused")
    private final ArchRule onionArchitecture = JMoleculesArchitectureRules.ensureOnionClassical();
}
