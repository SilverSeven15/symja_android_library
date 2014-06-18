package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.<br />
 * See GIT repository at: <a href="https://bitbucket.org/axelclk/symjaunittests">https://bitbucket.org/axelclk/symjaunittests</a>.
 */
public interface CoshRules {
  final public static IAST RULES = List(
    ISet(Cosh(C0),
      C1),
    ISet(Cosh(Times(CC(0L,1L,1L,6L),Pi)),
      Times(C1D2,Sqrt(C3))),
    ISet(Cosh(Times(CC(0L,1L,1L,5L),Pi)),
      Times(C1D4,Plus(C1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,1L,4L),Pi)),
      Power(C2,CN1D2)),
    ISet(Cosh(Times(CC(0L,1L,1L,3L),Pi)),
      C1D2),
    ISet(Cosh(Times(CC(0L,1L,2L,5L),Pi)),
      Times(C1D4,Plus(CN1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,1L,2L),Pi)),
      C0),
    ISet(Cosh(Times(CC(0L,1L,3L,5L),Pi)),
      Times(CN1D4,Plus(CN1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,2L,3L),Pi)),
      CN1D2),
    ISet(Cosh(Times(CC(0L,1L,3L,4L),Pi)),
      Times(CN1,Power(C2,CN1D2))),
    ISet(Cosh(Times(CC(0L,1L,4L,5L),Pi)),
      Times(CN1D4,Plus(C1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,5L,6L),Pi)),
      Times(CN1D2,Sqrt(C3))),
    ISet(Cosh(Times(CI,Pi)),
      CN1),
    ISet(Cosh(Times(CC(0L,1L,7L,6L),Pi)),
      Times(CN1D2,Sqrt(C3))),
    ISet(Cosh(Times(CC(0L,1L,6L,5L),Pi)),
      Times(CN1D4,Plus(C1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,5L,4L),Pi)),
      Times(CN1,Power(C2,CN1D2))),
    ISet(Cosh(Times(CC(0L,1L,4L,3L),Pi)),
      CN1D2),
    ISet(Cosh(Times(CC(0L,1L,7L,5L),Pi)),
      Times(CN1D4,Plus(CN1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,8L,5L),Pi)),
      Times(C1D4,Plus(CN1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,5L,3L),Pi)),
      C1D2),
    ISet(Cosh(Times(CC(0L,1L,7L,4L),Pi)),
      Power(C2,CN1D2)),
    ISet(Cosh(Times(CC(0L,1L,9L,5L),Pi)),
      Times(C1D4,Plus(C1,Sqrt(C5)))),
    ISet(Cosh(Times(CC(0L,1L,11L,6L),Pi)),
      Times(C1D2,Sqrt(C3))),
    ISet(Cosh(Times(CC(0L,1L,2L,1L),Pi)),
      C1),
    ISet(Cosh(CInfinity),
      CInfinity),
    ISet(Cosh(CComplexInfinity),
      Indeterminate)
  );
}