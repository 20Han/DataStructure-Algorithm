import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        return (int) getHashSet(numbers).stream().filter(str -> !str.startsWith("0")&&isPrimeNumber(Integer.parseInt(str))).count();
    }
    
    public HashSet<String> getHashSet(String str) {
        HashSet<String> hashSet = new HashSet<>();

        if(str == null)
            return  hashSet;

        if(str.length() == 1) {
            hashSet.add(str);
            return hashSet;
        }

        for(int i = 0; i<str.length(); i++){
            char charAtI = str.charAt(i);
            getHashSet(new StringBuilder(str).deleteCharAt(i).toString()).forEach(_str -> {
                hashSet.add(charAtI + _str);
                hashSet.add(_str);
            });
        }

        return hashSet;
    }

    public Boolean isPrimeNumber(int n) {
        if(n==1 || n==0)
            return false;

        for(int i = 2; i <= n/2; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
