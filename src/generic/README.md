
##### Collections的排序


    public static <T extends Comparable<? super T>> void sort(List<T> list) {
             list.sort(null);
         }
         
    T extends Comparable：标识T 必须是Comparable类型  【定了上限】
    <? super T> ：代表该类型必须是T 或者 T的父类。
    
    
如果想对ArrayList<Song>进行排序的话；有两种方案。

1. 需要【被排序类】实现Comparable 接口。 【根据歌名进行排序】


    public class Song implements Comparable {
        @Override
            public int compareTo(Object song) {
        
                Song s = (Song) song;
        
                // return title.compareTo(s.title);  升序； 小的去比大的。小的在做，大的在右。
                return s.title.compareTo(title); 降序
        
            }
    } 
    

2. 通过调用sort(List o, Comparator c) 比较

这个比较的方便，根据多种情况排序list。

需要自定义比较类，该类实现Comparator接口。

    // 根据Author 升序排序 
    static class ArtistCompare implements Comparator<Song> {
    
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }
    
    // 根据id降序排序、
    static class IdCompare implements Comparator<Song> {
    
        @Override
        public int compare(Song o1, Song o2) {
            return o2.getId().compareTo(o1.getId());
        }
    }
    
    

关于升序降序记忆点： 在 o1.CompareTo(o2); 和方法定义参数顺序一眼，升序。
    
          
             
             