public static Integer decode(String nm) throws NumberFormatException {
    int radix = 10;
    int index = 0;
    boolean negative = false;
    int result;

    if (nm.isEmpty()){
        throw new NumberFormatException("Zero length string");
    }

    char firstChar = nm.charAt(0);

    if (firstChar == '-') {
        negative = true;
        index++;
    } else if (firstChar == '+') {
        index++;
    }

    if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
        index += 2;
        radix = 16;
    } else if (nm.startsWith("#", index)) {
        index++;
        radix = 16;
    } else if (nm.startsWith("0", index) && nm.length() > 1 + index) {
        index++;
        radix = 8;
    }

    if (nm.startsWith("-", index) || nm.startsWith("+", index)){

        throw new NumberFormatException("Sign character in wrong position");
    }


    try {

        result = Integer.parseInt(nm, index, nm.length(), radix);
        result = negative ? -result : result;

    } catch (NumberFormatException e) {

        String constant = negative ? Integer.toString(Integer.MIN_VALUE) : Integer.toString(-Integer.MAX_VALUE);

        result = Integer.parseInt(constant, radix);

        if (result != Integer.MIN_VALUE){
            throw e;
        }
    }

    return Integer.valueOf(result);
}

void main() {

}
