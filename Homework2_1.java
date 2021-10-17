class Homework2_1 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String domain : cpdomains){
            //由于每一个完整的网站域名的访问次数和网站域名是用空格隔开的，所以先将两者分开并用新数组装填
            String[] countNAddress = domain.split("\\s+");
            //索引为0的就是访问次数
            int count = Integer.valueOf(countNAddress[0]);
            //索引为1的就是网站域名，然后由于每个子域名都是用“.”隔开的所以再将它们分开并用新数组装填
            String[] address = countNAddress[1].split("\\.");
            //从最后面的顶级域名开始往前遍历，每次更新完子域名的访问次数后就与前面的子域名做连接，
            //所以提前准备好一个变量名为str
            String str = "";
            for(int i = address.length - 1; i >= 0; i--){
                //中间的(i < address.length - 1 ? "." : "")判断是否是最后面的顶级域名，再往后遍历就用不到了
                str = address[i] + (i < address.length - 1 ? "." : "") + str;
                if(!map.containsKey(str)){
                    map.put(str, count);//第一次出现的子域名的话就直接存入容器中
                }else{
                    map.put(str, map.get(str) + count);//之前出现过的子域名就只需更新下访问次数
                }
            }
        }
        //遍历添加结果到提前准备好的ans容器里
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String element = entry.getValue() + " " + entry.getKey();
            ans.add(element);
        }
        return ans;
    }
}