class Solution {
    public int[] solution(String s) {
        int conversionCount = 0; // 변환 횟수
        int zeroCount = 0;       // 제거된 '0'의 총 개수

        while (!s.equals("1")) {
            // 1. 현재 문자열에서 '0' 제거
            int currentZeroCount = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    currentZeroCount++;
                }
            }
            zeroCount += currentZeroCount;

            // 2. '1'만 남긴 길이 계산
            int lengthAfterRemoval = s.length() - currentZeroCount;

            // 3. 길이를 이진 변환
            s = Integer.toBinaryString(lengthAfterRemoval);

            // 4. 변환 횟수 증가
            conversionCount++;
        }

        return new int[]{conversionCount, zeroCount};
    }
}