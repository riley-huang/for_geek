class Homework2_1 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String domain : cpdomains){
            String[] countNAddress = domain.split("\\s+");
            int count = Integer.valueOf(countNAddress[0]);
            String[] address = countNAddress[1].split("\\.");
            String str = "";
            for(int i = address.length - 1; i >= 0; i--){
                str = address[i] + (i < address.length - 1 ? "." : "") + str;
                if(!map.containsKey(str)){
                    map.put(str, count);
                }else{
                    map.put(str, map.get(str) + count);
                }
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String element = entry.getValue() + " " + entry.getKey();
            ans.add(element);
        }
        return ans;
    }
}