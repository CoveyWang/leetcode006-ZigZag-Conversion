/**
 * Created by Covey on 2015/1/28.
 */
public class Solution {
    public String convert(String s, int nRows) {
        if (s.isEmpty()) {
            return "";
        }

        if (nRows == 1) {
            return s;
        }

        String result = "";
        int len = s.length();

        int unit = 2 * nRows - 2;
        int blockNumber;

        if (len % unit == 0) {
            blockNumber = len / unit;
        } else {
            blockNumber = len / unit + 1;
        }

        for (int block = 0; block < blockNumber; block++) {
            result = result + s.charAt(unit * block);
        }
        for (int shift = 1; shift < nRows - 1; shift++) {
            for (int block = 0; block < blockNumber; block++) {
                if (unit * block + shift < len) {
                    result = result + s.charAt(unit * block + shift);
                }
                if (unit * block + unit - shift < len) {
                    result = result + s.charAt(unit * block + unit - shift);
                }
            }
        }
        for (int block = 0; block < blockNumber; block++) {
            if (unit * block + nRows - 1 < len) {
                result = result + s.charAt(unit * block + nRows - 1);
            }
        }

        return result;
    }
}
