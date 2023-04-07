package de.dhbw.caput.tinf21b1b6;

import java.util.Stack;

final class Parser {

	public static RegularExpression parse(String string) {
		// Stack Idee
		// wir lesen jedes zeichen ein und schmeißen das ihc den stack, wenns keins der
		// folgenden Zeichen, | conacat und * start dann ist des fine und bleibt in
		// stack
		// wenn dann ein | kommt, dann wird der stack geleert und die zeichen werden in
		// eine liste gepackt und dann wird des in der linkten ding da passt, und dann
		// geht man halt weiter durch und und such die nächste regex zeugs
		// und immer leeren wenn man was rausnimmt so
		Stack<RegularExpression> stack = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			// System.out.println(currentChar);

			if (currentChar == 'ε') {
				stack.push(new RegularExpression.EmptyWord());
			} else if (currentChar == '∅') {
				stack.push(new RegularExpression.EmptySet());
			} else if (currentChar == '*') {
				// RegularExpression base = stack.pop();
				// stack.push(new RegularExpression.KleeneStar(base));
			} else if (currentChar == '·') {
				// Concatenation

				// RegularExpression second = stack.pop();
				// RegularExpression first = stack.pop();
				// stack.push(new RegularExpression.Concatenation(first, second));
			} else if (currentChar == '|') {
				// Union

				// Schauen was oben auf dem stack ist wenn das ne schließende klapper ist dann
				// sind wir fertig ansonsten weiter den string zusammen baune
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty()) {
					String c = stack.pop().toString();
					if (c == "(") {
						break;
					}
					sb.append(c);
				}
				System.out.println(sb.toString());

				// Reverse the string since we popped characters in reverse order
				String result = sb.toString();

				// System.out.println("Union");
				// System.out.println(string.charAt(i - 1));
				// System.out.println(string.charAt(i + 1));
				// Hier muss man fixen wenn zb ne Capture Group kommt das dann
				// die Capture Group erst durch gegangen wird

				// RegularExpression second = stack.pop();
				// RegularExpression first = stack.pop();
				// stack.push(new RegularExpression.Union(first, second));
			} else {
				stack.push(new RegularExpression.Literal(currentChar));
				// System.out.println(new RegularExpression.Literal(currentChar));
			}
		}

		return stack.pop();
		// return new RegularExpression.EmptySet();
	}
}
