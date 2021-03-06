package org.matheclipse.core.builtin.functions;

import org.hipparchus.complex.Complex;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.builtin.NumberTheory;
import org.matheclipse.core.eval.exception.ArgumentTypeException;

public class ZetaJS {
	private ZetaJS() {
	}

	public static Complex summation(java.util.function.Function<Complex, Complex> f, double a, double b) {

		Complex s = Complex.ZERO;

		for (double i = a; i <= b; i++) {
			s = s.add(f.apply(new Complex(i)));
		}

		return s;

	}

	public static Complex complexSummation(java.util.function.DoubleFunction<Complex> f, double a, double b) {
		Complex s = Complex.ZERO;

		for (double i = a; i <= b; i++) {
			s = s.add(f.apply(i));
		}
		return s;
	}

	public static double sumDouble(java.util.function.DoubleUnaryOperator f, double a, double b) {
		double s = 0.0;

		for (double i = a; i <= b; i++) {
			s += f.applyAsDouble(i);
		}
		return s;
	}

	public static double sumInt(java.util.function.IntToDoubleFunction f, int a, int b) {
		double s = 0;

		for (int i = a; i <= b; i++) {
			s += f.applyAsDouble(i);
		}
		return s;
	}

	// public static Complex zeta(Complex x ) {
	//
	// // Borwein algorithm
	//
	// int n = 14; // from error bound for tolerance
	//
	// if ( x.getImaginary() != 0.0 ) {//isComplex(x) &&
	// n = Math.max( n, Math.ceil( log( 2.0 / GammaJS.gamma(x),abs( ) / tolerance ) / log( 3.0 + Math.Sqrt(8.0) ) ) );
	// }
	// int[] d = new int[] { 1 };
	// for ( int i = 1 ; i <= n ; i++ ) {
	// // order of multiplication reduces overflow, but factorial overflows at 171
	// d.push( d[i-1] + n * factorial( n+i-1 ) / factorial( n-i ) / factorial( 2*i ) * 4**i );
	// }
	// if ( x.getImaginary() != 0.0 ) {//isComplex(x)
	//
	// // functional equation dlmf.nist.gov/25.4.2
	// if ( x.re < 0 ) {
	// return mul( pow(2,x), pow(pi,sub(x,1)), sin( mul(pi/2,x) ), GammaJS.gamma( sub(1,x) ), zeta( sub(1,x) ) );
	// }
	// Complex s = summation( k => div( (-1)**k * ( d[k] - d[n] ), pow( k+1, x ) ), [0,n-1] );
	//
	// return div( div( s, -d[n] ), sub( 1, pow( 2, sub(1,x) ) ) );
	//
	// } else {
	//
	// // functional equation dlmf.nist.gov/25.4.2
	// if ( x < 0 ) {
	// return 2**x * pi**(x-1) * sin(pi*x/2) * GammaJS.gamma(1-x) * zeta(1-x);
	// }
	//
	// Complex s = summation( k => (-1)**k * ( d[k] - d[n] ) / (k+1)**x, [0,n-1] );
	//
	// return -s / d[n] / ( 1 - 2**(1-x) );
	//
	// }
	//
	// }

	// public static Complex dirichletEta(Complex x ) {
	// return mul( zeta(x), sub( 1, pow( 2, sub(1,x) ) ) );
	// }

	public static double bernoulliInt(int n) {
		return NumberTheory.bernoulliDouble(n);
	}

	// public static Complex harmonic(int n ) {
	//
	// if ( !Number.isInteger(n) ) throw Error( 'Noninteger argument for harmonic number' );
	//
	// return summation( i => 1/i, [1,n] );
	//
	// }

	public static double hurwitzZeta(final double x, final double a) {

		// Johansson arxiv.org/abs/1309.2877

		// if ( isComplex(x) || isComplex(a) ) {
		//
		//
		// } else {

		if (x == 1.0) {
			throw new ArgumentTypeException("Hurwitz zeta pole");
		}
		if (a < 0.0) {
			throw new ArgumentTypeException("Hurwitz zeta a < 0.0 ");
		}

		// dlmf.nist.gov/25.11.4

		if (a > 1.0) {
			double m = Math.floor(a);
			final double aValue = a - m;
			return hurwitzZeta(x, aValue) - sumDouble(i -> 1.0 / Math.pow(aValue + i, x), 0, m - 1);
		}

		// if ( a < 0.0 ) {
		// return hurwitzZeta( x, complex(a) );
		// }

		// Euler-Maclaurin has differences of large values in left-hand plane
		// swith to difference summation: dlmf.nist.gov/25.11.9

		double switchForms = -5.0;

		if (x < switchForms) {

			// x = 1 - x;
			final double xValue = 1 - x;
			double t = Math.cos(Math.PI * xValue / 2.0 - 2.0 * Math.PI * a);
			double s = t;
			int i = 1;

			while (Math.abs(t) > Config.SPECIAL_FUNCTIONS_TOLERANCE) {
				i++;
				t = Math.cos(Math.PI * xValue / 2.0 - 2.0 * i * Math.PI * a) / Math.pow(i, xValue);
				s += t;
			}

			return 2.0 * GammaJS.gamma(xValue) / Math.pow(2.0 * Math.PI, xValue) * s;

		}

		// Johansson arxiv.org/abs/1309.2877
		final int n = 15; // recommendation of Vepstas, Efficient Algorithm, p.12
		final int m = 5; // series is asymptotic, could check size of terms

		double S = sumDouble(i -> 1.0 / Math.pow(a + i, x), 0, n - 1);

		double I = Math.pow(a + n, 1.0 - x) / (x - 1.0);

		double T = sumInt(i -> bernoulliInt(2 * i) / GammaJS.factorialInt(2.0 * i) * GammaJS.gamma(x + 2.0 * i - 1.0)
				/ Math.pow(a + n, 2.0 * i - 1.0), 1, m);
		T = (0.5 + T / GammaJS.gamma(x)) / Math.pow(a + n, x);

		return S + I + T;

	}
}
