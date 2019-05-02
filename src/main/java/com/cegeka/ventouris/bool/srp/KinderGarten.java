package com.cegeka.ventouris.bool.srp;

import java.util.Objects;

public class KinderGarten {
    private final int numberOfChildren;
    private int numberOfCaregivers;

    public KinderGarten(int numberOfChildren, int numberOfCaregivers) {
        this.numberOfChildren = numberOfChildren;
        this.numberOfCaregivers = numberOfCaregivers;
    }

    public String reportToParents() {
        return Integer.toString(numberOfChildren);
    }

    public String reportToOwner() {
        return String.join(":", reportToParents(), Integer.toString(numberOfCaregivers));
    }

    public String reportToAuditor() {
        return Boolean.toString(numberOfChildren > 0 && numberOfChildren / (double) numberOfCaregivers > 6);
    }

    public static KinderGarten load(String serialized) {
        String[] split = serialized.split(":");
        int nChildren = Integer.parseInt(split[0]);
        int nCaregivers = Integer.parseInt(split[1]);

        return new KinderGarten(nChildren, nCaregivers);
    }

    public String save() {
        return reportToOwner();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KinderGarten that = (KinderGarten) o;
        return numberOfChildren == that.numberOfChildren &&
                numberOfCaregivers == that.numberOfCaregivers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfChildren, numberOfCaregivers);
    }

    @Override
    public String toString() {
        return KinderGarten.class.getCanonicalName() + "[" + reportToOwner() + "]";
    }
}
