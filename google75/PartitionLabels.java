/*
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
*/

//We want to partition the string into as many parts as possible so that 'each letter appears in at most one part'.
class Solution {
    public List<Integer> partitionLabels(String s) {
        
        // store the limit of each character
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }
      
        List<Integer> result = new ArrayList<>();
        int prev =-1;
        int max = 0;
        // iterate string
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);

            // before reaching limit, if i find any max, replace
            max = Math.max(max,map.get(current));

            // i reached end
            if(max==i){
                result.add(max-prev);
                prev = max;
            }

        }
        return result;
    }
}
