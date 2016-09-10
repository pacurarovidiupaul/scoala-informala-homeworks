package scoalainformala.metricdistancecalculator;

public class MetricDistanceExpressionParser {

	private static final String MINUS = "-";
	private static final String PLUS = "\\+";

	public Distance[] parse(String expression) {
		int operandCount = countSubStringOccurrence(expression, PLUS) + countSubStringOccurrence(expression, MINUS) + 1;
		if (expression.startsWith("-")) {
			operandCount--;
		}

		Distance dist[] = new Distance[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("\t", "");
		while (expression.length() > 0) {
			int sign = 1;
			if (expression.startsWith(MINUS)) {
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")) {
				expression = expression.replaceFirst(PLUS, "");
			}

			int nextOpPos = nextOperatorPos(expression);
			String operator = null;
			if (nextOpPos == -1) {
				operator = expression;
			} else {
				operator = expression.substring(0, nextOpPos);
			}

			expression = expression.replaceFirst(operator, "");
			dist[index++] = convertToDistance(operator, sign);
		}

		return dist;

	}

	int nextOperatorPos(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if (plusPos == -1) {
			return minusPos;
		}
		if (minusPos == -1) {
			return plusPos;
		}
		return plusPos < minusPos ? plusPos : minusPos;
	}

	/*
	 * private int nextOperand(String expression) { int plusPos =
	 * expression.indexOf("+"); int minusPos = expression.indexOf("-"); if
	 * (plusPos == -1) { return minusPos; } if (minusPos == -1) { return
	 * plusPos; } return plusPos < minusPos ? plusPos : minusPos; }
	 */

	private Distance convertToDistance(String e, int sign) {
		if (e.endsWith(Distance.MILIMETERS)) {
			return convertToDistance(e, sign, Distance.MILIMETERS);
		} else if (e.endsWith(Distance.CENTIMETERS)) {
			return convertToDistance(e, sign, Distance.CENTIMETERS);
		} else if (e.endsWith(Distance.DECAMETERS)) {
			return convertToDistance(e, sign, Distance.DECAMETERS);
		} else if (e.endsWith(Distance.KILO_METERS)) {
			return convertToDistance(e, sign, Distance.KILO_METERS);
		} else if (e.endsWith(Distance.INCH)) {
			return convertToDistance(e, sign, Distance.INCH);
		} else if (e.endsWith(Distance.FOOT)) {
			return convertToDistance(e, sign, Distance.FOOT);
		} else if (e.endsWith(Distance.MILES)) {
			return convertToDistance(e, sign, Distance.MILES);
		} else {

			return convertToDistance(e, sign, Distance.METERS);
		}
	}

	private Distance convertToDistance(String e, int sign, String distanceFormat) {
		return new Distance(distanceFormat, sign * Double.parseDouble(e.replace(distanceFormat, "")));

	}

	private int countSubStringOccurrence(String total, String sub) {
		return total.length() - total.replaceAll(sub, "").length();
	}

}
