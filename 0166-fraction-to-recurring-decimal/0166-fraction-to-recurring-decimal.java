
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        // Numerator is 0
        if (numerator == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        // Check negative answer
        if ((numerator < 0) != (denominator < 0)) {
            ans.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        ans.append(num / den);

        long remainder = num % den;

        // No decimal part
        if (remainder == 0) {
            return ans.toString();
        }

        ans.append(".");

        // remainder -> position in answer
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {

            // Same remainder means repeating starts here
            if (map.containsKey(remainder)) {

                int index = map.get(remainder);

                ans.insert(index, "(");
                ans.append(")");

                break;
            }

            map.put(remainder, ans.length());

            remainder *= 10;

            ans.append(remainder / den);

            remainder %= den;
        }

        return ans.toString();
    }
}

