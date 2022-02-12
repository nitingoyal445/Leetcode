class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        
        Set<String> endSet = new HashSet<>(); // optimization -> for bidirectional BFS
        endSet.add(endWord);
        
        Set<String> wordSet = new HashSet<>(wordList);
        
        return bfs(beginSet, endSet, wordSet, 1);
        // return bfs(beginSet, endWord, wordSet, 1);
        
    }
    
    // public int bfs(Set<String> beginSet, String endWord, Set<String> wordSet, int distance){
    public int bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int distance){
        
        if(beginSet.size()>endSet.size()){
            return bfs(endSet,beginSet,wordSet,distance);
        }
        
        Set<String> reachableSet = new HashSet<>();
        wordSet.removeAll(beginSet);
        
        for(String word : beginSet){
            for(int pos=0; pos<word.length(); pos++){
                char[] charArray = word.toCharArray();
                for(char c='a';c<='z';c++){
                    charArray[pos] = c;
                    String newWord = new String(charArray);
                    if(wordSet.contains(newWord)){
                        // if(newWord.equals(endWord)){
                        if(endSet.contains(newWord)){
                            return distance+1;
                        }
                        
                        reachableSet.add(newWord);
                    }
                }
            }
        }
        distance++;
        if(reachableSet.isEmpty()){
            return 0;
        }
        return bfs(reachableSet, endSet, wordSet, distance);
        // return bfs(reachableSet, endWord, wordSet, distance);
    }
    
}