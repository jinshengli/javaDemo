

import java.util.*;

/**
 * List比较函数
 * 这里标注所在部门+姓名
 * @author qdy
 *
 */
public class ListCompare {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("苹果手机");
		list1.add("华为手机");
		list1.add("电脑");
//		list1.add("苹果");

		
		List<String> list2 = new ArrayList<String>();
		list2.add("苹果手机");
		list2.add("华为手机");
		list2.add("电脑");
		list2.add("苹果");
		list2.add("电视机");
		
		
//		boolean sure=find(list1,"苹果");
//        System.out.println("sure:"+sure);
        List<String> list = differenceList(list1, list2);
        System.out.println(list);

        List<String> list3 = equalList(list1, list2);
        System.out.println(list3);
    }
	
	
	public static boolean find(List<String> list,String str){
		//TODO 在这里实现:在list查找str是否存在，存在返回true,不存在返回false
		for (int i=0; i < list.size(); ++i )
		    if ( list.get(i).equals(str) )
		        return true;
		return false;
	}

	/**
	 * 返回集合差异部分
	 * 比较两个集合，把差异部分返回
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> differenceList(List<String> list1,List<String> list2 ){
		//TODO 在这里实现代码：返回两个集合差异部分

		if ( list1 == null )
			return list2;
		if (list2 == null )
			return list1;


		int maxLength = list1.size() > list2.size() ? list1.size() : list2.size();

        ArrayList<String> differentL = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>(maxLength);

        for ( String s: list1){
            map.put(s,1);
        }

        for (String s:list2){
            Integer cnt = map.get(s);
            if (cnt != null ){
                map.put(s, cnt+1); // 存在map中
            }else {
            	differentL.add(s);
            }
        }

        for (String s : map.keySet() ){
            if ( map.get(s) == 1 )
                differentL.add(s);
        }
        return differentL;
	}
	
	/**
	 * 返回集合相同部分
	 * 比较两个集合，返回相同部分
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> equalList(List<String> list1,List<String> list2 ){
		//TODO 在这里实现代码：返回两个集合返回相同部分

        ArrayList<String> ans = new ArrayList<String>();

        HashSet<String> set = new HashSet<String>(list1);

        for (String s:list2 ){
            if ( set.contains(s) ){
                ans.add(s);
            }
        }

        return ans;
	}
}
