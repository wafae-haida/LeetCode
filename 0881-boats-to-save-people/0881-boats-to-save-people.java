class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int heavest = people.length - 1;
        int lightest = 0;
        int rs = 0;
        while(lightest <= heavest){
            rs++;
            if(people[lightest] + people[heavest] <= limit)
                lightest++;
            heavest--;
        }
        return rs;
    }
}