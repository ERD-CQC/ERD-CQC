import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.EnumSet;

public class A {
  public static String [] strings1 = {"first","second"};  // Noncompliant [[sc=27;ec=35]] {{Make this member "protected".}}
  public static final Map<Severity, Map<Severity, Severity>> OWASP_RR_LIKELIHOOD_TO_IMPACT_SEVERITY_MATRIX = Map.of(
          Severity.LOW, Map.of(
                  Severity.LOW, Severity.INFO,
                  Severity.MEDIUM, Severity.LOW,
                  Severity.HIGH, Severity.MEDIUM,
                  Severity.UNASSIGNED, Severity.UNASSIGNED
          ),
          Severity.MEDIUM, Map.of(
                  Severity.LOW, Severity.LOW,
                  Severity.MEDIUM, Severity.MEDIUM,
                  Severity.HIGH, Severity.HIGH,
                  Severity.UNASSIGNED, Severity.UNASSIGNED
          ),
          Severity.HIGH, Map.of(
                  Severity.LOW, Severity.MEDIUM,
                  Severity.MEDIUM, Severity.HIGH,
                  Severity.HIGH, Severity.CRITICAL,
                  Severity.UNASSIGNED, Severity.UNASSIGNED
          ),
          Severity.UNASSIGNED, Map.of(
                  Severity.LOW, Severity.UNASSIGNED,
                  Severity.MEDIUM, Severity.UNASSIGNED,
                  Severity.HIGH, Severity.UNASSIGNED,
                  Severity.UNASSIGNED, Severity.UNASSIGNED
          )
  );
}
