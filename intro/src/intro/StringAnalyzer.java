package intro;

public class StringAnalyzer {

	public static void main(String[] args)
	{
		System.out.println(getPlateauLength("aaaaa"));
	}

	public static int getPlateauLength(String s)
	{ 
		if (s.isEmpty())
			return 0;
		int maxLen = 1;
		int currLen = 1;
		int sLength = s.length();
		char prevChar = s.charAt(0);
		char currChar;
		for(int i = 1; i < sLength; i++)
		{
			currChar = s.charAt(i);
			if (currChar == prevChar)
			{
				currLen++;
			}
			if (currChar != prevChar || i == sLength - 1)
			{
				if (maxLen < currLen)
				{
					maxLen = currLen;
				}
				prevChar = currChar;
				currLen = 1;
			}
		}
		return maxLen;
	}
}
