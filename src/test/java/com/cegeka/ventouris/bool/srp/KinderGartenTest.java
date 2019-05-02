package com.cegeka.ventouris.bool.srp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KinderGartenTest {

    @ParameterizedTest
    @CsvSource({"0,0", "10,10"})
    void kinderGarten_reportsNumberOfKidsToParents(int numberOfChildren, String expectedReport) {
        KinderGarten kinderGarten = new KinderGarten(numberOfChildren, 0);

        String actualReport = kinderGarten.reportToParents();

        assertEquals(expectedReport, actualReport);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0:0", "10,2,10:2", "10,10,10:10"})
    void kinderGarten_reportsNumberOfKidsAndCaregiversToOwner(int numberOfChildren, int numberOfCaregivers, String expectedReport) {
        KinderGarten kinderGarten = new KinderGarten(numberOfChildren, numberOfCaregivers);

        String actualReport = kinderGarten.reportToOwner();

        assertEquals(expectedReport, actualReport);
    }

    @ParameterizedTest()
    @CsvSource({"0,0,false", "1,1,false", "6,1,false", "7,1,true", "7,2,false", "600,99,true", "600,100,false", "607,100,true"})
    void kinderGarten_reportToAuditorIfNotEnoughCaregivers(int numberOfChildren, int numberOfCaregivers, String expectedReport) {
        KinderGarten kinderGarten = new KinderGarten(numberOfChildren, numberOfCaregivers);

        String actualReport = kinderGarten.reportToAuditor();

        assertEquals(expectedReport, actualReport);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "10,10"})
    void kinderGarten_canSaveAndLoad(int numberOfChildren, int numberOfCaregivers) {
        KinderGarten kinderGarten = new KinderGarten(numberOfChildren, numberOfCaregivers);

        String serialized = kinderGarten.save();
        KinderGarten actualLoaded = KinderGarten.load(serialized);

        assertEquals(kinderGarten, actualLoaded);
    }
}
