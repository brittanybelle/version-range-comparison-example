package com.example;

import org.eclipse.aether.util.version.GenericVersionScheme;
import org.eclipse.aether.version.InvalidVersionSpecificationException;
import org.eclipse.aether.version.Version;
import org.eclipse.aether.version.VersionConstraint;
import org.eclipse.aether.version.VersionScheme;

public class VersionRangeHandler
{
  public static void main(String [] args) throws InvalidVersionSpecificationException
  {
    VersionScheme scheme = new GenericVersionScheme();

    String sampleVersionRange = "(,1.3.0]";
    String complexVersionRangeList = "(,0.4.0],[1.1.0],[1.3.0],[5.6.7,)";

    Version versionInRange = scheme.parseVersion("1.1.0");
    Version versionNotInRange = scheme.parseVersion("4.0.0");

    VersionConstraint versionConstraint = scheme.parseVersionConstraint(sampleVersionRange);
    VersionConstraint complexVersionConstraint = scheme.parseVersionConstraint(complexVersionRangeList);

    System.out.println("versionConstraint.containsVersion(versionInRange) -> " + versionConstraint.containsVersion(versionInRange)); // true
    System.out.println("versionConstraint.containsVersion(versionNotInRange) -> " + versionConstraint.containsVersion(versionNotInRange)); // false

    System.out.println("complexVersionConstraint.containsVersion(versionInRange) -> " + complexVersionConstraint.containsVersion(versionInRange)); // true
    System.out.println("complexVersionConstraint.containsVersion(versionNotInRange) -> " + complexVersionConstraint.containsVersion(versionNotInRange)); // false
  }
}
