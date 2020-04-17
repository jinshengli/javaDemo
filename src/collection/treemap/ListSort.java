package collection.treemap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 排序：
 *
 * 两种就是分别通过 Comparable 和 Comparator 两者进行排序的方式，而 TreeMap 利用
 * 的也是此原理，从而实现了对 key 的排序，我们一起来看下。
 *
 *
 */

public class ListSort {

    public static void main(String[] args) {

        ArrayList<DTO> dtos = new ArrayList<>();
        dtos.add(new DTO(10));
        dtos.add(new DTO(2));
        dtos.add(new DTO(1));
        dtos.add(new DTO(8776));
        Collections.sort(dtos);

        System.out.println(dtos);

        Comparator<DTO> comparator = new Comparator<DTO>() {
            @Override
            public int compare(DTO o1, DTO o2) {
                return o2.getId() - o1.getId();  // 从达到小
            }
        };

        Collections.sort(dtos, comparator);

        System.out.println(dtos);

        Object[] objects = dtos.toArray();
        System.out.println(objects);

        DTO dto[] = new DTO[dtos.size()];


    }
}
