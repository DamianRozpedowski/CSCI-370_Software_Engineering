package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {

	private String string; 
	
	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return string;
	}

	@Override
	public void setString(String string) {
		// TODO Auto-generated method stub
		this.string = string;
	}

	@Override
	public int countNumbers() {
		// TODO Auto-generated method stub
		if(this.string == null)
			throw new NullPointerException();

		if(this.string.isEmpty())
			return 0;

		int counter = 0;
		boolean checker = false;

		for (char c : this.string.toCharArray()) {
			if (Character.isDigit(c)) {
				if (!checker) {
					checker = true;
					counter++;
				}
			} else {
				checker = false;
			}
		}
		return counter;
	}

	@Override
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		// TODO Auto-generated method stub
		if(n <= 0)
			throw new IllegalArgumentException();
		if(this.string == null && n > 0)
			throw new NullPointerException();

		if(this.string.isEmpty() || this.string.length() < n)
			return "";

		StringBuilder resultString = new StringBuilder();
		int length = this.string.length();

		if(!startFromEnd) {
			for (int i = n - 1; i < length; i += n) {
				resultString.append(this.string.charAt(i));
			}
		}
		else{
			for (int i = length - n; i >= 0; i -= n) {
				resultString.append(this.string.charAt(i));
			}
			resultString.reverse();
		}

		return resultString.toString();
	}

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		// TODO Auto-generated method stub
		if (startPosition > endPosition)
			throw new IllegalArgumentException();
		if (startPosition < 1 || startPosition > this.string.length() || endPosition <1 || endPosition > this.string.length())
			throw new MyIndexOutOfBoundsException();
		if (this.string == null)
			throw new NullPointerException();

		StringBuilder resultString = new StringBuilder();

		for (int i = 0; i < this.string.length(); i++) {
			char character = this.string.charAt(i);

			if (Character.isDigit(character) && i + 1 >= startPosition && i + 1 <= endPosition) {
				switch (character) {
					case '0':
						resultString.append("Zero");
						break;
					case '1':
						resultString.append("One");
						break;
					case '2':
						resultString.append("Two");
						break;
					case '3':
						resultString.append("Three");
						break;
					case '4':
						resultString.append("Four");
						break;
					case '5':
						resultString.append("Five");
						break;
					case '6':
						resultString.append("Six");
						break;
					case '7':
						resultString.append("Seven");
						break;
					case '8':
						resultString.append("Eight");
						break;
					case '9':
						resultString.append("Nine");
						break;
					default:
						resultString.append(character);
						break;
				}
			} else {
				resultString.append(character);
			}
		}
		this.string = resultString.toString();
	}

}
